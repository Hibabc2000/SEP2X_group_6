package system.networking;

import system.model.loginModel.Account;
import system.model.loginModel.Group;
import system.util.Subject;

import java.io.IOException;

public interface Client extends Subject
{
  void start() throws IOException;
void createAccount(String name, String password, String email);

void changeEmail(Account acc, String email);

void recoverPassword(String email);
void createGroup(Account acc, String groupName);

 void  checkEmailChangeInformation(Account acc, String email);
 void checkPasswordChangeInformation(Account acc, String newPassword, String oldPassword);
 void checkEmail(String email);
void checkLogin(String username, String password);
void checkAccountUniqueness(String username, String password, String email);
void joinGroupAsAPlayer(Account acc,String groupname);
void searchGroup(int id, String user);
void removeUser(Account ac);
}
