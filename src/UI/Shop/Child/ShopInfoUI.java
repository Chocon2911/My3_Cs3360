package UI.Shop.Child;

import Obj.Data.Customer;
import Obj.Data.CustomerRequest;
import Obj.Data.Item;
import Obj.Data.Manager;
import Obj.Data.Shop;
import Obj.Data.Staff;
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

public class ShopInfoUI extends JFrame
{
    //==========================================Variable==========================================
    // local
    private JPanel infoPanel = new JPanel();

    // public
    private JButton backButton;

    //========================================Constructor=========================================
    public ShopInfoUI() 
    {
        super("App2.Shop.Main.Information");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(600, 700);
        setResizable(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



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

    //============================================================================================
    //========================================Information=========================================
    //============================================================================================

    //============================================Set=============================================
    public void setInfoPanel(Shop shop)
    {
        // ===Main Panel===
        this.infoPanel = new JPanel();
        this.infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        
        // ===Private Info Panel===
        JPanel privateInfoPanel = this.displayPrivateInfo(shop);

        // ===Active Managers Panel===
        JPanel activeManagersPanel = this.displayActiveManagers(shop);

        // ===Active Staffs Panel===
        JPanel activeStaffsPanel = this.displayActiveStaffs(shop);

        // ===Active Customers Panel===
        JPanel activeCustomersPanel = this.displayActiveCustomers(shop);

        // ===Items Panel===
        JPanel itemsPanel = this.displayItems(shop);

        // ===Customer Requests Panel===
        JPanel customerRequestsPanel = this.displayCustomerRequests(shop);

        // ===Display===
        this.infoPanel.add(privateInfoPanel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(activeManagersPanel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(activeStaffsPanel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(activeCustomersPanel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(itemsPanel);
        this.infoPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        this.infoPanel.add(customerRequestsPanel);
    }

    //========================================Private Info========================================
    private JPanel displayPrivateInfo(Shop shop)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        // Title Label
        JLabel titleLabel = new JLabel("Shop");
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));

        // Id Label
        JLabel idLabel = GuiUtil.getInstance().getNormalLabel("Id: " + shop.getId());

        // Name Label
        JLabel nameLabel = GuiUtil.getInstance().getNormalLabel("Name: " + shop.getName());

        // UserName Label
        JLabel userNameLabel = GuiUtil.getInstance().getNormalLabel("User Name: " + shop.getUserName());

        // Password Label
        JLabel passwordLabel = GuiUtil.getInstance().getNormalLabel("Password: " + shop.getPassword());

        // SystemCode Label
        JLabel systemCodeLabel = GuiUtil.getInstance().getNormalLabel("System Code: " + shop.getSystemCode());

        // CheckInCode Label
        JLabel checkInCodeLabel = GuiUtil.getInstance().getNormalLabel("Check In Code: " + shop.getCheckInCode());

        // Display
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(idLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(nameLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(userNameLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(passwordLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(systemCodeLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(checkInCodeLabel);

        return panel;
    }

    //=======================================ActiveManagers=======================================
    // Main
    private JPanel displayActiveManagers(Shop shop)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Components
        JLabel titleLabel = this.getTitleActiveManagersLabel();
        JPanel activeManagersPanel = this.getActiveManagersPanel(shop);

        // Display
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(activeManagersPanel);
        
        return panel;
    }

    // Title Label
    private JLabel getTitleActiveManagersLabel()
    {
        // Title Label
        JLabel titleLabel = new JLabel("Active Managers");
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));
        
        return titleLabel;
    }

    // ActiveManagers Panel
    private JPanel getActiveManagersPanel(Shop shop)
    {
        JPanel activeManagersPanel = new JPanel();
        activeManagersPanel.setLayout(new BoxLayout(activeManagersPanel, BoxLayout.Y_AXIS));

        int loop = 0;
        if (shop.getActiveManagers() == null) return activeManagersPanel;
        for (Manager activeManager : shop.getActiveManagers())
        {
            JLabel label = new JLabel((loop + 1) + ". " + activeManager.getId());
            GuiUtil.getInstance().setAlignmentCenter(label);
            label.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTextSize));

            activeManagersPanel.add(label);
            activeManagersPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
            loop++;
        }

        return activeManagersPanel;
    }

    //========================================ActiveStaffs========================================
    // Main
    private JPanel displayActiveStaffs(Shop shop)
    {   
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Components
        JLabel titleLabel = this.getTitleActiveStaffsLabel();
        JPanel activeStaffsPanel = this.getActiveStaffsPanel(shop);

        // Display
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(activeStaffsPanel);
        
        return panel;
    }

    // Title Label
    private JLabel getTitleActiveStaffsLabel()
    {
        // Title Label
        JLabel titleLabel = new JLabel("Active Staffs");
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));
        
        return titleLabel;
    }

    // ActiveStaffs Panel
    private JPanel getActiveStaffsPanel(Shop shop)
    {
        JPanel activeStaffsPanel = new JPanel();
        activeStaffsPanel.setLayout(new BoxLayout(activeStaffsPanel, BoxLayout.Y_AXIS));

        int loop = 0;
        if (shop.getActiveStaffs() == null) return activeStaffsPanel;
        for (Staff activeStaff : shop.getActiveStaffs())
        {
            JLabel label = new JLabel((loop + 1) + ". " + activeStaff.getId());
            GuiUtil.getInstance().setAlignmentCenter(label);
            label.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTextSize));

            activeStaffsPanel.add(label);
            activeStaffsPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
            loop++;
        }

