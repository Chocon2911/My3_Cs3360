package UI.Shop.Child;

import Util.GuiUtil;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ShopChangeCheckInUI extends JFrame
{
    //==========================================Variable==========================================
    // TextField
    private JTextField checkInTextField;

    // Button
    private JButton applyButton;
    private JButton cancelButton;

    //========================================Constructor=========================================
    public ShopChangeCheckInUI()
    {
        super("App2.Shop.Main.ChangeCheckInCode");
        GuiUtil guiUtil = GuiUtil.getInstance();

        // ===Frame===
        setSize(guiUtil.frameWidth, guiUtil.frameHeight);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ===Panel===
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // ===Title Label===
        JLabel titleLabel = new JLabel("Change CheckIn Code");
        guiUtil.setAlignmentCenter(titleLabel);
        titleLabel.setFont(new Font("Arial", Font.BOLD, guiUtil.bigTitleSize));


        
        // ===CheckIn Panel===
        // Panel
        JPanel checkInPanel = new JPanel();
        checkInPanel.setLayout(new BoxLayout(checkInPanel, BoxLayout.X_AXIS));
        guiUtil.setFixedSize(checkInPanel, guiUtil.panelTextFieldWidth, guiUtil.panelTextFieldHeight);

        // CheckIn Label
        JLabel checkInLabel = new JLabel("CheckIn Code: ");
        guiUtil.setAlignmentCenter(checkInLabel);
        guiUtil.setFixedSize(checkInLabel, guiUtil.smallLabelWidth, guiUtil.normalLabelHeight);

        // CheckIn TextField
        this.checkInTextField = new JTextField(guiUtil.textFieldAmount);

        // Display
        checkInPanel.add(Box.createHorizontalGlue());
        checkInPanel.add(checkInLabel);
        checkInPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        checkInPanel.add(this.checkInTextField);
        checkInPanel.add(Box.createHorizontalGlue());



        // ===Button Panel===
        // Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        guiUtil.setAlignmentCenter(buttonPanel);

        // Cancel Button
        this.cancelButton = guiUtil.createButton("Cancel", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.cancelButton);

        // Apply Button
        this.applyButton = guiUtil.createButton("Apply", guiUtil.smallButtonWidth, guiUtil.smallButtonHeight);
        guiUtil.setAlignmentCenter(this.applyButton);
        
        // Display
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(this.cancelButton);
        buttonPanel.add(Box.createHorizontalStrut(guiUtil.horizontalStrut));
        buttonPanel.add(this.applyButton);
        buttonPanel.add(Box.createHorizontalGlue());



        // ===Display===
        panel.add(Box.createVerticalGlue());
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(checkInPanel);
        panel.add(Box.createVerticalStrut(guiUtil.verticalStrut));
        panel.add(buttonPanel);
        panel.add(Box.createVerticalGlue());

        add(panel);
    }

    //============================================Get=============================================
    // TextField
    public String getCheckInCode() { return this.checkInTextField.getText(); }

    // Button
    public JButton getCancelButton() { return this.cancelButton; }
    public JButton getApplyButton() { return this.applyButton; }
}
