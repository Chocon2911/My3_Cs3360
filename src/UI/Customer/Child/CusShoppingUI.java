package UI.Customer.Child;

import DataBase.Child.ItemDb;
import Obj.Data.Item;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class CusShoppingUI extends JFrame {
    private JButton backButton;
    private JPanel itemsPanel = new JPanel();
    private JLabel label;
    private List<JButton> itemButtons = new ArrayList<>(); // LXHuy
    private List<Item> items = new ArrayList<>(); // LXHuy

    public CusShoppingUI()
    {
        this.setTitle("Choose your Product");
        this.setSize(450,550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 40));

        label = new JLabel("Please choose an item to display information!");


        JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jpanel.add(backButton);
        jpanel.add(label);
        jpanel.setBorder(BorderFactory.createEmptyBorder(15, 5, 0, 0));

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        JPanel jpanel2 = new JPanel();
        jpanel2.setLayout(new BorderLayout());
        jpanel2.add(jpanel, BorderLayout.NORTH);
        jpanel2.add(scrollPane, BorderLayout.CENTER);

        this.add(jpanel2);
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

    public void setItemsPanel(List<Item> itemsUI)
    {
        this.items = itemsUI;

        this.itemsPanel.removeAll();
        this.itemButtons.clear();

        if(itemsUI == null || itemsUI.isEmpty())
        {
            System.out.println("No information");
            return;
        }

        this.itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));
        List<Item> finalItems = new ArrayList<>();
        for (Item item : itemsUI)
        {
            System.out.println(item.getName());
            JButton itemButton = new JButton(item.getName());
            GuiUtil.getInstance().setFixedSize(itemButton, 100,40);
            GuiUtil.getInstance().setAlignmentCenter(itemButton);

            // Item
            Item queriedItem = ItemDb.getInstance().queryItemData(item.getId());
            if (queriedItem.getLeftAmount() <= 0) continue;

            finalItems.add(queriedItem);

            // Button
            this.itemButtons.add(itemButton);

            // Panel
            itemsPanel.add(Box.createVerticalStrut(10));
            itemsPanel.add(itemButton);
            itemsPanel.add(Box.createVerticalStrut(5));
        }

        this.items = finalItems;
    }
}
