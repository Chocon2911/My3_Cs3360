package UI.Shop.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopMainUI extends JFrame
{
    //==========================================Variable==========================================
    private JButton infoButton;
    private JButton createManagerButton;
    private JButton changeCheckInCodeButton;
    private JButton quitButton;

    //========================================Constructor=========================================
    public ShopMainUI()
    {
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        JFrame frame = new JFrame("App2.Shop.Main");
        frame.setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        frame.setResizable(false);

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Shop");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));

        // Information Button
        this.infoButton = guiUtil.createButton("Information", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.infoButton);

        // CreateManager Button
        this.createManagerButton = guiUtil.createButton("Create Manager", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.createManagerButton);

        // ChangeCheckInCode Button
        this.changeCheckInCodeButton = guiUtil.createButton("Change Check In Code", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.changeCheckInCodeButton);

        // Quit Button
        this.quitButton = guiUtil.createButton("Quit", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.quitButton);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.infoButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.createManagerButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.changeCheckInCodeButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.quitButton);
        panel.add(Box.createVerticalGlue());
        
        frame.add(panel);
    }

    //============================================Get=============================================
    public JButton getInfoButton() { return this.infoButton; }
    public JButton getCreateManagerButton() { return this.createManagerButton; }
    public JButton getChangeCheckInCodeButton() { return this.changeCheckInCodeButton; }
    public JButton getQuitButton() { return this.quitButton; }
}
