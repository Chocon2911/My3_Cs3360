package UI.Staff;

import Controller.Child.StaffCtrl;
import UI.Staff.Child.*;

public class StaffUI 
{
    private final StaffCtrl ctrl;
    
    public StaffUI(String id)
    {
        this.ctrl = new StaffCtrl(id);
    }

    // Variable
    private StaffPreMainUI preMainStaffUI;
    private StaffCheckinCode checkinStaffUI;
    private StaffMainUI mainStaffUI;
    private StaffInfoUI infoUI;
    private StaffDepositCustomerUI depositUI;
    private StaffCustomerRequestUI requestUI;

    // Constructor
    public StaffUI(){
        this.ctrl = null;
        this.preMainStaffUI = new StaffPreMainUI();
        this.checkinStaffUI = new StaffCheckinCode();
        this.mainStaffUI = new StaffMainUI();
        this.infoUI = new StaffInfoUI();
        this.depositUI = new StaffDepositCustomerUI();
        this.requestUI = new StaffCustomerRequestUI();
    }

    // Get
    public StaffPreMainUI getPreMainStaffUI() {return this.preMainStaffUI;}
    public StaffCheckinCode getStaffCheckinUI(){return this.checkinStaffUI;}
    public StaffMainUI getStaffMainUI() { return this.mainStaffUI;}
    public StaffInfoUI getInforUI() {return this.infoUI;}
    public StaffDepositCustomerUI getDepositUI() {return this.depositUI;}
    public StaffCustomerRequestUI getRequestUI() {return this.requestUI;}

}
