package system.transferobjects.login;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Oliver Izsák, 293131
 * @version 1.1.0
 * this class is the Group which stores the DM and players who are part of the group
 */
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
  /**
   * Returns the id of the group.
   * @return  value of id
   */
  public int getId()
  {
    return id;
  }
  /**
   * Returns the DM of the group
   * @return  variable dm
   */
  public DM getDM()
  {
    return dm;
  }
  /**
   * Sets the ArrayList of players.
   * @param plys ArrayList<Player>
   */
  public void addAllPlayers(ArrayList<Player> plys)
  {
    players = plys;
  }
  /**
   * Returns an Arraylist of players.
   * @return  players
   */
  public ArrayList<Player> getAllPlayers()
  {
    return players;
  }
  /**
   * Returns a Player with the same name, as the String variable player, from the group.
   * @param player String
   * @return  Player
   */
  public Player getPlayer(
      String player)
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
  /**
   * Adds a player to the ArrayList<Players>.
   * @param player Player
   */
    public void addPlayer(
      Player player)
  {
    players.add(player);
  }
  /**
   * Adds a DM to the group.
   * @param d DM
   */
  public void addDM(DM d)
  {
    dm = d;
  }

  public String toString()
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
  /**
   * Returns an boolean true if the player is part of the group and false if the player is not part of the group.
   * @param pla Player
   * @return  True, if the player is part of the group
   *          False, if the player is not part of the group.
   */
  public boolean isPlayerPartOfGroup(
      Player pla)  // returns whether the entered player is part of the group
  {
    return players.contains(pla);
  }
  /**
   * Returns an boolean true if the Player username is part of the group and false if the Player Username is not part of the group.
   * @param username String
   * @return  True, if the username is part of the group
   *          False, if the username is not part of the group.
   */
  public boolean isContainsUsername(
      String username)
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
