package system.transferobjects.login;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable
{
  private String groupName;
  private ArrayList<Player> players;
  private DM dm;

  private int id;

  public Group(String groupName, int i)
  {
    this.groupName = groupName;
    players = new ArrayList<>();
    id = i;
  }

  public int getId()
  {
    return id;
  } // returns ID of group

  public DM getDM()
  {
    return dm;
  } // returns the DM  of the group

  public Player getPlayer(
      String player) // returns the Player from the group by searching for him by name
  {
    Player temp = null;
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).getName().equals(player))
      {
        temp = players.get(i);
      }
    }
    return temp;
  }

  public void addPlayer(
      Player player)               // adds a player to the group
  {
    players.add(player);
  }

  public void addDM(DM d)                      //adds a DM to the group
  {
    dm = d;
  }

  public String toString()               // toString method for the GroupList in the UI, its all String, subject to change -
  {
    String m = "";
    if(dm == null) {
      System.out.println("No DM, this should not happen");

    } else
    if (players.size() == 0)
    {
      ;
      m = "Group name :\t\t" + groupName + "\n" + "Group ID: \t\t" + id
          + "\n DM: \t \t \t" + dm.getName() + "\n Players: ";
    }
    else
      m = "Group name :\t\t" + groupName + "\n" + "Group ID: \t\t" + id
          + "\n DM: \t \t \t" + dm.getName() + "\n Players: ";
    for (int i = 0; i < players.size(); i++)
    {
      m += "\n \t \t \t\t " + players.get(i).getName();
    }
    return m;
  }

  public boolean isPlayerPartOfGroup(
      Player pla)  // returns whether the entered player is part of the group
  {
    return players.contains(pla);
  }

  public boolean isContainsUsername(
      String username)           // returns whether the player with the entered player's name is part of the group
  {
    boolean temp = false;
    if(players!=null){
    for (int i = 0; i < players.size(); i++)
    {
      if (players.get(i).getName().equals(username))
      {
        temp = true;
        break;
      }
    }
    }
    return temp;
  }
}
