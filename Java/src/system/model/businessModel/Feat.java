package system.model.businessModel;

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

  public String getInfo()
  {
    return "Feat{" + "origin='" + origin + '\'' + ", name='" + name + '\''
        + ", description='" + description + '\'' + '}';
  }
  @Override public String toString()
  {
    return name;
  }
  public boolean equals(Object object)
  {
    if(!(object instanceof Feat)){return false;}
    else if((((Feat) object).getName().equals(name))&&(((Feat) object).getOrigin().equals(origin))){return true;}
    else {return false;}
  }
}
