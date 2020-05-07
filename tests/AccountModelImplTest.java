import system.Account;
import system.AccountsForTesting;
import system.Group;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.model.loginModel.AccountModel;
import system.model.loginModel.AccountModelImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountModelImplTest
{
  private ArrayList<Account> tempAccounts;
  private ArrayList<Group> findingUnknownGroupsGroup;
  private ArrayList<Group> groupsForDm;
  private ArrayList<Group> tempGroups;

 private AccountModelImpl model;


  @BeforeEach void setUp()
    {
      model = new AccountModelImpl();



    }


    @AfterEach void tearDown()
    {
    }
    @Test void testCreateGroup()
    {String name = "Group1";
      Account ac = model.getAccount();

     model.createGroup(name);





    }
}
