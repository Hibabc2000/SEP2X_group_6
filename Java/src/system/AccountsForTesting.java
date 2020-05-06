package system;

import java.util.ArrayList;

public class AccountsForTesting           // just testcl
{
  private ArrayList<Group> tempGroups;
  private ArrayList<Group> groupsForDm;
  private ArrayList<Group> findingUnknownGroupsGroup;
  private ArrayList<Account> tempAccounts;
  private Account usersAccount;
  private Account dmKristof;

  public AccountsForTesting()
  {
    tempGroups = new ArrayList<>();
    groupsForDm = new ArrayList<>();
    tempAccounts = new ArrayList<>();
    findingUnknownGroupsGroup = new ArrayList<>();

    tempAccounts
        .add(new Account("Kristof", "kecskepásztor123", "kristof@gmail.com"));
    tempAccounts
        .add(new Account("Ali", "reeeeeeee123", "averagereddituser@gmail.com"));
    tempAccounts
        .add(new Account("Marin", "perfectionist123", "MarinGodx@gmail.com"));
    tempAccounts
        .add(new Account("Silvestru", "dotation123", "myleghurts@gmail.com"));
    tempAccounts.add(new Account("1", "1", "1"));
    Account dmk = tempAccounts.get(0);
    Account pa = tempAccounts.get(1);
    Account pm = tempAccounts.get(2);
    Account ps = tempAccounts.get(3);
    dmk.setUserToDm();
    pa.setUserToPlayer();
    pm.setUserToPlayer();
    ps.setUserToPlayer();
    Group secretGroup = new Group("Secret Assassins of the Dark Shadow Cult",
        1337);
    secretGroup.addDM(dmk.getDM());
    secretGroup.addPlayer(pa.getPlayer());
    secretGroup.addPlayer(pm.getPlayer());
    secretGroup.addPlayer(ps.getPlayer());
    Account dmKristof = new Account("Kris", "kecs", "a@gmail.com");
    Account playerAli = new Account("Al", "ree", "aa@gmail.com");
    Account playerMarin = new Account("Mar", "perf", "Mga@gmail.com");
    Account playerSilvestru = new Account("Silv", "dot", "corona@gmail.com");
    dmKristof.setUserToDm();
    playerAli.setUserToPlayer();
    playerMarin.setUserToPlayer();
    playerSilvestru.setUserToPlayer();
    tempAccounts.add(dmKristof);
    tempAccounts.add(playerAli);
    tempAccounts.add(playerMarin);
    tempAccounts.add(playerSilvestru);

    Group group1 = new Group("FellowShipOfTheRing", 1111);
    group1.addPlayer(playerAli.getPlayer());
    group1.addPlayer(playerMarin.getPlayer());
    group1.addPlayer(playerSilvestru.getPlayer());
    group1.addDM(dmKristof.getDM());
    tempGroups.add(group1);
    findingUnknownGroupsGroup.add(secretGroup);
    findingUnknownGroupsGroup.add(group1);

    Account player0 = new Account("Obama", "obamaprism", "barack@gmail.com");
    Account player1 = new Account("Trump", "wallbuilder", "fakehair@gmail.com");
    Account player2 = new Account("Bruce Lee", "martialarts123",
        "belikewater@gmail.com");
    Account player3 = new Account("Michael Jackson", "ilikechildren",
        "goodchildren@gmail.com");
    player0.setUserToDm();

    player1.setUserToPlayer();
    player2.setUserToPlayer();
    player3.setUserToPlayer();
    tempAccounts.add(player0);
    tempAccounts.add(player1);
    tempAccounts.add(player2);
    tempAccounts.add(player3);
    Group groupdm = new Group("Reeeeeeeee", 2222);

    groupdm.addDM(player0.getDM());
    groupdm.addPlayer(player1.getPlayer());
    groupdm.addPlayer(player2.getPlayer());
    groupdm.addPlayer(player3.getPlayer());

    findingUnknownGroupsGroup.add(groupdm);
  }

  public Account getAcc()
  {
    return usersAccount;
  }

  public ArrayList<Group> getTempGroups()
  {
    return tempGroups;
  }

  public ArrayList<Group> getGroupsForDm()
  {
    return groupsForDm;
  }

  public ArrayList<Group> getFindingUnknownGroupsGroup()
  {
    return findingUnknownGroupsGroup;
  }

  public ArrayList<Account> getTempAccounts()
  {
    return tempAccounts;
  }
}
