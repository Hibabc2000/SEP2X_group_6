package login.model;

import login.views.*;

public class ViewModelFactory
{
  private ModelFactory model;
  private AccountViewModel accountModel;
  private CreateAccountViewModel createAccountModel;
  private LoginViewModel loginModel;
  private OpenSystemViewModel opsmodel;
  private PasswordRecoveryViewModel prmodel;
  private DMAccountViewModel dmavm;
  private PlayerAccountViewModel pavm;
  private ChangePasswordViewModel cpvm;
  private ChangeEmailViewModel cevm;

  public ViewModelFactory(ModelFactory mf)
  {
    model = mf;
    accountModel = new AccountViewModel(model.getAccountModel());
    createAccountModel = new CreateAccountViewModel(model.getAccountModel());
    loginModel = new LoginViewModel(model.getAccountModel());
    opsmodel = new OpenSystemViewModel(model.getAccountModel());
    prmodel = new PasswordRecoveryViewModel(model.getAccountModel());
    dmavm= new DMAccountViewModel(model.getAccountModel());
    pavm= new PlayerAccountViewModel(model.getAccountModel());
    cpvm = new ChangePasswordViewModel(model.getAccountModel());
    cevm = new ChangeEmailViewModel(model.getAccountModel());
  }

  public AccountViewModel getAccountVM()
  {
    return accountModel;
  }
  public ChangeEmailViewModel getCEVM(){return cevm;}
  public CreateAccountViewModel getCreateAccountVM()
  {
    return createAccountModel;
  }
  public LoginViewModel getLoginVM()
  {
    return loginModel;
  }
  public OpenSystemViewModel getOSVM()
  {
    return opsmodel;
  }
  public PasswordRecoveryViewModel getPasswordRecoveryVM()
  {
    return prmodel;
  }
  public DMAccountViewModel getDMAVM()
  {
    return dmavm;
  }
  public PlayerAccountViewModel getPAVM()
  {
    return pavm;
  }
  public ChangePasswordViewModel getCPVM()
  {
    return cpvm;
  }

}
