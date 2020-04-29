package system.views.login.dmAccount;

import system.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class DMAccountController
{
  private ViewHandler vh;
  private DMAccountViewModel methylenedioxymethamphetamine;
  @FXML private ListView<String> groupListDM;
  @FXML private TextField groupName;
  @FXML private Label  errorMessageDM;
  public void init(DMAccountViewModel dmavm, ViewHandler viewHandler)
  {
    methylenedioxymethamphetamine = dmavm;
    vh = viewHandler;
    groupListDM.setItems(methylenedioxymethamphetamine.getGroupList());
    errorMessageDM.textProperty().bind(methylenedioxymethamphetamine.getErrorProperty());
    groupName.textProperty().bindBidirectional(methylenedioxymethamphetamine.getTextFieldProperty());


  }

  public void createGroup(ActionEvent actionEvent)
  {
    methylenedioxymethamphetamine.createGroup();

  }

  public void joinGroupAsDM(ActionEvent actionEvent)
  {
  }

  public void backToAccount(ActionEvent actionEvent)
  {
    vh.openAccount();
  }
}
