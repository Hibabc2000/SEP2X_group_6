package system.views.login.dmAccount;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.model.loginModel.AccountModel;
import system.transferobjects.login.Group;
import system.transferobjects.login.Player;
import system.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class DMAccountViewModel implements Subject
{
  private AccountModel model;
  private StringProperty error;
  private StringProperty textField;
  private ObservableList<String> groupListDM;

  public DMAccountViewModel(AccountModel accountModel)
  {
    model = accountModel;
    error = new SimpleStringProperty();
    textField = new SimpleStringProperty();
    groupListDM = FXCollections.observableArrayList();
    textField.setValue("");

    model.addListener("GroupCreatedByDm",
        this::addGroupToList);   // listener if a new group is created by you.
    model.addListener("PlayerAddedToDMGroup",this::addPlayerToGroup);
  }

  private void addPlayerToGroup(PropertyChangeEvent propertyChangeEvent)
  { System.out.println("this is addplayertogroup method in playeraccountvm");
    for(int i =0; i<groupListDM.size();i++)
    {
      System.out.println("Mosr plYWER adok hozza az fxml-hez te fasz");
      if(groupListDM.get(i).equals(propertyChangeEvent.getOldValue().toString()))
      {Group adgruop = (Group) propertyChangeEvent.getOldValue();
        adgruop.addPlayer((Player)propertyChangeEvent.getNewValue());
        groupListDM.set(i,adgruop.toString());
        System.out.println("THIS IS OLD VALUE : \n"+propertyChangeEvent.getOldValue().toString());
        System.out.println( adgruop.toString());
      }

    }
  }

  // adds the new group to the group list.
  private void addGroupToList(PropertyChangeEvent propertyChangeEvent)
  {
    groupListDM.add(((Group) propertyChangeEvent.getNewValue()).toString());
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }

  public StringProperty getTextFieldProperty()
  {
    return textField;
  }

  // this method creates the grouplist  when the scene is opened
  // the getGroups method returns the groups the DM already created.
  // all of them are added to an arraylist<string> and that list is added to the observablelist and returned to the accountcontroller and view.
  public ObservableList<String> getGroupList()
  {
    ArrayList<String> groupsInString = new ArrayList<>();
    ArrayList<Group> temp = model.getGroups();
    for (int i = 0; i < temp.size(); i++)
    {
      groupsInString.add(temp.get(i).toString());

    }
    groupListDM.addAll(groupsInString);
    return groupListDM;
  }

  // method for creating a group checks whether the field is empty and calls the method createGroup if not. if yes, sets error.
  public void createGroup()
  {
    String temp = "Error";
    if (textField.getValue() == null || textField.getValue().equals(""))
    {
      error.setValue("Choose a name for your group");
    }
    else
    {
      temp = model.createGroup(textField.getValue());
    }
    error.setValue(temp);
  }

  public void joinGroupAsDM()
  {

  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {

  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {

  }
}
