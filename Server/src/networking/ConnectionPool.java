package networking;

import system.transferobjects.ClassName;
import system.transferobjects.Container;
import system.transferobjects.login.Account;
import system.transferobjects.login.Group;
import system.transferobjects.login.Player;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> connections = new ArrayList<>();
  private List<Account> accounts = new ArrayList<>();

  public synchronized void addHandler(ServerSocketHandler handler)
  {
    connections.add(handler);
  }
  public void removeHandler(ServerSocketHandler handler)
  {
    connections.remove(handler);
    userLeft(handler.getAccount());

  }
  public void addPlayerToGroup(Group gp )
  {
    for (ServerSocketHandler handler : connections)
    {
      if ((gp.isContainsUsername(handler.getAccount().getUsername()) || gp.getDM().getName().equals(handler.getAccount().getUsername())))
      {
        System.out.println("Ez a player kapott group updatet: "+ handler.getAccount().getUsername());
        Container dtp = new Container(gp, ClassName.GROUP_JOIN_UPDATE);
        handler.sendBackData(dtp);
      }
    }
  }
  public void  sendDataToUser(String username,Container data)
  {
    for(ServerSocketHandler handler : connections)
    {
      if(username.equals(handler.getAccount().getUsername()))
      {
        handler.sendBackData(data);
      }
    }

  }

  public void userJoin(Account acc)
  {

    accounts.add(acc);
  }
  public void userLeft(Account acc)
  {
    accounts.remove(acc);
  }

  public ArrayList<Player> selectTheOnesThatAreOnlineInThePool(Group grouToStartGameWith)
  {
    ArrayList<Player> playersWhoAreOnline = new ArrayList<>();
    for (ServerSocketHandler handler : connections)
    {
      if ((grouToStartGameWith.isContainsUsername(handler.getAccount().getUsername()) ))
      {
        System.out.println("Ez a player kap majd értesítést : "+ handler.getAccount().getUsername());
        playersWhoAreOnline.add(grouToStartGameWith.getPlayer(handler.getAccount().getUsername()));

      }
    }
    return playersWhoAreOnline;
  }
}
