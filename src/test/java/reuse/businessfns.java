/*
 * package reuse;
 * 
 * import org.openqa.selenium.WebDriver;
 * 
 * 
 * import commands.ActionDriver; import config.StartBrowser; import
 * zecomframework.zecomframework.LoginPage;
 * 
 * public class businessfns {
 * 
 * WebDriver driver; ActionDriver adriver;
 * 
 * public businessfns() { driver=StartBrowser.driver; adriver=new
 * ActionDriver();
 * 
 * } public void Login() throws Exception {
 * StartBrowser.childTest=StartBrowser.parentTest.
 * createNode("Login to Application"); ActionDriver adriver= new ActionDriver();
 * adriver.navigateToApp("https://www.demoblaze.com/");
 * adriver.click(LoginPage.homepageloginbtn,"Homepageloginbutton");
 * adriver.type(LoginPage.txtusername, "kkpp","username");
 * adriver.type(LoginPage.txtpassword , "kkpp","password");
 * adriver.click(LoginPage.btnlogin,"loginbutton");
 * 
 * 
 * }
 * 
 * }
 */

package reuse;

import org.openqa.selenium.WebDriver;

import commands.ActionDriver;
import config.StartBrowser;
import zecomframework.zecomframework.LoginPage;

public class businessfns {

    private WebDriver driver;
    private ActionDriver adriver;

    public businessfns() {
        driver = StartBrowser.driver;
        adriver = new ActionDriver(); // Initialize here if not using dependency injection
    }

    public void Login() throws Exception {
        StartBrowser.childTest = StartBrowser.parentTest.createNode("Login to Application");

        navigateToApp("https://www.demoblaze.com/");
        login("kkpp", "kkpp");

        // Handle potential exceptions based on your needs
    }

    private void navigateToApp(String url) {
        adriver.navigateToApp(url);
    }

    private void login(String username, String password) throws Exception {
        adriver.click(LoginPage.homepageloginbtn);
        adriver.type(LoginPage.txtusername, username);
        adriver.type(LoginPage.txtpassword, password);
        adriver.click(LoginPage.btnlogin);
    }
}
