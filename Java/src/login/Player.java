package login;

import java.util.ArrayList;

public class Player implements User
{
  private ArrayList<Character> characterList;
  private ArrayList<Group> groupList;
  private String playerName;
  private Group playerGroups;
  public Player(String name)
  {  playerName=name;
    characterList =new ArrayList<>();
    groupList = new ArrayList<>();
  }
  public void  addCharacter(Character ch)
  {
    characterList.add(ch);
  }
  public ArrayList<Character> getCharacterList()
  {
    return characterList;
  }
  public Character getCharacter(int i)
  {
    return characterList.get(i);
  }
  public Group getGroup(int i)
  {
    return groupList.get(i);
  }
  public String getName()
  {
    return playerName;
  }


  @Override public int rollDice(int diceType, int diceCount)
  {
    DiceRoll roll = new DiceRoll();
    return  roll.RollDice(diceType,diceCount);
  }


}
