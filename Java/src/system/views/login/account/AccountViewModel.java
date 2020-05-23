package system.views.login.account;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.AccountModel;

public class AccountViewModel
{
  private AccountModel model;
  private StringProperty userNameField;

  /**
   * Initializes the class attributes
   *
   * @param accountModel model
   */
  public AccountViewModel(AccountModel accountModel)
  {
    model = accountModel;
    userNameField = new SimpleStringProperty();
    getUsername();
  }

  /**
   * Get the user username and sets the String value to the userNameField StringProperty
   */
  private void getUsername()
  {
    userNameField.setValue(model.getUsername());
  }

  /**
   * Sends a request to the model in order to switch to the dm mode
   */
  public void changeToDm()
  {
    model.changeToDm();
  }

  /**
   * Sends a request to the model in order to switch to the player mode
   */
  public void changeToPlayer()
  {
    model.changeToPlayer();
  }

  // need to discuss this.
  public void removeAccount()
  {
    model.removeAccount();
  }

  /**
   * Gets userNameFieldProperty StringProperty value
   * @return userNameField value
   */
  public StringProperty userNameFieldProperty()
  {
    return userNameField;
  }
}
