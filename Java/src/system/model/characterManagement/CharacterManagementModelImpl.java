package system.model.characterManagement;

import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;
import system.model.characterClasses.CharacterClass;
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
  private ArrayList<CharacterClass> characterClasses;

  public CharacterManagementModelImpl(Client client)
  {
    characters = new ArrayList<>();
    this.client = client;

    characters = new ArrayList<>();
    support = new PropertyChangeSupport(this);
    client.addListener("incomingCharacter", this::setCharacter);
    client.addListener("incomingStaticModel", this::setStaticModel);
    client.addListener("createCharacter",this::createNewCharacterForTheFirstTime);
    client.addListener("joinedGroupK",this::setGroup);
    client.addListener("incomingClasses", this::addClasses);
    client.addListener("accountLogin",this::addAccount);
  }

  private void addAccount(PropertyChangeEvent propertyChangeEvent)
  { Account ack = (Account) ((Container)propertyChangeEvent.getNewValue()).getObject();
    System.out.println("intersting");
    account = ack;


  }

  public void addClasses(PropertyChangeEvent propertyChangeEvent)
  {
    characterClasses = (ArrayList<CharacterClass>)((Container)propertyChangeEvent.getNewValue()).getObject();
  }
  @Override public ArrayList<CharacterClass>  getAllCharacterClasses()
  {
    return characterClasses;
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
    System.out.println("nincs gond");
    Group grp = (Group) ((Container)propertyChangeEvent.getNewValue()).getObject();
    this.group = grp;
  }

  public void createNewCharacterForTheFirstTime(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("ez it a method forcreate char");
    boolean k = (boolean)((Container)propertyChangeEvent.getNewValue()).getObject();
    if(!k)
    { System.out.println("ez it if statement");
      System.out.println("ez it create new character in model");
      Character temporaryCharacter = new Character(staticModel);
      temporaryCharacter.setUsername(account.getUsername());
      temporaryCharacter.setGroupID(group.getId());
      System.out.println("grouup name, id, :" + account.getUsername()+ " id: "+group.getId() );
      support.firePropertyChange("openTheCreation",null,temporaryCharacter);
     // support.firePropertyChange("displayCharacterCreationScene",null,k);
    support.firePropertyChange("characterToSheetViewModel", null,temporaryCharacter);
      System.out.println("what?");
    }
  }

  public void sendCharacterList()
  { System.out.println("lehetetlen BORZALMASAN");
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
  { System.out.println("lehetetlen nGoN");
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
    System.out.println("lehetetlen");

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
    System.out.println("mohME:d "+account.getUsername());
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
