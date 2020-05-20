package system.model.businessModel;

public class EquipmentArmor
{
  private Equipment equipment;
  private int armorClass;
  private String dexMod;
  private boolean stealth;
  private int strength;

  public Equipment getEquipment()
  {
    return equipment;
  }

  public void setEquipment(Equipment equipment)
  {
    this.equipment = equipment;
  }

  public int getArmorClass()
  {
    return armorClass;
  }

  public void setArmorClass(int armorClass)
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

  public boolean isStealth()
  {
    return stealth;
  }

  public void setStealth(boolean stealth)
  {
    this.stealth = stealth;
  }

  public int getStrength()
  {
    return strength;
  }

  public void setStrength(int strength)
  {
    this.strength = strength;
  }

  public EquipmentArmor(Equipment equipment, int armorClass, String dexMod,
      boolean stealth, int strength)
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
}
