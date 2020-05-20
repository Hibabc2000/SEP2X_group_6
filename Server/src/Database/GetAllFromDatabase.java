package Database;

import system.*;

import java.sql.*;
import java.util.ArrayList;

public class GetAllFromDatabase
{
  /**
   * Class for initializing server. Loads all data from database Core schema into the java program.
   * @deprecated
   * DO NOT USE.
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


  public GetAllFromDatabase()
  { races = new ArrayList<>();
  equipmentArmors = new ArrayList<>();
 equipmentWeaponList = new ArrayList<>();
 equipmentGenerals = new ArrayList<>();
    skills = new ArrayList<>();
    abilities = new ArrayList<>();
    subraces = new ArrayList<>();
    subclasses= new ArrayList<>();
    spells = new ArrayList<>();

    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2", "postgres", "almafast325");
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

      loadEquipmentArmors();

      loadEquipmentGeneral();
      loadEquipmentWeapons();

      loadSkills();

      loadRace();

      loadSpells();

      loadSubClasses();

      loadSubRaces();

    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
    }
  }
  private void loadEquipmentArmors() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Equipment_armor\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      String equipment = rs.getString("equipment");
      String[] temp = equipment.split(",\""); //needed due to postgres stupidity (disappearing quotation marks)
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
      Equipment eq = new Equipment(temp[0], temp2[0], Double.parseDouble(temp3[0]), Double.parseDouble(temp3[1]));
      EquipmentArmor e = new EquipmentArmor(eq, rs.getInt("armorClass"), rs.getString("dexMod"), rs.getBoolean("stealth"), rs.getInt("strength"));
      equipmentArmors.add(e);
    }


  }
  private void loadEquipmentGeneral() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Equipment_general\"";
    ResultSet rs = st.executeQuery(query);
    while (rs.next())
    {
      String equipment = rs.getString("equipment");
      String[] temp = equipment.split(",\""); //needed due to postgres stupidity (disappearing quotation marks)
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
      EquipmentGeneral eq = new EquipmentGeneral(new Equipment(temp[0], temp2[0], Double.parseDouble(temp3[0]), Double.parseDouble(temp3[1])));
      equipmentGenerals.add(eq);
    }
  }

  private void loadRace() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Race\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Race rc = new Race(rs.getString("name"),rs.getString("description"),rs.getString("traits"));

      races.add(rc);

    }
  }


  private void loadSubRaces() throws SQLException
  {Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Subraces\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Subrace sb = new Subrace(rs.getString("name"),rs.getString("mainRace"),rs.getString("description"),rs.getString("traits"));
           subraces.add(sb);
    }
  }
  private void loadSkills() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Skill\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {

      Skill sk = new Skill(rs.getString("name"),rs.getString("description"),rs.getString("ability"));
      skills.add(sk);

    }
  }

  private void loadEquipmentWeapons() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Equipment_weapons\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      String equipment = rs.getString("equipment");
      String[] temp = equipment.split(",\""); //needed due to postgres stupidity (disappearing quotation marks)
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
      Equipment eq = new Equipment(temp[0], temp2[0], Double.parseDouble(temp3[0]), Double.parseDouble(temp3[1]));
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
      EquipmentWeapon ew = new EquipmentWeapon(eq, weaponDamage, props, rs.getString("weaponType"));
      equipmentWeaponList.add(ew);
    }
  }

  private void loadSpells() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Spell\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Spell sp = new Spell(rs.getString("name"),rs.getInt("spellLevel"),rs.getString("school"),
          rs.getString("castTime"),rs.getString("range"),rs.getString("components"),rs.getString("duration"),
          rs.getString("description"),rs.getString("class"));
      spells.add(sp);
    }



  }
  private void loadSubClasses() throws SQLException
  {Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Subclasses\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      Subclass sb = new Subclass(rs.getString("name"), rs.getString("description"),rs.getString("mainClass"));
      subclasses.add(sb);
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
  public ArrayList<Subrace> getSubraces()
  {
    return subraces;
  }
  public ArrayList<Race> getRaces()
  {
    return races;
  }
  public ArrayList<EquipmentArmor> getEquipmentArmors()
  {
    return equipmentArmors;
  }
  public ArrayList<Subclass> getSubclasses()
  {
    return subclasses;
  }
  public ArrayList<Spell> getSpells()
  {
    return spells;
  }
  public ArrayList<Skill> getSkills()
  {
    return skills;
  }
  public ArrayList<EquipmentWeapon> getEquipmentWeaponList()
  {
    return equipmentWeaponList;
  }
  public ArrayList<EquipmentGeneral> getEquipmentGenerals()
  {
    return equipmentGenerals;
  }

}
