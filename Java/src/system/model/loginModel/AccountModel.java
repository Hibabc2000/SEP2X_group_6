package system.model.loginModel;

import system.transferobjects.login.Account;
import system.util.Subject;

public interface AccountModel extends Subject
{
  void changeToDm();
  void changeToPlayer();
  void removeAccount();
  String createGroup(String name);
  String getUsername();
  Account getAccount();
}