        return activeStaffsPanel;
    }

    //======================================ActiveCustomers=======================================
    private JPanel displayActiveCustomers(Shop shop)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Components
        JLabel titleLabel = this.getTitleActiveCustomersLabel();
        JPanel activeCustomersPanel = this.getActiveCustomersPanel(shop);

        // Display
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(activeCustomersPanel);
        
        return panel;
    }

    // Title Label
    private JLabel getTitleActiveCustomersLabel()
    {
        // Title Label
        JLabel titleLabel = new JLabel("Active Customers");
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));
        
        return titleLabel;
    }

    // ActiveCustomers Panel
    private JPanel getActiveCustomersPanel(Shop shop)
    {
        JPanel activeCustomersPanel = new JPanel();
        activeCustomersPanel.setLayout(new BoxLayout(activeCustomersPanel, BoxLayout.Y_AXIS));

        int loop = 0;
        if (shop.getActiveCustomers() == null) return activeCustomersPanel;
        for (Customer activeCustomer : shop.getActiveCustomers())
        {
            JLabel label = new JLabel((loop + 1) + ". " + activeCustomer.getId());
            GuiUtil.getInstance().setAlignmentCenter(label);
            label.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTextSize));

            activeCustomersPanel.add(label);
            activeCustomersPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
            loop++;
        }

        return activeCustomersPanel;
    }

    //===========================================Items============================================
    private JPanel displayItems(Shop shop)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Components
        JLabel titleLabel = this.getTitleItemsLabel();
        JPanel itemsPanel = this.getItemsPanel(shop);

        // Display
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(itemsPanel);
        
        return panel;
    }

    // Title Label
    private JLabel getTitleItemsLabel()
    {
        // Title Label
        JLabel titleLabel = new JLabel("Items");
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));
        
        return titleLabel;
    }

    // Items Panel
    private JPanel getItemsPanel(Shop shop)
    {
        JPanel itemsPanel = new JPanel();
        itemsPanel.setLayout(new BoxLayout(itemsPanel, BoxLayout.Y_AXIS));

        int loop = 0;
        if (shop.getItems() == null) return itemsPanel;
        for (Item item : shop.getItems())
        {
            JLabel label = new JLabel((loop + 1) + ". " + item.getId());
            GuiUtil.getInstance().setAlignmentCenter(label);
            label.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTextSize));

            itemsPanel.add(label);
            itemsPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
            loop++;
        }

        return itemsPanel;
    }

    //======================================CustomerRequests======================================
    private JPanel displayCustomerRequests(Shop shop)
    {
        // Panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Components
        JLabel titleLabel = this.getTitleCustomerRequestsLabel();
        JPanel customerRequestsPanel = this.getCustomerRequestsPanel(shop);

        // Display
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        panel.add(customerRequestsPanel);
        
        return panel;
    }

    // Title Label
    private JLabel getTitleCustomerRequestsLabel()
    {
        // Title Label
        JLabel titleLabel = new JLabel("Customer Requests");
        GuiUtil.getInstance().setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTitleSize));
        
        return titleLabel;
    }

    // CustomerRequests Panel
    private JPanel getCustomerRequestsPanel(Shop shop)
    {
        JPanel customerRequestsPanel = new JPanel();
        customerRequestsPanel.setLayout(new BoxLayout(customerRequestsPanel, BoxLayout.Y_AXIS));

        int loop = 0;
        if (shop.getCustomerRequests() == null) return customerRequestsPanel;
        for (CustomerRequest customerRequest : shop.getCustomerRequests())
        {
            JLabel label = new JLabel((loop + 1) + ". " + customerRequest.getId());
            GuiUtil.getInstance().setAlignmentCenter(label);
            label.setFont(new Font("Arial", Font.BOLD, GuiUtil.getInstance().normalTextSize));

            customerRequestsPanel.add(label);
            customerRequestsPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
            loop++;
        }

        return customerRequestsPanel;
    }
}
