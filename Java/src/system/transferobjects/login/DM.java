package system.transferobjects.login;

import system.model.businessModel.DiceRoll;
/**
 * @author Oliver Izsák, 293131
 * @version 1.2.0
 * this class is the DM, stores information about the DM
 */
public class DM implements User
{
  private String nameDM;


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
