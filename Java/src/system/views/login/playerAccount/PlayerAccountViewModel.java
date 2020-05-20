package system.views.login.playerAccount;

import system.model.loginModel.AccountModel;
import system.transferobjects.login.Group;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class PlayerAccountViewModel
{
  private AccountModel model;
  private StringProperty searchGroup;
  private StringProperty error;
  private ObservableList<String> groupList;
  public PlayerAccountViewModel(AccountModel accountModel)
  {
    model = accountModel;
    searchGroup = new SimpleStringProperty();
    error = new SimpleStringProperty();
    groupList = FXCollections.observableArrayList();
    model.addListener("GroupAdded",this::addToGroupList);
    model.addListener("PlayerAddedToGroup",this::addPlayerToGroup);
    model.addListener("searchFailed",this::searchFail);


  }

  private void searchFail(PropertyChangeEvent propertyChangeEvent)
  {
    error.setValue("A group with this ID does not exist.");
  }

  // here we go through the grouplist and check whether the "oldgroup" variable equals one of the groups that are in the list right now.
  // if yes then  we will take that and change it to the new group which has been updated with your name in it.
  private void addPlayerToGroup(PropertyChangeEvent propertyChangeEvent)
  {
  for(int i =0; i<groupList.size();i++)
  {

    if(groupList.get(i).equals(propertyChangeEvent.getOldValue().toString()))
    {groupList.set(i,propertyChangeEvent.getNewValue().toString());}

  }
  }
// this adds a new group to the group list.
  private void addToGroupList(PropertyChangeEvent propertyChangeEvent)
    {
      groupList.add(((Group)propertyChangeEvent.getNewValue()).toString());
      error.set("Group added to your group list");
    }
// this method creates the grouplist  when the scene is opened
  // the getGroups method returns the groups the player already knows or is part of.
  // all of them are added to an arraylist<string> and that list is added to the observablelist and returned to the accountcontroller and view.
    public ObservableList<String> getGroupList()
  { ArrayList<String> groupsInString= new ArrayList<>();
    ArrayList<Group> temp = model.getGroups();
    for (int i =0; i<temp.size();i++)
    {groupsInString.add(temp.get(i).toString());

    }
    groupList.addAll(groupsInString);
    return groupList;
  }
  public StringProperty getSearchGroupProperty()
  {
    return searchGroup;
  }
  public StringProperty getErrorProperty()
  {
    return error;
  }


  // I parse the group ID string into integer so I can work with it. + also a numberformatexception is needed.
  public void addGroup(String text)
  {  try {
    int temp = Integer.parseInt(text);error.setValue(model.searchGroup(temp));}
    catch(NumberFormatException e)
    {
       error.setValue("Incorrect ID");}

  }
// if nothing was selected in view then it just shows an error.
  // else it call a method on accoutmodel to join the group and also at the same time sets the error value because that method also gives back a string.
  public void joinGroupAsPlayer(String groupname)
  {   if(groupname.equals("")) {error.setValue("Select a group from the list");}
  else
     error.setValue(model.joinGroupAsPlayer(groupname));
  }


}
