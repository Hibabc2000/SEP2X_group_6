package system.transferobjects.login;

import system.DiceRoll;

import java.io.Serializable;

public class DM implements User, Serializable
{
  private String nameDM;
  private Group groupDM;

  public DM(String name)
  {
    nameDM = name;
  }

  public String getName()
  {
    return nameDM;
  }

  @Override public int rollDice(int diceType, int diceCount)
  {
    DiceRoll roll = new DiceRoll();
    return roll.RollDice(diceType, diceCount);

  }

}
