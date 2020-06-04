package system.networking;

import system.model.businessModel.Character;
import system.transferobjects.login.Account;
import system.transferobjects.login.Group;
import system.util.Subject;

import java.io.IOException;

public interface Client extends Subject
{
  void start() throws IOException;
  void createAccount(String name, String password, String email);

  void changeEmail(String email, String username);

  void recoverPassword(String email);
  void createGroup(Account acc, String groupName);

  void changePassword(Account acc);


  void joinGroupAsAPlayer(Account acc, Group group);
  void searchGroup(int id, String user);
  void removeUser(Account ac);

//  open system
  void checkLogin(String username, String password);

  void submitCharacter(Character character);
  void startGame(Group groupToPlayWith);
  void getStaticModel();
}
