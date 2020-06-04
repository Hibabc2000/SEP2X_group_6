package system.views.characterSheet.infoPopup;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import system.core.ViewHandler;
import system.model.businessModel.staticModel.StaticModel;
import system.model.characterManagement.CharacterManagementModel;
import system.views.characterSheet.CharacterSheetViewModel;

public class InfoPopupViewModel
{

  private StringProperty infoPopupTitle;
  private StringProperty infoPopupContent;
  private ViewHandler viewHandler;
  private CharacterManagementModel characterManagementModel;
  private CharacterSheetViewModel characterSheetViewModel;
  private StaticModel staticModel;

  public InfoPopupViewModel(CharacterManagementModel characterManagementModel)
  {

    this.characterManagementModel = characterManagementModel;
    infoPopupTitle = new SimpleStringProperty();
    infoPopupContent = new SimpleStringProperty();
    staticModel = characterManagementModel.getStaticModel();

  }

  public void setInfo(String popupInfo)
  {
      for (int i = 0; i < staticModel.getAbilities().size(); i++)
    {
      if (staticModel.getAbilities().get(i).getName()
          .equalsIgnoreCase(popupInfo))
      {
        infoPopupTitle.setValue(popupInfo);
        infoPopupContent
            .setValue(staticModel.getAbilities().get(i).getDescription());
      }

    }

  }

  public StringProperty infoPopupTitleProperty()
  {
    return infoPopupTitle;
  }

  public StringProperty infoPopupContentProperty()
  {
    return infoPopupContent;
  }
}
