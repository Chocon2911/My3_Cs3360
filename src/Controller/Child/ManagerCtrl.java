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

    
<<<<<<< HEAD
    //=======================================DeleteStaff UI=======================================
    private void defaultDeleteStaffUI()
    {
        ManagerDeleteStaffUI deleteStaffUI = this.managerUI.getDeleteStaffUI();
        this.setDefaultClose(deleteStaffUI);

        // Delete Button
        deleteStaffUI.getDeleteButton().addActionListener((ActionEvent e) ->
        {
            System.out.println("//=========================================Delete Staff==========================================");

            // Logic Handler
            String userName = deleteStaffUI.getUserName();

            int deleteStaff = this.deleteStaff(userName);
            if (deleteStaff == 1) // UserName is not exist
            {
                JOptionPane.showMessageDialog(null, "User Name is not exist");
            }
            else if (deleteStaff == 0) // Delete Successfully
            {
                JOptionPane.showMessageDialog(null, "Delete Staff Successfully");
                deleteStaffUI.setVisible(false);
                deleteStaffUI.wipeOutField();
                this.managerUI.getMainUI().setVisible(true);
            }
        });

        // Cancel Button
        deleteStaffUI.getCancelButton().addActionListener((ActionEvent e) ->
        {
            deleteStaffUI.setVisible(false);
            deleteStaffUI.wipeOutField();
            this.managerUI.getMainUI().setVisible(true);
        });
    }

    //=========================================AddItem UI=========================================
    private void defaultAddItemUI()
    {
        ManagerAddItemUI addItemUI = this.managerUI.getAddItemUI();
        this.setDefaultClose(addItemUI);

        // Add Button
        addItemUI.getAddButton().addActionListener((ActionEvent e) ->
        {
            System.out.println("//=========================================Add Item==========================================");

            // Logic Handler
            String name = addItemUI.getNameStr();
            String priceStr = addItemUI.getPriceStr();
            String itemTypeStr = addItemUI.getItemTypeStr();
            String amountStr= addItemUI.getAmountStr();

            ItemType itemType = ObjUtil.getInstance().getItemTypeFromStr(itemTypeStr);
            try
            {
                float price = Float.parseFloat(priceStr);
                int amount = Integer.parseInt(amountStr);

                int addItem = this.addItem(name, price, amount, itemType);
                if (addItem == 1) // Price is too low
                {
                    JOptionPane.showMessageDialog(null, "Price is too low");
                }
                else if (addItem == 2) // Amount is too low
                {
                    JOptionPane.showMessageDialog(null, "Amount is too low");
                }
                else if (addItem == 3) // Doesn't join shop
                {
                    JOptionPane.showMessageDialog(null, "Doesn't join Shop yet!");
                }
                else if (addItem == 0) // Add Successfully
                {
                    JOptionPane.showMessageDialog(null, "Item added successfully");
                    addItemUI.setVisible(false);
                    addItemUI.wipeOutField();
                    this.managerUI.getMainUI().setVisible(true);
                }
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null, "Amount and Price must be numbers");
            }
        });

        // Cancel Button
        addItemUI.getCancelButton().addActionListener((ActionEvent e) ->
        {
            addItemUI.setVisible(false);
            addItemUI.wipeOutField();
            this.managerUI.getMainUI().setVisible(true);
        });
    }


=======
>>>>>>> 4d53e4bf972b8319945d7af0c3c12be0d2350bb3

    //============================================================================================
    //=========================================Controller=========================================
    //============================================================================================
    
<<<<<<< HEAD
    //========================================Create Staff========================================
    private int createStaff(String name, String userName, String password)
    {
        String staffId = ObjUtil.getInstance().getRandomStr(10);
        Staff staff = new Staff(staffId, name, userName, password, false);
        String e = StaffDb.getInstance().insertStaffData(staff);
        if (e == null) return 0; // Create Successfully
        else if (e.contains("Staffs.Id")) // Id Already exists
        {
            System.out.println("Error: Id already exists");
            return createStaff(name, userName, password);
        }
        else if (e.contains("Staffs.UserName")) return 1; // UserName is already exist

        return 0; // Create Successfully
    }

    private String getStaffId(String userName, String password)
    {
        Staff staff = StaffDb.getInstance().queryStaffByUserName(userName);
        if (staff == null) return null;
        else if (!staff.getPassword().equals(password)) return null;

        return staff.getId();
    }

    //========================================Delete Staff========================================
    private int deleteStaff(String userName)
    {
        Staff staff = StaffDb.getInstance().queryStaffByUserName(userName);
        if (staff == null) // No Staff with UserName
        {
            System.out.println("deleteStaff(): No Staff with UserName: " + userName);
            return 1;
        }
        
        boolean delete = StaffDb.getInstance().deleteStaffData(staff.getId(), staff.getUserName());
        if (!delete)
        {
            System.out.println("deleteStaff(): Can't Delete Staff with Id: " + staff.getId());
            return 2;
        }
        return 0;
    }

    //==========================================Add Item==========================================
    private int addItem(String name, float price, int initAmount, ItemType itemType)
    {
        if (price <= 0) // Price is too low
        {
            System.out.println("addItem(): Price is set too low: " + price);
            return 1;
        }
        else if (initAmount <= 0) // InitAmount is too low
        {
            System.out.println("addItem(): Init Amount is set too low: " + initAmount);
            return 2;
        }

        String itemId = ObjUtil.getInstance().getRandomStr(10);
        Shop shop = this.queryInfo().getShop();
        if (shop == null)
        {
            System.out.println("addItem() Error: Doesn't join shop yet!");
            return 3;
        }

        Item item = new Item(itemId, name, shop, price, itemType, initAmount, null);
        String e = ItemDb.getInstance().insertItemData(item);
        if (e == null) return 0; // Add Successfully
        else if (e.contains("Id")) // Id already exists
        {
            System.out.println("addItem(): Id already exists: " + itemId);
            return addItem(name, price, initAmount, itemType);
        }        

        return 0; // Add Successfully
    }

=======
>>>>>>> 4d53e4bf972b8319945d7af0c3c12be0d2350bb3
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
