
import system.model.loginModel.Account;
import system.model.loginModel.DM;
import system.model.loginModel.Player;
import system.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccTest
{  private Account ac;

  @BeforeEach void setUp()
  {
    ac = new Account("1","2","3");

  }

  @AfterEach void tearDown()
  {
  }
  @Test void testAccountName()
{ String te= ac.getUsername();
  assertEquals(te,"1");
}
  @Test void testAccountPassword()
  { String te= ac.getPassword();
    assertEquals(te,"2");
  }
  @Test void testAccountEmail()
  { String te= ac.getEmail();
    assertEquals(te,"3");
  }
  @Test void testAccountSetPass()
  { String str = "10";
    ac.setPassword(str);
    assertEquals(ac.getPassword(),"10");
  }
  @Test void testAccountSetPlayer()
  { ac.setUserToPlayer();
    assertTrue(ac.getUser() instanceof Player);
  }
  @Test void testAccountSetDM()
  { ac.setUserToDm();
  assertTrue(ac.getUser() instanceof DM);
  }
  @Test void testAccountGetPlayer()
  { ac.setUserToPlayer();
    Player m = ac.getPlayer();

    assertTrue(m != null);
    assertEquals(m, ac.getPlayer());
  }
  @Test void testAccountGetDM()
  { ac.setUserToDm();
    DM m = ac.getDM();

    assertTrue(m != null);
   assertEquals(m,ac.getDM());
  }
  @Test void testAccountGetUser()
  { ac.setUserToPlayer();
    User m = ac.getUser();
      assertTrue(m !=null);
    assertEquals(m,ac.getUser());
  }
}