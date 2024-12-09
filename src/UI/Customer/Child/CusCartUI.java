package UI.Customer.Child;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CusCartUI extends JFrame {
    private JButton backButton;
    private JButton requestButton;
    private JButton removeButton;

    public CusCartUI()
    {
        this.setTitle("Your Cart");
        this.setSize(450,550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        jpanel2.add(jpanel1, BorderLayout.SOUTH);

        this.add(jpanel2);
    }

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
}
