package login.views;

import login.AccountModel;
import login.Group;
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


  }

  private void addPlayerToGroup(PropertyChangeEvent propertyChangeEvent)
  {
  for(int i =0; i<groupList.size();i++)
  {

    if(groupList.get(i).equals(propertyChangeEvent.getOldValue().toString()))
    {groupList.set(i,propertyChangeEvent.getNewValue().toString());}

  }
  }

  private void addToGroupList(PropertyChangeEvent propertyChangeEvent)
    {ArrayList<Group> temp= new ArrayList<>();
    temp.add((Group) propertyChangeEvent.getNewValue());
      groupList.add(((Group)propertyChangeEvent.getNewValue()).toString());
    }

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

  public void addGroup(String text)
  {  try {
    int temp = Integer.parseInt(text);error.setValue(model.searchGroup(temp));}
    catch(NumberFormatException e)
    {
      System.out.println("wtF?");; error.setValue("Incorrect ID");}

  }

  public void joinGroupAsPlayer(String groupname)
  {
     error.setValue(model.joinGroupAsPlayer(groupname));
  }


}
