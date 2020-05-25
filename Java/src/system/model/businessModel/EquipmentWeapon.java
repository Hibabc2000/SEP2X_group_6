package system.model.businessModel;

public class EquipmentWeapon extends Equipment
{
  private String damage;
  private String properties;
  private String weaponType;

  public EquipmentWeapon(String name, String desc, double weight, double price, String damage, String properties,
      String weaponType)
  {
    super(name, desc, weight, price);
    this.damage = damage;
    this.properties = properties;
    this.weaponType = weaponType;
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
