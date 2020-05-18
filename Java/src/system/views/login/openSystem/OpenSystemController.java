package system.views.login.openSystem;

import system.core.ViewHandler;
import javafx.event.ActionEvent;

public class OpenSystemController
{ private ViewHandler vh;
private  OpenSystemViewModel osvm;
  public void createAccount(ActionEvent actionEvent)
  {
    vh.openCreateAccount();

  }

  public void login(ActionEvent actionEvent)
  {
    vh.openLogin();
  }

  public void quit(ActionEvent actionEvent)
  {
    System.exit(1);
  }

  public void init(OpenSystemViewModel osvm, ViewHandler viewHandler)
  {
    this.osvm=osvm;
    vh = viewHandler;
  }

  public void recoverPassword(ActionEvent actionEvent)
  {
    vh.openPasswordRecovery();
  }
}
