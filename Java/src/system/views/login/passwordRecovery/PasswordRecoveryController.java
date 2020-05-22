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

  /**
   * Initializes the class attributes, binds the fxml fields to view model properties.
   *
   * @param passwordRecoveryViewModel view model
   * @param viewHandler used for changing the views
   */
   public void init(PasswordRecoveryViewModel passwordRecoveryViewModel, ViewHandler viewHandler)
{
  model = passwordRecoveryViewModel;
  vh=viewHandler;
  emailTextField.textProperty().bindBidirectional(model.getEmailProperty());
  errorMessage.textProperty().bind(model.getErrorProperty());
}

  /**
   * Sends a request to the view model in order to check the credentials. If the credentials are
   * verified successfully the openAccount view will be opened
   */
  public void recoverPassword()
  {
    if(model.checkEmail().equals("Ready")){
      vh.closeStage2(); }
  }

}
