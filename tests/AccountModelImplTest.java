import system.Account;
import system.AccountsForTesting;
import system.Group;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

  private PropertyChangeSupport support;
  private Account usersAccount;

  private AccountsForTesting tests;


  @BeforeEach void setUp()
    {usersAccount= new Account("1","1","1");
      support = new PropertyChangeSupport(this);
      tests = new AccountsForTesting();
      tempGroups = new ArrayList<>();
      groupsForDm= new ArrayList<>();
      tempAccounts = new ArrayList<>();
      findingUnknownGroupsGroup = new ArrayList<>();
      // for testing
      usersAccount = tests.getAcc();
      tempGroups = tests.getTempGroups();
      groupsForDm = tests.getGroupsForDm();
      tempAccounts = tests.getTempAccounts();
      findingUnknownGroupsGroup = tests.getFindingUnknownGroupsGroup();



    }
  public void addListener(String eventName, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

    @AfterEach void tearDown()
    {
    }
    @Test void testCreateGroup()
    {
      String name = "alma";


    }
}
