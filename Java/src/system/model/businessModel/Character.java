package system.model.businessModel;

import system.model.characterClasses.CharacterClass;
import system.model.businessModel.staticModel.StaticModel;

import java.util.ArrayList;

public class Character
{
  private int id;
  private Race race;
  private ArrayList<CharacterClass> characterClass;
  private String name;
  private int[] abilities; //6-element array
  private ArrayList<Proficiency> proficiencies; //Stores all proficiencies
  private ArrayList<Double> profLevel; //half (x0.5), full (x1), expert (x2) - just write multiplier
  private int[] money; //platinum, gold, electrum, silver, copper
  private ArrayList<Item> equipmentList; //just names, get desc from database if necessary
  private int xp;
  private int level;
  private ArrayList<Spell> spells;
  private ArrayList<Spell> spellBook;
  //private ArrayList<String> physicalCharacteristics; //gender, eyes, size, height, hair, skin, age, weight - in this order
  private String physicalCharacteristics;
  private String alignment;
  private String faith;
  private String background;
  private ArrayList<Feat> feats;
  private int hp;
  private int rolledHp;
  private int armorClass;
  private ArrayList<String> personalityTraits;
  private ArrayList<String> ideals;
  private ArrayList<String> bonds;
  private ArrayList<String> flaws;
  private boolean[][] spellSlots;
  private ArrayList<String> treasures;
  private StaticModel staticModel;

  public boolean equals(Object object)
  {
    if (!(object instanceof Character))
    {
      return false;
    }
    else
    {
      Character temporaryCharacter = (Character) object;
      if ((id == temporaryCharacter.getId()) && (race.equals(temporaryCharacter.getRace()))
          && (name.equals(temporaryCharacter.getName())) && (abilities.equals(temporaryCharacter.getAbilities()))
          && (proficiencies.equals(temporaryCharacter.getProficiencies())) && (profLevel
          .equals(temporaryCharacter.getProficiencies())) && (money.equals(temporaryCharacter.getMoney()))
          && (equipmentList.equals(temporaryCharacter.getEquipmentList())) && (xp
          == temporaryCharacter.getXp()) && (level == temporaryCharacter.getLevel())
          && (spells.equals(temporaryCharacter.getSpells())) && (spellBook.equals(temporaryCharacter.getSpellBook()))
          && (physicalCharacteristics.equals(temporaryCharacter.getPhysicalCharacteristics()))
          && (alignment.equals(temporaryCharacter.getAlignment())) && (background.equals(temporaryCharacter.getBackground()))
          && (feats.equals(temporaryCharacter.getFeats())) && (hp == temporaryCharacter
          .getHp()) && (rolledHp == temporaryCharacter.getRolledHp()) && (
          armorClass == temporaryCharacter.getArmorClass()) && (personalityTraits
          .equals(temporaryCharacter.getPersonalityTraits())) && (faith.equals(temporaryCharacter.getFaith()))
          && (ideals.equals(temporaryCharacter.getIdeals())) && (bonds.equals(temporaryCharacter.getBonds()))
          && (flaws.equals(temporaryCharacter.getFlaws())) && (spellBook.equals(temporaryCharacter.getSpellSlots()))
          && (treasures.equals(temporaryCharacter.getTreasures())))
      {

          if (characterClass.size() == temporaryCharacter.getCharacterClass().size())
          {
            for (int i = 0; i < characterClass.size(); i++)
            {
              if (!characterClass.get(i).getClassName().equals(
                  temporaryCharacter.getCharacterClass().get(i).getClassName()))
              {
                return false;
              }

            }
          }
          else
          {
            return true;
          }
          return false;


      }
      else {return false;}
    }

  }







