package system.model.characterClasses;

import system.model.businessModel.Feat;
import system.model.businessModel.Proficiency;

import java.util.ArrayList;

public class CharacterClass
{
  private int hitDiceType;
  private ArrayList<Feat> classFeats;
  private ArrayList<Integer> classFeatLevels;
  private String description;
  private String primaryAbility;
  private ArrayList<Proficiency> featModifiers;

  public CharacterClass()
  {
  }

  public CharacterClass(int hitDiceType, ArrayList<Feat> classFeats, ArrayList<Integer> classFeatLevels,
      String description, String primary, ArrayList<Proficiency> featModifiers)
  {
    this.hitDiceType = hitDiceType;
    this.classFeats = classFeats;
    this.classFeatLevels = classFeatLevels;
    this.description = description;
    this.primaryAbility = primary;
    this.featModifiers = featModifiers;
  }


  public void setHitDiceType(int hitDiceType)
  {
    this.hitDiceType = hitDiceType;
  }

  public ArrayList<Feat> getClassFeats()
  {
    return classFeats;
  }

  public void setClassFeats(ArrayList<Feat> classFeats)
  {
    this.classFeats = classFeats;
  }

  public ArrayList<Integer> getClassFeatLevels()
  {
    return classFeatLevels;
  }

  public void setClassFeatLevels(ArrayList<Integer> classFeatLevels)
  {
    this.classFeatLevels = classFeatLevels;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getClassName()
  {
    return getClass().getName();
  }

  public int getHitDiceType()
  {
    return hitDiceType;
  }

  public String getPrimaryAbility()
  {
    return primaryAbility;
  }

  public void setPrimaryAbility(String primaryAbility)
  {
    this.primaryAbility = primaryAbility;
  }

  public ArrayList<Proficiency> getFeatModifiers()
  {
    return featModifiers;
  }

  public void setFeatModifiers(ArrayList<Proficiency> featModifiers)
  {
    this.featModifiers = featModifiers;
  }
}
