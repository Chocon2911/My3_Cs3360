package UI.App2;

import UI.App2.Child.*;

public class App2UI
{
    //==========================================Variable==========================================
    private App2MainUI mainUI;
    private App2LoginUI loginUI;
    private App2SignUpUI signUpUI;
    
    //========================================Constructor=========================================
    public App2UI()
    {
        this.mainUI = new App2MainUI();
        this.loginUI = new App2LoginUI();
        this.signUpUI = new App2SignUpUI();
    }

    //============================================Get=============================================
    public App2MainUI getMainUI() { return mainUI; }
    public App2LoginUI getLoginUI() { return loginUI; }
    public App2SignUpUI getSignUpUI() { return signUpUI; }
}
