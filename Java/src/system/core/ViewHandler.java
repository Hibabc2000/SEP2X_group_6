package system.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import system.views.login.account.AccountController;
import system.views.login.changeEmail.ChangeEmailController;
import system.views.login.changePassword.ChangePasswordController;
import system.views.login.createAccount.CreateAccountController;
import system.views.login.dmAccount.DMAccountController;
import system.views.login.openSystem.OpenSystemController;
import system.views.login.passwordRecovery.PasswordRecoveryController;
import system.views.login.playerAccount.PlayerAccountController;

import java.io.IOException;

public class ViewHandler
{
  private ViewModelFactory vmf;
  private Scene login;
  private Scene createAccount;
  private Scene account;
  private Scene accountPlayer;
  private Scene accountDM;
  private Scene openSystem;
  private Scene passwordRecovery;
  private Scene passwordChange;
  private Scene emailChange;
  private Scene characterSheet;
  private Stage stage;

  private Stage stage2;
  private Stage stage3;
  private Stage stage4;

  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
    stage = new Stage();
    stage2 = new Stage();
    stage3 = new Stage();
    stage4 = new Stage();

  }

  public void start()
  {
    openSystem();
  }
// 1* LOGIN VIEWS
  public void openSystem()
  {
    FXMLLoader loader = new FXMLLoader();
    if (openSystem == null)
    {
      Parent root = getRootByPath("../views/login/openSystem/OpenSystem.fxml",
          loader);
      OpenSystemController osc = loader.getController();
      osc.init(vmf.getOpenSystemViewModel(), this);
      openSystem = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(openSystem);
    stage.show();
  }

  public void openAccount()
  {
    FXMLLoader loader = new FXMLLoader();
    if (account == null)
    {
      Parent root = getRootByPath("../views/login/account/Account.fxml", loader);
      AccountController ac = loader.getController();
      ac.init(vmf.getAccountVM(), this);
      account = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(account);
    stage.show();
  }

  public void openAccountPlayer()
  {
    FXMLLoader loader = new FXMLLoader();
    if (accountPlayer == null)
    {
      Parent root = getRootByPath("../views/login/playerAccount/PlayerAccount.fxml", loader);
      PlayerAccountController pac = loader.getController();
      pac.init(vmf.getPlayerAccountViewModel(), this);
      accountPlayer = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(accountPlayer);
    stage.show();
  }

  public void openAccountDM()
  {
    FXMLLoader loader = new FXMLLoader();
    if (accountDM == null)
    {
      Parent root = getRootByPath("../views/login/dmAccount/DMAccount.fxml", loader);
      DMAccountController dmac = loader.getController();
      dmac.init(vmf.getDMAccountViewModel(), this);
      accountDM = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(accountDM);
    stage.show();
  }

  public void closeStage2()
  {
    stage2.close();
  }

  public void closeStage3()
  {
    stage3.close();
  }

  public void closeStage4()
  {
    stage4.close();
  }

  public void openCreateAccount()
  {
    FXMLLoader loader = new FXMLLoader();
    if (createAccount == null)
    {
      Parent root = getRootByPath("../views/login/createAccount/CreateAccount.fxml", loader);
      CreateAccountController cac = loader.getController();
      cac.init(vmf.getCreateAccountVM(), this);
      createAccount = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(createAccount);
    stage.show();
  }

  public void openPasswordRecovery()
  {

    FXMLLoader loader = new FXMLLoader();
    if (passwordRecovery == null)
    {
      Parent root = getRootByPath("../views/login/passwordRecovery/PasswordRecovery.fxml", loader);
      PasswordRecoveryController controller = loader.getController();
      controller.init(vmf.getPasswordRecoveryVM(), this);
      passwordRecovery = new Scene(root);
    }
    stage2.setTitle("DnDAS");
    stage2.setScene(passwordRecovery);
    stage2.show();
  }

  public void openChangePassword()
  {

    FXMLLoader loader = new FXMLLoader();
    if (passwordChange == null)
    {
      Parent root = getRootByPath("../views/login/changePassword/ChangePassword.fxml", loader);
      ChangePasswordController controller = loader.getController();
      controller.init(vmf.getChangePasswordViewModel(), this);
      passwordChange = new Scene(root);
    }
    stage3.setTitle("DnDAS");
    stage3.setScene(passwordChange);
    stage3.show();
  }

  public void openChangeEmail()
  {

    FXMLLoader loader = new FXMLLoader();
    if (emailChange == null)
    {
      Parent root = getRootByPath("../views/login/changeEmail/ChangeEmail.fxml", loader);
      ChangeEmailController controller = loader.getController();
      controller.init(vmf.getChangeEmailVM(), this);
      emailChange = new Scene(root);
    }
    stage4.setTitle("DnDAS");
    stage4.setScene(emailChange);
    stage4.show();
  }
//  1** END LOGIN VIEWS

//  CharacterSheet
public void openCharacterSheet()
{

  FXMLLoader loader = new FXMLLoader();
  if (emailChange == null)
  {
    Parent root = getRootByPath("../views/characterSheet/ChangeEmail.fxml", loader);
    ChangeEmailController controller = loader.getController();
    controller.init(vmf.getChangeEmailVM(), this);
    emailChange = new Scene(root);
  }
  stage4.setTitle("DnDAS");
  stage4.setScene(emailChange);
  stage4.show();
}

  private Parent getRootByPath(String path, FXMLLoader loader)
  {
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return root;
  }

}
