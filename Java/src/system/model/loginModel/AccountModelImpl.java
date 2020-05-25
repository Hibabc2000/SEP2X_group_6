package system.model.loginModel;

import system.AccountsForTesting;
import system.networking.Client;
import system.transferobjects.Container;
import system.transferobjects.login.Account;
import system.transferobjects.login.DM;
import system.transferobjects.login.Group;
import system.transferobjects.login.Player;

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

    tempGroups = new ArrayList<>();
    groupsForDm = new ArrayList<>();

    // for testing

    client.addListener("recoverPassword", this::recoverPasswordBackFromServer);
    client.addListener("createAccount", this::createAccountInfoBackFromServer);
    client.addListener("acceptLogin", this::loginInfo);
    client.addListener("searchGroup", this::searchGroupInfo);
    client.addListener("addPlayerGroupUpdate", this::updateGroups);
    client.addListener("addDMGroup", this::addDMGroup);
    client.addListener("answerToEmailChange", this::answerToEmailChange);
  }

  private void answerToEmailChange(PropertyChangeEvent propertyChangeEvent)
  {
    Object obj = ((Container) propertyChangeEvent.getNewValue()).getObject();
    boolean answer = (boolean) obj;
    if (answer)
    {
      support.firePropertyChange("emailChange", null, true);
    }
    else
    {
      support.firePropertyChange("emailChange", null, false);
    }
  }

  private void addDMGroup(PropertyChangeEvent propertyChangeEvent)
  {
    Group gp = (Group) ((ArrayList<Object>) ((Container) propertyChangeEvent
        .getNewValue()).getObject()).get(0);
    gp.addDM(usersAccount.getDM());
    groupsForDm.add(gp);
    support.firePropertyChange("GroupCreatedByDm", null, gp);
  }

  /**
   * Converts the Property Change Event to an ArrayList and fires an event containing {@param propertyChangeEvent}
   *
   * @param propertyChangeEvent Container contains an ArrayList of two objects(boolean and the recovered password)
   */
  private void recoverPasswordBackFromServer(
      PropertyChangeEvent propertyChangeEvent)
  {
    ArrayList<Object> objs = (ArrayList<Object>) ((Container) propertyChangeEvent
        .getNewValue()).getObject();
    System.out.println("almamatarastrigo");
    support.firePropertyChange("recoverPassword", null, objs);

  }

  private void updateGroups(PropertyChangeEvent propertyChangeEvent)
  {
    Group grp = (Group) ((Container) propertyChangeEvent.getNewValue())
        .getObject();

    int idOfTheGroupToAddThePlayer = grp.getId();
    Group oldGroup = null;
    Group newGroup = grp;
    System.out.println("******************************");
    for (int i = 0; i < tempGroups.size(); i++)
    {
      if (tempGroups.get(i).getId() == idOfTheGroupToAddThePlayer)
      {
        tempGroups.set(i, grp);
        support.firePropertyChange("PlayerAddedToGroup", null, tempGroups);
      }
    }
    for (int i = 0; i < groupsForDm.size(); i++)

    {
      if (groupsForDm.get(i).getId() == idOfTheGroupToAddThePlayer)
      {
        System.out.println("alm alm alma  csapat ");
        groupsForDm.set(i, grp);
        support.firePropertyChange("PlayerAddedToDMGroup", null, groupsForDm);
      }
    }
  }

  private void searchGroupInfo(PropertyChangeEvent propertyChangeEvent)
  {
    Container info = (Container) propertyChangeEvent.getNewValue();
    ArrayList<Object> objs = (ArrayList<Object>) info.getObject();
    boolean isIDValid = (boolean) objs.get(0);

    System.out.println("id :" + isIDValid);
    if (isIDValid)
    {
      Group groupWithTheIDWeFound = (Group) objs.get(1);
      tempGroups.add(
          groupWithTheIDWeFound);   //I'm not sure about this one, maybe it will cause problems.
      support.firePropertyChange("GroupAdded", null, groupWithTheIDWeFound);
    }
    else
    {
      support.firePropertyChange("searchFailed", null, isIDValid);
    }
  }

  private void loginInfo(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("verything is fine");
    Container info = (Container) propertyChangeEvent.getNewValue();
    ArrayList<Object> objs = (ArrayList<Object>) info.getObject();
    boolean isLoginValid = (boolean) objs.get(0);
    System.out.println("log response:" + isLoginValid);

    if (isLoginValid)
    {
      distributeAccountInfo(objs);
      support.firePropertyChange("acceptLogin", null, isLoginValid);
    }
    else
    {
      support.firePropertyChange("acceptLogin", null, isLoginValid);
    }
  }

  public void distributeAccountInfo(ArrayList<Object> o)
  {

    usersAccount = (Account) o.get(1);

    System.out.println(usersAccount.getUsername());
    try
    {
      if (o.get(2) != null)
      {
        System.out.println("nézem agroupokat");
        ArrayList<Group> groups = (ArrayList<Group>) o.get(2);

        for (int i = 0; i < groups.size(); i++)
        {
          if (groups.get(i).getDM().getName()
              .equals(usersAccount.getUsername()))
          {
            groupsForDm.add(groups.get(i));
          }
          else
            tempGroups.add(groups.get(i));
        }
      }
    }
    catch (IndexOutOfBoundsException e)
    {
      System.out.println("no groups");
    }

  }

  private void createAccountInfoBackFromServer(
      PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("modelimplistener");
    support.firePropertyChange("createAccount", null,
        propertyChangeEvent.getNewValue());
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
    String temp = "Creating...";
    client.createGroup(usersAccount, name);
    //serve

    //

    // support.firePropertyChange("GroupCreatedByDm", null, newGroup);

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
    for (int i = 0; i < groupsForDm.size(); i++)
    {
      if (groupsForDm.get(i).getId() == id)
      {
        temp = "You are the DM of this group\n so you cannot join a player.";
        break;
      }

    }
    if (temp.equals("Searching..."))
    {
      client.searchGroup(id, usersAccount.getUsername());
    }

    return temp;
  }

  // Player joins a group by a loop going through all the groups that are in his group list, and joins the one
  // that has the same toString which the player clicked, next checks if the player is the part of the group or not
  // and whether the group contains the same username as the player, just to make sure there is absolutely no errors.
  //after that the player is added to a group , and fire prop change with 2 variables, oldgroup and the tempgroup.

  @Override public String joinGroupAsPlayer(String groupName)
  {
    String temp = "Connecting...";

    // server
    for (int i = 0; i < tempGroups.size(); i++)
    {
      if (tempGroups.get(i).toString().equals(groupName) && (!tempGroups.get(i)
          .isContainsUsername(usersAccount.getUsername())))
      {
        Group oldGroup = tempGroups.get(i);

        temp = "You have been added to the group";

        tempGroups.get(i).addPlayer(usersAccount.getPlayer());
        client.joinGroupAsAPlayer(usersAccount, tempGroups.get(i));
        System.out.println("MÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓÓ");
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

  /**
   * Basic fields checking functionality(empty fields, fields length).
   * Sends a request to the client socket with the username,password,email in order
   * to create an account
   *
   * @param username String containing the username
   * @param pass1    String containing the password
   * @param pass2    String containing the password confirmation
   * @param email    String containing the email
   * @return String in case there are any errors
   */

  @Override public String checkAccountUniqueness(String username, String pass1,
      String pass2, String email)
  {
    String temp = "Connecting...";

    if (username.equals("") || pass1.equals("") || pass2.equals("") || email
        .equals(""))
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
    usersAccount = new Account(username, pass1, email);

    return temp;
  }

  // basic login with if statements checking pass and name.

  /**
   * Checks the given username and password and sends them forward to the
   * Client network
   *
   * @param username String containing the username
   * @param password String containing the password
   * @return a String with an error if it is the case
   */
  @Override public String checkLogin(String username, String password)
  {
    String temp = "Connecting...";
    //server
    if (username.equals("") || password.equals(""))
    {
      temp = "Fill out all the fields";
    }

    else
      client.checkLogin(username, password);
    // put it into server

    return temp;

  }
  // checking the email for password recovery whether the email is in the system

  /**
   * Basic field checks(empty fields), after checking the {@param email} is
   * send to the client socket
   *
   * @param email String containing the email
   * @return String message containing an error if it is the case
   */
  @Override public String checkEmail(String email)
  {
    String temp = "Error";

    if (email.equals(""))
    {
      temp = "Type in your email account,jezz...";
    }

    else
      client.recoverPassword(email);
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

  /**
   * Basic field checks(empty fields, password match), after checking the {@param email} is
   * send to the client socket
   *
   * @param username     String containing the username
   * @param passOld      String containing the old password
   * @param passNew      String containing the new password
   * @param passNewAgain String containing the new password confirmation
   * @return a String message if there is an error
   */
  @Override public String checkPasswordChangeInformation(String username,
      String passOld, String passNew, String passNewAgain)
  {
    String temp = "Error";
    Account change = null;

    if (username.equals("") || passOld.equals("") || passNew.equals("")
        || passNewAgain.equals(""))
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
    {
      usersAccount.setPassword(passNew);
      temp = "Ready"; // if no errors,then password is changed
      client.changePassword(
          usersAccount); // here we send it to the database so it changes, we dont need to check anything
    }

    return temp;
  }

  /**
   * Basic field checks(empty fields, same email, password check), after checking the user account and the new email
   * are sent send to the client socket
   *
   * @param username String containing the username
   * @param password String containing the password
   * @param email    String containing the email
   * @return a String message with an error or "Ready" if the check Email Change Information is completed successfully
   */
  @Override public String checkEmailChangeInformation(String username,
      String password, String email)
  {
    Account change = null;
    String temp = "Error";

    if (username.equals("") || password.equals("") || email.equals(""))
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
      client.changeEmail(email, usersAccount.getUsername());
    //server

    return temp;
  }

  /**
   * Get the user username
   *
   * @return String value containing the username
   */
  @Override public String getUsername()
  {
    return usersAccount.getUsername();

  }

  /**
   * Adds the listener.
   *
   * @param eventName String containing the event name
   * @param listener  source bean so as to be notified of any bound property updates.
   */
  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  /**
   * Removes the listener.
   *
   * @param eventName String containing the event name
   * @param listener  source bean so as to be notified of any bound property updates.
   */
  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }

  //everything under this is for testing  since I have no idea how to test these things.
  @Override public Account getAccount()
  {
    return usersAccount;
  }

  @Override public void startGame(String group)
  {
    for (int i = 0; i < tempGroups.size(); i++)
    {
      if (groupsForDm.get(i).toString().equals(group))
      {
        Group groupToPlayWith = tempGroups.get(i);

        client.startGame(groupToPlayWith);
        break;
      }


    }
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