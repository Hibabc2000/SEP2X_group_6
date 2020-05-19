package system.views.login.login;

import system.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController
{
  private ViewHandler vh;
  private LoginViewModel loginModel;
  @FXML private TextField userName;
  @FXML private PasswordField password;
  @FXML private Label errorMessage;
  @FXML private Button forgotPasswordButton;
  @FXML private Button loginButton;
  @FXML private Button backButton;

  public void login(ActionEvent actionEvent)
  {
    if(loginModel.checkLogin().equals("Ready")){
    vh.openAccount();}
  }

  public void goBack(ActionEvent actionEvent)
  { vh.openSystem();
  }

  public void init(LoginViewModel lvm, ViewHandler viewHandler)
  {
    loginModel = lvm;
    vh = viewHandler;
    userName.textProperty().bindBidirectional(loginModel.getUserNameProperty());
    password.textProperty().bindBidirectional(loginModel.getPasswordProperty());
    errorMessage.textProperty().bind(loginModel.getErrorProperty());

  }

  public void recoverPassword(ActionEvent actionEvent)
  {
    vh.openPasswordRecovery();
  }
}
