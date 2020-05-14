package system.model.loginModel;

import system.Character;
import system.DiceRoll;
import system.User;
import system.model.loginModel.Group;

public class Player implements User
{
  private Character character;

  private String playerName;
  private Group playerGroup;

  public Player(
      String name)                   // more information needed about player class
  {
    playerName = name;

  }

  public void createCharacter()    //
  {
    if (character == null)
      character = new Character();
  }

  public String getName()
  {
    return playerName;
  }

  @Override public int rollDice(int diceType, int diceCount)
  {
    DiceRoll roll = new DiceRoll();
    return roll.RollDice(diceType, diceCount);
  }

}
