package system.views.login.changeEmail;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.ChangeEmailModel;
import system.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChangeEmailViewModel implements Subject
{
  private ChangeEmailModel changeEmailModel;
  private StringProperty username;
  private StringProperty email;
  private StringProperty password;
  private StringProperty error;
  private PropertyChangeSupport support;

  /**
   * Initializes the class attributes and listens for updates from the model
   *
   * @param changeEmailModel model
   */
  public ChangeEmailViewModel(ChangeEmailModel changeEmailModel)
  {
    this.changeEmailModel = changeEmailModel;
     support = new PropertyChangeSupport(this);
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    email = new SimpleStringProperty();
    error = new SimpleStringProperty();
    error.setValue("");
    password.setValue("");
    email.setValue("");
    username.setValue("");
   changeEmailModel.addListener("emailChange",this::answerFromServer);
  }

  private void answerFromServer(PropertyChangeEvent propertyChangeEvent)
  {
    if((boolean)propertyChangeEvent.getNewValue())
    {
      error.setValue("Your email change was successful");  support.firePropertyChange("done",null,true);
    }
    else {error.setValue("This email is already in use");}

  }

  /**
   * Gets the username StringProperty value
   *
   * @return StringProperty
   */
  public StringProperty getUserNameProperty()
  {
    return username;
  }

  /**
   * Gets the password StringProperty value
   *
   * @return StringProperty
   */
  public StringProperty getPasswordProperty()
  {
    return password;
  }

  /**
   * Gets the error StringProperty value
   *
   * @return StringProperty
   */
  public StringProperty getErrorProperty()
  {
    return error;
  }

  /**
   * Gets the email StringProperty value
   *
   * @return StringProperty
   */
  public StringProperty getEmailProperty()
  {
    return email;
  }

  /**
   * Calls the model in order to check the credentials and sets the fields values to empty String
   *
   * @return String message containing an error if it is the case
   */
  public String checkEmailChangeInformation()
  {
    String temp = changeEmailModel
        .checkEmailChangeInformation(username.getValue(), password.getValue(),
            email.getValue());
    error.setValue(temp);
    password.setValue("");
    email.setValue("");
    username.setValue("");
    return temp;
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
