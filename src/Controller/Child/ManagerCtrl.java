package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.ItemDb;
import DataBase.Child.ManagerDb;
import DataBase.Child.ShopDb;
import DataBase.Child.StaffDb;
import Obj.Data.*;
import UI.Manager.Child.*;
import UI.Manager.ManagerUI;
import Util.ObjUtil;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ManagerCtrl extends AbstractObjCtrl
{
    private ManagerUI managerUI;

    //========================================Constructor=========================================
    public ManagerCtrl()
    {
        super();
        this.managerUI = new ManagerUI();

        this.defaultPreMainUI();
        this.defaultMainUI();
        this.defaultJoinShopUI();
        this.defaultInfoUI();
        this.defaultCreateStaffUI();
        this.defaultDeleteStaffUI();
        this.defaultAddItemUI();
    }

    public ManagerCtrl(String id)
    {
        super(id);
        this.managerUI = new ManagerUI();
        
        this.login();
        this.defaultPreMainUI();
        this.defaultMainUI();
        this.defaultJoinShopUI();
        this.defaultInfoUI();
        this.defaultCreateStaffUI();
        this.defaultDeleteStaffUI();
        this.defaultAddItemUI();
    }

    //==========================================Override==========================================
    @Override
    protected <T> String insertInfo(T info)
    {
        return ManagerDb.getInstance().insertManagerData((Manager)info);
    }
    @Override
    @SuppressWarnings("unchecked")
    public final Manager queryInfo() 
    { 
        Manager manager = ManagerDb.getInstance().queryManagerData(id);
        if (manager == null)
        {
            System.out.println("queryInfo(): Manager is null with Id: " + id);
            return null;
        } 

        return manager;
    }
    @Override
    protected <T> String updateInfo(T info)
    {
        return ManagerDb.getInstance().updateManagerData((Manager)info);
    }

    //============================================================================================
    //=============================================UI=============================================
    //============================================================================================

    //=========================================PreMain UI=========================================
    private void defaultPreMainUI()
    {
        ManagerPreMainUI preMainUI = this.managerUI.getPreMainUI();
        this.setDefaultClose(preMainUI);

        // Info Button
        preMainUI.getInfoButton().addActionListener((ActionEvent e) ->
        {
            // Info Panel
            Manager manager = this.queryInfo();
            if (manager == null)
            {
                System.out.println("Manager is not found with Id: " + this.id);
            }
            else
            {
                this.managerUI.getInfoUI().setInfoPanel(manager);
            }

            this.managerUI.getInfoUI().setInfoPanel(manager);
            preMainUI.setVisible(false);
            this.managerUI.getInfoUI().setVisible(true);
        });

        // Join Shop Button
        preMainUI.getJoinShopButton().addActionListener((ActionEvent e) ->
        {
            preMainUI.setVisible(false);
            this.managerUI.getJoinShopUI().setVisible(true);
        });

        // Quit Button
        preMainUI.getQuitButton().addActionListener((ActionEvent e) ->
        {
            if (!logout())
            {
                System.out.println("Log out failed");
            }

            System.exit(0);
        });
    }


    //==========================================Main UI===========================================
    private void defaultMainUI()
    {
        ManagerMainUI mainUI = this.managerUI.getMainUI();
        this.setDefaultClose(mainUI);

        // Info Button
        mainUI.getInfoButton().addActionListener((ActionEvent e) ->
        {
            // Info Panel
            Manager manager = this.queryInfo();
            if (manager == null)
            {
                System.out.println("Manager is not found with Id: " + this.id);
            }
            else
            {
                this.managerUI.getInfoUI().setInfoPanel(manager);
            }

            this.managerUI.getInfoUI().setInfoPanel(manager);
            this.managerUI.getMainUI().setVisible(false);
            this.managerUI.getInfoUI().setVisible(true);
        });

        // CreateStaff Button
        mainUI.getCreateStaffButton().addActionListener((ActionEvent e) ->
        {
            this.managerUI.getMainUI().setVisible(false);
            this.managerUI.getCreateStaffUI().setVisible(true);
        });

        // DeleteStaff Button
        mainUI.getDeleteStaffButton().addActionListener((ActionEvent e) ->
        {
            this.managerUI.getMainUI().setVisible(false);
            this.managerUI.getDeleteStaffUI().setVisible(true);
        });

        // AddItem Button
        mainUI.getAddItemButton().addActionListener((ActionEvent e) ->
        {
            this.managerUI.getMainUI().setVisible(false);
            this.managerUI.getAddItemUI().setVisible(true);
        });

        // Quit Button
        mainUI.getQuitButton().addActionListener((ActionEvent e) ->
        {
            if (!logout())
            {
                System.out.println("Log out failed");
            }

            new App1Ctrl();
        });
    }

    //==========================================Info UI===========================================
    private void defaultInfoUI()
    {
        ManagerInfoUI infoUI = this.managerUI.getInfoUI();
        this.setDefaultClose(infoUI);

        // Back Button
        infoUI.getBackButton().addActionListener((ActionEvent e) ->
        {
            infoUI.setVisible(false);
            Manager manager = this.queryInfo();
            if (manager == null) 
            {
                System.out.println("Manager is not found with Id: " + this.id);
                this.managerUI.getMainUI().setVisible(true);
            }

            else if (manager.getShop() == null)
            {
                System.out.println("Manager doesn't join shop");
                this.managerUI.getPreMainUI().setVisible(true);
            }

            else if (manager.getShop() != null)
            {
                System.out.println("Manager joins shop: " + manager.getShop().getCheckInCode());
                this.managerUI.getMainUI().setVisible(true);
            }
        });
    }

    //========================================JoinShop UI=========================================
    private void defaultJoinShopUI()
    {
        ManagerJoinShopUI joinShopUI = this.managerUI.getJoinShopUI();
        this.setDefaultClose(joinShopUI);

        // Join Button
        joinShopUI.getJoinButton().addActionListener((ActionEvent e) ->
        {
            System.out.println("//=========================================Join Shop==========================================");

            // Logic Handler
            String checkInCode = joinShopUI.getCheckInCode();

            int joinShop = this.joinShop(checkInCode);
            if (joinShop == 1) // Wrong CheckInCode
            {
                System.out.println("joinShop(): Wrong CheckInCode: " + checkInCode);
                JOptionPane.showMessageDialog(null, "Wrong CheckInCode!");
            }
            else if (joinShop == 2) // Shop is not online
            {
                System.out.println("joinShop(): Shop is not online: " + checkInCode);
                JOptionPane.showMessageDialog(null, "Wrong CheckInCode");
            } 
            else if (joinShop == 0) // Success
            {
                JOptionPane.showMessageDialog(null, "Join Shop successfully");
                joinShopUI.setVisible(false);
                joinShopUI.wipeOutField();
                this.managerUI.getMainUI().setVisible(true);
            }
        });
    }

    //=======================================CreateStaff UI=======================================
    private void defaultCreateStaffUI()
    {
        ManagerCreateStaffUI createStaffUI = this.managerUI.getCreateStaffUI();
        this.setDefaultClose(createStaffUI);

        // Create Button
        createStaffUI.getCreateButton().addActionListener((ActionEvent e) ->
        {
            System.out.println("//=========================================Create Staff==========================================");

            // Logic Handler
            String name = createStaffUI.getNameStr();
            String userName = createStaffUI.getUserName();
            String password = createStaffUI.getPassword();

            int createStaff = this.createStaff(name, userName, password);
            if (createStaff == 1) // UserName is already exist
            {
                JOptionPane.showMessageDialog(null, "User Name is already exist");
            }
            else if (createStaff == 0) // Create Successfully
            {
                JOptionPane.showMessageDialog(null, "Create Staff Successfully");
                createStaffUI.setVisible(false);
                createStaffUI.wipeOutField();
                this.managerUI.getMainUI().setVisible(true);
            }
        });

        // Cancel Button
        createStaffUI.getCancelButton().addActionListener((ActionEvent e) ->
        {
            createStaffUI.setVisible(false);
            createStaffUI.wipeOutField();
            this.managerUI.getMainUI().setVisible(true);
        });
    }
    
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
                else if (addItem == 0)
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



    //============================================================================================
    //=========================================Controller=========================================
    //============================================================================================

    //=========================================Join Shop==========================================
    private int joinShop(String checkInCode)
    {
        Shop shop = ShopDb.getInstance().queryShopByCheckInCode(checkInCode);
        if (shop == null) // No Shop with CheckInCode 
        {
            System.out.println("joinShop(): No Shop with CheckInCode: " + checkInCode);
            return 1;
        }
        else if (!shop.getIsLogin()) // Shop is not online yet
        {
            System.out.println("joinShop(): Shop is not online yet: " + checkInCode);
            return 2;
        }

        Manager manager = this.queryInfo();
        manager.setShop(shop);
        this.updateInfo(manager);
        return 0;
    }

    private String getShopIdByCheckInCode(String checkInCode)
    {
        Shop shop = ShopDb.getInstance().queryShopByCheckInCode(checkInCode);
        if (shop == null)
        {
            System.out.println("getShopIdByCheckInCode(): No Shop with CheckInCode: " + checkInCode);
            return null;
        }
        return shop.getId();
    }
    
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
        Item item = new Item(itemId, name, price, itemType, initAmount);
        String e = ItemDb.getInstance().insertItemData(item);
        if (e == null) return 0; // Add Successfully
        else if (e.contains("Items.Id")) // Id already exists
        {
            System.out.println("addItem(): Id already exists: " + itemId);
            return addItem(name, price, initAmount, itemType);
        }        

        return 0; // Add Successfully
    }

    //===========================================Other============================================
    private boolean login()
    {
        Manager manager = this.queryInfo();
        if (manager == null)
        {
            System.out.println("login(): Error: Manager not found");
            return false;
        }

        manager.setIsLogin(true);
        manager.setShop(null);
        this.updateInfo(manager);
        this.managerUI.getPreMainUI().setVisible(true);
        return true;
    }

    private boolean logout()
    {
        Manager manager = this.queryInfo();
        if (manager == null)
        {
            System.out.println("logout(): Error: Manager not found");
            return false;
        }

        System.out.println("logout(): Log out successfully");
        manager.setIsLogin(false);
        manager.setShop(null);
        this.updateInfo(manager);
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

    //============================================Test============================================
    public static void main(String[] args) 
    {
        new ManagerCtrl().managerUI.getMainUI().setVisible(true);
    }
}
