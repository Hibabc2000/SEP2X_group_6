package system.views.login.createAccount;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.CreateAccountModel;
import system.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CreateAccountViewModel implements Subject
{
  private CreateAccountModel createAccountModel;
  private StringProperty username;
  private StringProperty password1;
  private StringProperty password2;
  private StringProperty email;
  private StringProperty error;
  private PropertyChangeSupport support;

  /**
   * Initializes the class attributes, listens for updates from the model
   *
   * @param accountModel model
   */
  public CreateAccountViewModel(CreateAccountModel accountModel)
  {
    support = new PropertyChangeSupport(this);
    createAccountModel = accountModel;
    username = new SimpleStringProperty();
    password1 = new SimpleStringProperty();
    password2 = new SimpleStringProperty();
    email = new SimpleStringProperty();
    error = new SimpleStringProperty();
    username.setValue("");
    password1.setValue("");
    password2.setValue("");
    email.setValue("");
    createAccountModel.addListener("createAccount", this::accountCreationInfo);

  }

  /**
   * Checks the received propertyChangeEvent boolean value if it is true an event containing
   * a String with the value "Ready" will be fired to the controller, otherwise the String will
   * contain an error message
   *
   * @param propertyChangeEvent boolean
   */
  private void accountCreationInfo(PropertyChangeEvent propertyChangeEvent)
  {
    String val = "error";
    System.out.println("event");
    if (!((boolean) propertyChangeEvent.getNewValue()))
    {
      val = "This username or email is already in use.";
      error.setValue(val);
    }
    else
    {
      val = "Ready";
    }
    support.firePropertyChange("createAccount", null, val);

  }

  /**
   * Calls the checkAccountUniqueness method on model, and after that resets the fields and gives
   * the error for it if there is one, and passes the string to the view to checks if its ready or not.
   *
   * @return a String containing a message
   */
  public String checkFieldsForReg()
  {
    String temp = createAccountModel
        .checkAccountUniqueness(username.getValue(), password1.getValue(),
            password2.getValue(), email.getValue());
    error.setValue(temp);
    if (!temp.equals("Connecting..."))
    {
      username.setValue("");
      password1.setValue("");
      password2.setValue("");
      email.setValue("");
    }

    return temp;

  }

  /**
   * Gets the username StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getUserNameProperty()
  {
    return username;
  }

  /**
   * Gets the password1 StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getPassword1Property()
  {
    return password1;
  }

  /**
   * Gets the password2 StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getPassword2Property()
  {
    return password2;
  }

  /**
   * Gets the email StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getEmailProperty()
  {
    return email;
  }

  /**
   * Gets the error StringProperty
   *
   * @return StringProperty
   */
  public StringProperty getErrorProperty()
  {
    return error;
  }

  /**
   * Adds the listener.
   *
   * @param eventName String containing the event name
   * @param listener  source bean so as to be notified of any bound property updates.
   */
  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  /**
   * Removes the listener.
   *
   * @param eventName String containing the event name
   * @param listener  source bean so as to be notified of any bound property updates.
   */
  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
