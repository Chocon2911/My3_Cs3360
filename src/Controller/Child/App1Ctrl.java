package Controller.Child;

import DataBase.Child.CustomerDb;
import DataBase.Child.CustomerRequestDb;
import DataBase.Child.ItemDb;
import DataBase.Child.ManagerDb;
import DataBase.Child.RequestedItemDb;
import DataBase.Child.ShopDb;
import DataBase.Child.StaffDb;
import Obj.Data.Customer;
import Obj.Data.Manager;
import Obj.Data.Staff;
import UI.App1.App1UI;
import UI.App1.Child.*;
import Util.ObjUtil;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App1Ctrl
{
    private App1UI app1UI;

    //========================================Constructor=========================================
    public App1Ctrl()
    {
        this.app1UI = new App1UI();

        this.app1UI.getMainUI().setVisible(true);
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
        App1MainUI mainUI = app1UI.getMainUI();
        this.setDefaultClose(mainUI);

        // Login Button
        mainUI.getLoginButton().addActionListener((ActionEvent e) -> 
        { 
            mainUI.setVisible(false);
            app1UI.getLoginUI().setVisible(true);
        });

        // SignUp Button
        mainUI.getSignUpButton().addActionListener((ActionEvent e) -> 
        {
            mainUI.setVisible(false);
            app1UI.getSignUpUI().setVisible(true);
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
        App1LoginUI loginUI = app1UI.getLoginUI();
        this.setDefaultClose(loginUI);

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

            if (login == 0) // Wrong UserName
            {
                JOptionPane.showMessageDialog(null, "Username not found!");
            }
            else if (login == 2 || login == 4 || login == 6) // Wrong Password
            {
                JOptionPane.showMessageDialog(null, "Wrong Password!");
            }
            else if (login == 7 || login == 8 || login == 9) // Already Login
            {
                JOptionPane.showMessageDialog(null, "User Already Login!");
            }
            else // True UserName and Password
            {
                System.out.println("Login Success!");
                JOptionPane.showMessageDialog(null, "Login Success!");
                loginUI.setVisible(false);

                if (login == 1) // Login Customer
                {
                    System.out.println("Login Customer");
                    new CustomerCtrl(this.getCustomerId(userName, password));
                }
                else if (login == 3) // Login Staff
                {
                    System.out.println("Login Staff");
                    new StaffCtrl(this.getStaffId(userName, password));
                }
                else if (login == 5) // Login Manager
                {
                    System.out.println("Login Manager");
                    new ManagerCtrl(this.getManagerId(userName, password));
                }
                else
                {
                    System.out.println("displayLogin() Error: Login = " + login);
                }
            }
        });

        // Cancel Button
        loginUI.getCancelButton().addActionListener((ActionEvent e) -> 
        { 
            loginUI.setVisible(false);
            loginUI.wipeOutField();
            app1UI.getMainUI().setVisible(true);
        });
    }

    //=========================================SignUp UI==========================================
    private void defaultSignUpUI()
    {
        App1SignUpUI signUpUI = this.app1UI.getSignUpUI();
        this.setDefaultClose(signUpUI);

        // Register Button
        signUpUI.getRegisterButton().addActionListener((ActionEvent e) -> 
        { 
            System.out.println("//==========================================Register==========================================");

            String name = signUpUI.getNameStr();
            String userName = signUpUI.getUserName();
            String password = signUpUI.getPassword();

            System.out.println("Name: " + name);
            System.out.println("UserName: " + userName);
            System.out.println("Password: " + password);

            int signUp = this.signUp(name, userName, password);
            if (signUp == 1) 
            {
                System.out.println("UserName already exists");
                JOptionPane.showMessageDialog(null, "Username already exists!");
            }
            else if (signUp == 0)
            {
                System.out.println("Sign Up Success!");
                JOptionPane.showMessageDialog(null, "Sign Up Success!");
                signUpUI.setVisible(false);
                signUpUI.wipeOutField();
                app1UI.getMainUI().setVisible(true);
            }
        });

        // Cancel Button
        signUpUI.getCancelButton().addActionListener((ActionEvent e) -> 
        { 
            signUpUI.setVisible(false);
            signUpUI.wipeOutField();
            app1UI.getMainUI().setVisible(true);
        });
    }



    //============================================================================================
    //=========================================Controller=========================================
    //============================================================================================

    //===========================================Login============================================
    private int login(String userName, String password)
    {
        Customer customer = CustomerDb.getInstance().queryCustomerByUserName(userName);
        if (customer != null)
        {
            if (!customer.getPassword().equals(password)) return 2; // Password Wrong
            if (customer.getIsLogin()) return 7; // Customer Already Login

            customer.setIsLogin(true);
            return 1; // Login Customer   
        }

        Staff staff = StaffDb.getInstance().queryStaffByUserName(userName);
        if (staff != null)
        {
            if (!staff.getPassword().equals(password)) return 4; // Password Wrong
            if (staff.getIsLogin()) return 8; // Staff Already Login

            staff.setIsLogin(true);
            return 3; // Login Staff
        }

        Manager manager = ManagerDb.getInstance().queryManagerByUserName(userName);
        if (manager != null)
        {
            if (!manager.getPassword().equals(password)) return 6; // Password Wrong
            if (manager.getIsLogin()) return 9; // Manager Already Login

            manager.setIsLogin(true); 
            return 5; // Login Manager
        }

        return 0; // Wrong UserName
    }

    private String getCustomerId(String userName, String password)
    {
        Customer customer = CustomerDb.getInstance().queryCustomerByUserName(userName);
        if (customer == null) return null;
        else if (!customer.getPassword().equals(password)) return null;
        
        return customer.getId();
    }

    private String getStaffId(String userName, String password)
    {
        Staff staff = StaffDb.getInstance().queryStaffByUserName(userName);
        if (staff == null) return null;
        else if (!staff.getPassword().equals(password)) return null;
        
        return staff.getId();
    }

    private String getManagerId(String userName, String password)
    {
        Manager manager = ManagerDb.getInstance().queryManagerByUserName(userName);
        if (manager == null) 
        {
            System.out.println("getManagerId(): wrong userName: " + userName);
            return null;
        }
        else if (!manager.getPassword().equals(password))
        {
            System.out.println("getManagerId(): wrong password: " + password);
            return null;
        }
        
        return manager.getId();
    }

    //===========================================SignUp===========================================
    private int signUp(String name, String userName, String password)
    {
        String id = ObjUtil.getInstance().getRandomStr(10);
        Customer customer = new Customer(id, name, userName, password, false, 0);

        String e = CustomerDb.getInstance().insertCustomerData(customer);
        if (e == null) return 0;
        else if (e.contains("Id"))
        {
            System.out.println("signUp() Error: Id already exists");
            return this.signUp(name, userName, password);
        } 
        else if (e.contains("UserName")) return 1;

        return 0;
    }

    private void setDefaultClose(JFrame frame)
    {
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }

    //============================================Test============================================
    public static void main(String[] args) 
    {
        ShopDb.getInstance().createShopTable();
        CustomerDb.getInstance().createCustomerTable();
        StaffDb.getInstance().createStaffTable();
        ManagerDb.getInstance().createManagerTable();
        ItemDb.getInstance().createItemTable();
        RequestedItemDb.getInstance().createRequestedItemTable();
        CustomerRequestDb.getInstance().createCustomerRequestTable();


        new App1Ctrl();
    }
}
