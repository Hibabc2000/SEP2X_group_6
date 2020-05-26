package system.views.characterCreation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import system.model.businessModel.Background;
import system.model.businessModel.Race;

public class CharacterCreationController
{
  @FXML public ComboBox raceComboBox;
  @FXML public ComboBox classComboBox;
  @FXML public ComboBox subClassComboBox;
  @FXML public ComboBox featComboBox;
  @FXML public ComboBox abilityScoreImprovementComboBoxOne;
  @FXML public ComboBox abilityScoreImprovementComboBoxTwo;
  @FXML public ComboBox alignmentComboBox;
  @FXML public ComboBox backgroundComboBox;
  @FXML public TextArea raceDescription;
  @FXML public TextArea classDescription;
  @FXML public TextArea subClassDescription;
  @FXML public TextArea featDescription;
  @FXML public TextArea featOrFeatureDescription;
  @FXML public TextArea languageTextArea;
  @FXML public TextArea physicalCharacteristicsTextArea;
  @FXML public TextArea treasureTextArea;
  @FXML public TextArea alliesAndOrganizationsTextArea;
  @FXML public TextArea backstoryTextArea;
  @FXML public TextArea personalCharacteristicsTextArea;
  @FXML public TextArea characterDescriptionTextArea;
  @FXML public TextField strengthRolledNumber;
  @FXML public TextField dexterityRolledNumber;
  @FXML public TextField constitutionRolledNumber;
  @FXML public TextField intelligenceRolledNumber;
  @FXML public TextField wisdomRolledNumber;
  @FXML public TextField charismaRolledNumber;
  @FXML public TextField nameTextField;
  @FXML public TextField armorClassManuallyEnteredNumber;
  @FXML public TextField initiativeModifierManuallyEnteredNumber;
  @FXML public TextField levelManuallyEnteredNumber;
  @FXML public TextField speedManuallyEnteredNumber;
  @FXML public ListView featsAndFeaturesListView;
  @FXML public TextField xpManuallyEnteredNumber;
  @FXML public CheckBox acrobaticsCheckBox;
  @FXML public CheckBox animalHandlingCheckBox;
  @FXML public CheckBox arcanaCheckBox;
  @FXML public CheckBox athleticsCheckBox;
  @FXML public CheckBox deceptionCheckBox;
  @FXML public CheckBox historyCheckBox;
  @FXML public CheckBox insightCheckBox;
  @FXML public CheckBox intimidationCheckBox;
  @FXML public CheckBox investigationCheckBox;
  @FXML public CheckBox medicineCheckBox;
  @FXML public CheckBox natureCheckBox;
  @FXML public CheckBox perceptionCheckBox;
  @FXML public CheckBox performanceCheckBox;
  @FXML public CheckBox persuasionCheckBox;
  @FXML public CheckBox religionCheckBox;
  @FXML public CheckBox sleightOfHandCheckBox;
  @FXML public CheckBox stealthCheckBox;
  @FXML public CheckBox survivalCheckBox;
  @FXML public Label strengthRacialBonus;
  @FXML public Label strengthAbilityImprovement;
  @FXML public Label strengthMiscBonus;
  @FXML public Label strengthTotal;
  @FXML public Label dexterityRacialBonus;
  @FXML public Label dexterityAbilityImprovement;
  @FXML public Label dexterityMiscBonus;
  @FXML public Label dexterityTotal;
  @FXML public Label constitutionRacialBonus;
  @FXML public Label constitutionAbilityImprovement;
  @FXML public Label constitutionMiscBonus;
  @FXML public Label constitutionTotal;
  @FXML public Label intelligenceRacialBonus;
  @FXML public Label intelligenceAbilityImprovement;
  @FXML public Label intelligenceMiscBonus;
  @FXML public Label intelligenceTotal;
  @FXML public Label wisdomRacialBonus;
  @FXML public Label wisdomAbilityImprovement;
  @FXML public Label wisdomMiscBonus;
  @FXML public Label wisdomTotal;
  @FXML public Label charismaRacialBonus;
  @FXML public Label charismaAbilityImprovement;
  @FXML public Label charismaMiscBonus;
  @FXML public Label charismaTotal;
  @FXML public Button removeFeatOrFeatureButton;
  @FXML public TextArea personalityTraitsTextArea;
  @FXML public TextArea idealsTextArea;
  @FXML public TextArea bondsTextArea;
  @FXML public TextArea flawsTextArea;
  @FXML public Button saveCharacterButton;
  @FXML public Button addAbilityScoreImprovementConfirmationButton;
  @FXML public TextArea backgroundDescriptionTextArea;
  @FXML public TextArea newTreasureTextARea;
  @FXML public ListView treasuresListView;
  @FXML public ListView personalityTraitsListView;
  @FXML public ListView idealsListView;
  @FXML public ListView bondsListView;
  @FXML public ListView flawsListView;
  ////////////////////
  private CharacterCreationViewModel characterCreationViewModel;
  private ObservableList<String> alignments;
  private ObservableList<Background> backgrounds;


