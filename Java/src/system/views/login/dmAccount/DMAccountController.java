package system.views.login.dmAccount;

import javafx.event.ActionEvent;
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

  public void init(DMAccountViewModel dmavm, ViewHandler viewHandler)
  {
    dmAccountViewModel = dmavm;
    vh = viewHandler;
    groupListDM.setItems(dmAccountViewModel.getGroupList());
    errorMessageDM.textProperty()
        .bind(dmAccountViewModel.getErrorProperty());
    groupName.textProperty().bindBidirectional(
        dmAccountViewModel.getTextFieldProperty());

  }

  public void createGroup(ActionEvent actionEvent)
  {
    dmAccountViewModel.createGroup();
  }

  public void joinGroupAsDM(ActionEvent actionEvent)
  {
    dmAccountViewModel.joinGroupAsDM();
  }

  public void backToAccount(ActionEvent actionEvent)
  {
    vh.openAccount();
  }
}
