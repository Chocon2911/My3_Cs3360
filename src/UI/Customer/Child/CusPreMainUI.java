package UI.Customer.Child;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class CusPreMainUI extends JFrame {
    private JButton joinshopPreMainUI;
    private JButton informationPreMainUI;
    private JButton quitPreMainUI;
    private JLabel label;

    public CusPreMainUI ()
    {
        this.setTitle("Customer PreMain UI");
        this.setSize(450,550);
        this.setLocationRelativeTo(null);

        joinshopPreMainUI = new JButton("Join A Shop");
        informationPreMainUI = new JButton("User Information");
        quitPreMainUI = new JButton("Quit");
        label = new JLabel("     PreMain UI");
        label.setFont(label.getFont().deriveFont(30.0f));

        JPanel jpanel = new JPanel();
        
        jpanel.setLayout(new GridLayout(4, 1, 40,40));
        jpanel.add(label);
        jpanel.add(joinshopPreMainUI);
        jpanel.add(informationPreMainUI);
        jpanel.add(quitPreMainUI);

        JPanel jpanel1 = new JPanel(new BorderLayout());
        jpanel1.add(jpanel, BorderLayout.CENTER);

        jpanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        this.add(jpanel);
    }

    public JButton getJoinshopPreMainUIButton()
    {
        return joinshopPreMainUI;
    }

    public JButton getInformationPreMainUIButton()
    {
        return informationPreMainUI;
    }

    public JButton getQuitPreMainUIButton()
    {
        return quitPreMainUI;
    }

}
