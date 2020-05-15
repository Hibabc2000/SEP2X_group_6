package system.core;

import system.Client.Client;
import system.Client.SocketClient;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if(client==null){
      client=new SocketClient();
    }
    return client;
  }
}