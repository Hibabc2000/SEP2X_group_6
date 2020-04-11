package login.views;

import login.AccountModel;
import login.Group;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class DMAccountViewModel
{
  private AccountModel model;
  private StringProperty error;
  private StringProperty textField;
  private ObservableList<String> groupListDM;
  public DMAccountViewModel(AccountModel accountModel)
  {model=accountModel;
  error=new SimpleStringProperty();
  textField= new SimpleStringProperty();
    groupListDM = FXCollections.observableArrayList();
    textField.setValue("");

    model.addListener("GroupCreatedByDm",this::startGameWithGroup);
  }

  private void startGameWithGroup(PropertyChangeEvent propertyChangeEvent)
  {ArrayList<Group> temp= new ArrayList<>();
    temp.add((Group) propertyChangeEvent.getNewValue());
    groupListDM.add(((Group)propertyChangeEvent.getNewValue()).toString());
  }

  public StringProperty getErrorProperty()
  {
    return error;
  }
  public StringProperty getTextFieldProperty()
  {
    return textField;
  }

  public ObservableList<String> getGroupList()
  { ArrayList<String> groupsInString= new ArrayList<>();
    ArrayList<Group> temp = model.getGroups();
    for (int i =0; i<temp.size();i++)
    {groupsInString.add(temp.get(i).toString());

    }
    groupListDM.addAll(groupsInString);
    return groupListDM;
  }

  public String  createGroup()
  { String temp = "Error";
    if(textField.getValue()==null || textField.getValue().equals(""))

      {error.setValue("Choose a name for your group");}
      else
  {temp = model.createGroup(textField.getValue());}
    return temp;
  }

}
