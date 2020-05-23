package system.model.loginModel;

import system.transferobjects.login.Account;
import system.transferobjects.login.Group;
import system.util.Subject;

import java.util.ArrayList;

public interface AccountModel extends Subject
{
  String checkAccountUniqueness(String username, String pass1, String pass2,
      String email);
  String checkLogin(String username, String pass);
  String checkEmail(String value);
  void changeToDm();
  void changeToPlayer();
  String checkPasswordChangeInformation(String username, String passOld,
      String passNew, String passNewAgain);
  void removeAccount();
  String createGroup(String name);
  String searchGroup(int id);
  ArrayList<Group> getGroups();

 String joinGroupAsPlayer(String groupName);
  String checkEmailChangeInformation(String value, String value1, String value2);
  String getUsername();
  Account getAccount();
}
