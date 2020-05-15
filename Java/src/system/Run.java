package system;

import system.Client.Client;
import system.core.ClientFactory;
import system.core.ModelFactory;
import system.core.ViewHandler;
import system.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ClientFactory cf = new ClientFactory();
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();

  }
}
