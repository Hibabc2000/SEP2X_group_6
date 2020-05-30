package system.model.characterManagement;

import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;
import system.model.characterClasses.CharacterClass;
import system.util.Subject;

import java.util.ArrayList;

public interface CharacterManagementModel extends Subject
{
  //void receiveCharacter(Character character);
  void transmitCharacter(Character character);
  void setCharacter(Character character);
  boolean getAccountDmStatus();
  StaticModel getStaticModel();
  ArrayList<CharacterClass> getAllCharacterClasses();
  void sendCharacterForDmEditing(String characterName);
}
