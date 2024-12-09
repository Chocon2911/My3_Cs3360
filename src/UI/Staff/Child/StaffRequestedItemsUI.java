package UI.Staff.Child;

import Util.GuiUtil;
import javax.swing.*;

public class StaffRequestedItemsUI extends JFrame
{
    // ===Variable===
    //

    // Button
    private JButton acceptButton;
    private JButton refuseButton;
    private JButton backButton;

    // ===Constructor===
    public StaffRequestedItemsUI()
    {
        // ===Frame===
        super("Staff.Main.Requests.Items");
        setResizable(false);
        setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameWidth);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===Main Panel===
        JPanel requestedItemsPanel = new JPanel();
        requestedItemsPanel.setLayout(new BoxLayout(requestedItemsPanel, BoxLayout.Y_AXIS));

        // ===Title Label===
        JLabel titleLabel = GuiUtil.getInstance().getTitleLabel("Requested Items");



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(buttonPanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Refuse Button
        this.refuseButton = GuiUtil.getInstance().createButton("Refuse", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenterLeft(refuseButton);

        // Accept Button
        this.acceptButton = GuiUtil.getInstance().createButton("Accept", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenterRight(acceptButton);

        // Back Button 
        this.backButton = GuiUtil.getInstance().createButton("Back", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenterLeft(backButton); 
        
        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(refuseButton);
        buttonPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        buttonPanel.add(acceptButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(backButton);

    }
}
