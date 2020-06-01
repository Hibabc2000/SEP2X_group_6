package system.model.loginModel;

import system.util.Subject;

public interface CreateAccountModel extends Subject
{
  String checkAccountUniqueness(String value, String value1, String value2, String value3);

}
