package commands;

import config.StartBrowser;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

public class ActionDriver {
	WebDriver driver;

	public ActionDriver() {
		driver = StartBrowser.driver;
	
	}

	public void navigateToApp(String URL) {

		
		
		
		try {
		driver.get(URL);
		StartBrowser.childTest.pass("Succefully navigated to this url"+URL);
		}
		catch(Exception e) {
			
			StartBrowser.childTest.pass("FAILED TO navigate to this url"+URL);

			
		}
		
		
		
		
	}

	public void click(By Locator) throws Exception {
		
		
		
		try {
			driver.findElement(Locator).click();
			StartBrowser.childTest.pass("Succefully clicked to this ");
			}
			catch(Exception e) {
				
				StartBrowser.childTest.pass("FAILED TO navigate to this ",MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
				StartBrowser.childTest.info(e);
			}
		

	}
	public void type(By Locator,String text) throws Exception {
			
		try {
			driver.findElement(Locator).sendKeys(text);	
			StartBrowser.childTest.pass("Succefully clicked to this ");
			}
			catch(Exception e) {
				
				StartBrowser.childTest.pass("FAILED TO navigate to this ",MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
				StartBrowser.childTest.info(e);
			}
		
	}
	
	public String screenShot() {
		
		return((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
}
