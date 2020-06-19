package system.views.dmCharacterSheetChoosing;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import system.model.businessModel.Character;
import system.model.characterManagement.CharacterManagementModel;
import system.util.Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DMCharacterSheetChoosingViewModel implements Subject
{
  private PropertyChangeSupport support;
    private ObservableList<Character> characters;
  private CharacterManagementModel  model;
  private StringProperty xpField;
  private StringProperty error;

  public DMCharacterSheetChoosingViewModel(CharacterManagementModel model)
  { this.model = model;
    support = new PropertyChangeSupport(this);
    xpField = new SimpleStringProperty();
    error = new SimpleStringProperty();

    xpField.setValue("");
    characters = FXCollections.observableArrayList();
    model.addListener("characterReady", this::setCharacter);
    model.addListener("updateCharacterDM",this::updateCharacter);


  }
  public StringProperty getXpFieldProperty()
  {
    return xpField;
  }
  public StringProperty getErrorProperty()
  {
    return error;
  }

  private void updateCharacter(PropertyChangeEvent propertyChangeEvent)
  {
    Character charToUI = (Character) propertyChangeEvent.getNewValue();
    for(int i=0; i<characters.size();i++)
    {
      if(characters.get(i).getUsername().equals(charToUI.getUsername()))
      {
        characters.set(i,charToUI);
      }
    }
  }

  private void setCharacter(PropertyChangeEvent propertyChangeEvent)
  {
    Character charToUI = (Character) propertyChangeEvent.getNewValue();
    characters.add(charToUI);
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
  public ObservableList<Character> getCharacterList()
  {

    return characters;
  }

  public void giveXP(String chUsername, int amount)
  { Character characterToEdit = null;
    int xpm=0;
    int currentxo=0;

    for(Character charz : characters)
    {
      if(charz.getUsername().equals(chUsername) )
      {
        characterToEdit = charz;
        if(xpField.getValue().contains("-")) {error.setValue("You cannot give negative XP");}
        else
        try
        {
          currentxo = Integer.parseInt(xpField.getValue());
          xpm = amount + currentxo;

          error.setValue("XP added to character");
        }
        catch (NumberFormatException e)
        {
          error.setValue("Invalid input");
          break;
        }

        characterToEdit.setXp(xpm);

       break;}
    }
    if(!(error.getValue().equals("Invalid input")))
    {
      model.transmitCharacter(characterToEdit);

    }
  }

  public void enableLVL(Character ch)
  {
    int xpAmount = ch.getXp();
    int lvl = ch.getLevel();
    if(xpAmount>=100){
    while(xpAmount>=100)
    {
      xpAmount = xpAmount-100;
      lvl++;
    }
    ch.setXp(xpAmount);
    ch.setLevel(lvl);
    error.setValue("Character leveled up to "+ lvl);
    model.transmitCharacter(ch);

  }
  else {error.setValue("You need to have at least 100 xp to enable level up.");}
  }

  //testing method
  public void setCharacters(Character cha)
{
  characters.add(cha);
}
}
