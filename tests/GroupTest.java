import system.DM;
import system.Group;
import system.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GroupTest
{  private Group gr;
  private ArrayList<Player> players;


  @BeforeEach void setUp()
  {
    gr = new Group("WoW",1212);
    players= new ArrayList<>();
    gr.addDM(new DM("alma"));
    gr.addPlayer(new Player("kecske"));
    gr.addPlayer(new Player("tomato"));
  }

  @AfterEach void tearDown()
  {
  }
  @Test void testGetGroupId()
  { int m= gr.getId();
    assertEquals(m,1212);
  }
  @Test void testGetGroupDM()
{ DM m= gr.getDM();
  assertTrue(m instanceof DM && m.getName().equals("alma"));
  assertEquals(m,gr.getDM());
}
  @Test void testAddGroupDM()
  { String k = "béla";
  DM m = new DM(k);
    gr.addDM(m);
    assertTrue(gr.getDM() instanceof DM && gr.getDM().getName().equals("béla"));
    assertEquals(m, gr.getDM());

  }
  @Test void testGetGroupPlayer()
  { Player pl = gr.getPlayer("kecske");

    assertTrue(
        pl.getName().equals("kecske") && pl.equals(gr.getPlayer("kecske")));
  }
  @Test void testAddGroupPlayer()
  { Player pl = new Player("medve");
  gr.addPlayer(pl);

    assertTrue(pl instanceof Player && gr.getPlayer("medve").equals(pl));
  }
  @Test void testToString()
  { String m = gr.toString();

    assertTrue(m instanceof String);
    assertEquals(m, gr.toString());
  }
  @Test void testIsPlayerPartOfGroup()
  { Player pl = new Player("mol");
  Player pl2 = gr.getPlayer("kecske");


   assertFalse(gr.isPlayerPartOfGroup(pl));

    assertTrue( gr.isPlayerPartOfGroup(pl2));
  }
  @Test void testIsContainsUsername()
  { String username = "kecske";

    assertTrue(gr.isContainsUsername(username));
  }



}