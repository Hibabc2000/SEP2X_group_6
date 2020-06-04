package system.views.characterSheet.infoPopup;

import javafx.fxml.FXML;
import system.core.ViewHandler;

import java.awt.*;

public class InfoPopupController
{
    private ViewHandler viewHandler;
    private InfoPopupViewModel infoPopupViewModel;


    @FXML private Label infoPopupTitle;
    @FXML private Label infoPopupContent;

    public void init(InfoPopupViewModel infoPopupViewModel)
    {
        this.infoPopupViewModel = infoPopupViewModel;
        this.viewHandler=viewHandler;
    }

    public void setInfo()
    {

    }
}
