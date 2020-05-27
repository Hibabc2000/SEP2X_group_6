package system.model.businessModel;

import java.io.Serializable;

public class Proficiency implements Serializable
{
  /**
   * Class for storing proficiencies. Used in Character and CharacterSheetViewModel to calculate proper values.
   */
  private String name;
  private String type;
  private String origin;
  private double mod;

  public Proficiency(String name, String type, String origin, double mod)
  {
    this.name = name;
    this.type = type;
    this.origin = origin;
    this.mod = mod;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getOrigin()
  {
    return origin;
  }

  public void setOrigin(String origin)
  {
    this.origin = origin;
  }

  public double getMod()
  {
    return mod;
  }

  public void setMod(double mod)
  {
    this.mod = mod;
  }

  @Override public String toString()
  {
    return "Proficiency{" + "name='" + name + '\'' + ", type='" + type + '\''
        + ", origin='" + origin + '\'' + ", mod=" + mod + '}';
  }
  public boolean equals(Object object)
  {
    if(!(object instanceof Proficiency)){return false;}
    else if((((Proficiency) object).getName().equals(name))&&(((Proficiency) object).getMod() == mod)&&(((Proficiency) object).getOrigin().equals(origin)&&(((Proficiency) object).getType().equals(type)))){return true;}
    else{return false;}
  }
}
