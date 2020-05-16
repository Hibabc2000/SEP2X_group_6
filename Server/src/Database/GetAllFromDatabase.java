package Database;

import system.*;

import java.sql.*;
import java.util.ArrayList;

public class GetAllFromDatabase
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


  public GetAllFromDatabase()
  { races = new ArrayList<>();

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
      loadSubRaces();

    }
    catch (SQLException ex)
    {
      ex.printStackTrace();
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
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Dwarf"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Half-Elf"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Elf"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Halfling"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Human"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Dragonborn"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Gnome"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Half-Orc"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }
      else if (rs.getString("name").equals("Tiefling"))
      {
        Race r = new Race(rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        races.add(r);
      }

    }
  }


  private void loadSubRaces() throws SQLException
  {Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Subraces\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      if (rs.getString("name").equals("Hill Dwarf"))
      {
        System.out.println("hdwarf");
        Subrace hillDwarf = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(hillDwarf);
      }
      else if (rs.getString("name").equals("Mountain Dwarf"))
      { System.out.println("mdwarf");
        Subrace mountainDwarf = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(mountainDwarf);
      }
      else if (rs.getString("name").equals("High Elf"))
      { System.out.println("helf");
        Subrace highElf = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(highElf);
      }
      else if (rs.getString("name").equals("Wood Elf"))
      { System.out.println("welf");
        Subrace woodElf = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(woodElf);
      }
      else if (rs.getString("name").equals("Dark Elf (Drow)"))
      {
        Subrace drow = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(drow);
      }
      else if (rs.getString("name").equals("Lightfoot"))
      {
        Subrace lightfoot = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(lightfoot);
      }
      else if (rs.getString("name").equals("Stout"))
      {
        Subrace stout = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(stout);
      }
      else if (rs.getString("name").equals("Forest Gnome"))
      {
        Subrace forestGnome = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(forestGnome);
      }
      else if (rs.getString("name").equals("Rock Gnome"))
      {
        Subrace rockGnome = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
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

        Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
        skills.add(skill);
      }
    }
    if (rs.getString("name").equals("Animal Handling"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Arcana"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Athletics"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Deception"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("History"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Insight"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Intimidation"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Investigation"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Medicine"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Nature"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Perception"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Insight"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Insight"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Insight"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Insight"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Insight"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }
    if (rs.getString("name").equals("Insight"))
    {

      Skill skill = new Skill(rs.getString("ability"),rs.getString("name"),rs.getString("description"));
      skills.add(skill);
    }

  }








  private void loadSpells() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Spell\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      if (rs.getString("name").equals("Acid Arrow"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      else if (rs.getString("name").equals("Acid Splash"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      else if (rs.getString("name").equals("Aid"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      else if (rs.getString("name").equals("Alarm"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      else if (rs.getString("name").equals("Alter Self"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      else if (rs.getString("name").equals("Animal Friendship"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      else if (rs.getString("name").equals("Animal Messanger"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      else if (rs.getString("name").equals("Animal Shapes"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      else if (rs.getString("name").equals("Animate Dead"))
      {

        Spell spell = new Spell(rs.getString("name"), rs.getString("spellLevel"),
            rs.getString("school"), rs.getString("castTime"), rs.getString("range"),
            rs.getString("components"), rs.getString("duration"), rs.getString("description"),
            rs.getString("class"));
        spells.add(spell);
      }
      //more spells needed in database;
    }


  }
  private void loadSubClasses() throws SQLException
  {Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Subclasses\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
      if (rs.getString("name").equals("Path of the Berserker"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Path of the Totem Warrior"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("College of Lore"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("College of Valor"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Knowledge Domain"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Life Domain"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Light Domain"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Nature Domain"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Tempest Domain"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Trickery Domain"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("War Domain"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Assassin"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Circle of the Land"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Circle of the Moon"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Champion"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Battle Master"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Eldritch Knight"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Way of the Open Hand"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Way of Shadow"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Way of the Four Elements"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      } if (rs.getString("name").equals("Oath of Devotion"))
    {
      Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
          rs.getString("description"));
      subclasses.add(barbarian);

    } if (rs.getString("name").equals("Oath of the Ancients"))
    {
      Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
          rs.getString("description"));
      subclasses.add(barbarian);

    }
      if (rs.getString("name").equals("Oath of Vengeance"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Hunter"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Beast Master"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Thief"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Arcane Trickster"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Draconic Bloodline"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("Wild Magic"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("The Archfey"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("The Fiend"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("The Great Old One"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("School of Abjuration"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("School of Conjuration"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("School of Divination"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("School of Enchantment"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("School of Evocation"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("School of Illusion"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("School of Necromancy"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }
      if (rs.getString("name").equals("School of Transmutation"))
      {
        Subclass barbarian = new Subclass(rs.getString("name"),rs.getString("mainClass"),
            rs.getString("description"));
        subclasses.add(barbarian);

      }





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

}
