package login;

import java.util.Random;

public class DiceRoll
{
  public int RollDice(int diceType, int diceCount)  // basic diceroll method
  { int rolled=0;
    Random roll = new Random();
    for(int i =0; i<diceCount;i++)
    {
      rolled += roll.nextInt(diceType) + 1;
    }
    return rolled;
  }
}
