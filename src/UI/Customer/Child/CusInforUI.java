package UI.Customer.Child;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Obj.Data.Customer;

public class CusInforUI extends JFrame{
    private JPanel infoPanel = new JPanel();
    private JButton backButton;
    private JLabel label;

    public CusInforUI()
    {
        this.setTitle("User information");
        this.setSize(450,550);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 30));

        label = new JLabel("Information");
        label.setFont(label.getFont().deriveFont(30.0f));

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS)); 
        infoPanel.setBorder(BorderFactory.createEmptyBorder(130, 140, 120, 0));

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        jpanel.add(infoPanel,BorderLayout.SOUTH);
        jpanel.add(backButton, BorderLayout.WEST); 
        jpanel.add(label, BorderLayout.CENTER);
        jpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 100,0));

        label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS)); 
        label.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 0));        
        this.add(jpanel);
    }


    public JButton getBackButton()
    {
        return backButton;
    }

    public void setInfoPanel(Customer customer)
    {
        this.infoPanel.removeAll();
        if(customer == null)
        {
            System.out.println("No information");
            return;
        }

        infoPanel.add(Box.createVerticalGlue()); 
        infoPanel.add(new JLabel("Name: " + customer.getName()));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(new JLabel("Username: " + customer.getUserName()));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(new JLabel("Password: " + customer.getPassword()));
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(new JLabel("Balance: " + customer.getBalance()));
        infoPanel.add(Box.createVerticalGlue()); 
        infoPanel.revalidate(); 
        infoPanel.repaint();
    }
}
