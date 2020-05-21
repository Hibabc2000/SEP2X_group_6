package system.networking;

import system.transferobjects.Container;
import system.transferobjects.login.Account;
import system.transferobjects.login.Group;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.net.Socket;

public class SocketClient implements Client
{
  private static final String SERVER_IP = "127.0.0.1";
  private static final int SERVER_PORT = 9090;

  private ClientSocketHandler socketHandler;
  private Socket socket;


  private PropertyChangeSupport support;

  @Override public void start() throws IOException
  {
    support = new PropertyChangeSupport(this);
    socket = new Socket(SERVER_IP, SERVER_PORT);
    socketHandler = new ClientSocketHandler(socket, this);
    Thread thread = new Thread(socketHandler);
    thread.setDaemon(true);
    thread.start();
  }

  /**
   * Sends the the username,password,email to the client socket
   * handler in order to create an account
   *
   * @param username     String containing the username
   * @param password String containing the password
   * @param email    String containing the email
   */
  @Override public void createAccount(String username, String password,
      String email)
  {
    try
    {
      System.out.println("clientsocket");
      socketHandler.createAccount(username, password, email);

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }



  @Override public void changeEmail(Account acc, String email)
  {
    try
    {
      socketHandler.changeEmail(acc, email);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Sends the {@param email} to the client socket handler
   * @param email String containing the email
   */
  @Override public void recoverPassword(String email)
  {
    try
    {
      socketHandler.recoverPassword(email);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void createGroup(Account acc, String groupName)
  {
    try
    {
      socketHandler.createGroup(acc, groupName);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void changePassword(Account acc, String oldPassword)
  {
    try
    {
      socketHandler.changePassword(acc, oldPassword);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Sends the username and password to the Socket Handler
   *
   * @param username String containing the username
   * @param password String containing the password
   */
  @Override public void checkLogin(String username, String password)
  {
    try
    {
      socketHandler.checkLogin(username, password);
      System.out.println("sockethandler");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void joinGroupAsAPlayer(Account acc, Group groupname)
  {
    try
    {
      socketHandler.joinGroup(acc, groupname);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void searchGroup(int id, String user)
  {
    try
    {
      socketHandler.searchGroup(id, user);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void removeUser(Account ac)
  {
    try
    {
      socketHandler.removeUser(ac);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /**
   *
   * @param response Fires an event containing {@param response} with a boolean
   */
  public void createAccountInfo(boolean response)
  {

    support.firePropertyChange("createAccount", null, response);

  }

  /**
   * Fires an event containing {@param container} with all the account data
   *
   * @param container Container with the account data
   */
  public void loginInfo(Container container)
  {
    support.firePropertyChange("acceptLogin", null, container);
    System.out.println("client prop change");
  }

  public void searchGroupInfo(Container inDataPack)
  {
    support.firePropertyChange("searchGroup", null, inDataPack);
    System.out.println("clientsocketfiresupportadcmid");
  }
  public void addPlayerToGroupUpdate(Container c)
  {
    support.firePropertyChange("addPlayerGroupUpdate",null,c);
    System.out.println("group added to other player ui this is client speaking");
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

  public void recoverPasswordResponse(Container inDataPack)
  {
    support.firePropertyChange("recoverPassword", null, inDataPack);
  //  System.out.println("clientsocketfiresupportadcmid");
  }
}
