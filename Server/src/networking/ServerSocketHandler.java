package networking;

import Database.GetAllAccountData;
import system.model.loginModel.Account;
import system.networking.Container;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerSocketHandler implements Runnable
{
  private ConnectionPool pool;
  private Socket socket;

  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;
  private GetAllAccountData database;


  private Account account;


  public ServerSocketHandler(Socket socket, ConnectionPool pool, GetAllAccountData gaa)
      throws IOException
  {
    database = gaa;
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
        System.out.println("servercheck1");

        Container inDataPack = (Container)inFromClient.readObject();

          switch (inDataPack.getClassName())
          {

            case "createAccount":
            {
              ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
              System.out.println(m.get(0));
              System.out.println("serversockethangler");
              boolean unique = false;
              String name = (String) (m).get(0);
              String password = (String) (m).get(1);
              String email = (String) (m).get(2);
              try
              {
                unique = database.checkAccountUniqueness(name, email);
              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }
              if (unique)
              {
                try
                {
                  database.createAccount(name, password, email);
                }
                catch (SQLException e)
                {
                  e.printStackTrace();
                }
              }

              Container outDataPack = new Container(unique, "createAccount");
              sendBackInformationAboutAccountCreation(outDataPack);
           break;
            }
            case "changeEmail":
            {
              ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
              Account account = (Account) (m.get(0));
              String email = (String) (m.get(1));
                 break;
            }
            case "recoverPassword":
          {  ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            String email = (String) (m.get(0));
          break;
          }
            case "createGroup":
          {  ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Account account = (Account) (m.get(0));
            String groupname = (String) (m.get(1));
            break;
          }
            case "checkEmailChange":
          {ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Account account = (Account) (m.get(0));
            String email = (String) (m.get(1));
           break;
          }
            case "checkPasswordChange":
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Account account = (Account) (m.get(0));
            String newPassword = (String) (m.get(1));
            String oldPassword = (String) (m.get(2));
          break;
          }
            case "checkLogin":
          {ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            boolean answer = false;
            String username = (String) (m.get(0));
            String password = (String) (m.get(1));
            try
            {
              database.checkLogin(username, password);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            if (answer)
            {
              database.acceptLogin();
            }
            ArrayList<Object> objs = new ArrayList<>();
            objs.add("createAccount");
            objs.add(answer);

            Container outDataPack = new Container(objs,"accArrayList");
            sendBackInformationAboutAccountCreation(outDataPack);
                break;
          }
            case "checkAccount":
          {ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            String username = (String) (m).get(0);
            String password = (String) (m).get(1);
            String email = (String) (m).get(2);

            // datbase something
                  break;
          }
          case "joinGroup":
          {ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Account ac = (Account) (m.get(0));
            String groupname = (String) (m.get(1));
          break;
          }
            case "searchGroup":
          {ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            int id = (int) (m.get(0));
            String usernameToCheckWithDMgroup = (String) (m.get(1));
          break;
          }

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
  public void  sendBackInformationAboutAccountCreation(Object ob)
  {
    try
    {

      outToClient.writeObject(ob);
      System.out.println("sendbackfromservertoclient");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
