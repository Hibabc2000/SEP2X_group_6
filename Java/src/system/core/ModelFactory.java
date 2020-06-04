package system.core;

import system.model.characterManagement.CharacterManagementModelImpl;
import system.model.loginModel.*;

public class ModelFactory
{
  private AccountModel accountModel;
  private ChangeEmailModel changeEmailModel;
  private ChangePasswordModel changePasswordModel;
  private CreateAccountModel createAccountModel;
  private DMAccountModel dmAccountModel;
  private OpenSystemModel openSystemModel;
  private PasswordRecoveryModel passwordRecoveryModel;
  private PlayerAccountModel playerAccountModel;
  private ClientFactory clientFactory;
  private CharacterManagementModelImpl characterManagementModel;
  private AccountModelImpl accountModelImpl;
  /**
   * Initializes the class attributes
   *
   * @param clientFactory client factory
   */
  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
    accountModelImpl=new AccountModelImpl(clientFactory.getClient());
  }

  /**
   * Created a new instance of the AccountModelImpl or the returns the existing one
   *
   * @return instance of the AccountModelImpl
   */
  public AccountModel getAccountModel()
  {
    if (accountModel == null)
    {
      accountModel = accountModelImpl;
    }
    return accountModel;
  }
  /**
   * Created a new instance of the ChangeEmailModel or the returns the existing one
   *
   * @return instance of the ChangeEmailModel
   */
  public ChangeEmailModel getChangeEmailModel()
  {
    if (changeEmailModel == null)
    {
      changeEmailModel =accountModelImpl;
    }
    return changeEmailModel;
  }
  /**
   * Created a new instance of the ChangePasswordModel or the returns the existing one
   *
   * @return instance of the ChangePasswordModel
   */
  public ChangePasswordModel getChangePasswordModel()
  {
    if (changePasswordModel == null)
    {
      changePasswordModel = accountModelImpl;
    }
    return changePasswordModel;
  }
  /**
   * Created a new instance of the CreateAccountModel or the returns the existing one
   *
   * @return instance of the CreateAccountModel
   */
  public CreateAccountModel getCreateAccountModel()
  {
    if (createAccountModel == null)
    {
      createAccountModel = accountModelImpl;
    }
    return createAccountModel;
  }
  /**
   * Created a new instance of the DMAccountModel or the returns the existing one
   *
   * @return instance of the DMAccountModel
   */
  public DMAccountModel getDmAccountModel()
  {
    if (dmAccountModel == null)
    {
      dmAccountModel =accountModelImpl;
    }
    return dmAccountModel;
  }
  /**
   * Created a new instance of the OpenSystemModel or the returns the existing one
   *
   * @return instance of the OpenSystemModel
   */
  public OpenSystemModel getOpenSystemModel()
  {
    if (openSystemModel == null)
    {
      openSystemModel = accountModelImpl;
    }
    return openSystemModel;
  }
  /**
   * Created a new instance of the PasswordRecoveryModel or the returns the existing one
   *
   * @return instance of the PasswordRecoveryModel
   */
  public PasswordRecoveryModel getPasswordRecoveryModel()
  {
    if (passwordRecoveryModel == null)
    {
      passwordRecoveryModel =accountModelImpl;
    }
    return passwordRecoveryModel;
  }
  /**
   * Created a new instance of the PlayerAccountModel or the returns the existing one
   *
   * @return instance of the PlayerAccountModel
   */
  public PlayerAccountModel getPlayerAccountModel()
  {
    if (playerAccountModel == null)
    {
      playerAccountModel = accountModelImpl;
    }
    return playerAccountModel;
  }
  /**
   * Created a new instance of the CharacterManagementModelImpl or the returns the existing one
   *
   * @return instance of the CharacterManagementModelImpl
   */
  public CharacterManagementModelImpl getCharacterManagementModel()
  {
    if (characterManagementModel == null)
    {
      characterManagementModel = new CharacterManagementModelImpl(
          clientFactory.getClient());
    }
    return characterManagementModel;
  }
}
