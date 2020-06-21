package system.views.dmCharacterSheetChoosing;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import system.core.ViewHandler;
import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;

public class DmCharacterChoosingPageController
{
  private ViewHandler vh;
  private DMCharacterSheetChoosingViewModel model;
  @FXML private TableView<Character> tableDM;
  @FXML private TableColumn<Character, Integer> lvl;
  @FXML private TableColumn<Character, String> charname;
  @FXML private TableColumn<Character, String> play;
  @FXML private TableColumn<Character, Integer> curXP;
  @FXML private TextField giveXPField;
  @FXML private Label errorMessage;

  public TableView<Character> getTableDM()
  {
    return tableDM;
  }

  public void setTableDM(TableView<Character> tableDM)
  {
    this.tableDM = tableDM;
  }

  public TableColumn<Character, Integer> getLvl()
  {
    return lvl;
  }

  public void setLvl(TableColumn<Character, Integer> lvl)
  {
    this.lvl = lvl;
  }

  public TableColumn<Character, String> getCharname()
  {
    return charname;
  }

  public void setCharname(TableColumn<Character, String> charname)
  {
    this.charname = charname;
  }

  public TableColumn<Character, String> getPlay()
  {
    return play;
  }

  public void setPlay(TableColumn<Character, String> play)
  {
    this.play = play;
  }

  public TableColumn<Character, Integer> getCurXP()
  {
    return curXP;
  }

  public void setCurXP(TableColumn<Character, Integer> curXP)
  {
    this.curXP = curXP;
  }

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
        new PropertyValueFactory<Character, Integer>("level"));
    charname.setCellValueFactory(
        new PropertyValueFactory<Character, String>("name"));
    play.setCellValueFactory(
        new PropertyValueFactory<Character, String>("username"));
    curXP.setCellValueFactory(
        new PropertyValueFactory<Character, Integer>("xp"));
    tableDM.setItems(model.getCharacterList());
    giveXPField.textProperty().bindBidirectional(model.getXpFieldProperty());
    errorMessage.textProperty().bind(model.getErrorProperty());

  }

  public void enableLevelForPlayer(ActionEvent actionEvent)
  {
    if (tableDM.getSelectionModel().getSelectedItems().isEmpty())
    {
      Text message = new Text(errorMessage.getText());

    }
    else
    {
      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      Character ch = tableDM.getItems().get(row);

      model.enableLVL(ch);

    }
  }

  public void giveXPToCharacter(ActionEvent actionEvent)
  {
    if (tableDM.getSelectionModel().getSelectedItems().isEmpty())
    {
      Text message = new Text(errorMessage.getText());

    }
    else
    {
      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      Character ch = tableDM.getItems().get(row);
      int amount = ch.getXp();

      model.giveXP(ch.getUsername(), amount);
      Text message = new Text(errorMessage.getText());

    }

  }

  public void hardcode()
  {
    ObservableList data = FXCollections.observableArrayList(
        new DM_hardcode_data(0, "Marin", "Marin's character", 1));
    tableDM.getColumns().removeAll();
    tableDM.setItems(data);
    tableDM.getColumns().add(curXP);
    tableDM.getColumns().add(play);
    tableDM.getColumns().add(charname);
    tableDM.getColumns().add(lvl);
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
      Character ch = tableDM.getItems().get(row);
      int amount = ch.getXp();
      int setAmount = amount + Integer.parseInt(giveXPField.getText());
      ObservableList data = FXCollections.observableArrayList(
          new DM_hardcode_data(setAmount, "Marin", "Marin's character", 1));
      tableDM.getColumns().removeAll();
      tableDM.setItems(data);
      tableDM.getColumns().add(curXP);
      tableDM.getColumns().add(play);
      tableDM.getColumns().add(charname);
      tableDM.getColumns().add(lvl);
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
      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      Character ch = tableDM.getItems().get(row);
      int level_original = ch.getLevel();
      ObservableList data = FXCollections.observableArrayList(
          new DM_hardcode_data(0, "Marin", "Marin's character", level_original++));
      tableDM.getColumns().removeAll();
      tableDM.setItems(data);
      tableDM.getColumns().add(curXP);
      tableDM.getColumns().add(play);
      tableDM.getColumns().add(charname);
      tableDM.getColumns().add(lvl);
    }
  }
}
