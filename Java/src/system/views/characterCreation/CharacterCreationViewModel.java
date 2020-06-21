package system.views.characterCreation;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.model.businessModel.Character;
import system.model.businessModel.*;
import system.model.businessModel.staticModel.Skill;
import system.model.businessModel.staticModel.StaticModel;
import system.model.businessModel.staticModel.Subclass;
import system.model.characterClasses.CharacterClass;
import system.model.characterManagement.CharacterManagementModel;
import system.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class CharacterCreationViewModel implements Subject
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
  private StringProperty raceDescription;
  private StringProperty backgroundDescription;
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
  private StaticModel staticModel;
  private PropertyChangeSupport support;
  private ArrayList<CharacterClass> allClasses;
  private ArrayList<CharacterClass> characterClasses;
  private ObservableList<String> characterClassesName;
  private ObservableList<String> allCharacterClassesNames;
  private ArrayList<Background> backgrounds;
  private Background characterBackground;
  private boolean[] skills;

  public CharacterCreationViewModel(CharacterManagementModel model1)
  {
    support = new PropertyChangeSupport(this);
    skills = new boolean[18];
    model = model1;
    relatedFeats = new ArrayList<>();
    featsAndFeatures = new ArrayList<>();
    staticModel = model.getStaticModel();
    allClasses = model.getAllCharacterClasses();
    characterEditorAccountDmStatus = model.getAccountDmStatus();
    //changes, some initialization
   // allClasses = new ArrayList<>();
    backgrounds = new ArrayList<>();
    characterClasses = new ArrayList<>();
    relatedSubClasses = new ArrayList<>();
    relatedFeats = new ArrayList<>();
    raceDes = new SimpleStringProperty();
    intelligenceProperty = new SimpleStringProperty();
    strengthProperty = new SimpleStringProperty();
    dexterityProperty = new SimpleStringProperty();
    constitutionProperty = new SimpleStringProperty();

    wisdomProperty = new SimpleStringProperty();
    charismaProperty = new SimpleStringProperty();
    intelligenceRacialBonus = new SimpleStringProperty();
    strengthRacialBonus = new SimpleStringProperty();
    constitutionRacialBonus = new SimpleStringProperty();
    dexterityRacialBonus = new SimpleStringProperty();
    wisdomRacialBonus = new SimpleStringProperty();
    charismaRacialBonus = new SimpleStringProperty();
    intelligenceMiscBonus = new SimpleStringProperty();
    strengthMiscBonus = new SimpleStringProperty();
    constitutionMiscBonus = new SimpleStringProperty();
    dexterityMiscBonus = new SimpleStringProperty();
    intelligenceAbilityImprovement = new SimpleStringProperty();
    wisdomMiscBonus = new SimpleStringProperty();
    charismaMiscBonus = new SimpleStringProperty();
    strengthImprovement = new SimpleStringProperty();
    constitutionImprovement = new SimpleStringProperty();
    dexterityImprovement = new SimpleStringProperty();
    wisdomImprovement = new SimpleStringProperty();
    charismaImprovement = new SimpleStringProperty();
    strengthFinal = new SimpleStringProperty();
    intelligenceFinal = new SimpleStringProperty();
    constitutionFinal = new SimpleStringProperty();
    dexterityFinal = new SimpleStringProperty();
    wisdomFinal = new SimpleStringProperty();
    charismaFinal = new SimpleStringProperty();
    subClassDescription = new SimpleStringProperty();
    featToChooseDescription = new SimpleStringProperty();
    featDescription = new SimpleStringProperty();
    nameF = new SimpleStringProperty();
    languageF = new SimpleStringProperty();
    physicalCharacteristicsF = new SimpleStringProperty();
    alliesAndOrganizationsF = new SimpleStringProperty();
    characterDescriptionF = new SimpleStringProperty();
    alignment = new SimpleStringProperty();
    backstoryF = new SimpleStringProperty();
    armorClass = new SimpleStringProperty();
    initiative = new SimpleStringProperty();
    speed = new SimpleStringProperty();
    xp = new SimpleStringProperty();
    level = new SimpleStringProperty();
    raceDescription = new SimpleStringProperty();
    backgroundDescription = new SimpleStringProperty();
    //removed the listener since it wont work.
    //model.addListener("characterToSheetViewModel", this::setCharacter);
    // model.addListener("displayCharacterCreationScene",this::openScene);
    backgrounds.add(
        new Background("star wars holiday special dealer", "has low iq lol"));
    backgrounds.add(new Background("sage", "nerd or smth"));

  }

  public void setCharacter(Character propertyChangeEvent)
  {

    character = (Character) propertyChangeEvent;
    temporaryCharacter = character;
    allCharacterClassesNames = FXCollections.observableArrayList();
    characterClassesName = FXCollections.observableArrayList();
    treasures = FXCollections.observableArrayList();
    treasures.addAll(character.getTreasures());
    personalityTraits = FXCollections.observableArrayList();
    ideals = FXCollections.observableArrayList();
    bonds = FXCollections.observableArrayList();
    flaws = FXCollections.observableArrayList();
    personalityTraits.addAll(character.getPersonalityTraits());
    ideals.addAll(character.getIdeals());
    flaws.addAll(character.getFlaws());
    bonds.addAll(character.getBonds());
    nameF.setValue(temporaryCharacter.getName());
    for (int i = 0; i < allClasses.size(); i++)
    {
      allCharacterClassesNames.add(allClasses.get(i).getClassName());
    }
    for (int i = 0; i < characterClasses.size(); i++)
    {
      characterClassesName.add(characterClasses.get(i).getClassName());
    }
    for (int i = 0; i < characterClasses.size(); i++)
    {
      relatedFeats.addAll(characterClasses.get(i).getClassFeats());
    }
    for (int i = 0; i < backgrounds.size(); i++)
    {
      if ((temporaryCharacter.getBackground() != null) && backgrounds.get(i)
          .toString().equalsIgnoreCase(temporaryCharacter.getBackground()))
      {
        characterBackground = backgrounds.get(i);
      }
      for (Proficiency p : temporaryCharacter.getProficiencies())
      {
        if (p.getType().contains("language"))
        {
          languageF.setValue(p.getOrigin());
        }
        else
        {
          languageF.setValue(" ");
        }
      }
    }

    //HERE
    int[] x = temporaryCharacter.getAbilitiesRolled();
    intelligenceProperty.setValue(String.valueOf(x[3]));
    strengthProperty.setValue(String.valueOf(x[0]));
    dexterityProperty.setValue(String.valueOf(x[1]));
    constitutionProperty.setValue(String.valueOf(x[2]));
    wisdomProperty.setValue(String.valueOf(x[4]));
    charismaProperty.setValue(String.valueOf(x[5]));
    featsAndFeatures.addAll(temporaryCharacter.getFeats());
    //hvhjghjk

    for (Proficiency p : temporaryCharacter.getProficiencies())
    {
      StaticModel staticModel = new StaticModel();
      for (Skill s : staticModel.getSkills())
      {
        if (p.getName().toLowerCase().contains(s.getName().toLowerCase()))
        {
          if (s.getName().equals("Acrobatics"))
          {
            skills[0] = true;
          }
          else if (s.getName().equals("Animal Handling"))
          {
            skills[1] = true;
          }
          else if (s.getName().equals("Arcana"))
          {
            skills[2] = true;
          }
          else if (s.getName().equals("Athletics"))
          {
            skills[3] = true;
          }
          else if (s.getName().equals("Deception"))
          {
            skills[4] = true;
          }
          else if (s.getName().equals("History"))
          {
            skills[5] = true;
          }
          else if (s.getName().equals("Insight"))
          {
            skills[6] = true;
          }
          else if (s.getName().equals("Intimidation"))
          {
            skills[7] = true;
          }
          else if (s.getName().equals("Investigation"))
          {
            skills[8] = true;
          }
          else if (s.getName().equals("Medicine"))
          {
            skills[9] = true;
          }
          else if (s.getName().equals("Nature"))
          {
            skills[10] = true;
          }
          else if (s.getName().equals("Perception"))
          {
            skills[11] = true;
          }
          else if (s.getName().equals("Performance"))
          {
            skills[12] = true;
          }
          else if (s.getName().equals("Persuasion"))
          {
            skills[13] = true;
          }
          else if (s.getName().equals("Religion"))
          {
            skills[14] = true;
          }
          else if (s.getName().equals("Sleight of Hand"))
          {
            skills[15] = true;
          }
          else if (s.getName().equals("Stealth"))
          {
            skills[16] = true;
          }
          else if (s.getName().equals("Survival"))
          {
            skills[17] = true;
          }
        }
      }
    }

  }
