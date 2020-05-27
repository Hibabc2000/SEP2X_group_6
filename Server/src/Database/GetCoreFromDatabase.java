package Database;

import system.model.businessModel.*;
import system.model.businessModel.staticModel.*;
import system.transferobjects.ClassName;
import system.transferobjects.Container;

import java.sql.*;
import java.util.ArrayList;

public class GetCoreFromDatabase
{
  /**
   * Class for initializing server. Loads all data from database Core schema into the java program.
   */

  private Connection c;
  private ArrayList<Ability> abilities;
  private ArrayList<Subrace> subraces;
  private ArrayList<Subclass> subclasses;
  private ArrayList<Skill> skills;
  private ArrayList<Spell> spells;
  private ArrayList<Race> races;
  private ArrayList<EquipmentWeapon> equipmentWeaponList;
  private ArrayList<EquipmentGeneral> equipmentGenerals;
  private ArrayList<EquipmentArmor> equipmentArmors;
  private StaticModel staticModel;
  private Container cont;

  public GetCoreFromDatabase()
  {
    /**
     * Constructor method. Creates empty ArrayLists and gets the PostgreSQL connection.
     */
    races = new ArrayList<>();
    equipmentArmors = new ArrayList<>();
    equipmentWeaponList = new ArrayList<>();
    equipmentGenerals = new ArrayList<>();
    skills = new ArrayList<>();
    abilities = new ArrayList<>();
    subraces = new ArrayList<>();
    subclasses = new ArrayList<>();
    spells = new ArrayList<>();
    staticModel = new StaticModel();

    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2", "postgres",
              "Aoe3tadtwc-2000");
    }
    catch (SQLException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public Container loadDatabase()
  {
    /**
     * Main database loading method. Sub-methods responsible for loading individual tables.
     * All of the methods in this class draw on the Core database schema.
     * @exception SQLException Thrown in case of an error in the database communication.
     */
    try
    {
      System.out.println("1");
      loadAbility();
      System.out.println("3");
      loadEquipmentArmors();
      System.out.println("4");
      loadEquipmentGeneral();
      System.out.println("5");
      loadEquipmentWeapons();
      System.out.println("6");
      loadSkills();
      System.out.println("7");
      loadRace();
      System.out.println("8");
      loadSpells();
      System.out.println("9");
      loadSubClasses();
      System.out.println("10");
      loadSubRaces();
      System.out.println("11");
      staticModel.load(abilities, skills, races, spells, subclasses, subraces,
          equipmentArmors, equipmentGenerals, equipmentWeaponList);
      cont = new Container(staticModel, ClassName.STATIC_MODEL);
    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
    return cont;
  }

  private void loadEquipmentArmors() throws SQLException
  {
    /**
     * Method loading the Equipment_armor table.
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Equipment_armor\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      String equipment = rs.getString("equipment");
      String[] temp = equipment.split(
          ",\""); //needed due to postgres stupidity (disappearing quotation marks)
      String[] temp2 = temp[1].split("\",");
      String[] temp3 = temp2[1].split(",");
      temp[0] = temp[0].replaceAll("\"", "");
      temp[0] = temp[0].replaceAll("\\(", "");
      temp[0] = temp[0].replaceAll("\\)", "");
      temp2[0] = temp2[0].replaceAll("\"", "");
      temp2[0] = temp2[0].replaceAll("\\(", "");
      temp2[0] = temp2[0].replaceAll("\\)", "");
      temp3[0] = temp3[0].replaceAll("\"", "");
      temp3[0] = temp3[0].replaceAll("\\(", "");
      temp3[0] = temp3[0].replaceAll("\\)", "");
      temp3[1] = temp3[1].replaceAll("\"", "");
      temp3[1] = temp3[1].replaceAll("\\(", "");
      temp3[1] = temp3[1].replaceAll("\\)", "");
      Equipment eq = new Equipment(temp[0], temp2[0],
          Double.parseDouble(temp3[0]), Double.parseDouble(temp3[1]));
      EquipmentArmor e = new EquipmentArmor(eq, rs.getInt("armorClass"),
          rs.getString("dexMod"), rs.getBoolean("stealth"),
          rs.getInt("strength"));
      equipmentArmors.add(e);
    }

  }

  private void loadEquipmentGeneral() throws SQLException
  {
    /**
     * Method loading the Equipment_general table
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Equipment_general\"";
    ResultSet rs = st.executeQuery(query);
    while (rs.next())
    {
      String equipment = rs.getString("equipment");
      String[] temp = equipment.split(
          ",\""); //needed due to postgres stupidity (disappearing quotation marks)
      String[] temp2 = temp[1].split("\",");
      String[] temp3 = temp2[1].split(",");
      temp[0] = temp[0].replaceAll("\"", "");
      temp[0] = temp[0].replaceAll("\\(", "");
      temp[0] = temp[0].replaceAll("\\)", "");
      temp2[0] = temp2[0].replaceAll("\"", "");
      temp2[0] = temp2[0].replaceAll("\\(", "");
      temp2[0] = temp2[0].replaceAll("\\)", "");
      temp3[0] = temp3[0].replaceAll("\"", "");
      temp3[0] = temp3[0].replaceAll("\\(", "");
      temp3[0] = temp3[0].replaceAll("\\)", "");
      temp3[1] = temp3[1].replaceAll("\"", "");
      temp3[1] = temp3[1].replaceAll("\\(", "");
      temp3[1] = temp3[1].replaceAll("\\)", "");
      EquipmentGeneral eq = new EquipmentGeneral(
          new Equipment(temp[0], temp2[0], Double.parseDouble(temp3[0]),
              Double.parseDouble(temp3[1])));
      equipmentGenerals.add(eq);
    }
  }

  private void loadRace() throws SQLException
  {
    /**
     * Method for loading Race table.
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Race\"";
    ResultSet rs = st.executeQuery(query);
    while (rs.next())
    {
      Race r = new Race(rs.getString("name"), rs.getString("description"), rs.getString("traits"));
      races.add(r);
    }
  }

  private void loadSubRaces() throws SQLException
  {
    /**
     * Method for loading Subraces table.
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Subraces\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Subrace hillDwarf = new Subrace(rs.getString("mainRace"), rs.getString("name"), rs.getString("description"),
          rs.getString("traits"));
      subraces.add(hillDwarf);
    }
  }

  private void loadSkills() throws SQLException
  {
    /**
     * Method for loading Skills table.
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Skill\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
    }
  }

  private void loadEquipmentWeapons() throws SQLException
  {
    /**
     * Method for loading Equipment_weapons table
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Equipment_weapons\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      String equipment = rs.getString("equipment");
      String[] temp = equipment.split(
          ",\""); //needed due to postgres stupidity (disappearing quotation marks)
      String[] temp2 = temp[1].split("\",");
      String[] temp3 = temp2[1].split(",");
      temp[0] = temp[0].replaceAll("\"", "");
      temp[0] = temp[0].replaceAll("\\(", "");
      temp[0] = temp[0].replaceAll("\\)", "");
      temp2[0] = temp2[0].replaceAll("\"", "");
      temp2[0] = temp2[0].replaceAll("\\(", "");
      temp2[0] = temp2[0].replaceAll("\\)", "");
      temp3[0] = temp3[0].replaceAll("\"", "");
      temp3[0] = temp3[0].replaceAll("\\(", "");
      temp3[0] = temp3[0].replaceAll("\\)", "");
      temp3[1] = temp3[1].replaceAll("\"", "");
      temp3[1] = temp3[1].replaceAll("\\(", "");
      temp3[1] = temp3[1].replaceAll("\\)", "");
      Equipment eq = new Equipment(temp[0], temp2[0],
          Double.parseDouble(temp3[0]), Double.parseDouble(temp3[1]));
      String temp4 = rs.getString("damage");
      String weaponDamage = "";
      if (!temp4.equals("0"))
      {
        String[] temp5 = temp4.split("\\|");
        weaponDamage = temp5[0] + temp5[1] + ", " + temp5[2];
      }
      else
      {
        weaponDamage = "0";
      }
      String props = rs.getString("Properties").replaceAll("\\|", ", ");
      EquipmentWeapon ew = new EquipmentWeapon(eq, weaponDamage, props,
          rs.getString("weaponType"));
      equipmentWeaponList.add(ew);
    }
  }

  private void loadSpells() throws SQLException
  {
    /**
     * Method for loading Spells table.
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Spell\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Spell spell = new Spell(rs.getString("name"), rs.getInt("spellLevel"),
          rs.getString("school"), rs.getString("castTime"),
          rs.getString("range"), rs.getString("components"),
          rs.getString("duration"), rs.getString("description"),
          rs.getString("class"));
      spells.add(spell);
    }
    //more spells needed in database;
  }

  private void loadSubClasses() throws SQLException
  {
    /**
     * Method for loading Subclasses table.
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Subclasses\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Subclass barbarian = new Subclass(rs.getString("name"),
          rs.getString("mainClass"), rs.getString("description"));
      subclasses.add(barbarian);
    }
  }

  private ArrayList<Proficiency> parseModifiers(ResultSet rs)
  {
    /**
     * Special parser method for proficiencies and other modifiers.
     */
    ArrayList<Proficiency> arr = new ArrayList<>();
    try
    {
      ResultSetMetaData rsmd = rs.getMetaData();
      for (int i = 0; i < rsmd.getColumnCount(); i++)
      {
        if (rsmd.getColumnName(i).toLowerCase().contains("modifiers") || rsmd
            .getColumnName(i).toLowerCase().contains("proficien"))
        {
          String[] temp = rs.getString(i).split("\\|");
          for (String s : temp)
          {
            String[] s2 = s.split(":");
            double d;
            if (s.toLowerCase().contains("expert"))
            {
              d = 2;
            }
            else if (s.toLowerCase().contains("proficiency"))
            {
              d = 1;
            }
            else if (s.toLowerCase().contains("half"))
            {
              d = 0.5;
            }
            else
              d = 1;
            Proficiency p = new Proficiency(s2[1], s2[0], rsmd.getColumnName(i),
                d);
            arr.add(p);
          }
        }
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return arr;
  }

  private void loadAbility() throws SQLException
  {
    /**
     * Method for loading Ability table.
     */
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Ability\"";
    ResultSet rs = st.executeQuery(query);
    while (rs.next())
    {
      Ability ability = new Ability(rs.getString("name"),
          rs.getString("description"));
      abilities.add(ability);
    }
  }

  public ArrayList<Ability> getAbilities()
  {
    return abilities;
  }

  public ArrayList<Subrace> getSubraces()
  {
    return subraces;
  }

  public ArrayList<Subclass> getSubclasses()
  {
    return subclasses;
  }

  public ArrayList<Skill> getSkills()
  {
    return skills;
  }

  public ArrayList<Spell> getSpells()
  {
    return spells;
  }

  public ArrayList<Race> getRaces()
  {
    return races;
  }

  public ArrayList<EquipmentWeapon> getEquipmentWeaponList()
  {
    return equipmentWeaponList;
  }

  public ArrayList<EquipmentGeneral> getEquipmentGenerals()
  {
    return equipmentGenerals;
  }

  public ArrayList<EquipmentArmor> getEquipmentArmors()
  {
    return equipmentArmors;
  }
}
