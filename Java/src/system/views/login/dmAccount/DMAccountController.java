package system.views.login.dmAccount;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import system.core.ViewHandler;

public class DMAccountController
{
  private ViewHandler vh;
  private DMAccountViewModel dmAccountViewModel;
  @FXML private ListView<String> groupListDM;
  @FXML private TextField groupName;
  @FXML private Label errorMessageDM;

  public void init(DMAccountViewModel dmAccountViewModel, ViewHandler viewHandler)
  {
    this.dmAccountViewModel = dmAccountViewModel;
    vh = viewHandler;
    groupListDM.setItems(this.dmAccountViewModel.getGroupList());
    errorMessageDM.textProperty()
        .bind(this.dmAccountViewModel.getErrorProperty());
    groupName.textProperty().bindBidirectional(
        this.dmAccountViewModel.getTextFieldProperty());
  }

  public void createGroup()
  {
    dmAccountViewModel.createGroup();
  }

  public void joinGroupAsDM()
  {
    if(groupListDM.getSelectionModel().getSelectedItems().isEmpty()){
      dmAccountViewModel.startGame("");
    }else
    {
      String group =  groupListDM.getSelectionModel().getSelectedItems().get(0);
      dmAccountViewModel.startGame(group);
      vh.openDMCharacterChoosingPage();
    }


  }

  public void backToAccount()
  {
    vh.openAccount();
  }
}
