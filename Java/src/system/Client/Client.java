package system.Client;

import system.model.loginModel.Account;
import system.model.loginModel.Group;
import system.util.Subject;

import java.io.IOException;

public interface Client extends Subject
{
  void start() throws IOException;
void createAccount(String name, String password, String email);
void loginAccount(String name, String password);
void changeEmail(Account acc, String email);
void changePassword(Account acc, String newPassword, String oldPassword);
void recoverPassword(String email);
void createGroup(Account acc, Group g);
void joinGroup(Account acc, Group g);
 void  checkEmailChangeInformation(Account acc, String email);
 void checkPasswordChangeInformation(Account acc, String newPassword, String oldPassword);
 void checkEmail(String email);
void checkLogin(String username, String password);
void checkAccountUniqueness(String username, String password, String email);
void joinGroupAsAPlayer(Account acc,Group g);
void searchGroup(int id, String user);
void removeUser(Account ac);
}
