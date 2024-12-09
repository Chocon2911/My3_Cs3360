package Controller.Child;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DataBase.Child.CustomerDb;
import DataBase.Child.CustomerRequestDb;
import DataBase.Child.RequestedItemDb;
import Obj.Data.Customer;
import Obj.Data.CustomerRequest;
import Obj.Data.RequestedItem;
import UI.Customer.Child.*;

public class Customer_controller_design implements ActionListener
    {
        private CusPreMainUI pmui;
        private CusMainUI cmui;
        private CusInforUI ciui;
        private CusShoppingUI csui;
        private CusCartUI ccui;
        private ItemInforUI iiui;

        public Customer_controller_design(){}

        public Customer_controller_design (CusPreMainUI pmui, CusMainUI cmui, CusInforUI ciui, CusShoppingUI csui, CusCartUI ccui, ItemInforUI iiui)
        {
            this.pmui = pmui;
            this.cmui = cmui;
            this.ciui = ciui;
            this.csui = csui;
            this.ccui = ccui;
            this.iiui = iiui;

            pmui.getJoinshopPreMainUIButton().addActionListener(this);
            pmui.getInformationPreMainUIButton().addActionListener(this);
            pmui.getQuitPreMainUIButton().addActionListener(this);

            cmui.getInformation_button().addActionListener(this);
            cmui.getShopping_button().addActionListener(this);
            cmui.getCart_button().addActionListener(this);
            cmui.getExit_button().addActionListener(this);

            ciui.getBackButton().addActionListener(this);

            csui.getBackButton().addActionListener(this);

            ccui.getBackButton().addActionListener(this);
            ccui.getRequestButton().addActionListener(this);
            ccui.getRemoveButton().addActionListener(this);

            iiui.getBackshoppingButton().addActionListener(this);
            iiui.getAddButton().addActionListener(this);
        }


        @Override
        public void actionPerformed(ActionEvent ae)
        {
            Customer customer = new CustomerController().queryInfo();

            String src = ae.getActionCommand();
            System.out.println("Clicked" + " " + src);
            if(src.equals("Join Shop"))
            {
                pmui.setVisible(false);
                cmui.setVisible(true);
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
                System.exit(0);
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

        public JFrame getPreMainUI() 
        { 
            return this.pmui; 
        }
    }
