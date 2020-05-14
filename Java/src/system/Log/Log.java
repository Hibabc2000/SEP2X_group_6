package system.Log;

import java.util.ArrayList;

public class Log
{
  private int characterID;
  private ArrayList<Action> actionsDone;

  public Log(int characterID)
  {
    this.characterID = characterID;
    this.actionsDone = new ArrayList<>();
  }

  public int getCharacterID()
  {
    return characterID;
  }

  public void setCharacterID(int characterID)
  {
    this.characterID = characterID;
  }

  public ArrayList<Action> getActionsDone()
  {
    return actionsDone;
  }

  public void setActionsDone(ArrayList<Action> actionsDone)
  {
    this.actionsDone = actionsDone;
  }
  public void addAction(Action ac)
  {
    actionsDone.add(ac);
  }
}
