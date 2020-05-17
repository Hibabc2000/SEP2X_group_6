package system;

public class EquipmentWeapon
{
  private Equipment equipment;
  private String damage;
  private String properties;
  private String weaponType;

  public EquipmentWeapon(Equipment equipment, String damage, String properties,
      String weaponType)
  {
    this.equipment = equipment;
    this.damage = damage;
    this.properties = properties;
    this.weaponType = weaponType;
  }

  @Override public String toString()
  {
    return "EquipmentWeapon{" + "equipment='" + equipment + '\'' + ", damage='"
        + damage + '\'' + ", properties='" + properties + '\''
        + ", weaponType='" + weaponType + '\'' + '}';
  }

  public Equipment getEquipment()
  {
    return equipment;
  }

  public void setEquipment(Equipment equipment)
  {
    this.equipment = equipment;
  }

  public String getDamage()
  {
    return damage;
  }

  public void setDamage(String damage)
  {
    this.damage = damage;
  }

  public String getProperties()
  {
    return properties;
  }

  public void setProperties(String properties)
  {
    this.properties = properties;
  }

  public String getWeaponType()
  {
    return weaponType;
  }

  public void setWeaponType(String weaponType)
  {
    this.weaponType = weaponType;
  }
}
