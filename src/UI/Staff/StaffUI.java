package UI.Staff;

import Controller.Child.StaffCtrl;

public class StaffUI 
{
    private final StaffCtrl ctrl;
    
    public StaffUI()
    {
        this.ctrl = null;
    }

    public StaffUI(String id)
    {
        this.ctrl = new StaffCtrl(id);
    }
}
