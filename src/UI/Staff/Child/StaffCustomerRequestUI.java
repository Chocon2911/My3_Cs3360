package UI.Staff.Child;

import Obj.Data.CustomerRequest;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class StaffCustomerRequestUI extends JFrame
{
    //==========================================Variable==========================================
    // Frame
    private final JPanel customerReqsPanel = new JPanel();
    private final JButton backButton;
    
    // customerReqsPanel
    private List<JButton> customerReqButtons = new ArrayList<>();
    private List<CustomerRequest> customerReqs = new ArrayList<>();

    //========================================Constructor=========================================
    public StaffCustomerRequestUI() 
    {
        super("Staff.Main.CustomerRequest");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);
        setLayout(new BorderLayout());



        // ===Panel===
        JPanel panel = guiUtil.getMainPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Customer Request");
        
        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.customerReqsPanel);
        panel.add(Box.createVerticalGlue());

        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);

        // ===Back Button===
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.backButton);

        // ===Display===
        add(scrollPane, BorderLayout.CENTER);
        add(backButton, BorderLayout.SOUTH);
    }

    //============================================Get=============================================
    public JButton getBackButton() { return this.backButton; }
    public List<JButton> getCustomerReqButtons() { return this.customerReqButtons; }
    public List<CustomerRequest> getCustomerReqs() { return this.customerReqs; }
    
    //============================================Set=============================================
    public void setCustomerReqsPanel(List<CustomerRequest> customerRequests)
    {
        this.customerReqsPanel.removeAll();
        this.customerReqsPanel.setLayout(new BoxLayout(this.customerReqsPanel, BoxLayout.Y_AXIS));
        this.customerReqButtons.clear();
        GuiUtil guiUtil = GuiUtil.getInstance();
        this.customerReqs = customerRequests;
        if (customerReqs == null || customerReqs.isEmpty())
        {
            System.out.println("setCsPanel(): customerReqs is null or empty");
            return;
        }

        for (CustomerRequest customerReq : customerReqs)
        {
            // Button
            if (customerReq == null)
            {
                System.out.println("setCsPanel(): A customerRequest is null");
                continue;
            }

            JButton customerReqButton = guiUtil.createButton(customerReq.getRequestedCustomer().getName() + " - " + customerReq.getId(), guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
            this.customerReqButtons.add(customerReqButton);

            // Panel
            this.customerReqsPanel.add(customerReqButton);
            this.customerReqsPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        }
    }
}