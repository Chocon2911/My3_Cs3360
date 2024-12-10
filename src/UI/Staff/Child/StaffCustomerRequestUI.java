package UI.Staff.Child;

import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import Obj.Data.CustomerRequest;
import Obj.Data.Staff;

public class StaffCustomerRequestUI extends JFrame 
{
    // ===Variable===
    // local 
    private JPanel crPane = new JPanel();
    // public
    private JButton backButton;
    private List<JButton> crButtons = new ArrayList<>();



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
        panel.add(crPane);
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
    public List<JButton> getRequestsButton() {return this.crButtons;}

    //============================================================================================
    //========================================Information=========================================
    //============================================================================================

    //============================================Set=============================================
    public void setCustomerRequests(List<CustomerRequest> customerReqs)
    {
        // ===Main Panel===
        this.crPane.removeAll();
        this.crPane.setLayout(new BoxLayout(crPane, BoxLayout.Y_AXIS));

        // ===Staff Information Panel===
        JPanel requestInfoPanel = this.displayRequestInfo(customerReqs);

        // ===Display===
        this.crPane.add(requestInfoPanel);
        this.crPane.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
    }

    private JPanel displayRequestInfo(List<CustomerRequest> customerReqs)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Title Label
        JLabel titleLabel = new JLabel("Requests");
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));

        // Requests Panel
        for (int i = 0;i <customerReqs.size(); i++)
        {
            // Create Button
            JButton requestsButton = new JButton();
            requestsButton = GuiUtil.getInstance().createButton("Request " + i, GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
            
            // List Button
            this.crButtons.add(requestsButton);

            // Panel
            panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
            panel.add(requestsButton);

        }

        // Display
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(titleLabel);

        return panel;
    }
    
}

