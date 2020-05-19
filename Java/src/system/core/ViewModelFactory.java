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

  private OpenSystemViewModel openSystemViewModel;
  private PasswordRecoveryViewModel passwordRecoveryViewModel;
  private DMAccountViewModel dmAccountViewModel;
  private PlayerAccountViewModel playerAccountViewModel;
  private ChangePasswordViewModel changePasswordViewModel;
  private ChangeEmailViewModel changeEmailViewModel;

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

    openSystemViewModel = new OpenSystemViewModel(model.getAccountModel());
    passwordRecoveryViewModel = new PasswordRecoveryViewModel(model.getAccountModel());
    dmAccountViewModel = new DMAccountViewModel(model.getAccountModel());
    playerAccountViewModel = new PlayerAccountViewModel(model.getAccountModel());
    changePasswordViewModel = new ChangePasswordViewModel(model.getAccountModel());
    changeEmailViewModel = new ChangeEmailViewModel(model.getAccountModel());


  }

  public AccountViewModel getAccountVM()
  {
    return accountModel;
  }
  public ChangeEmailViewModel getChangeEmailVM(){return changeEmailViewModel;}
  public CreateAccountViewModel getCreateAccountVM()
  {
    return createAccountModel;
  }

  public OpenSystemViewModel getOpenSystemViewModel()
  {
    return openSystemViewModel;
  }
  public PasswordRecoveryViewModel getPasswordRecoveryVM()
  {
    return passwordRecoveryViewModel;
  }
  public DMAccountViewModel getDMAccountViewModel()
  {
    return dmAccountViewModel;
  }
  public PlayerAccountViewModel getPlayerAccountViewModel()
  {
    return playerAccountViewModel;
  }
  public ChangePasswordViewModel getChangePasswordViewModel()
  {
    return changePasswordViewModel;
  }

}
