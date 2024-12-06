package UI.Manager.Child;

import Obj.Data.Manager;
import Util.GuiUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import javax.swing.*;

public class ManagerInfoUI extends JFrame
{
    //==========================================Variable==========================================
    // Local
    private JPanel infoPanel = new JPanel();

    // Public
    private JButton backButton;

    //========================================Constructor=========================================
    public ManagerInfoUI()
    {
        super("Manager.Information");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(600, 700);
        setResizable(true);
        setLayout(new BorderLayout());



        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("Information");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);

        // Display
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createHorizontalStrut(guiUtil.verticalStrut));
        panel.add(infoPanel);
        panel.add(Box.createVerticalGlue());


        
        // ===Back Panel===
        // Back Panel
        JPanel backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));

        // Back Button
        this.backButton = guiUtil.createButton("Back", guiUtil.smallButtonWidth, guiUtil.bigButtonHeight);
        this.backButton.setAlignmentY(Component.TOP_ALIGNMENT);

        // Display
        backPanel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        backPanel.add(this.backButton);



        // ===scrollPane===
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(30);



        // ===Display===
        add(backPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
    }

    //============================================Get=============================================
    public JButton getBackButton() { return this.backButton; }


    //========================================Information=========================================
    public void setInfoPanel(Manager manager)
    {
        this.infoPanel.removeAll();
        if (manager == null) return;

        // MainPanel
        this.infoPanel = GuiUtil.getInstance().getMainPanel();

        // Name Label
        JLabel nameLabel = GuiUtil.getInstance().getNormalLabel(manager.getName());

        // UserName Label
        JLabel userNameLabel = GuiUtil.getInstance().getNormalLabel(manager.getUserName());

        // Password Label
        JLabel passwordLabel = GuiUtil.getInstance().getNormalLabel(manager.getPassword());

        // ShopName Label
        JLabel shopNameLabel = GuiUtil.getInstance().getNormalLabel("Doesn't join Shop yet!");
        if (manager.getShop() != null)
        {
            shopNameLabel = GuiUtil.getInstance().getNormalLabel("Shop Name: " + manager.getShop().getName());
        }

        // Display
        this.infoPanel.add(nameLabel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(userNameLabel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(passwordLabel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(shopNameLabel);
    }
}
