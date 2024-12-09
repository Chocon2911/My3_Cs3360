package UI.App2.Child;

import Util.GuiUtil;
import javax.swing.*;

public class App2SignUpUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField nameTextField;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;
    private JTextField systemCodeTextField;
    private JTextField checkInCodeTextField;
    // Button
    private JButton registerButton;
    private JButton cancelButton;

    //========================================Constructor=========================================
    public App2SignUpUI()
    {
        // ===Frame===
        super("App2.Main.SignUp");
        setResizable(false);
        setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameWidth);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = GuiUtil.getInstance().getTitleLabel("Sign Up");
        


        // ===Name Panel===
        // Panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(namePanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Name Label
        JLabel nameLabel = new JLabel("Name:");
        GuiUtil.getInstance().setFixedSize(nameLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // Name Field
        this.nameTextField = new JTextField(GuiUtil.getInstance().textFieldAmount);

        // Display
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(nameLabel);
        namePanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        namePanel.add(nameTextField);
        namePanel.add(Box.createHorizontalGlue());



        // ===UserName Panel===
        // Panel
        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(userNamePanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Label
        JLabel userNameLabel = new JLabel("User Name:");
        GuiUtil.getInstance().setFixedSize(userNameLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // Text Field
        this.userNameTextField = new JTextField(GuiUtil.getInstance().textFieldAmount);

        // Display
        userNamePanel.add(Box.createHorizontalGlue());
        userNamePanel.add(userNameLabel);
        userNamePanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        userNamePanel.add(userNameTextField);
        userNamePanel.add(Box.createHorizontalGlue());



        // ===Password Panel===
        // Panel
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(passwordPanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Label
        JLabel passwordLabel = new JLabel("Password:");
        GuiUtil.getInstance().setFixedSize(passwordLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // password Field
        this.passwordTextField = new JPasswordField(GuiUtil.getInstance().textFieldAmount);

        // Display
        passwordPanel.add(Box.createHorizontalGlue());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        passwordPanel.add(passwordTextField);
        passwordPanel.add(Box.createHorizontalGlue());



        // ===SystemCode Panel===
        // Panel
        JPanel systemCodePanel = new JPanel();
        systemCodePanel.setLayout(new BoxLayout(systemCodePanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(systemCodePanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Label
        JLabel systemCodeLabel = new JLabel("System Code:");
        GuiUtil.getInstance().setFixedSize(systemCodeLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // Text Field
        this.systemCodeTextField = new JTextField(GuiUtil.getInstance().textFieldAmount);

        // Display
        systemCodePanel.add(Box.createHorizontalGlue());
        systemCodePanel.add(systemCodeLabel);
        systemCodePanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        systemCodePanel.add(systemCodeTextField);
        systemCodePanel.add(Box.createHorizontalGlue());



        // ===CheckInCode Panel===
        // Panel
        JPanel checkInCodePanel = new JPanel();
        checkInCodePanel.setLayout(new BoxLayout(checkInCodePanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(checkInCodePanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Label
        JLabel checkInCodeLabel = new JLabel("Check In Code:");
        GuiUtil.getInstance().setFixedSize(checkInCodeLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // Text Field
        this.checkInCodeTextField = new JTextField(GuiUtil.getInstance().textFieldAmount);

        // Display
        checkInCodePanel.add(Box.createHorizontalGlue());
        checkInCodePanel.add(checkInCodeLabel);
        checkInCodePanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        checkInCodePanel.add(checkInCodeTextField);
        checkInCodePanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(buttonPanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Cancel Button
        this.cancelButton = GuiUtil.getInstance().createButton("Cancel", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(cancelButton);

        // Register Button
        this.registerButton = GuiUtil.getInstance().createButton("Register", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(registerButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        buttonPanel.add(registerButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(userNamePanel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(systemCodePanel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(checkInCodePanel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    // TextField
    public String getNameStr() { return this.nameTextField.getText(); }
    public String getUserName() { return this.userNameTextField.getText(); }
    public String getPassword() { return String.valueOf(this.passwordTextField.getPassword()); }
    public String getSystemCode() { return this.systemCodeTextField.getText(); }
    public String getCheckInCode() { return this.checkInCodeTextField.getText(); }

    // Button
    public JButton getCancelButton() { return this.cancelButton; }
    public JButton getRegisterButton() { return this.registerButton; }

    //===========================================Other============================================
    public void wipeOutField()
    {
        this.nameTextField.setText(null);
        this.userNameTextField.setText(null);
        this.passwordTextField.setText(null);
        this.systemCodeTextField.setText(null);
        this.checkInCodeTextField.setText(null);
    }
}
