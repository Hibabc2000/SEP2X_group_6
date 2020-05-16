package system.model.CharacterClasses;

import system.Feat;

import java.util.ArrayList;

public interface  CharacterClass
{
  int  hitDiceType();
   int levelInClass();
   ArrayList<Feat> classFeats();
 ArrayList<Integer> classFeatLevels();
 String description();


}
