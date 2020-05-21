package Database;

import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;

import java.sql.*;

public class LoadCharacter
{
  /**
   * Class for loading characters from the database.
   */
  private Character character;
  private Connection c;
  private StaticModel staticModel;

  public LoadCharacter()
  {
    /**
     * Constructor method for LoadCharacter. Gets the PostgreSQL connection.
     */
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2", "postgres",
              "");
    }
    catch (SQLException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public Character loadCharacter(int id)
  {
    /**
     * Character loading method. Returns the character object whose ID matches the id in the database.
     * @param id ID of the character in the database.
     * @return Returns a Character object with the id matching the parameter.
     */
    character = new Character(staticModel);
    try
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Characters\".\"Characters\" WHERE id = " + id + ";";
    ResultSet rs = st.executeQuery(query);
    while (rs.next())
    {
      //call character set methods
    }
  }
  catch (SQLException e)
  {
    e.printStackTrace();
  }
    return character;
  }
}
