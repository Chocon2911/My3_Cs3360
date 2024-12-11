package UI.Staff.Child;

import Obj.Data.CustomerRequest;
import Obj.Data.RequestedItem;
import Util.GuiUtil;
import java.awt.BorderLayout;
import javax.swing.*;

public class StaffCustomerRequestInfoUI extends JFrame
{
    //==========================================Variable==========================================
    // Panel
    private final JPanel customerReqPanel = new JPanel();
    private CustomerRequest customerReq;

    // Button
    private final JButton backButton;
    private final JButton refuseButton;
    private final JButton acceptButton;

    //========================================Constructor=========================================
    public StaffCustomerRequestInfoUI() 
    {
        super("Staff.Main.CustomerRequest.Info");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);
        setLayout(new BorderLayout());



        // ===Panel===
        // Panel
        JPanel panel = guiUtil.getMainPanel();

        // Title Label
        JLabel titleLabel = guiUtil.getTitleLabel("Request Information");



        // ===Button Panel===
        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));

        // refuse Button
        this.refuseButton = guiUtil.createButton("Refuse", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.refuseButton);

        // Accept Button
        this.acceptButton = guiUtil.createButton("Accept", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.acceptButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.refuseButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.acceptButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.customerReqPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());



        // ===ScrollPane===
        // ScrollPane
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);

        // ===Back Button===
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.backButton);

        // ===Display===
        // Display
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(this.backButton, BorderLayout.WEST);
    }

    //============================================Get=============================================
    // Panel
    public CustomerRequest getCustomerRequest() { return this.customerReq; }

    // Button
    public JButton getBackButton() { return this.backButton; }
    public JButton getRefuseButton() { return this.refuseButton; }
    public JButton getAcceptButton() { return this.acceptButton; }

    //============================================Set=============================================
    public void setCustomerRequestPanel(CustomerRequest chosenCustomerRequest) 
    { 
        GuiUtil guiUtil = GuiUtil.getInstance();
        this.customerReqPanel.removeAll();

        if (chosenCustomerRequest == null) return;
        else if (chosenCustomerRequest.getRequestedItems() == null) return;
        else if (chosenCustomerRequest.getRequestedItems().isEmpty()) return;
        
        for (RequestedItem reqItem : chosenCustomerRequest.getRequestedItems())
        {
            if (reqItem == null) continue;

            // ItemName Label
            JLabel itemNameLabel = guiUtil.getNormalLabel(reqItem.getItem().getName() + " - $" + reqItem.getTotalMoney());

            // Display
            this.customerReqPanel.add(itemNameLabel);
            this.customerReqPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        }
    }
}
