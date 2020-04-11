package login.model;

import login.AccountModel;
import login.AccountModelImpl;

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
