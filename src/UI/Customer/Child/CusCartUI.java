package UI.Customer.Child;

import DataBase.Child.RequestedItemDb;
import Obj.Data.CustomerRequest;
import Obj.Data.RequestedItem;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class CusCartUI extends JFrame {
    private JButton backButton;
    private JButton requestButton;
    private JButton removeButton;
    private JLabel label;
    private JLabel label1;
    private JCheckBox selectAllBox;

    private JPanel itemsPanel = new JPanel();
    private List<JCheckBox> itemincartCheckboxs = new ArrayList<>(); // LXHuy
    private List<RequestedItem> itemincarts = new ArrayList<>(); // LXHuy
    private JLabel totalMoneyLabel = new JLabel(); // LXHuy

    public CusCartUI()
    {
        this.setTitle("Your Cart");
        this.setSize(450,550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        label = new JLabel("Mention: Tick to box of item you want to delete from cart!");
        label.setForeground(Color.RED);

        label1 = new JLabel("Format: [Itemname : Amounts]");

        selectAllBox = new JCheckBox("Select All");

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 40));

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(130,35));

        requestButton = new JButton("Send Request");
        requestButton.setPreferredSize(new Dimension(130,35));

        JPanel jp = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jp.add(label1);
        jp.add(selectAllBox);

        JPanel jp1 = new JPanel(new GridLayout(2,1,0,-10));
        jp1.add(label);
        jp1.add(jp);

        JPanel jpanel = new JPanel(new FlowLayout());
        jpanel.add(backButton);
        jpanel.add(jp1);
        jpanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 0, 0));
        
        JPanel jpanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpanel1.add(removeButton);
        jpanel1.add(requestButton);
        jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JPanel jpanel2 = new JPanel(new GridLayout(2, 1, 0,-15));
        jpanel2.add(totalMoneyLabel);
        jpanel2.add(jpanel1);

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        JPanel jpanel3 = new JPanel(new BorderLayout());
        jpanel3.add(jpanel, BorderLayout.NORTH);
        jpanel3.add(scrollPane, BorderLayout.CENTER);
        jpanel3.add(jpanel2, BorderLayout.SOUTH);

        this.add(jpanel3);
    }

    // ===Get===
    public JButton getBackButton()
    {
        return backButton;
    }

    public JButton getRequestButton()
    {
        return requestButton;
    }

    public JButton getRemoveButton()
    {
        return removeButton;
    }

    public List<JCheckBox> getInCartCheckbox()
    {
        return this.itemincartCheckboxs;
    }

    public List<RequestedItem> getReqItems() 
    {
        return this.itemincarts;
    }

    public JCheckBox getSelectAllBox()
    {
        return this.selectAllBox;
    }


    // ===Set===
    public void setReqItemsPanel(List<RequestedItem> reqitems)
    {
        this.itemincarts = reqitems;

        this.itemsPanel.removeAll();
        this.itemincartCheckboxs.clear();

        
        if(reqitems == null || reqitems.isEmpty())
        {
            System.out.println("No information");
            return;
        }

        this.itemsPanel.setLayout(new BoxLayout(this.itemsPanel, BoxLayout.Y_AXIS));

        List<RequestedItem> queriedReqItems = new ArrayList<>();
        for (RequestedItem reqitem : reqitems)
        {
            int amountInCart = reqitem.getAmount();
            JCheckBox itemCheckbox = new JCheckBox(reqitem.getItem().getName()+ " : " + amountInCart);
            GuiUtil.getInstance().setFixedSize(itemCheckbox, 100,20);
            GuiUtil.getInstance().setAlignmentCenterLeft(itemCheckbox);

            // Button
            this.itemincartCheckboxs.add(itemCheckbox);

            // Panel
            itemsPanel.add(Box.createVerticalStrut(5));
            itemsPanel.add(itemCheckbox);
            itemsPanel.add(Box.createVerticalStrut(5));

            // Query
            RequestedItem queriedReqItem = RequestedItemDb.getInstance().queryRequestedItemData(reqitem.getId());
            queriedReqItems.add(queriedReqItem);
        }

        CustomerRequest tempCustomerReq = new CustomerRequest();
        tempCustomerReq.setRequestedItems(queriedReqItems);
        this.totalMoneyLabel.setText("                                                          Total Price: $" + tempCustomerReq.getTotalMoney());
    }
}
