package system.core;

import system.model.loginModel.AccountModel;
import system.model.loginModel.AccountModelImpl;

public class ModelFactory
{
private AccountModel model;

public ModelFactory()
{

}
 public AccountModel getAccountModel()
 {
if(model==null)
{
model = new AccountModelImpl();
}
 return model;
 }

}
