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
  private CreateAccountViewModel cavm;
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
    cavm = createAccountVM;
    vh = viewHandler;

    userName.textProperty().bindBidirectional(cavm.getUserNameProperty());
    errorMessage.textProperty().bind(cavm.getErrorProperty());
    email.textProperty().bindBidirectional(cavm.getEmailProperty());
    password1.textProperty().bindBidirectional(cavm.getPassword1Property());
    password2.textProperty().bindBidirectional(cavm.getPassword2Property());
       cavm.addListener("createAccount",this::createAccountReally);


  }
  public void createAccount()
  {  cavm.checkFieldsForReg();



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
