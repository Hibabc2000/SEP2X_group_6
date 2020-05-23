package system.core;


import system.model.characterCreation.CharacterCreationModel;
import system.model.characterSheet.CharacterSheetModel;
import system.model.loginModel.AccountModel;
import system.model.loginModel.AccountModelImpl;

public class ModelFactory
{
  private AccountModel accountModel;
  private ClientFactory clientFactory;

private CharacterCreationModel characterCreationModel;
private CharacterSheetModel characterSheetModel;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;

  }

  public AccountModel getAccountModel()
  {
    if (accountModel == null)
    {
      accountModel = new AccountModelImpl(clientFactory.getClient());
    }
    return accountModel;
  }

}
