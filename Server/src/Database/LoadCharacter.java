package Database;

import system.model.businessModel.Character;
import system.model.businessModel.Feat;
import system.model.businessModel.Item;
import system.model.businessModel.staticModel.StaticModel;
import system.model.characterClasses.Barbarian;
import system.model.characterClasses.CharacterClass;

import java.sql.*;
import java.util.ArrayList;

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
              "almafast325");
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
      String query =
          "SELECT * FROM \"Characters\".\"Characters\" WHERE id = " + id + ";";
      ResultSet rs = st.executeQuery(query);
      while (rs.next())
      {
        character.setAbilities((int[]) rs.getArray("abilities").getArray());
        character.setAbilitiesRolled((int[]) rs.getArray("abilitiesRolled").getArray());
        character.setId(id);
        ArrayList<String> classNames = (ArrayList<String>) rs.getArray("classes").getArray();
        ArrayList<Integer> classLevels = (ArrayList<Integer>) rs.getArray("classLevels").getArray();
        ArrayList<CharacterClass> classes = new ArrayList<>();
        for(String s : classNames)
        {
          if(s.equals("Barbarian")) //make the rest of the classes
          {
            Barbarian barbarian = new Barbarian();
            classLevels.add(0);
            classes.add(barbarian);
          }
        }
        character.setCharacterClass(classes);
        character.setLevelInClass(classLevels);
        character.setAlignment(rs.getString("alignment"));
        character.setBackground(rs.getString("backgroundName"));
        character.setName(rs.getString("name"));
        character.setLevel(rs.getInt("level"));
        character.setXp(rs.getInt("XP"));
        character.setRolledHp(rs.getInt("hitPointRolled"));
        character.setFaith(rs.getString("faith"));
        character.setPhysicalCharacteristics(rs.getString("physicalTraits"));
        character.setMoney((int[]) rs.getArray("money").getArray());
        character.setFeats((ArrayList<Feat>) rs.getArray("extraFeatNames").getArray());
        character.setUsername(rs.getString("username"));
        ArrayList<String> equipment_names = (ArrayList<String>) rs.getArray("equipment_names").getArray();
        ArrayList<Integer> equipment_amounts = (ArrayList<Integer>) rs.getArray("eqiupment_amount").getArray(); //typo is in database
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<String> treasures = new ArrayList<>();
        for(String s : equipment_names)
        {
          //write equipment setter
        }
        character.setTreasures(treasures);
        character.setEquipmentList(items);
        character.setGroupID(rs.getInt("groupID"));
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return character;
  }

  public Integer getIDOfTheNewlyCreatedCharacter(int id, String username)
      throws SQLException
  {
    int idOfTheCreatedCharacter = 0;

    Statement st = c.createStatement();
    String query =
        "SELECT * FROM \"Characters\".\"Characters\" WHERE username = '"
            + username + "' AND \"groupID\" = " + id + " ;";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      idOfTheCreatedCharacter = rs.getInt("id");
    }
    return idOfTheCreatedCharacter;
  }
}
