package system.transferobjects.login;

import system.model.businessModel.DiceRoll;

import java.io.Serializable;

public class DM implements User, Serializable
{
  private String nameDM;
  private Group groupDM;

  public DM(String name)
  {
    nameDM = name;
  }

  public String getName()
  {
    return nameDM;
  }
  public Group getGroupDM()
  {
    return groupDM;
  }
  public void setGroupDM(Group grp)
  {
    groupDM= grp;
  }

  @Override public int rollDice(int diceType, int diceCount)
  {
    DiceRoll roll = new DiceRoll();
    return roll.RollDice(diceType, diceCount);

  }

}
