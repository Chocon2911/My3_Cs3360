package UI.App2.Child;

import Util.GuiUtil;
import javax.swing.*;

public class App2MainUI extends JFrame
{
    //==========================================Variable==========================================
    private JButton loginButton;
    private JButton signUpButton;
    private JButton quitButton;

    //========================================Constructor=========================================
    public App2MainUI()
    {
        // Frame
        super("App2.Main");
        setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel panel = GuiUtil.getInstance().getMainPanel();

        // Title Label
        JLabel titleLabel = GuiUtil.getInstance().getTitleLabel("App2");
        
        // Login Button
        this.loginButton = GuiUtil.getInstance().createButton("Login", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(loginButton);

        // SignUp Button
        this.signUpButton = GuiUtil.getInstance().createButton("Sign Up", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(signUpButton);
        
        // Quit Button
        this.quitButton = GuiUtil.getInstance().createButton("Quit", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(quitButton);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(loginButton);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(signUpButton);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(quitButton);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    public JButton getLoginButton() { return loginButton; }
    public JButton getSignUpButton() { return signUpButton; }
    public JButton getQuitButton() { return quitButton; }
}
