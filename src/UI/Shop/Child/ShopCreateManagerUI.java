package UI.Shop.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ShopCreateManagerUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField nameTextField;
    private JTextField userNameTextField;
    private JPasswordField passwordTextField;

    // Button
    private JButton createButton;
    private JButton backButton;

    //========================================Constructor=========================================
    public ShopCreateManagerUI()
    {
        super("App2.Shop.Main.CreateManager");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));



        // ===Title Label===
        JLabel titleLabel = new JLabel("Create Manager");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);



        // ===Name Panel===
        // Panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(namePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Name Label
        JLabel nameLabel = new JLabel("Name: ");
        guiUtil.setAlignmentCenter(nameLabel);
        guiUtil.setFixedSize(nameLabel, guiUtil.smallLabelWidth, guiUtil.normalLabelHeight);

        // Name TextField
        this.nameTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(nameLabel);
        namePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        namePanel.add(this.nameTextField);
        namePanel.add(Box.createHorizontalGlue());



        // ===UserName Panel===
        // Panel
        JPanel userNamePanel = new JPanel();
        userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(userNamePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // UserName Label
        JLabel userNameLabel = new JLabel("UserName: ");
        guiUtil.setAlignmentCenter(userNameLabel);
        guiUtil.setFixedSize(userNameLabel, guiUtil.smallLabelWidth, guiUtil.normalLabelHeight);

        // UserName TextField
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
        JLabel passwordLabel = new JLabel("Password: ");
        guiUtil.setAlignmentCenter(passwordLabel);
        guiUtil.setFixedSize(passwordLabel, guiUtil.smallLabelWidth, guiUtil.normalLabelHeight);

        // Password TextField
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

        // Back Button
        this.backButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.backButton);

        // Create Button
        this.createButton = guiUtil.createButton("Create", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.createButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.backButton);
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
    public JButton getBackButton() { return this.backButton; }
    public JButton getCreateButton() { return this.createButton; }

    //===========================================Other============================================
    public void wipeOutField()
    {
        this.nameTextField.setText(null);
        this.userNameTextField.setText(null);
        this.passwordTextField.setText(null);
    }
}
