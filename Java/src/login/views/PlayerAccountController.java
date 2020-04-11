package login.views;

import login.model.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PlayerAccountController
{
  private ViewHandler vh;
  private PlayerAccountViewModel pavm;
  @FXML private Label  errorMessagePlayer;
  @FXML private TextField addGroup;
  @FXML private ListView<String> groupListPlayer;
  public void init(PlayerAccountViewModel accountPVM, ViewHandler viewHandler)
  {
    pavm= accountPVM;
    vh = viewHandler;
     groupListPlayer.setItems(pavm.getGroupList());
     errorMessagePlayer.textProperty().bind(pavm.getErrorProperty());
     addGroup.textProperty().bindBidirectional(pavm.getSearchGroupProperty());


  }

  public void addGroup(ActionEvent actionEvent)
  {
    pavm.addGroup(addGroup.getText());
  }

  public void joinGroupAsPlayer(ActionEvent actionEvent)
  { if(groupListPlayer.getSelectionModel().getSelectedItems().isEmpty()){
    errorMessagePlayer.setText("Select a group from the list");
  }else
  {
    String group =  groupListPlayer.getSelectionModel().getSelectedItems().get(0);
    pavm.joinGroupAsPlayer(group);
  }
  }



  public void backToAccount(ActionEvent actionEvent)
  {
   ;vh.openAccount();
  }
}
