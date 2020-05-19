package system.model.loginModel;

import system.AccountsForTesting;
import system.DiceRoll;
import system.networking.Client;
import system.networking.Container;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
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
  private Client client;

  public AccountModelImpl(Client client)
  {
    this.client = client;
    try
    {
      client.start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    support = new PropertyChangeSupport(this);
    tests = new AccountsForTesting();
    tempGroups = new ArrayList<>();
    groupsForDm = new ArrayList<>();
    tempAccounts = new ArrayList<>();
    findingUnknownGroupsGroup = new ArrayList<>();
    // for testing
    usersAccount = tests.getAcc();
    tempGroups = tests.getTempGroups();
    groupsForDm = tests.getGroupsForDm();
    tempAccounts = tests.getTempAccounts();
    findingUnknownGroupsGroup = tests.getFindingUnknownGroupsGroup();

    client.addListener("createAccount",this::createAccountInfoBackFromServer);
    client.addListener("acceptLogin",this::loginInfo);
  }

  private void loginInfo(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("verything is fine");
    Container info = (Container) propertyChangeEvent.getNewValue();
    ArrayList<Object> objs =  (ArrayList<Object>) info.getObject();
    boolean isLoginValid = (boolean)objs.get(0);
    System.out.println(((Account)objs.get(1)).getPlayer());
    if(isLoginValid) {distributeAccountInfo(objs);}
    else {support.firePropertyChange("acceptLogin",isLoginValid,null);} // be aware that new value is null, because login is invalid
  }
  public void distributeAccountInfo(ArrayList<Object> o)
  {
    System.out.println(((Account)o.get(1)));
    Account temp = (Account) o.get(1);
    usersAccount = temp;
    ArrayList<Group> groups = (ArrayList<Group>) o.get(2);
    for(int i=0; i<groups.size();i++)
    {
      if(groups.get(i).getDM().getName().equals(usersAccount.getDM().getName()))
      {groupsForDm.add(groups.get(i));}
      else tempGroups.add(groups.get(i));


    }




  }

  private void createAccountInfoBackFromServer(
      PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("modelimplistener");
    support.firePropertyChange("createAccount",null,propertyChangeEvent.getNewValue());
    System.out.println("modelimplistener2");

  }

  public void removeAccount()
  {
    client.removeUser(usersAccount);
    System.exit(1);
  }

  // DM creates a group with a given name , and a random ID, right now i am using just a RNG, but this might be changed cause it is inefficient
  //  added it to a newgroup, I add DM as myself, since I created the group, so I am the DM.
  // the newgroup is added to the groupsForDm which will appear in my DM grouplist.
  // I add it to the temporary findingUnkownGroupsGroup so it can be found by other players. This  replaces the database right now.
  // fire propchange to update the viewmodel and view with the new group,
  @Override public String createGroup(String name)
  {
    String temp;
    client.createGroup(usersAccount, name);
    //serve
    DiceRoll roll = new DiceRoll();
    ArrayList<Integer> ids = new ArrayList<>();
    //server
    for (int i = 0; i < findingUnknownGroupsGroup.size(); i++)
    {
      ids.add(findingUnknownGroupsGroup.get(i).getId());
    }
    int id = 0;
    do
    {
      id = roll.RollDice(1000000, 2);
    }
    while ((ids.contains(id)));
    Group newGroup = new Group(name, id);
    newGroup.addDM(usersAccount.getDM());
    groupsForDm.add(newGroup);
    System.out.println(id);
    findingUnknownGroupsGroup.add(newGroup);
    support.firePropertyChange("GroupCreatedByDm", null, newGroup);

    return temp = "Group created";

  }

  // returns the groups for the User depending on what mode is he in (player or DM)
  @Override public ArrayList<Group> getGroups()
  {
    if (usersAccount.getUser() instanceof Player)
    {
      return tempGroups;
    }
    else if (usersAccount.getUser() instanceof DM)
    {
      return groupsForDm;
    }

    else
      return null;
  }

  // players will use this method to search for a group by ID,
  //If it in his tempGroups that means he already discovered it, then the loop breaks;
  // Nextx loop checks the database for the group , and if he finds it but the DM has the same name as the DM of that group then loop breaks and error,
  //if no errors then next loop finds the group and adds it to the users grouplist and property change fire to update view/vm.
  @Override public String searchGroup(int id)
  {
    String temp = "Searching...";

    for (int i = 0; i < tempGroups.size(); i++)
    {
      if (tempGroups.get(i).getId() == id)
      {
        temp = "You already have this group in your group list";
        break;
      }
    }

    client.searchGroup(id, usersAccount.getUsername());
    for (int i = 0; i < findingUnknownGroupsGroup.size(); i++)
    {
      if (findingUnknownGroupsGroup.get(i).getDM().getName()
          .equals(usersAccount.getUsername())
          && findingUnknownGroupsGroup.get(i).getId() == id)
      {
        temp = "This group was made by you as a DM.\n You can only see this group in the DM mode";
        break;
      }

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
    String temp = "Connecting...";
    client.joinGroupAsAPlayer(usersAccount, groupname);
    // server
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

    for (int i = 0; i < tempGroups.size(); i++)
    {
      if (tempGroups.get(i).isPlayerPartOfGroup(usersAccount.getPlayer()))
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
    String temp = "Connecting...";

    if (username.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (pass1.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (pass2.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (email.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (pass1.length() < 6)
    {
      temp = "Password must be longer than 6 characters";
    }
    else if (username.length() < 4)
    {
      temp = "Username must be longer than 4 characters";
    }
    else if (!(pass1.equals(pass2)))
    {
      temp = "Passwords don't match";
    }
    else if (!email.contains("@"))
    {
      temp = "E-mail format not valid";
    }

    else
      client.createAccount(username, pass1, email);
    System.out.println("alma");
    usersAccount = new Account(username,pass1,email);

    return temp;
  }

  // basic login with if statements checking pass and name.
  @Override public String checkLogin(String username, String pass)
  {
    String temp = "Connecting...";
    //server
    if (username.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (pass.equals(""))
    {
      temp = "Fill out all the fields";
    }

    else

      client.checkLogin(username, pass);
    // put it into server


    return temp;

  }
  // checking the email for password recovery whether the email is in the system

  @Override public String checkEmail(String value)
  {
    String temp = "Error";

    if (value.equals(""))
    {
      temp = "Type in your email account,jezz...";
    }

    else
      client.recoverPassword(value);
    //server
    for (int i = 0; i < tempAccounts.size(); i++)
    {
      if (tempAccounts.get(i).getEmail().equals(value))
      {
        temp = "Ready";
        String pas = tempAccounts.get(i).getPassword();
        String nam = tempAccounts.get(i).getUsername();
        System.out.println("You got a new email: \n  For the account " + nam
            + " your password is : " + pas);
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

    if (username.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (passOld.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (passNew.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (passNewAgain.equals(""))
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
      client.checkPasswordChangeInformation(usersAccount, passNew, passOld);
    //server
    for (int i = 0; i < tempAccounts.size(); i++)
    {
      if (tempAccounts.get(i).getPassword().equals(passOld) && tempAccounts
          .get(i).getUsername().equals(username))
      {
        change = tempAccounts.get(i);
        temp = "Ready";
      }

    }
    if (temp.equals("Ready"))
    {
      tempAccounts.get(tempAccounts.indexOf(change)).setPassword(passNew);
      System.out.println(usersAccount.getEmail());
      usersAccount.setPassword(passNew);
    }

    return temp;
  }

  // the same as the method above, but with emailchange
  @Override public String checkEmailChangeInformation(String username,
      String password, String email)
  {
    Account change = null;
    String temp = "Error";

    if (username.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (password.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if (email.equals(""))
    {
      temp = "Fill out all the fields";
    }
    else if ((email.equals(usersAccount.getEmail())))
    {
      temp = "This is your current email address. You nitwit...";
    }
    else if (!(usersAccount.getPassword().equals(password)) || !(usersAccount
        .getUsername().equals(username)))
    {
      temp = "Wrong  password or username";
    }
    else
      client.checkEmailChangeInformation(usersAccount, email);
    //server
    for (int i = 0; i < tempAccounts.size(); i++)
    {
      if (tempAccounts.get(i).getPassword().equals(password) && tempAccounts
          .get(i).getUsername().equals(username))
      {
        change = tempAccounts.get(i);

      }
      if ((tempAccounts.get(i).getEmail().equals(email)))
      {
        temp = "This email is already registered.";
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

  //everything under this is for testing  since I have no idea how to test these things.
  public Account getAccount()
  {
    return usersAccount;
  }

  public ArrayList<Account> getTempAccounts()
  {
    return tempAccounts;
  }

  public ArrayList<Group> getFindingUnknownGroupsGroup()
  {
    return findingUnknownGroupsGroup;
  }

  public ArrayList<Group> getTempGroups()
  {
    return tempGroups;
  }

  public ArrayList<Group> getGroupsForDm()
  {
    return groupsForDm;
  }

}