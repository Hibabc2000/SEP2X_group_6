package system.model.businessModel;

import java.io.Serializable;

public class Equipment implements
    Serializable //DO NOT INSTANTIATE UNLESS NECESSARY.
{
  /**
   * Class for equipment. DO NOT INSTANTIATE.
   * Use EquipmentWeapon, EquipmentArmor and EquipmentGeneral instead.
   */
  private String name;
  private String description;
  private double weight;
  private double price;

  public Equipment(String name, String description, double weight, double price)
  {
    this.name = name;
    this.description = description;
    this.weight = weight;
    this.price = price;
  }

  public Equipment(Equipment equipment)
  {
    this.name = equipment.getName();
    this.description = equipment.getDescription();
    this.weight = equipment.getWeight();
    this.price = equipment.getPrice();
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

  public double getWeight()
  {
    return weight;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  @Override public String toString()
  {
    return "Equipment{" + "name='" + name + '\'' + ", description='"
        + description + '\'' + ", weight=" + weight + ", price=" + price + '}';
  }
  public boolean equals(Object object)
  {
    if(! (object instanceof Equipment)){return false;}
    else if(((Equipment) object).getName().equals(name)){return true;}
    else{return true;}
  }
}
