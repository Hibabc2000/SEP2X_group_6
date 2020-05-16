package system;

import java.util.ArrayList;

public class Race
{
  private ArrayList<Feat> raceFeats;
  private String name;
  private String description;

  public Race(String name, String description)
  {
    raceFeats = new ArrayList<>();
    this.name = name;
    this.description = description;
  }
  public void addFeat(Feat f)
  {
    raceFeats.add(f);
  }

  public ArrayList<Feat> getRaceFeats()
  {
    return raceFeats;
  }

  public void setRaceFeats(ArrayList<Feat> raceFeats)
  {
    this.raceFeats = raceFeats;
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
    return "Race{" + "raceFeats=" + raceFeats + ", name='" + name + '\''
        + ", description='" + description + "'}'";
  }
}
