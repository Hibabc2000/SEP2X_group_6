package system.views.login.openSystem;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.model.loginModel.AccountModel;
import system.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class OpenSystemViewModel implements Subject
{
  private StringProperty username;
  private StringProperty password;
  private StringProperty error;
  private AccountModel accountModel;
  private PropertyChangeSupport support;

  public OpenSystemViewModel(AccountModel accountModel)
  {
    this.accountModel = accountModel;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    error = new SimpleStringProperty();
    username.setValue("");
    password.setValue("");
    support = new PropertyChangeSupport(this);
    accountModel.addListener("acceptLogin", this::acceptLoginInfo);
    accountModel.addListener("searchGroup",this::searchGroupAnswer);
  }

  private void searchGroupAnswer(PropertyChangeEvent propertyChangeEvent)
  {
    String val = "error";
    boolean respone = ((boolean) propertyChangeEvent.getNewValue());
  if(!respone)
  {
    val = "A group with this ID doesn't exist";
    error.setValue(val);
  }
  else{val="The group has been added to your group list."; error.setValue(val);}
    support.firePropertyChange("acceptTheGroup",null, val);

  }

  private void acceptLoginInfo(PropertyChangeEvent propertyChangeEvent)
  {String val = "error";
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

    support.firePropertyChange("acceptTheLogIn",null, val);


  }

  public String checkLogin()
  {
    String temp = accountModel.checkLogin(username.getValue(), password.getValue());
    error.setValue(temp);
    username.setValue("");
    password.setValue("");
    return temp;
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

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
