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
    public ShopMainUI getMainUI() { return this.mainUI; }
    public ShopInfoUI getInfoUI() { return this.infoUI; }
    public ShopCreateManagerUI getCreateManagerUI() { return this.createManagerUI; }
    public ShopChangeCheckInUI getChangeCheckInUI() { return this.changeCheckInUI; }
}
