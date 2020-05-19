import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.transferobjects.login.Account;
import system.transferobjects.login.Group;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.model.loginModel.AccountModelImpl;
import system.views.login.createAccount.CreateAccountViewModel;
import system.views.login.dmAccount.DMAccountViewModel;
import system.views.login.playerAccount.PlayerAccountViewModel;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountModelImplTest
{
  private ArrayList<Account> tempAccounts;
  private ArrayList<Group> findingUnknownGroupsGroup;
  private ArrayList<Group> groupsForDm;
  private ArrayList<Group> tempGroups;

 private AccountModelImpl model;
private CreateAccountViewModel cavm;
   private DMAccountViewModel davm;
   private PlayerAccountViewModel pavm;
   private Account ac;
   private ArrayList<Group> hiddenGroups;
  private ArrayList<Group> playerKnownGroups;
  private ArrayList<Group> dmKnownGroups;

  @BeforeEach void setUp()
    {

      cavm =  new CreateAccountViewModel(model);
       davm = new DMAccountViewModel(model);
       pavm = new PlayerAccountViewModel(model);
      //acount setup, returns an already setup account name,pass,email are "1"
      ac = model.getAccount();
      model.addListener("GroupCreatedByDm",
          this::addGroupToList);
       //created groups
       hiddenGroups = model.getFindingUnknownGroupsGroup();
       playerKnownGroups = model.getTempGroups();
       dmKnownGroups = model.getGroupsForDm();
    }


    @AfterEach void tearDown()
    {
    }
  @Test void testGetGroupsAsPlayer()
  {
    ac.setUserToPlayer();


    StringProperty searchGroup= new SimpleStringProperty();
    StringProperty error = new SimpleStringProperty();
    ObservableList<String> groupList = FXCollections.observableArrayList();


    pavm.getErrorProperty().bind(error);
    pavm.getSearchGroupProperty().bindBidirectional(searchGroup);

    ObservableList<String> m = pavm.getGroupList();


    assertEquals(Arrays.toString(m.toArray()),
        Arrays.toString(playerKnownGroups.toArray()));


  }



    @Test void testCreateGroup1()
    {String name = "Group1";

      StringProperty error = new SimpleStringProperty();
      StringProperty textField = new SimpleStringProperty();
      ac.setUserToDm();



      davm.getTextFieldProperty().bindBidirectional(textField);
      davm.getErrorProperty().bindBidirectional(error);

      textField.setValue(name);
      davm.createGroup();

      assertEquals("Group created",error.getValue());






    }  // this is for checking the group creation propertychangeevent
    public void addGroupToList(PropertyChangeEvent propertyChangeEvent)
    {
      // the newly added group is third in the array.

      assertEquals(((Group) propertyChangeEvent.getNewValue()).toString(),hiddenGroups.get(3).toString());
    }


}
