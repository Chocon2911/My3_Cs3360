package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.*;
import Obj.Data.*;
import UI.Staff.StaffUI;
import UI.Staff.Child.*;
import Util.ObjUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.plaf.TreeUI;

public class StaffCtrl extends AbstractObjCtrl
{
    private StaffUI staffUI;

    //========================================Constructor=========================================
    public StaffCtrl()
    { 
        super(); 
        this.staffUI = new StaffUI();
        this.defaultStaffPreMainUI();
        this.defaultStaffCheckinUI();
        this.defaultStaffMainUI();
        this.defaultStaffInfoUI();
        this.defaultDepositCustomerUI();
        this.defaultCustomerRequestUI();
        this.defaultRequestedItemsUI();
    }
    public StaffCtrl(String id) 
    { 
        super(id);
        this.staffUI = new StaffUI();
        this.defaultStaffPreMainUI();
        this.defaultStaffCheckinUI();
        this.defaultStaffMainUI();
        this.defaultStaffInfoUI();
        this.defaultDepositCustomerUI();
        this.defaultCustomerRequestUI(); 
        this.defaultRequestedItemsUI();
        staffUI.getPreMainStaffUI().setVisible(true); 
    }

    //============================================================================================
    //=============================================UI=============================================
    //============================================================================================

    //======================================Pre Main Staff UI=====================================
    private void defaultStaffPreMainUI()
    {
        StaffPreMainUI staffPreMainUI = staffUI.getPreMainStaffUI();

        // Display Staff Information Button
        staffPreMainUI.getDisplayInformationButton().addActionListener((ActionEvent e) ->
        {
            StaffInfoUI infoUI = staffUI.getInforUI();
            Staff staff = StaffDb.getInstance().queryStaffData(id);
            infoUI.setStaffInfo(staff);
            staffPreMainUI.setVisible(false);
            staffUI.getInforUI().setVisible(true);
        });

        // Checkin code Button
        staffPreMainUI.getCheckinButton().addActionListener((ActionEvent e) -> 
        {
            staffPreMainUI.setVisible(false);
            staffUI.getStaffCheckinUI().setVisible(true);
        });

        // Quit Button
        staffPreMainUI.getQuitButton().addActionListener((ActionEvent e) ->
        {
            System.exit(0);
        });
    }
    //========================================Staff Checkin UI====================================
    private void defaultStaffCheckinUI()
    {
        StaffCheckinCode staffCheckinUI = staffUI.getStaffCheckinUI();

        // Enter Button
        staffCheckinUI.getEnterButton().addActionListener((ActionEvent e) -> 
        {
            // Enter Handle
            String checkinCode = staffCheckinUI.getCheckinCode(); // Get Checkin Code

            int enter = this.enter(checkinCode);

            if (enter == 0)
            {
                JOptionPane.showMessageDialog(null, "Successfully Joined: ");
                staffCheckinUI.setVisible(false);
                staffUI.getPreMainStaffUI().setVisible(true);
            }
            else if (enter == 1)
            {
                JOptionPane.showMessageDialog(null, "Wrong Checkin Code");
            }
            else if (enter == 2)
            {
                JOptionPane.showMessageDialog(null, "Shop isn't online yet"); 
            }
        });

        // Cancel Button
        staffCheckinUI.getCancelButton().addActionListener((ActionEvent e) ->
        {
            staffCheckinUI.setVisible(false);
            staffUI.getPreMainStaffUI().setVisible(true);
        });

    }

