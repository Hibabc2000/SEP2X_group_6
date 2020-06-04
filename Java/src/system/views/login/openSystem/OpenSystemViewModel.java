package system.views.login.openSystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.OpenSystemModel;
import system.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OpenSystemViewModel implements Subject
{
  private StringProperty username;
  private StringProperty password;
  private StringProperty error;
  private OpenSystemModel openSystemModel;
  private PropertyChangeSupport support;

  /**
   * Initializes the class attributes, listens for updates from the model
   *
   * @param openSystemModel model
   */
  public OpenSystemViewModel(OpenSystemModel openSystemModel)
  {
    this.openSystemModel = openSystemModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    error = new SimpleStringProperty();
    username.setValue("");
    password.setValue("");
    support = new PropertyChangeSupport(this);
    openSystemModel.addListener("acceptLogin", this::acceptLoginInfo);
   // accountModel.addListener("searchGroup", this::searchGroupAnswer);
  }

  /**
   * Checks the {@param propertyChangeEvent} value and fires an event(acceptTheGroup)
   * with a String value
   * if {@param propertyChangeEvent} is true String with the value "Ready"
   * will be displayed in the view otherwise an error will be returned.
   * @param propertyChangeEvent boolean value
   */
  private void searchGroupAnswer(PropertyChangeEvent propertyChangeEvent)
  {

    String val = "error";
    boolean respone = ((boolean) propertyChangeEvent.getNewValue());
    if (!respone)
    {
      val = "A group with this ID doesn't exist";
      error.setValue(val);
    }
    else
    {
      val = "The group has been added to your group list.";
      error.setValue(val);
    }
    support.firePropertyChange("acceptTheGroup", null, val);
  }

  /**
   * Checks the {@param propertyChangeEvent} value and fires an event(acceptTheLogIn)
   * with a String value
   * if {@param propertyChangeEvent} is true String with the value "Ready"
   * will be displayed in the view otherwise an error will be returned.
   */
  private void acceptLoginInfo(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("MIFAS?");
    String val = "error";
    System.out.println("event");
    boolean response = ((boolean) propertyChangeEvent.getNewValue());
    if (!response)
    {
      val = "Wrong password or username";
      error.setValue(val);
    }
    else
    {
      System.out.println("muhahhaa");
      val = "Ready";
      error.setValue(val);

    }

    support.firePropertyChange("acceptTheLogIn", null, val);

  }

  /**
   * Calls the model in order to check the credentials. Sets the error
   * username and password fields to empty Strings
   * @return String with an error if it is the case
   */
  public String checkLogin()
  {
    String temp = openSystemModel
        .checkLogin(username.getValue(), password.getValue());
    error.setValue(temp);
    username.setValue("");
    password.setValue("");
    return temp;
  }

  /**
   * Gets the username StringProperty
   * @return StringProperty
   */
  public StringProperty getUserNameProperty()
  {
    return username;
  }



  /**
   * Gets the password StringProperty
   * @return StringProperty
   */
  public StringProperty getPasswordProperty()
  {
    return password;
  }

  /**
   * Gets the error StringProperty
   * @return StringProperty
   */
  public StringProperty getErrorProperty()
  {
    return error;
  }

  /**
   * Adds the listener.
   * @param eventName String containing the event name
   * @param listener source bean so as to be notified of any bound property updates.
   */
  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  /**
   * Removes the listener.
   * @param eventName String containing the event name
   * @param listener  source bean so as to be notified of any bound property updates.
   */
  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
