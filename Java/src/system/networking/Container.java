package system.networking;

public class Container
{
  private Object object;
  private String className;

  public Object getObject()
  {
    return object;
  }

  public void setObject(Object object)
  {
    this.object = object;
  }

  public String getClassName()
  {
    return className;
  }

  public void setClassName(String className)
  {
    this.className = className;
  }

  public Container(Object object, String className)
  {
    this.object = object;
    this.className = className;
  }
}