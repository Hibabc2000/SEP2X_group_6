package system.model.characterClasses;

import system.model.businessModel.Feat;

import java.util.ArrayList;

public class CharacterClass
{
  private int hitDiceType;
  private ArrayList<Feat> classFeats;
  private ArrayList<Integer> classFeatLevels;
  private String description;
  private String primaryAbility;

  public CharacterClass()
  {
  }

  public CharacterClass(int hitDiceType, ArrayList<Feat> classFeats, ArrayList<Integer> classFeatLevels,
      String description, String primary)
  {
    this.hitDiceType = hitDiceType;
    this.classFeats = classFeats;
    this.classFeatLevels = classFeatLevels;
    this.description = description;
    this.primaryAbility = primary;
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

}
