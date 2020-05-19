package system.transferobjects;

import java.io.Serializable;

public class Container implements Serializable
{
  private Object object;
  private ClassName className;

  public Container(Object object, ClassName className)
  {
    this.object = object;
    this.className = className;
  }

  public Object getObject()
  {
    return object;
  }

  public void setObject(Object object)
  {
    this.object = object;
  }

  public ClassName getClassName()
  {
    return className;
  }

  public void setClassName(ClassName className)
  {
   this.className=className;
  }

}
