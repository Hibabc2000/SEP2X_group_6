package system.views.login.passwordRecovery;

import system.model.loginModel.AccountModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PasswordRecoveryViewModel
{ private AccountModel model;
private StringProperty email;
private StringProperty error;
  public PasswordRecoveryViewModel(AccountModel accountModel)
  {model = accountModel;
  email= new SimpleStringProperty();
  error= new SimpleStringProperty();
  email.setValue("");
  }
  public String checkEmail()
  {
    // Pars a message to view (confirmation message)
    String temp= model.checkEmail(email.getValue());
    error.setValue(temp); email.setValue("");
    return temp;

  }
  public StringProperty getEmailProperty()
  {
    return email;
  }
  public StringProperty getErrorProperty()
  {return error;}
}
