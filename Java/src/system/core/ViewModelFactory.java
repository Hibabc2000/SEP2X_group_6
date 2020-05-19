package system.core;

import system.model.characterCreation.CharacterCreationModel;
import system.model.characterSheet.CharacterSheetModel;
import system.views.characterCreation.CharacterCreationViewModel;
import system.views.characterSheet.CharacterSheetViewModel;
import system.views.login.account.AccountViewModel;
import system.views.login.changeEmail.ChangeEmailViewModel;
import system.views.login.changePassword.ChangePasswordViewModel;
import system.views.login.createAccount.CreateAccountViewModel;
import system.views.login.dmAccount.DMAccountViewModel;

import system.views.login.openSystem.OpenSystemViewModel;
import system.views.login.passwordRecovery.PasswordRecoveryViewModel;
import system.views.login.playerAccount.PlayerAccountViewModel;

public class ViewModelFactory
{
//  LOGIN
  private ModelFactory model;
  private AccountViewModel accountModel;
  private CreateAccountViewModel createAccountModel;

  private OpenSystemViewModel opsmodel;
  private PasswordRecoveryViewModel prmodel;
  private DMAccountViewModel dmavm;
  private PlayerAccountViewModel pavm;
  private ChangePasswordViewModel cpvm;
  private ChangeEmailViewModel cevm;

//  characterSheet
  private CharacterSheetViewModel characterSheetViewModel;
  private CharacterSheetModel characterSheetModel;
//  characterCreation
  private CharacterCreationViewModel characterCreationViewModel;
  private CharacterCreationModel characterCreationModel;

  public ViewModelFactory(ModelFactory mf)
  {
    model = mf;
    accountModel = new AccountViewModel(model.getAccountModel());
    createAccountModel = new CreateAccountViewModel(model.getAccountModel());

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
