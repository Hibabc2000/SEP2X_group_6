import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import system.model.loginModel.AccountModelImpl;
import system.transferobjects.login.Account;
import system.transferobjects.login.Group;
import system.views.login.createAccount.CreateAccountViewModel;
import system.views.login.dmAccount.DMAccountViewModel;
import system.views.login.playerAccount.PlayerAccountViewModel;

import java.util.ArrayList;

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


    }


    @AfterEach void tearDown()
    {
    }



}
