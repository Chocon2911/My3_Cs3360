package UI.App2.Child;

import Util.GuiUtil;
import javax.swing.*;

public class App2LoginUI extends JFrame
{
    //==========================================Variable==========================================
    // Text Field
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;

    // Button
    private JButton cancelButton;
    private JButton loginButton;

    //========================================Constructor=========================================
    public App2LoginUI()
    {
        // ===Frame===
        super("App2.Main.Login");
        setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // ===Panel===
        JPanel panel = GuiUtil.getInstance().getMainPanel();

        // ===Title Label===
        JLabel titleLabel = GuiUtil.getInstance().getTitleLabel("Login");

        // ===UserName Panel===
        // Panel
        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(userNamePanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // UserName Label
        JLabel userNameLabel = new JLabel("User Name:");
        GuiUtil.getInstance().setFixedSize(userNameLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // UserName Text Field
        this.userNameTextField = new JTextField(GuiUtil.getInstance().textFieldAmount);

        // Display
        userNamePanel.add(Box.createHorizontalGlue());
        userNamePanel.add(userNameLabel);
        userNamePanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        userNamePanel.add(this.userNameTextField);
        userNamePanel.add(Box.createHorizontalGlue());



        // ===Password Panel===
        // Panel
        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(passwordPanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Password Label
        JLabel passwordLabel = new JLabel("Password:");
        GuiUtil.getInstance().setFixedSize(passwordLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // Password Text Field
        this.passwordTextField = new JPasswordField(GuiUtil.getInstance().textFieldAmount);

        // Display
        passwordPanel.add(Box.createHorizontalGlue());
        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        passwordPanel.add(passwordTextField);
        passwordPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(buttonPanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Cancel Button
        this.cancelButton = GuiUtil.getInstance().createButton("Cancel", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(cancelButton);
        
        // Login Button
        this.loginButton = GuiUtil.getInstance().createButton("Login", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(loginButton);

        // Display 
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        buttonPanel.add(loginButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(userNamePanel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(passwordPanel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    // TextField
    public String getUserName() { return this.userNameTextField.getText(); }
    public String getPassword() { return new String(this.passwordTextField.getPassword()); }

    // Button
    public JButton getCancelButton() { return this.cancelButton; }
    public JButton getLoginButton() { return this.loginButton; }
}
