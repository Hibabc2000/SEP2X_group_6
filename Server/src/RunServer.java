package system.Server;

import javafx.application.Application;
import system.Run;

public class RunServer
{
  public static void main(String[] args)
  {
    Server es=new Server();
    es.start();
  }
}
