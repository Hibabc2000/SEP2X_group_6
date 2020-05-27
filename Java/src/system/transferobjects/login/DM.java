package system.transferobjects.login;

import system.model.businessModel.DiceRoll;

public class DM implements User
{
  private String nameDM;
  private Group groupDM;

  public DM(String name)
  {
    nameDM = name;
  }
  /**
   * Retruns the username.
   * @return  String  variable nameDM
   */
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
