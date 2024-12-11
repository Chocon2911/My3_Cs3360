package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.*;
import Obj.Data.*;
import UI.Staff.Child.*;
import UI.Staff.StaffUI;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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

        this.login();
    }


    
    //============================================================================================
    //=============================================UI=============================================
    //============================================================================================

    //======================================Pre Main Staff UI=====================================
    private void defaultStaffPreMainUI()
    {
        StaffPreMainUI staffPreMainUI = staffUI.getPreMainStaffUI();
        this.setDefaultClose(staffPreMainUI);

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
            if (!this.logout())
            {
                System.out.println("Log out failed");
            }

            System.exit(0);
        });
    }
    //========================================Staff Checkin UI====================================
    private void defaultStaffCheckinUI()
    {
        StaffCheckinCode staffCheckinUI = staffUI.getStaffCheckinUI();
        this.setDefaultClose(staffCheckinUI);

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
                staffUI.getStaffMainUI().setVisible(true);
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
        this.setDefaultClose(staffMainUI);

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
            System.out.println("//=======================================Display Request=======================================");
            Staff staff = this.queryInfo();
            Shop shop = staff.getShop();
            shop = ShopDb.getInstance().queryShopData(shop.getId());
            List<CustomerRequest> shopCrs = shop.getCustomerRequests();
            if (shopCrs == null || shopCrs.isEmpty())
            {
                System.out.println("MainUI(): Request Button: CustomerRequest is null");
                return;
            }

            List<CustomerRequest> crs = new ArrayList<>();
            System.out.println("Bug here: " + shopCrs.size());
            for (CustomerRequest staffCr : shopCrs)
            {
                CustomerRequest newCr = CustomerRequestDb.getInstance().queryCustomerRequestData(staffCr.getId());
                if (newCr.getHandledStaff() != null) continue;
                crs.add(newCr);
            }

            // CustomerRequest Buttons
            staffUI.getRequestUI().setCustomerReqsPanel(crs);
            List<JButton> customerReqButtons = staffUI.getRequestUI().getCustomerReqButtons();
            if (customerReqButtons == null || customerReqButtons.isEmpty()) {}
            
            else 
            {
                int index = 0;
                for (JButton customerReqButton : customerReqButtons)
                {
                    int tempIndex = index;
                    customerReqButton.addActionListener((ActionEvent e1) -> 
                    {
                        // Chosen CustomerRequest
                        CustomerRequest chosenCr = staffUI.getRequestUI().getCustomerReqs().get(tempIndex);
                        chosenCr = CustomerRequestDb.getInstance().queryCustomerRequestData(chosenCr.getId());
                        
                        // Panel
                        this.staffUI.geRequestInfoUI().setCustomerRequestPanel(chosenCr);
                        staffUI.getRequestUI().setVisible(false);
                        staffUI.geRequestInfoUI().setVisible(true);
                    });
                    index++;
                }
            }

            this.defaultCustomerRequestUI();
            staffMainUI.setVisible(false);
            staffUI.getRequestUI().setVisible(true);
        });

        // Quit Button
        staffMainUI.getQuitButton().addActionListener((ActionEvent e) ->
        {
            if (!this.logout())
            {
                System.out.println("Log out failed");
            }

            System.exit(0);
        });
    }

    //==========================================Staff Information UI==============================
    private void defaultStaffInfoUI()
    {
        StaffInfoUI staffInfoUI = staffUI.getInforUI();
        this.setDefaultClose(staffInfoUI);

        // Back Button
        staffInfoUI.getBackButton().addActionListener((ActionEvent e) ->
        {
            staffInfoUI.setVisible(false);
            Staff staff = this.queryInfo();
            if (staff.getShop()== null)
            {
                System.out.println();
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
        this.setDefaultClose(staffDepositUI);

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
        StaffCustomerRequestUI requestUI = staffUI.getRequestUI();
        this.setDefaultClose(requestUI);

        // Back Button
        staffUI.getRequestUI().getBackButton().addActionListener((ActionEvent e) ->
        {
            staffUI.getRequestUI().setVisible(false);
            staffUI.getStaffMainUI().setVisible(true);
        });
    }

    //======================================Request Info UI=======================================
    private void defaultRequestedItemsUI()
    {
        StaffCustomerRequestInfoUI requestInfoUI = staffUI.geRequestInfoUI();
        this.setDefaultClose(requestInfoUI);

        // Back Button
        requestInfoUI.getBackButton().addActionListener((ActionEvent e) ->
        {
            requestInfoUI.setVisible(false);
            staffUI.getRequestUI().setVisible(true);
        });

        // Refuse Button
        requestInfoUI.getRefuseButton().addActionListener((ActionEvent e) ->
        {
            System.out.println("//=======================================Refuse Request=======================================");
            int refuseRequest = this.refuseRequest(requestInfoUI.getCustomerRequest());
            if (refuseRequest == 3)
            {
                JOptionPane.showMessageDialog(null, "Request Already Handled");
                requestInfoUI.setVisible(false);
                staffUI.getRequestUI().setVisible(true);
            }

            else if (refuseRequest == 0)
            {
                JOptionPane.showMessageDialog(null, "Request Refused");
                requestInfoUI.setVisible(false);
                staffUI.getRequestUI().setVisible(true);
            }
        });

        // Accept Button
        requestInfoUI.getAcceptButton().addActionListener((ActionEvent e) -> 
        {
            System.out.println("//=======================================Accept Request=======================================");
            int acceptRequest = this.acceptRequest(requestInfoUI.getCustomerRequest());
            if (acceptRequest == 3)
            {
                JOptionPane.showMessageDialog(null, "Request Already Handled");
                requestInfoUI.setVisible(false);
                staffUI.getRequestUI().setVisible(true);
            }
            else if (acceptRequest == 0)
            {
                JOptionPane.showMessageDialog(null, "Request Accepted");
                requestInfoUI.setVisible(false);
                staffUI.getRequestUI().setVisible(true);
            }
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
            if (newCr.getRequestedItems() == null || newCr.getRequestedItems().isEmpty()) continue;
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
        if (shop == null) {
            System.out.println("going to shop null: " + checkincode);
            return 1;} // Wrong Checkin Code
        else if (!shop.getIsLogin()){
            System.out.println("Going to shop isnt online ");
            return 2;}  // Shop is not online yet
        // Update shop id to staff
        else{
            System.out.println("Shop success " + checkincode);
            Staff staff = StaffDb.getInstance().queryStaffData(id);
            staff.setShop(shop);
            StaffDb.getInstance().updateStaffData(staff);
            return 0;
        }

    }

    //=======================================Accept Request=======================================
    public int acceptRequest(CustomerRequest customerRequest)
    {
        if (customerRequest == null) // CustomerRequest is null
        {
            System.out.println("acceptRequest(): CustomerRequest is null");
            return 1;
        }

        CustomerRequest queriedCustomerReq = CustomerRequestDb.getInstance().queryCustomerRequestData(customerRequest.getId());
        if (queriedCustomerReq == null) // Id not found
        {
            System.out.println("acceptRequest(): CustomerRequest not found: " + customerRequest.getId());
            return 2;
        }

        if (queriedCustomerReq.getHandledStaff() != null) // Already handled
        {
            System.out.println("acceptRequest(): CustomerRequest already handled: " + customerRequest.getId());
            return 3;
        }

        queriedCustomerReq.setHandledStaff(this.queryInfo());
        queriedCustomerReq.setIsSold(true);
        CustomerRequestDb.getInstance().updateCustomerRequestData(queriedCustomerReq);
        return 0;
    }

    // =======================================Refuse Request=======================================
    public int refuseRequest(CustomerRequest customerRequest)
    {
        if (customerRequest == null) // CustomerRequest is null
        {
            System.out.println("refuseRequest(): CustomerRequest is null");
            return 1;
        }

        CustomerRequest queriedCustomerReq = CustomerRequestDb.getInstance().queryCustomerRequestData(customerRequest.getId());
        if (queriedCustomerReq == null) // Id not found
        {
            System.out.println("refuseRequest(): CustomerRequest not found: " + customerRequest.getId());
            return 2;
        }

        if (queriedCustomerReq.getHandledStaff() != null) // Already handled
        {
            System.out.println("refuseRequest(): CustomerRequest already handled: " + customerRequest.getId());
            return 3;
        }

        queriedCustomerReq.setHandledStaff(this.queryInfo());
        queriedCustomerReq.setIsSold(false);
        CustomerRequestDb.getInstance().updateCustomerRequestData(queriedCustomerReq);
        return 0;
    }

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
        staff.setShop(null);
        this.updateInfo(staff);
        this.staffUI.getPreMainStaffUI().setVisible(true);
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

        System.out.println("logout(): Log out successfully");
        staff.setIsLogin(false);
        staff.setShop(null);
        this.updateInfo(staff);
        return true;
    }

    private void cleanUI()
    {
        this.staffUI.getPreMainStaffUI().dispose();
        this.staffUI.getStaffMainUI().dispose();
        this.staffUI.getInforUI().dispose();
        this.staffUI.getStaffCheckinUI().dispose();
        this.staffUI.getDepositUI().dispose();
        this.staffUI.getRequestUI().dispose();
        this.staffUI.geRequestInfoUI().dispose();

        this.staffUI = null;
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
        new StaffCtrl().staffUI.geRequestInfoUI().setVisible(true);
    }
}