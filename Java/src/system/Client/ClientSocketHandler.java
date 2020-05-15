package system.Client;

import system.model.loginModel.Account;
import system.model.loginModel.Group;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

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

    public void removeUser(Account ac, String remove) throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(remove);
      objs.add(ac);
      outToServer.writeObject(objs);
    }

    public void searchGroup(int id, String user, String searchGroup)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(searchGroup);
      objs.add(id);
      objs.add(user);
      outToServer.writeObject(objs);
    }

    public void joinGroupAsPlayer(Account acc, String groupname, String joinGroup)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(joinGroup);
      objs.add(acc);
      objs.add(groupname);

      outToServer.writeObject(objs);
    }

    public void checkAccountUniqueness(String username, String password, String email, String checkAccount)
        throws IOException
    { System.out.println("clientcheck3");
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkAccount);
      objs.add(username);
      objs.add(password);
      objs.add(email);
      outToServer.writeObject(objs);
    }

    public void checkLogin(String username, String password, String checkLogin)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkLogin);
      objs.add(username);
      objs.add(password);
        outToServer.writeObject(objs);
    }

    public void checkEmail(String email, String checkEmail) throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkEmail);
      objs.add(email);

      outToServer.writeObject(objs);
    }

    public void checkPasswordChangeInformation(Account acc, String newPassword, String oldPassword,
        String checkPasswordChange) throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkPasswordChange);
      objs.add(acc);
      objs.add(newPassword);
      objs.add(oldPassword);
      outToServer.writeObject(objs);
    }

    public void checkEmailChangeInformation(Account acc, String email, String checkEmailChange)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkEmailChange);
      objs.add(acc);
      objs.add(email);
      outToServer.writeObject(objs);
    }

    public void joinGroup(Account acc, Group g, String joinGroup)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(joinGroup);
      objs.add(acc);
      objs.add(g);
      outToServer.writeObject(objs);
    }

    public void createGroup(Account acc, String groupName, String createGroup)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(createGroup);
      objs.add(acc);
      objs.add(groupName);
      outToServer.writeObject(objs);
    }

    public void recoverPassword(String email, String recoverPassword)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(recoverPassword);
      objs.add(email);
      outToServer.writeObject(objs);
    }

    public void changePassword(Account acc, String newPassword, String changePassword)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(changePassword);
      objs.add(acc);
      objs.add(newPassword);
      outToServer.writeObject(objs);
    }

    public void changeEmail(Account acc, String email, String changeEmail)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(changeEmail);
      objs.add(acc);
      objs.add(email);
      outToServer.writeObject(objs);
    }

    public void loginAccount(String name, String password, String loginAccount)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(loginAccount);
      objs.add(name);
      objs.add(password);
      outToServer.writeObject(objs);
    }

    public void createAccount(String name, String password, String email, String createAccount)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(createAccount);
      objs.add(name);
      objs.add(password);
      objs.add(email);
      outToServer.writeObject(objs);
    }
  }
