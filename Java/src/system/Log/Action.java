package system.Log;

public class Action
{
  private String type;
  private Object changedThing;

  public Action(String t, Object ch)
  {
    type = t;
    changedThing = ch;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public Object getChangedThing()
  {
    return changedThing;
  }

  public void setChangedThing(Object changedThing)
  {
    this.changedThing = changedThing;
  }

  @Override public String toString()
  {
    return "Action{" + "type='" + type + '\'' + ", changedThing=" + changedThing
        + '}';
  }
}
