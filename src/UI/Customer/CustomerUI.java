package UI.Customer;

import UI.Customer.Child.*;

public class CustomerUI 
{
    //==========================================Variable==========================================
    private CusPreMainUI pmui;
    private CusMainUI cmui;
    private CusInforUI ciui;
    private CusShoppingUI csui;
    private CusCartUI ccui;
    private ItemInforUI iiui;
    private CusCheckShopCodeUI cscui;

    //========================================Constructor=========================================
    public CustomerUI()
    {
        this.pmui = new CusPreMainUI();
        this.cmui = new CusMainUI();
        this.ciui = new CusInforUI();
        this.csui = new CusShoppingUI();
        this.ccui = new CusCartUI();
        this.iiui = new ItemInforUI();
        this.cscui = new CusCheckShopCodeUI();
    }

    //============================================Get=============================================
    public CusPreMainUI getPreMainUI()
    {
        return pmui;
    }
    public CusMainUI getMainUI()
    {
        return cmui;
    }
    public CusInforUI getInforUI()
    {
        return ciui;
    }
    public CusShoppingUI getShoppingUI()
    {
        return csui;
    }
    public CusCartUI getCartUI()
    {
        return ccui;
    }
    public ItemInforUI getItemInforUI()
    {
        return iiui;
    }
    public CusCheckShopCodeUI getCheckShopCodeUI()
    {
        return cscui;
    }
}