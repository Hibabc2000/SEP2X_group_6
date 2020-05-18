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
  { accounts = new ArrayList<>();
  ids = new ArrayList<ArrayList<Integer>>();
   groups = new ArrayList<>();
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2", "postgres", "almafast325");
    }
    catch (SQLException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private void loadAccount() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Users\".\"Users\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Account ac = new Account(rs.getString("username"),rs.getString("password"),
      rs.getString("email"));
      ArrayList<Integer> id = (ArrayList<Integer>) rs.getArray("groupIDs");

      accounts.add(ac);
      ids.add(id);

    }
  }
  private void loadGroups() throws SQLException
  {Statement st = c.createStatement();
    String query = "SELECT * FROM \"Groups\".\"Groups\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Group gr = new Group(rs.getString("name"),rs.getInt("id"));
      gr.addDM(new DM(rs.getString("usernameDM")));
      ArrayList<String> players = (ArrayList<String>) rs.getArray("usernamePlayers");

      for (int i=0; i<players.size();i++)
      { Player pl = new Player(players.get(i));
          gr.addPlayer(pl);

      }



    }

  }



}