  public void init()
  {
    alignments =  FXCollections.observableArrayList();
    //<editor-fold desc="alignments">
    alignments.add("Chaotic Good");
    alignments.add("Chaotic Neutral");
    alignments.add("Chaotic Evil");
    alignments.add("Lawful Good");
    alignments.add("Lawful Neutral");
    alignments.add("Lawful Evil");
    alignments.add("Neutral Good");
    alignments.add("Neutral");
    alignments.add("Neutral Evil");
    //</editor-fold>
    backgrounds = FXCollections.observableArrayList();
    //ill add the real stuff later
    //<editor-fold desc="backgrounds">
    backgrounds.add(new Background("Acolyte","retard"));
    backgrounds.add(new Background("noble","advanced retard"));
    //</editor-fold>

    raceComboBox.setItems(FXCollections.observableList(characterCreationViewModel.getStaticModel().getRaces()));
    raceComboBox.getSelectionModel().select(characterCreationViewModel.getCharacter().getRace());
    raceDescription.textProperty().bind(characterCreationViewModel.raceDesProperty());
    //<editor-fold desc="intelligenceRolledNumber">
    intelligenceRolledNumber.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*([\\.]\\d{0,2})?")) {
          intelligenceRolledNumber.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });
    //////
    strengthRolledNumber.textProperty().bindBidirectional(characterCreationViewModel.intelligencePropertyProperty());
    strengthRolledNumber.textProperty().addListener((observable, oldValue, newValue) -> {
      characterCreationViewModel.calculateAbilities();
    });
    //</editor-fold>
    //<editor-fold desc="strengthRolledNumber">
    strengthRolledNumber.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*([\\.]\\d{0,2})?")) {
          strengthRolledNumber.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });
    //////
    strengthRolledNumber.textProperty().bindBidirectional(characterCreationViewModel.strengthPropertyProperty());
    strengthRolledNumber.textProperty().addListener((observable, oldValue, newValue) -> {
      characterCreationViewModel.calculateAbilities();
    });
    //</editor-fold>
    //<editor-fold desc="dexterityRolledNumber">
    dexterityRolledNumber.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*([\\.]\\d{0,2})?")) {
          dexterityRolledNumber.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });
    //////
    dexterityRolledNumber.textProperty().bindBidirectional(characterCreationViewModel.dexterityPropertyProperty());
    dexterityRolledNumber.textProperty().addListener((observable, oldValue, newValue) -> {
      characterCreationViewModel.calculateAbilities();
    });
    //</editor-fold>
    //<editor-fold desc="constitutionRolledNumber">
    constitutionRolledNumber.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*([\\.]\\d{0,2})?")) {
          constitutionRolledNumber.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });
    //////
    constitutionRolledNumber.textProperty().bindBidirectional(characterCreationViewModel.constitutionPropertyProperty());
    constitutionRolledNumber.textProperty().addListener((observable, oldValue, newValue) -> {
      characterCreationViewModel.calculateAbilities();
    });
    //</editor-fold>
    //<editor-fold desc="wisdomRolledNumber">
    wisdomRolledNumber.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*([\\.]\\d{0,2})?")) {
          wisdomRolledNumber.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });
    //////
    wisdomRolledNumber.textProperty().bindBidirectional(characterCreationViewModel.wisdomPropertyProperty());
    wisdomRolledNumber.textProperty().addListener((observable, oldValue, newValue) -> {
      characterCreationViewModel.calculateAbilities();
    });
    //</editor-fold>
    //<editor-fold desc="charismaRolledNumber">
    charismaRolledNumber.textProperty().addListener(new ChangeListener<String>() {
      @Override
      public void changed(ObservableValue<? extends String> observable, String oldValue,
          String newValue) {
        if (!newValue.matches("\\d*([\\.]\\d{0,2})?")) {
          charismaRolledNumber.setText(newValue.replaceAll("[^\\d]", ""));
        }
      }
    });
    //////
    charismaRolledNumber.textProperty().bindBidirectional(characterCreationViewModel.charismaPropertyProperty());
    charismaRolledNumber.textProperty().addListener((observable, oldValue, newValue) -> {
      characterCreationViewModel.calculateAbilities();
    });
    //</editor-fold>

    //<editor-fold desc="abilityNumbers">
    strengthMiscBonus.textProperty().bindBidirectional(characterCreationViewModel.strengthMiscBonusProperty());
    intelligenceMiscBonus.textProperty().bindBidirectional(characterCreationViewModel.intelligenceMiscBonusProperty());
    constitutionMiscBonus.textProperty().bindBidirectional(characterCreationViewModel.constitutionMiscBonusProperty());
    dexterityMiscBonus.textProperty().bindBidirectional(characterCreationViewModel.dexterityMiscBonusProperty());
    wisdomMiscBonus.textProperty().bindBidirectional(characterCreationViewModel.wisdomMiscBonusProperty());
    charismaMiscBonus.textProperty().bindBidirectional(characterCreationViewModel.charismaMiscBonusProperty());


    strengthRacialBonus.textProperty().bindBidirectional(characterCreationViewModel.strengthRacialBonusProperty());
    intelligenceRacialBonus.textProperty().bindBidirectional(characterCreationViewModel.intelligenceRacialBonusProperty());
    dexterityRacialBonus.textProperty().bindBidirectional(characterCreationViewModel.dexterityRacialBonusProperty());
    constitutionRacialBonus.textProperty().bindBidirectional(characterCreationViewModel.constitutionRacialBonusProperty());
    wisdomRacialBonus.textProperty().bindBidirectional(characterCreationViewModel.wisdomRacialBonusProperty());
    charismaRacialBonus.textProperty().bindBidirectional(characterCreationViewModel.charismaRacialBonusProperty());

    strengthAbilityImprovement.textProperty().bindBidirectional(characterCreationViewModel.strengthImprovementProperty());
    intelligenceAbilityImprovement.textProperty().bindBidirectional(characterCreationViewModel.intelligenceAbilityImprovementProperty());
    dexterityAbilityImprovement.textProperty().bindBidirectional(characterCreationViewModel.dexterityImprovementProperty());
    constitutionAbilityImprovement.textProperty().bindBidirectional(characterCreationViewModel.constitutionImprovementProperty());
    wisdomAbilityImprovement.textProperty().bindBidirectional(characterCreationViewModel.wisdomImprovementProperty());
    charismaAbilityImprovement.textProperty().bindBidirectional(characterCreationViewModel.charismaImprovementProperty());

    strengthTotal.textProperty().bindBidirectional(characterCreationViewModel.strengthFinalProperty());
    intelligenceTotal.textProperty().bindBidirectional(characterCreationViewModel.intelligenceFinalProperty());
    dexterityTotal.textProperty().bindBidirectional(characterCreationViewModel.dexterityFinalProperty());
    constitutionTotal.textProperty().bindBidirectional(characterCreationViewModel.constitutionFinalProperty());
    wisdomTotal.textProperty().bindBidirectional(characterCreationViewModel.wisdomFinalProperty());
    charismaTotal.textProperty().bindBidirectional(characterCreationViewModel.charismaFinalProperty());
    //</editor-fold>

    //<editor-fold desc="features">
    subClassComboBox.setItems(FXCollections.observableList(characterCreationViewModel.getRelatedSubClasses()));
    subClassDescription.textProperty().bindBidirectional(characterCreationViewModel.subClassDescriptionProperty());
    featComboBox.setItems(FXCollections.observableList(characterCreationViewModel.getRelatedFeats()));
    featDescription.textProperty().bindBidirectional(characterCreationViewModel.featToChooseDescriptionProperty());
    featsAndFeaturesListView.setItems(FXCollections.observableList(characterCreationViewModel.getFeatsAndFeatures()));
    featOrFeatureDescription.textProperty().bindBidirectional(characterCreationViewModel.featDescriptionProperty());
    //</editor-fold>

    //<editor-fold desc="Description">
    nameTextField.setText(characterCreationViewModel.getCharacter().getName());
    languageTextArea.textProperty().bindBidirectional(characterCreationViewModel.languageFProperty());
    physicalCharacteristicsTextArea.setText(characterCreationViewModel.getCharacter().getPhysicalCharacteristics());
    treasuresListView.setItems(characterCreationViewModel.getTreasures());

    alignmentComboBox.setItems(alignments);
    backgroundComboBox.setItems(backgrounds);

    personalityTraitsListView.setItems(characterCreationViewModel.getPersonalityTraits());
    idealsListView.setItems(characterCreationViewModel.getIdeals());
    flawsListView.setItems(characterCreationViewModel.getIdeals());
    bondsListView.setItems(characterCreationViewModel.getBonds());

    backstoryTextArea.setText(characterCreationViewModel.getCharacter().getBackstory());
    characterDescriptionTextArea.textProperty().bindBidirectional(characterCreationViewModel.characterDescriptionFProperty());
    //</editor-fold>

    //<editor-fold desc="Extras">
    armorClassManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.armorClassProperty());
    initiativeModifierManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.initiativeProperty());
    speedManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.speedProperty());
    xpManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.xpProperty());
    levelManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.levelProperty());

    if(characterCreationViewModel.isCharacterEditorAccountDmStatus())
    {
      armorClassManuallyEnteredNumber.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue,
            String newValue) {
          if (!newValue.matches("\\d*([\\.]\\d{0,2})?")) {
            armorClassManuallyEnteredNumber.setText(newValue.replaceAll("[^\\d]", ""));
          }
        }
      });
      initiativeModifierManuallyEnteredNumber.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue,
            String newValue) {
          if (!newValue.matches("\\d*([\\.]\\d{0,2})?")) {
            initiativeModifierManuallyEnteredNumber.setText(newValue.replaceAll("[^\\d]", ""));
          }
        }
      });
      speedManuallyEnteredNumber.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue,
            String newValue) {
          if (!newValue.matches("\\d*([\\.]\\d{0,3})?")) {
            speedManuallyEnteredNumber.setText(newValue.replaceAll("[^\\d]", ""));
          }
        }
      });
      xpManuallyEnteredNumber.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue,
            String newValue) {
          if (!newValue.matches("\\d*([\\.]\\d{0,6})?")) {
            xpManuallyEnteredNumber.setText(newValue.replaceAll("[^\\d]", ""));
          }
        }
      });
      levelManuallyEnteredNumber.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue,
            String newValue) {
          if (!newValue.matches("\\d*([\\.]\\d{0,3})?")) {
            levelManuallyEnteredNumber.setText(newValue.replaceAll("[^\\d]", ""));
          }
        }
      });
    }
    else
    {
      levelManuallyEnteredNumber.setEditable(false);
      xpManuallyEnteredNumber.setEditable(false);
      speedManuallyEnteredNumber.setEditable(false);
      initiativeModifierManuallyEnteredNumber.setEditable(false);
      armorClassManuallyEnteredNumber.setEditable(false);
    }

    //</editor-fold>
  }
  public void addFeat(ActionEvent actionEvent)
  {
  }

  public void removeFeat(ActionEvent actionEvent)
  {
  }

  public void addAbilityScoreImprovement(ActionEvent actionEvent)
  {
  }

  public void addTreasure(ActionEvent actionEvent)
  {
  }

  public void onRaceChange(ActionEvent actionEvent)
  {
    characterCreationViewModel.setTemporaryCharacterRace((Race)raceComboBox.getValue());

  }

  public void onClassChange(ActionEvent actionEvent)
  {
  }

  public void setSubClass(ActionEvent actionEvent)
  {
  }

  public void setFeatFromCB(ActionEvent actionEvent)
  {
  }

  public void saveCharacter(ActionEvent actionEvent)
  {
  }

  public void setBackgroundFN(ActionEvent actionEvent)
  {
  }

  public void removeTreasure(ActionEvent actionEvent)
  {
  }

  public void removePersonalityTrait(ActionEvent actionEvent)
  {
  }

  public void addPersonalityTrait(ActionEvent actionEvent)
  {
  }

  public void removeIdeal(ActionEvent actionEvent)
  {
  }

  public void addIdeal(ActionEvent actionEvent)
  {
  }

  public void removeBond(ActionEvent actionEvent)
  {
  }

  public void addBond(ActionEvent actionEvent)
  {
  }

  public void removeFlaw(ActionEvent actionEvent)
  {
  }

  public void addFlaw(ActionEvent actionEvent)
  {
  }
  /*
  public Button addFeatButton;
  public Button addAbilityScoreImprovementConfirmationButton;
  public Button removeFeatOrFeatureButton;
  public Button saveCharacterButton;
   */

}
