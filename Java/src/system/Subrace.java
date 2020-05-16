package system;

public class Subrace
{
  private String mainRace;
  private String raceName;
  private String description;
  private String traits;

  public Subrace(String mainRace, String raceName, String description,
      String traits)
  {
    this.mainRace = mainRace;
    this.raceName = raceName;
    this.description = description;
    this.traits = traits;
  }

  public String getMainRace()
  {
    return mainRace;
  }

  public void setMainRace(String mainRace)
  {
    this.mainRace = mainRace;
  }

  public String getRaceName()
  {
    return raceName;
  }

  public void setRaceName(String raceName)
  {
    this.raceName = raceName;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
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
    return "Subrace{" + "mainRace='" + mainRace + '\'' + ", raceName='"
        + raceName + '\'' + ", description='" + description + '\''
        + ", traits='" + traits + '\'' + '}';
  }
}
