package system.model.businessModel.staticModel;

import java.io.Serializable;

public class Ability implements Serializable
{
  /**
   * Class for storing DnD abilities.
   */
  private String name;
  private String description;

  public Ability(String name, String description)
  {
    this.name = name;
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

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Override public String toString()
  {
    return "Ability{" + "name='" + name + '\'' + ", description='" + description + "'}'";
  }
}
