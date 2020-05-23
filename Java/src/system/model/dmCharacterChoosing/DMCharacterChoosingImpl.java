package system.model.dmCharacterChoosing;

import system.model.businessModel.Character;
import system.networking.Client;
import system.transferobjects.login.Account;
import system.transferobjects.login.DM;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class DMCharacterChoosingImpl implements DMCharacterChoosingModel
{
  private ArrayList<Character> characters;
  private Account account;
  private PropertyChangeSupport support;
  private Client client;
  public DMCharacterChoosingImpl()
  {

    characters = new ArrayList<>();
    support = new PropertyChangeSupport(this);
    client.addListener("incomingCharacter",this::setCharacter);

  }

  /*
  @Override public void receiveCharacter(Character character)
  {

  }
   */
  @Override public void transmitCharacter(Character character)
  {

  }

  public void getCharacter()
  {

  }
  public void setCharacter(PropertyChangeEvent propertyChangeEvent)
  {
    Character temporaryCharacter = (Character) propertyChangeEvent.getNewValue();
    if(account.getUser() instanceof DM)
    {
      if(characters.size() == 0)
      {
        characters.add(temporaryCharacter);
      }
      else
      {
        for(int i = 0; i < characters.size(); i++)
        {
          if(characters.get(i).getId() == temporaryCharacter.getId())
          {
            characters.remove(characters.get(i));
            characters.add(i,temporaryCharacter);
          }
          else
          {
            characters.add(temporaryCharacter);
          }
        }
      }
    }
    else
    {
     if(!(temporaryCharacter.equals(characters.get(0))))
     {
       characters.remove(0);
       characters.add(temporaryCharacter);
       support.firePropertyChange("characterToSheetViewModel",null, characters.get(0));
     }
    }
  }

  public void setCharacter(Character character)
  {
    if(account.getUser() instanceof DM)
    {
      if(characters.size() == 0)
      {
        characters.add(character);
      }
      else
      {
        for(int i = 0; i < characters.size(); i++)
        {
          if(characters.get(i).getId() == character.getId())
          {
            characters.remove(characters.get(i));
            characters.add(i,character);
          }
          else
          {
            characters.add(character);
          }
        }
      }
    }
    else
    {
      characters.remove(0);
      characters.add(character);
    }
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
