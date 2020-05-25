package system.views.login.createAccount;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

import java.beans.PropertyChangeEvent;

public class CreateAccountController
{
  private ViewHandler vh;
  private CreateAccountViewModel createAccountViewModel;
  @FXML private TextField userName;
  @FXML private PasswordField password1;
  @FXML private PasswordField password2;
  @FXML private TextField email;
  @FXML private Label errorMessage;
  @FXML private Button backButton;
  @FXML private Button createButton;

  /**
   * Initializes the class attributes, binds the fxml fields to view model properties.
   * Note that this method is also listening for changes from the view model, and in case
   * the create account process is completed successfully the createAccountReally method will
   * be called
   * @param createAccountVM view model for this controller
   * @param viewHandler used for changing the views
   */
  public void init(CreateAccountViewModel createAccountVM,
      ViewHandler viewHandler)
  {
    createAccountViewModel = createAccountVM;
    vh = viewHandler;

    userName.textProperty().bindBidirectional(createAccountViewModel.getUserNameProperty());
    errorMessage.textProperty().bind(createAccountViewModel.getErrorProperty());
    email.textProperty().bindBidirectional(createAccountViewModel.getEmailProperty());
    password1.textProperty().bindBidirectional(createAccountViewModel.getPassword1Property());
    password2.textProperty().bindBidirectional(createAccountViewModel.getPassword2Property());
    createAccountViewModel.addListener("createAccount", this::createAccountReally);

  }

  /**
   * Calls the field checker in the view model
   */
  public void createAccount()
  {
    createAccountViewModel.checkFieldsForReg();
  }

  /**
   * Open the OpenSystem view(main view)
   */
  public void goBack()
  {
    vh.openSystem();
  }

  /**
   * If the {@param propertyChangeEvent} contains the String "Ready" the
   * creating account process was successful and the openAccount view will be opened
   * @param propertyChangeEvent String containing a message
   */
  private void createAccountReally(PropertyChangeEvent propertyChangeEvent)
  {
    if (propertyChangeEvent.getNewValue().equals("Ready"))
    {
      System.out.println("opening account");
      vh.openAccount();
    }
// !!!! WE SHOULD DISPLAY THE ERROR IF SMTH GOES WRONG
  }

}
