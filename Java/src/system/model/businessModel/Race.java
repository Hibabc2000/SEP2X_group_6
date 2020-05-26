package system.model.businessModel;

public class Race
{

  private String traits;
  private String name;
  private String description;
  //private int[] abilityIncrease;
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



  public String getInfo()
  {
    return "Race{" + "traits=" + traits + ", name='" + name + '\''
        + ", description='" + description + "'}'";
  }

  @Override public String toString()
  {
    return name;
  }
  public boolean equals(Object object)
  {
    if(!(object instanceof Race)){return false;}
    else if(((Race) object).getName().equals(name)){return true;}
    else{return false;}
  }
  /*

  public int[] getAbilityIncrease()
  {
    return abilityIncrease;
  }

  public void setAbilityIncrease(int[] abilityIncrease)
  {
    this.abilityIncrease = abilityIncrease;
  }

   */
}
