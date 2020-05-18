package Database;

import system.*;
import system.model.staticModel.StaticModel;
import system.networking.Container;

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

  public void loadDatabase()
  {
    /**
     * Main database loading method. Sub-methods responsible for loading individual tables.
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
      staticModel.load(abilities, skills, races, spells, subclasses, subraces, equipmentArmors, equipmentGenerals, equipmentWeaponList);
      cont = new Container(staticModel, "StaticModel");
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
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Race\"";
    ResultSet rs = st.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
    while (rs.next())
    {
      if (rs.getString("name").equals("Dwarf"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Dwarf"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Half-Elf"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Elf"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Halfling"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Human"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Dragonborn"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Gnome"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Half-Orc"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Tiefling"))
      {
        Race r = new Race(rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        races.add(r);
      }

    }
  }

  private void loadSubRaces() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Subraces\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      if (rs.getString("name").equals("Hill Dwarf"))
      {
        Subrace hillDwarf = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(hillDwarf);
      }
      else if (rs.getString("name").equals("Mountain Dwarf"))
      {
        Subrace mountainDwarf = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(mountainDwarf);
      }
      else if (rs.getString("name").equals("High Elf"))
      {
        Subrace highElf = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(highElf);
      }
      else if (rs.getString("name").equals("Wood Elf"))
      {
        Subrace woodElf = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(woodElf);
      }
      else if (rs.getString("name").equals("Dark Elf (Drow)"))
      {
        Subrace drow = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(drow);
      }
      else if (rs.getString("name").equals("Lightfoot"))
      {
        Subrace lightfoot = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(lightfoot);
      }
      else if (rs.getString("name").equals("Stout"))
      {
        Subrace stout = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(stout);
      }
      else if (rs.getString("name").equals("Forest Gnome"))
      {
        Subrace forestGnome = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(forestGnome);
      }
      else if (rs.getString("name").equals("Rock Gnome"))
      {
        Subrace rockGnome = new Subrace(rs.getString("mainRace"),
            rs.getString("name"), rs.getString("description"),
            rs.getString("traits"));
        subraces.add(rockGnome);
      }

    }
  }

  private void loadSkills() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Skill\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      if (rs.getString("name").equals("Acrobatics"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }

      if (rs.getString("name").equals("Animal Handling"))
      {
        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Arcana"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Athletics"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Deception"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("History"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Insight"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Intimidation"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Investigation"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Medicine"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Nature"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Perception"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Insight"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Insight"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Insight"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Insight"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Insight"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }
      if (rs.getString("name").equals("Insight"))
      {

        Skill skill = new Skill(rs.getString("ability"), rs.getString("name"),
            rs.getString("description"));
        skills.add(skill);
      }

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
    ArrayList<Proficiency> arr = new ArrayList<>();
    try
    {
      ResultSetMetaData rsmd = rs.getMetaData();
      for (int i = 0; i < rsmd.getColumnCount(); i++)
      {
        if(rsmd.getColumnName(i).toLowerCase().equals("modifiers") || rsmd.getColumnName(i).toLowerCase().equals("proficiency"))
        {
          String[] temp = rs.getString(i).split("\\|");
          for (String s : temp)
          {
            String[] s2 = s.split(":");
            double d;
            if(s.toLowerCase().contains("expert"))
            {
              d = 2;
            }
            else if(s.toLowerCase().contains("proficiency"))
            {
              d = 1;
            }
            else if (s.toLowerCase().contains("half"))
            {
              d = 0.5;
            }
            else d = 1;
            Proficiency p = new Proficiency(s2[1], s2[0], rsmd.getColumnName(i), d);
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
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Ability\"";
    ResultSet rs = st.executeQuery(query);
    ResultSetMetaData rsmd = rs.getMetaData();
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
