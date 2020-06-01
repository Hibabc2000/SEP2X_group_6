package system.model.loginModel;

import system.transferobjects.login.Group;
import system.util.Subject;

import java.util.ArrayList;

public interface DMAccountModel extends Subject
{
  ArrayList<Group> getGroups();
  String createGroup(String value);
  void startGame(String group);
}
