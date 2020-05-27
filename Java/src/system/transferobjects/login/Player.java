package system.transferobjects.login;

import system.model.businessModel.Character;
import system.model.businessModel.DiceRoll;

public class Player implements User
{
  private Character character;

  private String playerName;
  private Group playerGroup;
 private Integer characterID;
  public Player(String name)                   // more information needed about player class
  {
    playerName = name;

  }

  public void createCharacter()    //
  {

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
