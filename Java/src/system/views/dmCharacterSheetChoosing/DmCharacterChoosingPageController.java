package system.views.dmCharacterSheetChoosing;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import system.core.ViewHandler;

public class DmCharacterChoosingPageController
{
  private ViewHandler vh;
  private DMCharacterSheetChoosingViewModel model;
  @FXML private TableView<DM_hardcode_data> tableDM;
  @FXML private TableColumn<DM_hardcode_data, Integer> lvl;
  @FXML private TableColumn<DM_hardcode_data, String> charname;
  @FXML private TableColumn<DM_hardcode_data, String> play;
  @FXML private TableColumn<DM_hardcode_data, Integer> curXP;
  @FXML private TextField giveXPField;
  @FXML private Label errorMessage;


  public TextField getGiveXPField()
  {
    return giveXPField;
  }

  public void setGiveXPField(TextField giveXPField)
  {
    this.giveXPField = giveXPField;
  }

  public Label getErrorMessage()
  {
    return errorMessage;
  }

  public void setErrorMessage(Label errorMessage)
  {
    this.errorMessage = errorMessage;
  }

  public void init(DMCharacterSheetChoosingViewModel viewModel,
      ViewHandler viewHandler)
  {
    vh = viewHandler;
    model = viewModel;
    lvl.setCellValueFactory(
        new PropertyValueFactory<DM_hardcode_data, Integer>("level"));
    charname.setCellValueFactory(
        new PropertyValueFactory<DM_hardcode_data, String>("name"));
    play.setCellValueFactory(
        new PropertyValueFactory<DM_hardcode_data, String>("username"));
    curXP.setCellValueFactory(
        new PropertyValueFactory<DM_hardcode_data, Integer>("xp"));
   // tableDM.setItems(model.getCharacterList());
 //   giveXPField.textProperty().bindBidirectional(model.getXpFieldProperty());
    errorMessage.textProperty().bind(model.getErrorProperty());
    hardcode();

  }

  public void enableLevelForPlayer(ActionEvent actionEvent)
  {
    if (tableDM.getSelectionModel().getSelectedItems().isEmpty())
    {
      int test= Integer.parseInt(giveXPField.getText());

      ObservableList<DM_hardcode_data> data = FXCollections.observableArrayList(
          new DM_hardcode_data(50, "Marin", "Marin's character", 1));
      tableDM.setItems(data);


    }
    else
    {
      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      DM_hardcode_data ch = tableDM.getItems().get(row);

     // model.enableLVL(ch);

    }
  }

  public void giveXPToCharacter(ActionEvent actionEvent)
  {
    if (tableDM.getSelectionModel().getSelectedItems().isEmpty())
    {
      int test= Integer.parseInt(giveXPField.getText());

      ObservableList<DM_hardcode_data> data = FXCollections.observableArrayList(
          new DM_hardcode_data(test, "marin", "TestCharacter", 0));
      tableDM.setItems(data);

    }
    else
    {
      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
//      Character ch = tableDM.getItems().get(row);
//      int amount = ch.getXp();
//
//      model.giveXP(ch.getUsername(), amount);
//      Text message = new Text(errorMessage.getText());

    }

  }

  public void hardcode()
  {
    ObservableList<DM_hardcode_data> data = FXCollections.observableArrayList(
        new DM_hardcode_data(0, "marin", "TestCharacter", 1));
    tableDM.setItems(data);




  }

  public void hardcode_giveXP()
  {
    if (tableDM.getSelectionModel().getSelectedItems().isEmpty())
    {
      Text message = new Text(errorMessage.getText());
    }
    else
    {
      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
//      Character ch = tableDM.getItems().get(row);
//      int amount = ch.getXp();
//      int setAmount = amount + Integer.parseInt(giveXPField.getText());
//      ObservableList data = FXCollections.observableArrayList(
//          new DM_hardcode_data(setAmount, "Marin", "Marin's character", 1));
//      tableDM.getColumns().removeAll();
//      tableDM.setItems(data);
//      tableDM.getColumns().add(curXP);
//      tableDM.getColumns().add(play);
//      tableDM.getColumns().add(charname);
//      tableDM.getColumns().add(lvl);
    }
  }

  public void hardcode_giveLevel()
  {
    if (tableDM.getSelectionModel().getSelectedItems().isEmpty())
    {
      Text message = new Text(errorMessage.getText());
    }
    else
    {
//      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
//      int row = tp.getRow();
//      Character ch = tableDM.getItems().get(row);
//      int level_original = ch.getLevel();
//      ObservableList data = FXCollections.observableArrayList(
//          new DM_hardcode_data(0, "Marin", "Marin's character", level_original++));
//      tableDM.getColumns().removeAll();
//      tableDM.setItems(data);
//      tableDM.getColumns().add(curXP);
//      tableDM.getColumns().add(play);
//      tableDM.getColumns().add(charname);
//      tableDM.getColumns().add(lvl);
    }
  }
}
