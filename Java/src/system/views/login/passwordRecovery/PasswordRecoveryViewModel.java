package system.views.login.passwordRecovery;

import system.model.loginModel.AccountModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.transferobjects.Container;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class PasswordRecoveryViewModel
{ private AccountModel model;
private StringProperty email;
private StringProperty error;

  /**
   *  Initializes the class attributes
   * @param accountModel
   */
  public PasswordRecoveryViewModel(AccountModel accountModel)
  {model = accountModel;
  email= new SimpleStringProperty();
  error= new SimpleStringProperty();
  email.setValue("");
    model.addListener("recoverPassword", this::recoverPasswordBackFromServer);
  }

  private void recoverPasswordBackFromServer(
      PropertyChangeEvent propertyChangeEvent)
  {
    ArrayList<Object> objs = (ArrayList<Object>) ((Container) propertyChangeEvent
        .getNewValue()).getObject();
    boolean answer= (boolean) objs.get(0);
    String password= (String) objs.get(1);
    if(answer){
error.setValue("Your password is: "+password);
    }else
      error.setValue("The email was not found");
  }

  /**
   * Calls the model in order to check the credentials
   * @return String message containing an error if it is the case
   */
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
