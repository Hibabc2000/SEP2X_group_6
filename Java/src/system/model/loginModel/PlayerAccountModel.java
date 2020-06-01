package system.model.loginModel;

import system.transferobjects.login.Group;
import system.util.Subject;

import java.util.ArrayList;

public interface PlayerAccountModel extends Subject
{

  ArrayList<Group> getGroups();

  String searchGroup(int temp);
  String joinGroupAsPlayer(String groupname);
}
