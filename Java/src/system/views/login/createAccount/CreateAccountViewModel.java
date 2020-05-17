package system.views.login.createAccount;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.AccountModel;

public class CreateAccountViewModel
{
  private AccountModel model;
  private StringProperty username;
  private StringProperty password1;
  private StringProperty password2;
  private StringProperty email;
  private StringProperty error;

  public CreateAccountViewModel(AccountModel accountModel)
  {
    model = accountModel;
    username = new SimpleStringProperty();
    password1 = new SimpleStringProperty();
    password2 = new SimpleStringProperty();
    email = new SimpleStringProperty();
    error = new SimpleStringProperty();
    username.setValue("");
    password1.setValue("");
    password2.setValue("");
    email.setValue("");
  }

  // calls the checkmethod on model, and after that resets the fields and gives the error for it if there is one, and passes the string to the view
  // to checks if its ready or not.
  public String checkFieldsForReg()
  {

    String temp = model
        .checkAccountUniqueness(username.getValue(), password1.getValue(),
            password2.getValue(), email.getValue());
    error.setValue(temp);
    username.setValue("");
    password1.setValue("");
    password2.setValue("");
    email.setValue("");
    return temp;

  }

  public StringProperty getUserNameProperty()
  {
    return username;
  }

  public StringProperty getPassword1Property()
  {
    return password1;
  }

  public StringProperty getPassword2Property()
  {
    return password2;
  }

  public StringProperty getEmailProperty()
  {
    return email;
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }
}
