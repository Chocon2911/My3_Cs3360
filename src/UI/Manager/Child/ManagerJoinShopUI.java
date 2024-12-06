package UI.Manager.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.*;

public class ManagerJoinShopUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField checkInCodeTextField;

    // Button
    private JButton joinButton;
    private JButton cancelButton;

    //========================================Constructor=========================================
    public ManagerJoinShopUI()
    {
        super("Manager.JoinShop");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(true);



        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Join Shop");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);



        // ===CheckInCode Panel===
        // Panel
        JPanel checkInCodePanel = new JPanel();
        checkInCodePanel.setLayout(new BoxLayout(checkInCodePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(checkInCodePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel checkInCodeLabel = new JLabel("CheckIn Code:");
        guiUtil.setAlignmentCenter(checkInCodeLabel);
        guiUtil.setFixedSize(checkInCodeLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        this.checkInCodeTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        checkInCodePanel.add(Box.createHorizontalGlue());
        checkInCodePanel.add(checkInCodeLabel);
        checkInCodePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        checkInCodePanel.add(this.checkInCodeTextField);
        checkInCodePanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.cancelButton);

        // Join Button
        this.joinButton = guiUtil.createButton("Join", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.joinButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.joinButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(checkInCodePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    // TextField
    public String getCheckInCode() { return this.checkInCodeTextField.getText(); }

    // Button
    public JButton getJoinButton() { return this.joinButton; }
    public JButton getCancelButton() { return this.cancelButton; }

    //===========================================Other============================================
    public void wipeOutField()
    {
        this.checkInCodeTextField.setText("");
    }
}
