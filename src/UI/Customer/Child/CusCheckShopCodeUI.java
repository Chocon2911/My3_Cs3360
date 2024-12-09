package UI.Customer.Child;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CusCheckShopCodeUI extends JFrame {
    private JLabel label;
    private JTextField checkcode;
    private JButton joinbutton;
    private JButton backbutton;


    public CusCheckShopCodeUI()
    {
        this.setTitle("Checkcode UI");
        this.setSize(300,400);
        this.setLocationRelativeTo(null);

        label = new JLabel("    Enter checkcode to join a shop!");
        label.setFont(label.getFont().deriveFont(17.0f));

        checkcode = new JTextField(20);
        checkcode.setPreferredSize(new Dimension(15, 30));

        joinbutton = new JButton("Join");
        joinbutton.setPreferredSize(new Dimension(100,35));

        backbutton = new JButton("Back");
        backbutton.setPreferredSize(new Dimension(100,35));

        JPanel jpanel = new JPanel(new FlowLayout());
        jpanel.add(backbutton);
        jpanel.add(joinbutton);

        JPanel jpanel1 = new JPanel(new FlowLayout());
        jpanel1.add(checkcode);

        JPanel jpanel2 = new JPanel(new GridLayout(3,1,10,10));
        jpanel2.add(label);
        jpanel2.add(jpanel1);
        jpanel2.add(jpanel);

        JPanel jpanel3 = new JPanel(new BorderLayout());
        jpanel3.add(jpanel2, BorderLayout.CENTER);

        this.add(jpanel3);
    }

    public JTextField getCheckcode()
    {
        return checkcode;
    }

    public JButton getJoinbutton()
    {
        return joinbutton;
    }
    
    public JButton getBackbutton()
    {
        return backbutton;
    }

}
