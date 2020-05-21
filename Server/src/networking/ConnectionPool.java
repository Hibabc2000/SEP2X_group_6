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
  public void addPlayerToGroup(Group gp, Account ac )
  {
    for (ServerSocketHandler handler : connections)
    {
      if ((gp.isContainsUsername(handler.getAccount().getUsername()) || gp.getDM().getName().equals(handler.getAccount().getUsername())) && !handler.getAccount().equals(ac))
      { Player  p = new Player(ac.getUsername());
        ArrayList<Object> m = new ArrayList<>();
        m.add(p);
        m.add(gp.getId());
        Container dtp = new Container(m, ClassName.GROUP_JOIN_UPDATE);
        handler.sendBackData(dtp);
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
}
