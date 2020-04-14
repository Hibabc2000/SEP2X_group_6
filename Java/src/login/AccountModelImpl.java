package login;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class AccountModelImpl implements AccountModel
{
  private ArrayList<Account> tempAccounts; // database
  private ArrayList<Group> tempGroups; //database
  private ArrayList<Group> findingUnknownGroupsGroup; //database
  private ArrayList<Group> groupsForDm; //

  private PropertyChangeSupport support;
  private Account usersAccount;
  private AccountsForTesting tests;

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
    usersAccount = null; //remove client  instead .
  }

  @Override public String createGroup(String name)
  {
    String temp = "Group cannot be created";
    DiceRoll roll = new DiceRoll();
    int id = roll.RollDice(10000,2);
    Group newGroup = new Group(name,id);
    newGroup.addDM(usersAccount.getDM());
    groupsForDm.add(newGroup);
    System.out.println(id);
    findingUnknownGroupsGroup.add(newGroup);support.firePropertyChange("GroupCreatedByDm",null,newGroup); getGroups();
    return temp="Ready";

  }

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
      if(findingUnknownGroupsGroup.get(i).getDM().getName().equals(usersAccount.getUsername()))
      {temp="This group was made by you as a DM.\n You can only see this group in the DM scene";}
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

  @Override public ArrayList<Group> getGroups()
  { if(usersAccount.getUser() instanceof Player)
  {return tempGroups;}
  else if(usersAccount.getUser() instanceof DM)
  {System.out.println("whatshappening?"); return groupsForDm;}

  else return null;
  }

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
          System.out.println(temp = "Ready");
          usersAccount = tempAccounts.get(i);
          //usersAccount = add account from database
          break;
        }
        else
        {
          temp = "This account doesn't exit.";
        }
      }

    return temp;

  }

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
          System.out.println(temp = "Ready");
          break;
        }
        else
        {
          temp = "This email is not registered in our system.";
        }
      }

    return temp;
  }

  @Override public void changeToDm()
  {
    usersAccount.setUserToDm();

  }

  @Override public void changeToPlayer()
  {
    usersAccount.setUserToPlayer();
  }

  @Override public String checkPasswordChangeInformation(String username,
      String passOld, String passNew, String passNewAgain)
  {
    String temp = "Error";
    Account add = null;
    Account remove = null;

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
        if (tempAccounts.get(i).getPassword().equals(passOld))
        {
          add = tempAccounts.get(i);
          remove = tempAccounts.get(i);
        }
        if ((tempAccounts.get(i).getPassword().equals(passNew)))
        {
          System.out.println(temp = "Error message: Choose different password");
          break;
        }
        else
        {
          temp = "Ready";
        }
      }
    if (temp.equals("Ready"))
    {
      tempAccounts.remove(remove);
      tempAccounts.add(add);
      usersAccount.setPassword(passNew);
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