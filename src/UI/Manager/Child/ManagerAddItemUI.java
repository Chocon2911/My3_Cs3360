package UI.Manager.Child;

import Util.GuiUtil;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class ManagerAddItemUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField amountTextField;

    // Button
    private JButton addButton;
    private JButton cancelButton;

    // JList
    private JList<String> itemTypeStrJList;

    //========================================Constructor=========================================
    public ManagerAddItemUI()
    {
        super("Manager.AddItem");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(true);
        
        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // ===Title Label===
        JLabel titleLabel = new JLabel("Add Item");
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));
        guiUtil.setAlignmentCenter(titleLabel);

        // ===Name Panel===
        // Panel
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(namePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel nameLabel = new JLabel("Name:");
        guiUtil.setAlignmentCenter(nameLabel);
        guiUtil.setFixedSize(nameLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        this.nameTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        namePanel.add(Box.createHorizontalGlue());
        namePanel.add(nameLabel);
        namePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        namePanel.add(this.nameTextField);
        namePanel.add(Box.createHorizontalGlue());



        // ===Price Panel===
        // Panel
        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new BoxLayout(pricePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(pricePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel priceLabel = new JLabel("Price:");
        guiUtil.setAlignmentCenter(priceLabel);
        guiUtil.setFixedSize(priceLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        this.priceTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        pricePanel.add(Box.createHorizontalGlue());
        pricePanel.add(priceLabel);
        pricePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        pricePanel.add(this.priceTextField);
        pricePanel.add(Box.createHorizontalGlue());

        
        
        // ===ItemType Panel===
        // Panel
        JPanel itemTypePanel = new JPanel();
        itemTypePanel.setLayout(new BoxLayout(itemTypePanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(itemTypePanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight / 4 * 9);

        // Label
        JLabel itemTypeLabel = new JLabel("ItemType:");
        guiUtil.setAlignmentCenter(itemTypeLabel);
        guiUtil.setFixedSize(itemTypeLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // JList
        String[] itemTypesStr = {"Food", "Drink", "Souvenir"};
        this.itemTypeStrJList = new JList<>(itemTypesStr);
        this.itemTypeStrJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Set the selection mode to single selection
        this.itemTypeStrJList.setSelectedIndex(0);
        guiUtil.setFixedSize(this.itemTypeStrJList, 178, guiUtil.smallLabelHeight * 3);
        this.itemTypeStrJList.setBorder(BorderFactory.createLineBorder(Color.gray));

        // Display
        itemTypePanel.add(Box.createHorizontalGlue());
        itemTypePanel.add(itemTypeLabel);
        itemTypePanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        itemTypePanel.add(this.itemTypeStrJList);
        itemTypePanel.add(Box.createHorizontalGlue());



        // ===Amount Panel===
        // Panel
        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new BoxLayout(amountPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(amountPanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // Label
        JLabel amountLabel = new JLabel("Amount:");
        guiUtil.setAlignmentCenter(amountLabel);
        guiUtil.setFixedSize(amountLabel, guiUtil.smallLabelWidth, guiUtil.smallLabelHeight);

        // TextField
        this.amountTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        amountPanel.add(Box.createHorizontalGlue());
        amountPanel.add(amountLabel);
        amountPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        amountPanel.add(this.amountTextField);
        amountPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.cancelButton);

        // Add Button
        this.addButton = guiUtil.createButton("Add", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.addButton);

        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.addButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(namePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(pricePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(itemTypePanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(amountPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    // TextField
    public String getNameTextField() { return this.nameTextField.getText(); }
    public String getPriceTextField() { return this.priceTextField.getText(); }
    public String getItemType() { return this.itemTypeStrJList.getSelectedValue(); }
    public String getAmountTextField() { return this.amountTextField.getText(); }

    // Button
    public JButton getAddButton() { return this.addButton; }
    public JButton getCancelButton() { return this.cancelButton; }
}
