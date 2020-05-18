package system;

import system.model.characterClasses.CharacterClass;
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
  private String physicalCharacteristics;
  private String alignment;
  private String background;
  private ArrayList<Feat> feats;
  private int hp;
  private int rolledHp;
  //things like ideals, flaws, bonds etc
  private String personalCharacteristics;
  private String languages;
  private boolean[][] spellSlots;
  private String treasures;
  //private ArrayList<Integer> equipmentAmount; //just the amount of stuff the character has

  public Character()   // need to consult with group about this class
  {

  }


}
