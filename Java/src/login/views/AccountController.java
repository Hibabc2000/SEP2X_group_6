package login.views;

import login.model.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AccountController
{
  private ViewHandler vh;
  private AccountViewModel avm;
  @FXML private TextField addGroup;
  @FXML private ListView groupListPlayer;
  @FXML private ListView groupListDM;
  @FXML private Label errorMessagePlayer;
  @FXML private Label errorMessageDM;
  @FXML private TextField groupName;


  public void init(AccountViewModel accountVM, ViewHandler viewHandler)
  {
    avm= accountVM;
    vh=viewHandler;
  }

  

  public void logout(ActionEvent actionEvent)
  {
    avm.removeAccount();
    System.exit(1);  //I wanted to make it so it goes back to the login screen, but then if I login back with a different account
                           //information about groups and etc. stay the same... Somehow I need to reset everything, almost everything,  I have no idea how to do it..
  }

  public void changePassword(ActionEvent actionEvent)
  {
    vh.openChangePassword();
  }

  public void changeToDM(ActionEvent actionEvent)
  {
    avm.changeToDm();
    vh.openAccountDM();
  }

  public void changeToPlayer(ActionEvent actionEvent)
  {
    avm.changeToPlayer();
    vh.openAccountPlayer();
  }
}
