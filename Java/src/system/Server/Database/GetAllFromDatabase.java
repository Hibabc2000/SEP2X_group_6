package system.Server.Database;

import java.sql.*;
import java.util.ArrayList;

public class GetAllFromDatabase
{
  /**
   * Class for initializing server. Loads all data from database Core schema into the java program.
   */

  private Connection c;
  private ArrayList<String> modifiers;

  public GetAllFromDatabase()
  {
    modifiers = new ArrayList<String>();
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SEP2", "postgres", "");
    }
    catch (SQLException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public void loadDatabase()
  {
    try
    {
      Statement st = c.createStatement();
      String query = "SELECT * FROM \"Core\".\"Ability\"";
      //write database queries and load them into multiton instances
      //following is example  for Ability table
      ResultSet rs = st.executeQuery(query);
      ResultSetMetaData rsmd = rs.getMetaData();
      while (rs.next())
      {
        System.out.println(rs.getString("name"));
        System.out.println(rs.getString("description"));
      }
        /*if(rsmd.getColumnName(i).toLowerCase().equals("modifiers") || rsmd.getColumnName(i).toLowerCase().equals("proficiencies"))
        {
         //parse into proficiencies
       }*/
      }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
