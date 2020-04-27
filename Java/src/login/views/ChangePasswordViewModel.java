package login.views;

import login.AccountModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ChangePasswordViewModel
{
  private AccountModel model;
  private StringProperty username;
  private StringProperty passwordOld;
  private  StringProperty passwordNew;
  private StringProperty passwordNewAgain;
  private StringProperty error;

  public ChangePasswordViewModel(AccountModel accountModel)
  {model=accountModel;

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

  public StringProperty getUserNameProperty()
  {
    return username;
  }
  public StringProperty getPasswordOldProperty()
  {
    return passwordOld;
  }
  public StringProperty getErrorProperty()
  {
    return error;
  }
  public StringProperty getPasswordNewProperty()
  {
    return passwordNew;
  }
  public StringProperty getPasswordNewAgainProperty()
  {
    return passwordNewAgain;
  }
  // calls the checkmethod on model, and after that resets the fields and gives the error for it if there is one, and passes the string to the view
  // to checks if its ready or not.
  public String checkPasswordChangeInformation()
  {
    String temp = model.checkPasswordChangeInformation(username.getValue(),passwordOld.getValue(),passwordNew.getValue(),passwordNewAgain.getValue());
    error.setValue(temp);
    passwordOld.setValue("");
    passwordNew.setValue("");
    passwordNewAgain.setValue("");
    username.setValue("");
    return temp;
  }
}
