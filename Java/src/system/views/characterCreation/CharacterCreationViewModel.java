package system.views.characterCreation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.model.businessModel.Character;
import system.model.businessModel.Feat;
import system.model.businessModel.Race;
import system.model.businessModel.Subclass;
import system.model.characterManagement.CharacterManagementModel;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

public class CharacterCreationViewModel
{
  private StringProperty raceDes;
  private StringProperty intelligenceProperty;
  private StringProperty strengthProperty;
  private StringProperty constitutionProperty;
  private StringProperty dexterityProperty;
  private StringProperty wisdomProperty;
  private StringProperty charismaProperty;
  private StringProperty intelligenceRacialBonus;
  private StringProperty strengthRacialBonus;
  private StringProperty constitutionRacialBonus;
  private StringProperty dexterityRacialBonus;
  private StringProperty wisdomRacialBonus;
  private StringProperty charismaRacialBonus;
  private StringProperty intelligenceMiscBonus;
  private StringProperty strengthMiscBonus;
  private StringProperty constitutionMiscBonus;
  private StringProperty dexterityMiscBonus;
  private StringProperty wisdomMiscBonus;
  private StringProperty charismaMiscBonus;
  private StringProperty intelligenceAbilityImprovement;
  private StringProperty strengthImprovement;
  private StringProperty constitutionImprovement;
  private StringProperty dexterityImprovement;
  private StringProperty wisdomImprovement;
  private StringProperty charismaImprovement;
  private StringProperty strengthFinal;
  private StringProperty intelligenceFinal;
  private StringProperty constitutionFinal;
  private StringProperty dexterityFinal;
  private StringProperty wisdomFinal;
  private StringProperty charismaFinal;
  private StringProperty subClassDescription;
  private StringProperty featToChooseDescription;
  private StringProperty featDescription;
  private StringProperty nameF;
  private StringProperty languageF;
  private StringProperty physicalCharacteristicsF;
  private StringProperty alliesAndOrganizationsF;
  private StringProperty characterDescriptionF;
  private StringProperty alignment;
  private StringProperty backstoryF;
  private StringProperty armorClass;
  private StringProperty initiative;
  private StringProperty speed;
  private StringProperty xp;
  private StringProperty level;
  ////////////////////////////////
  private Character temporaryCharacter;
  private Character character;
  private CharacterManagementModel model;
  private ArrayList<Subclass> relatedSubClasses;
  private ArrayList<Feat> relatedFeats;
  private ArrayList<Feat> featsAndFeatures;
  private ObservableList<String> treasures;
  private ObservableList<String> personalityTraits;
  private ObservableList<String> ideals;
  private ObservableList<String> bonds;
  private ObservableList<String> flaws;
  private boolean characterEditorAccountDmStatus;

  public CharacterCreationViewModel(CharacterManagementModel model1)
  {
    characterEditorAccountDmStatus = model1.getAccountDmStatus();
    treasures = FXCollections.observableArrayList();
    treasures.addAll(character.getTreasures());
    personalityTraits = FXCollections.observableArrayList();
    ideals= FXCollections.observableArrayList();
    bonds= FXCollections.observableArrayList();
    flaws= FXCollections.observableArrayList();
    personalityTraits.addAll(character.getPersonalityTraits());
    ideals.addAll(character.getIdeals());
    flaws.addAll(character.getFlaws());
    bonds.addAll(character.getBonds());
    model = model1;
    model.addListener("characterToSheetViewModel", this::setCharacter);

  }
  public void setCharacter(PropertyChangeEvent propertyChangeEvent)
  {
     character = (Character) propertyChangeEvent.getNewValue();
  }
  public void calculate()
  {

  }

  public Character getCharacter()
  {
    return character;
  }
  public void setTemporaryCharacterRace(Race race)
  {
    temporaryCharacter.setRace(race);
    raceDes = new SimpleStringProperty(temporaryCharacter.getRace().getInfo());
  }

  public String getRaceDes()
  {
    return raceDes.get();
  }

  public StringProperty raceDesProperty()
  {
    return raceDes;
  }

  public String getIntelligenceProperty()
  {
    return intelligenceProperty.get();
  }

  public StringProperty intelligencePropertyProperty()
  {
    return intelligenceProperty;
  }

