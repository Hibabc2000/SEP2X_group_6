package Database;

import system.model.businessModel.*;
import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;
import system.model.characterClasses.Barbarian;
import system.model.characterClasses.CharacterClass;
import system.transferobjects.Container;

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
      GetCoreFromDatabase getCore = new GetCoreFromDatabase();
      Container container = getCore.loadDatabase();
      staticModel = getCore.loadStaticModel();
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
        String classNamesSQL = rs.getString("classes");
        String classLevelsSQL = rs.getString("classLevels");
        ArrayList<String> classNames = sqlArrayToArrayListString(classNamesSQL);
        ArrayList<Integer> classLevels = sqlArrayToArrayListInteger(classLevelsSQL);
        ArrayList<CharacterClass> classes = new ArrayList<>();
        for(String s : classNames)
        {
          if(s.equals("Barbarian")) //make the rest of the classes
          {
            Barbarian barbarian = new Barbarian();
            classLevels.add(classLevels.get(classNames.indexOf(s)));
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
        String equipmentNames = rs.getString("equipment_names");
        String equipmentAmount = rs.getString("eqiupment_amount");
        ArrayList<String> equipment_names = sqlArrayToArrayListString(equipmentNames);
        ArrayList<Integer> equipment_amounts = sqlArrayToArrayListInteger(equipmentAmount);
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<String> treasures = new ArrayList<>();
        for(String s : equipment_names)
        {
          Item i = null;
          for (EquipmentGeneral e: staticModel.getEquipmentGenerals())
          {
            if(e.getName().equals(s))
            {
              i = new Item(e, equipment_amounts.get(equipment_names.indexOf(s)));
            }
          }
          for (EquipmentArmor e: staticModel.getEquipmentArmors())
          {
            if(e.getName().equals(s))
            {
              i = new Item(e, equipment_amounts.get(equipment_names.indexOf(s)));
            }
          }
          for (EquipmentWeapon e: staticModel.getEquipmentWeaponList())
          {
            if(e.getName().equals(s))
            {
              i = new Item(e, equipment_amounts.get(equipment_names.indexOf(s)));
            }
          }
          if(i == null)
          {
            treasures.add(s);
          }
          else
          {
            items.add(i);
          }
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

  public static ArrayList<String> sqlArrayToArrayListString(String ar)
  {
    ArrayList<String> temp = new ArrayList<>();
    System.out.println("This is the array of usernames:"+ar);

    String[] ara = ar.split("\\{");
    String part2 = ara[1];
    String[] h = part2.split("}");
    String o = h[0];
    String[] l = o.split(",");

    for (int i = 0; i < l.length; i++)
    {
      temp.add(l[i]);

    }
    return temp;
  }

  public ArrayList<Integer> sqlArrayToArrayListInteger(String ar)
  {
    ArrayList<Integer> temp = new ArrayList<>();
    String[] ara = ar.split("\\{");
    String part2 = ara[1];
    String[] h = part2.split("}");
    String o = h[0];
    String[] l = o.split(",");

    for (int i = 0; i < l.length; i++)
    { if(l[i].equals("NULL")) {l[i]="0";}
      temp.add(Integer.parseInt(l[i]));

    }
    return temp;
  }
}
