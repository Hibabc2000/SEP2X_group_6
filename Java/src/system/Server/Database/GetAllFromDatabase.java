package system.Server.Database;

import system.Ability;

import java.sql.*;
import java.util.ArrayList;

public class GetAllFromDatabase
{
  /**
   * Class for initializing server. Loads all data from database Core schema into the java program.
   */

  private Connection c;
  private ArrayList<Ability> abilities;

  public GetAllFromDatabase()
  {
    abilities = new ArrayList<>();
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2", "postgres", "Aoe3tadtwc-2000");
    }
    catch (SQLException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public void loadDatabase()
  {
    /**
     * Main database loading method. Sub-methods responsible for loading individual tables.
     */
    try
    {
      loadAbility();
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
  }

  private void parseModifiers()
  {
          /*for (int i = 1; i < rsmd.getColumnCount(); i++)
       {
         if (rsmd.getColumnName(i).toLowerCase().equals("modifiers") || rsmd.getColumnName(i).toLowerCase().equals("proficiencies"))
         {
           //parse into proficiencies
         }
       }*/
  }

  private void loadAbility() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Ability\"";
    ResultSet rs = st.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
    while (rs.next())
    {
      if (rs.getString("name").equals("Strength"))
      {
        Ability strength = new Ability(rs.getString("name"),
            rs.getString("description"));
        abilities.add(strength);
      }
      else if (rs.getString("name").equals("Dexterity"))
      {
        Ability dexterity = new Ability(rs.getString("name"),
            rs.getString("description"));
        abilities.add(dexterity);
      }
      else if (rs.getString("name").equals("Constitution"))
      {
        Ability constitution = new Ability(rs.getString("name"),
            rs.getString("description"));
        abilities.add(constitution);
      }
      else if (rs.getString("name").equals("Intelligence"))
      {
        Ability intelligence = new Ability(rs.getString("name"),
            rs.getString("description"));
        abilities.add(intelligence);
      }
      else if (rs.getString("name").equals("Wisdom"))
      {
        Ability wisdom = new Ability(rs.getString("name"),
            rs.getString("description"));
        abilities.add(wisdom);
      }
      else if (rs.getString("name").equals("Charisma"))
      {
        Ability charisma = new Ability(rs.getString("name"),
            rs.getString("description"));
        abilities.add(charisma);
      }
    }
  }

  public ArrayList<Ability> getAbilities()
  {
    return abilities;
  }
}
