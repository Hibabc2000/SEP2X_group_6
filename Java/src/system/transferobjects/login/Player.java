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
  public void setCharacter(Character ch)
  {
    character = ch;
  }
  public void addCharacterID(Integer i)
  {
    characterID = i;
  }
  public Integer getCharacterID()
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
