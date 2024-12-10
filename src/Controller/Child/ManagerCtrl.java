package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.*;
import Obj.Data.*;
import UI.Staff.Child.StaffCustomerRequestInfoUI;
import UI.Staff.Child.StaffCustomerRequestUI;
import UI.Staff.Child.StaffDepositCustomerUI;
import UI.Staff.Child.StaffInfoUI;
import UI.Staff.Child.StaffMainUI;
import UI.Staff.Child.StaffPreMainUI;
import UI.Staff.StaffUI;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class StaffCtrl extends AbstractObjCtrl
{
    private StaffUI staffUI;

    //========================================Constructor=========================================
    public StaffCtrl() 
    { 
        super();
        this.staffUI = new StaffUI();

        this.defaultPreMainUI();
        this.defaultMainUI();
        this.defaultInfoUI();
        this.defaultDepositCustomerUI();
        this.defaultCustomerRequestUI();
        this.defaultCustomerRequestInfoUI();
    }
    public StaffCtrl(String id) 
    { 
        super(id); 
        this.staffUI = new StaffUI();

        this.login();
        this.defaultPreMainUI();
        this.defaultMainUI();
        this.defaultInfoUI();
        this.defaultDepositCustomerUI();
        this.defaultCustomerRequestUI();
        this.defaultCustomerRequestInfoUI();

        this.staffUI.getPreMainUI().setVisible(true);
    }

    //==========================================Override==========================================
    @Override
    protected <T> String insertInfo(T info)
    {
        return new StaffDb().insertStaffData((Staff)info);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final Staff queryInfo()
    {
        Staff staff = new StaffDb().queryStaffData(id);
        if (staff == null)
        {
            System.out.println("Staff not found: " + id);
        }

        return staff;
    }

    @Override 
    protected <T> String updateInfo(T info)
    {
        return new StaffDb().updateStaffData((Staff)info);
    }

    //============================================================================================
    //=============================================UI=============================================
    //============================================================================================
    
    //=========================================PreMain UI=========================================
    private void defaultPreMainUI()
    {
        StaffPreMainUI preMainUI = this.staffUI.getPreMainUI();
        this.setDefaultClose(preMainUI);

        // Info Button
        preMainUI.getInfoButton().addActionListener((ActionEvent e) ->
        {
            Staff staff = this.queryInfo();

            this.staffUI.getInfoUI().setInfoPanel(staff);
            preMainUI.setVisible(false);
            preMainUI.setVisible(true);
        });

        // JoinShop Button
        preMainUI.getJoinShopButton().addActionListener((ActionEvent e) -> 
        {
            preMainUI.setVisible(false);
            preMainUI.setVisible(true);
        });

        // Quit Button
        preMainUI.getQuitButton().addActionListener((ActionEvent e) -> 
        {
            if (!logout())
            {
                System.out.println("Logout failed");
            }


            new App1Ctrl();
        });
    }

    //==========================================Main UI===========================================
    private void defaultMainUI()
    {
        StaffMainUI mainUI = this.staffUI.getMainUI();
        this.setDefaultClose(mainUI);
    }

    //==========================================Info UI===========================================
    private void defaultInfoUI()
    {
        StaffInfoUI infoUI = this.staffUI.getInfoUI();
        this.setDefaultClose(infoUI);
    }

    //=====================================DepositCustomer UI=====================================
    private void defaultDepositCustomerUI()
    {
        StaffDepositCustomerUI depositCustomerUI = this.staffUI.getDepositCustomerUI();
        this.setDefaultClose(depositCustomerUI);
    }

    //=====================================CustomerRequest UI=====================================
    private void defaultCustomerRequestUI()
    {
        StaffCustomerRequestUI customerReqUI = this.staffUI.getCustomerRequestUI();
        this.setDefaultClose(customerReqUI);
    }

    //===================================CustomerRequestInfo UI===================================
    private void defaultCustomerRequestInfoUI()
    {
        StaffCustomerRequestInfoUI customerReqInfoUI = this.staffUI.getCusteomRequestInfoUI();
        this.setDefaultClose(customerReqInfoUI);
    }

    

    //============================================================================================
    //=========================================Controller=========================================
    //============================================================================================
    
    //===========================================Other============================================
    private boolean login()
    {
        Staff staff = this.queryInfo();
        if (staff == null)
        {
            System.out.println("login(): Error: Staff not found");
            return false;
        }

        staff.setIsLogin(true);
        this.updateInfo(staff);
        return true;
    } 

    private boolean logout()
    {
        this.cleanUI();
        
        Staff staff = this.queryInfo();
        if (staff == null)
        {
            System.out.println("logout(): Error: Staff not found");
            return false;
        }

        staff.setIsLogin(false);
        this.updateInfo(staff);
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

                System.out.println("Log out successfully");
                System.exit(0);
            }
        });
    }

    private void cleanUI()
    {
        this.staffUI.getPreMainUI().dispose();
        this.staffUI.getMainUI().dispose();
        this.staffUI.getInfoUI().dispose();
        this.staffUI.getDepositCustomerUI().dispose();
        this.staffUI.getCustomerRequestUI().dispose();
        this.staffUI.getCusteomRequestInfoUI().dispose();
        this.staffUI = null;
    }

    //============================================Test============================================
    public static void main(String[] args) 
    {
        
    }
}
