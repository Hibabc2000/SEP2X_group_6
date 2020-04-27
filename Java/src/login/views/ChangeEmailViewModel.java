package login.views;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import login.AccountModel;

public class ChangeEmailViewModel
{  private AccountModel model;
  private StringProperty username;
  private StringProperty email;
  private  StringProperty password;
  private StringProperty error;

  public ChangeEmailViewModel(AccountModel accountModel)
  { model = accountModel;

    username= new SimpleStringProperty();
    password = new SimpleStringProperty();
    email = new SimpleStringProperty();
    error = new SimpleStringProperty();
    error.setValue("");
    password.setValue("");
   email.setValue("");
    username.setValue("");
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
  public StringProperty getEmailProperty()
  {
    return email;
  }

  // calls the checkmethod on model, and after that resets the fields and gives the error for it if there is one, and passes the string to the view
  // to checks if its ready or not.
  public String checkEmailChangeInformation()
  {
    String temp = model.checkEmailChangeInformation(username.getValue(),password.getValue(),email.getValue());
    error.setValue(temp);
    password.setValue("");
    email.setValue("");
    username.setValue("");
    return temp;
  }
}
