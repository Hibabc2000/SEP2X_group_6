package system.views.login.openSystem;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

public class OpenSystemController
{
  public Button createAccountButton;
  public Button loginButton;
  public TextField userNameField;
  public PasswordField passwordField;
  public Button forgotPasswordButton;
  public Label errorMessageLabel;

  private ViewHandler vh;
  private OpenSystemViewModel openSystemViewModel;

  public void createAccount(ActionEvent actionEvent)
  {
    vh.openCreateAccount();

  }

  public void login()
  {

    vh.openLogin();
  }

  public void init(OpenSystemViewModel osvm, ViewHandler viewHandler)
  {
    this.openSystemViewModel = osvm;
    vh = viewHandler;
  }

  public void recoverPassword(ActionEvent actionEvent)
  {
    vh.openPasswordRecovery();
  }
}
