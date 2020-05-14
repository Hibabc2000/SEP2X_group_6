package system;

import java.util.ArrayList;

public class Skill
{
  private ArrayList<Proficiency> proficiencies;
  private Ability ability;
  private String name;
  private String description;

  public Skill( Ability ability,
      String name, String description)
  {
    proficiencies = new ArrayList<>();
    this.ability = ability;
    this.name = name;
    this.description = description;
  }

  public ArrayList<Proficiency> getProficiencies()
  {
    return proficiencies;
  }
  public void addProficiency(Proficiency prof)
  {
    proficiencies.add(prof);
  }

  public void setProficiencies(ArrayList<Proficiency> proficiencies)
  {
    this.proficiencies = proficiencies;
  }

  public Ability getAbility()
  {
    return ability;
  }

  public void setAbility(Ability ability)
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
    return "Skill{" + "proficiencies=" + proficiencies + ", ability=" + ability
        + ", name='" + name + '\'' + ", description='" + description + '\''
        + '}';
  }
}
