package system.views.characterSheet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import system.core.ViewHandler;
import system.util.logger.Log;

public class CharacterSheetController
{

  @FXML public Label strengthModifier;
  @FXML public Label strength;
  @FXML public Label dexterityModifier;
  @FXML public Label dexterity;
  @FXML public Label constitutionModifier;
  @FXML public Label constitution;
  @FXML public Label intelligenceModifier;
  @FXML public Label intelligence;
  @FXML public Label wisdomModifier;
  @FXML public Label wisdom;
  @FXML public Label charismaModifier;
  @FXML public Label charisma;
  @FXML public Label acrobaticsModifier;
  @FXML public Label animalHandlingModifier;
  @FXML public Label arcanaModifier;
  @FXML public Label athleticsModifier;
  @FXML public Label deceptionModifier;
  @FXML public Label historyModifier;
  @FXML public Label insightModifier;
  @FXML public Label intimidationModifier;
  @FXML public Label investigationModifier;
  @FXML public Label medicineModifier;
  @FXML public Label natureModifier;
  @FXML public Label perceptionModifier;
  @FXML public Label performanceModifier;
  @FXML public Label persuasionModifier;
  @FXML public Label religionModifier;
  @FXML public Label sleightOfHandModifier;
  @FXML public Label stealthModifier;
  @FXML public Label survivalModifier;
  @FXML public Label characterClass;
  @FXML public Label characterName;
  @FXML public Label characterAlignment;
  @FXML public Label characterRace;
  @FXML public Label hpMax;
  @FXML public Label hp;
  @FXML public Label levelDisplay;
  @FXML public Label xpCount;
  @FXML public Label strengthSavingThrow;
  @FXML public Label dexteritySavingThrow;
  @FXML public Label constitutionSavingThrow;
  @FXML public Label intelligenceSavingThrow;
  @FXML public Label wisdomSavingThrow;
  @FXML public Label charismaSavingThrow;
  @FXML public Label proficiencyBonus;
  @FXML public Label passiveWisdom;
  @FXML public Label speed;
  @FXML public Label armorClass;
  @FXML public Label initiativeModifier;
  @FXML public Label platinumPiece;
  @FXML public Label copperPiece;
  @FXML public Label electrumPiece;
  @FXML public Label silverPiece;
  @FXML public Label goldPiece;
  @FXML public Label knownSpellsAmount;
  @FXML public Label preparedSpellsAmount;
  @FXML public Label selectedItemFromInventoryName;
  @FXML public Label addItemSelectedItemName;
  @FXML public Label platinumPieceOne;
  @FXML public Label goldPieceOne;
  @FXML public Label electrumPieceOne;
  @FXML public Label silverPieceOne;
  @FXML public Label copperPieceOne;
  @FXML public Button hpPlusButton;
  @FXML public Button hpMinusButton;
  @FXML public Button removeKnownSpellButton;
  @FXML public Button addSpelltoKnownSpellsButton;
  @FXML public Button prepareSpellButton;
  @FXML public Button unprepareSpellButton;
  @FXML public Button removeSpellFromSpellbookButton;
  @FXML public Button removeSelectedItemFromInventoryButton;
  @FXML public Button equipSelectedItemFromInventoryButton;
  @FXML public Button unequipSelectedItemFromInventoryButton;
  @FXML public Button addSelectedItemFromAddItemButton;
  @FXML public Button addCurrencyButton;
  @FXML public Button removeCurrencyButton;
  @FXML public Button clearChangeCurrencyTextFieldsButton;
  @FXML public TextField hpChangeAmount;
  @FXML public TextField selectedItemFromInventoryAmount;
  @FXML public TextField selectedItemFromAddItemAmountTextField;
  @FXML public TextField changePlatinumAmountTextField;
  @FXML public TextField changeGoldAmountTextField;
  @FXML public TextField changeElectrumAmountTextField;
  @FXML public TextField changeSilverAmountTextField;
  @FXML public TextField changeCopperAmountTextField;
  @FXML public ProgressBar xpBar;
  @FXML public TableView attacksAndSpellCastingTable;
  @FXML public TableView knownSpellsTable;
  @FXML public TableView addSpellTable;
  @FXML public TableView spellBookTable;
  @FXML public TableView inventoryWeaponsTable;
  @FXML public TableView inventoryArmorTable;
  @FXML public TableView inventoryMiscellaneousTable;
  @FXML public TableView addItemWeaponTable;
  @FXML public TableView addItemArmorTable;
  @FXML public TableView addItemMiscellaneousTable;
  @FXML public TableView equipmentTable;
  @FXML public TableColumn attackAndSpellCastingTableNameColumn;
  @FXML public TableColumn attacksAndSpellCastingTableDamageColumn;
  @FXML public TableColumn attacksAndSpellCastingTableRangeColumn;
  @FXML public TableColumn attacksAndSpellCastingTableDamageTypeColumn;
  @FXML public TableColumn equipmentTableEquippedColumn;
  @FXML public TableColumn equipmentTableAmountColumn;
  @FXML public TableColumn equipmentTableNameColumn;
  @FXML public TableColumn knownSpellsTableNameColumn;
  @FXML public TableColumn knownSpellsTableRangeAndAreaColumn;
  @FXML public TableColumn knownSpellsTableDamageColumn;
  @FXML public TableColumn knownSpellsTableComponentsColumn;
  @FXML public TableColumn knownSpellsTableLevelColumn;
  @FXML public TableColumn knownSpellsTableCastTimeColumn;
  @FXML public TableColumn knownSpellsTableDurationColumn;
  @FXML public TableColumn knownSpellsTableSavingThrowColumn;
  @FXML public TableColumn addSpellTableNameColumn;
  @FXML public TableColumn addSpellTableRangeAndAreaColumn;
  @FXML public TableColumn addSpellTableDamageColumn;
  @FXML public TableColumn addSpellTableComponentsColumn;
  @FXML public TableColumn addSpellTableLevelColumn;
  @FXML public TableColumn addSpellTableCastTimeColumn;
  @FXML public TableColumn addSpellTableDurationColumn;
  @FXML public TableColumn addSpellTableSavingThrowColumn;
  @FXML public TableColumn spellBookTableNameColumn;
  @FXML public TableColumn spellBookTableRangeAndAreaColumn;
  @FXML public TableColumn spellBookTableDamageColumn;
  @FXML public TableColumn spellBookTableComponentsColumn;
  @FXML public TableColumn spellBookTableLevelColumn;
  @FXML public TableColumn spellBookTableCastTimeColumn;
  @FXML public TableColumn spellBookTableSavingThrowColumn;
  @FXML public TableColumn spellBookTableDurationColumn;
  @FXML public TableColumn spellBookTablePreparedColumn;
  @FXML public TableColumn inventoryWeaponsTableEquippedColumn;
  @FXML public TableColumn inventoryWeaponsTableAmountColumn;
  @FXML public TableColumn inventoryWeaponsTableNameColumn;
  @FXML public TableColumn inventoryWeaponsTableDamageColumn;
  @FXML public TableColumn inventoryWeaponsTableDamageTypeColumn;
  @FXML public TableColumn inventoryWeaponsTableWeightColumn;
  @FXML public TableColumn inventoryWeaponsTableValueColumn;
  @FXML public TableColumn inventoryWeaponsTableRangeColumn;
  @FXML public TableColumn inventoryWeaponsTableTypeColumn;
  @FXML public TableColumn inventoryMiscellaneousTableEquippedColumn;
  @FXML public TableColumn inventoryMiscellaneousTableNameColumn;
  @FXML public TableColumn inventoryMiscellaneousTableAmountColumn;
  @FXML public TableColumn inventoryMiscellaneousTableWeightColumn;
  @FXML public TableColumn inventoryMiscellaneousTableValueColumn;
  @FXML public TableColumn addItemWeaponTableNameColumn;
  @FXML public TableColumn addItemWeaponTableDamageColumn;
  @FXML public TableColumn addItemWeaponTableDamageTypeColumn;
  @FXML public TableColumn addItemWeaponTableWeightColumn;
  @FXML public TableColumn addItemWeaponTableValueColumn;
  @FXML public TableColumn addItemWeaponTableRangeColumn;
  @FXML public TableColumn addItemWeaponTableTypeColumn;
  @FXML public TableColumn addItemArmorTableNameColumn;
  @FXML public TableColumn addItemArmorTableWeightColumn;
  @FXML public TableColumn addItemArmorTableValueColumn;
  @FXML public TableColumn addItemArmorTableArmorClassColumn;
  @FXML public TableColumn addItemMiscellaneousTableNameColumn;
  @FXML public TableColumn addItemMiscellaneousTableWeightColumn;
  @FXML public TableColumn addItemMiscellaneousTableValueColumn;
  @FXML public TableColumn inventoryArmorTableEquippedColumn;
  @FXML public TableColumn inventoryArmorTableAmountColumn;
  @FXML public TableColumn inventoryArmorTableNameColumn;
  @FXML public TableColumn inventoryArmorTableWeightColumn;
  @FXML public TableColumn inventoryArmorTableValueColumn;
  @FXML public TableColumn inventoryArmorTableArmorClassColumn;
  @FXML public TitledPane spellSlotsTitledPane;
  @FXML public TitledPane knownSpellsTitledPane;
  @FXML public TitledPane addSpellsTitledPane;
  @FXML public TitledPane spellBookTitledPane;
  @FXML public TitledPane inventoryTitledPane;
  @FXML public TitledPane inventoryArmorTitledPane;
  @FXML public TitledPane inventoryWeaponsTitledPane;
  @FXML public TitledPane inventoryMiscellaneousTitledPane;
  @FXML public TitledPane addItemTitledPane;
  @FXML public TitledPane addItemWeaponTitledPane;
  @FXML public TitledPane addItemArmorTitledPane;
  @FXML public TitledPane addItemMiscellaneousTitledPane;
  @FXML public TextArea featuresAndTraitsTextArea;
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
  @FXML public CheckBox levelOneFirstSpellSlot;
  @FXML public CheckBox levelOneSecondSpellSlot;
  @FXML public CheckBox levelOneSpellSlot;
  @FXML public CheckBox levelOneFourthSpellSlot;
  @FXML public CheckBox levelTwoFirstSpellSlot;
  @FXML public CheckBox levelTwoSecondSpellSlot;
  @FXML public CheckBox levelTwoThirdSpellSlot;
  @FXML public CheckBox levelTwoFourthSpellSlot;
  @FXML public CheckBox levelThreeFirstSpellSlot;
  @FXML public CheckBox levelThreeSecondSpellSlot;
  @FXML public CheckBox levelThreeThirdSpellSlot;
  @FXML public CheckBox levelThreeFourthSpellSlot;
  @FXML public CheckBox levelFourFirstSpellSlot;
  @FXML public CheckBox levelFourSecondSpellSlot;
  @FXML public CheckBox levelFourThirdSpellSlot;
  @FXML public CheckBox levelFourFourth;
  @FXML public CheckBox levelFiveFirstSpellSlot;
  @FXML public CheckBox levelFiveSecondSpellSlot;
  @FXML public CheckBox levelFiveThirdSpellSlot;
  @FXML public CheckBox levelFiveFourthSpellSlot;
  @FXML public CheckBox levelSixFirstSpellSlot;
  @FXML public CheckBox levelSixSecondSpellSlot;
  @FXML public CheckBox levelSixFourthSpellSlot;
  @FXML public CheckBox levelSevenFirstSpellSlot;
  @FXML public CheckBox levelSevenSecondSpellSlot;
  @FXML public CheckBox levelEightFirstSpellSlot;
  @FXML public CheckBox levelNineFirstSpellSlot;
  @FXML public CheckBox levelEightSecondSpellSlot;
  @FXML public CheckBox levelNineSecondSpellSlot;
  @FXML public CheckBox levelNineThirdSpellSlot;
  @FXML public CheckBox levelNineFourthSpellSlot;
  @FXML public CheckBox levelEightThirdSpellSlot;
  @FXML public CheckBox levelEightFourthSpellSlot;
  @FXML public CheckBox levelSevenThirdSpellSlot;
  @FXML public CheckBox levelSevenFourthSpellSlot;
  @FXML public CheckBox pactFirstSpellSlot;
  @FXML public CheckBox pactSecondSpellSlot;
  @FXML public CheckBox pactThirdSpellSlot;
  @FXML public CheckBox pactFourthSpellSlot;
  @FXML public CheckBox levelSixThirdSpellSlot;
  private ViewHandler vh;
  private CharacterSheetViewModel viewModel;

