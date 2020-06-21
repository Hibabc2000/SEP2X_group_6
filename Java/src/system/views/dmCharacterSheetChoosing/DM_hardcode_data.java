package system.views.dmCharacterSheetChoosing;

public class DM_hardcode_data
{
  private int XP;
  private String playerName;
  private String charName;
  private int level;

  public DM_hardcode_data(int XP, String playerName, String charName, int level)
  {
    this.XP = XP;
    this.playerName = playerName;
    this.charName = charName;
    this.level = level;
  }

  public int getXP()
  {
    return XP;
  }

  public void setXP(int XP)
  {
    this.XP = XP;
  }

  public String getPlayerName()
  {
    return playerName;
  }

  public void setPlayerName(String playerName)
  {
    this.playerName = playerName;
  }

  public String getCharName()
  {
    return charName;
  }

  public void setCharName(String charName)
  {
    this.charName = charName;
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
