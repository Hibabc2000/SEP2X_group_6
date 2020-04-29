package system.views.login.changeEmail;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

public class ChangeEmailController
{
  private ViewHandler vh;
  private ChangeEmailViewModel cevmodel;
  @FXML private Label errorMessage;
  @FXML private TextField usernameField;
  @FXML private PasswordField passwordField;
 @FXML private TextField emailField;
  public void init(ChangeEmailViewModel vm, ViewHandler viewHandler)
  {

    cevmodel= vm;
    vh = viewHandler;
    errorMessage.textProperty().bind(cevmodel.getErrorProperty());
    usernameField.textProperty().bindBidirectional(cevmodel.getUserNameProperty());
    passwordField.textProperty().bindBidirectional(cevmodel.getPasswordProperty());
    emailField.textProperty().bindBidirectional(cevmodel.getEmailProperty());

  }
  // checks the string if it equals ready then closes the stage
  public void proceedWithEmailChange(ActionEvent actionEvent)
  {if (cevmodel.checkEmailChangeInformation().equals("Ready")) { vh.closeStage4();}

  }

  public void cancelEmailChange(ActionEvent actionEvent)
  {
    vh.closeStage4();
  }
}
