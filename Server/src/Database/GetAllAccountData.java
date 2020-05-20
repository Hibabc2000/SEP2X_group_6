package Database;

import system.transferobjects.login.Account;
import system.transferobjects.login.DM;
import system.transferobjects.login.Group;
import system.transferobjects.login.Player;
import system.transferobjects.ClassName;
import system.transferobjects.Container;

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

  public Container acceptLogin(String username, String password)
      throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT u.username, u.password, u.email, u.\"groupIDs\", g.name, g.id, g.\"usernameDM\", g.\"usernamePlayers\", g.\"characterIDs\" FROM \"Groups\".\"Groups\" g, \"Users\".\"Users\" u     WHERE u.username = '"+username +"' AND u.password= '"+password +"' ;";

    ResultSet rs = st.executeQuery(query);
    String userame = null;
    String ema = null;
    String pass = null;


    ArrayList<Group> groupList = new ArrayList<>();
    ArrayList<String> plys = new ArrayList<>();
    ArrayList<Integer> charIDs = new ArrayList<>();

    while (rs.next())
    {
      userame = rs.getString("username");
      pass = rs.getString("password");
      ema = rs.getString("email");

      //groupidz = rs.getString("groupIDs");

      String k = rs.getString("usernamePlayers");
      plys = sqlArrayToArrayListString(k);

      String charid = rs.getString("characterIDs");
      charIDs = sqlArrayToArrayListInteger(charid);

      Group ng = null;
      ng  = new Group(rs.getString("name"), rs.getInt("id"));

      for (int i = 0; i < plys.size(); i++)
      {

        Player a = new Player(plys.get(i));

        if(charIDs.get(i)!=null)
        { a.addCharacterID(charIDs.get(i));} else {a.addCharacterID(null);}
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
    objs.add(groupList);

    System.out.println("acc: " + acc.getUsername() + "pas "+ acc.getPassword() + "ema "+ acc.getEmail());
    System.out.println("Group1 "+ groupList.get(0).toString());
    System.out.println("Group2 "+ groupList.get(1).toString());

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
    {
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
}
