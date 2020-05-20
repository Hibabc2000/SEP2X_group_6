package system.views.login.openSystem;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

import java.beans.PropertyChangeEvent;

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
    openSystemViewModel.addListener("acceptTheLogIn", this::loginAccount);

  }

  private void loginAccount(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("Asda");
    System.out.println(propertyChangeEvent.getNewValue());
    if (propertyChangeEvent.getNewValue().equals("Ready"))
    {
      System.out.println("opening account");
      viewHandler.openAccount();
    }
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
