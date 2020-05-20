package Database;

import system.model.businessModel.Character;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCharacter
{
  private Connection c;

  public InsertCharacter()
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

  public void insertCharacter(Character cha) throws SQLException
  {
    Statement st = c.createStatement();
    String[] physical = (String[]) cha.getPhysicalCharacteristics().toArray();
    String query =
        "INSERT INTO \"Characters\".\"Characters\" (\"name\", \"level\", \"XP\", \"hitPointRolled\", \"alignment\", \"faith\", \"physicalTraits\", \"money\", \"abilities\", \"backgroundName\", \"classes\", \"classLevels\", \"extraFeatNames\", \"username\", \"groupName\", \"equipment_names\", \"equipment_amount\") VALUES ("
            + cha.getName() + ", " + cha.getLevel() + ", " + cha.getXp() + ", " + cha.getRolledHp() + ", " + cha.getAlignment() + ", " + cha.getFaith()
            + ", ";
    //write converter from String[] to SQL array (physical traits)
    //next, converter from int[] to SQL array (money)
    //ability array converter
    query += cha.getBackground() + ", ";
    //class names converter
    //class levels converter
    //extraFeatNames converter
    query += cha.getUsername() + ", ";
    query += cha.getGroup() + ", ";
    //write equipment name getter
    //write equipment amount getter
    st.executeUpdate(query);
    st.close();
    c.close();
  }
}
