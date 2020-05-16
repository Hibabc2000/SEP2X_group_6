package system.model.CharacterClasses;

import system.Ability;
import system.Feat;

import java.util.ArrayList;

public abstract class CharacterClass
{
  private int hitDiceType;
  private int levelInClass;
  private ArrayList<Feat> classFeats;
  private ArrayList<Integer> classFeatLevels;
  private String description;
  private Ability primary;
}
