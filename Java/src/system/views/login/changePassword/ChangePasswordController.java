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
   * Initializes the class attributes, binds the fxml fields to view model properties.

   * @param changePasswordViewModel view model for this controller
   * @param viewHandler used for changing the views
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

  /**
   * Calls the field checker in the view model
   */
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
