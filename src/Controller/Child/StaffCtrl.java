package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.*;
import Obj.Data.*;
import UI.Staff.StaffUI;
import UI.Staff.Child.*;
import Util.ObjUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class StaffCtrl extends AbstractObjCtrl
{
    private StaffUI staffUI;

    //========================================Constructor=========================================
    public StaffCtrl()
    { 
        super(); 
        this.staffUI = new StaffUI();
        this.defaultStaffMainUI();
        this.defaultStaffInfoUI();
        this.defaultDepositCustomerUI();
        this.defaultCustomerRequestUI();
    }
    public StaffCtrl(String id) 
    { 
        super(id);
        this.staffUI = new StaffUI();
        this.defaultStaffMainUI();
        this.defaultStaffInfoUI();
        this.defaultDepositCustomerUI();
        this.defaultCustomerRequestUI(); 
    }

    //============================================================================================
    //=============================================UI=============================================
    //============================================================================================

    //==========================================Main Staff UI=====================================
    private void defaultStaffMainUI()
    {
        StaffMainUI staffMainUI = staffUI.getStaffMainUI();

        // Display Staff Information Button
        staffMainUI.getDisplayInformationButton().addActionListener((ActionEvent e) ->
        {
            // Get Customer Infomation
            staffMainUI.setVisible(false);
            staffUI.getInforUI().setVisible(true);
        });

        // Deposit Customer Button
        staffMainUI.getDepositButton().addActionListener((ActionEvent e) ->
        {
            staffMainUI.setVisible(false);
            staffUI.getDepositUI().setVisible(true);
        });

        // Display Customer Request Button
        staffMainUI.getDisplayRequestButton().addActionListener((ActionEvent e) ->
        {
            staffMainUI.setVisible(false);
            staffUI.getRequestUI().setVisible(true);
        });

        // Quit Button
        staffMainUI.getQuitButton().addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });
    }

    //==========================================Staff Information UI==============================
    private void defaultStaffInfoUI()
    {
        StaffInfoUI staffInfoUI = staffUI.getInforUI();

        // Display

        // Back Button
        staffInfoUI.getBackButton().addActionListener((ActionEvent e) ->
        {
            staffInfoUI.setVisible(false);
            staffUI.getStaffMainUI().setVisible(true);
        });
    }

    //==========================================Customer Desposit UI==============================
    private void defaultDepositCustomerUI()
    {
        StaffDepositCustomerUI staffDepositUI = staffUI.getDepositUI();

        // Accept Button
        staffDepositUI.getAcceptButton().addActionListener((ActionEvent e) -> 
        {
            // Accept Handle
            String id = staffDepositUI.getCustomerId();
            String amount = staffDepositUI.getDepositAmount();

            System.out.println("ID: " + id);
            System.out.println("Amount: " + amount);

            int accept = this.accept(id, amount);

            if (accept == 0)
            {
                JOptionPane.showMessageDialog(null, "Successfully Deposited: " + amount + " $");
                staffDepositUI.setVisible(false);
                staffUI.getStaffMainUI().setVisible(true);
            }
            else if (accept == 1)
            {
                JOptionPane.showMessageDialog(null, "Customer ID Not Found");
            }
        });

        // Cancel Button
        staffDepositUI.getCancelButton().addActionListener((ActionEvent e) ->
        {
            staffDepositUI.setVisible(false);
            staffUI.getStaffMainUI().setVisible(true);
        });
    }

    //==========================================Customer Request UI===============================
    private void defaultCustomerRequestUI()
    {
        StaffCustomerRequestUI staffRequestUI = staffUI.getRequestUI();

        // Display

        // Back Button
        staffRequestUI.getBackButton().addActionListener((ActionEvent e) ->
        {
            staffRequestUI.setVisible(false);
            staffUI.getStaffMainUI().setVisible(true);
        });
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
        return new StaffDb().queryStaffData(id);
    }
    @Override 
    protected <T> String updateInfo(T info)
    {
        return new StaffDb().updateStaffData((Staff)info);
    }

//============================================================================================
//=========================================Controller=========================================
//============================================================================================

//===========================================Accept===========================================

private int accept(String id, String amount)
{
    Shop shop = ShopDb.getInstance().queryShopData(id);
    if (shop == null) return 1; // ID Not Found
    return 0;
}

//============================================Test============================================
    public static void main(String[] args) 
    {
        new StaffCtrl().staffUI.getStaffMainUI().setVisible(true);
    }
}