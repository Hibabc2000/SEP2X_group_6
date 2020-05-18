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

         Object obj = inFromServer.readObject();
         Container inDataPack = (Container) obj;
         switch (inDataPack.getClassName())
         {
           case "accArrayList":
             ArrayList<Object> objs = (ArrayList<Object>)inDataPack.getObject();
             String type = (String) objs.get(0);
             System.out.println("clientrunning");
             System.out.println(type);
             if(type.equals("createAccount")) {
               System.out.println(((ArrayList<Object>) obj).get(1));
               boolean ac = (boolean) objs.get(1);
               socketClient.createAccountInfo(ac);

               System.out.println("socketclienten method");
             }
             break;
         }

       }
     }
     catch (IOException | ClassNotFoundException e)
     {
       e.printStackTrace();
     }
    }

    public void removeUser(Account ac, String remove) throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(remove);
      objs.add(ac);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void searchGroup(int id, String user, String searchGroup)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(searchGroup);
      objs.add(id);
      objs.add(user);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void joinGroupAsPlayer(Account acc, String groupname, String joinGroup)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(joinGroup);
      objs.add(acc);
      objs.add(groupname);

      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void checkAccountUniqueness(String username, String password, String email, String checkAccount)
        throws IOException
    { System.out.println("clientcheck3");
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkAccount);
      objs.add(username);
      objs.add(password);
      objs.add(email);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void checkLogin(String username, String password, String checkLogin)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkLogin);
      objs.add(username);
      objs.add(password);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void checkEmail(String email, String checkEmail) throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkEmail);
      objs.add(email);

      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void checkPasswordChangeInformation(Account acc, String newPassword, String oldPassword,
        String checkPasswordChange) throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkPasswordChange);
      objs.add(acc);
      objs.add(newPassword);
      objs.add(oldPassword);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void checkEmailChangeInformation(Account acc, String email, String checkEmailChange)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(checkEmailChange);
      objs.add(acc);
      objs.add(email);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void joinGroup(Account acc, Group g, String joinGroup)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(joinGroup);
      objs.add(acc);
      objs.add(g);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void createGroup(Account acc, String groupName, String createGroup)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(createGroup);
      objs.add(acc);
      objs.add(groupName);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void recoverPassword(String email, String recoverPassword)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(recoverPassword);
      objs.add(email);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void changePassword(Account acc, String newPassword, String changePassword)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(changePassword);
      objs.add(acc);
      objs.add(newPassword);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void changeEmail(Account acc, String email, String changeEmail)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(changeEmail);
      objs.add(acc);
      objs.add(email);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void loginAccount(String name, String password, String loginAccount)
        throws IOException
    {
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(loginAccount);
      objs.add(name);
      objs.add(password);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);
    }

    public void createAccount(String name, String password, String email, String createAccount)
        throws IOException
    {
      System.out.println("clientsockethandler");
      ArrayList<Object> objs = new ArrayList<>();
      objs.add(createAccount);
      objs.add(name);
      objs.add(password);
      objs.add(email);
      Container outDataPack = new Container(objs, "accArrayList");
      outToServer.writeObject(outDataPack);

    }
  }
