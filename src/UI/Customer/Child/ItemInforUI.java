package UI.Customer.Child;

import DataBase.Child.ItemDb;
import Obj.Data.Item;
import Util.GuiUtil;
import Util.ObjUtil;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ItemInforUI extends JFrame {
    private JButton backshoppingButton;
    private JButton addButton;
    private JLabel label;
    private JTextField textField;
    private JPanel iteminfoPanel = new JPanel();

    public ItemInforUI()
    {
        this.setTitle("Item information");
        this.setSize(450,550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        backshoppingButton = new JButton("Back to Shop");
        GuiUtil.getInstance().setFixedSize(backshoppingButton, 110, 30);

        addButton = new JButton("Add to Cart");

        label = new JLabel("Amounts: ");
        textField = new JTextField(9);
        textField.setHorizontalAlignment(JTextField.CENTER);

        iteminfoPanel.setLayout(new BoxLayout(iteminfoPanel, BoxLayout.Y_AXIS)); 
        iteminfoPanel.setBorder(BorderFactory.createEmptyBorder(100, 170, 160, 0));

        JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jpanel.add(backshoppingButton);
        jpanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        JPanel jpanel1 = new JPanel(new FlowLayout());
        jpanel1.add(label);
        jpanel1.add(textField);

        JPanel jpanel2 = new JPanel(new GridLayout(2,1,0,10));
        jpanel2.add(jpanel1);
        jpanel2.add(addButton);
        jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 120, 10, 120));

        JPanel jpanel3 = new JPanel(new BorderLayout());
        jpanel3.add(jpanel, BorderLayout.NORTH);
        jpanel3.add(jpanel2, BorderLayout.SOUTH);
        jpanel3.add(iteminfoPanel, BorderLayout.CENTER);
        jpanel3.setBorder(BorderFactory.createEmptyBorder(20, 20, 50,0));
        this.add(jpanel3);
    }

    public JButton getBackshoppingButton()
    {
        return backshoppingButton;
    }

    public JButton getAddButton()
    {
        return addButton;
    }

    public JTextField getTextField()
    {
        return textField;
    }

    public void setItemInfoPanel(Item item)
    {
        this.iteminfoPanel.removeAll();
        if(item == null)
        {
            System.out.println("No information");
            return;
        }

        Item queriedItem = ItemDb.getInstance().queryItemData(item.getId());

        // LXHuy
        String itemId = item.getId();
        item = ItemDb.getInstance().queryItemData(itemId);

        String itemTypeStr = ObjUtil.getInstance().getStrFromItemType(queriedItem.getItemType());
        iteminfoPanel.add(Box.createVerticalGlue()); 
        iteminfoPanel.add(new JLabel("Name: " + queriedItem.getName()));
        iteminfoPanel.add(Box.createVerticalStrut(10));
        iteminfoPanel.add(new JLabel("Type: " + itemTypeStr));
        iteminfoPanel.add(Box.createVerticalStrut(10));
        iteminfoPanel.add(new JLabel("Price: $" + queriedItem.getPrice()));
        iteminfoPanel.add(Box.createVerticalStrut(10));
        iteminfoPanel.add(new JLabel("Amount: " + queriedItem.getLeftAmount()));
        iteminfoPanel.add(Box.createVerticalGlue());
        iteminfoPanel.revalidate(); 
        iteminfoPanel.repaint();
    }
}
