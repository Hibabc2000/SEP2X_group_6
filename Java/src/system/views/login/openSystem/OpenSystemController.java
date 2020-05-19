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

  private ViewHandler viewHandler;
  private OpenSystemViewModel openSystemViewModel;

  public void init(OpenSystemViewModel openSystemViewModel,
      ViewHandler viewHandler)
  {
    this.openSystemViewModel = openSystemViewModel;
    userNameField.textProperty()
        .bindBidirectional(openSystemViewModel.getUserNameProperty());
    passwordField.textProperty()
        .bindBidirectional(openSystemViewModel.getPasswordProperty());
    errorMessageLabel.textProperty()
        .bind(openSystemViewModel.getErrorProperty());
    this.viewHandler = viewHandler;
  }

  public void createAccount()
  {
    viewHandler.openCreateAccount();
  }

  public void login()
  {
    if (openSystemViewModel.checkLogin().equals("Ready"))
    {
      viewHandler.openAccount();
    }
  }

  public void recoverPassword(ActionEvent actionEvent)
  {
    viewHandler.openPasswordRecovery();
  }
}
