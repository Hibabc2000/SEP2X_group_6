package networking;

import Database.*;
import system.model.businessModel.Character;
import system.model.characterClasses.CharacterClass;
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
      GetAllAccountData gaa, InsertCharacter i, LoadCharacter lc)
      throws IOException
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
                account = new Account(name, password, email);
                pool.userJoin(account);
                pool.addHandler(this);
                Container outDataPack = new Container(unique,
                    ClassName.CREATE_ACCOUNT);
                sendBackData(outDataPack);
                GetCoreFromDatabase gcfd = new GetCoreFromDatabase();

                sendBackData(gcfd.loadDatabase());
              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }
            }
            else
            {

              Container datapack = new Container(unique, ClassName.CREATE_ACCOUNT);
              sendBackData(datapack);
            }
            break;
          }
          case CHECK_EMAIL_CHANGE:
          {
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            boolean answer = true;
            Container dataPack = null;
            String email = (String) (m.get(0));
            String username = (String) (m.get(1));

            try
            {
              dataPack = database.checkChangeEmail(email);
              answer = (boolean) ((ArrayList<Object>) dataPack.getObject()).get(0);
              dataPack.setClassName(ClassName.CHECK_EMAIL_CHANGE);
            }
            catch (SQLException e)
            {
              e.printStackTrace();
            }
            if (answer)
            {
              try
              {
                dataPack = database.changeEmail(email, username);
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
              database.createGroup(account, groupname);
              Container dataPack = database
                  .bringBackTheGroupAfterCreation(account, groupname);
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

            Account accu = (Account) inDataPack.getObject();
            System.out.println(accu.getPassword()+ " this is pass");
            String newPassword = accu.getPassword();
            try
            {
              //              change the password in the database
              database.changePassword(accu, newPassword);
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
                account = (Account) ((ArrayList<Object>) (ArrayList<Object>) dataPack
                    .getObject()).get(1);
                pool.userJoin(account);
                pool.addHandler(this);
                GetCoreFromDatabase gcfd = new GetCoreFromDatabase();
                Container staticmod = gcfd.loadDatabase();
                sendBackData(staticmod);

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
              database.addPlayerToGroup(ac, group);
              Group gro = database.getGroupForUpdate(group.getId());
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
            ArrayList<Object> m = (ArrayList<Object>) inDataPack.getObject();
            Group groupToStartGameWith = (Group) m.get(0);
            // here I go through the players who are part of this group AND Online and put them in an arraylist
            ArrayList<Player> playersOnline = pool.selectTheOnesThatAreOnlineInThePool(groupToStartGameWith);

            boolean doIhaveACharacter = false;
            pool.getUserAccount(groupToStartGameWith.getDM().getName());
            pool.getGroups(groupToStartGameWith);
            System.out.println("wtf???wtf?wt?F?WTF?WTwF?");
            System.out.println(playersOnline.get(0).getCharacterID() + " this is the ID which should be null");
            System.out.println("wtf???wtf?wt?F?WTF?WTwF?");
            for (int i = 0; i < playersOnline.size(); i++)
            {// here If the player doesnt have a charID, then we will send him a boolean "false" so the client will know that means
              // we have to create a character.
              pool.getUserAccount(playersOnline.get(i).getName());
              if (playersOnline.get(i).getCharacterID() == null)
              {
                doIhaveACharacter = false;

                Container data = new Container(doIhaveACharacter, ClassName.CLIENT_PLEASE_CREATE_A_CHARACTER);
                pool.sendDataToUser(playersOnline.get(i).getName(), data);
                Container dataForDM = new Container(true, ClassName.CLIENT_PLEASE_CREATE_A_CHARACTER);
                pool.sendDataToUser(groupToStartGameWith.getDM().getName(),dataForDM);
              }
              // here if the player has a charID then we actually get back the character from the dbs, and send that back to him
              else if (playersOnline.get(i).getCharacterID() != null)
              {
                System.out.println("THIS SHOULD ABSOLUTELY NOT HAPPEN");
                doIhaveACharacter = true;
                ArrayList<Object> objs = new ArrayList<>();
                Character characterFromDBS = loch
                    .loadCharacter(playersOnline.get(i).getCharacterID());
                Player playerWithChar = playersOnline.get(i);
                playerWithChar.setCharacter(characterFromDBS);

                Container data = new Container(characterFromDBS, ClassName.CHARACTER);

                pool.sendDataToUser(playersOnline.get(i).getName(), data);

                // data to DM

                pool.sendDataToUser(groupToStartGameWith.getDM().getName(), data);
              }

            }

           break;

          }
          case CHARACTER:
          { // HAS 2 parts,  first part when a character is created, and the second if it is just an update to an already existing one.
             ArrayList wtf = (ArrayList) inDataPack.getObject();
            System.out.println("ez most komolyan mi? "+wtf.get(0) +"\n ez mi?");
            System.out.println("hm?");
            Character character = (Character) inDataPack.getObject();

            Integer id = null;
            if (character.getId() == null)
            {

              Character characterBackToClient = null;
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
                id = loch.getIDOfTheNewlyCreatedCharacter(character.getGroupID(),
                    character.getUsername());
                characterBackToClient = loch.loadCharacter(id);
                Container data = new Container(characterBackToClient, ClassName.CHARACTER);
                String dmOfTheGroup = database.getDMofAGroup(character.getGroup());
                sendBackData(data);

                pool.sendDataToUser(dmOfTheGroup, data);
              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }
              // here we update the player charID in the groups
              if (id != null)
              {
                try
                {
                  database.updateGroupsAfterCharacterCreation(character.getGroupID(),
                      character.getUsername(), id);
                }
                catch (SQLException e)
                {
                  e.printStackTrace();
                }
              }
            }
            else if (character.getId() != null)
            {

              try
              {
                ich.updateCharacter(character);
                Character charToDM = loch.loadCharacter(character.getId());
                String dmOfTheGroup = database.getDMofAGroup(character.getGroup());
                Container charToDMData = new Container(charToDM, ClassName.CHARACTER);
                pool.sendDataToUser(dmOfTheGroup, charToDMData);

              }
              catch (SQLException e)
              {
                e.printStackTrace();
              }

            }

            break;
          }
          case CLASSES_LOAD:
          {
            Account a = getAccount();
            LoadCharacterClasses loader = new LoadCharacterClasses();
            ArrayList<CharacterClass> ret = loader.load();
            Container cont = new Container(ret, ClassName.CLASSES_LOAD);
            pool.sendDataToUser(getAccount().getUsername(), cont);
            break;
          }
        }
      }
    }
    catch (IOException | ClassNotFoundException | SQLException e)
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

  /**
   * returns an accounts variable
   *
   * @return Account
   */
  public Account getAccount()
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
