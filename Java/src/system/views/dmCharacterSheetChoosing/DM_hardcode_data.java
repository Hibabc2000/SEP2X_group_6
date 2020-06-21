package system.views.dmCharacterSheetChoosing;

public class DM_hardcode_data
{
  private int xp;
  private String username;
  private String name;
  private int level;

  public DM_hardcode_data(int xp, String username, String name, int level)
  {
    this.xp = xp;
    this.username = username;
    this.name = name;
    this.level = level;
  }

  public int getXp()
  {
    return xp;
  }

  public void setXp(int xp)
  {
    this.xp = xp;
  }

  public String getUsername()
  {
    return username;
  }
  public String getName()
  {
    return name;
  }

  public int getLevel()
  {
    return level;
  }

  public void setLevel(int level)
  {
    this.level = level;
  }
}
