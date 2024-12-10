package UI.Staff.Child;

import Util.GuiUtil;

import java.awt.BorderLayout;
import java.awt.Component;
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
        GuiUtil guiUtil = GuiUtil.getInstance();
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
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);
        this.backButton.setAlignmentY(Component.TOP_ALIGNMENT);
        
        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(refuseButton);
        buttonPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        buttonPanel.add(acceptButton);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(backButton);


        // ===Scroll Panel===
        JScrollPane scrollPanel = new JScrollPane(requestedItemsPanel);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(30);

        // Display
        requestedItemsPanel.add(Box.createHorizontalGlue());
        requestedItemsPanel.add(buttonPanel);
        requestedItemsPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));

        add(requestedItemsPanel);
        add(scrollPanel, BorderLayout.EAST);
    }
    // ===Get===
    // Get Button
    public JButton getRefuseButton() {return this.refuseButton;}
    public JButton getBackButton() {return this.backButton;}
    public JButton getAcceptButton() {return this.acceptButton;}
}
