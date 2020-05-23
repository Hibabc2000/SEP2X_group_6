package system.core;

import system.networking.Client;
import system.networking.SocketClient;

public class ClientFactory
{
  private Client client;

  /**
   * Created a new instance of the SocketClient or the returns the existing one
   * @return instance of the SocketClient
   */
  public Client getClient()
  {
    if(client==null){
      client=new SocketClient();
    }
    return client;
  }
}