package login;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AccountModelImpl implements AccountModel
{
  private ArrayList<Account> tempAccounts; // this plays the role of a database  it will be removed
  private ArrayList<Group> findingUnknownGroupsGroup; // same
  private ArrayList<Group> groupsForDm; // This will be replaced, this will store the groups that the account already manages but only for the DM
  private ArrayList<Group> tempGroups; //This will be replaced, this will store the groups that the account already knows but only for the Player

  private PropertyChangeSupport support;
  private Account usersAccount;                     // this is the users account, we will store the information about the user's account here.
                                                    // like names,groups etc.. so we don't need to constantly ask the db for information.
  private AccountsForTesting tests;             // this is for testing

  public AccountModelImpl()
  {
    support = new PropertyChangeSupport(this);
    tests = new AccountsForTesting();
    tempGroups = new ArrayList<>();
    groupsForDm= new ArrayList<>();
    tempAccounts = new ArrayList<>();
    findingUnknownGroupsGroup = new ArrayList<>();
    // for testing
    usersAccount = tests.getAcc();
    tempGroups = tests.getTempGroups();
    groupsForDm = tests.getGroupsForDm();
    tempAccounts = tests.getTempAccounts();
    findingUnknownGroupsGroup = tests.getFindingUnknownGroupsGroup();
  }

  public void removeAccount()
  {

   System.exit(1);//remove client  instead .
  }

  // DM creates a group with a given name , and a random ID, right now i am using just a RNG, but this might be changed cause it is inefficient
  //  added it to a newgroup, I add DM as myself, since I created the group, so I am the DM.
  // the newgroup is added to the groupsForDm which will appear in my DM grouplist.
  // I add it to the temporary findingUnkownGroupsGroup so it can be found by other players. This  replaces the database right now.
  // fire propchange to update the viewmodel and view with the new group,
  @Override public String createGroup(String name)
  {
    String temp = "Group cannot be created";
    DiceRoll roll = new DiceRoll();
    ArrayList<Integer> ids= new ArrayList<>();
    for(int i=0;i<findingUnknownGroupsGroup.size();i++)
    {ids.add(findingUnknownGroupsGroup.get(i).getId());}
    int id=0;
    do {
    id = roll.RollDice(1000000,2);}while((ids.contains(id)));
    Group newGroup = new Group(name,id);
    newGroup.addDM(usersAccount.getDM());
    groupsForDm.add(newGroup);
    System.out.println(id);
    findingUnknownGroupsGroup.add(newGroup);support.firePropertyChange("GroupCreatedByDm",null,newGroup);
    return temp="Group Created";

  }
  // returns the groups for the User depending on what mode is he in (player or DM)
  @Override public ArrayList<Group> getGroups()
  { if(usersAccount.getUser() instanceof Player)
  {return tempGroups;}
  else if(usersAccount.getUser() instanceof DM)
  { return groupsForDm;}

  else return null;
  }
  // players will use this method to search for a group by ID,
  //If it in his tempGroups that means he already discovered it, then the loop breaks;
  // Nextx loop checks the database for the group , and if he finds it but the DM has the same name as the DM of that group then loop breaks and error,
  //if no errors then next loop finds the group and adds it to the users grouplist and property change fire to update view/vm.
  @Override public String searchGroup(int id)
  {
    String temp = "This group doesn't exit";

    for (int i = 0; i < tempGroups.size(); i++)
    {
      if (tempGroups.get(i).getId() == id)
      {
        temp = "You already have this group in your group list";
        break;
      }
    }
    for(int i=0; i<findingUnknownGroupsGroup.size();i++)
    {
      if(findingUnknownGroupsGroup.get(i).getDM().getName().equals(usersAccount.getUsername()) &&
          findingUnknownGroupsGroup.get(i).getId()==id )
      {temp="This group was made by you as a DM.\n You can only see this group in the DM mode";break;}

    }
    if (temp.equals("This group doesn't exit"))
    {
      for (int i = 0; i < findingUnknownGroupsGroup.size(); i++)
      {
        if (findingUnknownGroupsGroup.get(i).getId() == id)
        {
          tempGroups.add(findingUnknownGroupsGroup.get(i));
          support.firePropertyChange("GroupAdded", null,
              findingUnknownGroupsGroup.get(i));
          temp = "Group added to your group list";
          break;
        }

      }
    }
    return temp;
  }


// Player joins a group by a loop going through all the groups that are in his group list, and joins the one
  // that has the same toString which the player clicked, next checks if the player is the part of the group or not
  // and whether the group contains the same username as the player, just to make sure there is absolutely no errors.
  //after that the player is added to a group , and fire prop change with 2 variables, oldgroup and the tempgroup.

  @Override public String joinGroupAsPlayer(String groupname)
  {
    String temp = "Error";
    for (int i = 0; i < tempGroups.size(); i++)
    {
      if (tempGroups.get(i).toString().equals(groupname) && !(tempGroups.get(i)
          .isPlayerPartOfGroup(usersAccount.getPlayer())) && (!tempGroups.get(i)
          .isContainsUsername(usersAccount.getUsername())))
      {
        String oldGroup = tempGroups.get(i).toString();
        tempGroups.get(i).addPlayer(usersAccount.getPlayer());
        temp = "You have been added to the group";
        support.firePropertyChange("PlayerAddedToGroup", oldGroup,
            tempGroups.get(i));
        break;
      }
      else
      {
        temp = "You are already part of that group";
      }
    }
    return temp;
  }

// this is for creating new accounts, its just checking with if statements if all the values are correct aetc..
  @Override public String checkAccountUniqueness(String username, String pass1,
      String pass2, String email)
  {
    String temp = "Error";

    if (username.equals("") || username == null)
    {
      temp = "Fill out all the fields";
    }
    else if (pass1.equals("") || pass1 == null)
    {
      temp = "Fill out all the fields";
    }
    else if (pass2.equals("") || pass2 == null)
    {
      temp = "Fill out all the fields";
    }
    else if (email.equals("") || email == null)
    {
      temp = "Fill out all the fields";
    }
    else if (!(pass1.equals(pass2)))
    {
      temp = "Passwords don't match";
    }
    else
      for (int i = 0; i < tempAccounts.size(); i++)
      {
        if ((tempAccounts.get(i).getUsername().equals(username))
            || (tempAccounts.get(i).getPassword().equals(pass1))
            || (tempAccounts.get(i).getEmail().equals(email)))
        {
          System.out.println(
              temp = "Error message: Account with this pass/email/name already exists");
          break;
        }
        else
        {
          temp = "Ready";
        }
      }
    if (temp.equals("Ready"))
    {
      tempAccounts.add(new Account(username, pass1, email));
      usersAccount = new Account(username, pass1, email);
    }

    return temp;
  }
// basic login with if statements checking pass and name.
  @Override public String checkLogin(String username, String pass)
  {
    String temp = "Error";
    if (username.equals("") || username == null)
    {
      temp = "Fill out all the fields";
    }
    else if (pass.equals("") || pass == null)
    {
      temp = "Fill out all the fields";
    }
    else
      for (int i = 0; i < tempAccounts.size(); i++)
      {
        if ((tempAccounts.get(i).getUsername().equals(username))
            && (tempAccounts.get(i).getPassword().equals(pass)))
        {
         temp = "Ready";
          usersAccount = tempAccounts.get(i);
          // usersAccount = add account from database
          break;
        }
        else
        {
          temp = "This account doesn't exit.";
        }
      }

    return temp;

  }
// checking the email for password recovery

  @Override public String checkEmail(String value)
  {
    String temp = "Error";
    if (value.equals("") || value == null)
    {
      temp = "Type in your email account,dude...";
    }
    else
      for (int i = 0; i < tempAccounts.size(); i++)
      {
        if (tempAccounts.get(i).getEmail().equals(value))
        {
         temp = "Ready";
         String pas = tempAccounts.get(i).getPassword();
         String nam = tempAccounts.get(i).getUsername();
          System.out.println("You got a new email: \n  For the account "+ nam + " your password is : "+ pas );
          break;
        }
        else
        {
          temp = "This email is not registered in our system.";
        }
      }

    return temp;
  }
// its for the account, when we decide to be DM or Player, its switching the User to that instance.
  @Override public void changeToDm()
  {
    usersAccount.setUserToDm();

  }

  @Override public void changeToPlayer()
  {
    usersAccount.setUserToPlayer();
  }

  // method for checking that everything is right for password change, field checks, I create an account variable which is null,
  // but it shouldn't be a problem , since its impossible to actually get null pointer exception, cause that variable will only be used if everything is right.
  @Override public String checkPasswordChangeInformation(String username,
      String passOld, String passNew, String passNewAgain)
  {
    String temp = "Error";
    Account change = null;


    if (username.equals("") || username == null)
    {
      temp = "Fill out all the fields";
    }
    else if (passOld.equals("") || passOld == null)
    {
      temp = "Fill out all the fields";
    }
    else if (passNew.equals("") || passNew == null)
    {
      temp = "Fill out all the fields";
    }
    else if (passNewAgain.equals("") || passNewAgain == null)
    {
      temp = "Fill out all the fields";
    }
    else if (!(passNewAgain.equals(passNew)))
    {
      temp = "Passwords don't match";
    }
    else if (!(usersAccount.getPassword().equals(passOld)))
    {
      temp = "Wrong old password";
    }
    else
      for (int i = 0; i < tempAccounts.size(); i++)
      {
        if (tempAccounts.get(i).getPassword().equals(passOld) && tempAccounts.get(i).getUsername().equals(username))
        {
         change = tempAccounts.get(i);

        }
        if ((tempAccounts.get(i).getPassword().equals(passNew)))
        {
          temp = "Error message: Password is weak, like you. lol. git gud.";    // actually its not weak, but I don't want to accounts have the same password.
          break;
        }
        else
        {
          temp = "Ready";
        }
      }
    if (temp.equals("Ready"))
    {
      tempAccounts.get(tempAccounts.indexOf(change)).changeEmail(passNew);

      usersAccount.setPassword(passNew);
    }

    return temp;
  }

  // the same as the method above, but with emailchange
  @Override public String checkEmailChangeInformation(String username,
      String password, String email)
  {
  Account change= null;
    String temp = "Error";

    if (username.equals("") || username == null)
    {
      temp = "Fill out all the fields";
    }
    else if (password.equals("") || password == null)
    {
      temp = "Fill out all the fields";
    }
    else if (email.equals("") || email == null)
    {
      temp = "Fill out all the fields";
    }
    else if ((email.equals(usersAccount.getEmail())))
    {
      temp = "This is your current email address. You nitwit...";
    }
    else if (!(usersAccount.getPassword().equals(password)) || !(usersAccount.getUsername().equals(username)))
    {
      temp = "Wrong  password or username";
    }
    else
      for (int i = 0; i < tempAccounts.size(); i++)
      {
        if (tempAccounts.get(i).getPassword().equals(password) && tempAccounts.get(i).getUsername().equals(username))
        {
          change = tempAccounts.get(i);

        }
        if ((tempAccounts.get(i).getEmail().equals(email)))
        {
          temp = "This email is already regisered.";
          break;
        }
        else
        {
          temp = "Ready";
        }
      }
    if (temp.equals("Ready"))
    {

      tempAccounts.get(tempAccounts.indexOf(change)).changeEmail(email);
      usersAccount.changeEmail(email);

    }
    return temp;
  }

    @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}