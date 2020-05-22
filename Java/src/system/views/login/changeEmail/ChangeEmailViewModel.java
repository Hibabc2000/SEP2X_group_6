package system.views.login.changeEmail;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.AccountModel;

public class ChangeEmailViewModel
{
  private AccountModel accountModel;
  private StringProperty username;
  private StringProperty email;
  private StringProperty password;
  private StringProperty error;

  /**
   * Initializes the class attributes and listens for updates from the model
   *
   * @param accountModel model
   */
  public ChangeEmailViewModel(AccountModel accountModel)
  {
    this.accountModel = accountModel;

    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    email = new SimpleStringProperty();
    error = new SimpleStringProperty();
    error.setValue("");
    password.setValue("");
    email.setValue("");
    username.setValue("");
  }

  /**
   * Gets the username StringProperty value
   *
   * @return StringProperty
   */
  public StringProperty getUserNameProperty()
  {
    return username;
  }

  /**
   * Gets the password StringProperty value
   *
   * @return StringProperty
   */
  public StringProperty getPasswordProperty()
  {
    return password;
  }

  /**
   * Gets the error StringProperty value
   *
   * @return StringProperty
   */
  public StringProperty getErrorProperty()
  {
    return error;
  }

  /**
   * Gets the email StringProperty value
   *
   * @return StringProperty
   */
  public StringProperty getEmailProperty()
  {
    return email;
  }

  /**
   * Calls the model in order to check the credentials and sets the fields values to empty String
   *
   * @return String message containing an error if it is the case
   */
  public String checkEmailChangeInformation()
  {
    String temp = accountModel
        .checkEmailChangeInformation(username.getValue(), password.getValue(),
            email.getValue());
    error.setValue(temp);
    password.setValue("");
    email.setValue("");
    username.setValue("");
    return temp;
  }
}
