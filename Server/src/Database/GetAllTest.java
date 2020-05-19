package Database;

import java.util.ArrayList;

public class GetAllTest
{
  public static void main(String[] args)
  {
    String array = "{1,2,3,44,235,9421,2311}";
    ArrayList<Integer> m = new ArrayList<>();
    String[] ar = array.split("\\{");

    String part1 = ar[0];
    String part2 = ar[1];
    String[] h = part2.split("}");
    System.out.println(h[0]);
    String o = h[0];
    System.out.println(o);
    String[] l = o.split(",");
    ArrayList<Integer> ids= new ArrayList<>();
    for(int i =0;i<l.length;i++)
    {
      ids.add(Integer.parseInt(l[i]));

    }







  }
}
