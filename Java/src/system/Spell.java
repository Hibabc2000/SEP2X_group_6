package system;

public class Spell
{
  private String name;
  private String spellLevel;
  private String school;
  private String castTime;
  private String range;
  private String components;
  private String duration;
  private String description;
  private String clas;

  public Spell(String name, String spellLevel, String school, String castTime,
      String range, String components, String duration, String description,
      String clas)
  {
    this.name = name;
    this.spellLevel = spellLevel;
    this.school = school;
    this.castTime = castTime;
    this.range = range;
    this.components = components;
    this.duration = duration;
    this.description = description;
    this.clas = clas;
  }

  @Override public String toString()
  {
    return "Spell{" + "name='" + name + '\'' + ", spellLevel='" + spellLevel
        + '\'' + ", school='" + school + '\'' + ", castTime='" + castTime + '\''
        + ", range='" + range + '\'' + ", components='" + components + '\''
        + ", duration='" + duration + '\'' + ", description='" + description
        + '\'' + ", clas='" + clas + '\'' + '}';
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getSpellLevel()
  {
    return spellLevel;
  }

  public void setSpellLevel(String spellLevel)
  {
    this.spellLevel = spellLevel;
  }

  public String getSchool()
  {
    return school;
  }

  public void setSchool(String school)
  {
    this.school = school;
  }

  public String getCastTime()
  {
    return castTime;
  }

  public void setCastTime(String castTime)
  {
    this.castTime = castTime;
  }

  public String getRange()
  {
    return range;
  }

  public void setRange(String range)
  {
    this.range = range;
  }

  public String getComponents()
  {
    return components;
  }

  public void setComponents(String components)
  {
    this.components = components;
  }

  public String getDuration()
  {
    return duration;
  }

  public void setDuration(String duration)
  {
    this.duration = duration;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public String getClas()
  {
    return clas;
  }

  public void setClas(String clas)
  {
    this.clas = clas;
  }
}
