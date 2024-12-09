package UI.Staff.Child;

import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Obj.Data.CustomerRequest;
import Obj.Data.Staff;

public class StaffInfoUI extends JFrame
{
    // ===Variable===
    // local
    private JPanel staffInfoPanel = new JPanel();
    // public
    private JButton backButton;


    // ===Constructor===
    public StaffInfoUI()
    {
        super("Staff.Main.Information");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // Frame
        setSize(600, 700);
        setResizable(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        // ===Title Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Staff Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(staffInfoPanel);
        panel.add(Box.createVerticalGlue());



        // ===Back Button Panel===
        // Back Panel
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new BoxLayout(backButtonPanel, BoxLayout.Y_AXIS));

        // Back Button
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);
        this.backButton.setAlignmentY(Component.TOP_ALIGNMENT);

        // Display
        backButtonPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        backButtonPanel.add(this.backButton);



        // ===Scroll Panel===
        JScrollPane scrollPanel = new JScrollPane(panel);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.getVerticalScrollBar().setUnitIncrement(30);

        // Display
        add(backButtonPanel, BorderLayout.WEST);
        add(scrollPanel, BorderLayout.CENTER);
    }

    // ===Get===
    public JButton getBackButton() { return this.backButton; }

    //============================================================================================
    //========================================Information=========================================
    //============================================================================================

    //============================================Set=============================================
    public void setStaffInfo(Staff staff)
    {
        // ===Main Panel===
        this.staffInfoPanel.removeAll();
        this.staffInfoPanel.setLayout(new BoxLayout(staffInfoPanel, BoxLayout.Y_AXIS));

        // ===Staff Information Panel===
        JPanel staffInforPanel = this.displayStaffInfor(staff);

        // ===Display===
        this.staffInfoPanel.add(staffInforPanel);
        this.staffInfoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
    }



    //==========================================Staff Information==================================
    private JPanel displayStaffInfor(Staff staff)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Title Label
        JLabel titleLabel = new JLabel(staff.getUserName());
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));

        // Username Label
        JLabel staffUsernamLabel = GuiUtil.getInstance().getNormalLabel("Username: " + staff.getUserName());

        // Name Label
        JLabel staffNameLabel = GuiUtil.getInstance().getNormalLabel("Name: " + staff.getName());

        // Password Label
        JLabel staffPasswordLabel = GuiUtil.getInstance().getNormalLabel("Password: " + staff.getPassword());

        // Shop name Label
        JLabel staffShopLabel = GuiUtil.getInstance().getNormalLabel("Password: ");

        // Display
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(staffUsernamLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(staffNameLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(staffPasswordLabel);

        return panel;
    }
}