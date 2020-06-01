package system.model.loginModel;

import system.util.Subject;

public interface PasswordRecoveryModel extends Subject
{
  String checkEmail(String value);

}
