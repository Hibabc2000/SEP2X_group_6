package system.model.businessModel;

public class Item
{
 private Equipment gameItem;
 private int amount;
 private boolean equipped;
 public Item(Equipment gameItem, int amount)
 {
   this.gameItem = gameItem;
   this.amount = amount;
 }
  public void setGameItem(Equipment gameItem)
  {
    this.gameItem = gameItem;
  }

  public void setEquipped(boolean equipped)
  {
    this.equipped = equipped;
  }

  public void setAmount(int amount)
  {
    this.amount = amount;
  }

  public Equipment getGameItem()
  {
    return gameItem;
  }

  public boolean isEquipped()
  {
    return equipped;
  }

  public int getAmount()
  {
    return amount;
  }

  public boolean equals(Object object)
  {
    if(!(object instanceof Item)){return false;}
    else if((((Item) object).getAmount() == amount)&&(((Item) object).getGameItem().equals(gameItem))&&(((Item) object).isEquipped() == equipped)){return true;}
    else {return false;}
  }
}
