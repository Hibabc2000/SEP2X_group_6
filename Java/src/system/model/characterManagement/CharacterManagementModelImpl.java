package system.model.characterManagement;

import system.model.businessModel.Character;
import system.model.businessModel.Feat;
import system.model.businessModel.Proficiency;
import system.model.businessModel.staticModel.StaticModel;
import system.model.characterClasses.CharacterClass;
import system.model.characterClasses.Fighter;
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
  /**
   * Returns a randomly created number or a sum of random numbers.
   * @param client Client, to receive the incoming data from the sockets implementations
   */
  public CharacterManagementModelImpl(Client client)
  {characters = new ArrayList<>();
    characterClasses = new ArrayList<>();
    ArrayList<Feat> fts = new ArrayList();
    ArrayList<Integer> featlvls = new ArrayList<>();
    ArrayList<Proficiency> ftmdf = new ArrayList<>();
    Fighter testclass = new Fighter(6,fts,featlvls,"fat","AAA",ftmdf);
    characterClasses.add(testclass);

    this.client = client;
    support = new PropertyChangeSupport(this);
    client.addListener("incomingCharacter", this::receiveCharacter);
    client.addListener("incomingStaticModel", this::setStaticModel);
    client.addListener("createCharacter",this::createNewCharacterForTheFirstTime);
    client.addListener("joinedGroupK",this::setGroup);
    client.addListener("incomingClasses", this::addClasses);
    client.addListener("accountLogin",this::addAccount);
  }
  /**
   * sets the account, this is needed because the model needs to know if the player is a DM or a player
   * @param propertyChangeEvent PropertyChangeEvent,
   */
  private void addAccount(PropertyChangeEvent propertyChangeEvent)
  { Account ack = (Account) ((Container)propertyChangeEvent.getNewValue()).getObject();
    System.out.println("intersting");
    account = ack;


  }
  /**
   * sets the received classes from the server
   * @param propertyChangeEvent PropertyChangeEvent,
   */
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
  /**
   * sends the character to the server
   * @param character Character, the character that is going to be sent to the server
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
  /**
   * creates a new , empty character
   * @param propertyChangeEvent PropertyChangeEvent
   */
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
    //support.firePropertyChange("characterToSheetViewModel", null,temporaryCharacter);
      System.out.println("what?");
    }
  }
  /**
   * sends all the character names and their ids to be chosen by the dm
   */
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
  /**
   * sends the selected character to the characterSheet and CharacterCreation pages
   * @param characterName String, the name of the character that you want to edit
   */
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
  /**
   * saves the static model that was received from the server
   * @param propertyChangeEvent PropertyChangeEvent, gets the new value of it
   */
  public void setStaticModel(PropertyChangeEvent propertyChangeEvent)
  {
    staticModel = (StaticModel)(StaticModel) ((Container) propertyChangeEvent
        .getNewValue()).getObject();
  }
  @Override public StaticModel getStaticModel()
  {
    return staticModel;
  }
  /**
   * set the character received from the server
   * @param propertyChangeEvent PropertyChangeEvent, gets the new value of the character
   */
  public void receiveCharacter(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("lehetetlen");
    boolean isItAnUpdate = false;
    Character temporaryCharacter = (Character) ((Container) propertyChangeEvent
        .getNewValue()).getObject();
    if (account.getUser() instanceof DM)
    {
      if (characters.size() == 0)
      {
        System.out.println("EZ FUT LE");
        System.out.println("shangrila . + " +temporaryCharacter.getUsername()  );
        characters.add(temporaryCharacter);
        support.firePropertyChange("characterReady", null, temporaryCharacter);
      }
      else
      {
        for (int i = 0; i < characters.size(); i++)
        {
          if (characters.get(i).getId() == temporaryCharacter.getId())
          { isItAnUpdate=true;
            characters.remove(characters.get(i));
            characters.add(i, temporaryCharacter);
            support.firePropertyChange("updateCharacterDM", null, temporaryCharacter);
            break;
          }

        }
        if(!isItAnUpdate)
      {
        characters.add(temporaryCharacter);
        support.firePropertyChange("characterReady", null, temporaryCharacter);
      }

      }
    }
    else
    {
      if(characters.size()==0){ characters.add(temporaryCharacter);
      support.firePropertyChange("characterToSheetViewModel", null,
          characters.get(0));}
      else
        characters.remove(0);
        characters.add(temporaryCharacter);
        support.firePropertyChange("characterToSheetViewModel", null,
            characters.get(0));

    }
    sendCharacterList();
  }
  /**
   * sets the character,if the account is a player to the first slot and if the player is a DM to its own slot, and transmits it to the server
   * @param character Character, the character that you want to save and transmit
   */
  @Override public void setCharacter(Character character)
  {
    System.out.println(character.getName()+character.getAbilities()[0]+"!!!!!!!");
    if (account.getUser() instanceof DM)
    {
      if (characters.size() == 0)
      {
        System.out.println(character.getName()+character.getAbilities()[0]+"!!!!!!!"+1);
        characters.add(character);
      }
      else
      {
        for (int i = 0; i < characters.size(); i++)
        {
          if (characters.get(i).getId() == character.getId())
          {
            System.out.println(character.getName()+character.getAbilities()[0]+"!!!!!!!"+2);
            characters.remove(characters.get(i));
            characters.add(i, character);
            transmitCharacter(character);
          }
          else
          {
            System.out.println(character.getName()+character.getAbilities()[0]+"!!!!!!!"+3);
            characters.add(character);
            transmitCharacter(character);
          }
        }
      }
    }
    else if(characters.size() > 0)
    {
      System.out.println(character.getName()+character.getAbilities()[0]+"!!!!!!!"+4);
      characters.remove(0);
      characters.add(character);
      transmitCharacter(character);
    }

  }
  /**
   * returns if the account is a DM or a player
   * @return a boolean that is true it the account is a DM, and false if its a player
   */
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
