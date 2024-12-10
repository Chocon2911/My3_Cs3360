package UI.Staff.Child;

import Util.GuiUtil;
import javax.swing.*;

import Util.GuiUtil;

public class StaffCheckinCode extends JFrame{
    // ===Variable===
    // Button
    private JButton cancelButton;
    private JButton enterButton;
    // textfield
    private JTextField checkinCode;

    // Constructor
    public StaffCheckinCode()
    {
        // Frame
        super("Staff.PreMain.Checkin");
        setResizable(false);
        setSize(GuiUtil.getInstance().frameWidth, GuiUtil.getInstance().frameWidth);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===Customer Panel===
        JPanel joinShopPanel = new JPanel();
        joinShopPanel.setLayout(new BoxLayout(joinShopPanel, BoxLayout.Y_AXIS));

        // ===Title Label===
        JLabel titleLabel = GuiUtil.getInstance().getTitleLabel("Join shop");



        // ===Checkin Code Panel===
        // Panel
        JPanel checkincodePanel = new JPanel();
        checkincodePanel.setLayout(new BoxLayout(checkincodePanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(checkincodePanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Label
        JLabel shopCodeLabel = new JLabel("Code: ");
        GuiUtil.getInstance().setFixedSize(shopCodeLabel, GuiUtil.getInstance().smallLabelWidth, GuiUtil.getInstance().smallLabelHeight);

        // IdField
        this.checkinCode = new JTextField(GuiUtil.getInstance().textFieldAmount);

        // Display
        checkincodePanel.add(Box.createHorizontalGlue());
        checkincodePanel.add(shopCodeLabel);
        checkincodePanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        checkincodePanel.add(checkinCode);
        checkincodePanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        GuiUtil.getInstance().setFixedSize(buttonPanel, GuiUtil.getInstance().panelTextFieldWidth, GuiUtil.getInstance().panelTextFieldHeight);

        // Cancel Button
        this.cancelButton = GuiUtil.getInstance().createButton("Cancel", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(cancelButton);

        // Enter Button
        this.enterButton = GuiUtil.getInstance().createButton("Enter", GuiUtil.getInstance().smallButtonWidth, GuiUtil.getInstance().smallButtonHeight);
        GuiUtil.getInstance().setAlignmentCenter(enterButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(GuiUtil.getInstance().horizontalStrut));
        buttonPanel.add(enterButton);
        buttonPanel.add(Box.createHorizontalGlue());


        
        // ===Display===
        joinShopPanel.add(Box.createVerticalGlue());
        joinShopPanel.add(titleLabel);
        joinShopPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        joinShopPanel.add(checkincodePanel);
        joinShopPanel.add(Box.createVerticalStrut(GuiUtil.getInstance().verticalStrut));
        joinShopPanel.add(buttonPanel);
        joinShopPanel.add(Box.createVerticalGlue());

        add(joinShopPanel);
    }
    
    // Get Field
    public String getCheckinCode() {return this.checkinCode.getText();}
    // Get Button
    public JButton getCancelButton() {return this.cancelButton;}
    public JButton getEnterButton() {return this.enterButton;}
}
