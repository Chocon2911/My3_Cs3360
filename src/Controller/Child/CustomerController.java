package Controller.Child;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.Base.AbstractObjCtrl;
import DataBase.Child.CustomerDb;
import DataBase.Child.CustomerRequestDb;
import DataBase.Child.RequestedItemDb;
import DataBase.Child.ShopDb;
import Obj.Data.Customer;
import Obj.Data.CustomerRequest;
import Obj.Data.RequestedItem;
import Obj.Data.Shop;
import UI.Customer.Child.CusCartUI;
import UI.Customer.Child.CusCheckShopCodeUI;
import UI.Customer.Child.CusInforUI;
import UI.Customer.Child.CusMainUI;
import UI.Customer.Child.CusPreMainUI;
import UI.Customer.Child.CusShoppingUI;
import UI.Customer.Child.ItemInforUI;

public class CustomerController extends AbstractObjCtrl implements ActionListener
{
    private CusPreMainUI pmui = new CusPreMainUI();
    private CusMainUI cmui = new CusMainUI();
    private CusInforUI ciui = new CusInforUI();
    private CusShoppingUI csui = new CusShoppingUI();
    private CusCartUI ccui = new CusCartUI();
    private ItemInforUI iiui = new ItemInforUI();
    private CusCheckShopCodeUI cscui = new CusCheckShopCodeUI();

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

        cmui.getInformation_button().addActionListener(this); //Information MainUI//
        cmui.getShopping_button().addActionListener(this); //Shopping
        cmui.getCart_button().addActionListener(this);  //Cart
        cmui.getExit_button().addActionListener(this);  //Exit 

        ciui.getBackButton().addActionListener(this); //Back (Information)

        csui.getBackButton().addActionListener(this); //Back (Shopping)

        ccui.getBackButton().addActionListener(this); //Back(Cart)
        ccui.getRequestButton().addActionListener(this); //Request
        ccui.getRemoveButton().addActionListener(this); //Remove

        iiui.getBackshoppingButton().addActionListener(this); //Back (Item)//
        iiui.getAddButton().addActionListener(this); //Add

        cscui.getJoinbutton().addActionListener(this); // Join
        cscui.getCheckcode().addActionListener(this); //Enter Checkcode
        cscui.getBackbutton().addActionListener(this); //Back(Checkcode)

        pmui.setVisible(true);
    }

    //=========================================UI Handle==========================================
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        Customer customer = this.queryInfo();
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
            }
            else if (checkJoinShop == 2) // Not Online
            {
                JOptionPane.showMessageDialog(null, "Unable to connect !");
                cscui.getCheckcode().setText("");
            }
            else if (checkJoinShop == 3) // Join Success
            {
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
        }
        else if(src.equals("Shopping"))
        {
            cmui.setVisible(false);
            csui.setVisible(true);
        }
        else if(src.equals("Cart"))
        {
            cmui.setVisible(false);
            ccui.setVisible(true);
        }
        else if(src.equals("Exit"))
        {
            cmui.setVisible(false);
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
        else if(src.equals("Back to Shopping"))
        {
            iiui.setVisible(false);
            csui.setVisible(true); 
        }
        else if(src.equals("Send Request"))
        {

        }
        else if(src.equals("Remove Item"))
        {

        }
        else if(src.equals("Add"))
        {
            // handleAddButton();
        }
        // LXHuy
        // for (JButton button : this.csui.getItemButtons())
        // {
        //     if (src.equals(button.getName()))
        //     {
        //         // Do Something
        //     }
        // }
    }

    // private void showMessage(String message, String title, int messageType) 
    // {
    //     JOptionPane.showMessageDialog(iiui, message, title, messageType);
    // }

    // private void handleAddButton() 
    // {
    //     String input = iiui.getTextField().getText();
    //     if ( == 0)
    //     {
    //         showMessage("This item is out of stock!", "Notification", JOptionPane.INFORMATION_MESSAGE);
    //     }

    //     else
    //     {
    //         if (!input.matches("\\d+") || input.equals("0"))
    //         {
    //             showMessage("Please enter a valid number!", "Notification", JOptionPane.WARNING_MESSAGE);
    //             iiui.getTextField().setText("");
    //             iiui.getTextField().requestFocus();
    //         } 

    //         else 
    //         {
    //             int enteredAmount = Integer.parseInt(input);

    //             if (enteredAmount > ) 
    //             {
    //                 showMessage("Not enough stock available! Only " +   + " items left.", "Notification", JOptionPane.WARNING_MESSAGE);
    //             }
    //             else 
    //             {
    //                 showMessage("Added " + enteredAmount + (enteredAmount == 1 ? " item" : " items") + " to your cart!", "Notification", JOptionPane.INFORMATION_MESSAGE);
    //             }
    //         }
    //     }
    // }

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

    @Override
    protected <T> String insertInfo(T info) 
    { 
        return CustomerDb.getInstance().insertCustomerData((Customer)info); 
    }

    @Override
    @SuppressWarnings("unchecked")
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



