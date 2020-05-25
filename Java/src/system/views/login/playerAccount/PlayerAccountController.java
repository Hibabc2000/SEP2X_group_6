package system.views.login.playerAccount;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

public class PlayerAccountController
{

  private ViewHandler vh;
  private PlayerAccountViewModel playerAccountViewModel;
  @FXML private Label  errorMessagePlayer;
  @FXML private TextField addGroup;
  @FXML private ListView<String> groupListPlayer;
  public void init(PlayerAccountViewModel accountPVM, ViewHandler viewHandler)
  {
    playerAccountViewModel = accountPVM;
    vh = viewHandler;
     groupListPlayer.setItems(playerAccountViewModel.getGroupList());
     errorMessagePlayer.textProperty().bind(playerAccountViewModel.getErrorProperty());
     addGroup.textProperty().bindBidirectional(playerAccountViewModel.getSearchGroupProperty());


  }
// in thismethod I take the text in the addgroup field, and call addgroup method on it to parse it into integer
  public void addGroup()
  {
    playerAccountViewModel.addGroup(addGroup.getText());
  }

  // This method takes the selected group and calls the joingroupAsplayer method to it, if nothing is selected then shows error.
  public void joinGroupAsPlayer()
  { if(groupListPlayer.getSelectionModel().getSelectedItems().isEmpty()){
    playerAccountViewModel.joinGroupAsPlayer("");
  }else
  {
    String group =  groupListPlayer.getSelectionModel().getSelectedItems().get(0);
    playerAccountViewModel.joinGroupAsPlayer(group);
  }
  }


// just opens the account scene
  public void backToAccount()
  {
    vh.openAccount();
  }
}
