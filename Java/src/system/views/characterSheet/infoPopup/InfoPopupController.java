package system.views.characterSheet.infoPopup;

import javafx.scene.control.Label;
import system.core.ViewHandler;

public class InfoPopupController
{
    public Label infoPopupTitle;
    public Label infoPopupContent;

    private ViewHandler viewHandler;
    private InfoPopupViewModel infoPopupViewModel;




    public void init(InfoPopupViewModel infoPopupViewModel, String popupInfo)
    {

        this.infoPopupViewModel = infoPopupViewModel;
        infoPopupContent.textProperty().bindBidirectional(infoPopupViewModel.infoPopupContentProperty());
        infoPopupTitle.textProperty().bindBidirectional(infoPopupViewModel.infoPopupTitleProperty());
        setInfo(popupInfo);
    }

    public void setInfo(String popupInfo)
    {
        infoPopupViewModel.setInfo(popupInfo);
    }


}
