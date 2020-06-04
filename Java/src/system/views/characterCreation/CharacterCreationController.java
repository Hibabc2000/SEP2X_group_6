package system.views.characterCreation;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import system.core.ViewHandler;
import system.model.businessModel.Background;
import system.model.businessModel.Character;
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
  @FXML public ListView classesListView;
  ////////////////////
  private CharacterCreationViewModel characterCreationViewModel;
  private ViewHandler viewHandler;
  private ObservableList<String> alignments;
  private ObservableList<Background> backgrounds;
  private ObservableList<String> abilitiesList;


  public void init(CharacterCreationViewModel cCVM,ViewHandler vh, Character tempChar)
  {
    this.characterCreationViewModel = cCVM;
    characterCreationViewModel.setCharacter(tempChar);
    viewHandler = vh;
    classComboBox.setItems(characterCreationViewModel.getAllCharacterClassesNames());
    classesListView.setItems(characterCreationViewModel.getCharacterClassesName());
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
    backgroundComboBox.setItems(FXCollections.observableList(characterCreationViewModel.getBackgrounds()));

    //<editor-fold desc="abilities comboBox">
    abilitiesList = FXCollections.observableArrayList();
    abilitiesList.add("Strength");
    abilitiesList.add("Intelligence");
    abilitiesList.add("Dexterity");
    abilitiesList.add("Constitution");
    abilitiesList.add("Wisdom");
    abilitiesList.add("Charisma");
    abilityScoreImprovementComboBoxOne.setItems(abilitiesList);
    abilityScoreImprovementComboBoxTwo.setItems(abilitiesList);
    //</editor-fold>

    raceComboBox.setItems(FXCollections.observableList(characterCreationViewModel.getStaticModel().getRaces()));
    raceComboBox.getSelectionModel().select(
        characterCreationViewModel.
            getCharacter().
            getRace());
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
    acrobaticsCheckBox.setSelected(characterCreationViewModel.getSkills()[0]);
    animalHandlingCheckBox.setSelected(characterCreationViewModel.getSkills()[1]);
    arcanaCheckBox.setSelected(characterCreationViewModel.getSkills()[2]);
    athleticsCheckBox.setSelected(characterCreationViewModel.getSkills()[3]);
    deceptionCheckBox.setSelected(characterCreationViewModel.getSkills()[4]);
    historyCheckBox.setSelected(characterCreationViewModel.getSkills()[5]);
    insightCheckBox.setSelected(characterCreationViewModel.getSkills()[6]);
    intimidationCheckBox.setSelected(characterCreationViewModel.getSkills()[7]);
    investigationCheckBox.setSelected(characterCreationViewModel.getSkills()[8]);
    medicineCheckBox.setSelected(characterCreationViewModel.getSkills()[9]);
    natureCheckBox.setSelected(characterCreationViewModel.getSkills()[10]);
    perceptionCheckBox.setSelected(characterCreationViewModel.getSkills()[11]);
    performanceCheckBox.setSelected(characterCreationViewModel.getSkills()[12]);
    persuasionCheckBox.setSelected(characterCreationViewModel.getSkills()[13]);
    religionCheckBox.setSelected(characterCreationViewModel.getSkills()[14]);
    sleightOfHandCheckBox.setSelected(characterCreationViewModel.getSkills()[15]);
    stealthCheckBox.setSelected(characterCreationViewModel.getSkills()[16]);
    survivalCheckBox.setSelected(characterCreationViewModel.getSkills()[17]);
    //</editor-fold>

    //<editor-fold desc="Description">
    nameTextField.setText(characterCreationViewModel.getCharacter().getName());
    languageTextArea.textProperty().bindBidirectional(characterCreationViewModel.languageFProperty());
    physicalCharacteristicsTextArea.textProperty().bindBidirectional(characterCreationViewModel.physicalCharacteristicsFProperty());
    treasuresListView.setItems(characterCreationViewModel.getTreasures());
    alignmentComboBox.setItems(alignments);
    backgroundComboBox.setItems(FXCollections.observableList(characterCreationViewModel.getBackgrounds()));
    backgroundComboBox.getSelectionModel().select(characterCreationViewModel.getCharacterBackground());
    personalityTraitsListView.setItems(characterCreationViewModel.getPersonalityTraits());
    idealsListView.setItems(characterCreationViewModel.getIdeals());
    flawsListView.setItems(characterCreationViewModel.getIdeals());
    bondsListView.setItems(characterCreationViewModel.getBonds());
    backstoryTextArea.textProperty().bindBidirectional(characterCreationViewModel.backstoryFProperty());
    characterDescriptionTextArea.textProperty().bindBidirectional(characterCreationViewModel.characterDescriptionFProperty());
    //</editor-fold>

    //<editor-fold desc="Extras">
    armorClassManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.armorClassProperty());
    //initiativeModifierManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.initiativeProperty());
    //speedManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.speedProperty());
    xpManuallyEnteredNumber.promptTextProperty().bindBidirectional(characterCreationViewModel.xpProperty());

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

    //characterCreationViewModel.addListener("openSceneCharacterCreation",this::openScene);
  }

