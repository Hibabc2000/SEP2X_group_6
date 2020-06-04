package system.transferobjects.login;

import system.model.businessModel.Character;
import system.model.businessModel.DiceRoll;

/**
 * @author Oliver Izsák, 293131
 * @version 1.1.0
 * this class is the Player stores information about the player.
 */
public class Player implements User
{
  private Character character;

  private String playerName;

 private Integer characterID;
  public Player(String name)
  {
    playerName = name;
  characterID=null;
  }

  /**
 * Sets a character.
 * @param ch Character
 */
  public void setCharacter(Character ch)
  {
    character = ch;
  }

  /**
   * Sets the character's ID.
   * @param i Integer
   */
  public void addCharacterID(Integer i)
  {
    characterID = i;
  }
  /**
   * Returns the ID of the character.
   * @return  value of characterID
   */
  public Integer getCharacterID()
  {
    return  characterID;
  }


  /**
   * Returns the name of the player.
   * @return  String playerName
   */
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
