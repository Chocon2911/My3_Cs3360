package UI.Customer.Child;

import Obj.Data.RequestedItem;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CusCartUI extends JFrame {
    private JButton backButton;
    private JButton requestButton;
    private JButton removeButton;

    private JPanel itemsPanel = new JPanel();
    private List<JButton> itemincartButtons = new ArrayList<>(); // LXHuy
    private List<RequestedItem> itemincarts = new ArrayList<>(); // LXHuy

    public CusCartUI()
    {
        this.setTitle("Your Cart");
        this.setSize(450,550);
        this.setLocationRelativeTo(null);

        Dimension buttonSize = new Dimension(80, 30);
        backButton = new JButton("Back");
        backButton.setPreferredSize(buttonSize);

        removeButton = new JButton("Remove Item");
        removeButton.setPreferredSize(new Dimension(130,35));

        requestButton = new JButton("Send Request");
        requestButton.setPreferredSize(new Dimension(130,35));

        JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jpanel.add(backButton);
        jpanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 0, 0));

        JPanel jpanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jpanel1.add(removeButton);
        jpanel1.add(requestButton);
        jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        JPanel jpanel2 = new JPanel(new BorderLayout());
        jpanel2.add(jpanel, BorderLayout.NORTH);
        jpanel2.add(itemsPanel, BorderLayout.CENTER);
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

        int listSize = reqitems.size();
        this.itemsPanel.setLayout((new GridLayout(listSize, 1,10,10)));
        for (RequestedItem reqitem : reqitems)
        {
            // System.out.println(reqitem.getItem().getName());
            JButton itemButton = new JButton(reqitem.getItem().getName());
            GuiUtil.getInstance().setFixedSize(itemButton, 60,40);

            // Button
            this.itemincartButtons.add(itemButton);

            // Panel
            itemsPanel.add(Box.createVerticalGlue()); 
            itemsPanel.add(itemButton);
            itemsPanel.add(Box.createVerticalStrut(60));
        }
    }

}
