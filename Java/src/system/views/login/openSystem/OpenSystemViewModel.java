package system.views.login.openSystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.AccountModel;

public class OpenSystemViewModel
{
  private StringProperty username;
  private StringProperty password;
  private StringProperty error;
  private AccountModel accountModel;

  public OpenSystemViewModel(AccountModel accountModel)
  {
    this.accountModel = accountModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    error = new SimpleStringProperty();
    username.setValue("");
    password.setValue("");
  }

  public String checkLogin()
  {
    String temp = accountModel.checkLogin(username.getValue(), password.getValue());
    error.setValue(temp);
    username.setValue("");
    password.setValue("");
    return temp;
  }
  public StringProperty getUserNameProperty()
  {
    return username;
  }

  public StringProperty getPasswordProperty()
  {
    return password;
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }
}
