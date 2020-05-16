package system.Server;

import system.Client.ClientSocketHandler;
import system.Server.Database.ConnectDBC;
import system.model.loginModel.Account;

import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketHandler implements Runnable
{
  private ConnectionPool pool;
  private Socket socket;

  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;
  private ConnectDBC database;

  private Account account;


  public ServerSocketHandler(Socket socket, ConnectionPool pool, ConnectDBC dtbs)
      throws IOException
  {
    database = dtbs;
this.socket = socket;
this.pool = pool;
inFromClient = new ObjectInputStream(socket.getInputStream());
outToClient = new ObjectOutputStream(socket.getOutputStream());


  }

  @Override public void run()
  {
    try

    {
      while (true)
      { System.out.println("servercheck1");
        Object obj = inFromClient.readObject();
        ArrayList<Object> m = (ArrayList<Object>) obj;
        System.out.println(m.get(0));
        if (m.get(0).equals("createAccount"))
        {
          String name = (String) (m).get(1);
          String password = (String) (m).get(2);
          String email = (String) (m).get(3);
          database.InsertAccount(name,password,email);
        }
           else if (m.get(0).equals("changeEmail"))
        {
          Account account = (Account) (m.get(1));
          String email = (String) (m.get(2));
          // dataase
        }
        else if (m.get(0).equals("recoverPassword"))
        {
          String email = (String) (m.get(1));
        }
        else if (m.get(0).equals("createGroup"))
        {
          Account account = (Account) (m.get(1));
          String groupname = (String) (m.get(2));
        }
        else if (m.get(0).equals("checkEmailChange"))
        {
          Account account = (Account) (m.get(1));
          String email = (String) (m.get(2));
        }
        else if (m.get(0).equals("checkPasswordChange"))
        {

          Account account = (Account) (m.get(1));
          String newPassword = (String) (m.get(2));
          String oldPassword = (String) (m.get(3));
        }
        else if (m.get(0).equals("checkLogin"))
        {
          String username = (String) (m.get(1));
          String password = (String) (m.get(2));
        }
        else if (m.get(0).equals("checkAccount"))
        {
          String username = (String) (m).get(1);
          String password = (String) (m).get(2);
          String email = (String) (m).get(3);

          // datbase something


        }
        else if (m.get(0).equals("joinGroup"))
        {
          Account ac = (Account)(m.get(1));
          String groupname = (String) (m.get(2));
        }
        else if (m.get(0).equals("searchGroup"))
        {
          int id = (int) (m.get(1));
          String usernameToCheckWithDMgroup = (String) (m.get(2));
        }
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      try
      {
        pool.removeHandler(this);
        socket.close();
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }

  }
}
