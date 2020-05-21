package system.model.characterClasses;

import system.model.businessModel.Ability;
import system.model.businessModel.Feat;

import java.util.ArrayList;

public abstract class CharacterClass
{
  private int hitDiceType;
  private int levelInClass;
  private ArrayList<Feat> classFeats;
  private ArrayList<Integer> classFeatLevels;
  private String description;
  private Ability primary;

  public String getClassName()
  {
    return getClass().getName();
  }

  public int getLevelInClass()
  {
    return levelInClass;
  }
}
