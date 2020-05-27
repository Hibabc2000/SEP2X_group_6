package system.views.characterSheet;

import javafx.beans.property.StringProperty;
import system.model.businessModel.Character;
import system.model.businessModel.*;
import system.model.businessModel.staticModel.Ability;
import system.model.businessModel.staticModel.Skill;
import system.model.businessModel.staticModel.StaticModel;
import system.model.characterClasses.*;
import system.model.characterManagement.CharacterManagementModel;

import java.beans.PropertyChangeEvent;

public class CharacterSheetViewModel
{

  private StringProperty strengthModifier;
  private StringProperty strength;
  private StringProperty dexterityModifier;
  private StringProperty dexterity;
  private StringProperty constitutionModifier;
  private StringProperty constitution;
  private StringProperty intelligenceModifier;
  private StringProperty intelligence;
  private StringProperty wisdomModifier;
  private StringProperty wisdom;
  private StringProperty charismaModifier;
  private StringProperty charisma;
  private StringProperty acrobaticsModifier;
  private StringProperty animalHandlingModifier;
  private StringProperty arcanaModifier;
  private StringProperty athleticsModifier;
  private StringProperty deceptionModifier;
  private StringProperty historyModifier;
  private StringProperty insightModifier;
  private StringProperty intimidationModifier;
  private StringProperty investigationModifier;
  private StringProperty medicineModifier;
  private StringProperty natureModifier;
  private StringProperty perceptionModifier;
  private StringProperty performanceModifier;
  private StringProperty persuasionModifier;
  private StringProperty religionModifier;
  private StringProperty sleightOfHandModifier;
  private StringProperty stealthModifier;
  private StringProperty survivalModifier;
  private StringProperty characterName;
  private StringProperty characterClass;
  private StringProperty characterRace;
  private StringProperty characterAlignment;
  private StringProperty characterHP;
  private StringProperty characterHPMax;
  private StringProperty characterLevel;
  private StringProperty xpCount;
  private StringProperty strengthSavingThrow;
  private StringProperty constitutionSavingThrow;
  private StringProperty dexteritySavingThrow;
  private StringProperty intelligenceSavingThrow;
  private StringProperty wisdomSavingThrow;
  private StringProperty charismaSavingThrow;
  private StringProperty proficiencyBonus;
  private StringProperty passiveWisdom;
  private StringProperty speed;
  private StringProperty armorClass;
  private int armorClassInt;
  private StringProperty knownSpellAmount;
  private StringProperty preparedSpellAmount;
  private StringProperty addItemSelectedItemName;
  private StringProperty selectedItemFromInventoryName;
  private StringProperty platinumPiece;
  private StringProperty copperPiece;
  private StringProperty electrumPiece;
  private StringProperty silverPiece;
  private StringProperty goldPiece;
  private StringProperty platinumPieceOne;
  private StringProperty goldPieceOne;
  private StringProperty electrumPieceOne;
  private StringProperty silverPieceOne;
  private StringProperty copperPieceOne;
  ///////////////////////////////////////////////////////
  private StringProperty hpChangeAmount;
  private StringProperty selectedItemFromInventoryAmount;
  private StringProperty selectedItemFromAddItemAmountStringProperty;
  private StringProperty changePlatinumAmountStringProperty;
  private StringProperty changeGoldAmountStringProperty;
  private StringProperty changeElectrumAmountStringProperty;
  private StringProperty changeSilverAmountStringProperty;
  private StringProperty changeCopperAmountStringProperty;
  ///////////////////////////////////////////////////////////

  private Character sheetCharacter;

  private CharacterManagementModel model;

  public CharacterSheetViewModel(CharacterManagementModel model1)
  {
    model = model1;
    model.addListener("characterToSheetViewModel", this::setCharacter);
  }

  private void setCharacter(PropertyChangeEvent propertyChangeEvent)
  {
    sheetCharacter = (Character) propertyChangeEvent.getNewValue();
  }

