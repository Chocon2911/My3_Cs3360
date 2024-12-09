package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.ManagerDb;
import DataBase.Child.ShopDb;
import Obj.Data.Manager;
import Obj.Data.Shop;
import UI.Shop.Child.*;
import UI.Shop.ShopUI;
import Util.ObjUtil;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class ShopCtrl extends AbstractObjCtrl
{
    //==========================================Variable==========================================
    private ShopUI shopUI;
    
    //========================================Constructor=========================================
    public ShopCtrl()
    {
        super();
        this.shopUI = new ShopUI();

        this.defaultMainUI();
        this.defaultInfoUI();
        this.defaultCreateManagerUI();
        this.defaultChangeCheckInUI();
    }

    public ShopCtrl(String id)
    {
        super(id);
        this.shopUI = new ShopUI();

        this.login();
        this.defaultMainUI();
        this.defaultInfoUI();
        this.defaultCreateManagerUI();
        this.defaultChangeCheckInUI();
    }

    //==========================================Override==========================================
    @Override
    protected <T> String insertInfo(T info)
    {
        return ShopDb.getInstance().insertShopData((Shop)info);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final Shop queryInfo()
    {
        return ShopDb.getInstance().queryShopData(id);
    }

    @Override 
    protected <T> String updateInfo(T info)
    {
        return ShopDb.getInstance().updateShopData((Shop)info);
    }


    //============================================================================================
    //=============================================UI=============================================
    //============================================================================================
    
    //==========================================Main UI===========================================
    private void defaultMainUI()
    {
        ShopMainUI mainUI = this.shopUI.getMainUI();
        this.setDefaultClose(mainUI);

        // Info Button
        mainUI.getInfoButton().addActionListener((ActionEvent e) -> 
        {
            // Info Panel
            Shop shop = this.queryInfo();
            if (shop == null)
            {
                System.out.println("Shop is not found with Id: " + this.id);
            }
            else
            {
                this.shopUI.getInfoUI().setInfoPanel(shop);
            }

            this.shopUI.getMainUI().setVisible(false);
            this.shopUI.getInfoUI().setVisible(true);
        });

        // Create Manager Button
        mainUI.getCreateManagerButton().addActionListener((ActionEvent e) -> 
        {
            this.shopUI.getMainUI().setVisible(false);
            this.shopUI.getCreateManagerUI().setVisible(true);
        });

        // Change CheckIn Button
        mainUI.getChangeCheckInButton().addActionListener((ActionEvent e) -> 
        {
            this.shopUI.getMainUI().setVisible(false);
            this.shopUI.getChangeCheckInUI().setVisible(true);
        });

        // Quit Button
        mainUI.getQuitButton().addActionListener((ActionEvent e) -> 
        {
            if (!this.logout())
            {
                System.out.println("Logout failed.");
            }

            this.shopUI = null;
            mainUI.dispose();
            new App2Ctrl();
        });
    }

    //=======================================Information UI=======================================
    private void defaultInfoUI()
    {
        ShopInfoUI infoUI = this.shopUI.getInfoUI();
        this.setDefaultClose(infoUI);

        // Back Button
        infoUI.getBackButton().addActionListener((ActionEvent e) -> 
        {
            this.shopUI.getInfoUI().setVisible(false);
            this.shopUI.getMainUI().setVisible(true);
        });
    }

    //======================================CreateManager UI======================================
    private void defaultCreateManagerUI()
    {
        ShopCreateManagerUI createManagerUI = this.shopUI.getCreateManagerUI();
        this.setDefaultClose(createManagerUI);

        // Back Button
        createManagerUI.getBackButton().addActionListener((ActionEvent e) -> 
        {
            createManagerUI.setVisible(false);
            createManagerUI.wipeOutField();
            this.shopUI.getMainUI().setVisible(true);
        });

        // Create Button
        createManagerUI.getCreateButton().addActionListener((ActionEvent e) -> 
        {
            String name = createManagerUI.getNameTextField();
            String userName = createManagerUI.getUserNameTextField();
            String password = createManagerUI.getPasswordTextField();

            int createManager = this.createManager(name, userName, password);
            if (createManager == 1)
            {
                JOptionPane.showMessageDialog(null, "UserName is already exist or empty");
            }
            else if (createManager == 0)
            {
                JOptionPane.showMessageDialog(null, "Create Manager Success");
                createManagerUI.setVisible(false);
                createManagerUI.wipeOutField();
                this.shopUI.getMainUI().setVisible(true);
            }
        });
    }

    //======================================ChangeCheckIn UI======================================
    private void defaultChangeCheckInUI()
    {
        ShopChangeCheckInUI changeCheckInUI = this.shopUI.getChangeCheckInUI();
        this.setDefaultClose(changeCheckInUI);

        // Cancel Button
        changeCheckInUI.getCancelButton().addActionListener((ActionEvent e) -> 
        {
            changeCheckInUI.setVisible(false);
            changeCheckInUI.wipeOutField();
            this.shopUI.getMainUI().setVisible(true);
        });

        // Apply Button
        changeCheckInUI.getApplyButton().addActionListener((ActionEvent e) ->
        {
            System.out.println("//====================================Change CheckIn Code=====================================");

            // Logic Handler
            String checkInCode = changeCheckInUI.getCheckInCode();

            int changeCheckInCode = this.changeCheckInCode(checkInCode);
            if (changeCheckInCode == 1)
            {
                JOptionPane.showMessageDialog(null, "CheckIn Code is already exist");
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Change CheckIn Code Success");
                changeCheckInUI.setVisible(false);
                changeCheckInUI.wipeOutField();
                this.shopUI.getMainUI().setVisible(true);
            }
        });
    }

    //============================================================================================
    //=========================================Controller=========================================
    //============================================================================================
    
    //=======================================CreateManager========================================
    private int createManager(String name, String userName, String password)
    {
        String managerId = ObjUtil.getInstance().getRandomStr(10);
        Shop shop = this.queryInfo();
        Manager insertManager = new Manager(managerId, name, userName, password, false, shop);

        String e = ManagerDb.getInstance().insertManagerData(insertManager);
        if (e == null) return 0;
        else if (e.contains("Id"))
        {
            System.out.println("Error: Id already exists");
            return this.createManager(name, userName, password);
        }
        else if (e.contains("UserName")) return 1;

        return 0;
    }

    //====================================Change CheckIn Code=====================================
    private int changeCheckInCode(String checkInCode)
    {
        Shop shop = ShopDb.getInstance().queryShopByCheckInCode(checkInCode);
        if (shop != null) return 1;

        Shop updateShop = this.queryInfo();
        updateShop.setCheckInCode(checkInCode);
        this.updateInfo(updateShop);
        
        return 0;
    }

    //===========================================Other============================================
    private boolean logout()
    {
        Shop shop = this.queryInfo();
        if (shop == null)
        {
            System.out.println("logout(): Error: Shop not found");
            return false;
        }

        shop.setIsLogin(false);
        this.updateInfo(shop);
        return true;
    }

    private boolean login()
    {
        Shop shop = this.queryInfo();
        if (shop == null)
        {
            System.out.println("login(): Error: Shop not found");
            return false;
        }

        shop.setIsLogin(true);
        ShopDb.getInstance().updateShopData(shop);
        this.shopUI.getMainUI().setVisible(true);
        return true;
    }    
    
    private void setDefaultClose(JFrame frame)
    {
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                if (!logout())
                {
                    System.out.println("Log out failed");
                }
                
                System.exit(0);
            }
        });
    }

    //============================================Test============================================
    public static void main(String[] args) 
    {
        new ShopCtrl().shopUI.getMainUI().setVisible(true);
    }   
}