package system.Client;

import system.Account;
import system.Group;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


  public class ClientSocketHandler implements Runnable
  {
    private SocketClient socketClient;
    private Socket socket;

    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;

    public ClientSocketHandler(Socket socket, SocketClient socketClient)
        throws IOException
    {
      this.socket = socket;
      this.socketClient = socketClient;
      outToServer = new ObjectOutputStream(socket.getOutputStream());
      inFromServer = new ObjectInputStream(socket.getInputStream());
    }

    @Override public void run()
    {

    }

    public void removeUser(Account ac, String remove)
    {
    }

    public void searchGroup(int id, String user, String searchGroup)
    {
    }

    public void joinGroupAsPlayer(Account acc, Group g, String joinGroup)
    {
    }

    public void checkAccountUniqueness(String username, String password, String email, String checkAccount)
    {
    }

    public void checkLogin(String username, String password, String checkLogin)
    {
    }

    public void checkEmail(String email, String checkEmail)
    {
    }

    public void checkPasswordChangeInformation(Account acc, String newPassword, String oldPassword,
        String checkPasswordChange)
    {
    }

    public void checkEmailChangeInformation(Account acc, String email, String checkEmailChange)
    {
    }

    public void joinGroup(Account acc, Group g, String joinGroup)
    {
    }

    public void createGroup(Account acc, Group g, String createGroup)
    {
    }

    public void recoverPassword(String email, String recoverPassword)
    {
    }

    public void changePassword(Account acc, String newPassword, String changePassword)
    {
    }

    public void changeEmail(Account acc, String email, String changeEmail)
    {
    }

    public void loginAccount(String name, String password, String loginAccount)
    {
    }

    public void createAccount(String name, String password, String email, String createAccount)
    {
    }
  }
