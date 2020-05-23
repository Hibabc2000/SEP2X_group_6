package system.model.dmCharacterChoosing;

import system.model.businessModel.Character;
import system.util.Subject;

public interface DMCharacterChoosingModel extends Subject
{
  void receiveCharacter(Character character);
  void transmitCharacter(Character character);
}
