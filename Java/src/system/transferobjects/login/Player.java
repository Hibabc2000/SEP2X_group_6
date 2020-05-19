package system.transferobjects.login;

import system.Character;
import system.DiceRoll;

import java.io.Serializable;

public class Player implements User, Serializable
{
  private Character character;

  private String playerName;
  private Group playerGroup;
 private int characterID;
  public Player(String name)                   // more information needed about player class
  {
    playerName = name;

  }

  public void createCharacter()    //
  {

  }
  public void addCharacterID(Integer i)
  {
    characterID = i;
  }
  public int getCharacterID()
  {
    return  characterID;
  }
  public void addGroup(Group gr)
  {
    playerGroup = gr;
  }
  public Group getPlayerGroup()
  {
    return playerGroup;
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
