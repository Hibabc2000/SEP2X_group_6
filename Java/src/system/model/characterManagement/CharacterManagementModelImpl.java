package system.model.characterManagement;

import javafx.beans.property.BooleanProperty;
import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;
import system.networking.Client;
import system.transferobjects.Container;
import system.transferobjects.login.Account;
import system.transferobjects.login.DM;
import system.transferobjects.login.Group;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class CharacterManagementModelImpl implements CharacterManagementModel
{
  private ArrayList<Character> characters;
  private Account account;
  private PropertyChangeSupport support;
  private Client client;
  private StaticModel staticModel;
  private Group group;

  public CharacterManagementModelImpl(Client client,Account account)
  {
    this.client = client;
    this.account=account;
    characters = new ArrayList<>();
    support = new PropertyChangeSupport(this);
    client.addListener("incomingCharacter", this::setCharacter);
    client.addListener("incomingStaticModel", this::setStaticModel);
    client.addListener("incomingServerRequestToCreateANewCharacterForTheFirstTime",this::createNewCharacterForTheFirstTime);
    client.addListener("joinedGroupK",this::setGroup);
  }

  /*
    @Override public void receiveCharacter(Character character)
    {

    }
     */
  @Override public void transmitCharacter(Character character)
  {
    client.submitCharacter(character);
  }

  public void setGroup(PropertyChangeEvent propertyChangeEvent)
  {
    this.group = (Group)propertyChangeEvent.getNewValue();
  }

  public void getCharacter()
  {

  }
  public void createNewCharacterForTheFirstTime(PropertyChangeEvent propertyChangeEvent)
  {
    boolean k = ((BooleanProperty)((Container)propertyChangeEvent.getNewValue()).getObject()).getValue();
    if(k)
    {
      Character temporaryCharacter = new Character(staticModel);
      temporaryCharacter.setUsername(account.getUsername());
      temporaryCharacter.setGroupID(group.getId());
    }
  }

  public void sendCharacterList()
  {
    ArrayList<String> charactersNameList = new ArrayList<>();
    for (int i = 0; i < characters.size(); i++)
    {
      charactersNameList
          .add(characters.get(i).getName() + ", " + characters.get(i).getId());
    }
    support.firePropertyChange("charactersNameListToDmChoosing", null,
        charactersNameList);
  }

  @Override public void sendCharacterForDmEditing(String characterName)
  {
    for (int i = 0; i < characters.size(); i++)
    {
      String temporaryStringOne =
          characters.get(i).getName() + ", " + characters.get(i).getId();
      if (temporaryStringOne.equals(characterName))
      {
        support.firePropertyChange("characterToSheetViewModel", null,
            characters.get(i));
      }
    }
  }
  public void setStaticModel(PropertyChangeEvent propertyChangeEvent)
  {
    staticModel = (StaticModel)(StaticModel) ((Container) propertyChangeEvent
        .getNewValue()).getObject();
  }
  @Override public StaticModel getStaticModel()
  {
    return staticModel;
  }
  public void setCharacter(PropertyChangeEvent propertyChangeEvent)
  {

    Character temporaryCharacter = (Character) ((Container) propertyChangeEvent
        .getNewValue()).getObject();
    if (account.getUser() instanceof DM)
    {
      if (characters.size() == 0)
      {
        characters.add(temporaryCharacter);
      }
      else
      {
        for (int i = 0; i < characters.size(); i++)
        {
          if (characters.get(i).getId() == temporaryCharacter.getId())
          {
            characters.remove(characters.get(i));
            characters.add(i, temporaryCharacter);
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
      if (!(temporaryCharacter.equals(characters.get(0))))
      {
        characters.remove(0);
        characters.add(temporaryCharacter);
        support.firePropertyChange("characterToSheetViewModel", null,
            characters.get(0));
      }
    }
    sendCharacterList();
  }

  @Override public void setCharacter(Character character)
  {
    if (account.getUser() instanceof DM)
    {
      if (characters.size() == 0)
      {
        characters.add(character);
      }
      else
      {
        for (int i = 0; i < characters.size(); i++)
        {
          if (characters.get(i).getId() == character.getId())
          {
            characters.remove(characters.get(i));
            characters.add(i, character);
            transmitCharacter(character);
          }
          else
          {
            characters.add(character);
            transmitCharacter(character);
          }
        }
      }
    }
    else
    {
      characters.remove(0);
      characters.add(character);
      transmitCharacter(character);
    }

  }
  @Override public boolean getAccountDmStatus()
  {
    if(account.getUser() instanceof DM)
    {
      return true;
    }
    else
    {
      return false;
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
