package system.views.login.passwordRecovery;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.AccountModel;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class PasswordRecoveryViewModel
{
  private AccountModel model;
  private StringProperty email;
  private StringProperty error;

  /**
   * Initializes the class attributes
   *
   * @param accountModel
   */
  public PasswordRecoveryViewModel(AccountModel accountModel)
  {
    model = accountModel;
    email = new SimpleStringProperty();
    error = new SimpleStringProperty();
    email.setValue("");
    model.addListener("recoverPassword", this::recoverPasswordBackFromServer);
  }

  /**
   * Converts the Property Change Event to an ArrayList. The first position of the arrayList contains the
   * response from the server. If it is true the second object in the arrayList will be the password which is returned in the
   * view. If it is false an error will be displayed.
   *
   * @param propertyChangeEvent Container contains an ArrayList of two objects(boolean and the recovered password)
   */
  private void recoverPasswordBackFromServer(
      PropertyChangeEvent propertyChangeEvent)
  {
    ArrayList<Object> objs = (ArrayList<Object>)  propertyChangeEvent.getNewValue();
    boolean answer = (boolean) objs.get(0);
    String password = (String) objs.get(1);
    if (answer)
    {
      error.setValue("Your password is: " + password);
    }
    else
      error.setValue("The email was not found");
  }

  /**
   * Calls the model in order to check the credentials
   *
   * @return String message containing an error if it is the case
   */
  public String checkEmail()
  {
    // Pars a message to view (confirmation message)
    String temp = model.checkEmail(email.getValue());
    error.setValue(temp);
    email.setValue("");
    return temp;

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
