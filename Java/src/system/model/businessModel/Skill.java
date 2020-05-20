package system.model.businessModel;

public class Skill
{
  private String ability;
  private String name;
  private String description;

  public Skill(String ability, String name, String description)
  {
    this.ability = ability;
    this.name = name;
    this.description = description;
  }

  public String getAbility()
  {
    return ability;
  }

  public void setAbility(String ability)
  {
    this.ability = ability;
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
    return "Skill{" + "ability=" + ability
        + ", name='" + name + '\'' + ", description='" + description + '\''
        + '}';
  }
}
