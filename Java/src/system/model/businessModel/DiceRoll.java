package system.model.businessModel;

import java.util.Random;

public class DiceRoll
{
  /**
   * Returns a randomly created number or a sum of random numbers.
   * @param diceType int, this number represents the sides of a dice.
   * @param  diceCount int, this number represents how many dices were thrown.
   * @return  rolled value which is an int.
   */
  public int RollDice(int diceType, int diceCount)  // basic diceroll method
  {
    int rolled = 0;
    Random roll = new Random();
    for (int i = 0; i < diceCount; i++)
    {
      rolled += roll.nextInt(diceType) + 1;
    }
    return rolled;
  }
}
