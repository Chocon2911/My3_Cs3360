package UI.Staff.Child;

import Util.GuiUtil;
import javax.swing.*;

public class StaffDepositCustomerUI extends JFrame
{
    // ===Variable===
    // TextField
    private JTextField customerName;
    private JTextField depositAmount;

    // Button
    private JButton acceptButton;
    private JButton cancelButton;

    // ===Constructor===
    public StaffDepositCustomerUI()
    {
        // ===Frame===
        super("Staff.Main.Deposit");
        setResizable(false);
        setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameWidth);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===Customer Panel===
        JPanel depositPanel = new JPanel();
        depositPanel.setLayout(new BoxLayout(depositPanel, BoxLayout.Y_AXIS));

        // ===Title Label===
        JLabel titleLabel = GuiUtil.getInstance().getTitleLabel("Deposit");



        // ===Customer Name Panel===
        // Panel
        JPanel customerNamePanel = new JPanel();
        customerNamePanel.setLayout(new BoxLayout(customerNamePanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(customerNamePanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Label
        JLabel customerNameLabel = new JLabel("Username: ");
        GuiUtil.getInstance().setFixedSize(customerNameLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // IdField
        this.customerName = new JTextField(GuiUtil.getInstance().textFieldAmount);

        // Display
        customerNamePanel.add(Box.createHorizontalGlue());
        customerNamePanel.add(customerNameLabel);
        customerNamePanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        customerNamePanel.add(customerName);
        customerNamePanel.add(Box.createHorizontalGlue());



        // ===Deposit Amount Panel===
        // Panel 
        JPanel depositAmountPanel = new JPanel();
        depositAmountPanel.setLayout(new BoxLayout(depositAmountPanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(depositAmountPanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Label
        JLabel depositAmountLabel = new JLabel("Amount:");
        GuiUtil.getInstance().setFixedSize(depositAmountLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // Deposit Feild
        this.depositAmount = new JTextField(GuiUtil.getInstance().textFieldAmount);

        // Display
        depositAmountPanel.add(Box.createHorizontalGlue());
        depositAmountPanel.add(depositAmountLabel);
        depositAmountPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        depositAmountPanel.add(depositAmount);
        depositAmountPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(buttonPanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Cancel Button
        this.cancelButton = GuiUtil.getInstance().createButton("Cancel", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(cancelButton);

        // Accept Button
        this.acceptButton = GuiUtil.getInstance().createButton("Accept", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(acceptButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        buttonPanel.add(acceptButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        depositPanel.add(Box.createVerticalGlue());
        depositPanel.add(titleLabel);
        depositPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        depositPanel.add(customerNamePanel);
        depositPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        depositPanel.add(depositAmountPanel);
        depositPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        depositPanel.add(buttonPanel);
        depositPanel.add(Box.createVerticalGlue());

        add(depositPanel);
    }

    // ===Get===
    // Get TextField
    public String getCustomerName() {return this.customerName.getText();}
    public String getDepositAmount() {return this.depositAmount.getText();}

    // Get Button
    public JButton getCancelButton() {return this.cancelButton;}
    public JButton getAcceptButton() {return this.acceptButton;}
}