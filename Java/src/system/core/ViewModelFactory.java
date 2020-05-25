package system.core;

import system.views.characterCreation.CharacterCreationViewModel;
import system.views.characterSheet.CharacterSheetViewModel;
import system.views.dmCharacterSheetChoosing.DMCharacterSheetChoosingViewModel;
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
  private DMCharacterSheetChoosingViewModel dmcscv;

  //  characterSheet
  private CharacterSheetViewModel characterSheetViewModel;

  //  characterCreation
  private CharacterCreationViewModel characterCreationViewModel;

  /**
   * Initializes the class attributes(not all)
   *
   * @param mf model factory
   */
  public ViewModelFactory(ModelFactory mf)
  {
    model = mf;
    createAccountModel = new CreateAccountViewModel(model.getAccountModel());

    openSystemViewModel = new OpenSystemViewModel(model.getAccountModel());
    passwordRecoveryViewModel = new PasswordRecoveryViewModel(
        model.getAccountModel());
    dmAccountViewModel = new DMAccountViewModel(model.getAccountModel());
    playerAccountViewModel = new PlayerAccountViewModel(
        model.getAccountModel());
    changePasswordViewModel = new ChangePasswordViewModel(
        model.getAccountModel());
    changeEmailViewModel = new ChangeEmailViewModel(model.getAccountModel());
    dmcscv = new DMCharacterSheetChoosingViewModel(model.getAccountModel());

  }

  /**
   * Lazy instantiation of the AccountViewModel
   *
   * @return an instance of the AccountViewModel
   */
  public AccountViewModel getAccountVM()
  {
    if (accountModel == null)
    {
      accountModel = new AccountViewModel(model.getAccountModel());
    }
    return accountModel;
  }
  public DMCharacterSheetChoosingViewModel getDMStartGameVM()
  {
    if (dmcscv == null)
    {
      dmcscv = new DMCharacterSheetChoosingViewModel(model.getAccountModel());
    }
    return dmcscv;
  }

  /**
   * Gets the ChangeEmailViewModel object
   *
   * @return ChangeEmailViewModel object
   */
  public ChangeEmailViewModel getChangeEmailVM()
  {
    return changeEmailViewModel;
  }

  /**
   * Gets the CreateAccountViewModel object
   *
   * @return CreateAccountViewModel object
   */
  public CreateAccountViewModel getCreateAccountVM()
  {
    return createAccountModel;
  }

  /**
   * Gets the OpenSystemViewModel object
   *
   * @return OpenSystemViewModel object
   */
  public OpenSystemViewModel getOpenSystemViewModel()
  {
    return openSystemViewModel;
  }

  /**
   * Gets the PasswordRecoveryViewModel object
   *
   * @return PasswordRecoveryViewModel object
   */
  public PasswordRecoveryViewModel getPasswordRecoveryVM()
  {
    return passwordRecoveryViewModel;
  }

  /**
   * Gets the DMAccountViewModel object
   *
   * @return DMAccountViewModel object
   */
  public DMAccountViewModel getDMAccountViewModel()
  {
    return dmAccountViewModel;
  }

  /**
   * Gets the PlayerAccountViewModel object
   *
   * @return PlayerAccountViewModel object
   */
  public PlayerAccountViewModel getPlayerAccountViewModel()
  {
    return playerAccountViewModel;
  }

  /**
   * Gets the ChangePasswordViewModel object
   *
   * @return ChangePasswordViewModel object
   */
  public ChangePasswordViewModel getChangePasswordViewModel()
  {
    return changePasswordViewModel;
  }

}
