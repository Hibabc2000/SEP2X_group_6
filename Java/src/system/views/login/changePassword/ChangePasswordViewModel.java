package system.views.login.changePassword;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.ChangePasswordModel;

public class ChangePasswordViewModel
{
  private ChangePasswordModel changePasswordModel;
  private StringProperty username;
  private StringProperty passwordOld;
  private  StringProperty passwordNew;
  private StringProperty passwordNewAgain;
  private StringProperty error;

  /**
   * Initializes the class attributes, listens for updates from the model
   *
   * @param changePasswordModel model
   */
  public ChangePasswordViewModel(ChangePasswordModel changePasswordModel)
  {
    this.changePasswordModel =changePasswordModel;

   username= new SimpleStringProperty();
   passwordNew = new SimpleStringProperty();
   passwordNewAgain = new SimpleStringProperty();
   passwordOld = new SimpleStringProperty();
   error = new SimpleStringProperty();
   error.setValue("");
   passwordOld.setValue("");
   passwordNewAgain.setValue("");
   passwordNew.setValue("");
   username.setValue("");
  }
  /**
   * Gets the username StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getUserNameProperty()
  {
    return username;
  }

  /**
   * Gets the passwordOld StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getPasswordOldProperty()
  {
    return passwordOld;
  }

  /**
   * Gets the error StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getErrorProperty()
  {
    return error;
  }

  /**
   * Gets the passwordNew StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getPasswordNewProperty()
  {
    return passwordNew;
  }

  /**
   * Gets the passwordNewAgain StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getPasswordNewAgainProperty()
  {
    return passwordNewAgain;
  }
  // calls the checkmethod on model, and after that resets the fields and gives the error for it if there is one, and passes the string to the view
  // to checks if its ready or not.

  /**
   * Calls the checkPasswordChangeInformation method on model, and after that resets the fields.
   *
   * @return a String containing a message
   */
  public String checkPasswordChangeInformation()
  {
    String temp = changePasswordModel
        .checkPasswordChangeInformation(username.getValue(),passwordOld.getValue(),passwordNew.getValue(),passwordNewAgain.getValue());
    error.setValue(temp);
    passwordOld.setValue("");
    passwordNew.setValue("");
    passwordNewAgain.setValue("");
    username.setValue("");
    return temp;
  }
}
