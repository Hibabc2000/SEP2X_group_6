package login;

public class DM implements User
{
  private String nameDM;
  private Group groupDM;
  public DM(String name)
  {
    nameDM=name;

  }
  public void createGroup(String name)
  {
    groupDM= new Group(name, 1111);


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
