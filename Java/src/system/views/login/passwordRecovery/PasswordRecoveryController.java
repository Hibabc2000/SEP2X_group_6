package system.views.login.passwordRecovery;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

public class PasswordRecoveryController
{
  private ViewHandler vh;
  private PasswordRecoveryViewModel model;
  @FXML private TextField emailTextField;
  @FXML private Button recoverPasswordButton;
  @FXML private Label errorMessage;
  public void recoverPassword()
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
