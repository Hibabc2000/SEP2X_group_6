package system.core;


import system.model.loginModel.AccountModel;
import system.model.loginModel.AccountModelImpl;

public class ModelFactory
{
  private AccountModel accountModel;
  private ClientFactory clientFactory;

  /**
   * Initializes the class attributes
   * @param clientFactory client factory
   */
  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }
  /**
   * Created a new instance of the AccountModelImpl or the returns the existing one
   * @return instance of the AccountModelImpl
   */
  public AccountModel getAccountModel()
  {
    if (accountModel == null)
    {
      accountModel = new AccountModelImpl(clientFactory.getClient());
    }
    return accountModel;
  }
}
