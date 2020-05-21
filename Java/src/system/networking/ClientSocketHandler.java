package system.networking;

import javafx.application.Platform;
import system.transferobjects.ClassName;
import system.transferobjects.Container;
import system.transferobjects.login.Account;
import system.transferobjects.login.Group;

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

  /**
   * An infinite loop that is listening for Server Response.
   * The incoming request is casted to a Container. The container has
   * two attributes:  object and  identifier(ClassName). The switch statement will check
   * the request identifier
   */
  @Override public void run()
  {
    try
    {
      while (true)
      {
        System.out.println("cliensocket run");
        Container inDataPack = (Container) inFromServer.readObject();

        System.out.println(inDataPack.getClassName() + "classname");
        switch (inDataPack.getClassName())
        {
          case CREATE_ACCOUNT:
            boolean objs = (boolean) inDataPack.getObject();

            System.out.println("clientrunning");

            System.out.println(objs);
            Platform.runLater(() -> {

              socketClient.createAccountInfo(objs);
            });

            System.out.println("socketclienten method");

            break;
          case LOGIN_RESPONSE:
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            System.out.println((boolean) m.get(0));
            Platform.runLater(() -> {

              socketClient.loginInfo(inDataPack);
            });

            break;
          }
          case SEARCH_GROUP:
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();

            Platform.runLater(() -> {
              socketClient.searchGroupInfo(inDataPack);
            });

            break;
          }

        }

      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public void removeUser(Account ac) throws IOException
  {
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(ac);
    Container outDataPack = new Container(objs, ClassName.REMOVE_USER);
    outToServer.writeObject(outDataPack);
  }

  public void searchGroup(int id, String user) throws IOException
  {
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(id);
    objs.add(user);
    Container outDataPack = new Container(objs, ClassName.SEARCH_GROUP);
    outToServer.writeObject(outDataPack);
  }

  /**
   * Appends the username and password to an ArrayList. Afterwords
   * a Container is created containing the created ArrayList and an identifier(ClassName).
   * The container is send to the server
   *
   * @param username String containing the username
   * @param password String containing the password
   * @throws IOException exceptions produced by failed or interrupted I/O operations.
   */
  public void checkLogin(String username, String password) throws IOException
  {
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(username);
    objs.add(password);
    Container outDataPack = new Container(objs, ClassName.CHECK_LOGIN);

    outToServer.writeObject(outDataPack);
  }

  public void changePassword(Account acc, String oldPassword) throws IOException
  {
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(acc);
    objs.add(oldPassword);
    Container outDataPack = new Container(objs,
        ClassName.CHECK_PASSWORD_CHANGE);
    outToServer.writeObject(outDataPack);
  }

  public void joinGroup(Account acc, Group g) throws IOException
  {
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(acc);
    objs.add(g);
    Container outDataPack = new Container(objs, ClassName.JOIN_GROUP);
    outToServer.writeObject(outDataPack);
  }

  public void createGroup(Account acc, String groupName) throws IOException
  {
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(acc);
    objs.add(groupName);
    Container outDataPack = new Container(objs, ClassName.CREATE_GROUP);
    outToServer.writeObject(outDataPack);
  }

  /**
   * Appends the email to an ArrayList. Afterwords
   * a Container is created containing the created ArrayList and an identifier(ClassName).
   * The container is send to the server
   *
   * @param email String containing the email
   * @throws IOException exceptions produced by failed or interrupted I/O operations
   */
  public void recoverPassword(String email) throws IOException
  {
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(email);
    Container outDataPack = new Container(objs, ClassName.RECOVER_PASSWORD);
    outToServer.writeObject(outDataPack);
  }

  public void changeEmail(Account acc, String email) throws IOException
  {
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(acc);
    objs.add(email);
    Container outDataPack = new Container(objs, ClassName.CHECK_EMAIL_CHANGE);
    outToServer.writeObject(outDataPack);
  }

  /**
   * Appends the username and password to an ArrayList. Afterwords
   * a Container is created containing the created ArrayList and an identifier(ClassName).
   * The container is send to the server
   *
   * @param username String containing the username
   * @param password String containing the password
   * @param email    String containing the email
   * @throws IOException exceptions produced by failed or interrupted I/O operations.
   */
  public void createAccount(String username, String password, String email)
      throws IOException
  {
    System.out.println("clientsockethandler");
    ArrayList<Object> objs = new ArrayList<>();

    objs.add(username);
    objs.add(password);
    objs.add(email);
    Container outDataPack = new Container(objs, ClassName.CREATE_ACCOUNT);
    outToServer.writeObject(outDataPack);

  }
}
