package UI.Customer.Child;

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
    private JLabel label2;

    private JPanel itemsPanel = new JPanel();
    private List<JButton> itemincartButtons = new ArrayList<>(); // LXHuy
    private List<RequestedItem> itemincarts = new ArrayList<>(); // LXHuy

    public CusCartUI()
    {
        this.setTitle("Your Cart");
        this.setSize(450,550);
        this.setLocationRelativeTo(null);

        label = new JLabel("Mention: Click to item if you want to delete it from cart!");
        label.setForeground(Color.RED);

        label1 = new JLabel("Format: [Itemname : Amounts]");

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 40));

        removeButton = new JButton("Remove All Item");
        removeButton.setPreferredSize(new Dimension(130,35));

        requestButton = new JButton("Send Request");
        requestButton.setPreferredSize(new Dimension(130,35));

        JPanel jp = new JPanel(new GridLayout(2,1,0,0));
        jp.add(label);
        jp.add(label1);

        JPanel jpanel = new JPanel(new FlowLayout());
        jpanel.add(backButton);
        jpanel.add(jp);
        jpanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 0, 0));
        

        JPanel jpanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpanel1.add(removeButton);
        jpanel1.add(requestButton);
        jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        JPanel jpanel2 = new JPanel(new BorderLayout());
        jpanel2.add(jpanel, BorderLayout.NORTH);
        jpanel2.add(scrollPane, BorderLayout.CENTER);
        jpanel2.add(jpanel1, BorderLayout.SOUTH);

        this.add(jpanel2);
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

    public List<JButton> getInCarButtons()
    {
        return this.itemincartButtons;
    }

    public List<RequestedItem> getReqItems() 
    {
        return this.itemincarts;
    }


    // ===Set===
    public void setReqItemsPanel(List<RequestedItem> reqitems)
    {
        this.itemincarts = reqitems;

        this.itemsPanel.removeAll();
        this.itemincartButtons.clear();

        
        if(reqitems == null || reqitems.isEmpty())
        {
            System.out.println("No information");
            return;
        }

        this.itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        for (RequestedItem reqitem : reqitems)
        {
            JButton itemButton = new JButton(reqitem.getItem().getName());
            GuiUtil.getInstance().setFixedSize(itemButton, 100,50);
            GuiUtil.getInstance().setAlignmentCenter(itemButton);

            // Button
            this.itemincartButtons.add(itemButton);

            // Panel
            itemsPanel.add(Box.createVerticalStrut(10));
            itemsPanel.add(itemButton);
            itemsPanel.add(Box.createVerticalStrut(5));
        }
    }

}
