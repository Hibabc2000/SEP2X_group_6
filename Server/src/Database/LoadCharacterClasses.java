package Database;

import system.model.businessModel.Feat;
import system.model.businessModel.Proficiency;
import system.model.characterClasses.*;

import java.sql.*;
import java.util.ArrayList;

public class LoadCharacterClasses
{
  /**
   * Class for loading character classes.
   */
  private Connection connection;
  private ArrayList<CharacterClass> classList;

  public LoadCharacterClasses()
  {
    /**
     * Constructor method for LoadCharacterClasses. Gets the PostgreSQL connection.
     */
    try
    {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/SEP2", "postgres",
              "Aoe3tadtwc-2000");
      classList = new ArrayList<>();
    }
    catch (SQLException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    classList = new ArrayList<>();
  }

  public ArrayList<CharacterClass> load() throws SQLException
  {
    /**
     * Main method for loading character classes and class feats.
     */
    Statement st = connection.createStatement();
    String query = "SELECT * FROM \"Core\".\"CharacterClass\";";
    ResultSet rs = st.executeQuery(query);
    while (rs.next())
    {
      if (rs.getString("name").equals("Barbarian"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_barbarian\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          featLevels.add(feat.getInt("level"));
          feats.add(feat1);
        }
        Barbarian b = new Barbarian(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Bard"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Bard b = new Bard(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Cleric"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Cleric b = new Cleric(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Druid"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Druid b = new Druid(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Fighter"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Fighter b = new Fighter(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Monk"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Monk b = new Monk(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Paladin"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Paladin b = new Paladin(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Ranger"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Ranger b = new Ranger(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Rogue"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Rogue b = new Rogue(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Sorcerer"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Sorcerer b = new Sorcerer(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Warlock"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Warlock b = new Warlock(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
      else if (rs.getString("name").equals("Wizard"))
      {
        query = "SELECT * FROM \"Core\".\"Feat_bard\";";
        ResultSet feat = st.executeQuery(query);
        ArrayList<Proficiency> featModifiers = new ArrayList<>();
        ArrayList<Feat> feats = new ArrayList<>();
        ArrayList<Integer> featLevels = new ArrayList<>();
        while (feat.next())
        {
          String[] temp = feat.getString("feat").split(",\"");
          Feat feat1 = new Feat("class", temp[0], temp[1]);
          featModifiers = new ArrayList<>(parseModifiers(temp[2]));
          feats.add(feat1);
        }
        Wizard b = new Wizard(rs.getInt("hitDiceType"), feats, featLevels,
            rs.getString("description"), rs.getString("primaryAbility"), featModifiers);
        classList.add(b);
      }
    }
    return classList;
  }

  private ArrayList<Proficiency> parseModifiers(String modifiers)
  {
    /**
     * Special parser method for proficiencies and other modifiers.
     */
    ArrayList<Proficiency> arr = new ArrayList<>();
    String[] temp = modifiers.split("|");
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
      else d = 1;
      Proficiency p = new Proficiency(s2[0], s2[1], "class", d);
      arr.add(p);
    }
    return arr;
  }
}
