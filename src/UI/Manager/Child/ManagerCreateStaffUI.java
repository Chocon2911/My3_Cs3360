package UI.Manager.Child;

import Util.GuiUtil;
import javax.swing.*;

public class ManagerCreateStaffUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField nameTextField;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;

    // Button
    private JButton createButton;
    private JButton cancelButton;

    //========================================Constructor=========================================
    public ManagerCreateStaffUI()
    {
        super("Manager.CreateStaff");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(true);

        // ===Panel===
        JPanel panel = guiUtil.getMainPanel();

        // ===Title===
        JLabel titleLabel = guiUtil.getTitleLabel("Create Staff");

        // ===Name Panel===
        // Panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(namePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel nameLabel = new JLabel("Name:");
        guiUtil.setAlignmentCenter(nameLabel);
        guiUtil.setFixedSize(nameLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        this.nameTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(nameLabel);
        namePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        namePanel.add(this.nameTextField);
        namePanel.add(Box.createHorizontalGlue());



        // ===User Name Panel===
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



        // ===Password Panel===
        // Panel
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(passwordPanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel passwordLabel = new JLabel("Password:");
        guiUtil.setAlignmentCenter(passwordLabel);
        guiUtil.setFixedSize(passwordLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        this.passwordTextField = new JPasswordField(guiUtil.textFieldAmount);

        // Display        
        passwordPanel.add(Box.createHorizontalGlue());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        passwordPanel.add(this.passwordTextField);
        passwordPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.cancelButton);

        // Create Button
        this.createButton = guiUtil.createButton("Create", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.createButton);
        
        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.createButton);
        buttonPanel.add(Box.createHorizontalGlue());


        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(userNamePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());
        
        add(panel);
    }

    //============================================Get=============================================
    // TextField
    public String getNameTextField() { return this.nameTextField.getText(); }
    public String getUserNameTextField() { return this.userNameTextField.getText(); }
    public String getPasswordTextField() { return new String(this.passwordTextField.getPassword()); }

    // Button
    public JButton getCreateButton() { return this.createButton; }
    public JButton getCancelButton() { return this.cancelButton; }
}
