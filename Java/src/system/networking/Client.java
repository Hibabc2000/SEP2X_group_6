package system.networking;

import system.transferobjects.login.Account;
import system.transferobjects.login.Group;
import system.util.Subject;

import java.io.IOException;

public interface Client extends Subject
{
  void start() throws IOException;
  void createAccount(String name, String password, String email);

  void changeEmail(Account acc, String email);

  void recoverPassword(String email);
  void createGroup(Account acc, String groupName);

  void changePassword(Account acc,
      String oldPassword);


  void joinGroupAsAPlayer(Account acc, Group group);
  void searchGroup(int id, String user);
  void removeUser(Account ac);

//  open system
void checkLogin(String username, String password);
}