  private Log log;

  public void init(CharacterSheetViewModel vm, ViewHandler vhandler)
  {
    viewModel = vm;
    vh = vhandler;
    log = Log.getLogEntry();
    strengthModifier.textProperty()
        .bindBidirectional(viewModel.getstrengthModifier());
    strength.textProperty().bindBidirectional(viewModel.getstrength());
    dexterityModifier.textProperty()
        .bindBidirectional(viewModel.getdexterityModifier());
    dexterity.textProperty().bindBidirectional(viewModel.getdexterity());
    constitutionModifier.textProperty()
        .bindBidirectional(viewModel.getconstitutionModifier());
    constitution.textProperty().bindBidirectional(viewModel.getconstitution());
    intelligenceModifier.textProperty()
        .bindBidirectional(viewModel.getintelligenceModifier());
    intelligence.textProperty().bindBidirectional(viewModel.getintelligence());
    wisdomModifier.textProperty()
        .bindBidirectional(viewModel.getwisdomModifier());
    wisdom.textProperty().bindBidirectional(viewModel.getwisdom());
    charismaModifier.textProperty()
        .bindBidirectional(viewModel.getcharismaModifier());
    charisma.textProperty().bindBidirectional(viewModel.getcharisma());
    acrobaticsModifier.textProperty()
        .bindBidirectional(viewModel.getacrobaticsModifier());
    animalHandlingModifier.textProperty()
        .bindBidirectional(viewModel.getanimalHandlingModifier());
    arcanaModifier.textProperty()
        .bindBidirectional(viewModel.getarcanaModifier());
    athleticsModifier.textProperty()
        .bindBidirectional(viewModel.getathleticsModifier());
    deceptionModifier.textProperty()
        .bindBidirectional(viewModel.getdeceptionModifier());
    historyModifier.textProperty()
        .bindBidirectional(viewModel.gethistoryModifier());
    insightModifier.textProperty()
        .bindBidirectional(viewModel.getinsightModifier());
    intimidationModifier.textProperty()
        .bindBidirectional(viewModel.getintimidationModifier());
    investigationModifier.textProperty()
        .bindBidirectional(viewModel.getinvestigationModifier());
    medicineModifier.textProperty()
        .bindBidirectional(viewModel.getmedicineModifier());
    natureModifier.textProperty()
        .bindBidirectional(viewModel.getnatureModifier());
    perceptionModifier.textProperty()
        .bindBidirectional(viewModel.getperceptionModifier());
    performanceModifier.textProperty()
        .bindBidirectional(viewModel.getperformanceModifier());
    persuasionModifier.textProperty()
        .bindBidirectional(viewModel.getpersuasionModifier());
    religionModifier.textProperty()
        .bindBidirectional(viewModel.getreligionModifier());
    sleightOfHandModifier.textProperty()
        .bindBidirectional(viewModel.getsleightOfHandModifier());
    stealthModifier.textProperty()
        .bindBidirectional(viewModel.getstealthModifier());
    survivalModifier.textProperty()
        .bindBidirectional(viewModel.getsurvivalModifier());
    characterClass.textProperty()
        .bindBidirectional(viewModel.getcharacterClass());
    characterName.textProperty()
        .bindBidirectional(viewModel.getcharacterName());
    characterAlignment.textProperty()
        .bindBidirectional(viewModel.getcharacterAlignment());
    characterRace.textProperty()
        .bindBidirectional(viewModel.getcharacterRace());
    hpMax.textProperty().bindBidirectional(viewModel.getcharacterHPMax());
    hp.textProperty().bindBidirectional(viewModel.getcharacterHP());
    levelDisplay.textProperty()
        .bindBidirectional(viewModel.getcharacterLevel());
    xpCount.textProperty().bindBidirectional(viewModel.getxpCount());
    strengthSavingThrow.textProperty()
        .bindBidirectional(viewModel.getstrengthSavingThrow());
    dexteritySavingThrow.textProperty()
        .bindBidirectional(viewModel.getdexteritySavingThrow());
    constitutionSavingThrow.textProperty()
        .bindBidirectional(viewModel.getconstitutionSavingThrow());
    intelligenceSavingThrow.textProperty()
        .bindBidirectional(viewModel.getintelligenceSavingThrow());
    wisdomSavingThrow.textProperty()
        .bindBidirectional(viewModel.getwisdomSavingThrow());
    charismaSavingThrow.textProperty()
        .bindBidirectional(viewModel.getcharismaSavingThrow());
    proficiencyBonus.textProperty()
        .bindBidirectional(viewModel.getproficiencyBonus());
    passiveWisdom.textProperty()
        .bindBidirectional(viewModel.getpassiveWisdom());
    speed.textProperty().bindBidirectional(viewModel.getspeed());
    armorClass.textProperty().bindBidirectional(viewModel.getarmorClass());

    platinumPiece.textProperty()
        .bindBidirectional(viewModel.getplatinumPiece());
    copperPiece.textProperty().bindBidirectional(viewModel.getcopperPiece());
    electrumPiece.textProperty()
        .bindBidirectional(viewModel.getelectrumPiece());
    silverPiece.textProperty().bindBidirectional(viewModel.getsilverPiece());
    goldPiece.textProperty().bindBidirectional(viewModel.getgoldPiece());
    knownSpellsAmount.textProperty()
        .bindBidirectional(viewModel.getknownSpellAmount());
    preparedSpellsAmount.textProperty()
        .bindBidirectional(viewModel.getpreparedSpellAmount());
    selectedItemFromInventoryName.textProperty()
        .bindBidirectional(viewModel.getselectedItemFromInventoryName());
    addItemSelectedItemName.textProperty()
        .bindBidirectional(viewModel.getaddItemSelectedItemName());
    platinumPieceOne.textProperty()
        .bindBidirectional(viewModel.getplatinumPieceOne());
    goldPieceOne.textProperty().bindBidirectional(viewModel.getgoldPieceOne());
    electrumPieceOne.textProperty()
        .bindBidirectional(viewModel.getelectrumPieceOne());
    silverPieceOne.textProperty()
        .bindBidirectional(viewModel.getsilverPieceOne());
    copperPieceOne.textProperty()
        .bindBidirectional(viewModel.getcopperPieceOne());

    hpChangeAmount.textProperty()
        .bindBidirectional(viewModel.gethpChangeAmount());
    selectedItemFromInventoryAmount.textProperty()
        .bindBidirectional(viewModel.getselectedItemFromInventoryAmount());
    selectedItemFromAddItemAmountTextField.textProperty().bindBidirectional(
        viewModel.getselectedItemFromAddItemAmountStringProperty());
    changePlatinumAmountTextField.textProperty()
        .bindBidirectional(viewModel.getchangePlatinumAmountStringProperty());
    changeGoldAmountTextField.textProperty()
        .bindBidirectional(viewModel.getchangeGoldAmountStringProperty());
    changeElectrumAmountTextField.textProperty()
        .bindBidirectional(viewModel.getchangeElectrumAmountStringProperty());
    changeSilverAmountTextField.textProperty()
        .bindBidirectional(viewModel.getchangeSilverAmountStringProperty());
    changeCopperAmountTextField.textProperty()
        .bindBidirectional(viewModel.getchangeCopperAmountStringProperty());
    initiativeModifier.textProperty()
        .bindBidirectional(viewModel.getInitiativeModifier());
  }

  public void spellSlotCheck(ActionEvent actionEvent)
  {
  }

  public void removeSpellFromKnownSpells(ActionEvent actionEvent)
  {
  }

  public void addSpellToKnownSpells(ActionEvent actionEvent)
  {
  }

  public void prepareSpell(ActionEvent actionEvent)
  {
  }

  public void unprepareSpell(ActionEvent actionEvent)
  {
  }

  public void removeSpellFromSpellBook(ActionEvent actionEvent)
  {
  }

  public void removeSelectedItemFromInventory(ActionEvent actionEvent)
  {
  }

  public void equipSelectedItemFromInventory(ActionEvent actionEvent)
  {
  }

  public void unequipSelectedItemFromInventory(ActionEvent actionEvent)
  {
  }

  public void addSelectedItemToInventory(ActionEvent actionEvent)
  {
  }

  public void addCurrency(ActionEvent actionEvent)
  {
  }

  public void removeCurrency(ActionEvent actionEvent)
  {
  }

  public void clearCurrencyTextFields(ActionEvent actionEvent)
  {
  }
}
