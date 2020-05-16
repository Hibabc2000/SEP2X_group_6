package system;

public class EquipmentArmor
{
  private String equipment;
  private String armorClass;
  private String dexMod;
  private String stealth;
  private String strength;

  public EquipmentArmor(String equipment, String armorClass, String dexMod,
      String stealth, String strength)
  {
    this.equipment = equipment;
    this.armorClass = armorClass;
    this.dexMod = dexMod;
    this.stealth = stealth;
    this.strength = strength;
  }

  @Override public String toString()
  {
    return "EquipmentArmor{" + "equipment='" + equipment + '\''
        + ", armorClass='" + armorClass + '\'' + ", dexMod='" + dexMod + '\''
        + ", stealth='" + stealth + '\'' + ", strength='" + strength + '\''
        + '}';
  }

  public String getEquipment()
  {
    return equipment;
  }

  public void setEquipment(String equipment)
  {
    this.equipment = equipment;
  }

  public String getArmorClass()
  {
    return armorClass;
  }

  public void setArmorClass(String armorClass)
  {
    this.armorClass = armorClass;
  }

  public String getDexMod()
  {
    return dexMod;
  }

  public void setDexMod(String dexMod)
  {
    this.dexMod = dexMod;
  }

  public String getStealth()
  {
    return stealth;
  }

  public void setStealth(String stealth)
  {
    this.stealth = stealth;
  }

  public String getStrength()
  {
    return strength;
  }

  public void setStrength(String strength)
  {
    this.strength = strength;
  }
}
