package system;

public class Item
{
  private String name;
  private String description;
  private double price;

  public Item(String name, double price)
  {
    this.name = name;
    this.price = price;
  }

  public void addDescription(String desc)
  {
    description = desc;
  }
  public void addPrice(double pr)
  {
    price = pr;
  }
  public String getDescription()
  {
    return description;
  }
  public String getName()
  {
    return name;
  }
  public double price()
  {
    return price;
  }



}