/*  private void openScene(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("miért nem köszkdss");
    viewHandler.openCharacterCreation();
  }


 */
  public void addFeat(ActionEvent actionEvent)
  {
    if(!(featComboBox.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.addFeat(featComboBox.getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }

  }

  public void removeFeat(ActionEvent actionEvent)
  {
    if(!(featsAndFeaturesListView.getSelectionModel().getSelectedItems().isEmpty()))
    {
      characterCreationViewModel.removeFeat(featsAndFeaturesListView.getSelectionModel().getSelectedItem());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void addAbilityScoreImprovement(ActionEvent actionEvent)
  {
    if((!(abilityScoreImprovementComboBoxOne.getSelectionModel().isEmpty()))&&(!(abilityScoreImprovementComboBoxTwo.getSelectionModel().isEmpty())))
    {
      String tempStr1 = (String) abilityScoreImprovementComboBoxOne.getValue();
      String tempStr2 = (String) abilityScoreImprovementComboBoxOne.getValue();
      characterCreationViewModel.abilityScoreImprovement(tempStr1,tempStr2);
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }

  }

  public void addTreasure(ActionEvent actionEvent)
  {
    if(!(treasureTextArea.textProperty() == null||treasureTextArea.textProperty().getValue() == null||treasureTextArea.textProperty().getValue().equals("")))
    {
      characterCreationViewModel.addTreasure(treasureTextArea.textProperty().getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }

  }

  public void onRaceChange(ActionEvent actionEvent)
  {
    if(!(raceComboBox.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.setTemporaryCharacterRace((Race)raceComboBox.getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }

  }

  public void onClassChange(ActionEvent actionEvent)
  {
    if(!(classComboBox.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.changeClassDesc(classComboBox.getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }

  }

  public void setSubClass(ActionEvent actionEvent)
  {
  }

  public void setFeatFromCB(ActionEvent actionEvent)
  {
    if(!(featComboBox.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.changeFeatDescription(featComboBox.getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }

  }

  public void saveCharacter(ActionEvent actionEvent)
  {
    boolean[] tmp = new boolean[18];
    tmp[0] = acrobaticsCheckBox.isSelected();
    tmp[1] = animalHandlingCheckBox.isSelected();
    tmp[2] = arcanaCheckBox.isSelected();
    tmp[3] = athleticsCheckBox.isSelected();
    tmp[4] = deceptionCheckBox.isSelected();
    tmp[5] = historyCheckBox.isSelected();
    tmp[6] = insightCheckBox.isSelected();
    tmp[7] = intimidationCheckBox.isSelected();
    tmp[8] = investigationCheckBox.isSelected();
    tmp[9] = medicineCheckBox.isSelected();
    tmp[10] = natureCheckBox.isSelected();
    tmp[11] = perceptionCheckBox.isSelected();
    tmp[12] = performanceCheckBox.isSelected();
    tmp[13] = persuasionCheckBox.isSelected();
    tmp[14] = religionCheckBox.isSelected();
    tmp[15] = sleightOfHandCheckBox.isSelected();
    tmp[16] = stealthCheckBox.isSelected();
    tmp[17] = survivalCheckBox.isSelected();

    if(!(languageTextArea.textProperty()==null||languageTextArea.textProperty().getValue()==null||languageTextArea.textProperty().getValue().equalsIgnoreCase("")))
    {
      characterCreationViewModel.setLanguage(languageTextArea.textProperty().get());
      characterCreationViewModel.saveCharacter();
      characterCreationViewModel.setSkills(tmp);
      viewHandler.openCharacterSheet();
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please set the required values");
      alert.showAndWait();
    }



  }

  public void setBackgroundFN(ActionEvent actionEvent)
  {
    characterCreationViewModel.setBackground(backgroundComboBox.getValue());
  }

  public void removeTreasure(ActionEvent actionEvent)
  {
    if(!(treasuresListView.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.removeTreasure((String)treasuresListView.getSelectionModel().getSelectedItem());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void removePersonalityTrait(ActionEvent actionEvent)
  {
    if(!(personalityTraitsListView.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.removePersonalityTrait((String) personalityTraitsListView.getSelectionModel().getSelectedItem());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void addPersonalityTrait(ActionEvent actionEvent)
  {
    if(!(personalityTraitsTextArea.textProperty()==null||personalityTraitsTextArea.textProperty().getValue()==null||personalityTraitsTextArea.textProperty().getValue().equalsIgnoreCase("")))
    {
      characterCreationViewModel.addPersonalityTrait(personalityTraitsTextArea.textProperty().getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }

  }

  public void removeIdeal(ActionEvent actionEvent)
  {
    if(!(idealsListView.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.removeIdeal((String) idealsListView.getSelectionModel().getSelectedItem());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void addIdeal(ActionEvent actionEvent)
  {
    if(!(idealsTextArea.textProperty()==null||idealsTextArea.textProperty().getValue()==null||idealsTextArea.textProperty().getValue().equalsIgnoreCase("")))
    {
      characterCreationViewModel.addIdeal(idealsTextArea.textProperty().getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }


  public void removeBond(ActionEvent actionEvent)
  {
    if(!(bondsListView.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.removeBond((String) bondsListView.getSelectionModel().getSelectedItem());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }

  }

  public void addBond(ActionEvent actionEvent)
  {
    if(!(bondsTextArea.textProperty()==null||bondsTextArea.textProperty().getValue()==null||bondsTextArea.textProperty().getValue().equalsIgnoreCase("")))
    {
      characterCreationViewModel.addBond(bondsTextArea.textProperty().getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void removeFlaw(ActionEvent actionEvent)
  {
    if(!(flawsListView.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.removeFlaw((String) flawsListView.getSelectionModel().getSelectedItem());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void addFlaw(ActionEvent actionEvent)
  {
    if(!(flawsTextArea.textProperty()==null||flawsTextArea.textProperty().getValue()==null||flawsTextArea.textProperty().getValue().equalsIgnoreCase("")))
    {
      characterCreationViewModel.addFlaw(flawsTextArea.textProperty().getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void AddClass(ActionEvent actionEvent)
  {
    if(!(classComboBox.getSelectionModel().isEmpty()))
    {
      characterCreationViewModel.addCharacterClass(classComboBox.getValue());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void removeClass(ActionEvent actionEvent)
  {
    if(!(classesListView.getSelectionModel().getSelectedItems().isEmpty()))
    {
      characterCreationViewModel.removeCharacterClass(classesListView.getSelectionModel().getSelectedItem());
    }
    else
    {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Error Dialog");
      alert.setHeaderText("An Error Dialog");
      alert.setContentText("Please Choose an option");
      alert.showAndWait();
    }
  }

  public void changeSelectedClassForLevelEditing(ActionEvent actionEvent)
  {
  }
  /*
  public Button addFeatButton;
  public Button addAbilityScoreImprovementConfirmationButton;
  public Button removeFeatOrFeatureButton;
  public Button saveCharacterButton;
   */

}
