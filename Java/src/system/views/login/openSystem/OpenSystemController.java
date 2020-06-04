package system.views.login.openSystem;

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

  // test

  public Label testPopup;

  // end test

  private ViewHandler viewHandler;
  private OpenSystemViewModel openSystemViewModel;

  /**
   * Initializes the class attributes, binds the fxml fields to view model properties.
   * Note that this method is also listening for changes from the view model, and in case
   * the login data is accepted the loginAccount method will be called
   * @param openSystemViewModel
   * @param viewHandler used for changing the views
   */
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



  /**
   * Returns to the view the login request result. If the {@param propertyChangeEvent} has the
   * value "Ready" the openAccount view will be opened
   * @param propertyChangeEvent contains a String
   */


  private void loginAccount(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("Asda");
    System.out.println(propertyChangeEvent.getNewValue());
    if (propertyChangeEvent.getNewValue().equals("Ready"))
    {
      System.out.println("opening account");
      viewHandler.openAccount();
    }
    // !!!! WE SHOULD DISPLAY THE ERROR IF SMTH GOES WRONG
  }

  /**
   * Opens the CreateAccount view
   */
  public void createAccount()
  {
    viewHandler.openCreateAccount();
  }

  /**
   * Sends a request to the view model in order to check the credentials. If the credentials are
   * verified successfully the openAccount view will be opened
   */
  public void login()
  {
    if (openSystemViewModel.checkLogin().equals("Ready"))
    {
      viewHandler.openAccount();
    }
  }

  /**
   * Opens the PasswordRecovery view
   */
  public void recoverPassword()
  {
    viewHandler.openPasswordRecovery();
  }
}
