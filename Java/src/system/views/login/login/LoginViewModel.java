package system.views.login.login;

import system.model.loginModel.AccountModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{ private AccountModel model;
 private StringProperty username;
 private StringProperty password;
 private StringProperty error;
  public LoginViewModel(AccountModel accountModel)
  {
    model = accountModel;
    username= new SimpleStringProperty();
    password=new SimpleStringProperty();
    error= new SimpleStringProperty();
    username.setValue("");
    password.setValue("");
  }
  public String checkLogin()
  {
    String temp= model.checkLogin(username.getValue(),password.getValue());
    error.setValue(temp);username.setValue("");
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
