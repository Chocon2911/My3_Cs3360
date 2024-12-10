package UI.Staff.Child;

import Util.GuiUtil;
import javax.swing.*;

public class StaffPreMainUI extends JFrame
{
    // public
    private JButton displayInformationButton;
    private JButton checkincodeButton;
    private JButton quitButton;

    //============================================================================================
    //=============================================UI============================================
    //============================================================================================
    // Constructor
    public StaffPreMainUI (){
        // Frame
        super("Staff.PreMain");
        setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main Panel
        JPanel staffPanel = GuiUtil.getInstance().getMainPanel();

        // Title Label
        JLabel titleLabel = GuiUtil.getInstance().getTitleLabel("Pre Main");
        
        // Display Information Button
        this.displayInformationButton = GuiUtil.getInstance().createButton("Display Information", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(displayInformationButton);

        // Checkin Button
        this.checkincodeButton = GuiUtil.getInstance().createButton("Join Shop", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(checkincodeButton);

        // Quit Button
        this.quitButton = GuiUtil.getInstance().createButton("Quit", GuiUtil.getInstance().bigButtonWidth, GuiUtil.getInstance().bigButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(quitButton);

        // Display
        staffPanel.add(Box.createVerticalGlue());
        staffPanel.add(titleLabel);
        staffPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        staffPanel.add(displayInformationButton);
        staffPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        staffPanel.add(checkincodeButton);
        staffPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        staffPanel.add(quitButton);
        staffPanel.add(Box.createVerticalGlue());

        add(staffPanel);
    }
    
    // Get
    public JButton getDisplayInformationButton() { return this.displayInformationButton; }
    public JButton getCheckinButton() { return this.checkincodeButton; }
    public JButton getQuitButton() { return this.quitButton; }

}