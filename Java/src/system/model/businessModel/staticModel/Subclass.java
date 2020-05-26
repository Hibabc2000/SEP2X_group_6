package system.model.businessModel.staticModel;

public class Subclass
{
  private String mainClass;
  private String description;
  private String name;

  public Subclass(String name, String mainClass, String description)
  {
    this.mainClass = mainClass;
    this.description = description;
    this.name = name;
  }

  public String getMainClass()
  {
    return mainClass;
  }

  public void setMainClass(String mainClass)
  {
    this.mainClass = mainClass;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getInfo()
  {
    return "Subclass{" + "mainClass='" + mainClass + '\'' + ", description='"
        + description + '\'' + ", name='" + name + '\'' + '}';
  }
  public String toString()
  {
    return name;
  }
}