    //==========================================Main Staff UI=====================================
    private void defaultStaffMainUI()
    {
        StaffMainUI staffMainUI = staffUI.getStaffMainUI();

        // Display Staff Information Button
        staffMainUI.getDisplayInformationButton().addActionListener((ActionEvent e) ->
        {
            StaffInfoUI infoUI = staffUI.getInforUI();
            Staff staff = StaffDb.getInstance().queryStaffData(id);
            infoUI.setStaffInfo(staff);
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

        // Back Button
        staffInfoUI.getBackButton().addActionListener((ActionEvent e) ->
        {
            staffInfoUI.setVisible(false);
            Staff staff = this.queryInfo();
            if (staff.getShop()== null)
            {
                staffUI.getPreMainStaffUI().setVisible(true);
            }
            else if (staff.getShop()!= null)
            {
                staffUI.getStaffMainUI().setVisible(true);
            }
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
            String username = staffDepositUI.getCustomerName(); // Get UserName
            String amount = staffDepositUI.getDepositAmount();

            System.out.println("Username: " + username);
            System.out.println("Amount: " + amount);

            int accept = this.accept(username, amount);

            if (accept == 0)
            {
                JOptionPane.showMessageDialog(null, "Successfully Deposited: " + amount + " $");
                staffDepositUI.setVisible(false);
                staffUI.getStaffMainUI().setVisible(true);
            }
            else if (accept == 1)
            {
                JOptionPane.showMessageDialog(null, "Customer Username Not Found");
            }
            else if (accept == 2)
            {
                JOptionPane.showMessageDialog(null, "Amount is invalid");
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

    //======================================Requested Items UI====================================
    private void defaultRequestedItemsUI()
    {
        StaffRequestedItemsUI requestedItemsUI = staffUI.geItemsUI();

        // Back Button
        requestedItemsUI.getBackButton().addActionListener((ActionEvent e) ->
        {
            requestedItemsUI.setVisible(false);
            staffUI.getRequestUI().setVisible(true);
        });

        // Refuse Button
        requestedItemsUI.getRefuseButton().addActionListener((ActionEvent e) -> 
        {
            JOptionPane.showMessageDialog(null, "Request Refused");
            requestedItemsUI.setVisible(false);
            staffUI.getRequestUI().setVisible(true);
        });

        // Accept Button
        requestedItemsUI.getAcceptButton().addActionListener((ActionEvent e) -> 
        {
            JOptionPane.showMessageDialog(null, "Request Accepted");
            requestedItemsUI.setVisible(false);
            staffUI.getRequestUI().setVisible(true);
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
        Staff staff = new StaffDb().queryStaffData(id);
        if (staff == null)
        {
            System.out.println("Staff not found: " + id);
            return null;
        }

        List<CustomerRequest> crs = new ArrayList<>();
        for (CustomerRequest cr : staff.getCustomerRequests())
        {
            CustomerRequest newCr = CustomerRequestDb.getInstance().queryCustomerRequestData(cr.getId());
            List<RequestedItem> ris = new ArrayList<>();
            // Get RequestedItems of CustomerRequest From Db
            for (RequestedItem ri : newCr.getRequestedItems())
            {
                RequestedItem newRi = RequestedItemDb.getInstance().queryRequestedItemData(ri.getId());
                ris.add(newRi);
            }
            
            newCr.setRequestedItems(ris);
            crs.add(newCr);
        }
        
        staff.setCustomerRequests(crs);
        return staff;
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

private int accept(String username, String amount) //
{
    try
    {   
        float amountFloat = Float.parseFloat(amount);
        if (amountFloat < 0){return 2;}
        Customer customer = CustomerDb.getInstance().queryCustomerByUserName(username); //
        if (customer == null) {return 1;} // Name Not Found
        float balance = amountFloat + customer.getBalance();
        customer.setBalance(balance);
        CustomerDb.getInstance().updateCustomerData(customer);
        return 0;
    }
    catch (NumberFormatException e)
    {
        System.out.println("StaffCtrl.accept() Error: amount = " + amount);
        return 2; // Amount is not an integer
    }
}
//============================================Enter===========================================
private int enter (String checkincode)
{
    Shop shop = ShopDb.getInstance().queryShopByCheckInCode(checkincode);
    if (shop == null) {return 1;} // Wrong Checkin Code
    else if (!shop.getIsLogin()){return 2;}  // Shop is not online yet
    return 0;
}

//============================================Test============================================
    public static void main(String[] args) 
    {
        new StaffCtrl().staffUI.getRequestUI().setVisible(true);
    }
}