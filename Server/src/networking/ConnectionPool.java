package networking;

import system.transferobjects.login.Account;

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

  }
}
