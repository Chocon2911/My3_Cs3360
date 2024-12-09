package UI.Staff.Child;

import Util.GuiUtil;
import javax.swing.*;

public class StaffMainUI extends JFrame
{
    // Variable 
    private JButton displayInformationButton;
    private JButton depositButton;
    private JButton displayRequestButton;
    private JButton quitButton;

    // Constructor
    public StaffMainUI (){
        // Frame
        super("Staff.Main");
        setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel staffPanel = GuiUtil.getInstance().getMainPanel();

        // Title Label
        JLabel titleLabel = GuiUtil.getInstance().getTitleLabel("Staff");
        
        // Display Information Button
        this.displayInformationButton = GuiUtil.getInstance().createButton("Display Information", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(displayInformationButton);

        // Deposit Button
        this.depositButton = GuiUtil.getInstance().createButton("Deposit Customer", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(depositButton);

        // Display Request Button
        this.displayRequestButton = GuiUtil.getInstance().createButton("Customer Request", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(displayRequestButton);

        // Quit Button
        this.quitButton = GuiUtil.getInstance().createButton("Quit", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(quitButton);

        // Display
        staffPanel.add(Box.createVerticalGlue());
        staffPanel.add(titleLabel);
        staffPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        staffPanel.add(displayInformationButton);
        staffPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        staffPanel.add(depositButton);
        staffPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        staffPanel.add(displayRequestButton);
        staffPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        staffPanel.add(quitButton);
        staffPanel.add(Box.createVerticalGlue());

        add(staffPanel);
    }
    
    // Get
    public JButton getDisplayInformationButton() { return this.displayInformationButton; }
    public JButton getDepositButton() { return this.depositButton; }
    public JButton getDisplayRequestButton() { return this.displayRequestButton; }
    public JButton getQuitButton() { return this.quitButton; }
}
