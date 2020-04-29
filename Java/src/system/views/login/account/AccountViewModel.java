package system.views.login.account;

import system.model.loginModel.AccountModel;

public class AccountViewModel
{
  private AccountModel model;

  public AccountViewModel(AccountModel accountModel)
  {
    model = accountModel;
  }

  public void changeToDm()
  {
    model.changeToDm();
  }

  public void changeToPlayer()
  {model.changeToPlayer();
  }
// need to discuss this.
  public void removeAccount()
  {
    model.removeAccount();
  }
}
