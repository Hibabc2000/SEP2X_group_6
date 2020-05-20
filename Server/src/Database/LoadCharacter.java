package Database;

import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;

import java.sql.*;

public class LoadCharacter
{
  private Character character;
  private Connection c;
  private StaticModel staticModel;

  public LoadCharacter()
  {
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
