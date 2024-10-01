package scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import commands.ActionDriver;
import config.StartBrowser;
import zecomframework.zecomframework.LoginPage;

public class TC01 extends StartBrowser {
  @Test
  public void Login() throws Exception {
	  
	  ActionDriver adriver= new ActionDriver();
	  adriver.navigateToApp("https://www.demoblaze.com/");
	  adriver.click(LoginPage.homepageloginbtn);
	  adriver.type(LoginPage.txtusername, "kkpp");
	  adriver.type(LoginPage.txtpassword , "kkpp");
	  adriver.click(LoginPage.btnlogin);

  
  }
}
