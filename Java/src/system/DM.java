package system;

public class DM implements User
{
  private String nameDM;
  private Group groupDM;
  public DM(String name)
  {
    nameDM=name;
  }

  public String getName()
  {
    return nameDM;
  }


  @Override public int rollDice(int diceType, int diceCount)
  {
     DiceRoll roll = new DiceRoll();
    return  roll.RollDice(diceType,diceCount);

  }


}
