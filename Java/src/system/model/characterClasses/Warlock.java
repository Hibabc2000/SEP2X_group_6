package system.model.characterClasses;

import system.model.businessModel.Feat;
import system.model.businessModel.Proficiency;

import java.util.ArrayList;

public class Warlock extends CharacterClass
{
  public Warlock(int hitDiceType, ArrayList<Feat> feats, ArrayList<Integer> featLevels, String description, String primaryAbility, ArrayList<Proficiency> featModifiers)
  {
    super(hitDiceType, feats, featLevels, description, primaryAbility, featModifiers);
  }
}
