package scripts;

import org.testng.annotations.Test;

import commands.ActionDriver;
import reuse.businessfns;
import zecomframework.zecomframework.LoginPage;

public class TC2 {
	 @Test
	  public void testLogin() throws Exception {
		  
		 businessfns bsf=new businessfns();
		 bsf.Login();

	  
	  }
	 

}
