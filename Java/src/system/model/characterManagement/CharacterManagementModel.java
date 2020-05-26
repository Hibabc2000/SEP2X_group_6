package system.model.characterManagement;

import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;
import system.util.Subject;

public interface CharacterManagementModel extends Subject
{
  //void receiveCharacter(Character character);
  void transmitCharacter(Character character);
  void setCharacter(Character character);
  boolean getAccountDmStatus();
  StaticModel getStaticModel();
  void sendCharacterForDmEditing(String characterName);
}
