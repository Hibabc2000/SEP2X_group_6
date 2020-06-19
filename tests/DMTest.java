import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.model.businessModel.Character;
import system.model.businessModel.staticModel.StaticModel;
import system.model.characterManagement.CharacterManagementModel;
import system.model.characterManagement.CharacterManagementModelImpl;
import system.networking.Client;
import system.networking.SocketClient;
import system.views.dmCharacterSheetChoosing.DMCharacterSheetChoosingViewModel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class DMTest
{
 private DMCharacterSheetChoosingViewModel viewmodel ;
 private CharacterManagementModel model;
 private Client client;
private StaticModel stm;
  private Character chacha;
  private Character cha;
  @BeforeEach void setUp()
  { client = new SocketClient();
stm = new StaticModel();
     model = new CharacterManagementModelImpl(client);
   viewmodel = new DMCharacterSheetChoosingViewModel(model);
   cha = new Character(stm);
   cha.setLevel(1);
   cha.setXp(0);
   cha.setUsername("Noémi");
   cha.setName("NotNoémi");
   cha.setId(27);
   cha.setGroupID(10);
     chacha = new Character(stm);
    cha.setLevel(1);
    cha.setXp(0);
    cha.setUsername("Byron");
    cha.setName("Reckful");
    cha.setId(3);
    cha.setGroupID(5);

    viewmodel.setCharacters(cha);
    viewmodel.setCharacters(chacha);



  }

  @AfterEach void tearDown()
  {cha.setXp(0);
  chacha.setXp(0);
  cha.setLevel(1);
  chacha.setLevel(1);
  }
  @Test void giveXPErrorMessageTestSuccessTest()
  { //arrange
    StringProperty xpField = new SimpleStringProperty();
    StringProperty error = new SimpleStringProperty();
    viewmodel.getXpFieldProperty().bindBidirectional(xpField);
    viewmodel.getErrorProperty().bindBidirectional(error);

    //act
    xpField.setValue("15");
    error.setValue("");


    //assert
    assertThrows(NullPointerException.class , () -> {
      viewmodel.giveXP(cha.getUsername(),cha.getXp());

    });
    assertEquals(error.getValue(),"XP added to character");




  }
  @Test void giveXPErrorMessageTestFailureTest()
  { //arrange
    StringProperty xpField = new SimpleStringProperty();
    StringProperty error = new SimpleStringProperty();
    viewmodel.getXpFieldProperty().bindBidirectional(xpField);
    viewmodel.getErrorProperty().bindBidirectional(error);

    //act
    xpField.setValue("ff");
    error.setValue("");
    viewmodel.giveXP(cha.getUsername(),cha.getXp());

    //assert
    assertEquals(error.getValue(),"Invalid input");


  }
  @Test void giveZeroXPTest()
  { //arrange
    StringProperty xpField = new SimpleStringProperty();
    StringProperty error = new SimpleStringProperty();
    viewmodel.getXpFieldProperty().bindBidirectional(xpField);
    viewmodel.getErrorProperty().bindBidirectional(error);

    //act
    xpField.setValue("0");
    error.setValue("");


    //assert
    assertThrows(NullPointerException.class , () -> {
      viewmodel.giveXP(cha.getUsername(),cha.getXp());

    });

    assertEquals(cha.getXp(),0);

  }
  @Test void giveOneXPTest()
  { //arrange
    StringProperty xpField = new SimpleStringProperty();
    StringProperty error = new SimpleStringProperty();
    viewmodel.getXpFieldProperty().bindBidirectional(xpField);
    viewmodel.getErrorProperty().bindBidirectional(error);

    //act
    xpField.setValue("1");
    error.setValue("");


    //assert
    assertThrows(NullPointerException.class , () -> {
      viewmodel.giveXP(cha.getUsername(),cha.getXp());

    });

    assertEquals(cha.getXp(),1);
  }
  @Test void giveManyXPTest()
  { //arrange
    StringProperty xpField = new SimpleStringProperty();
    StringProperty error = new SimpleStringProperty();
    viewmodel.getXpFieldProperty().bindBidirectional(xpField);
    viewmodel.getErrorProperty().bindBidirectional(error);

    //act
    xpField.setValue("11341");
    error.setValue("");


    //assert
    assertThrows(NullPointerException.class , () -> {
      viewmodel.giveXP(cha.getUsername(),cha.getXp());

    });

    assertEquals(cha.getXp(),11341);
  }
  @Test void giveMinusOneXPBoundaryTest()
  { //arrange
    StringProperty xpField = new SimpleStringProperty();
    StringProperty error = new SimpleStringProperty();
    viewmodel.getXpFieldProperty().bindBidirectional(xpField);
    viewmodel.getErrorProperty().bindBidirectional(error);

    //act
    xpField.setValue("-1");
    error.setValue("");


    //assert
    assertThrows(NullPointerException.class , () -> {
      viewmodel.giveXP(cha.getUsername(),cha.getXp());

    });

    assertEquals(cha.getXp(),0);
    assertEquals(error.getValue(),"You cannot give negative XP");

  }

  @Test void enableLevelErrorSuccessTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(140);
    assertThrows(NullPointerException.class , () -> {
      viewmodel.enableLVL(cha);


    });

    //assert



    assertEquals(error.getValue(),"Character leveled up to "+ cha.getLevel());

  }
  @Test void enableLevelErrorFailureTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(56);

      viewmodel.enableLVL(cha);



    //assert



    assertEquals(error.getValue(),"You need to have at least 100 xp to enable level up.");

  }
  @Test void enableLevelWithOneXPTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(1);

      viewmodel.enableLVL(cha);



    //assert



    assertEquals(error.getValue(),"You need to have at least 100 xp to enable level up.");

  }
  @Test void enableLevelWithZeroXPTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(0);

    viewmodel.enableLVL(cha);



    //assert



    assertEquals(error.getValue(),"You need to have at least 100 xp to enable level up.");

  }
  @Test void enableLevelWithMinusOneXPTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(-1);

    viewmodel.enableLVL(cha);



    //assert



    assertEquals(error.getValue(),"You need to have at least 100 xp to enable level up.");

  }
  @Test void enableLevelWithManyXPTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(4140);
    assertThrows(NullPointerException.class , () -> {
      viewmodel.enableLVL(cha);


    });

    //assert



    assertEquals(error.getValue(),"Character leveled up to "+ cha.getLevel());
    assertEquals(cha.getXp(),40);

  }
  @Test void enableLevelBoundaryHundredXPTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(100);

    assertThrows(NullPointerException.class , () -> {
      viewmodel.enableLVL(cha);


    });





    //assert



    assertEquals(error.getValue(),"Character leveled up to "+ cha.getLevel());
    assertEquals(cha.getXp(),0);
  }

  @Test void enableLevelBoundaryHundredOneXPTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(101);
    assertThrows(NullPointerException.class , () -> {
      viewmodel.enableLVL(cha);


    });

    //assert



    assertEquals(error.getValue(),"Character leveled up to "+ cha.getLevel());
    assertEquals(cha.getXp(),1);
  }
  @Test void enableLevelBoundaryNinetyNineXPTest()
  { //arrange

    StringProperty error = new SimpleStringProperty();

    viewmodel.getErrorProperty().bindBidirectional(error);

    //act

    error.setValue("");
    cha.setXp(99);

      viewmodel.enableLVL(cha);


    //assert

    assertEquals(error.getValue(),"You need to have at least 100 xp to enable level up.");
    assertEquals(cha.getXp(),99);
  }

}