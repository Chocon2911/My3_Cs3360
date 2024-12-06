package Controller.Child;

import DataBase.Child.ShopDb;
import Obj.Data.Shop;
import UI.App2.App2UI;
import UI.App2.Child.*;
import Util.ObjUtil;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class App2Ctrl
{
    private App2UI app2UI;
    
    //========================================Constructor=========================================
    public App2Ctrl()
    {
        this.app2UI = new App2UI();

        this.app2UI.getMainUI().setVisible(true);
        this.defaultMainUI();
        this.defaultLoginUI();
        this.defaultSignUpUI();
    }

    //============================================================================================
    //=============================================UI=============================================
    //============================================================================================

    //==========================================Main UI===========================================
    private void defaultMainUI()
    {
        App2MainUI mainUI = app2UI.getMainUI();

        // Login Button
        mainUI.getLoginButton().addActionListener((ActionEvent e) -> 
        { 
            mainUI.setVisible(false);
            app2UI.getLoginUI().setVisible(true);
        });

        // SignUp Button
        mainUI.getSignUpButton().addActionListener((ActionEvent e) -> 
        { 
            mainUI.setVisible(false);
            app2UI.getSignUpUI().setVisible(true);
        });

        // Quit Button
        mainUI.getQuitButton().addActionListener((ActionEvent e) -> 
        { 
            System.exit(0);
        });
    }

    //==========================================Login UI==========================================
    private void defaultLoginUI()
    {
        App2LoginUI loginUI = app2UI.getLoginUI();

        // Login Button
        loginUI.getLoginButton().addActionListener((ActionEvent e) -> 
        { 
            System.out.println("//===========================================Login============================================");

            // Login Handle
            String userName = loginUI.getUserName();
            String password = loginUI.getPassword();

            System.out.println("UserName: " + userName);
            System.out.println("Password: " + password);
            
            int login = this.login(userName, password);

            if (login == 0)
            {
                System.out.println("Login Success");
                JOptionPane.showMessageDialog(null, "Login Success");
                loginUI.setVisible(false);
                new ShopCtrl(this.getUserId(userName, password));
                this.app2UI = null; // Delete
            }
            else if (login == 1) 
            {
                JOptionPane.showMessageDialog(null, "User Name Not Found");
            }
            else if (login == 2) 
            {
                JOptionPane.showMessageDialog(null, "Password Wrong");
            }
        });

        // Cancel Button
        loginUI.getCancelButton().addActionListener((ActionEvent e) -> 
        { 
            loginUI.setVisible(false);
            loginUI.wipeOutField();
            app2UI.getMainUI().setVisible(true);
        });
    }

    //=========================================SignUp UI==========================================
    private void defaultSignUpUI()
    {
        App2SignUpUI signUpUI = app2UI.getSignUpUI();

        // Register Button
        signUpUI.getRegisterButton().addActionListener((ActionEvent e) -> 
        { 
            System.out.println("//==========================================Register==========================================");

            // Register Handle
            String name = signUpUI.getNameStr();
            String userName = signUpUI.getUserName();
            String password = signUpUI.getPassword();
            String systemCode = signUpUI.getSystemCode();
            String checkInCode = signUpUI.getCheckInCode();

            System.out.println("Name: " + name);
            System.out.println("UserName: " + userName);
            System.out.println("Password: " + password);
            System.out.println("SystemCode: " + systemCode);
            System.out.println("CheckInCode: " + checkInCode);

            int signUp = this.signUp(name, userName, password, checkInCode, systemCode);
            if (signUp == 1)
            {
                JOptionPane.showMessageDialog(null, "User Name already exists");
            }
            else if (signUp == 2)
            {
                JOptionPane.showMessageDialog(null, "Check In Code already exists");
            }
            else if (signUp == 0) 
            {
                JOptionPane.showMessageDialog(null, "Register Success");
                signUpUI.setVisible(false);
                signUpUI.wipeOutField();
                app2UI.getMainUI().setVisible(true);
            }

        });

        // Cancel Button
        signUpUI.getCancelButton().addActionListener((ActionEvent e) -> 
        { 
            signUpUI.setVisible(false);
            signUpUI.wipeOutField();
            app2UI.getMainUI().setVisible(true);
        });
    }

    //============================================================================================
    //=========================================Controller=========================================
    //============================================================================================

    //===========================================Login============================================
    private int login(String userName, String password)
    {
        Shop shop = ShopDb.getInstance().queryShopByUserName(userName);
        if (shop == null) return 1; // UserName Not Found
        else if (!shop.getPassword().equals(password)) return 2; // Password Wrong
        
        return 0;
    }

    private String getUserId(String userName, String password)
    {
        Shop shop = ShopDb.getInstance().queryShopByUserName(userName);
        if (shop == null) return null;
        else if (!shop.getPassword().equals(password)) return null;

        return shop.getId();
    }

    //===========================================SignUp===========================================
    private int signUp(String name, String userName, String password, String checkInCode, String systemCode)
    {
        String shopId = ObjUtil.getInstance().getRandomStr(10);
        Shop shop = new Shop(shopId, name, userName, password, false, systemCode, checkInCode, null, null, null, null, null);

        String e = ShopDb.getInstance().insertShopData(shop);
        if (e == null) return 0;
        else if (e.contains("Shops.Id"))
        {
            System.out.println("Error: Id already exists");
            return this.signUp(name, userName, password, checkInCode, systemCode);
        }
        else if (e.contains("Shops.UserName")) return 1;
        else if (e.contains("Shops.CheckInCode")) return 2;

        return 0;
    }

    //============================================Test============================================
    public static void main(String[] args) 
    {
        new App2Ctrl().app2UI.getMainUI().setVisible(true);
    }
}
