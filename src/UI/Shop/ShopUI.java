package UI.Shop;

import UI.Shop.Child.*;

public class ShopUI
{
    //==========================================Variable==========================================
    private ShopMainUI mainUI;
    private ShopInfoUI infoUI;
    private ShopCreateManagerUI createManagerUI;
    private ShopChangeCheckInUI changeCheckInUI;
    
    //========================================Constructor=========================================
    public ShopUI()
    {
        this.mainUI = new ShopMainUI();
        this.infoUI = new ShopInfoUI();
        this.createManagerUI = new ShopCreateManagerUI();
        this.changeCheckInUI = new ShopChangeCheckInUI();
    }

    //============================================Get=============================================
    public ShopMainUI getMainUI() { return mainUI; }
    public ShopInfoUI getInfoUI() { return infoUI; }
    public ShopCreateManagerUI getCreateManagerUI() { return createManagerUI; }
    public ShopChangeCheckInUI getChangeCheckInUI() { return changeCheckInUI; }
}
