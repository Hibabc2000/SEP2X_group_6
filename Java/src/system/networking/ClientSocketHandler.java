package system.networking;

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
     try
     {
       while (true)
       {
         System.out.println("cliensocket run");
         Object obj = inFromServer.readObject();
         Container inDataPack = (Container) obj;
         System.out.println(inDataPack.getClassName() + "classname");
         switch (inDataPack.getClassName())
         {
           case "createAccount":
              boolean objs = (boolean)inDataPack.getObject();

             System.out.println("clientrunning");


               System.out.println(objs);

               socketClient.createAccountInfo(objs);

               System.out.println("socketclienten method");

             break;
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
      Container outDataPack = new Container(objs, "removeUser");
      outToServer.writeObject(outDataPack);
    }

    public void searchGroup(int id, String user)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(id);
      objs.add(user);
      Container outDataPack = new Container(objs, "searchGroup");
      outToServer.writeObject(outDataPack);
    }

    public void joinGroupAsPlayer(Account acc, String groupname)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(acc);
      objs.add(groupname);

      Container outDataPack = new Container(objs, "joinGroup");
      outToServer.writeObject(outDataPack);
    }

    public void checkAccountUniqueness(String username, String password, String email)
        throws IOException
    { System.out.println("clientcheck3");
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(username);
      objs.add(password);
      objs.add(email);
      Container outDataPack = new Container(objs, "checkAccount");
      outToServer.writeObject(outDataPack);
    }

    public void checkLogin(String username, String password)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(username);
      objs.add(password);
      Container outDataPack = new Container(objs, "checkLogin");
      outToServer.writeObject(outDataPack);
    }

    public void checkEmail(String email) throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(email);

      Container outDataPack = new Container(objs, "checkEmail");
      outToServer.writeObject(outDataPack);
    }

    public void checkPasswordChangeInformation(Account acc, String newPassword, String oldPassword) throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(acc);
      objs.add(newPassword);
      objs.add(oldPassword);
      Container outDataPack = new Container(objs, "checkPasswordChange");
      outToServer.writeObject(outDataPack);
    }

    public void checkEmailChangeInformation(Account acc, String email)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(acc);
      objs.add(email);
      Container outDataPack = new Container(objs, "checkEmailChange");
      outToServer.writeObject(outDataPack);
    }

    public void joinGroup(Account acc, Group g)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(acc);
      objs.add(g);
      Container outDataPack = new Container(objs, "joinGroup");
      outToServer.writeObject(outDataPack);
    }

    public void createGroup(Account acc, String groupName)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(acc);
      objs.add(groupName);
      Container outDataPack = new Container(objs, "createGroup");
      outToServer.writeObject(outDataPack);
    }

    public void recoverPassword(String email)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(email);
      Container outDataPack = new Container(objs, "recoverPassword");
      outToServer.writeObject(outDataPack);
    }

    public void changePassword(Account acc, String newPassword)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(acc);
      objs.add(newPassword);
      Container outDataPack = new Container(objs, "changePassword");
      outToServer.writeObject(outDataPack);
    }

    public void changeEmail(Account acc, String email)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(acc);
      objs.add(email);
      Container outDataPack = new Container(objs, "changeEmail");
      outToServer.writeObject(outDataPack);
    }

    public void loginAccount(String name, String password)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(name);
      objs.add(password);
      Container outDataPack = new Container(objs, "loginAccount");
      outToServer.writeObject(outDataPack);
    }

    public void createAccount(String name, String password, String email)
        throws IOException
    {
      System.out.println("clientsockethandler");
      ArrayList<Object> objs = new ArrayList<>();

      objs.add(name);
      objs.add(password);
      objs.add(email);
      Container outDataPack = new Container(objs, "createAccount");
      outDataPack.setClassName("createAccount");
      outToServer.writeObject(outDataPack);

    }
  }