  private void calculateValues()
  {
    strength.setValue(String.valueOf(sheetCharacter.getAbilities()[0]));
    dexterity.setValue(String.valueOf(sheetCharacter.getAbilities()[1]));
    constitution.setValue(String.valueOf(sheetCharacter.getAbilities()[2]));
    intelligence.setValue(String.valueOf(sheetCharacter.getAbilities()[3]));
    wisdom.setValue(String.valueOf(sheetCharacter.getAbilities()[4]));
    charisma.setValue(String.valueOf(sheetCharacter.getAbilities()[5]));
    //ability modifiers

    //strength

    if (sheetCharacter.getAbilities()[0] == 10
        || sheetCharacter.getAbilities()[0] == 11)
    {
      strengthModifier.setValue(String.valueOf(0));
    }
    else if (sheetCharacter.getAbilities()[0] == 12
        || sheetCharacter.getAbilities()[0] == 13)
    {
      strengthModifier.setValue(String.valueOf(1));
    }
    else if (sheetCharacter.getAbilities()[0] == 14
        || sheetCharacter.getAbilities()[0] == 15)
    {
      strengthModifier.setValue(String.valueOf(2));
    }
    else if (sheetCharacter.getAbilities()[0] == 16
        || sheetCharacter.getAbilities()[0] == 17)
    {
      strengthModifier.setValue(String.valueOf(3));
    }
    else if (sheetCharacter.getAbilities()[0] == 18
        || sheetCharacter.getAbilities()[0] == 19)
    {
      strengthModifier.setValue(String.valueOf(4));
    }
    else if (sheetCharacter.getAbilities()[0] == 20
        || sheetCharacter.getAbilities()[0] == 21)
    {
      strengthModifier.setValue(String.valueOf(5));
    }
    else if (sheetCharacter.getAbilities()[0] == 22
        || sheetCharacter.getAbilities()[0] == 23)
    {
      strengthModifier.setValue(String.valueOf(6));
    }
    else if (sheetCharacter.getAbilities()[0] == 24)
    {
      strengthModifier.setValue(String.valueOf(7));
    }
    else if (sheetCharacter.getAbilities()[0] == 1)
    {
      strengthModifier.setValue(String.valueOf(-5));
    }
    else if (sheetCharacter.getAbilities()[0] == 2
        || sheetCharacter.getAbilities()[0] == 3)
    {
      strengthModifier.setValue(String.valueOf(-4));
    }
    else if (sheetCharacter.getAbilities()[0] == 4
        || sheetCharacter.getAbilities()[0] == 5)
    {
      strengthModifier.setValue(String.valueOf(-3));
    }
    else if (sheetCharacter.getAbilities()[0] == 6
        || sheetCharacter.getAbilities()[0] == 7)
    {
      strengthModifier.setValue(String.valueOf(-2));
    }
    else if (sheetCharacter.getAbilities()[0] == 8
        || sheetCharacter.getAbilities()[0] == 9)
    {
      strengthModifier.setValue(String.valueOf(-1));
    }

    //dexterity

    if (sheetCharacter.getAbilities()[1] == 10
        || sheetCharacter.getAbilities()[1] == 11)
    {
      dexterityModifier.setValue(String.valueOf(0));
    }
    else if (sheetCharacter.getAbilities()[1] == 12
        || sheetCharacter.getAbilities()[1] == 13)
    {
      dexterityModifier.setValue(String.valueOf(1));
    }
    else if (sheetCharacter.getAbilities()[1] == 14
        || sheetCharacter.getAbilities()[1] == 15)
    {
      dexterityModifier.setValue(String.valueOf(2));
    }
    else if (sheetCharacter.getAbilities()[1] == 16
        || sheetCharacter.getAbilities()[1] == 17)
    {
      dexterityModifier.setValue(String.valueOf(3));
    }
    else if (sheetCharacter.getAbilities()[1] == 18
        || sheetCharacter.getAbilities()[1] == 19)
    {
      dexterityModifier.setValue(String.valueOf(4));
    }
    else if (sheetCharacter.getAbilities()[1] == 20
        || sheetCharacter.getAbilities()[1] == 21)
    {
      dexterityModifier.setValue(String.valueOf(5));
    }
    else if (sheetCharacter.getAbilities()[1] == 22
        || sheetCharacter.getAbilities()[1] == 23)
    {
      dexterityModifier.setValue(String.valueOf(6));
    }
    else if (sheetCharacter.getAbilities()[1] == 24)
    {
      dexterityModifier.setValue(String.valueOf(7));
    }
    else if (sheetCharacter.getAbilities()[1] == 1)
    {
      dexterityModifier.setValue(String.valueOf(-5));
    }
    else if (sheetCharacter.getAbilities()[1] == 2
        || sheetCharacter.getAbilities()[1] == 3)
    {
      dexterityModifier.setValue(String.valueOf(-4));
    }
    else if (sheetCharacter.getAbilities()[1] == 4
        || sheetCharacter.getAbilities()[1] == 5)
    {
      dexterityModifier.setValue(String.valueOf(-3));
    }
    else if (sheetCharacter.getAbilities()[1] == 6
        || sheetCharacter.getAbilities()[1] == 7)
    {
      dexterityModifier.setValue(String.valueOf(-2));
    }
    else if (sheetCharacter.getAbilities()[1] == 8
        || sheetCharacter.getAbilities()[1] == 9)
    {
      dexterityModifier.setValue(String.valueOf(-1));
    }

    //constitution

    if (sheetCharacter.getAbilities()[2] == 10
        || sheetCharacter.getAbilities()[2] == 11)
    {
      constitutionModifier.setValue(String.valueOf(0));
    }
    else if (sheetCharacter.getAbilities()[2] == 12
        || sheetCharacter.getAbilities()[2] == 13)
    {
      constitutionModifier.setValue(String.valueOf(1));
    }
    else if (sheetCharacter.getAbilities()[2] == 14
        || sheetCharacter.getAbilities()[2] == 15)
    {
      constitutionModifier.setValue(String.valueOf(2));
    }
    else if (sheetCharacter.getAbilities()[2] == 16
        || sheetCharacter.getAbilities()[2] == 17)
    {
      constitutionModifier.setValue(String.valueOf(3));
    }
    else if (sheetCharacter.getAbilities()[2] == 18
        || sheetCharacter.getAbilities()[2] == 19)
    {
      constitutionModifier.setValue(String.valueOf(4));
    }
    else if (sheetCharacter.getAbilities()[2] == 20
        || sheetCharacter.getAbilities()[2] == 21)
    {
      constitutionModifier.setValue(String.valueOf(5));
    }
    else if (sheetCharacter.getAbilities()[2] == 22
        || sheetCharacter.getAbilities()[2] == 23)
    {
      constitutionModifier.setValue(String.valueOf(6));
    }
    else if (sheetCharacter.getAbilities()[2] == 24)
    {
      constitutionModifier.setValue(String.valueOf(7));
    }
    else if (sheetCharacter.getAbilities()[2] == 1)
    {
      constitutionModifier.setValue(String.valueOf(-5));
    }
    else if (sheetCharacter.getAbilities()[2] == 2
        || sheetCharacter.getAbilities()[2] == 3)
    {
      constitutionModifier.setValue(String.valueOf(-4));
    }
    else if (sheetCharacter.getAbilities()[2] == 4
        || sheetCharacter.getAbilities()[2] == 5)
    {
      constitutionModifier.setValue(String.valueOf(-3));
    }
    else if (sheetCharacter.getAbilities()[2] == 6
        || sheetCharacter.getAbilities()[2] == 7)
    {
      constitutionModifier.setValue(String.valueOf(-2));
    }
    else if (sheetCharacter.getAbilities()[2] == 8
        || sheetCharacter.getAbilities()[2] == 9)
    {
      constitutionModifier.setValue(String.valueOf(-1));
    }

    //intelligence

    if (sheetCharacter.getAbilities()[3] == 10
        || sheetCharacter.getAbilities()[3] == 11)
    {
      intelligenceModifier.setValue(String.valueOf(0));
    }
    else if (sheetCharacter.getAbilities()[3] == 12
        || sheetCharacter.getAbilities()[3] == 13)
    {
      intelligenceModifier.setValue(String.valueOf(1));
    }
    else if (sheetCharacter.getAbilities()[3] == 14
        || sheetCharacter.getAbilities()[3] == 15)
    {
      intelligenceModifier.setValue(String.valueOf(2));
    }
    else if (sheetCharacter.getAbilities()[3] == 16
        || sheetCharacter.getAbilities()[3] == 17)
    {
      intelligenceModifier.setValue(String.valueOf(3));
    }
    else if (sheetCharacter.getAbilities()[3] == 18
        || sheetCharacter.getAbilities()[3] == 19)
    {
      intelligenceModifier.setValue(String.valueOf(4));
    }
    else if (sheetCharacter.getAbilities()[3] == 20
        || sheetCharacter.getAbilities()[3] == 21)
    {
      intelligenceModifier.setValue(String.valueOf(5));
    }
    else if (sheetCharacter.getAbilities()[3] == 22
        || sheetCharacter.getAbilities()[3] == 23)
    {
      intelligenceModifier.setValue(String.valueOf(6));
    }
    else if (sheetCharacter.getAbilities()[3] == 24)
    {
      intelligenceModifier.setValue(String.valueOf(7));
    }
    else if (sheetCharacter.getAbilities()[3] == 1)
    {
      intelligenceModifier.setValue(String.valueOf(-5));
    }
    else if (sheetCharacter.getAbilities()[3] == 2
        || sheetCharacter.getAbilities()[3] == 3)
    {
      intelligenceModifier.setValue(String.valueOf(-4));
    }
    else if (sheetCharacter.getAbilities()[3] == 4
        || sheetCharacter.getAbilities()[3] == 5)
    {
      intelligenceModifier.setValue(String.valueOf(-3));
    }
    else if (sheetCharacter.getAbilities()[3] == 6
        || sheetCharacter.getAbilities()[3] == 7)
    {
      intelligenceModifier.setValue(String.valueOf(-2));
    }
    else if (sheetCharacter.getAbilities()[3] == 8
        || sheetCharacter.getAbilities()[3] == 9)
    {
      intelligenceModifier.setValue(String.valueOf(-1));
    }

    //wisdom

    if (sheetCharacter.getAbilities()[4] == 10
        || sheetCharacter.getAbilities()[4] == 11)
    {
      wisdomModifier.setValue(String.valueOf(0));
    }
    else if (sheetCharacter.getAbilities()[4] == 12
        || sheetCharacter.getAbilities()[4] == 13)
    {
      wisdomModifier.setValue(String.valueOf(1));
    }
    else if (sheetCharacter.getAbilities()[4] == 14
        || sheetCharacter.getAbilities()[4] == 15)
    {
      wisdomModifier.setValue(String.valueOf(2));
    }
    else if (sheetCharacter.getAbilities()[4] == 16
        || sheetCharacter.getAbilities()[4] == 17)
    {
      wisdomModifier.setValue(String.valueOf(3));
    }
    else if (sheetCharacter.getAbilities()[4] == 18
        || sheetCharacter.getAbilities()[4] == 19)
    {
      wisdomModifier.setValue(String.valueOf(4));
    }
    else if (sheetCharacter.getAbilities()[4] == 20
        || sheetCharacter.getAbilities()[4] == 21)
    {
      wisdomModifier.setValue(String.valueOf(5));
    }
    else if (sheetCharacter.getAbilities()[4] == 22
        || sheetCharacter.getAbilities()[4] == 23)
    {
      wisdomModifier.setValue(String.valueOf(6));
    }
    else if (sheetCharacter.getAbilities()[4] == 24)
    {
      wisdomModifier.setValue(String.valueOf(7));
    }
    else if (sheetCharacter.getAbilities()[4] == 1)
    {
      wisdomModifier.setValue(String.valueOf(-5));
    }
    else if (sheetCharacter.getAbilities()[4] == 2
        || sheetCharacter.getAbilities()[4] == 3)
    {
      wisdomModifier.setValue(String.valueOf(-4));
    }
    else if (sheetCharacter.getAbilities()[4] == 4
        || sheetCharacter.getAbilities()[4] == 5)
    {
      wisdomModifier.setValue(String.valueOf(-3));
    }
    else if (sheetCharacter.getAbilities()[4] == 6
        || sheetCharacter.getAbilities()[4] == 7)
    {
      wisdomModifier.setValue(String.valueOf(-2));
    }
    else if (sheetCharacter.getAbilities()[4] == 8
        || sheetCharacter.getAbilities()[4] == 9)
    {
      wisdomModifier.setValue(String.valueOf(-1));
    }

    //charisma

    if (sheetCharacter.getAbilities()[5] == 10
        || sheetCharacter.getAbilities()[5] == 11)
    {
      charismaModifier.setValue(String.valueOf(0));
    }
    else if (sheetCharacter.getAbilities()[5] == 12
        || sheetCharacter.getAbilities()[5] == 13)
    {
      charismaModifier.setValue(String.valueOf(1));
    }
    else if (sheetCharacter.getAbilities()[5] == 14
        || sheetCharacter.getAbilities()[5] == 15)
    {
      charismaModifier.setValue(String.valueOf(2));
    }
    else if (sheetCharacter.getAbilities()[5] == 16
        || sheetCharacter.getAbilities()[5] == 17)
    {
      charismaModifier.setValue(String.valueOf(3));
    }
    else if (sheetCharacter.getAbilities()[5] == 18
        || sheetCharacter.getAbilities()[5] == 19)
    {
      charismaModifier.setValue(String.valueOf(4));
    }
    else if (sheetCharacter.getAbilities()[5] == 20
        || sheetCharacter.getAbilities()[5] == 21)
    {
      charismaModifier.setValue(String.valueOf(5));
    }
    else if (sheetCharacter.getAbilities()[5] == 22
        || sheetCharacter.getAbilities()[5] == 23)
    {
      charismaModifier.setValue(String.valueOf(6));
    }
    else if (sheetCharacter.getAbilities()[5] == 24)
    {
      charismaModifier.setValue(String.valueOf(7));
    }
    else if (sheetCharacter.getAbilities()[5] == 1)
    {
      charismaModifier.setValue(String.valueOf(-5));
    }
    else if (sheetCharacter.getAbilities()[5] == 2
        || sheetCharacter.getAbilities()[5] == 3)
    {
      charismaModifier.setValue(String.valueOf(-4));
    }
    else if (sheetCharacter.getAbilities()[5] == 4
        || sheetCharacter.getAbilities()[5] == 5)
    {
      charismaModifier.setValue(String.valueOf(-3));
    }
    else if (sheetCharacter.getAbilities()[5] == 6
        || sheetCharacter.getAbilities()[5] == 7)
    {
      charismaModifier.setValue(String.valueOf(-2));
    }
    else if (sheetCharacter.getAbilities()[5] == 8
        || sheetCharacter.getAbilities()[5] == 9)
    {
      charismaModifier.setValue(String.valueOf(-1));
    }

    //proficiency bonus

    if (sheetCharacter.getLevel() <= 4)
    {
      proficiencyBonus.setValue(String.valueOf(2));
    }
    else if (sheetCharacter.getLevel() <= 8)
    {
      proficiencyBonus.setValue(String.valueOf(3));
    }
    else if (sheetCharacter.getLevel() <= 12)
    {
      proficiencyBonus.setValue(String.valueOf(4));
    }
    else if (sheetCharacter.getLevel() <= 16)
    {
      proficiencyBonus.setValue(String.valueOf(5));
    }
    else
    {
      proficiencyBonus.setValue(String.valueOf(6));
    }

    //main non-calculated setters (eg. name etc.)
    characterName.setValue(sheetCharacter.getName());
    characterAlignment.setValue(sheetCharacter.getAlignment());
    characterRace.setValue(sheetCharacter.getRace().getName());
    characterLevel.setValue(String.valueOf(sheetCharacter.getLevel()));
    String classes = "";
    if (sheetCharacter.getCharacterClass().size() == 1)
    {
      classes = sheetCharacter.getCharacterClass().get(0).getClassName();
    }
    else
    {
      for (int i = 0; i < sheetCharacter.getCharacterClass().size(); i++)
      {
        classes += sheetCharacter.getCharacterClass().get(i).getClassName();
        if (i != sheetCharacter.getCharacterClass().size() - 1)
        {
          classes += ", ";
        }
      }
    }
    characterClass.setValue(classes);
    int maxHP = calculateMaxHP();
    characterHPMax.setValue(String.valueOf(maxHP));
    xpCount.setValue(String.valueOf(sheetCharacter.getXp()));

    //speed difference based on race

    if (sheetCharacter.getRace().getTraits().contains("25 feet"))
    {
      speed.setValue(String.valueOf(25));
    }
    else
      speed.setValue(String.valueOf(30));

    //armor class calculation

    for (Item i : sheetCharacter.getEquipmentList())
    {
      if (i.isEquipped() && i.getGameItem() instanceof EquipmentArmor)
      {
        armorClassInt = ((EquipmentArmor) i.getGameItem()).getArmorClass();
        if (((EquipmentArmor) i.getGameItem()).getDexMod().equals("full"))
        {
          armorClassInt += Integer.parseInt(dexterityModifier.getValue());
        }
        else if (((EquipmentArmor) i.getGameItem()).getDexMod()
            .equals("limited"))
        {
          int temp = Integer.parseInt(dexterityModifier.getValue());
          if (temp <= 2)
          {
            armorClassInt += temp;
          }
          else
            armorClassInt += 2;
        }
      }
      else if (i.isEquipped() && i.getGameItem().getName().toLowerCase()
          .equals("shield"))
      {
        armorClassInt += 2;
      }
    }
    armorClass.setValue(String.valueOf(armorClassInt));
    setSavingThrows();
    setSkills();
    parseProficiencies();
  }

