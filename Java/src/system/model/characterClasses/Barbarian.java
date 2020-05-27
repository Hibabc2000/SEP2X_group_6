package system.model.characterClasses;

import system.model.businessModel.Feat;

import java.util.ArrayList;

public class Barbarian extends CharacterClass
{
  public Barbarian(int hitDiceType, ArrayList<Feat> feats, ArrayList<Integer> featLevels, String description, String primaryAbility)
  {
    super(hitDiceType, feats, featLevels, description, primaryAbility);
  }
}
