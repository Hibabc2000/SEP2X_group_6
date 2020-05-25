package Database;

import system.model.characterClasses.CharacterClass;

import java.sql.*;
import java.util.ArrayList;

public class LoadCharacterClasses
{
  /**
   * Class for loading character classes.
   */
  private Connection c;
  private ArrayList<CharacterClass> classList;

  public LoadCharacterClasses()
  {
    /**
     * Constructor method for LoadCharacterClasses. Gets the PostgreSQL connection.
     */
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
    classList = new ArrayList<>();
  }

  public void load() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"CharacterClass\";";
    ResultSet rs = st.executeQuery(query);
    while(rs.next())
    {
      if(rs.getString("name").equals("Barbarian"))
      {
        //load Barbarian class
      }
    }
  }
}
