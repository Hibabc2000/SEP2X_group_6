package networking;

import Database.GetAllAccountData;
import Database.InsertCharacter;
import Database.LoadCharacter;
import system.model.businessModel.Character;
import system.transferobjects.ClassName;
import system.transferobjects.Container;
import system.transferobjects.login.Account;
import system.transferobjects.login.Group;
import system.transferobjects.login.Player;

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
  private InsertCharacter ich;
  private LoadCharacter loch;

  private Account account;

  public ServerSocketHandler(Socket socket, ConnectionPool pool,
      GetAllAccountData gaa, InsertCharacter i, LoadCharacter lc) throws IOException
  {
    loch = lc;
    ich = i;
    database = gaa;
    this.socket = socket;
    this.pool = pool;
    inFromClient = new ObjectInputStream(socket.getInputStream());
    outToClient = new ObjectOutputStream(socket.getOutputStream());

  }

  /**
   * An infinite loop that is listening for client requests.
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
        System.out.println("servercheck1");

        Container inDataPack = (Container) inFromClient.readObject();

        switch (inDataPack.getClassName())
        {

          case CREATE_ACCOUNT:
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
//              Check account uniqueness in the database
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
//                create the account in the database
                database.createAccount(name, password, email);
                account = new Account(name,password,email);
                pool.userJoin(account);
                pool.addHandler(this);
                Container outDataPack = new Container(unique,
                    ClassName.CREATE_ACCOUNT);
                sendBackData(outDataPack);
              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }
            }else{
              ArrayList<Object> objs=new ArrayList();
              objs.add(unique);
              Container datapack=new Container(objs, ClassName.CREATE_ACCOUNT);
              sendBackData(datapack);
            }
            break;
          }
          case CHECK_EMAIL_CHANGE:
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            boolean answer= true;
            Container dataPack =null;
            String email = (String) (m.get(0));
            String username =(String) (m.get(1));
            System.out.println("ez történik");
            try
            {
              dataPack = database.checkChangeEmail(email);
               answer = (boolean)((ArrayList<Object>)dataPack.getObject()).get(0);
               dataPack.setClassName(ClassName.CHECK_EMAIL_CHANGE);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            if(answer)
            {
              try
              {
                dataPack = database.changeEmail(email,username);
               dataPack.setClassName(ClassName.CHECK_EMAIL_CHANGE);
              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }
            }
            sendBackData(dataPack);

          }
          case RECOVER_PASSWORD:
          {
            Container outDataPack = null;
            boolean answer = false;
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            String email = (String) (m.get(0));
            try
            {
//              Check the email in the database
              answer = database.checkEmail(email);

              if (answer)
              {
                outDataPack = database.recoverPassword(email);
                sendBackData(outDataPack);
              }
              else if (!answer)
              {
                outDataPack = new Container(answer, ClassName.RECOVER_PASSWORD_RESPONSE);
                sendBackData(outDataPack);
              }
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }

            break;
          }
          case CREATE_GROUP:
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Account account = (Account) (m.get(0));
            String groupname = (String) (m.get(1));

            try
            {
               database.createGroup(account,groupname);
              Container dataPack = database.bringBackTheGroupAfterCreation(account,groupname);
              sendBackData(dataPack);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            break;
          }

          case CHECK_PASSWORD_CHANGE:
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Account account = (Account) (m.get(0));
            String newPassword = account.getPassword();
            try
            {
//              change the password in the database
              database.changePassword(account,newPassword);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            break;
          }
          case CHECK_LOGIN:
          {
            Container dataPack = null;
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            boolean answer = false;
            String username = (String) (m.get(0));
            String password = (String) (m.get(1));

            try
            {
              System.out.println("checking the login in serveecoscket");
              dataPack = database.checkLogin(username, password);
              answer = (boolean) ((ArrayList<Object>) dataPack.getObject())
                  .get(0);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            if (answer)
            {
              try
              {
                System.out.println("if answer true,");
//                dataPack contains an obj with the acc data/groups
                dataPack = database.acceptLogin(username, password);
                sendBackData(dataPack);
                account = (Account) ((ArrayList<Object>)(ArrayList<Object>) dataPack.getObject()).get(1);
                pool.userJoin(account);
                pool.addHandler(this);

              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }
            }
            else if (!answer)
            {
              System.out.println("if answ not true");
              sendBackData(dataPack);
            }

            break;
          }

          case JOIN_GROUP:
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Account ac = (Account) (m.get(0));
            Group group = (Group) (m.get(1));
            try
            {
              database.addPlayerToGroup(ac,group);
             Group gro=  database.getGroupForUpdate(group.getId());
              pool.addPlayerToGroup(gro);

            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            break;
          }
          case SEARCH_GROUP:
          {
            Container dataPack = null;
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            int id = (int) (m.get(0));
            boolean isItValid = false;
            try
            {
              isItValid = database.searchGroup(id);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            if (isItValid)
            {
              try
              {

                dataPack = database.getGroup(id);

                sendBackData(dataPack);
              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }

            }
            else
            {
              ArrayList<Object> obj = new ArrayList<Object>();
              obj.add(isItValid);
              dataPack = new Container(obj, ClassName.SEARCH_GROUP);
              sendBackData(dataPack);
            }
            break;
          }
          case REMOVE_USER:
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Account user = (Account) (m.get(0));

            break;

          }

          case START_GAME:
          {
            ArrayList<Object> m =(ArrayList<Object>)inDataPack.getObject();
            Group groupToStartGameWith = (Group)m.get(0);
            // here I go throught the players who are part of this group AND Online and put them in an arraylist
           ArrayList<Player> playersOnline =  pool.selectTheOnesThatAreOnlineInThePool(groupToStartGameWith);


            boolean doIhaveACharacter = false;


           for(int i=0;i<playersOnline.size();i++)
           {// here If the player doesnt have a charID, then we will send him a boolean "false" so the client will know that means
             // we have to create a character.
             if(playersOnline.get(i).getCharacterID()==null)
             {  ArrayList<Object> objs = new ArrayList<>();
             doIhaveACharacter = false;
               objs.add(doIhaveACharacter);
               Container data = new Container(objs,ClassName.START_GAME_PLAYER);
               pool.sendDataToUser(playersOnline.get(i).getName(),data);
             }
             // here if the player has a charID then we actually get back the character from the dbs, and send that back to him
             else if(playersOnline.get(i).getCharacterID()!=null)
             { doIhaveACharacter =true;
               ArrayList<Object> objs = new ArrayList<>();
               Character characterFromDBS =  loch.loadCharacter(playersOnline.get(i).getCharacterID());
               Player playerWithChar = playersOnline.get(i);
               playerWithChar.setCharacter(characterFromDBS);
               objs.add(doIhaveACharacter);
               objs.add(playerWithChar);
               Container data = new Container(objs,ClassName.START_GAME_PLAYER);
               pool.sendDataToUser(playersOnline.get(i).getName(),data);
               // data to DM
               playersOnline.get(i).setCharacter(characterFromDBS);
             }
           }
           // after the loop is done an all the players have been updated with characters, then we send this arraylist back to the DM.
            ArrayList<Object> objs = new ArrayList<>();
           objs.add(playersOnline);
            Container playerAndCharacterDataForDM = new Container(objs,ClassName.START_GAME_DM);
            sendBackData(playerAndCharacterDataForDM);

          }
          case CREATE_CHARACTER:
          { // this is when a player creates his character
             Integer id =0;
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
             String username = (String)m.get(0);
             Group gp = (Group)m.get(1);
             Character character = (Character)m.get(2);
           // here we first load the character in the database;
            try
            {
              ich.insertCharacter(character);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            // here we get the character ID from the database, so we can update the groups
            // with the username of the player and the groupID, since we don't know the char ID yet.
            try
            {
             id = loch.getIDOfTheNewlyCreatedCharacter(gp.getId(),username);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            // here we update the player charID in the groups
            if(id!=0)
            {
              try
              {
                database.updateGroupsAfterCharacterCreation(gp.getId(),username,id);
              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }
            }

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

  /** returns an accounts variable
   *
   * @return Account
   */
  public Account  getAccount()
  {
    return account;
  }

  /**
   * Send a response to the Client
   *
   * @param ob Object containing the response
   */
  public void sendBackData(Object ob)
  {
    try
    {
      outToClient.writeObject(ob);
      System.out.println("sendbackfromservertoclientlogin");
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
