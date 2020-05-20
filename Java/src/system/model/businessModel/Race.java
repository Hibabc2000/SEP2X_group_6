package system.model.businessModel;

public class Race
{

  private String traits;
  private String name;
  private String description;

  public Race(String name, String description, String traits)
  {
    this.traits = traits;
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

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTraits()
  {
    return traits;
  }

  public void setTraits(String traits)
  {
    this.traits = traits;
  }

  @Override public String toString()
  {
    return "Race{" + "traits=" + traits + ", name='" + name + '\''
        + ", description='" + description + "'}'";
  }
}
