package system.views.login.changePassword;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

public class ChangePasswordController
{
  private ViewHandler vh;
  private ChangePasswordViewModel cpvmodel;
  @FXML private Label error;
  @FXML private TextField username;
  @FXML private PasswordField passwordOld;
  @FXML private PasswordField passwordNew;
  @FXML private PasswordField passwordNewAgain;

  /**
   *
   * @param changePasswordViewModel
   * @param viewHandler
   */
  public void init(ChangePasswordViewModel changePasswordViewModel, ViewHandler viewHandler)
  {

    cpvmodel = changePasswordViewModel;
    vh = viewHandler;
    error.textProperty().bind(cpvmodel.getErrorProperty());
    username.textProperty().bindBidirectional(cpvmodel.getUserNameProperty());
    passwordNew.textProperty()
        .bindBidirectional(cpvmodel.getPasswordNewProperty());
    passwordNewAgain.textProperty()
        .bindBidirectional(cpvmodel.getPasswordNewAgainProperty());
    passwordOld.textProperty()
        .bindBidirectional(cpvmodel.getPasswordOldProperty());
  }

  public void saveChanges()
  {
    if (cpvmodel.checkPasswordChangeInformation().equals("Ready"))
    {
      vh.closeStage3();
    }

  }

  public void cancelGoBack()
  {
    vh.closeStage3();
  }

}
