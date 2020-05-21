package system.model.dmCharacterChoosing;

import system.model.businessModel.Character;
import system.networking.Client;
import system.transferobjects.login.DM;
import system.transferobjects.login.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class dmCharacterChoosingImpl implements dmCharacterChoosingModel
{
  private ArrayList<Character> characters;
  private User user;
  private PropertyChangeSupport support;
  private Client client;
  public dmCharacterChoosingImpl(User user)
  {
    this.user=user;
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
    if(user instanceof DM)
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
     }
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
