package system.model.businessModel;

import java.io.Serializable;

public class EquipmentArmor extends Equipment implements Serializable
{
  private int armorClass;
  private String dexMod;
  private boolean stealth;
  private int strength;

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
    super(equipment);
    this.armorClass = armorClass;
    this.dexMod = dexMod;
    this.stealth = stealth;
    this.strength = strength;
  }

  @Override public String toString()
  {
    return "EquipmentArmor{" + "equipment='" + super.toString() + '\''
        + ", armorClass='" + armorClass + '\'' + ", dexMod='" + dexMod + '\''
        + ", stealth='" + stealth + '\'' + ", strength='" + strength + '\''
        + '}';
  }
}
