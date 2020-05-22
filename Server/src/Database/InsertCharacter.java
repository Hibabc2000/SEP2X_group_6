package Database;

import system.model.businessModel.Character;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertCharacter
{
  /**
   * Class for inserting characters into the database.
   */
  private Connection c;

public InsertCharacter()
  {
    /**
     * Constructor method for InsertCharacter. Gets the PostgreSQL connection via the JDBC driver.
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

  public void insertCharacter(Character cha) throws SQLException
  {
    /**
     * Character insertion method. Gets character data from the argument character, and parses it into SQL format.
     * @param cha Character to be inserted into the database.
     */
    Statement st = c.createStatement();
    String query =
        "INSERT INTO \"Characters\".\"Characters\" (\"name\", \"level\", \"XP\", \"hitPointRolled\", \"alignment\", \"faith\", \"physicalTraits\", \"money\", \"abilities\", \"backgroundName\", \"classes\", \"classLevels\", \"extraFeatNames\", \"username\", \"groupName\", \"equipment_names\", \"equipment_amount\") VALUES ("
            + cha.getName() + ", " + cha.getLevel() + ", " + cha.getXp() + ", "
            + cha.getRolledHp() + ", " + cha.getAlignment() + ", " + cha
            .getFaith() + ", \'{";
    //add physical traits
    /*
    String[] physical = (String[]) cha.getPhysicalCharacteristics().toArray();
    for (int i = 0; i < physical.length; i++)
    {
      query += physical[i];
      if (i < physical.length - 1)
      {
        query += ", ";
      }
    }
    query += "}\', ";
    //add money
    int[] money = cha.getMoney();
    for (int i = 0; i < money.length; i++)
    {
      query += money[i];
      if (i < money.length - 1)
      {
        query += ", ";
      }
    }
    query += "}\', ";
    //ability array converter
    int[] ability = cha.getAbilities();
    for (int i = 0; i < ability.length; i++)
    {
      query += ability[i];
      if (i < ability.length - 1)
      {
        query += ", ";
      }
    }
    query += "}\', ";
    //background
    query += cha.getBackground() + ", ";
    //class names converter
    CharacterClass[] classNames = (CharacterClass[]) cha.getCharacterClass()
        .toArray();
    for (int i = 0; i < classNames.length; i++)
    {
      query += classNames[i].getClassName();
      if (i < classNames.length - 1)
      {
        query += ", ";
      }
    }
    query += "}\', ";
    //class levels converter
    for (int i = 0; i < classNames.length; i++)
    {
      query += classNames[i].getLevelInClass();
      if (i < classNames.length - 1)
      {
        query += ", ";
      }
    }
    query += "}\', ";
    //extraFeatNames converter
    Feat[] extraFeats = (Feat[]) cha.getFeats().toArray();
    for (int i = 0; i < extraFeats.length; i++)
    {
      if (extraFeats[i].getOrigin().toLowerCase().equals("general"))
      {
        query += extraFeats[i].getName();
        if (i < extraFeats.length - 1)
        {
          query += ", ";
        }
      }
    }
    query += "}\', ";
    query += cha.getUsername() + ", ";
    query += cha.getGroup() + ", ";
    //write equipment name getter
    Item[] equipment = (Item[]) cha.getEquipmentList().toArray();
    for (int i = 0; i < equipment.length; i++)
    {
      query += equipment[i].getGameItem().getName();
      if (i < equipment.length - 1)
      {
        query += ", ";
      }
    }
    query += "}\', ";
    //write equipment amount getter
    for (int i = 0; i < equipment.length; i++)
    {
      query += equipment[i].getAmount();
      if (i < equipment.length - 1)
      {
        query += ", ";
      }
    }
    query += "}\');";
    st.executeUpdate(query);
    st.close();
    c.close();*/
  }

}
