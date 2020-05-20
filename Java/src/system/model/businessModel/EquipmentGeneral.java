package system.model.businessModel;

public class EquipmentGeneral
{
  private Equipment equipment;

  public EquipmentGeneral(Equipment equipment)
  {
    this.equipment = equipment;
  }

  public Equipment getEquipment()
  {
    return equipment;
  }

  public void setEquipment(Equipment equipment)
  {
    this.equipment = equipment;
  }

  @Override public String toString()
  {
    return "EquipmentGeneral{" + "equipment='" + equipment + '\'' + '}';
  }
}
