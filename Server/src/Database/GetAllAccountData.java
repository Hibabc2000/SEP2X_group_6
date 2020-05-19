package Database;

import system.model.loginModel.Account;
import system.model.loginModel.DM;
import system.model.loginModel.Group;
import system.model.loginModel.Player;

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
        "SELECT * FROM \"Users\".\"Users\" WHERE  username  = '" + username + "' OR email ='"
            + email + "' ;";

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
      ArrayList<String> players = (ArrayList<String>) rs.getArray("usernamePlayers");

      for (int i = 0; i < players.size(); i++)
      {
        Player pl = new Player(players.get(i));
        gr.addPlayer(pl);

      }

    }

  }

  public void createAccount(String username,String password, String email) throws SQLException
  {

    boolean done = false;
    Statement st = c.createStatement();
    String query =
        "INSERT INTO  \"Users\".\"Users\" VALUES( '" + username + "', '"
            + password + "', null, '" + email + "') ";

    st.executeUpdate(query);


  }
  public boolean checkLogin(String username, String password)
      throws SQLException

  { boolean answer = false;

    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Users\".\"Users\" WHERE  username  = '" + username + "' AND password ='"
            + password + "' ;";

    ResultSet rs = st.executeQuery(query);
    String userame = null;
    String ema = null;
    String pass = null;
    while (rs.next())
    {
      userame = rs.getString("username");
      ema = rs.getString("email");
      System.out.println("name = " + userame);
      System.out.println("email = " + ema);

      if (userame != null && password != null)
      { answer= true;
        System.out.println(answer);
        break;
      }
      System.out.println(answer);
    }

    return answer;
  }

  public void acceptLogin()
  {
  }
}
