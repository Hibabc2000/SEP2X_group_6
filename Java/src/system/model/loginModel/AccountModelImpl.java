package system.model.loginModel;

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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author Oliver Izsák, 293131
 * @version 1.2.0
 * this class is the model for all the functionalities of the Account system and Create group, Join group, Start game.
 */
public class AccountModelImpl
    implements AccountModel, OpenSystemModel, ChangeEmailModel,
    ChangePasswordModel, CreateAccountModel,DMAccountModel,PasswordRecoveryModel,PlayerAccountModel
{

  private ArrayList<Group> groupsForDm;
  private ArrayList<Group> groupsForPlayer;

  private PropertyChangeSupport support;

  private Account usersAccount;

  private Client client;
  private static final Lock lock = new ReentrantLock();

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

    groupsForPlayer = new ArrayList<>();
    groupsForDm = new ArrayList<>();



    client.addListener("recoverPassword", this::recoverPasswordBackFromServer);
    client.addListener("createAccount", this::createAccountInfoBackFromServer);
    client.addListener("acceptLogin", this::loginInfo);
    client.addListener("searchGroup", this::searchGroupInfo);
    client.addListener("addPlayerGroupUpdate", this::updateGroups);
    client.addListener("addDMGroup", this::addDMGroup);
    client.addListener("answerToEmailChange", this::answerToEmailChange);
  }
  /**
   * Converts the Property Change Event to an boolean and fires an event containing {@param answer}
   *If the email change was successful it fires true, otherwise false.
   * @param propertyChangeEvent Container contains a boolean
   */
  private void answerToEmailChange(PropertyChangeEvent propertyChangeEvent)
  {
    Object obj = ((Container) propertyChangeEvent.getNewValue()).getObject();
    boolean answer = (boolean) obj;
    if (answer)
    {
      support.firePropertyChange("emailChange", null, answer);
    }
    else
    {
      support.firePropertyChange("emailChange", null, answer);
    }
  }
  /**
   * Converts the Property Change Event to an ArrayList and fires an event containing {@param gp}
   * Adds the new  group to the groupForDM group list and updates the viewmodel.
   * @param propertyChangeEvent Container contains an ArrayList of 1 object(Group)
   */
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

    support.firePropertyChange("recoverPassword", null, objs);

  }
  /**
   * Converts the Property Change Event to a Group and fires an event containing {@param groupsForPlayer}
   * Gets id of the Group and searches the groupsForPlayer and GroupForDM group list for group that matches the ID then updates it, and sends
   * the update to the viewmodel.
   * @param propertyChangeEvent Container contains an Group object
   */
  private void updateGroups(PropertyChangeEvent propertyChangeEvent)
  {
    Group grp = (Group) ((Container) propertyChangeEvent.getNewValue())
        .getObject();

    int idOfTheGroupToAddThePlayer = grp.getId();


    for (int i = 0; i < groupsForPlayer.size(); i++)
    {
      if (groupsForPlayer.get(i).getId() == idOfTheGroupToAddThePlayer)
      {
        groupsForPlayer.set(i, grp);
        support.firePropertyChange("PlayerAddedToGroup", null, groupsForPlayer);
      }
    }
    for (int i = 0; i < groupsForDm.size(); i++)

    {
      if (groupsForDm.get(i).getId() == idOfTheGroupToAddThePlayer)
      {

        groupsForDm.set(i, grp);
        support.firePropertyChange("PlayerAddedToDMGroup", null, groupsForDm);
      }
    }
  }
  /**
   * Converts the Property Change Event to a Arraylist and fires an event containing {@param groupsWithTheIDWeFound or isIDValid}
   * If the boolean is true, a group was found, in this case the group is added to the groupsForPlayer group list,
   * and an update is fired for the view model with the group in it.
   * Otherwise only a boolean is sent to the view model stating that the group ID does not exist.
   * @param propertyChangeEvent Container contains an ArrayList of 2 objects(First one is a boolean, if the first one
   *  has the value true, then it also contains a second object which is a group, if the value of the boolean is false, then it does not)
   *
   */
  private void searchGroupInfo(PropertyChangeEvent propertyChangeEvent)
  {
    Container info = (Container) propertyChangeEvent.getNewValue();
    ArrayList<Object> objs = (ArrayList<Object>) info.getObject();
    boolean isIDValid = (boolean) objs.get(0);

    if (isIDValid)
    {
      Group groupWithTheIDWeFound = (Group) objs.get(1);
      groupsForPlayer.add(
          groupWithTheIDWeFound);   //I'm not sure about this one, maybe it will cause problems.
      support.firePropertyChange("GroupAdded", null, groupWithTheIDWeFound);
    }
    else
    {
      support.firePropertyChange("searchFailed", null, isIDValid);
    }
  }
  /**
   * Converts the Property Change Event to an Arraylist and fires an event containing {@param isLoginValid}
   * If the boolean is true then the distributeAccountInfo method is called and the viewmodel is updated with a successful login.
   * else the viewmodel is only updated with an unsuccessful login.
   * @param propertyChangeEvent Container contains an ArrayList of 2 objects(First one is a boolean, if the first one
   *    *  has the value true, then it also contains a second object which is an account, if the value of the boolean is false, then it does not)
   */
  private void loginInfo(PropertyChangeEvent propertyChangeEvent)
  {

    Container info = (Container) propertyChangeEvent.getNewValue();
    ArrayList<Object> objs = (ArrayList<Object>) info.getObject();
    boolean isLoginValid = (boolean) objs.get(0);


    if (isLoginValid)
    {
      System.out.println("KURVAÉLETBE");
      distributeAccountInfo(objs);

      support.firePropertyChange("acceptLogin", null, isLoginValid);
    }
    else
    {
      support.firePropertyChange("acceptLogin", null, isLoginValid);
    }
  }
  /**
   *Gets an Arraylist from the loginInfo listener method, and initializes the user's account, set's the user to player
   * and distributes the groups the User is part of, depending on whether he is the DM of a group or just a player.
   * @param o Container contains an ArrayList of 2 objects(First one is a boolean, if the first one
   *    *  has the value true, then it also contains a second object which is an account and
   *      a third which is a Arraylist of groups , if the value of the boolean is false, then it does not)
   * @throws IndexOutOfBoundsException if the user is not part of any group.
   */
  public void distributeAccountInfo(ArrayList<Object> o)
  {

    usersAccount = (Account) o.get(1);
    usersAccount.setUserToPlayer();

    try
    {
      if (o.get(2) != null)
      {

        ArrayList<Group> groups = (ArrayList<Group>) o.get(2);

        for (int i = 0; i < groups.size(); i++)
        {
          if (groups.get(i).getDM().getName()
              .equals(usersAccount.getUsername()))
          {
            groupsForDm.add(groups.get(i));
          }
          else
            groupsForPlayer.add(groups.get(i));
        }
      }
    }
    catch (IndexOutOfBoundsException e)
    {

    }

  }
  /**
   * Passes on the {@param propertyChangeEvent} containing a boolean to the create account view model.
   * @param propertyChangeEvent Container contains boolean
   */
  private void createAccountInfoBackFromServer(
      PropertyChangeEvent propertyChangeEvent)
  {

    support.firePropertyChange("createAccount", null,
        propertyChangeEvent.getNewValue());


  }
  /**
   * Removes the account from the server after the client exits the system.
   */
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
      return groupsForPlayer;
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

    for (int i = 0; i < groupsForPlayer.size(); i++)
    {
      if (groupsForPlayer.get(i).getId() == id)
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
    for (int i = 0; i < groupsForPlayer.size(); i++)
    {
      if (groupsForPlayer.get(i).toString().equals(groupName) && (!groupsForPlayer.get(i)
          .isContainsUsername(usersAccount.getUsername())))
      {
        Group oldGroup = groupsForPlayer.get(i);

        temp = "You have been added to the group";

        groupsForPlayer.get(i).addPlayer(usersAccount.getPlayer());
        client.joinGroupAsAPlayer(usersAccount, groupsForPlayer.get(i));

        break;
      }
      else
      {
        temp = "You are already part of that group";
      }
    }

    for (int i = 0; i < groupsForPlayer.size(); i++)
    {
      if (groupsForPlayer.get(i).isPlayerPartOfGroup(usersAccount.getPlayer()))
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
    else if(username.contains(" ")) {temp="Your name cannot contain spaces.";}

    else if (pass1.length() < 6)
    {
      temp = "Password must be longer than 6 characters";
    }
    else if (username.length() < 4)
    {
      temp = "Username must be longer than 4 characters";
    }
    else if(username.contains(",") || username.contains("{"))
    {
      temp = "Username cannot contain the following symbols: , { ";
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
    usersAccount.setUserToPlayer();

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
    {
      client.checkLogin(username, password);}
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
    System.out.println("watafuk1");
    usersAccount.setUserToDm();
    System.out.println("watafuk2");
    System.out.println("watafuk3");

  }

  @Override public void changeToPlayer()
  {
    System.out.println("watafuk1");
    usersAccount.setUserToPlayer();
    System.out.println("watafuk2");

    System.out.println("watafuk3");
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
  @Override  public  synchronized String checkPasswordChangeInformation(String username,
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
    else synchronized (lock)
    {
      System.out.println("BÜDÖSKÖCSÖKG");
      usersAccount.setPassword(passNew);
      temp = "Ready"; // if no errors,then password is changed
      client.changePassword(
          usersAccount); // here we send it to the database so it changes, we dont need to check anything
      System.out.println(usersAccount.getPassword());
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

  @Override public Account getAccount()
  {
    return usersAccount;
  }

  @Override public void startGame(String group)
  {
    for (int i = 0; i < groupsForDm.size(); i++)
    {
      if (groupsForDm.get(i).toString().equals(group))
      {
        Group groupToPlayWith = groupsForDm.get(i);

        client.startGame(groupToPlayWith);
        break;
      }

    }
  }

}