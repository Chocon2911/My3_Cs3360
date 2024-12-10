package UI.Staff.Child;

import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.List;

import javax.swing.*;

import Obj.Data.Customer;
import Obj.Data.CustomerRequest;
import Obj.Data.Staff;

public class StaffCustomerRequestUI extends JFrame 
{
    // ===Variable===
    // local 
    private JPanel customerRequestsPanel = new JPanel();
    // public
    private JButton backButton;


    // ===Constructor===
    public StaffCustomerRequestUI()
    {
        super("Staff.Main.Request");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        setSize(600, 700);
        setResizable(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // ===Title Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Customer Requests");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createHorizontalStrut(guiUtil.verticalStrut));
        panel.add(customerRequestsPanel);
        panel.add(Box.createVerticalGlue());



        // ===Back Button Panel===
        // Back Panel
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new BoxLayout(backButtonPanel, BoxLayout.Y_AXIS));

        // Back Button
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);
        this.backButton.setAlignmentY(Component.TOP_ALIGNMENT);

        // Display
        backButtonPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        backButtonPanel.add(this.backButton);



        // ===Scroll Panel===
        JScrollPane scrollPanel = new JScrollPane(panel);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(30);

        // Display
        add(backButtonPanel, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);
    }

    // ===Get===
    public JButton getBackButton() { return this.backButton; }

    //============================================================================================
    //========================================Information=========================================
    //============================================================================================

    //============================================Set=============================================
    public void setCustonmerInfo(Customer customer)
    {
        // ===Main Panel===
        this.customerRequestsPanel.removeAll();
        this.customerRequestsPanel.setLayout(new BoxLayout(customerRequestsPanel, BoxLayout.Y_AXIS));

        // ===Staff Information Panel===
        JPanel requestInfoPanel = this.displayRequestInfo(customer);

        // ===Display===
        this.customerRequestsPanel.add(requestInfoPanel);
        this.customerRequestsPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
    }
    private JPanel displayRequestInfo(Customer customer)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Title Label
        JLabel titleLabel = new JLabel("Requests");
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));

        // Requests Label
        JLabel requestsLabel = GuiUtil.getInstance().getNormalLabel("Requests: " + customer.getCustomerRequests());

        // Display
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(requestsLabel);

        return panel;
    }
}

