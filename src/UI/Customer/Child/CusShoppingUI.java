package UI.Customer.Child;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

import Obj.Data.Customer;
import Obj.Data.Item;
import Util.GuiUtil;

public class CusShoppingUI extends JFrame {
    private JButton backButton;
    private JPanel itemsPanel = new JPanel();
    private List<JButton> itemButtons = new ArrayList<>(); // LXHuy
    private List<Item> items = new ArrayList<>(); // LXHuy

    public CusShoppingUI()
    {
        this.setTitle("Choose your Product");
        this.setSize(450,550);
        this.setLocationRelativeTo(null);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 30));

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        jpanel.add(backButton, BorderLayout.WEST);
        jpanel.add(itemsPanel, BorderLayout.SOUTH);
        jpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 380, 0));

        JScrollPane scrollPane = new JScrollPane(jpanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        this.add(scrollPane);
    }

    public JButton getBackButton()
    {
        return backButton;
    }

    // LXhuy
    public List<Item> getItems() 
    { 
        return this.items; 
    }

    public List<JButton> getItemButtons() 
    { 
        return this.itemButtons; 
    }

    public void setItemsPanel(List<Item> items)
    {
        this.items = items;

        this.itemsPanel.removeAll();
        this.itemButtons.clear();
        if(items == null || items.isEmpty())
        {
            System.out.println("No information");
            return;
        }

        int listSize = items.size();
        this.itemsPanel.setLayout((new GridLayout(listSize, 1,10,10)));
        for (Item item : items)
        {
            System.out.println(item.getName());
            JButton itemButton = new JButton(item.getName());
            GuiUtil.getInstance().setFixedSize(itemButton, 60,40);

            // Button
            this.itemButtons.add(itemButton);

            // Panel
            itemsPanel.add(Box.createVerticalGlue()); 
            itemsPanel.add(itemButton);
            itemsPanel.add(Box.createVerticalStrut(60));
        }
    }
}
