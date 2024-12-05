package UI.Manager.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.*;

public class ManagerMainUI extends JFrame
{
    //==========================================Variable==========================================
    private JButton infoButton;
    private JButton createStaffButton;
    private JButton deleteStaffButton;
    private JButton addItemButton;
    private JButton quitButton;

    //========================================Constructor=========================================
    public ManagerMainUI()
    {
        super("Manager.Main");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(true);

        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Manager");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));

        // Info Button
        this.infoButton = guiUtil.createButton("Information", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.infoButton);

        // CreateStaff Button
        this.createStaffButton = guiUtil.createButton("Create Staff", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.createStaffButton);

        // DeleteStaff Button
        this.deleteStaffButton = guiUtil.createButton("Delete Staff", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.deleteStaffButton);

        // AddItem Button
        this.addItemButton = guiUtil.createButton("Add Item", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.addItemButton);

        // Quit Button
        this.quitButton = guiUtil.createButton("Quit", guiUtil.bigButtonWidth, guiUtil.bigButtonHeight);
        guiUtil.setAlignmentCenter(this.quitButton);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.infoButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.createStaffButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.deleteStaffButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.addItemButton);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(this.quitButton);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    public JButton getInfoButton() { return this.infoButton; }
    public JButton getCreateStaffButton() { return this.createStaffButton; }
    public JButton getDeleteStaffButton() { return this.deleteStaffButton; }
    public JButton getAddItemButton() { return this.addItemButton; }
    public JButton getQuitButton() { return this.quitButton; }
}
