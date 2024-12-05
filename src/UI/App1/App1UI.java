
package UI.App1;

import UI.App1.Child.App1LoginUI;
import UI.App1.Child.App1MainUI;
import UI.App1.Child.App1SignUpUI;

public class App1UI
{
    //==========================================Variable==========================================
    private App1MainUI mainUI;
    private App1LoginUI loginUI;
    private App1SignUpUI signUpUI;

    //========================================Constructor=========================================
    public App1UI()
    {
        this.mainUI = new App1MainUI();
        this.loginUI = new App1LoginUI();
        this.signUpUI = new App1SignUpUI();
    }

    //============================================Get=============================================
    public App1MainUI getMainUI() { return mainUI; }
    public App1LoginUI getLoginUI() { return loginUI; }
    public App1SignUpUI getSignUpUI() { return signUpUI; }
}   