  private void setSkills()
  {
    for (Proficiency p : sheetCharacter.getProficiencies())
    {
      StaticModel staticModel = new StaticModel();
      for (Skill s : staticModel.getSkills())
      {
        if (p.getName().toLowerCase().contains(s.getName().toLowerCase()))
        {
          if (s.getName().equals("Acrobatics"))
          {
            acrobaticsModifier.setValue(
                String.valueOf(Integer.parseInt(dexterityModifier.toString())));
          }
          else if (s.getName().equals("Animal Handling"))
          {
            animalHandlingModifier.setValue(
                String.valueOf(Integer.parseInt(wisdomModifier.toString())));
          }
          else if (s.getName().equals("Arcana"))
          {
            arcanaModifier.setValue(String
                .valueOf(Integer.parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Athletics"))
          {
            athleticsModifier.setValue(
                String.valueOf(Integer.parseInt(strengthModifier.toString())));
          }
          else if (s.getName().equals("Deception"))
          {
            deceptionModifier.setValue(
                String.valueOf(Integer.parseInt(charismaModifier.toString())));
          }
          else if (s.getName().equals("History"))
          {
            historyModifier.setValue(String
                .valueOf(Integer.parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Insight"))
          {
            insightModifier.setValue(
                String.valueOf(Integer.parseInt(wisdomModifier.toString())));
          }
          else if (s.getName().equals("Intimidation"))
          {
            intimidationModifier.setValue(
                String.valueOf(Integer.parseInt(charismaModifier.toString())));
          }
          else if (s.getName().equals("Investigation"))
          {
            investigationModifier.setValue(String
                .valueOf(Integer.parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Medicine"))
          {
            medicineModifier.setValue(
                String.valueOf(Integer.parseInt(wisdomModifier.toString())));
          }
          else if (s.getName().equals("Nature"))
          {
            natureModifier.setValue(String
                .valueOf(Integer.parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Perception"))
          {
            perceptionModifier.setValue(
                String.valueOf(Integer.parseInt(wisdomModifier.toString())));
          }
          else if (s.getName().equals("Performance"))
          {
            performanceModifier.setValue(
                String.valueOf(Integer.parseInt(charismaModifier.toString())));
          }
          else if (s.getName().equals("Persuasion"))
          {
            persuasionModifier.setValue(
                String.valueOf(Integer.parseInt(charismaModifier.toString())));
          }
          else if (s.getName().equals("Religion"))
          {
            religionModifier.setValue(String
                .valueOf(Integer.parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Sleight of Hand"))
          {
            sleightOfHandModifier.setValue(
                String.valueOf(Integer.parseInt(dexterityModifier.toString())));
          }
          else if (s.getName().equals("Stealth"))
          {
            stealthModifier.setValue(
                String.valueOf(Integer.parseInt(dexterityModifier.toString())));
          }
          else if (s.getName().equals("Survival"))
          {
            survivalModifier.setValue(
                String.valueOf(Integer.parseInt(wisdomModifier.toString())));
          }
        }
      }
    }
  }

  private void setSavingThrows()
  {
    StaticModel staticModel = sheetCharacter.getStaticModel();
    for (Ability a : staticModel.getAbilities())
    {
      if (a.getName().toLowerCase().equals("strength"))
      {
        double strSave = Integer.parseInt(String.valueOf(strengthModifier));
        strengthSavingThrow.setValue(String.valueOf(strSave));
      }
      else if (a.getName().toLowerCase().equals("dexterity"))
      {
        double dexSave = Integer.parseInt(String.valueOf(dexterityModifier));
        strengthSavingThrow.setValue(String.valueOf(dexSave));
      }
      else if (a.getName().toLowerCase().equals("constitution"))
      {
        double conSave = Integer.parseInt(String.valueOf(constitutionModifier));
        strengthSavingThrow.setValue(String.valueOf(conSave));
      }
      else if (a.getName().toLowerCase().equals("intelligence"))
      {
        double intSave = Integer.parseInt(String.valueOf(intelligenceModifier));
        strengthSavingThrow.setValue(String.valueOf(intSave));
      }
      else if (a.getName().toLowerCase().equals("wisdom"))
      {
        double wisSave = Integer.parseInt(String.valueOf(wisdomModifier));
        strengthSavingThrow.setValue(String.valueOf(wisSave));
      }
      else if (a.getName().toLowerCase().equals("charisma"))
      {
        double chaSave = Integer.parseInt(String.valueOf(charismaModifier));
        strengthSavingThrow.setValue(String.valueOf(chaSave));
      }
    }
  }

  private int calculateMaxHP()
  {
    int i = 0;
    for (CharacterClass c : sheetCharacter.getCharacterClass())
    {
      //add level 1 base HP
      i += c.getHitDiceType();
    }
    i += (Integer.parseInt(constitutionModifier.getValue()) * sheetCharacter
        .getLevel());
    i += sheetCharacter.getRolledHp();
    return i;
  }

  public void parseProficiencies() //DO NOT TOUCH
  {
    for (Proficiency p : sheetCharacter.getProficiencies())
    {
      StaticModel staticModel = new StaticModel();
      for (Skill s : staticModel.getSkills())
      {
        if (p.getName().toLowerCase().contains(s.getName().toLowerCase()))
        {
          if (s.getName().equals("Acrobatics"))
          {
            acrobaticsModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(dexterityModifier.toString())));
          }
          else if (s.getName().equals("Animal Handling"))
          {
            animalHandlingModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(wisdomModifier.toString())));
          }
          else if (s.getName().equals("Arcana"))
          {
            arcanaModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Athletics"))
          {
            athleticsModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(strengthModifier.toString())));
          }
          else if (s.getName().equals("Deception"))
          {
            deceptionModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(charismaModifier.toString())));
          }
          else if (s.getName().equals("History"))
          {
            historyModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Insight"))
          {
            insightModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(wisdomModifier.toString())));
          }
          else if (s.getName().equals("Intimidation"))
          {
            intimidationModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(charismaModifier.toString())));
          }
          else if (s.getName().equals("Investigation"))
          {
            investigationModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Medicine"))
          {
            medicineModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(wisdomModifier.toString())));
          }
          else if (s.getName().equals("Nature"))
          {
            natureModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Perception"))
          {
            perceptionModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(wisdomModifier.toString())));
          }
          else if (s.getName().equals("Performance"))
          {
            performanceModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(charismaModifier.toString())));
          }
          else if (s.getName().equals("Persuasion"))
          {
            persuasionModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(charismaModifier.toString())));
          }
          else if (s.getName().equals("Religion"))
          {
            religionModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(intelligenceModifier.toString())));
          }
          else if (s.getName().equals("Sleight of Hand"))
          {
            sleightOfHandModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(dexterityModifier.toString())));
          }
          else if (s.getName().equals("Stealth"))
          {
            stealthModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(dexterityModifier.toString())));
          }
          else if (s.getName().equals("Survival"))
          {
            survivalModifier.setValue(String.valueOf(
                Integer.parseInt(proficiencyBonus.toString()) + Integer
                    .parseInt(wisdomModifier.toString())));
          }
        }
      }
      for (Ability a : staticModel.getAbilities())
      {
        if (p.getName().toLowerCase().contains(a.getName().toLowerCase()) && !p
            .getOrigin().equals("class"))
        {
          if (a.getName().toLowerCase().equals("strength"))
          {
            double strSave =
                Integer.parseInt(String.valueOf(strengthModifier)) + (
                    Integer.parseInt(String.valueOf(proficiencyBonus)) * p
                        .getMod());
            strengthSavingThrow.setValue(String.valueOf(strSave));
          }
          else if (a.getName().toLowerCase().equals("dexterity"))
          {
            double dexSave =
                Integer.parseInt(String.valueOf(dexterityModifier)) + (
                    Integer.parseInt(String.valueOf(proficiencyBonus)) * p
                        .getMod());
            dexteritySavingThrow.setValue(String.valueOf(dexSave));
          }
          else if (a.getName().toLowerCase().equals("constitution"))
          {
            double conSave =
                Integer.parseInt(String.valueOf(constitutionModifier)) + (
                    Integer.parseInt(String.valueOf(proficiencyBonus)) * p
                        .getMod());
            constitutionSavingThrow.setValue(String.valueOf(conSave));
          }
          else if (a.getName().toLowerCase().equals("intelligence"))
          {
            double intSave =
                Integer.parseInt(String.valueOf(intelligenceModifier)) + (
                    Integer.parseInt(String.valueOf(proficiencyBonus)) * p
                        .getMod());
            intelligenceSavingThrow.setValue(String.valueOf(intSave));
          }
          else if (a.getName().toLowerCase().equals("wisdom"))
          {
            double wisSave =
                Integer.parseInt(String.valueOf(wisdomModifier)) + (
                    Integer.parseInt(String.valueOf(proficiencyBonus)) * p
                        .getMod());
            wisdomSavingThrow.setValue(String.valueOf(wisSave));
          }
          else if (a.getName().toLowerCase().equals("charisma"))
          {
            double chaSave =
                Integer.parseInt(String.valueOf(charismaModifier)) + (
                    Integer.parseInt(String.valueOf(proficiencyBonus)) * p
                        .getMod());
            charismaSavingThrow.setValue(String.valueOf(chaSave));
          }
        }
      }
      if (p.getName().toLowerCase().contains("weapon"))
      {
        for (Item i : sheetCharacter.getEquipmentList())
        {
          if (p.getName().toLowerCase().contains("martial"))
          {
            if (i.getGameItem() instanceof EquipmentWeapon && i.isEquipped()
                && ((EquipmentWeapon) i.getGameItem()).getWeaponType()
                .toLowerCase().contains("martial"))
            {
              //show
            }
          }
          else if (p.getName().toLowerCase().contains("simple"))
          {
            if (i.getGameItem() instanceof EquipmentWeapon && i.isEquipped()
                && ((EquipmentWeapon) i.getGameItem()).getWeaponType()
                .toLowerCase().contains("simple"))
            {
              //show
            }
          }
          else //all others are all weapons (individual weapons are identified by name)
          {
            if (i.getGameItem() instanceof EquipmentWeapon && i.isEquipped())
            {
              //show
            }
          }
        }
      }
      if (p.getName().toLowerCase().contains("armor"))
      {
        for (Item i : sheetCharacter.getEquipmentList())
        {
          if (p.getName().toLowerCase().contains("all"))
          {
            if (i.getGameItem() instanceof EquipmentArmor && i.isEquipped())
            {
              //show
            }
          }
          else if (p.getName().contains("light"))
          {
            if (i.getGameItem() instanceof EquipmentArmor && i.isEquipped()
                && ((EquipmentArmor) i.getGameItem()).getDexMod().toLowerCase()
                .equals("full"))
            {
              //show
            }
          }
          else if (p.getName().contains("medium"))
          {
            if (i.getGameItem() instanceof EquipmentArmor && i.isEquipped()
                && ((EquipmentArmor) i.getGameItem()).getDexMod().toLowerCase()
                .equals("limited"))
            {
              //show
            }
          }
          else if (p.getName().contains("heavy"))
          {
            if (i.getGameItem() instanceof EquipmentArmor && i.isEquipped()
                && ((EquipmentArmor) i.getGameItem()).getDexMod().toLowerCase()
                .equals("none"))
            {
              //show
            }
          }
        }
      }
      else if (p.getType().toLowerCase().contains("shield"))
      {
        for (Item i : sheetCharacter.getEquipmentList())
        {
          if (i.getGameItem().getName().toLowerCase().equals("shield") && i
              .isEquipped())
          {
            //show prof
          }
        }
      }
      else if (p.getType().toLowerCase().contains("language") || p.getType()
          .toLowerCase().contains("thieves' cant"))
      {
        //display in prof bar
      }
      else if (p.getType().toLowerCase().contains("cantrip"))
      {
        //add cantrip
      }
      else if (p.getType().toLowerCase().contains("spell"))
      {
        int spells = Integer.parseInt(knownSpellAmount.toString());
        spells++;
        knownSpellAmount.setValue(String.valueOf(spells));
      }

      else
      {
        //parse for individual weapons, if not, then just note prof in Features and Traits bar
        parseClassFeats();
      }
    }
  }

  public void parseClassFeats()
  {
    for (CharacterClass c : sheetCharacter.getCharacterClass())
    {
      if (c instanceof Barbarian)
      {
        for (Feat f : c.getClassFeats())
        {
          //Unarmored Defense
          boolean isArmorEquipped = false;
          for (Item i : sheetCharacter.getEquipmentList())
          {
            if (i.getGameItem() instanceof EquipmentArmor && i.isEquipped())
            {
              isArmorEquipped = true;
            }
          }
          if (!isArmorEquipped)
          {
            armorClassInt =
                10 + Integer.parseInt(dexterityModifier.getValue()) + Integer
                    .parseInt(constitutionModifier.getValue());
            armorClass.setValue(String.valueOf(armorClassInt));
          }
        }
      }
      else if (c instanceof Bard && sheetCharacter.getLevelInClass()
          .get(sheetCharacter.getCharacterClass().indexOf(c)) >= 2)
      {
        for (Feat f : c.getClassFeats())
        {
          //Jack of all Trades
          StaticModel staticModel = sheetCharacter.getStaticModel();
          for (Skill s : staticModel.getSkills())
          {
            if (s.getName().equals("Acrobatics"))
            {
              acrobaticsModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(dexterityModifier.toString())));
            }
            else if (s.getName().equals("Animal Handling"))
            {
              animalHandlingModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(wisdomModifier.toString())));
            }
            else if (s.getName().equals("Arcana"))
            {
              arcanaModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(intelligenceModifier.toString())));
            }
            else if (s.getName().equals("Athletics"))
            {
              athleticsModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(strengthModifier.toString())));
            }
            else if (s.getName().equals("Deception"))
            {
              deceptionModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(charismaModifier.toString())));
            }
            else if (s.getName().equals("History"))
            {
              historyModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(intelligenceModifier.toString())));
            }
            else if (s.getName().equals("Insight"))
            {
              insightModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(wisdomModifier.toString())));
            }
            else if (s.getName().equals("Intimidation"))
            {
              intimidationModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(charismaModifier.toString())));
            }
            else if (s.getName().equals("Investigation"))
            {
              investigationModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(intelligenceModifier.toString())));
            }
            else if (s.getName().equals("Medicine"))
            {
              medicineModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(wisdomModifier.toString())));
            }
            else if (s.getName().equals("Nature"))
            {
              natureModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(intelligenceModifier.toString())));
            }
            else if (s.getName().equals("Perception"))
            {
              perceptionModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(wisdomModifier.toString())));
            }
            else if (s.getName().equals("Performance"))
            {
              performanceModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(charismaModifier.toString())));
            }
            else if (s.getName().equals("Persuasion"))
            {
              persuasionModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(charismaModifier.toString())));
            }
            else if (s.getName().equals("Religion"))
            {
              religionModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(intelligenceModifier.toString())));
            }
            else if (s.getName().equals("Sleight of Hand"))
            {
              sleightOfHandModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(dexterityModifier.toString())));
            }
            else if (s.getName().equals("Stealth"))
            {
              stealthModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(dexterityModifier.toString())));
            }
            else if (s.getName().equals("Survival"))
            {
              survivalModifier.setValue(String.valueOf(
                  Math.floor(Integer.parseInt(proficiencyBonus.toString()) / 2)
                      + Integer.parseInt(wisdomModifier.toString())));
            }
          }
        }
      }
      else if (c instanceof Monk)
      {
        for (Feat f : c.getClassFeats())
        {
          //Unarmored Defense
          boolean isArmorEquipped = false;
          for (Item i : sheetCharacter.getEquipmentList())
          {
            if (i.getGameItem() instanceof EquipmentArmor && i.isEquipped())
            {
              isArmorEquipped = true;
            }
          }
          if (!isArmorEquipped)
          {
            armorClassInt =
                10 + Integer.parseInt(dexterityModifier.getValue()) + Integer
                    .parseInt(wisdomModifier.getValue());
            armorClass.setValue(String.valueOf(armorClassInt));
          }

          //Unarmored Movement
          if (sheetCharacter.getLevelInClass()
              .get(sheetCharacter.getCharacterClass().indexOf(c)) >= 2)
          {
            isArmorEquipped = false;
            for (Item i : sheetCharacter.getEquipmentList())
            {
              if ((i.getGameItem() instanceof EquipmentArmor && i.isEquipped())
                  || i.getGameItem().getName().toLowerCase().contains("shield"))
              {
                isArmorEquipped = true;
              }
            }
            if (!isArmorEquipped)
            {
              speed.setValue(
                  String.valueOf(Integer.parseInt(speed.getValue()) + 10));
            }
          }

          //Diamond Soul
          if (sheetCharacter.getLevelInClass()
              .get(sheetCharacter.getCharacterClass().indexOf(c)) >= 14)
          {
            double strSave =
                Integer.parseInt(String.valueOf(strengthModifier)) + (Integer
                    .parseInt(String.valueOf(proficiencyBonus)));
            if (strSave >= Integer.parseInt(charismaSavingThrow.getValue()))
            {
              strengthSavingThrow.setValue(String.valueOf(strSave));
            }
            double dexSave =
                Integer.parseInt(String.valueOf(dexterityModifier)) + (Integer
                    .parseInt(String.valueOf(proficiencyBonus)));
            if (dexSave >= Integer.parseInt(charismaSavingThrow.getValue()))
            {
              dexteritySavingThrow.setValue(String.valueOf(dexSave));
            }
            double conSave =
                Integer.parseInt(String.valueOf(constitutionModifier))
                    + (Integer.parseInt(String.valueOf(proficiencyBonus)));
            if (conSave >= Integer.parseInt(charismaSavingThrow.getValue()))
            {
              constitutionSavingThrow.setValue(String.valueOf(conSave));
            }
            double intSave =
                Integer.parseInt(String.valueOf(intelligenceModifier))
                    + (Integer.parseInt(String.valueOf(proficiencyBonus)));
            if (intSave >= Integer.parseInt(charismaSavingThrow.getValue()))
            {
              intelligenceSavingThrow.setValue(String.valueOf(intSave));
            }
            double wisSave =
                Integer.parseInt(String.valueOf(wisdomModifier)) + (Integer
                    .parseInt(String.valueOf(proficiencyBonus)));
            if (wisSave >= Integer.parseInt(charismaSavingThrow.getValue()))
            {
              wisdomSavingThrow.setValue(String.valueOf(wisSave));
            }
            double chaSave =
                Integer.parseInt(String.valueOf(charismaModifier)) + (Integer
                    .parseInt(String.valueOf(proficiencyBonus)));
            if (chaSave >= Integer.parseInt(charismaSavingThrow.getValue()))
            {
              charismaSavingThrow.setValue(String.valueOf(chaSave));
            }
          }
        }
      }
      else if (c instanceof Rogue && sheetCharacter.getLevelInClass()
          .get(sheetCharacter.getCharacterClass().indexOf(c)) >= 15)
      {
        double wisSave =
            Integer.parseInt(String.valueOf(wisdomModifier)) + (Integer
                .parseInt(String.valueOf(proficiencyBonus)));
        if (wisSave >= Integer.parseInt(charismaSavingThrow.getValue()))
        {
          wisdomSavingThrow.setValue(String.valueOf(wisSave));
        }
      }
    }
  }
}
