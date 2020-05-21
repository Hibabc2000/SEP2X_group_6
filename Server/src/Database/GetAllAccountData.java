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
              "almafast325");
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

  public void loadGroups() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Groups\".\"Groups\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Group gr = new Group(rs.getString("name"), rs.getInt("id"));
      gr.addDM(new DM(rs.getString("usernameDM")));
      ArrayList<String> players = (ArrayList<String>) rs
          .getArray("usernamePlayers");

      for (int i = 0; i < players.size(); i++)
      {
        Player pl = new Player(players.get(i));
        gr.addPlayer(pl);

      }

    }

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

  //  /**
  //   * @param username String containing the username
  //   * @param password String containing the password
  //   * @return
  //   * @throws SQLException An exception that provides information on a database
  //   *                      access error or other errors.
  //   */
  public Container acceptLogin(String username, String password)
      throws SQLException
  {

    Statement st = c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
    String query =
        "SELECT u.username, u.password, u.email, u.\"groupIDs\", g.name, g.id, g.\"usernameDM\", g.\"usernamePlayers\", g.\"characterIDs\" FROM \"Groups\".\"Groups\" g, \"Users\".\"Users\" u     WHERE u.username = '"
            + username + "' AND u.password= '" + password
            + "' AND u.\"groupIDs\" IS NOT NULL ;";

    ResultSet rs = st.executeQuery(query);

    boolean doesAccountHaveGroups = true;
    String userame = null;
    String ema = null;
    String pass = null;

    if (!rs.next())
    {
      doesAccountHaveGroups = false;
      query =
          "SELECT * FROM \"Users\".\"Users\" WHERE  username  = '" + username
              + "' AND password ='" + password + "' ;";
      rs = st.executeQuery(query);
      System.out.println("alma");


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
      System.out.println(doesAccountHaveGroups + "why isnt if true?");
      if (doesAccountHaveGroups == false)
      {
        System.out.println(
            doesAccountHaveGroups + " which means it doesnt have accs");
        break;
      }
      System.out.println(doesAccountHaveGroups + "why isnt if true?");
      //groupidz = rs.getString("groupIDs");

      String k = rs.getString("usernamePlayers");
      plys = sqlArrayToArrayListString(k);

      String charid = rs.getString("characterIDs");
      charIDs = sqlArrayToArrayListInteger(charid);

      Group ng = null;
      ng = new Group(rs.getString("name"), rs.getInt("id"));

      for (int i = 0; i < plys.size(); i++)
      {

        Player a = new Player(plys.get(i));

        if (charIDs.get(i) != null)
        {
          a.addCharacterID(charIDs.get(i));
        }
        else
        {
          a.addCharacterID(null);
        }
        ng.addDM(new DM(rs.getString("usernameDM")));


        ng.addPlayer(a);

      }




      groupList.add(ng);


    }


    ArrayList<Object> objs = new ArrayList<>();
    boolean b = true;
    objs.add(b);
    Account acc = new Account(userame, password, ema);
    objs.add(acc);
    System.out.println(doesAccountHaveGroups + "why isnt if true?");
    if (doesAccountHaveGroups)
    {
      objs.add(groupList);
      System.out.println(
          groupList.get(0).getId() + "=id \n did gro: " + groupList.get(0)
              .getDM().getName() + " id: " + groupList.get(1).getId());
    }
    System.out.println(
        "acc: " + acc.getUsername() + "pas " + acc.getPassword() + "ema " + acc
            .getEmail());

    Container dataPack = new Container(objs, ClassName.LOGIN_RESPONSE);
    return dataPack;

  }

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

  public ArrayList<String> sqlArrayToArrayListString(String ar)
  {
    ArrayList<String> temp = new ArrayList<>();
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

      String k = rs.getString("usernamePlayers");
      plys = sqlArrayToArrayListString(k);

      String charid = rs.getString("characterIDs");
      charIDs = sqlArrayToArrayListInteger(charid);

      thisIsAGroupForTheGroupWithTheIDOfWhatTheUserInsertedIntoTheMethodToFindThisGroupDoYouUnderstandThisMarin = new Group(
          rs.getString("name"), rs.getInt("id"));

      for (int i = 0; i < plys.size(); i++)
      {

        Player a = new Player(plys.get(i));

        if (charIDs.get(i) != null)
        {
          a.addCharacterID(charIDs.get(i));
        }
        else
        {
          a.addCharacterID(null);
        }
        thisIsAGroupForTheGroupWithTheIDOfWhatTheUserInsertedIntoTheMethodToFindThisGroupDoYouUnderstandThisMarin
            .addDM(new DM(rs.getString("usernameDM")));

        thisIsAGroupForTheGroupWithTheIDOfWhatTheUserInsertedIntoTheMethodToFindThisGroupDoYouUnderstandThisMarin
            .addPlayer(a);

      }

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
}
