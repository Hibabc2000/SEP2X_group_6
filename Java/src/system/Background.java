package system;

import java.util.ArrayList;

public class Background
{
  private String name;
  private String description;
  private ArrayList<Item> equipmentList;
  private ArrayList<String> traits;
  private ArrayList<String> ideals;
  private ArrayList<String> bonds;
  private ArrayList<String> flaws;

  public Background(String name, String description)
  {
    traits = new ArrayList<>();
    ideals = new ArrayList<>();
    bonds = new ArrayList<>();
    flaws = new ArrayList<>();
    equipmentList = new ArrayList<>();
    this.name = name;
    this.description = description;
  }
  public void addEquipmentList(ArrayList<Item> eqs)
  {
    equipmentList = eqs;
  }
  public void addEquipment(Item equipment)
  {
    equipmentList.add(equipment);
  }
  public void addTrait(String trait)
  {
    traits.add(trait);
  }
  public void addIdeal(String ideal)
  {
    ideals.add(ideal);
  }
  public void addBond(String bond)
  {
    bonds.add(bond);
  }
  public void addFlaw(String flaw)
  {
    flaws.add(flaw);
  }

}
