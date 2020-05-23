package system.views.login.account;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

public class AccountController
{
  public Label usernameField;
  private ViewHandler vh;
  private AccountViewModel accountViewModel;
  @FXML private TextField addGroup;
  @FXML private ListView groupListPlayer;
  @FXML private ListView groupListDM;
  @FXML private Label errorMessagePlayer;
  @FXML private Label errorMessageDM;
  @FXML private TextField groupName;

  /**
   * Initializes the class attributes, binds the fxml fields to view model properties.
   * @param accountVM view model
   * @param viewHandler used for changing the views
   */
  public void init(AccountViewModel accountVM, ViewHandler viewHandler)
  {
    usernameField.textProperty()
        .bind(accountVM.userNameFieldProperty());
    accountViewModel = accountVM;
    vh=viewHandler;
  }

  /**
   * Closes the program
   */
  public void logout()
  {

    System.exit(1);  //I wanted to make it so it goes back to the login screen, but then if I login back with a different account
                           //information about groups and etc. stay the same... Somehow I need to reset everything, almost everything, i not sure how to do it efficiently
  }

  /**
   * Opens change password view
   */
  public void changePassword()
  {
    vh.openChangePassword();
  }

  /**
   * Sends a request to the view model in order to switch to DM and opens the account dm view
   */
  public void changeToDM()
  {
    accountViewModel.changeToDm();
    vh.openAccountDM();
  }

  /**
   * Sends a request to the view model in order to switch to the player and opens the player view
   */
  public void changeToPlayer()
  {
    accountViewModel.changeToPlayer();
    vh.openAccountPlayer();
  }

  /**
   * Opens the change email view
   */
  public void changeEmail()
  {
    vh.openChangeEmail();
  }
}
