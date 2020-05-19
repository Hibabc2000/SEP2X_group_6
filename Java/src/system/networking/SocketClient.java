package system.networking;

import system.model.loginModel.Account;

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
    support=new PropertyChangeSupport(this);
    socket = new Socket(SERVER_IP, SERVER_PORT);
    socketHandler = new ClientSocketHandler(socket, this);
    Thread thread = new Thread(socketHandler);
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void createAccount(String name, String password,
      String email)
  {
    try
    {
      System.out.println("clientsocket");
      socketHandler.createAccount(name,password,email);

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
      socketHandler.changeEmail(acc,email);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }



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
      socketHandler.createGroup(acc,groupName);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }



  @Override public void checkEmailChangeInformation(Account acc, String email)
  {
    try
    {
      socketHandler.checkEmailChangeInformation(acc,email);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void checkPasswordChangeInformation(Account acc,
      String newPassword, String oldPassword)
  {
    try
    {
      socketHandler.checkPasswordChangeInformation(acc,newPassword,oldPassword);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }



  @Override public void checkLogin(String username, String password)
  {
    try
    {
      socketHandler.checkLogin(username,password);
      System.out.println("sockethandler");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  /*@Override public void checkAccountUniqueness(String username, String password,
      String email)
  {System.out.println("clientcheck1");
    try
    {
      System.out.println("clientcheck2");
      socketHandler.checkAccountUniqueness(username,password,email,"checkAccount");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
*/
  @Override public void joinGroupAsAPlayer(Account acc, String groupname)
  {
    try
    {
      socketHandler.joinGroupAsPlayer(acc,groupname);
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
      socketHandler.searchGroup(id,user);
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

   public void createAccountInfo(boolean ac)
  {

      support.firePropertyChange("createAccount",null,ac);


  }
  public void loginInfo(Container c)
  {
    support.firePropertyChange("acceptLogin",null,c);
    System.out.println("client prop change");
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
