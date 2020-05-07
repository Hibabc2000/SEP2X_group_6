package system.Client;

import system.Account;
import system.Group;

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
    socketHandler.createAccount(name,password,email,"createAccount");
  }

  @Override public void loginAccount(String name, String password)
  {
   socketHandler.loginAccount(name,password,"loginAccount");
  }

  @Override public void changeEmail(Account acc, String email)
  {
  socketHandler.changeEmail(acc,email,"changeEmail");
  }

  @Override public void changePassword(Account acc, String newPassword,
      String oldPassword)
  {
 socketHandler.changePassword(acc,newPassword,"changePassword");
  }

  @Override public void recoverPassword(String email)
  {
  socketHandler.recoverPassword(email,"recoverPassword");
  }

  @Override public void createGroup(Account acc, Group g)
  {
 socketHandler.createGroup(acc,g,"createGroup");
  }

  @Override public void joinGroup(Account acc, Group g)
  {
 socketHandler.joinGroup(acc,g,"joinGroup");
  }

  @Override public void checkEmailChangeInformation(Account acc, String email)
  {
socketHandler.checkEmailChangeInformation(acc,email,"checkEmailChange");
  }

  @Override public void checkPasswordChangeInformation(Account acc,
      String newPassword, String oldPassword)
  {
 socketHandler.checkPasswordChangeInformation(acc,newPassword,oldPassword,"checkPasswordChange");
  }

  @Override public void checkEmail(String email)
  {
 socketHandler.checkEmail(email,"checkEmail");
  }

  @Override public void checkLogin(String username, String password)
  {
 socketHandler.checkLogin(username,password,"checkLogin");
  }

  @Override public void checkAccountUniqueness(String username, String password,
      String email)
  {
 socketHandler.checkAccountUniqueness(username,password,email,"checkAccount");
  }

  @Override public void joinGroupAsAPlayer(Account acc, Group g)
  {
 socketHandler.joinGroupAsPlayer(acc,g,"joinGroup");
  }

  @Override public void searchGroup(int id, String user)
  {
  socketHandler.searchGroup(id,user,"searchGroup");
  }

  @Override public void removeUser(Account ac)
  {
  socketHandler.removeUser(ac,"remove");
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {

  }
}