/*
  private void openScene(PropertyChangeEvent propertyChangeEvent)
  { System.out.println("was ist day?");
    support.firePropertyChange("openSceneCharacterCreation",null,null);

  }


 */

  public void calculate()
  {

  }

  public void createCharacter()
  {

  }

  public void recalculateAvailableFeats()
  {
    relatedFeats.clear();
    for (int i = 0; i < characterClasses.size(); i++)
    {
      relatedFeats.addAll(characterClasses.get(i).getClassFeats());
    }
    relatedFeats.removeAll(temporaryCharacter.getFeats());
  }

  public Character getCharacter()
  {
    return character;
  }

  public void setTemporaryCharacterRace(Race race)
  {
    for(int x = 0; x < staticModel.getRaces().size();x++)
    {
      if(staticModel.getRaces().get(x).getName().equalsIgnoreCase(race.getName()))
      {
        raceDes = new SimpleStringProperty(temporaryCharacter.getRace().getInfo());
        temporaryCharacter.setRace(staticModel.getRaces().get(x));
      }
    }
  }

  //<editor-fold desc="immense pain">
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

  //</editor-fold>
  public void calculateAbilities()
  {
    int[] finalAbilities = temporaryCharacter.getAbilities();
    int[] insertedRolledAbilities = temporaryCharacter.getAbilitiesRolled();
    int[] racialModifiers = new int[] {0, 0, 0, 0, 0, 0};
    int[] abilityImprovement = {0, 0, 0, 0, 0, 0};
    if (!(strengthProperty == null || strengthProperty.get().equals("")))
    {
      insertedRolledAbilities[0] = Integer.parseInt(strengthProperty.get());
    }
    if (!(dexterityProperty == null || dexterityProperty.get().equals("")))
    {
      insertedRolledAbilities[1] = Integer.parseInt(dexterityProperty.get());

    }
    if (!(constitutionProperty == null || constitutionProperty.get()
        .equals("")))
    {
      insertedRolledAbilities[2] = Integer.parseInt(constitutionProperty.get());

    }
    if (!(intelligenceProperty == null || intelligenceProperty.get()
        .equals("")))
    {
      insertedRolledAbilities[3] = Integer.parseInt(intelligenceProperty.get());

    }
    if (!(wisdomProperty == null || wisdomProperty.get().equals("")))
    {
      insertedRolledAbilities[4] = Integer.parseInt(wisdomProperty.get());

    }
    if (!(charismaProperty == null || charismaProperty.get().equals("")))
    {
      insertedRolledAbilities[5] = Integer.parseInt(charismaProperty.get());

    }
    temporaryCharacter.setAbilitiesRolled(insertedRolledAbilities);

    if (temporaryCharacter.getRace() == null)
    {
      charismaRacialBonus.setValue("0");
      strengthRacialBonus.setValue("0");
      intelligenceRacialBonus.setValue("0");
      dexterityRacialBonus.setValue("0");
      constitutionRacialBonus.setValue("0");
      wisdomRacialBonus.setValue("0");

      for (int i = 0; i < temporaryCharacter.getFeats().size(); i++)
      {
        if (temporaryCharacter.getFeats().get(i).getName()
            .equals("ability Score Improvement"))
        {
          String[] abilitiesToImprove;
          String tempStr3 = temporaryCharacter.getFeats().get(i)
              .getDescription();
          abilitiesToImprove = tempStr3.split(", ");
          String tempStr1 = abilitiesToImprove[0];
          String tempStr2 = abilitiesToImprove[1];
          switch (tempStr1)
          {
            case "Strength":
            {
              abilityImprovement[0]++;
              break;
            }
            case "Intelligence":
            {
              abilityImprovement[3]++;
              break;
            }
            case "Dexterity":
            {
              abilityImprovement[1]++;
              break;
            }
            case "Constitution":
            {
              abilityImprovement[2]++;
              break;
            }
            case "Wisdom":
            {
              abilityImprovement[4]++;
              break;
            }
            case "Charisma":
            {
              abilityImprovement[5]++;
              break;
            }
          }
          switch (tempStr2)
          {
            case "Strength":
            {
              abilityImprovement[0]++;
              break;
            }
            case "Intelligence":
            {
              abilityImprovement[3]++;
              break;
            }
            case "Dexterity":
            {
              abilityImprovement[1]++;
              break;
            }
            case "Constitution":
            {
              abilityImprovement[2]++;
              break;
            }
            case "Wisdom":
            {
              abilityImprovement[4]++;
              break;
            }
            case "Charisma":
            {
              abilityImprovement[5]++;
              break;
            }
          }
        }
      }
      strengthImprovement.setValue(String.valueOf(abilityImprovement[0]));
      dexterityImprovement.setValue(String.valueOf(abilityImprovement[1]));
      constitutionImprovement.setValue(String.valueOf(abilityImprovement[2]));
      intelligenceAbilityImprovement
          .setValue(String.valueOf(abilityImprovement[3]));
      wisdomImprovement.setValue(String.valueOf(abilityImprovement[4]));
      charismaImprovement.setValue(String.valueOf(abilityImprovement[5]));
    }
    else
    {
      //<editor-fold desc="these are temporary">
      switch (temporaryCharacter.getRace().getName())
      {
        case "Dwarf":
        {
          racialModifiers[2] = racialModifiers[2] + 2;
          constitutionRacialBonus.setValue(String.valueOf(2));
          break;
        }
        case "Elf":
        {
          racialModifiers[1] = racialModifiers[1] + 2;
          dexterityRacialBonus.setValue(String.valueOf(2));
          break;
        }
        case "Halfling":
        {
          racialModifiers[1] = racialModifiers[1] + 2;
          dexterityRacialBonus.setValue(String.valueOf(2));
          break;
        }
        case "Human":
        {
          racialModifiers[0] = racialModifiers[0] + 1;
          racialModifiers[1] = racialModifiers[1] + 1;
          racialModifiers[2] = racialModifiers[2] + 1;
          racialModifiers[3] = racialModifiers[3] + 1;
          racialModifiers[4] = racialModifiers[4] + 1;
          racialModifiers[5] = racialModifiers[5] + 1;
          strengthRacialBonus.setValue(String.valueOf(1));
          constitutionRacialBonus.setValue(String.valueOf(1));
          dexterityRacialBonus.setValue(String.valueOf(1));
          intelligenceRacialBonus.setValue(String.valueOf(1));
          wisdomRacialBonus.setValue(String.valueOf(1));
          charismaRacialBonus.setValue(String.valueOf(1));
          break;
        }
        case "Dragonborn":
        {
          racialModifiers[0] = racialModifiers[0] + 2;
          racialModifiers[5] = racialModifiers[5] + 1;
          strengthRacialBonus.setValue(String.valueOf(2));
          charismaRacialBonus.setValue(String.valueOf(1));
          break;
        }
        case "Gnome":
        {
          racialModifiers[3] = racialModifiers[3] + 2;
          intelligenceRacialBonus.setValue(String.valueOf(2));
          break;
        }
        case "Half-Elf":
        {
          //THIS INFO IS WRONG
          racialModifiers[5] = racialModifiers[5] + 2;
          racialModifiers[1] = racialModifiers[1] + 1;
          racialModifiers[2] = racialModifiers[2] + 1;
          charismaRacialBonus.setValue(String.valueOf(2));
          dexterityRacialBonus.setValue(String.valueOf(1));
          constitutionRacialBonus.setValue(String.valueOf(1));
          break;
        }
        case "Half-Orc":
        {
          racialModifiers[0] = racialModifiers[0] + 2;
          racialModifiers[2] = racialModifiers[2] + 1;
          strengthRacialBonus.setValue(String.valueOf(2));
          constitutionRacialBonus.setValue(String.valueOf(1));
          break;
        }
        case "Tiefling":
        {
          racialModifiers[5] = racialModifiers[5] + 2;
          racialModifiers[3] = racialModifiers[3] + 1;
          charismaRacialBonus.setValue(String.valueOf(2));
          intelligenceRacialBonus.setValue(String.valueOf(1));
          break;
        }
        default:
          break;
      }
      //</editor-fold>

    }
    finalAbilities[0] =
        abilityImprovement[0] + insertedRolledAbilities[0] + racialModifiers[0];
    finalAbilities[1] =
        abilityImprovement[1] + insertedRolledAbilities[1] + racialModifiers[1];
    finalAbilities[2] =
        abilityImprovement[2] + insertedRolledAbilities[2] + racialModifiers[2];
    finalAbilities[3] =
        abilityImprovement[3] + insertedRolledAbilities[3] + racialModifiers[3];
    finalAbilities[4] =
        abilityImprovement[4] + insertedRolledAbilities[4] + racialModifiers[4];
    finalAbilities[5] =
        abilityImprovement[5] + insertedRolledAbilities[5] + racialModifiers[5];
    strengthImprovement.set(String.valueOf(abilityImprovement[0]));
    dexterityImprovement.set(String.valueOf(abilityImprovement[1]));
    constitutionImprovement.set(String.valueOf(abilityImprovement[2]));
    intelligenceAbilityImprovement.set(String.valueOf(abilityImprovement[3]));
    wisdomImprovement.set(String.valueOf(abilityImprovement[4]));
    charismaImprovement.set(String.valueOf(abilityImprovement[5]));
    strengthFinal.setValue(String.valueOf(finalAbilities[0]));
    dexterityFinal.setValue(String.valueOf(finalAbilities[1]));
    constitutionFinal.setValue(String.valueOf(finalAbilities[2]));
    intelligenceFinal.setValue(String.valueOf(finalAbilities[3]));
    wisdomFinal.setValue(String.valueOf(finalAbilities[4]));
    charismaFinal.setValue(String.valueOf(finalAbilities[5]));
    temporaryCharacter.setAbilitiesRolled(finalAbilities);
  }

  public void abilityScoreImprovement(String abilityOne, String abilityTwo)
  {
    String tempStr = abilityOne + ", " + abilityTwo;
    Feat newAbilityScoreImprovementFeat = new Feat("all",
        "ability Score Improvement", tempStr);
    ArrayList<Feat> tmp = temporaryCharacter.getFeats();
    tmp.add(newAbilityScoreImprovementFeat);
    temporaryCharacter.setFeats(tmp);
  }

  public StaticModel getStaticModel()
  {
    return staticModel;
  }

  public void removeFeat(Object object)
  {
    ArrayList<Feat> tmp = temporaryCharacter.getFeats();
    tmp.remove((Feat) object);
    featsAndFeatures = tmp;
    temporaryCharacter.setFeats(tmp);
  }

  public void addFeat(Object object)
  {
    ArrayList<Feat> tmp = temporaryCharacter.getFeats();
    tmp.add((Feat) object);
    temporaryCharacter.setFeats(tmp);
    featsAndFeatures = tmp;
  }

  public void addCharacterClass(Object object)
  {
    for (int i = 0; i < allClasses.size(); i++)
    {
      if (allClasses.get(i).getClassName().equals((String) object))
      {
        allClasses.get(i).getClassName().equals((String) object);
        raceDescription.setValue(allClasses.get(i).getDescription());
        characterClasses.add(allClasses.get(i));
        temporaryCharacter.setCharacterClass(characterClasses);
        characterClassesName.add((String) object);
      }
    }
    recalculateAvailableFeats();
  }

  public void removeCharacterClass(Object object)
  {
    for (int i = 0; i < characterClasses.size(); i++)
    {
      if (characterClasses.get(i).getClassName().equals((String) object))
      {
        characterClasses.remove(i);
        characterClassesName.remove(i);
      }
    }
    recalculateAvailableFeats();
  }

  public void changeClassDesc(Object object)
  {
    for (int i = 0; i < allClasses.size(); i++)
    {
      allClasses.get(i).getClassName().equals((String) object);
      raceDescription.setValue(allClasses.get(i).getDescription());
    }
  }

  public void changeFeatDescription(Object object)
  {
    featToChooseDescription.setValue(((Feat) object).getDescription());
  }

  public String getRaceDescription()
  {
    return raceDescription.get();
  }

  public StringProperty raceDescriptionProperty()
  {
    return raceDescription;
  }

  public ObservableList<String> getCharacterClassesName()
  {
    return characterClassesName;
  }

  public ObservableList<String> getAllCharacterClassesNames()
  {
    return allCharacterClassesNames;
  }

  public void addTreasure(String treasure)
  {
    treasures.add(treasure);
    ArrayList<String> tmp = temporaryCharacter.getTreasures();
    tmp.add(treasure);
    temporaryCharacter.setTreasures(tmp);
  }

  public void setBackground(Object object)
  {
    characterBackground = (Background) object;
    temporaryCharacter.setBackground(((Background) object).toString());
    backgroundDescription.setValue(characterBackground.getDescription());
  }
  public void setAlignment(Object object)
  {
    temporaryCharacter.setAlignment((String) object);
  }

  public ArrayList<Background> getBackgrounds()
  {
    return backgrounds;
  }

  public String getBackgroundDescription()
  {
    return backgroundDescription.get();
  }

  public StringProperty backgroundDescriptionProperty()
  {
    return backgroundDescription;
  }

  public Background getCharacterBackground()
  {
    return characterBackground;
  }

  public void removeTreasure(String treasure)
  {
    treasures.remove(treasure);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < treasures.size(); i++)
    {
      tmp.add(treasures.get(i));
    }
    temporaryCharacter.setTreasures(tmp);
  }

  public void removePersonalityTrait(String personalityTrait)
  {
    personalityTraits.remove(personalityTrait);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < personalityTraits.size(); i++)
    {
      tmp.add(personalityTraits.get(i));
    }
    temporaryCharacter.setPersonalityTraits(tmp);
  }

  public void addPersonalityTrait(String personalityTrait)
  {
    personalityTraits.add(personalityTrait);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < personalityTraits.size(); i++)
    {
      tmp.add(personalityTraits.get(i));
    }
    temporaryCharacter.setPersonalityTraits(tmp);
  }

  public void removeIdeal(String ideal)
  {
    ideals.remove(ideal);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < ideals.size(); i++)
    {
      tmp.add(ideals.get(i));
    }
    temporaryCharacter.setIdeals(tmp);
  }

  public void addIdeal(String ideal)
  {
    ideals.add(ideal);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < ideals.size(); i++)
    {
      tmp.add(ideals.get(i));
    }
    temporaryCharacter.setIdeals(tmp);
  }

  public void removeFlaw(String flaw)
  {
    flaws.remove(flaw);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < flaws.size(); i++)
    {
      tmp.add(flaws.get(i));
    }
    temporaryCharacter.setFlaws(tmp);
  }

  public void addFlaw(String flaw)
  {
    flaws.add(flaw);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < flaws.size(); i++)
    {
      tmp.add(flaws.get(i));
    }
    temporaryCharacter.setFlaws(tmp);
  }

  public void removeBond(String bond)
  {
    bonds.remove(bond);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < bonds.size(); i++)
    {
      tmp.add(bonds.get(i));
    }
    temporaryCharacter.setBonds(tmp);
  }

  public void addBond(String bond)
  {
    bonds.add(bond);
    ArrayList<String> tmp = new ArrayList<>();
    for (int i = 0; i < bonds.size(); i++)
    {
      tmp.add(bonds.get(i));
    }
    temporaryCharacter.setBonds(tmp);
  }

  public void setSkills(boolean[] shkills)
  {
    skills = shkills;
    ArrayList<Proficiency> tmp = temporaryCharacter.getProficiencies();
    for (Proficiency p : tmp)
    {
      if (p.getName().toLowerCase().equalsIgnoreCase("Acrobatics") || p
          .getName().toLowerCase().equalsIgnoreCase("Animal Handling") || p
          .getName().toLowerCase().equalsIgnoreCase("Arcana") || p.getName()
          .toLowerCase().equalsIgnoreCase("Athletics") || p.getName()
          .toLowerCase().equalsIgnoreCase("Deception") || p.getName()
          .toLowerCase().equalsIgnoreCase("History") || p.getName()
          .toLowerCase().equalsIgnoreCase("Insight") || p.getName()
          .toLowerCase().equalsIgnoreCase("Intimidation") || p.getName()
          .toLowerCase().equalsIgnoreCase("Investigation") || p.getName()
          .toLowerCase().equalsIgnoreCase("Medicine") || p.getName()
          .toLowerCase().equalsIgnoreCase("Nature") || p.getName().toLowerCase()
          .equalsIgnoreCase("Perception") || p.getName().toLowerCase()
          .equalsIgnoreCase("Performance") || p.getName().toLowerCase()
          .equalsIgnoreCase("Persuasion") || p.getName().toLowerCase()
          .equalsIgnoreCase("Religion") || p.getName().toLowerCase()
          .equalsIgnoreCase("Sleight of Hand") || p.getName().toLowerCase()
          .equalsIgnoreCase("Stealth") || p.getName().toLowerCase()
          .equalsIgnoreCase("Survival"))
      {
        tmp.remove(p);
      }
    }
    if (shkills[0])
    {
      tmp.add(new Proficiency("Acrobatics", "", "", 0));
    }
    else if (shkills[1])
    {
      tmp.add(new Proficiency("Animal Handling", "", "", 0));
    }
    else if (shkills[2])
    {
      tmp.add(new Proficiency("Arcana", "", "", 0));
    }
    else if (shkills[3])
    {
      tmp.add(new Proficiency("Athletics", "", "", 0));
    }
    else if (shkills[4])
    {
      tmp.add(new Proficiency("Deception", "", "", 0));
    }
    else if (shkills[5])
    {
      tmp.add(new Proficiency("History", "", "", 0));
    }
    else if (shkills[6])
    {
      tmp.add(new Proficiency("Insight", "", "", 0));
    }
    else if (shkills[7])
    {
      tmp.add(new Proficiency("Intimidation", "", "", 0));
    }
    else if (shkills[8])
    {
      tmp.add(new Proficiency("Investigation", "", "", 0));
    }
    else if (shkills[9])
    {
      tmp.add(new Proficiency("Medicine", "", "", 0));
    }
    else if (shkills[10])
    {
      tmp.add(new Proficiency("Nature", "", "", 0));
    }
    else if (shkills[11])
    {
      tmp.add(new Proficiency("Perception", "", "", 0));
    }
    else if (shkills[12])
    {
      tmp.add(new Proficiency("Performance", "", "", 0));
    }
    else if (shkills[13])
    {
      tmp.add(new Proficiency("Persuasion", "", "", 0));
    }
    else if (shkills[14])
    {
      tmp.add(new Proficiency("Religion", "", "", 0));
    }
    else if (shkills[15])
    {
      tmp.add(new Proficiency("Sleight of Hand", "", "", 0));
    }
    else if (shkills[16])
    {
      tmp.add(new Proficiency("Stealth", "", "", 0));
    }
    else if (shkills[17])
    {
      tmp.add(new Proficiency("Survival", "", "", 0));
    }
    temporaryCharacter.setProficiencies(tmp);
  }

  public boolean[] getSkills()
  {
    return skills;
  }

  public void setLanguage(String langs)
  {
    ArrayList<Proficiency> tmp = temporaryCharacter.getProficiencies();
    {
      for (Proficiency p : tmp)
      {
        if (p.getType().contains("language"))
        {
          tmp.remove(p);
        }
      }
    }
    //FORGIVE ME
    //Im using the origin as the description
    tmp.add(new Proficiency("Languages", "Language", langs, 0));
    temporaryCharacter.setProficiencies(tmp);
  }

  public void saveCharacter()
  {
    temporaryCharacter.setBackstory(backstoryF.getValue());
    //add lang here
    if (armorClass.getValue() == null)
    {
      temporaryCharacter.setArmorClass(0);
    }
    else
      temporaryCharacter.setArmorClass(Integer.parseInt(armorClass.getValue()));
    //Speed here:temporaryCharacter.setspeed
    if (xp.getValue() == null)
    {
      temporaryCharacter.setXp(0);
    }
    else
      temporaryCharacter.setXp(Integer.parseInt(xp.getValue()));
    temporaryCharacter.setName(nameF.getName());
    System.out.println(temporaryCharacter.getName()+"BBBBBBBBBB"+nameF.getValue());
    temporaryCharacter.setPhysicalCharacteristics(physicalCharacteristicsF.toString());
    temporaryCharacter.setBackstory(backstoryF.toString());
    temporaryCharacter.setAlliesAndOrganizations(alliesAndOrganizationsF.toString());
    //these are the last
    character = temporaryCharacter;
    model.setCharacter(character);
  }

  @Override public void addListener(String eventName,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(eventName, listener);

  }

  @Override public void removeListener(String eventName,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(eventName, listener);
  }
}
