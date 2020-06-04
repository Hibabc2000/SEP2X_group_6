package system.core;

import system.views.characterCreation.CharacterCreationViewModel;
import system.views.characterSheet.CharacterSheetViewModel;
import system.views.characterSheet.infoPopup.InfoPopupViewModel;
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
  private InfoPopupViewModel infoPopupViewModel;

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
    createAccountModel = new CreateAccountViewModel(model.getCreateAccountModel());

    openSystemViewModel = new OpenSystemViewModel(model.getOpenSystemModel());
    passwordRecoveryViewModel = new PasswordRecoveryViewModel(
        model.getPasswordRecoveryModel());
    dmAccountViewModel = new DMAccountViewModel(model.getDmAccountModel());
    playerAccountViewModel = new PlayerAccountViewModel(
        model.getPlayerAccountModel());
    changePasswordViewModel = new ChangePasswordViewModel(
        model.getChangePasswordModel());
    changeEmailViewModel = new ChangeEmailViewModel(model.getChangeEmailModel());
    dmcscv = new DMCharacterSheetChoosingViewModel(model.getCharacterManagementModel());


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
      dmcscv = new DMCharacterSheetChoosingViewModel(model.getCharacterManagementModel());
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
    if (changeEmailViewModel == null)
    {
     changeEmailViewModel = new ChangeEmailViewModel(model.getChangeEmailModel());
    }
    return changeEmailViewModel;
  }

  /**
   * Gets the CreateAccountViewModel object
   *
   * @return CreateAccountViewModel object
   */
  public CreateAccountViewModel getCreateAccountVM()
  {
    if (createAccountModel == null)
    {
      createAccountModel = new CreateAccountViewModel(model.getCreateAccountModel());
    }
    return createAccountModel;
  }

  /**
   * Gets the OpenSystemViewModel object
   *
   * @return OpenSystemViewModel object
   */
  public OpenSystemViewModel getOpenSystemViewModel()
  {
    if (openSystemViewModel == null)
    {
      openSystemViewModel = new OpenSystemViewModel(model.getOpenSystemModel());
    }
    return openSystemViewModel;
  }

  /**
   * Gets the PasswordRecoveryViewModel object
   *
   * @return PasswordRecoveryViewModel object
   */
  public PasswordRecoveryViewModel getPasswordRecoveryVM()
  {
    if (passwordRecoveryViewModel == null)
    {
      passwordRecoveryViewModel= new PasswordRecoveryViewModel(model.getPasswordRecoveryModel());
    }
    return passwordRecoveryViewModel;
  }

  /**
   * Gets the DMAccountViewModel object
   *
   * @return DMAccountViewModel object
   */
  public DMAccountViewModel getDMAccountViewModel()
  {
    if (dmAccountViewModel == null)
    {
      dmAccountViewModel = new DMAccountViewModel(model.getDmAccountModel());
    }
    return dmAccountViewModel;
  }

  /**
   * Gets the PlayerAccountViewModel object
   *
   * @return PlayerAccountViewModel object
   */
  public PlayerAccountViewModel getPlayerAccountViewModel()
  {
    if (playerAccountViewModel == null)
    {
      playerAccountViewModel= new PlayerAccountViewModel(model.getPlayerAccountModel());
    }
    return playerAccountViewModel;
  }

  /**
   * Gets the ChangePasswordViewModel object
   *
   * @return ChangePasswordViewModel object
   */
  public ChangePasswordViewModel getChangePasswordViewModel()
  {
    if (changePasswordViewModel == null)
    {
      changePasswordViewModel = new ChangePasswordViewModel(model.getChangePasswordModel());
    }
    return changePasswordViewModel;
  }
  //bruh
  public ModelFactory getModel()
  {
    return model;
  }

  public CharacterCreationViewModel getCharacterCreationViewModel()
  {
    if(characterCreationViewModel == null)
    {
      characterCreationViewModel = new CharacterCreationViewModel(model.getCharacterManagementModel());
    }
    return characterCreationViewModel;
  }
}
