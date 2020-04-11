package login;

import java.util.ArrayList;

public class Group
{
  private String groupName;
  private ArrayList<Player> players;
  private DM dm;
  private User user;
  private int id;
  public Group(String groupName, int i)
  { this.groupName = groupName;
  players= new ArrayList<>();
id = i;
  }
  public int getId()
  {
    return id;
  }
  public DM getDM()
  {
    return dm;
  }
  public void addPlayer(Player player)
  {
     players.add(player);
  }
  public void addDM(DM d)
  {
    dm = d;
  }
  public String toString()
  {String m ="";
  if(players.size()==0) {
    ;m= "Group name :\t\t"+groupName+"\n" + "Group ID: \t\t"+ id   +"\n DM: \t \t \t"+ dm.getName() + "\n Players: " ;}
  else
  m= "Group name :\t\t"+groupName+"\n" + "Group ID: \t\t"+ id   +"\n DM: \t \t \t"+ dm.getName() + "\n Players: " ;
    for (int i = 0; i < players.size(); i++)
    {
      m += "\n \t \t \t\t "+players.get(i).getName();
    }
    return m;
  }

  public boolean isPlayerPartOfGroup(Player pla)
  {
    return players.contains(pla);
  }

  public boolean isContainsUsername(String username)
  { boolean temp=false;
    for(int i =0;i<players.size();i++)
    {
      if(players.get(i).getName().equals(username))
      {temp=true; break;}
    }
    return temp;
  }
}
