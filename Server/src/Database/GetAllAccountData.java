package Database;

import system.transferobjects.ClassName;
import system.transferobjects.Container;
import system.transferobjects.login.Account;
import system.transferobjects.login.DM;
import system.transferobjects.login.Group;
import system.transferobjects.login.Player;

import java.sql.*;
import java.util.ArrayList;

public class GetAllAccountData
{
  private Connection c;
  private ArrayList<Account> accounts;
  private ArrayList<ArrayList<Integer>> ids;
  private ArrayList<Group> groups;

  public GetAllAccountData()
  {
    accounts = new ArrayList<>();
    ids = new ArrayList<ArrayList<Integer>>();
    groups = new ArrayList<>();
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2", "postgres",
              "123456");
//      almafast325
    }
    catch (SQLException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  /**
   * Creates an SQL statement, if the username or email is found in the database
   * the method will return a boolean false. If they are not in the database the
   * credentials are unique and the method will return a boolean true
   *
   * @param username String containing the username
   * @param email    String containing the email
   * @return boolean true if the account is unique and false if it is not
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   */
  public boolean checkAccountUniqueness(String username, String email)
      throws SQLException
  {
    boolean unique = false;
    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Users\".\"Users\" WHERE  username  = '" + username
            + "' OR email ='" + email + "' ;";

    ResultSet rs = st.executeQuery(query);
    String userame = null;
    String ema = null;
    while (rs.next())
    {
      userame = rs.getString("username");
      ema = rs.getString("email");
      System.out.println("name = " + userame);
      System.out.println("email = " + ema);
      if (userame != null || ema != null)
      {
        System.out.println(unique);
        break;
      }
      System.out.println(unique);
    }
    if (userame == null && ema == null)
    {
      unique = true;
      System.out.println(unique);
    }
    return unique;
  }



  /**
   * Creates an SQL statement that will create an account in the Database
   *
   * @param username String containing the username
   * @param password String containing the password
   * @param email    String containing the email
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   */
  public void createAccount(String username, String password, String email)
      throws SQLException
  {
    boolean done = false;
    Statement st = c.createStatement();
    String query =
        "INSERT INTO  \"Users\".\"Users\" VALUES( '" + username + "', '"
            + password + "', null, '" + email + "') ";

    st.executeUpdate(query);

  }
  /**
   * Creates an SQL statement that will update a group and a user in the Database
   *
   * @param ac Account containing user information.
   * @param gp Group containing the information about the group.
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   */
  public void addPlayerToGroup(Account ac,Group gp) throws SQLException
  {
    Statement st = c.createStatement();
    String query =
        "UPDATE \"Groups\".\"Groups\" SET \"usernamePlayers\" = \"usernamePlayers\" || '{"+ac.getUsername()+"}', \"characterIDs\"= \"characterIDs\" || '{null}'  WHERE id = " + gp.getId() + ";";

    st.executeUpdate(query);
    Statement mt = c.createStatement();
    String curry = "UPDATE \"Users\".\"Users\" SET \"groupIDs\" = \"groupIDs\" || '{"+gp.getId()+"}' WHERE username = '" + ac.getUsername() + "' ;";
    mt.executeUpdate(curry);

  }

  /**
   * Creates an SQL statement that checks if the username and password are found in
   * the database. If the credentials are found a Container will be created containing the
   * answer(true), otherwise the answer will be false
   *
   * @param username String containing the username
   * @param password String containing the password
   * @return a container that has the answer(boolean) from the database
   * @throws SQLException An exception that provides information on a database
   *                      access error or other errors.
   */
  public Container checkLogin(String username, String password)
      throws SQLException

  {
    boolean answer = false;

    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Users\".\"Users\" WHERE  username  = '" + username
            + "' AND password ='" + password + "' ;";

    ResultSet rs = st.executeQuery(query);
    String userame = null;
    String ema = null;
    String pass = null;

    while (rs.next())
    {
      userame = rs.getString("username");
      pass = rs.getString("password");
      ema = rs.getString("email");

      System.out.println("name = " + userame);
      System.out.println("email = " + ema);

      if (userame != null && password != null)
      {
        answer = true;
        System.out.println("ans1" + answer);
        break;
      }

    }
    System.out.println("ans3" + answer);
    ArrayList<Object> obj = new ArrayList<>();
    obj.add(answer);
    Container datapack = new Container(obj, ClassName.LOGIN_RESPONSE);
    return datapack;
  }

  /**
   * Creates an SQL statement that will get the account information and the groups, that
   * the user is part of , from the database.
   * @param username String containing the username
   * @param password String containing the password
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   * @returns Container that contains a boolean true stating that the login was successfull, the account of the user and an ArrayList of groups.
   */
  public Container acceptLogin(String username, String password)
      throws SQLException
  {
    Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
    String query ="SELECT u.username, u.password, u.email, u.\"groupIDs\", g.name, g.id, g.\"usernameDM\", g.\"usernamePlayers\", g.\"characterIDs\" FROM \"Groups\".\"Groups\" g, \"Users\".\"Users\" u     WHERE u.username = '"+username +"' AND u.password= '"+password +"' AND u.\"groupIDs\" IS NOT NULL  AND  g.id IN (select(unnest(u.\"groupIDs\")));";

    ResultSet rs = st.executeQuery(query);

    boolean doesAccountHaveGroups=true;
    String userame = null;
    String ema = null;
    String pass = null;



    if(!rs.next())
    {
      doesAccountHaveGroups = false;
      query =
          "SELECT * FROM \"Users\".\"Users\" WHERE  username  = '" + username + "' AND password ='" + password + "' ;";
      rs = st.executeQuery(query);



    }
    rs.beforeFirst();


    ArrayList<Group> groupList = new ArrayList<>();

    ArrayList<String> plys = new ArrayList<>();
    ArrayList<Integer> charIDs = new ArrayList<>();

    while (rs.next())
    {
      userame = rs.getString("username");
      pass = rs.getString("password");
      ema = rs.getString("email");

      if(doesAccountHaveGroups==false) {
        break;}





      String k = rs.getString("usernamePlayers");
      String charid = rs.getString("characterIDs");
      Group ng = null;
      ng  = new Group(rs.getString("name"), rs.getInt("id"));
      ng.addDM(new DM(rs.getString("usernameDM")));
      if(k!=null)
      {
        plys = sqlArrayToArrayListString(k);

        charIDs = sqlArrayToArrayListInteger(charid);

        for (int i = 0; i < plys.size(); i++)
        {
          if(plys.get(i)!=null)
          {
            Player a = new Player(plys.get(i));

              if(charIDs.get(i)!=0)
            { a.addCharacterID(charIDs.get(i));
              System.out.println("char id for "+ a.getName() + " is: " +charIDs.get(i));} else {a.addCharacterID(null);}
            ng.addPlayer(a);
          }

        }
      }

      System.out.println("group : "+ng.toString());
      groupList.add(ng);


    }


    ArrayList<Object> objs = new ArrayList<>();
    boolean b = true; objs.add(b);
    Account acc = new Account(userame, password, ema);
    objs.add(acc);

    if(doesAccountHaveGroups)
    {
      objs.add(groupList);

    }



    Container dataPack = new Container(objs, ClassName.LOGIN_RESPONSE);
    return dataPack;

  }

  /**
   * Just a parser to change sql Arrays to ArrayList of integers.
   * @param ar String
   * @return ArrayList<Integer>
   */
  public ArrayList<Integer> sqlArrayToArrayListInteger(String ar)
  {
    ArrayList<Integer> temp = new ArrayList<>();
    String[] ara = ar.split("\\{");
    String part2 = ara[1];
    String[] h = part2.split("}");
    String o = h[0];
    String[] l = o.split(",");

    for (int i = 0; i < l.length; i++)
    { if(l[i].equals("NULL")) {l[i]="0";}
      temp.add(Integer.parseInt(l[i]));

    }
    return temp;
  }
  /**
   * Just a parser to change sql Arrays to ArrayList of Strings.
   * @param ar String
   * @return ArrayList<String>
   */
  public static ArrayList<String> sqlArrayToArrayListString(String ar)
  {
    ArrayList<String> temp = new ArrayList<>();
    System.out.println("This is the array of usernames:"+ar);

    String[] ara = ar.split("\\{");
    String part2 = ara[1];
    String[] h = part2.split("}");
    String o = h[0];
    String[] l = o.split(",");

    for (int i = 0; i < l.length; i++)
    {
      temp.add(l[i]);

    }
    return temp;
  }
  /**
   * Creates an SQL statement that will search for a group and return whether it exists or not.
   * @param id int ID to search for the group
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   * @returns boolean stating true if the group exists, and false if otherwise.
   */
  public boolean searchGroup(int id) throws SQLException
  {
    boolean answer = false;

    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Groups\".\"Groups\" WHERE  id  = " + id + " ;";

    ResultSet rs = st.executeQuery(query);
    String nam = null;

    while (rs.next())
    {
      nam = rs.getString("name");

    }
    if (nam != null)
    {
      answer = true;
      System.out.println("ans1" + answer);

    }
    return answer;
  }
  /**
   * Creates an SQL statement that will get the group from the database
   * @param id int to search for the group.
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   * @returns Container containing the chosen group, and a boolean .
   */
  public Container getGroup(int id) throws SQLException
  {
    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Groups\".\"Groups\" WHERE  id  = " + id + " ;";
    ResultSet rs = st.executeQuery(query);

    Group thisIsAGroupForTheGroupWithTheIDOfWhatTheUserInsertedIntoTheMethodToFindThisGroupDoYouUnderstandThisMarin = null;

    ArrayList<String> plys = new ArrayList<>();
    ArrayList<Integer> charIDs = new ArrayList<>();

    while (rs.next())
    {

      String k = rs.getString("usernamePlayers"); String charid = rs.getString("characterIDs");

      thisIsAGroupForTheGroupWithTheIDOfWhatTheUserInsertedIntoTheMethodToFindThisGroupDoYouUnderstandThisMarin = new Group(
          rs.getString("name"), rs.getInt("id"));
      if(k!=null && charid!=null)
      {
        plys = sqlArrayToArrayListString(k);
        charIDs = sqlArrayToArrayListInteger(charid);

      for (int i = 0; i < plys.size(); i++)
      {

        Player a = new Player(plys.get(i));

        if (charIDs.get(i) != 0)
        {
          a.addCharacterID(charIDs.get(i));
          System.out.println("character id in getGroup:" + charIDs.get(i));
        }
        else
        {
          a.addCharacterID(null);
        }
        thisIsAGroupForTheGroupWithTheIDOfWhatTheUserInsertedIntoTheMethodToFindThisGroupDoYouUnderstandThisMarin
            .addPlayer(a);
      }



      }
      thisIsAGroupForTheGroupWithTheIDOfWhatTheUserInsertedIntoTheMethodToFindThisGroupDoYouUnderstandThisMarin
          .addDM(new DM(rs.getString("usernameDM")));

    }

    ArrayList<Object> objs = new ArrayList<>();
    boolean b = true;
    objs.add(b);

    objs.add(
        thisIsAGroupForTheGroupWithTheIDOfWhatTheUserInsertedIntoTheMethodToFindThisGroupDoYouUnderstandThisMarin);

    System.out.println("Group1 " + objs.get(0).toString());

    Container dataPack = new Container(objs, ClassName.SEARCH_GROUP);
    return dataPack;

  }
  /**
   * Checks the given {@param email} value in the database. If the user with this email
   * is found the method will return a true, otherwise false
   *
   * @param email String containing the email
   * @return boolean
   * @throws SQLException An exception that provides information on a database
   *                      access error or other errors
   */
  public boolean checkEmail(String email) throws SQLException
  {
    boolean response = false;
    String emails = null;
    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Users\".\"Users\" WHERE  email  = '" + email + "' ;";
    ResultSet rs = st.executeQuery(query);
    while (rs.next())
    {
      emails = rs.getString("email");
    }
    if (email == null)
    {
      response = false;
    }
    else
      response = true;
    return response;
  }

  /**
   * Creates an SQL statement that searches in the database the User by the given {@param email}.
   * Extracts the users password and appends it to an ArrayList and a boolean value true. Afterwords
   * a Container is created containing the created ArrayList and an identifier(ClassName).
   *
   * @param email String containing the email
   * @return a Container of objects(boolean true and account password)
   * @throws SQLException An exception that provides information
   *                      on a database access error or other errors.
   */
  public Container recoverPassword(String email) throws SQLException
  {
    String password = null;
    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Users\".\"Users\" WHERE  email  = '" + email + "' ;";
    ResultSet rs = st.executeQuery(query);
    while (rs.next())
    {
      password = rs.getString("password");
    }
    ArrayList<Object> objs = new ArrayList<>();
    boolean answer = true;
    objs.add(answer);
    objs.add(password);
    Container datapack = new Container(objs,
        ClassName.RECOVER_PASSWORD_RESPONSE);
    return datapack;
  }
  /**
   * Creates an SQL statement that will create a group in the database.
   * @param account Account containing user information.
   * @param groupname String containing the name of the group.
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   */
  public void createGroup(Account account, String groupname)
      throws SQLException
  {
    Statement st = c.createStatement();
    String query ="INSERT INTO  \"Groups\".\"Groups\" (\"name\",\"usernameDM\",\"usernamePlayers\",\"characterIDs\") VALUES ('" +groupname +"','"+account.getUsername()+"' , NULL,NULL);";

    st.execute(query);


  }
  /**
   * Creates an SQL statement that will get the newly created group's ID and update the user's groupID column with it.
   * @param account Account containing user information
   * @param groupname String containing the group name
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   * @returns Container containing the group in an Arraylist<Object>
   */
  public Container bringBackTheGroupAfterCreation(Account account, String groupname)
      throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Groups\".\"Groups\" WHERE name = '"+groupname+"' AND \"usernameDM\" = '"+account.getUsername()+"' AND id = (SELECT MAX (id) FROM \"Groups\".\"Groups\") ;";
ResultSet rs = st.executeQuery(query);
   Group gp = null;
   while(rs.next())
    {
      gp = new Group(groupname,rs.getInt("id"));
      gp.addDM(new DM(account.getUsername()));

    }

   ArrayList<Object> obj = new ArrayList<>();
   obj.add(gp);
    Statement mt = c.createStatement();
    String curry = "UPDATE \"Users\".\"Users\" SET \"groupIDs\" = \"groupIDs\" || '{"+gp.getId()+"}' WHERE username = '" + account.getUsername() + "' ;";
    mt.executeUpdate(curry);
   Container data = new Container(obj,ClassName.CREATE_GROUP);

   return data;
  }

  /**
   * Creates an SQL statement that UPDATED in the database the password {@param newPassword}. The username
   * is retrieved from the {@param account}.
   * @param account users account
   * @param newPassword String containing the new password
   * @throws SQLException  An exception that provides information
   *                       on a database access error or other errors.
   */
  public void changePassword(Account account, String newPassword)
      throws SQLException
  {
  String username= account.getUsername();
    System.out.println("acc password: " + newPassword);
    Statement st = c.createStatement();
    String query =
        "UPDATE \"Users\".\"Users\" SET password= '"+newPassword
            + "' WHERE  username  = '" + username + "' ;";
    st.executeUpdate(query);
  }
  /**
   * Creates an SQL statement that will get the group from the database.
   * @param id int containing the id of the group
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   * @returns Group retrieved from the database
   */
  public Group getGroupForUpdate(int id) throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Groups\".\"Groups\" WHERE id = "+ id +" ;";
    ResultSet rs = st.executeQuery(query);
    Group  geez = null;

   ArrayList<String> plys;
   ArrayList<Integer> charIDs;
    while (rs.next())
    {
      geez = new Group(rs.getString("name"),rs.getInt("id"));
      geez.addDM(new DM(rs.getString("usernameDM")));

      String k = rs.getString("usernamePlayers");
      plys = sqlArrayToArrayListString(k);

      String charid = rs.getString("characterIDs");
      charIDs = sqlArrayToArrayListInteger(charid);



      for (int i = 0; i < plys.size(); i++)
      {

        Player a = new Player(plys.get(i));

        if(charIDs.get(i)==0)
        {a.addCharacterID(null);} else if(charIDs.get(i)!=null){ a.addCharacterID(charIDs.get(i));} else {a.addCharacterID(null);}



        geez.addPlayer(a);
        System.out.println("database , join group method: " + a.getName() + " id of char "+ a.getCharacterID());
      }

    }

    return geez;
  }
  /**
   * Creates an SQL statement that will change the email of the user in the database
   * @param username String containing the username
   * @param email String containing the email.
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   * @returns Container containing a boolean stating that the email change was successful
   */
  public Container changeEmail(String email,String username) throws SQLException
  {

    Statement st = c.createStatement();
    String query =
        "UPDATE \"Users\".\"Users\" SET email = '"+ email
            + "' WHERE  username  = '" + username + "' ;";
     st.executeUpdate(query);
    boolean answer = true;
    Container dps = new Container(answer,ClassName.CHECK_EMAIL_CHANGE);
    return dps;
  }

  /**
   * Creates an SQL statement that will check whether the given email is in the database
   * @param email String containing the email
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   * @returns Container containing a boolean true if the email exists in the database, false if it does not.
   */

  public Container checkChangeEmail(String email) throws SQLException
  {
    boolean  answer = true;
    Statement st = c.createStatement();
    String query =
        "SELECT FROM \"Users\".\"Users\" WHERE email = '"+ email
            + "' ;";
    ResultSet rs = st.executeQuery(query);

    String ema = null;

    while (rs.next())
    {

      ema = rs.getString("email");

      System.out.println("email = " + ema);

      if (ema != null)
      {
        answer = false;
        System.out.println("ans1" + answer);
        break;
      }
    }
    System.out.println("ans3" + answer);
    ArrayList<Object> obj = new ArrayList<>();
    obj.add(answer);
    Container datapack = new Container(obj, ClassName.CHECK_EMAIL_CHANGE);
    return datapack;
  }

  /**
   * Creates an SQL statement that will update the a group after a character has been created.

   * @param username String containing the username
   * @param charID Integer containing the id of the character
   * @param  id int containing the id of the group.
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   */
  public void updateGroupsAfterCharacterCreation(int id, String username, Integer charID)
      throws SQLException
  {
    Statement st = c.createStatement();
    Group groupForUpdate = getGroupForUpdate(id);
    ArrayList<Player> arrayOfPlayers = groupForUpdate.getAllPlayers();
String curry = "";
    for(int i =0; i<arrayOfPlayers.size();i++)
    {
      if(arrayOfPlayers.get(i).getName().equals(username))
      {
       curry += charID;
      }
      else if(arrayOfPlayers.get(i).getCharacterID()!=null)
      {
        curry +=  arrayOfPlayers.get(i).getCharacterID();
      }
      else if(arrayOfPlayers.get(i).getCharacterID()==null)
      {
         curry +="NULL";
      }
      if(1<arrayOfPlayers.size()-1)
      {curry +=",";}
    }
    String query = "UPDATE \"Characters\".\"Characters\" SET \"characterIDs\"  = '{"+ curry +"}'  WHERE id =" + id +" ;" ;
    st.executeUpdate(query);
  }
  /**
   * Creates an SQL statement that will get the DM of a group from the database
   * @param group int containing the id of the group.
   * @throws SQLException an exception that provides information on a database
   *                      access error or other errors.
   * @returns String containing the name of the DM.
   */
  public String getDMofAGroup(int group) throws SQLException
  {
    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Groups\".\"Groups\" WHERE id = "+ group + " ;";
    ResultSet rs = st.executeQuery(query);
    String dmName = "";
    while(rs.next())
    {
      dmName = rs.getString("usernameDM");
    }
    return dmName;

  }
}
