package system;

import system.model.CharacterClasses.CharacterClass;
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
  private ArrayList<String> equipmentList; //just names, get desc from database if necessary
  private ArrayList<Integer> equipmentAmount; //just the amount of stuff the character has

  public Character()   // need to consult with group about this class
  {

  }
}
