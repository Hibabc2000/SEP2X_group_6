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

  public void createAccount()
  {
    createAccountViewModel.checkFieldsForReg();
  }

  public void goBack()
  {
    vh.openSystem();
  }

  private void createAccountReally(PropertyChangeEvent propertyChangeEvent)
  {

    if (propertyChangeEvent.getNewValue().equals("Ready"))
    {
      System.out.println("opening account");
      vh.openAccount();
    }

  }

}
