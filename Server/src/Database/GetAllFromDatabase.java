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
       if (rs.getString("equipment").equals("(Padded,\" Padded armor consists of quilted layers of cloth and batting.\",5,8)"))
      {

        EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
            rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
        equipmentArmors.add(ea);
      }
       else if (rs.getString("equipment").equals("(Hide,\" This crude armor consists of thick furs and pelts. It is commonly worn by barbarian tribes, evil humanoids, and other folk who lack access to the tools and materials needed to create better armor.\",10,12)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(\"Studded leather\",\" Made from tough but flexible leather, studded leather is reinforced with close-set rivets or spikes.\",45,13)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(Leather,\" The breastplate and shoulder protectors of this armor are made of leather that has been stiffened by being boiled in oil. The rest of the armor is made of softer and more flexible materials.\",10,10)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(\"Chain shirt\",\" Made of interlocking metal rings, a chain shirt is worn between layers of clothing or leather. This armor offers modest protection to the wearer's upper body and allows the sound of the rings rubbing against one another to be muffled by outer layers.\",50,20)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(\"Scale mail\",\" This armor consists of a coat and leggings (and perhaps a separate skirt) of leather covered with overlapping pieces of metal, much like the scales of a fish. The suit includes gauntlets.\",50,45)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(Breastplate,\" This armor consists of a fitted metal chest piece worn with supple leather. Although it leaves the legs and arms relatively unprotected, this armor provides good protection for the wearer's vital organs while leaving the wearer relatively unencumbered.\",400,20)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(\"Half plate\",\" Half plate consists of shaped metal plates that cover most of the wearer's body. It does not include leg protection beyond simple greaves that are attached with leather straps.\",750,40)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(\"Ring mail\",\" This armor is leather armor with heavy rings sewn into it. The rings help reinforce the armor against blows from swords and axes. Ring mail is inferior to chain mail, and it's usually worn only by those who can't afford better armor.\",30,40)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(\"Chain mail\",\" Made of interlocking metal rings, chain mail includes a layer of quilted fabric worn underneath the mail to prevent chafing and to cushion the impact of blows. The suit includes gauntlets.\",75,55)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(Splint,\" This armor is made of narrow vertical strips of metal riveted to a backing of leather that is worn over cloth padding. Flexible chain mail protects the joints.\",200,60)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }
       else if (rs.getString("equipment").equals("(Plate,\" Plate consists of shaped, interlocking metal plates to cover the entire body. A suit of plate includes gauntlets, heavy leather boots, a visored helmet, and thick layers of padding underneath the armor. Buckles and straps distribute the weight over the body.\",1500,65)"))
       {

         EquipmentArmor  ea= new EquipmentArmor(rs.getString("equipment"), rs.getString("armorClass"),
             rs.getString("dexMod"), rs.getString("stealth"), rs.getString("strength"));
         equipmentArmors.add(ea);
       }



    }


  }
  private void loadEquipmentGeneral() throws SQLException
  {
    Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Equipment_general\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
       if (rs.getString("equipment").equals("(\"Parchment (one sheet)\",\" \",0.1,0)"))
      {

        EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
        equipmentGenerals.add(eg);
      }
       else if (rs.getString("equipment").equals("(\"Perfume (vial)\",\" \",5,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }
       else if (rs.getString("equipment").equals("(\"Pick, miner's\",\" \",2,10)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }
       else if (rs.getString("equipment").equals("(Piton,\" \",0.05,0.25)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Pole (10-foot)\",\" \",0.05,7)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Pot, iron\",\" \",2,10)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Potion of healing\",\" A character who drinks the magical red fluid in this vial regains 2d4 + 2 hit points. Drinking or administering a potion takes an action.\",50,0.5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Pouch,\" A cloth or leather pouch can hold up to 20 sling bullets or 50 blowgun needles, among other things. A compartmentalized pouch for holding spell components is called a component pouch (described earlier in this section).\",0.5,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Quiver,\" A quiver can hold up to 20 arrows.\",1,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Ram, portable\",\" You can use a portable ram to break down doors. When doing so, you gain a +4 bonus on the Strength check. One other character can help you use the ram, giving you advantage on this check.\",4,35)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Rations (1 day)\",\" Rations consist of dry foods suitable for extended travel, including jerky, dried fruit, hardtack, and nuts.\",0.5,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Robes,\" \",1,4)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Rope, hempen (50 feet)\",\" Rope, whether made of hemp or silk, has 2 hit points and can be burst with a DC 17 Strength check.\",1,10)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Rope, silk (50 feet)\",\" Rope, whether made of hemp or silk, has 2 hit points and can be burst with a DC 17 Strength check.\",10,5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Sack,\" Capacity: 1 cubic foot/30 pounds of gear.\",0.01,0.5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Scale, merchant's\",\" A scale includes a small balance, pans, and a suitable assortment of weights up to 2 pounds. With it, you can measure the exact weight of small objects, such as raw precious metals or trade goods, to help determine their worth.\",5,3)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Sealing wax\",\" \",0.5,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Shovel,\" \",2,5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Signal whistle\",\" \",0.05,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Signet ring\",\" \",5,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Soap,\" \",0.02,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Spellbook,\" Essential for wizards, a spellbook is a leather-bound tome with 100 blank vellum pages suitable for recording spells.\",50,3)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Spikes, iron (10)\",\" \",1,5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Spyglass,\" Objects viewed through a spyglass are magnified to twice their size.\",1000,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Tent, two-person\",\" A simple and portable canvas shelter, a tent sleeps two.\",2,20)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Tinderbox,\" This small container holds flint, fire steel, and tinder (usually dry cloth soaked in light oil) used to kindle a fire. Using it to light a torch — or anything else with abundant, exposed fuel — takes an action. Lighting any other fire takes 1 minute.\",0.5,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Torch,\" A torch burns for 1 hour, providing bright light in a 20-foot radius and dim light for an additional 20 feet. If you make a melee attack with a burning torch and hit, it deals 1 fire damage.\",0.01,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Vial,\" Capacity: 4 ounces liquid.\",1,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Waterskin,\" Capacity: 4 pints liquid.\",0.2,5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Whetstone,\" \",0.01,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Arrows (20)\",\" \",1,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Blowgun needles (50)\",\" \",1,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Crossbow bolts (20)\",\" \",1,1.5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Sling bullets (20)\",\" \",0.04,1.5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Crystal,\" An arcane focus is a special item — an orb, a crystal, a rod, a specially constructed staff, a wand-like length of wood, or some similar item — designed to channel the power of arcane spells. A sorcerer, warlock, or wizard can use such an item as a spellcasting focus, as described in chapter 10.\",10,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Orb,\" An arcane focus is a special item — an orb, a crystal, a rod, a specially constructed staff, a wand-like length of wood, or some similar item — designed to channel the power of arcane spells. A sorcerer, warlock, or wizard can use such an item as a spellcasting focus, as described in chapter 10.\",20,3)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Rod,\" An arcane focus is a special item — an orb, a crystal, a rod, a specially constructed staff, a wand-like length of wood, or some similar item — designed to channel the power of arcane spells. A sorcerer, warlock, or wizard can use such an item as a spellcasting focus, as described in chapter 10.\",10,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Staff,\" An arcane focus is a special item — an orb, a crystal, a rod, a specially constructed staff, a wand-like length of wood, or some similar item — designed to channel the power of arcane spells. A sorcerer, warlock, or wizard can use such an item as a spellcasting focus, as described in chapter 10.\",5,4)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Wand,\" An arcane focus is a special item — an orb, a crystal, a rod, a specially constructed staff, a wand-like length of wood, or some similar item — designed to channel the power of arcane spells. A sorcerer, warlock, or wizard can use such an item as a spellcasting focus, as described in chapter 10.\",10,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Sprig of mistletoe\",\" A druidic focus might be a sprig of mistletoe or holly, a wand or scepter made of yew or another special wood, a staff drawn whole out of a living tree, or a totem object incorporating feathers, fur, bones, and teeth from sacred animals. A druid can use such an object as a spellcasting focus, as described in chapter 10.\",1,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Totem,\" A druidic focus might be a sprig of mistletoe or holly, a wand or scepter made of yew or another special wood, a staff drawn whole out of a living tree, or a totem object incorporating feathers, fur, bones, and teeth from sacred animals. A druid can use such an object as a spellcasting focus, as described in chapter 10.\",1,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Wooden staff\",\" A druidic focus might be a sprig of mistletoe or holly, a wand or scepter made of yew or another special wood, a staff drawn whole out of a living tree, or a totem object incorporating feathers, fur, bones, and teeth from sacred animals. A druid can use such an object as a spellcasting focus, as described in chapter 10.\",5,4)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Yew wand\",\" A druidic focus might be a sprig of mistletoe or holly, a wand or scepter made of yew or another special wood, a staff drawn whole out of a living tree, or a totem object incorporating feathers, fur, bones, and teeth from sacred animals. A druid can use such an object as a spellcasting focus, as described in chapter 10.\",10,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Amulet,\" A holy symbol is a representation of a god or pantheon. It might be an amulet depicting a symbol representing a deity, the same symbol carefully engraved or inlaid as an emblem on a shield, or a tiny box holding a fragment of a sacred relic. A cleric or paladin can use a holy symbol as a spellcasting focus, as described in chapter 10. To use the symbol in this way, the caster must hold it in hand, wear it visibly, or bear it on a shield.\",5,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Emblem,\" A holy symbol is a representation of a god or pantheon. It might be an amulet depicting a symbol representing a deity, the same symbol carefully engraved or inlaid as an emblem on a shield, or a tiny box holding a fragment of a sacred relic. A cleric or paladin can use a holy symbol as a spellcasting focus, as described in chapter 10. To use the symbol in this way, the caster must hold it in hand, wear it visibly, or bear it on a shield.\",5,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Reliquary,\" A holy symbol is a representation of a god or pantheon. It might be an amulet depicting a symbol representing a deity, the same symbol carefully engraved or inlaid as an emblem on a shield, or a tiny box holding a fragment of a sacred relic. A cleric or paladin can use a holy symbol as a spellcasting focus, as described in chapter 10. To use the symbol in this way, the caster must hold it in hand, wear it visibly, or bear it on a shield.\",5,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Abacus,\" \",2,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Acid (vial)\",\" As an action, you can splash the contents of this vial onto a creature within 5 feet of you or throw the vial up to 20 feet, shattering it on impact. In either case, make a ranged attack against a creature or object, treating the acid as an improvised weapon. On a hit, the target takes 2d6 acid damage.\",25,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Alchemist's fire (flask)\",\" This sticky, adhesive fluid ignites when exposed to air. As an action, you can throw this flask up to 20 feet, shattering it on impact. Make a ranged attack against a creature or object, treating the alchemist's fire as an improvised weapon. On a hit, the target takes 1d4 fire damage at the start of each of its turns. A creature can end this damage by using its action to make a DC 10 Dexterity check to extinguish the flames.\",50,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Antitoxin (vial)\",\" A creature that drinks this vial of liquid gains advantage on saving throws against poison for 1 hour. It confers no benefit to undead or constructs.\",50,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Backpack,\" Capacity: 1 cubic foot/30 pounds of gear. You can also strap items, such as a bedroll or a coil of rope, to the outside of a backpack.\",2,5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Ball bearings (bag of 1,000)\",\" As an action, you can spill these tiny metal balls from their pouch to cover a level, square area that is 10 feet on a side. A creature moving across the covered area must succeed on a DC 10 Dexterity saving throw or fall prone. A creature moving through the area at half speed doesn't need to make the save.\",1,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Barrel,\" Capacity: 40 gallons liquid, 4 cubic feet solid.\",2,70)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Basket,\" Capacity: 2 cubic feet/40 pounds of gear.\",0.4,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Bedroll,\" \",1,7)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Bell,\" \",1,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Blanket,\" \",0.5,3)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Block and tackle\",\" A set of pulleys with a cable threaded through them and a hook to attach to objects, a block and tackle allows you to hoist up to four times the weight you can normally lift.\",1,5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Book,\" A book might contain poetry, historical accounts, information pertaining to a particular field of lore, diagrams and notes on gnomish contraptions, or just about anything else that can be represented using text or pictures. A book of spells is a spellbook (described later in this section).\",25,5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Bottle, glass\",\" Capacity: 1 1/2 pints liquid.\",2,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Bucket,\" Capacity: 3 gallons liquid, 1/2 cubic foot solid.\",0.05,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Caltrops (bag of 20)\",\" As an action, you can spread a bag of caltrops to cover a square area that is 5 feet on a side. Any creature that enters the area must succeed on a DC 15 Dexterity saving throw or stop moving this turn and take 1 piercing damage. Taking this damage reduces the creature's walking speed by 10 feet until the creature regains at least 1 hit point. A creature moving through the area at half speed doesn't need to make the save.\",1,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Candle,\" For 1 hour, a candle sheds bright light in a 5-foot radius and dim light for an additional 5 feet.\",0.01,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Case, crossbow bolt\",\" This wooden case can hold up to twenty crossbow bolts.\",1,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Case, map or scroll\",\" This cylindrical leather case can hold up to ten rolled-up sheets of paper or five rolled-up sheets of parchment.\",1,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Chain (10 feet)\",\" A chain has 10 hit points. It can be burst with a successful DC 20 Strength check.\",5,10)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Chalk (1 piece)\",\" \",0.01,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Chest,\" Capacity: 12 cubic feet/300 pounds gear.\",5,25)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Climber's kit\",\" A climber's kit includes special pitons, boot tips, gloves, and a harness. You can use the climber's kit as an action to anchor yourself; when you do, you can't fall more than 25 feet from the point where you anchored yourself, and you can't climb more than 25 feet away from that point without undoing the anchor.\",25,12)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Clothes, common\",\" \",0.5,3)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Clothes, costume\",\" \",5,4)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Clothes, fine\",\" \",15,6)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Clothes, traveler's\",\" \",2,4)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Component pouch\",\" A component pouch is a small, watertight leather belt pouch that has compartments to hold all the material components and other special items you need to cast your spells, except for those components that have a specific cost (as indicated in a spell's description).\",25,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Crowbar,\" Using a crowbar grants advantage to Strength checks where the crowbar's leverage can be applied.\",2,5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Fishing tackle\",\" This kit includes a wooden rod, silken line, corkwood bobbers, steel hooks, lead sinkers, velvet lures, and narrow netting.\",1,4)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Flask or tankard\",\" Capacity: 1 pint liquid.\",0.02,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Grappling hook\",\" \",2,4)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Hammer,\" \",1,3)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Hammer, sledge\",\" \",2,10)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Healer's kit\",\" This kit is a leather pouch containing bandages, salves, and splints. The kit has ten uses. As an action, you can expend one use of the kit to stabilize a creature that has 0 hit points, without needing to make a Wisdom (Medicine) check.\",5,3)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Holy water (flask)\",\" As an action, you can splash the contents of this flask onto a creature within 5 feet of you or throw it up to 20 feet, shattering it on impact. In either case, make a ranged attack against a target creature, treating the holy water as an improvised weapon. If the target is a fiend or undead, it takes 2d6 radiant damage. A cleric or paladin may create holy water by performing a special ritual. The ritual takes 1 hour to perform, uses 25 gp worth of powdered silver, and requires the caster to expend a 1st-level spell slot.\",25,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Hourglass,\" \",25,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Hunting trap\",\" When you use your action to set it, this trap forms a saw-toothed steel ring that snaps shut when a creature steps on a pressure plate in the center. The trap is affixed by a heavy chain to an immobile object, such as a tree or a spike driven into the ground. A creature that steps on the plate must succeed on a DC 13 Dexterity saving throw or take 1d4 piercing damage and stop moving. Thereafter, until the creature breaks free of the trap, its movement is limited by the length of the chain (typically 3 feet long). A creature can use its action to make a DC 13 Strength check, freeing itself or another creature within its reach on a success. Each failed check deals 1 piercing damage to the trapped creature.\",5,25)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Ink (1 ounce bottle)\",\" \",10,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Ink pen\",\" \",0.02,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Jug or pitcher\",\" Capacity: 1 gallon liquid.\",0.02,4)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Ladder (10 foot)\",\" \",0.1,25)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Lamp,\" A lamp casts bright light in a 15-foot radius and dim light for an additional 30 feet. Once lit, it burns for 6 hours on a flask (1 pint) of oil.\",0.5,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Lantern, bullseye\",\" A bullseye lantern casts bright light in a 60-foot cone and dim light for an additional 60 feet. Once lit, it burns for 6 hours on a flask (1 pint) of oil.\",10,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Lantern, hooded\",\" A hooded lantern casts bright light in a 30-foot radius and dim light for an additional 30 feet. Once lit, it burns for 6 hours on a flask (1 pint) of oil. As an action, you can lower the hood, reducing the light to dim light in a 5-foot radius.\",5,2)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Lock,\" A key is provided with the lock. Without the key, a creature proficient with thieves' tools can pick this lock with a successful DC 15 Dexterity check. Your DM may decide that better locks are available for higher prices.\",10,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Magnifying glass\",\" This lens allows a closer look at small objects. It is also useful as a substitute for flint and steel when starting fires. Lighting a fire with a magnifying glass requires light as bright as sunlight to focus, tinder to ignite, and about 5 minutes for the fire to ignite. A magnifying glass grants advantage on any ability check made to appraise or inspect an item that is small or highly detailed.\",100,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(Manacles,\" These metal restraints can bind a Small or Medium creature. Escaping the manacles requires a successful DC 20 Dexterity check. Breaking them requires a successful DC 20 Strength check. Each set of manacles comes with one key. Without the key, a creature proficient with thieves' tools can pick the manacles' lock with a successful DC 15 Dexterity check. Manacles have 15 hit points.\",2,6)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Mess kit\",\" This tin box contains a cup and simple cutlery. The box clamps together, and one side can be used as a cooking pan and the other as a plate or shallow bowl.\",0.2,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Mirror, steel\",\" \",5,0.5)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("(\"Oil (flask)\",\" Oil usually comes in a clay flask that holds 1 pint. As an action, you can splash the oil in this flask onto a creature within 5 feet of you or throw it up to 20 feet, shattering it on impact. Make a ranged attack against a target creature or object, treating the oil as an improvised weapon. On a hit, the target is covered in oil. If the target takes any fire damage before the oil dries (after 1 minute), the target takes an additional 5 fire damage from the burning oil. You can also pour a flask of oil on the ground to cover a 5-foot-square area, provided that the surface is level. If lit, the oil burns for 2 rounds and deals 5 fire damage to any creature that enters the area or ends its turn in the area. A creature can take this damage only once per turn.\",0.1,1)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }else if (rs.getString("equipment").equals("((\"Paper (one sheet)\",\" \",0.2,0)"))
       {

         EquipmentGeneral eg = new EquipmentGeneral(rs.getString("equipment"));
         equipmentGenerals.add(eg);
       }
































































































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
        Subrace hillDwarf = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(hillDwarf);
      }
      else if (rs.getString("name").equals("Mountain Dwarf"))
      {
        Subrace mountainDwarf = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(mountainDwarf);
      }
      else if (rs.getString("name").equals("High Elf"))
      {
        Subrace highElf = new Subrace(rs.getString("mainRace"),rs.getString("name"),
            rs.getString("description"),rs.getString("traits"));
        subraces.add(highElf);
      }
      else if (rs.getString("name").equals("Wood Elf"))
      {
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
  {Statement st = c.createStatement();
    String query = "SELECT * FROM \"Core\".\"Equipment_weapons\"";
    ResultSet rs = st.executeQuery(query);

    while (rs.next())
    {
       if (rs.getString("equipment").equals("(Club,\" \",0.1,2)"))
      {

        EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
            rs.getString("properties"),rs.getString("weaponType"));
        equipmentWeaponList.add(ew);
      }
       else if (rs.getString("equipment").equals("(Dagger,\" \",2,1)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Greatclub,\" \",0.2,10)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Handaxe,\" \",5,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Javelin,\" \",0.5,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(\"Light hammer\",\" \",2,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Mace,\" \",5,4)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Quarterstaff,\" \",0.2,4)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Sickle,\" \",1,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Spear,\" \",1,3)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }else if (rs.getString("equipment").equals("(\"Crossbow, light\",\" \",25,5)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Dart,\" \",0.05,0.25)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Shortbow,\" \",25,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Sling,\" \",0.1,0)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Battleaxe,\" \",10,4)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Flail,\" \",10,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Glaive,\" \",20,6)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Greataxe,\" \",30,7)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Greatsword,\" \",50,6)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Halberd,\" \",20,6)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Lance,\" \",10,6)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Longsword,\" \",15,3)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Maul,\" \",10,10)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Morningstar,\" \",15,4)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Pike,\" \",5,18)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Rapier,\" \",25,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Scimitar,\" \",25,3)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Shortsword,\" \",10,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Trident,\" \",5,4)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(\"War pick\",\" \",5,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Warhammer,\" \",15,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Whip,\" \",2,3)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Blowgun,\" \",10,1)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(\"Crossbow, heavy\",\" \",50,18)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Longbow,\" \",50,2)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }
       else if (rs.getString("equipment").equals("(Net,\" \",1,3)"))
       {

         EquipmentWeapon ew = new EquipmentWeapon(rs.getString("equipment"),rs.getString("damage"),
             rs.getString("properties"),rs.getString("weaponType"));
         equipmentWeaponList.add(ew);
       }



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
