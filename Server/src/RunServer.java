

import javafx.application.Application;
import networking.Server;


public class RunServer
{
  public static void main(String[] args)
  {
    Server es=new Server();
    es.start();
  }
}
