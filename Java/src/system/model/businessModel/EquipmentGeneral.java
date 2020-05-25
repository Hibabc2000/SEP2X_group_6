package system.model.businessModel;

public class EquipmentGeneral extends Equipment
{

  public EquipmentGeneral(Equipment equipment)
  {
    super(equipment.getName(), equipment.getDescription(), equipment.getWeight(), equipment.getPrice());
  }

  @Override public String toString()
  {
    return super.toString();
  }
}
