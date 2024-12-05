package UI.App1.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.*;

public class App1MainUI extends JFrame
{
    //==========================================Variable==========================================
    private JButton loginButton;
    private JButton signUpButton;
    private JButton quitButton;

    //========================================Constructor=========================================
    public App1MainUI()
    {
        super("App1");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("App1");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        
        // Login Button
        this.loginButton = guiUtil.createButton("Login", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.loginButton);

        // SignUp Button
        this.signUpButton = guiUtil.createButton("Sign Up", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.signUpButton);
        
        // Quit Button
        this.quitButton = guiUtil.createButton("Quit", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.quitButton);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.loginButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.signUpButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.quitButton);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    public JButton getLoginButton() { return this.loginButton; }
    public JButton getSignUpButton() { return this.signUpButton; }
    public JButton getQuitButton() { return this.quitButton; }
}
