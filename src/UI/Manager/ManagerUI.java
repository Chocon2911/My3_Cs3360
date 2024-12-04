package UI.Manager;

import UI.Manager.Child.*;

public class ManagerUI
{
    //==========================================Variable==========================================
    private ManagerPreMainUI preMainUI;
    private ManagerMainUI mainUI;
    private ManagerJoinShopUI joinShopUI;
    private ManagerInfoUI infoUI;
    private ManagerCreateStaffUI createStaffUI;
    private ManagerDeleteStaffUI deleteStaffUI;
    private ManagerAddItemUI addItemUI;

    //========================================Constructor=========================================
    public ManagerUI()
    {
        this.preMainUI = new ManagerPreMainUI();
        this.mainUI = new ManagerMainUI();
        this.joinShopUI = new ManagerJoinShopUI();
        this.infoUI = new ManagerInfoUI();
        this.createStaffUI = new ManagerCreateStaffUI();
        this.deleteStaffUI = new ManagerDeleteStaffUI();
        this.addItemUI = new ManagerAddItemUI();
    }

    //============================================Get=============================================
    public ManagerPreMainUI getPreMainUI() { return preMainUI; }
    public ManagerMainUI getMainUI() { return mainUI; }
    public ManagerJoinShopUI getJoinShopUI() { return joinShopUI; }
    public ManagerInfoUI getInfoUI() { return infoUI; }
    public ManagerCreateStaffUI getCreateStaffUI() { return createStaffUI; }
    public ManagerDeleteStaffUI getDeleteStaffUI() { return deleteStaffUI; }
    public ManagerAddItemUI getAddItemUI() { return addItemUI; }
}
