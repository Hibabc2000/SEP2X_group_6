package system;

import system.core.ModelFactory;
import system.core.ViewHandler;
import system.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Run extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory mf = new ModelFactory();
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(vmf);
    vh.start();

  }
}
