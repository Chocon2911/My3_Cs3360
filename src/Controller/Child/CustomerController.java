package Controller.Child;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.CustomerDb;
import DataBase.Child.CustomerRequestDb;
import DataBase.Child.ItemDb;
import DataBase.Child.RequestedItemDb;
import DataBase.Child.ShopDb;
import Obj.Data.Customer;
import Obj.Data.CustomerRequest;
import Obj.Data.Item;
import Obj.Data.RequestedItem;
import Obj.Data.Shop;
import UI.Customer.Child.CusCartUI;
import UI.Customer.Child.CusCheckShopCodeUI;
import UI.Customer.Child.CusInforUI;
import UI.Customer.Child.CusMainUI;
import UI.Customer.Child.CusPreMainUI;
import UI.Customer.Child.CusShoppingUI;
import UI.Customer.Child.ItemInforUI;
import Util.ObjUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CustomerController extends AbstractObjCtrl implements ActionListener
{
    private CusPreMainUI pmui = new CusPreMainUI();
    private CusMainUI cmui = new CusMainUI();
    private CusInforUI ciui = new CusInforUI();
    private CusShoppingUI csui = new CusShoppingUI();
    private CusCartUI ccui = new CusCartUI();
    private ItemInforUI iiui = new ItemInforUI();
    private CusCheckShopCodeUI cscui = new CusCheckShopCodeUI();
    private Item chosenItem; // LXHuy

    public CustomerController()
    {
        super();
    }

    public CustomerController(String id)
    {
        super(id);
        System.out.println(id);

        //===MainUI===
        pmui.getJoinshopPreMainUIButton().addActionListener(this); //Join Shop
        pmui.getInformationPreMainUIButton().addActionListener(this);//Information PreMainUI//
        pmui.getQuitPreMainUIButton().addActionListener(this); //Quit
        this.setDefaultClose(pmui);
        pmui.setVisible(true);


        cmui.getInformation_button().addActionListener(this); //Information MainUI//
        cmui.getShopping_button().addActionListener(this); //Shopping
        cmui.getCart_button().addActionListener(this);  //Cart
        cmui.getExit_button().addActionListener(this);  //Exit 
        this.setDefaultClose(cmui);

        ciui.getBackButton().addActionListener(this); //Back (Information)
        this.setDefaultClose(ciui);

        csui.getBackButton().addActionListener(this); //Back (Shopping)
        this.setDefaultClose(csui);

        ccui.getBackButton().addActionListener(this); //Back(Cart)
        ccui.getRequestButton().addActionListener(this); //Request
        ccui.getRemoveButton().addActionListener(this); //Remove
        this.setDefaultClose(ccui);

        iiui.getBackshoppingButton().addActionListener(this); //Back (Item)//
        iiui.getAddButton().addActionListener(this); //Add
        this.setDefaultClose(iiui);

        cscui.getJoinbutton().addActionListener(this); // Join
        cscui.getCheckcode().addActionListener(this); //Enter Checkcode
        cscui.getBackbutton().addActionListener(this); //Back(Checkcode)
        this.setDefaultClose(cscui);

        
    }

    //=========================================UI Handle==========================================
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Customer customer = this.queryInfo();
        // List<Item> items = this.queryItemInfo();
        String src = ae.getActionCommand();
        System.out.println("Clicked" + " " + src);
        if(src.equals("Join A Shop"))  // Mở UI nhập code 
        {
            pmui.setVisible(false);
            cscui.setVisible(true);
        }
        else if(src.equals("Join")) // Mở UI shop
        {
            String checkInCode = cscui.getCheckcode().getText();
            int checkJoinShop = this.joinShop(checkInCode);

            if (checkJoinShop == 1) // Wrong Shop
            {
                JOptionPane.showMessageDialog(null, "Wrong checkcode!");
                cscui.getCheckcode().setText("");
                cscui.getCheckcode().requestFocus();
            }
            else if (checkJoinShop == 2) // Not Online
            {
                JOptionPane.showMessageDialog(null, "Unable to connect !");
                cscui.getCheckcode().setText("");
                cscui.getCheckcode().requestFocus();
            }
            else if (checkJoinShop == 3) // Join Success
            {
                cscui.getCheckcode().setText("");
                cscui.getCheckcode().requestFocus();
                cscui.setVisible(false);
                cmui.setVisible(true);
            }
        }
        else if(src.equals("User Information"))
        {
            pmui.setVisible(false);
            cmui.setVisible(false);
            ciui.setInfoPanel(customer);
            ciui.setVisible(true);
        }
        else if(src.equals("Quit"))
        {
            pmui.setVisible(false);
            pmui = null;
            cmui = null;
            ciui = null;
            csui = null;
            ccui = null;
            iiui = null;
            new App1Ctrl();
            customer.setIsLogin(false);
        }
        else if(src.equals("Shopping"))
        {
            Shop shop = ShopDb.getInstance().queryShopData(customer.getShop().getId());
            List<Item> items = shop.getItems();
            List<Item> queriedItems = new ArrayList<>(); // LXHuy
            for (Item item : items)
            {
                Item queriedItem = ItemDb.getInstance().queryItemData(item.getId()); // LXHuy
                queriedItems.add(queriedItem);
            }

            System.out.println(queriedItems.size());
            csui.setItemsPanel(queriedItems); // LXHuy
            this.defaultItemButtons(); // LXHuy
            cmui.setVisible(false);
            csui.setVisible(true);
        }
        else if(src.equals("Cart"))
        {
            List<RequestedItem> tempReqItems = customer.getUnRequestedItems();
            System.out.println("UnRequestedItem amount = " + customer.getUnRequestedItems().size());
            List<RequestedItem> reqItems = new ArrayList<>();
            for (RequestedItem reqItem : tempReqItems)
            {
                String reqItemId = reqItem.getId();
                RequestedItem newReqItem = RequestedItemDb.getInstance().queryRequestedItemData(reqItemId);
                reqItems.add(newReqItem);
                System.out.println(newReqItem.getItem().getName());
            }

            System.out.println("UnRequestedItem Amount new = " + reqItems.size());

            ccui.setReqItemsPanel(reqItems);
            this.defaultReqItemButtons();
            cmui.setVisible(false);
            ccui.setVisible(true);
        }
        else if(src.equals("Exit"))
        {
            cmui.setVisible(false);
            customer.setShop(null);
            this.updateInfo(customer);
            pmui.setVisible(true);
        }
        else if(src.equals("Back"))
        {
            if(customer.getShop() == null) 
            {
                cmui.setVisible(false);
                ciui.setVisible(false);
                csui.setVisible(false);
                ccui.setVisible(false);
                cscui.setVisible(false);
                pmui.setVisible(true);
            }
            else 
            {
                pmui.setVisible(false);
                ciui.setVisible(false);
                csui.setVisible(false);
                ccui.setVisible(false);
                cmui.setVisible(true);
            }
        }
        else if(src.equals("Back to Shop"))
        {
            Shop shop = ShopDb.getInstance().queryShopData(customer.getShop().getId());
            List<Item> items = shop.getItems();
            System.out.println(items.size());
            csui.setItemsPanel(items); // LXHuy
            this.defaultItemButtons(); // LXHuy
            iiui.setVisible(false);
            csui.setVisible(true); 
        }
        else if(src.equals("Send Request"))
        {
            System.out.println("//========================================Send Request========================================");
            List<RequestedItem> reqItems = ccui.getReqItems();
            System.out.println("Send Request Amount = " + reqItems.size());
            int sendRequest = this.sendRequest(reqItems);
            if (sendRequest == 1)
            {
                JOptionPane.showMessageDialog(null, "No Item To Request");
            }

            else if (sendRequest == 2)
            {
                System.out.println("SenRequest Button pressed: Shop is null");
            }

            else if (sendRequest == 0)
            {
                JOptionPane.showMessageDialog(null, "Request Sucessfully");
                ccui.setVisible(false);
                cmui.setVisible(true);   
            }
        }
        else if(src.equals("Remove All Item"))
        {

        }
        else if(src.equals("Add to Cart"))
        {
            handleAddButton();
        }
    }

    // ===Item Button===
    private void defaultItemButtons() // LXHuy
    {
        int index = 0;
        for (JButton itemButton : this.csui.getItemButtons())
        {
            System.out.println("Button clicked");
            int tempIndex = index;
            itemButton.addActionListener((ActionEvent e) ->
            {
                csui.setVisible(false);
                iiui.setVisible(true);
                this.chosenItem = csui.getItems().get(tempIndex);
                iiui.setItemInfoPanel(this.chosenItem);
            });

            index++;
        }
    }
    // =================

    // ==============================================UI===============================================
    // ===ReqItem Button===
    private void defaultReqItemButtons() //LXHuy
    {
        int index = 0;
        for (JButton reqItemButton : this.ccui.getInCarButtons())
        {
            int tempIndex = index; 
            ccui.setVisible(false);
            reqItemButton.addActionListener((ActionEvent e) ->
            {
                // Get Delete Reqitem
                RequestedItem deleteReqItem = ccui.getReqItems().get(tempIndex);

                // Delete Customer from ReqItem
                String reqItemid = deleteReqItem.getId();
                deleteReqItem = RequestedItemDb.getInstance().queryRequestedItemData(reqItemid);
                deleteReqItem.setCustomer(null);
                RequestedItemDb.getInstance().updateRequestedItemData(deleteReqItem);

                // DisVisible reqItemButton
                reqItemButton.setVisible(false);
                System.out.println("Deleet Item: " + tempIndex);
            });

            index++;
        }
    }
    // ====================

    // ===========================Check Amount Item when add to cart==============================
    private void showMessage(String message, String title, int messageType) 
    {
        JOptionPane.showMessageDialog(iiui, message, title, messageType);
    }

    private void handleAddButton() 
    {
        String input = iiui.getTextField().getText();
        if (chosenItem == null)
        {
            System.out.println("handleAddButton() Error: chosenItem is null");
            iiui.getTextField().setText("");
            return;
        }

        String id = chosenItem.getId();
        chosenItem = ItemDb.getInstance().queryItemData(id);

        if (chosenItem.getLeftAmount() == 0)
        {
            showMessage("This item is out of stock!", "Notification", JOptionPane.INFORMATION_MESSAGE);
            iiui.getTextField().setText("");
            iiui.getTextField().requestFocus();
        }

        else
        {
            if (!input.matches("\\d+") || input.equals("0"))
            {
                showMessage("Please enter a valid number!", "Notification", JOptionPane.WARNING_MESSAGE);
                iiui.getTextField().setText("");
                iiui.getTextField().requestFocus();
            } 

            else 
            {
                int enteredAmount = Integer.parseInt(input);

                if (enteredAmount > chosenItem.getLeftAmount()) 
                {
                    showMessage("Not enough stock available! Only " + chosenItem.getLeftAmount()  + " items left.", "Notification", JOptionPane.WARNING_MESSAGE);
                    iiui.getTextField().setText("");
                    iiui.getTextField().requestFocus();
                }
                else 
                {
                    showMessage("Added " + enteredAmount + (enteredAmount == 1 ? " item" : " items") + " to your cart!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    iiui.getTextField().setText("");
                    iiui.getTextField().requestFocus();
                    this.createRequesteditem(enteredAmount, chosenItem);
                }
            }
        }
    }

    //======================================DataBase Handle=======================================
    private int joinShop(String checkInCode)
    {
        Shop shop = ShopDb.getInstance().queryShopByCheckInCode(checkInCode);
        if (shop == null) 
        {
            return 1; // Wrong checkInCode
        }
        else 
        {
            if (!shop.getIsLogin()) 
            {
                return 2; // Shop is not online
            }
            // Update new Shop to CustomerDb
            Customer customer = this.queryInfo();
            customer.setShop(shop);
            CustomerDb.getInstance().updateCustomerData(customer);
            return 3; // Success
        }
    }

    private boolean logout()
    {
        Customer customer = this.queryInfo();
        if (customer == null)
        {
            System.out.println("logout(): Error: Manager not found");
            return false;
        }

        System.out.println("logout(): Log out successfully");
        customer.setIsLogin(false);
        customer.setShop(null);
        this.updateInfo(customer);
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

    private void createRequesteditem(int amount, Item item)
    {
        String id = ObjUtil.getInstance().getRandomStr(10);
        Customer customer = this.queryInfo();

        RequestedItem reqItem = new RequestedItem(id, customer.getShop(), null, customer, item, amount);
        String e = RequestedItemDb.getInstance().insertRequestedItemData(reqItem);
        if (e == "RequestedItem.Id")
        {
            System.out.println("createRequesteditem() Error: Id already exists: " + id);
            this.createRequesteditem(amount, item);
        }

        System.out.println("Create RequestedItem successfully with id = " + id);
    }

    private int sendRequest(List<RequestedItem> reqItems)
    {
        if (reqItems == null || reqItems.isEmpty())
        {
            System.out.println("sendRequest(): reqItems is null or empty");
            return 1; // List is empty
        }
        
        Customer customer = this.queryInfo();
        Shop shop = customer.getShop();
        if (shop == null)
        {
            System.out.println("sendRequest(): Doesn't join Shop yet!");
            return 2; // Shop is null
        }

        for (RequestedItem reqItem : reqItems)
        {
            reqItem.setShop(shop);
        }

        String newId = ObjUtil.getInstance().getRandomStr(10);
        String name = "NULL";
        CustomerRequest customerRequest = new CustomerRequest(newId, name, shop, customer, null, reqItems, false);
        String e = CustomerRequestDb.getInstance().insertCustomerRequestData(customerRequest);
        if (e == null) {}
        else if (e.contains("CustomerRequests.Id"))
        {
            System.out.println("Id exist already: " + newId);
            return this.sendRequest(reqItems);
        }

        for (RequestedItem reqItem : reqItems)
        {
            reqItem.setCustomerRequest(customerRequest);
            RequestedItemDb.getInstance().updateRequestedItemData(reqItem);
        }

        return 0;
    }


    //==========================================Override==========================================
    @Override
    protected <T> String insertInfo(T info) 
    { 
        return CustomerDb.getInstance().insertCustomerData((Customer)info); 
    }

    @Override
    @SuppressWarnings("unchecked")
    // Get Customer information from Db
    public final Customer queryInfo()
    {
        Customer customer = CustomerDb.getInstance().queryCustomerData(id);
        System.out.println("queryInfo(): " + id);
        if (customer == null) 
        {
            System.out.println("queryInfo() Error: No Customer with Id: " + this.id);
            return null;
        }
        else if (customer.getCustomerRequests() == null)
        {
            System.out.println("queryInfo(): No CustomerRequests");
            return customer;
        }

        // Get CustomerRequests of Customer From Db
        List<CustomerRequest> crs = new ArrayList<>();
        for (CustomerRequest cr : customer.getCustomerRequests())
        {
            CustomerRequest newCr = CustomerRequestDb.getInstance().queryCustomerRequestData(cr.getId());
            if (newCr.getRequestedItems() == null || newCr.getRequestedItems().isEmpty()) continue;

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
        
        customer.setCustomerRequests(crs);
        return customer;
    }

    @Override
    protected <T> String updateInfo(T info)
    {
        return CustomerDb.getInstance().updateCustomerData((Customer)info);
    }  
}