  public Character(StaticModel staticModel)   //staticmodel has to be uploaded at instantiation, so that we can have the proficiency parser
  {
    this.staticModel = staticModel;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public Race getRace()
  {
    return race;
  }

  public void setRace(Race race)
  {
    this.race = race;
  }

  public ArrayList<CharacterClass> getCharacterClass()
  {
    return characterClass;
  }

  public void setCharacterClass(ArrayList<CharacterClass> characterClass)
  {
    this.characterClass = characterClass;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int[] getAbilities()
  {
    return abilities;
  }

  public void setAbilities(int[] abilities)
  {
    this.abilities = abilities;
  }

  public ArrayList<Proficiency> getProficiencies()
  {
    return proficiencies;
  }

  public void setProficiencies(ArrayList<Proficiency> proficiencies)
  {
    this.proficiencies = proficiencies;
  }

  public ArrayList<Double> getProfLevel()
  {
    return profLevel;
  }

  public void setProfLevel(ArrayList<Double> profLevel)
  {
    this.profLevel = profLevel;
  }

  public int[] getMoney()
  {
    return money;
  }

  public void setMoney(int[] money)
  {
    this.money = money;
  }

  public ArrayList<Item> getEquipmentList()
  {
    return equipmentList;
  }

  public void setEquipmentList(ArrayList<Item> equipmentList)
  {
    this.equipmentList = equipmentList;
  }

  public int getXp()
  {
    return xp;
  }

  public void setXp(int xp)
  {
    this.xp = xp;
  }

  public int getLevel()
  {
    return level;
  }

  public void setLevel(int level)
  {
    this.level = level;
  }

  public ArrayList<Spell> getSpells()
  {
    return spells;
  }

  public void setSpells(ArrayList<Spell> spells)
  {
    this.spells = spells;
  }

  public ArrayList<Spell> getSpellBook()
  {
    return spellBook;
  }

  public void setSpellBook(ArrayList<Spell> spellBook)
  {
    this.spellBook = spellBook;
  }


  /*
  public ArrayList<String> getPhysicalCharacteristics()
  {
    return physicalCharacteristics;
  }

   */
  public String getPhysicalCharacteristics()
  {
    return physicalCharacteristics;
  }
  /*
  public void setPhysicalCharacteristics(ArrayList<String> physicalCharacteristics)
  {
    this.physicalCharacteristics = physicalCharacteristics;
  }
   */

  public void setPhysicalCharacteristics(String physicalCharacteristics)
  {
    this.physicalCharacteristics = physicalCharacteristics;
  }

  public String getAlignment()
  {
    return alignment;
  }

  public void setAlignment(String alignment)
  {
    this.alignment = alignment;
  }

  public String getBackground()
  {
    return background;
  }

  public void setBackground(String background)
  {
    this.background = background;
  }

  public ArrayList<Feat> getFeats()
  {
    return feats;
  }

  public void setFeats(ArrayList<Feat> feats)
  {
    this.feats = feats;
  }

  public int getHp()
  {
    return hp;
  }

  public void setHp(int hp)
  {
    this.hp = hp;
  }

  public int getRolledHp()
  {
    return rolledHp;
  }

  public void setRolledHp(int rolledHp)
  {
    this.rolledHp = rolledHp;
  }

  public int getArmorClass()
  {
    return armorClass;
  }

  public void setArmorClass(int armorClass)
  {
    this.armorClass = armorClass;
  }

  public ArrayList<String> getPersonalityTraits()
  {
    return personalityTraits;
  }

  public void setPersonalityTraits(ArrayList<String> personalityTraits)
  {
    this.personalityTraits = personalityTraits;
  }

  public ArrayList<String> getIdeals()
  {
    return ideals;
  }

  public void setIdeals(ArrayList<String> ideals)
  {
    this.ideals = ideals;
  }

  public ArrayList<String> getBonds()
  {
    return bonds;
  }

  public void setBonds(ArrayList<String> bonds)
  {
    this.bonds = bonds;
  }

  public ArrayList<String> getFlaws()
  {
    return flaws;
  }

  public void setFlaws(ArrayList<String> flaws)
  {
    this.flaws = flaws;
  }

  public boolean[][] getSpellSlots()
  {
    return spellSlots;
  }

  public void setSpellSlots(boolean[][] spellSlots)
  {
    this.spellSlots = spellSlots;
  }

  public ArrayList<String> getTreasures()
  {
    return treasures;
  }

  public void setTreasures(ArrayList<String> treasures)
  {
    this.treasures = treasures;
  }

  public String getFaith()
  {
    return faith;
  }

  public void setFaith(String faith)
  {
    this.faith = faith;
  }

  public void parseProficiencies() //DO NOT TOUCH
  {
    for (Proficiency p : proficiencies)
    {
      if(p.getType().toLowerCase().equals("skill"))
      {
        for (Skill s : staticModel.getSkills())
        {
          if (p.getName().equals(s.getName()))
          {
            //send to viewmodel
          }
        }
      }
      else if (p.getType().toLowerCase().equals("ability"))
      {
        for (Ability a : staticModel.getAbilities())
        {
          if (p.getName().equals(a.getName()))
          {
            //send to viewmodel
          }
        }
      }
      else if (p.getType().toLowerCase().contains("weapon"))
      {
        if(p.getName().toLowerCase().contains("martial"))
        {
          //send to viewmodel
        }
        else if (p.getName().toLowerCase().contains("simple"))
        {
          //send to viewmodel
        }
        else
        {
          //send to viewmodel, select weapon
        }
      }
      else if (p.getType().toLowerCase().contains("armor"))
      {
        if(p.getName().toLowerCase().contains("all"))
        {

        }
        else if(p.getName().contains("light"))
        {

        }
        else if (p.getName().contains("medium"))
        {

        }
        else if(p.getName().contains("heavy"))
        {

        }
      }
      else if(p.getType().toLowerCase().contains("shield"))
      {

      }
      else if(p.getType().toLowerCase().contains("language"))
      {

      }
      else if(p.getType().toLowerCase().contains("cantrip"))
      {
        //add a cantrip
      }
      else if(p.getType().toLowerCase().contains("spell"))
      {
        //add a spell (1st-level), but not a spell slot
      }
      else
      {
        //parse for individual weapons, if not, then just note prof in Features and Traits bar
      }
    }
  }

  public String getUsername()
  {
    //write username getter
    return "";
  }

  public String getGroup()
  {
    //write groupname getter
    return "";
  }
}
