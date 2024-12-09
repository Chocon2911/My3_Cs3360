package UI.App1.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.*;

public class App1SignUpUI extends JFrame
{
    //==========================================Variable==========================================
    // Text Field
    private JTextField nameField;
    private JTextField userNameField;
    private JPasswordField passwordField;

    // Button
    private JButton registerButton;
    private JButton cancelButton;

    //========================================Constructor=========================================
    public App1SignUpUI()
    {
        super("App1.Main.SignUp");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setResizable(false);
        setSize(guiUtil.frameWidth, guiUtil.frameWidth);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);
        


        // ===Name Panel===
        // Panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(namePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Name Label
        JLabel nameLabel = new JLabel("Name:");
        guiUtil.setFixedSize(nameLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // Name Field
        this.nameField = new JTextField(guiUtil.textFieldAmount);

        // Display
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(nameLabel);
        namePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        namePanel.add(this.nameField);
        namePanel.add(Box.createHorizontalGlue());



        // ===UserName Panel===
        // Panel
        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(userNamePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel userNameLabel = new JLabel("User Name:");
        guiUtil.setFixedSize(userNameLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // Text Field
        this.userNameField = new JTextField(guiUtil.textFieldAmount);

        // Display
        userNamePanel.add(Box.createHorizontalGlue());
        userNamePanel.add(userNameLabel);
        userNamePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        userNamePanel.add(this.userNameField);
        userNamePanel.add(Box.createHorizontalGlue());



        // ===Password Panel===
        // Panel
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(passwordPanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel passwordLabel = new JLabel("Password:");
        guiUtil.setFixedSize(passwordLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // password Field
        this.passwordField = new JPasswordField(guiUtil.textFieldAmount);

        // Display
        passwordPanel.add(Box.createHorizontalGlue());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        passwordPanel.add(this.passwordField);
        passwordPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(buttonPanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.cancelButton);

        // Register Button
        this.registerButton = guiUtil.createButton("Register", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.registerButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.registerButton);
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
    public final String getNameStr() { return this.nameField.getText(); }
    public final String getUserName() { return this.userNameField.getText(); }
    public final String getPassword() { return new String(this.passwordField.getPassword()); }

    // Button
    public final JButton getRegisterButton() { return this.registerButton; }
    public final JButton getCancelButton() { return this.cancelButton; }

    //===========================================Other============================================
    public void wipeOutField()
    {
        this.nameField.setText("");
        this.userNameField.setText("");
        this.passwordField.setText("");
    }
}
