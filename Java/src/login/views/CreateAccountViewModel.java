package login.views;

import login.AccountModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
    model= accountModel;
    username = new SimpleStringProperty();
    password1=new SimpleStringProperty();
    password2=new SimpleStringProperty();
    email=new SimpleStringProperty();
    error=new SimpleStringProperty();
    username.setValue("");
    password1.setValue("");
    password2.setValue("");
    email.setValue("");
  }
public String checkFieldsForReg()
{

   String temp= model.checkAccountUniqueness(username.getValue(),password1.getValue(),password2.getValue(),email.getValue());
error.setValue(temp);username.setValue("");
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
