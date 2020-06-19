package system.views.dmCharacterSheetChoosing;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import system.core.ViewHandler;
import system.model.businessModel.Character;

public class DmCharacterChoosingPageController
{
  private ViewHandler  vh;
  private DMCharacterSheetChoosingViewModel model;
  @FXML private TableView<Character> tableDM;
  @FXML private TableColumn<Character, Integer> lvl;
  @FXML private TableColumn<Character, String> charname;
  @FXML private TableColumn<Character, String> play;
  @FXML private TableColumn<Character, Integer> curXP;
  @FXML private TextField giveXPField;
  @FXML private Label errorMessage;



  public void init(DMCharacterSheetChoosingViewModel viewModel, ViewHandler viewHandler)
  {
    vh= viewHandler;
    model = viewModel;
    lvl.setCellValueFactory(new PropertyValueFactory<Character,Integer>("level"));
    charname.setCellValueFactory(new PropertyValueFactory<Character,String>("name"));
    play.setCellValueFactory(new PropertyValueFactory<Character,String>("username"));
    curXP.setCellValueFactory(new PropertyValueFactory<Character,Integer>("xp"));
   tableDM.setItems(model.getCharacterList());
   giveXPField.textProperty().bindBidirectional(model.getXpFieldProperty());
   errorMessage.textProperty().bind(model.getErrorProperty());

  }

  public void enableLevelForPlayer(ActionEvent actionEvent)
  {
    if(tableDM.getSelectionModel().getSelectedItems().isEmpty()){
      Text message = new Text(errorMessage.getText());



    }else
    {
      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      Character ch = tableDM.getItems().get(row);


      model.enableLVL(ch);



    }
  }

  public void giveXPToCharacter(ActionEvent actionEvent)
  {
    if(tableDM.getSelectionModel().getSelectedItems().isEmpty()){
      Text message = new Text(errorMessage.getText());

    }else
    {
      TablePosition tp = tableDM.getSelectionModel().getSelectedCells().get(0);
      int row = tp.getRow();
      Character ch = tableDM.getItems().get(row);
      int amount = ch.getXp();

      model.giveXP(ch.getUsername(), amount);
      Text message = new Text(errorMessage.getText());

    }


  }

}
