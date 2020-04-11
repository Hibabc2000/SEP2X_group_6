package login.views;

import login.model.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CreateAccountController
{ private ViewHandler vh;
private CreateAccountViewModel cavm;
@FXML private TextField userName;
  @FXML private PasswordField password1;
  @FXML private PasswordField password2;
  @FXML private TextField email;
  @FXML private Label errorMessage;
  @FXML private Button backButton;
  @FXML private Button createButton;
  public void createAccount(ActionEvent actionEvent)
  {
    if (cavm.checkFieldsForReg().equals("Ready")) {vh.openAccount();}

  }

  public void goBack(ActionEvent actionEvent)
  {
    vh.openSystem();
  }

  public void init(CreateAccountViewModel createAccountVM, ViewHandler viewHandler)
  {
    cavm=createAccountVM;
    vh=viewHandler;

    userName.textProperty().bindBidirectional(cavm.getUserNameProperty());
    errorMessage.textProperty().bind(cavm.getErrorProperty());
    email.textProperty().bindBidirectional(cavm.getEmailProperty());
    password1.textProperty().bindBidirectional(cavm.getPassword1Property());
    password2.textProperty().bindBidirectional(cavm.getPassword2Property());
  }

}
