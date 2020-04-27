package login.model;

import login.views.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene login;
private Scene createAccount;
private Scene account;
private Scene accountPlayer;
private Scene accountDM;
private Scene openSystem;
private Scene passwordRecovery;
private Scene passwordChange;
private Scene emailChange;
private Stage stage;
private ViewModelFactory vmd;
private  Stage stage2;
private Stage stage3;
private Stage stage4;

  public ViewHandler(ViewModelFactory vmf)
  {
    vmd = vmf;
    stage = new Stage();
    stage2 = new Stage();
    stage3 = new Stage();
    stage4 = new Stage();

  }

  public void start()
  {
    openSystem();
  }

  public void openSystem()
  {
    FXMLLoader loader = new FXMLLoader();
    if(openSystem==null)
    {
      Parent root = getRootByPath("../views/OpenSystem.fxml",loader);
      OpenSystemController osc = loader.getController();
      osc.init(vmd.getOSVM(),this);
      openSystem = new Scene(root);


    }

stage.setTitle("DnDAS");
stage.setScene(openSystem);
stage.show();
  }
  public void openLogin()
  {
    FXMLLoader loader = new FXMLLoader();
    if(login==null)
    {
      Parent root = getRootByPath("../views/Login.fxml",loader);
      LoginController lc = loader.getController();
      lc.init(vmd.getLoginVM(),this);
      login = new Scene(root);


    }

    stage.setTitle("DnDAS");
    stage.setScene(login);
    stage.show();
  }
  public void openAccount()
  {
    FXMLLoader loader = new FXMLLoader();
    if(account==null)
    {
      Parent root = getRootByPath("../views/Account.fxml",loader);
      AccountController ac = loader.getController();
      ac.init(vmd.getAccountVM(),this);
      account = new Scene(root);


    }

    stage.setTitle("DnDAS");
    stage.setScene(account);
    stage.show();
  }
  public void openAccountPlayer()
  {
    FXMLLoader loader = new FXMLLoader();
    if(accountPlayer==null)
    {
      Parent root = getRootByPath("../views/PlayerAccount.fxml",loader);
      PlayerAccountController pac = loader.getController();
      pac.init(vmd.getPAVM(),this);
      accountPlayer = new Scene(root);


    }

    stage.setTitle("DnDAS");
    stage.setScene(accountPlayer);
    stage.show();
  }
  public void openAccountDM()
  {
    FXMLLoader loader = new FXMLLoader();
    if(accountDM==null)
    {
      Parent root = getRootByPath("../views/DMAccount.fxml",loader);
      DMAccountController dmac = loader.getController();
      dmac.init(vmd.getDMAVM(),this);
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
  public void closeStage3() {stage3.close();}
  public void closeStage4() {stage4.close(); }
  public void openCreateAccount()
  {
    FXMLLoader loader = new FXMLLoader();
    if(createAccount==null)
    {
      Parent root = getRootByPath("../views/CreateAccount.fxml",loader);
      CreateAccountController cac = loader.getController();
      cac.init(vmd.getCreateAccountVM(),this);
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
      Parent root = getRootByPath("../views/PasswordRecovery.fxml",
          loader);
      PasswordRecoveryController controller = loader.getController();
      controller.init(vmd.getPasswordRecoveryVM(),this);
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
      Parent root = getRootByPath("../views/ChangePassword.fxml",
          loader);
      ChangePasswordController controller = loader.getController();
      controller.init(vmd.getCPVM(),this);
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
      Parent root = getRootByPath("../views/ChangeEmail.fxml",
          loader);
      ChangeEmailController controller = loader.getController();
      controller.init(vmd.getCEVM(),this);
      emailChange= new Scene(root);
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
