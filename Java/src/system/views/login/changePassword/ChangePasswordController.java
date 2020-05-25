package system.views.login.changePassword;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

public class ChangePasswordController
{
  private ViewHandler vh;
  private ChangePasswordViewModel changePasswordViewModel;
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

    this.changePasswordViewModel = changePasswordViewModel;
    vh = viewHandler;
    error.textProperty().bind(this.changePasswordViewModel.getErrorProperty());
    username.textProperty().bindBidirectional(this.changePasswordViewModel.getUserNameProperty());
    passwordNew.textProperty()
        .bindBidirectional(this.changePasswordViewModel.getPasswordNewProperty());
    passwordNewAgain.textProperty()
        .bindBidirectional(this.changePasswordViewModel.getPasswordNewAgainProperty());
    passwordOld.textProperty()
        .bindBidirectional(this.changePasswordViewModel.getPasswordOldProperty());
  }

  /**
   * Calls the field checker in the view model
   */
  public void saveChanges()
  {

    if (changePasswordViewModel.checkPasswordChangeInformation().equals("Ready"))
    {
      vh.closeStage3();
    }

  }

  /**
   * Open the OpenSystem view(main view)
   */
  public void cancelGoBack()
  {
    vh.closeStage3();
  }

}