  public String getCharismaProperty()
  {
    return charismaProperty.get();
  }

  public StringProperty charismaPropertyProperty()
  {
    return charismaProperty;
  }

  public String getWisdomProperty()
  {
    return wisdomProperty.get();
  }

  public StringProperty wisdomPropertyProperty()
  {
    return wisdomProperty;
  }

  public String getDexterityProperty()
  {
    return dexterityProperty.get();
  }

  public StringProperty dexterityPropertyProperty()
  {
    return dexterityProperty;
  }

  public String getConstitutionProperty()
  {
    return constitutionProperty.get();
  }

  public StringProperty constitutionPropertyProperty()
  {
    return constitutionProperty;
  }

  public String getStrengthProperty()
  {
    return strengthProperty.get();
  }

  public StringProperty strengthPropertyProperty()
  {
    return strengthProperty;
  }

  public String getIntelligenceRacialBonus()
  {
    return intelligenceRacialBonus.get();
  }

  public StringProperty intelligenceRacialBonusProperty()
  {
    return intelligenceRacialBonus;
  }

  public String getStrengthRacialBonus()
  {
    return strengthRacialBonus.get();
  }

  public StringProperty strengthRacialBonusProperty()
  {
    return strengthRacialBonus;
  }

  public String getConstitutionRacialBonus()
  {
    return constitutionRacialBonus.get();
  }

  public StringProperty constitutionRacialBonusProperty()
  {
    return constitutionRacialBonus;
  }

  public String getDexterityRacialBonus()
  {
    return dexterityRacialBonus.get();
  }

  public StringProperty dexterityRacialBonusProperty()
  {
    return dexterityRacialBonus;
  }

  public String getWisdomRacialBonus()
  {
    return wisdomRacialBonus.get();
  }

  public StringProperty wisdomRacialBonusProperty()
  {
    return wisdomRacialBonus;
  }

  public String getCharismaRacialBonus()
  {
    return charismaRacialBonus.get();
  }

  public StringProperty charismaRacialBonusProperty()
  {
    return charismaRacialBonus;
  }

  public String getIntelligenceMiscBonus()
  {
    return intelligenceMiscBonus.get();
  }

  public StringProperty intelligenceMiscBonusProperty()
  {
    return intelligenceMiscBonus;
  }

  public String getStrengthMiscBonus()
  {
    return strengthMiscBonus.get();
  }

  public StringProperty strengthMiscBonusProperty()
  {
    return strengthMiscBonus;
  }

  public String getConstitutionMiscBonus()
  {
    return constitutionMiscBonus.get();
  }

  public StringProperty constitutionMiscBonusProperty()
  {
    return constitutionMiscBonus;
  }

  public String getDexterityMiscBonus()
  {
    return dexterityMiscBonus.get();
  }

  public StringProperty dexterityMiscBonusProperty()
  {
    return dexterityMiscBonus;
  }

  public String getWisdomMiscBonus()
  {
    return wisdomMiscBonus.get();
  }

  public StringProperty wisdomMiscBonusProperty()
  {
    return wisdomMiscBonus;
  }

  public String getCharismaMiscBonus()
  {
    return charismaMiscBonus.get();
  }

  public StringProperty charismaMiscBonusProperty()
  {
    return charismaMiscBonus;
  }

  public String getIntelligenceAbilityImprovement()
  {
    return intelligenceAbilityImprovement.get();
  }

  public StringProperty intelligenceAbilityImprovementProperty()
  {
    return intelligenceAbilityImprovement;
  }

  public String getStrengthImprovement()
  {
    return strengthImprovement.get();
  }

  public StringProperty strengthImprovementProperty()
  {
    return strengthImprovement;
  }

  public String getConstitutionImprovement()
  {
    return constitutionImprovement.get();
  }

  public StringProperty constitutionImprovementProperty()
  {
    return constitutionImprovement;
  }

  public String getDexterityImprovement()
  {
    return dexterityImprovement.get();
  }

  public StringProperty dexterityImprovementProperty()
  {
    return dexterityImprovement;
  }

  public String getWisdomImprovement()
  {
    return wisdomImprovement.get();
  }

  public StringProperty wisdomImprovementProperty()
  {
    return wisdomImprovement;
  }

  public String getCharismaImprovement()
  {
    return charismaImprovement.get();
  }

