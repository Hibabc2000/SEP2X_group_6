package system.model.loginModel;

import system.util.Subject;

public interface ChangeEmailModel extends Subject
{
  String checkEmailChangeInformation(String value, String value1, String value2);
}
