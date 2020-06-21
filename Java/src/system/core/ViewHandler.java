package system.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import system.model.businessModel.Character;
import system.views.characterCreation.CharacterCreationController;
import system.views.characterSheet.CharacterSheetController;
import system.views.characterSheet.infoPopup.InfoPopupController;
import system.views.dmCharacterSheetChoosing.DmCharacterChoosingPageController;
import system.views.login.account.AccountController;
import system.views.login.changeEmail.ChangeEmailController;
import system.views.login.changePassword.ChangePasswordController;
import system.views.login.createAccount.CreateAccountController;
import system.views.login.dmAccount.DMAccountController;
import system.views.login.openSystem.OpenSystemController;
import system.views.login.passwordRecovery.PasswordRecoveryController;
import system.views.login.playerAccount.PlayerAccountController;

import java.beans.PropertyChangeEvent;
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
  private Scene characterCreation;
  private Scene dmStartGamePage;
  private Scene popupScene;

  private Stage stage;

  private Stage stage2;
  private Stage stage3;
  private Stage stage4;
  private Stage characterSheetStage;

  /**
   * Initializes the stages
   *
   * @param vmf view model factory
   */
  public ViewHandler(ViewModelFactory vmf)
  {
    this.vmf = vmf;
    stage = new Stage();
    stage2 = new Stage();
    stage3 = new Stage();
    stage4 = new Stage();
    characterSheetStage=new Stage();
    //bruh
     vmf.getModel().getCharacterManagementModel().addListener("openTheCreation",this::openCharacterCreation);

  }

  /**
   * Opens the openSystem view
   */
  public void start()
  {
openSystem();
  }
  // 1* LOGIN VIEWS

  /**
   * If the scene(openSystem) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
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

  /**
   * If the scene(openAccount) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openAccount()
  {
    FXMLLoader loader = new FXMLLoader();
    if (account == null)
    {
      Parent root = getRootByPath("../views/login/account/Account.fxml",
          loader);
      AccountController ac = loader.getController();
      ac.init(vmf.getAccountVM(), this);
      account = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(account);
    stage.show();
  }

  /**
   * If the scene(openAccountPlayer) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openAccountPlayer()
  {
    FXMLLoader loader = new FXMLLoader();
    if (accountPlayer == null)
    {
      Parent root = getRootByPath(
          "../views/login/playerAccount/PlayerAccount.fxml", loader);
      PlayerAccountController pac = loader.getController();
      pac.init(vmf.getPlayerAccountViewModel(), this);
      accountPlayer = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(accountPlayer);
    stage.show();
  }

  /**
   * If the scene(openAccountDM) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openAccountDM()
  {
    FXMLLoader loader = new FXMLLoader();
    if (accountDM == null)
    {
      Parent root = getRootByPath("../views/login/dmAccount/DMAccount.fxml",
          loader);
      DMAccountController dmac = loader.getController();
      dmac.init(vmf.getDMAccountViewModel(), this);
      accountDM = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(accountDM);
    stage.show();
  }

  /**
   * Closes the stage
   */
  public void closeStage2()
  {
    stage2.close();
  }

  /**
   * Closes the stage
   */
  public void closeStage3()
  {
    stage3.close();
  }

  /**
   * Closes the stage
   */
  public void closeStage4()
  {
    stage4.close();
  }

  /**
   * If the scene(openCreateAccount) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openCreateAccount()
  {
    FXMLLoader loader = new FXMLLoader();
    if (createAccount == null)
    {
      Parent root = getRootByPath(
          "../views/login/createAccount/CreateAccount.fxml", loader);
      CreateAccountController cac = loader.getController();
      cac.init(vmf.getCreateAccountVM(), this);
      createAccount = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(createAccount);
    stage.show();
  }

  public void openDMCharacterChoosingPage()
  {
    FXMLLoader loader = new FXMLLoader();
    if (dmStartGamePage == null)
    {
      Parent root = getRootByPath(
          "../views/dmCharacterSheetChoosing/dmCharacterChoosingPage.fxml", loader);
      DmCharacterChoosingPageController dccpc = loader.getController();
      dccpc.init(vmf.getDMStartGameVM(), this);
      dmStartGamePage = new Scene(root);

    }

    stage.setTitle("DnDAS");
    stage.setScene(dmStartGamePage);
    stage.show();
  }

  public void openInfoPopupWindow(String popupInfo)
  {
    FXMLLoader loader = new FXMLLoader();
    if (popupScene == null)
    {
      Parent root = getRootByPath(
          "../views/characterSheet/infoPopup/infoPopup.fxml", loader);
      InfoPopupController infoPopupController = loader.getController();
     infoPopupController.init(vmf.getInfoPopupViewModel(), popupInfo);
      popupScene = new Scene(root);

    }

    stage2.setTitle("Info");
    stage2.setScene(popupScene);
    stage2.show();
  }


  /**
   * If the scene(openPasswordRecovery) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openPasswordRecovery()
  {

    FXMLLoader loader = new FXMLLoader();
    if (passwordRecovery == null)
    {
      Parent root = getRootByPath(
          "../views/login/passwordRecovery/PasswordRecovery.fxml", loader);
      PasswordRecoveryController controller = loader.getController();
      controller.init(vmf.getPasswordRecoveryVM(), this);
      passwordRecovery = new Scene(root);
    }
    stage2.setTitle("DnDAS");
    stage2.setScene(passwordRecovery);
    stage2.show();
  }

  /**
   * If the scene(openChangePassword) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openChangePassword()
  {

    FXMLLoader loader = new FXMLLoader();
    if (passwordChange == null)
    {
      Parent root = getRootByPath(
          "../views/login/changePassword/ChangePassword.fxml", loader);
      ChangePasswordController controller = loader.getController();
      controller.init(vmf.getChangePasswordViewModel(), this);
      passwordChange = new Scene(root);
    }
    stage3.setTitle("DnDAS");
    stage3.setScene(passwordChange);
    stage3.show();
  }

  /**
   * If the scene(openChangeEmail) is null, the method will find the FXML file by the given root
   * using the method getRootByPath(), an object hierarchy from an XML document will be loaded(FXML controller)
   * and the init method will be called on that object.
   * Otherwise the method will return the already created scene.
   * A title and the scene will be assigned to the stage.
   */
  public void openChangeEmail()
  {

    FXMLLoader loader = new FXMLLoader();
    if (emailChange == null)
    {
      Parent root = getRootByPath("../views/login/changeEmail/ChangeEmail.fxml",
          loader);
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
    //METHOD NOT WORKING
    FXMLLoader loader = new FXMLLoader();
    if (characterSheet == null)
    {
      Parent root = getRootByPath("../views/characterSheet/CharacterSheet.fxml",
          loader);
      CharacterSheetController controller = loader.getController();
      controller.init(vmf.getCharacterSheetViewModel(), this);
      characterSheet = new Scene(root);
    }
    characterSheetStage.setTitle("DnDAS");
    characterSheetStage.setScene(characterSheet);
    characterSheetStage.show();
  }
 /* public void openCharacterCreation()
  {
    FXMLLoader loader = new FXMLLoader();
    if (characterCreation == null)
    {
      Parent root = getRootByPath("../views/characterCreation/CharacterCreation.fxml",
          loader);
      CharacterCreationController controller = loader.getController();
      controller.init(vmf.getCharacterCreationViewModel(), this);
      characterCreation = new Scene(root);
    }
    stage.setTitle("DnDAS");
    stage.setScene(characterCreation);
    stage.show();
  }

  */
  public void openCharacterCreation(PropertyChangeEvent propertyChangeEvent)
  {
    FXMLLoader loader = new FXMLLoader();
    if (characterCreation == null)
    {
      Parent root = getRootByPath("../views/characterCreation/CharacterCreation.fxml",
          loader);
      CharacterCreationController controller = loader.getController();
      controller.init(vmf.getCharacterCreationViewModel(), this, (Character)propertyChangeEvent.getNewValue());
      characterCreation = new Scene(root);
    }

    stage.setTitle("DnDAS");
    stage.setScene(characterCreation);
    stage.show();
  }

  /**
   * Returns the root of the object hierarchy.
   *
   * @param path   path to the object
   * @param loader
   * @return root of the object hierarchy
   */
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
