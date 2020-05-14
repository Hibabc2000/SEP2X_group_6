package system;

public class Feat
{
  private String origin;
  private String name;
  private String description;
  public Feat(String or, String na, String des)
  {
    origin = or;
    name =na;
    description= des;
  }
  public String getOrigin()
  {
    return origin;
  }

  public void setOrigin(String origin)
  {
    this.origin = origin;
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
    return "Feat{" + "origin='" + origin + '\'' + ", name='" + name + '\''
        + ", description='" + description + '\'' + '}';
  }
}
