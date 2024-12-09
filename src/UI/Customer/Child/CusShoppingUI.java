package UI.Customer.Child;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CusShoppingUI extends JFrame {
    private JButton backButton;
    private List<JButton> itemButtons; // LXHuy

    public CusShoppingUI()
    {
        this.setTitle("Choose your Product");
        this.setSize(450,550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension buttonSize = new Dimension(80, 30);

        backButton = new JButton("Back");
        backButton.setPreferredSize(buttonSize);

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BorderLayout());
        jpanel.add(backButton, BorderLayout.WEST);
        jpanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 450, 0));
        this.add(jpanel);
    }

    public JButton getBackButton()
    {
        return backButton;
    }

    // LXhuy
    public List<JButton> getItemButtons() { return this.itemButtons; }

}
