package system.Server;

import system.Client.ClientSocketHandler;
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

  private Account account;


  public ServerSocketHandler(Socket socket, ConnectionPool pool)
      throws IOException
  {
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
      {
        Object obj = inFromClient.readObject();
        ArrayList<Object> m = (ArrayList<Object>) obj;
        if (((ArrayList<Object>) obj).get(0).equals("createAccount"))
        {
          String name = (String) ((ArrayList<Object>) obj).get(1);
          String password = (String) ((ArrayList<Object>) obj).get(2);
          String email = (String) ((ArrayList<Object>) obj).get(3);
          // datbase something
        }
        else if (((ArrayList<Object>) obj).get(0).equals("changeEmail"))
        {
          Account account = (Account) ((ArrayList<Object>) obj).get(1);
          String email = (String) ((ArrayList<Object>) obj).get(2);
          // dataase
        }
        else if (((ArrayList<Object>) obj).get(0).equals("recoverPassword"))
        {
          String email = (String) ((ArrayList<Object>) obj).get(1);
        }
        else if (((ArrayList<Object>) obj).get(0).equals("createGroup"))
        {
          Account account = (Account) ((ArrayList<Object>) obj).get(1);
          String groupname = (String) ((ArrayList<Object>) obj).get(2);
        }
        else if (((ArrayList<Object>) obj).get(0).equals("checkEmailChange"))
        {
          Account account = (Account) ((ArrayList<Object>) obj).get(1);
          String email = (String) ((ArrayList<Object>) obj).get(2);
        }
        else if (((ArrayList<Object>) obj).get(0).equals("checkPasswordChange"))
        {

          Account account = (Account) ((ArrayList<Object>) obj).get(1);
          String newPassword = (String) ((ArrayList<Object>) obj).get(2);
          String oldPassword = (String) ((ArrayList<Object>) obj).get(3);
        }
        else if (((ArrayList<Object>) obj).get(0).equals("checkLogin"))
        {
          String username = (String) ((ArrayList<Object>) obj).get(1);
          String password = (String) ((ArrayList<Object>) obj).get(2);
        }
        else if (((ArrayList<Object>) obj).get(0).equals("checkAccount"))
        {
          String username = (String) ((ArrayList<Object>) obj).get(1);
          String password = (String) ((ArrayList<Object>) obj).get(2);
          String email = (String) ((ArrayList<Object>) obj).get(3);

        }
        else if (((ArrayList<Object>) obj).get(0).equals("joinGroup"))
        {
          Account ac = (Account)((ArrayList<Object>) obj).get(1);
          String groupname = (String) ((ArrayList<Object>) obj).get(2);
        }
        else if (((ArrayList<Object>) obj).get(0).equals("searchGroup"))
        {
          int id = (int) ((ArrayList<Object>) obj).get(1);
          String usernameToCheckWithDMgroup = (String) ((ArrayList<Object>) obj).get(2);
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
