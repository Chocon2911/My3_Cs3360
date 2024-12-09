package UI.Customer.Child;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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

    public ItemInforUI()
    {
        this.setTitle("Item information");
        this.setSize(450,550);
        this.setLocationRelativeTo(null);

        Dimension buttonSize = new Dimension(140, 30);
        backshoppingButton = new JButton("Back to Shopping");
        backshoppingButton.setPreferredSize(buttonSize);

        addButton = new JButton("Add to Cart");
        addButton.setPreferredSize(new Dimension(130,35));

        label = new JLabel("Amounts: ");
        textField = new JTextField(5);
        textField.setHorizontalAlignment(JTextField.CENTER);

        JPanel jpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jpanel.add(backshoppingButton);
        jpanel.setBorder(BorderFactory.createEmptyBorder(15, 10, 0, 0));

        JPanel jpanel1 = new JPanel(new FlowLayout());
        jpanel1.add(label);
        jpanel1.add(textField);

        JPanel jpanel2 = new JPanel(new GridLayout(2,1,10,10));
        jpanel2.add(jpanel1);
        jpanel2.add(addButton);
        jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 150, 20, 150));

        JPanel jpanel3 = new JPanel(new BorderLayout());
        jpanel3.add(jpanel, BorderLayout.NORTH);
        jpanel3.add(jpanel2, BorderLayout.SOUTH);

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

}
