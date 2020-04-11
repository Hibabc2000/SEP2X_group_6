package login.views;

import login.AccountModel;

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

  public void removeAccount()
  {
    model.removeAccount();
  }
}
