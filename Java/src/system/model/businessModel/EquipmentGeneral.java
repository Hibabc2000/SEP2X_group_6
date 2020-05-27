package system.model.businessModel;

import java.io.Serializable;

public class EquipmentGeneral extends Equipment implements Serializable
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
