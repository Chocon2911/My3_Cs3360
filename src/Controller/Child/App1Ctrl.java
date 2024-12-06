package Controller.Child;

import DataBase.Child.CustomerDb;
import DataBase.Child.ManagerDb;
import DataBase.Child.StaffDb;
import Obj.Data.Customer;
import Obj.Data.Manager;
import Obj.Data.Staff;
import UI.App1.App1UI;
import UI.App1.Child.*;
import Util.ObjUtil;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class App1Ctrl
{
    private App1UI app1UI;

    //========================================Constructor=========================================
    public App1Ctrl()
    {
        this.app1UI = new App1UI();

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
            if (customer.getPassword().equals(password)) // Login Customer
            {
                customer.setIsLogin(true);
                return 1;
            }
            else return 2;
        }

        Staff staff = StaffDb.getInstance().queryStaffByUserName(userName);
        if (staff != null)
        {
            if (staff.getPassword().equals(password)) return 3; // Login Staff
            else return 4;
        }

        Manager manager = ManagerDb.getInstance().queryManagerByUserName(userName);
        if (manager != null)
        {
            if (manager.getPassword().equals(password)) return 5; // Login Manager
            else return 6; 
        }

        return 0;
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
        else if (e.contains("Customers.Id"))
        {
            System.out.println("signUp() Error: Id already exists");
            return this.signUp(name, userName, password);
        } 
        else if (e.contains("Customers.UserName")) return 1;

        return 0;
    }
}
