package system.Map;

public class MapEnemy
{
  private int initiative;
  private String name;

  public MapEnemy(String name)
  {
    this.name = name;
  }
  public void addInitiative(int i)
  {
    initiative = i;
  }

  public int getInitiative()
  {
    return initiative;
  }

  public String getName()
  {
    return name;
  }

  @Override public String toString()
  {
    return "MapEnemy{" + "initiative=" + initiative + ", name='" + name + '\''
        + '}';
  }
}
