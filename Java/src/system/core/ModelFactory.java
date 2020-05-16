package system.core;


import system.model.characterCreation.CharacterCreationModel;
import system.model.characterSheet.CharacterSheetModel;
import system.model.loginModel.AccountModel;
import system.model.loginModel.AccountModelImpl;

public class ModelFactory
{
  private AccountModel model;
  private ClientFactory cf;

private CharacterCreationModel characterCreationModel;
private CharacterSheetModel characterSheetModel;
  public ModelFactory(ClientFactory c)
  {
    cf = c;

  }

  public AccountModel getAccountModel()
  {
    if (model == null)
    {
      model = new AccountModelImpl(cf.getClient());
    }
    return model;
  }

}
