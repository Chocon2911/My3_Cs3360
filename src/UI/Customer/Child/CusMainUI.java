package UI.Customer.Child;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CusMainUI extends JFrame
{
    private JLabel labelMainUI;
    private JButton informationMainUI;
    private JButton shoppingMainUI;
    private JButton cartMainUI;
    private JButton exitMainUI;
    
    public CusMainUI ()
    {
        this.setTitle("Welcome to our shop!");
        this.setSize(450,550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        labelMainUI = new JLabel("Customer", JLabel.CENTER);
        labelMainUI.setFont(labelMainUI.getFont().deriveFont(30.0f));

        informationMainUI = new JButton("User Information");
        shoppingMainUI = new JButton("Shopping");
        cartMainUI = new JButton("Cart");
        exitMainUI = new JButton("Exit");

        JPanel jp = new JPanel();
        
        jp.setLayout(new GridLayout(5,1,25, 25));
        jp.add(labelMainUI);
        jp.add(informationMainUI);
        jp.add(shoppingMainUI);
        jp.add(cartMainUI);
        jp.add(exitMainUI);

        JPanel jpl = new JPanel(new BorderLayout());
        jpl.add(jp, BorderLayout.CENTER);

        jp.setBorder(BorderFactory.createEmptyBorder(15, 135, 35, 135));

        this.add(jp);
    }

    public JButton getInformation_button() 
    {
        return informationMainUI;
    }

    public JButton getShopping_button() 
    {
        return shoppingMainUI;
    }

    public JButton getCart_button() 
    {
        return cartMainUI;
    }

    public JButton getExit_button() 
    {
        return exitMainUI;
    }

}
