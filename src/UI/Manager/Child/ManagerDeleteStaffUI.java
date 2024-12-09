package UI.Manager.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.*;

public class ManagerDeleteStaffUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField userNameTextField;

    // Button
    private JButton deleteButton;
    private JButton cancelButton;

    //========================================Constructor=========================================
    public ManagerDeleteStaffUI()
    {
        super("Manager.DeleteStaff");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(true);

        
        
        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Delete Staff");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);



        // ===UserName Panel===
        // Panel
        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(userNamePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel userNameLabel = new JLabel("User Name:");
        guiUtil.setAlignmentCenter(userNameLabel);
        guiUtil.setFixedSize(userNameLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        this.userNameTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        userNamePanel.add(Box.createHorizontalGlue());
        userNamePanel.add(userNameLabel);
        userNamePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        userNamePanel.add(this.userNameTextField);
        userNamePanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.cancelButton);

        // Delete Button
        this.deleteButton = guiUtil.createButton("Delete", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.deleteButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.deleteButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(userNamePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    // TextField
    public String getUserName() { return this.userNameTextField.getText(); }
    
    // Button
    public JButton getDeleteButton() { return this.deleteButton; }
    public JButton getCancelButton() { return this.cancelButton; }

    //===========================================Other============================================
    public void wipeOutField()
    {
        this.userNameTextField.setText("");
    }
}
