package system.core;

import system.networking.Client;
import system.networking.SocketClient;

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