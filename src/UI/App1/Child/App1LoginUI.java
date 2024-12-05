package UI.App1.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.*;

public class App1LoginUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;

    // Button
    private JButton cancelButton;
    private JButton loginButton;

    //========================================Constructor=========================================
    public App1LoginUI()
    {
        super("App1.Login");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);



        // ===UserName Panel===
        // Panel
        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(userNamePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // UserName Label
        JLabel userNameLabel = new JLabel("User Name:");
        guiUtil.setFixedSize(userNameLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // UserName Text Field
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

        // Password Label
        JLabel passwordLabel = new JLabel("Password:");
        guiUtil.setFixedSize(passwordLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // Password Text Field
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
        guiUtil.setFixedSize(buttonPanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.cancelButton);
        
        // Login Button
        this.loginButton = guiUtil.createButton("Login", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.loginButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.loginButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
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
    public JTextField getUserNameTextField() { return this.userNameTextField; }
    public JPasswordField getPasswordTextField() { return this.passwordTextField; }

    // Button
    public JButton getCancelButton() { return this.cancelButton; }
    public JButton getLoginButton() { return this.loginButton; }
}