  public StringProperty charismaImprovementProperty()
  {
    return charismaImprovement;
  }

  public String getStrengthFinal()
  {
    return strengthFinal.get();
  }

  public StringProperty strengthFinalProperty()
  {
    return strengthFinal;
  }

  public String getIntelligenceFinal()
  {
    return intelligenceFinal.get();
  }

  public StringProperty intelligenceFinalProperty()
  {
    return intelligenceFinal;
  }

  public String getConstitutionFinal()
  {
    return constitutionFinal.get();
  }

  public StringProperty constitutionFinalProperty()
  {
    return constitutionFinal;
  }

  public String getDexterityFinal()
  {
    return dexterityFinal.get();
  }

  public StringProperty dexterityFinalProperty()
  {
    return dexterityFinal;
  }

  public String getWisdomFinal()
  {
    return wisdomFinal.get();
  }

  public StringProperty wisdomFinalProperty()
  {
    return wisdomFinal;
  }

  public String getCharismaFinal()
  {
    return charismaFinal.get();
  }

  public StringProperty charismaFinalProperty()
  {
    return charismaFinal;
  }

  public String getSubClassDescription()
  {
    return subClassDescription.get();
  }

  public StringProperty subClassDescriptionProperty()
  {
    return subClassDescription;
  }

  public ArrayList<Subclass> getRelatedSubClasses()
  {
    return relatedSubClasses;
  }

  public String getFeatToChooseDescription()
  {
    return featToChooseDescription.get();
  }

  public StringProperty featToChooseDescriptionProperty()
  {
    return featToChooseDescription;
  }

  public ArrayList<Feat> getRelatedFeats()
  {
    return relatedFeats;
  }

  public ArrayList<Feat> getFeatsAndFeatures()
  {
    return featsAndFeatures;
  }

  public String getFeatDescription()
  {
    return featDescription.get();
  }

  public StringProperty featDescriptionProperty()
  {
    return featDescription;
  }

  public String getNameF()
  {
    return nameF.get();
  }

  public StringProperty nameFProperty()
  {
    return nameF;
  }

  public String getLanguageF()
  {
    return languageF.get();
  }

  public StringProperty languageFProperty()
  {
    return languageF;
  }

  public String getPhysicalCharacteristicsF()
  {
    return physicalCharacteristicsF.get();
  }

  public StringProperty physicalCharacteristicsFProperty()
  {
    return physicalCharacteristicsF;
  }

  public String getAlliesAndOrganizationsF()
  {
    return alliesAndOrganizationsF.get();
  }

  public StringProperty alliesAndOrganizationsFProperty()
  {
    return alliesAndOrganizationsF;
  }


  public String getCharacterDescriptionF()
  {
    return characterDescriptionF.get();
  }

  public StringProperty characterDescriptionFProperty()
  {
    return characterDescriptionF;
  }

  public String getAlignment()
  {
    return alignment.get();
  }

  public StringProperty alignmentProperty()
  {
    return alignment;
  }

  public ObservableList<String> getTreasures()
  {
    return treasures;
  }

  public ObservableList<String> getPersonalityTraits()
  {
    return personalityTraits;
  }

  public ObservableList<String> getIdeals()
  {
    return ideals;
  }

  public ObservableList<String> getBonds()
  {
    return bonds;
  }

  public ObservableList<String> getFlaws()
  {
    return flaws;
  }

  public String getBackstoryF()
  {
    return backstoryF.get();
  }

  public StringProperty backstoryFProperty()
  {
    return backstoryF;
  }

  public String getArmorClass()
  {
    return armorClass.get();
  }

  public StringProperty armorClassProperty()
  {
    return armorClass;
  }

  public String getInitiative()
  {
    return initiative.get();
  }

  public StringProperty initiativeProperty()
  {
    return initiative;
  }

  public String getSpeed()
  {
    return speed.get();
  }

  public StringProperty speedProperty()
  {
    return speed;
  }

  public String getXp()
  {
    return xp.get();
  }

  public StringProperty xpProperty()
  {
    return xp;
  }

  public String getLevel()
  {
    return level.get();
  }

  public StringProperty levelProperty()
  {
    return level;
  }

  public boolean isCharacterEditorAccountDmStatus()
  {
    return characterEditorAccountDmStatus;
  }
}
