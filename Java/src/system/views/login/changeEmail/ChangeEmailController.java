package system.views.login.changeEmail;

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

  /**
   * /**
   * Initializes the class attributes, binds the fxml fields to view model properties.
   *
   * @param changeEmailViewModel view model
   * @param viewHandler          used for changing the views
   */

  public void init(ChangeEmailViewModel changeEmailViewModel,
      ViewHandler viewHandler)
  {

    cevmodel = changeEmailViewModel;
    vh = viewHandler;
    errorMessage.textProperty().bind(cevmodel.getErrorProperty());
    usernameField.textProperty()
        .bindBidirectional(cevmodel.getUserNameProperty());
    passwordField.textProperty()
        .bindBidirectional(cevmodel.getPasswordProperty());
    emailField.textProperty().bindBidirectional(cevmodel.getEmailProperty());

  }

  /**
   * Sends a request to the view model in order to check the credentials. If the email is changed
   * successfully the stage will be closed
   */
  public void confirmEmailButton()
  {
    if (cevmodel.checkEmailChangeInformation().equals("Ready"))
    {
      vh.closeStage4();
    }

  }

  /**
   * Closes the stage
   */
  public void cancelEmailChange()
  {
    vh.closeStage4();
  }
}
