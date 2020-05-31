package system.views.dmCharacterSheetChoosing;

import system.core.ViewHandler;

public class DmCharacterChoosingPageController
{
  private ViewHandler  vh;
  private DMCharacterSheetChoosingViewModel model;
  public void init(DMCharacterSheetChoosingViewModel viewModel, ViewHandler viewHandler)
  {
    vh= viewHandler;
    model = viewModel;
  }
}
