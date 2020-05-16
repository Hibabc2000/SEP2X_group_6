package system;

public class EquipmentGeneral
{
  private String equipment;

  public EquipmentGeneral(String equipment)
  {
    this.equipment = equipment;
  }

  public String getEquipment()
  {
    return equipment;
  }

  public void setEquipment(String equipment)
  {
    this.equipment = equipment;
  }

  @Override public String toString()
  {
    return "EquipmentGeneral{" + "equipment='" + equipment + '\'' + '}';
  }
}
