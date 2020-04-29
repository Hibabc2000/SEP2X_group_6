package system.views.login.passwordRecovery;

import system.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PasswordRecoveryController
{
  private ViewHandler vh;
  private PasswordRecoveryViewModel model;
  @FXML private TextField emailTextField;
  @FXML private Button recoverPasswordButton;
  @FXML private Label errorMessage;
  public void recoverPassword(ActionEvent actionEvent)
  {
    if(model.checkEmail().equals("Ready")){
      vh.closeStage2(); }
  }
   public void init(PasswordRecoveryViewModel prvm, ViewHandler viewHandler)
{
  model = prvm;
  vh=viewHandler;
  emailTextField.textProperty().bindBidirectional(model.getEmailProperty());
  errorMessage.textProperty().bind(model.getErrorProperty());
}

}
