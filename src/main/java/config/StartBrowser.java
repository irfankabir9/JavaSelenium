package config;

import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class StartBrowser {

	public static WebDriver driver;
	// add variables related to html report or extent reports
	ExtentSparkReporter htmlreporter;

	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;

	/*
	 * @Test public void launch() {
	 * 
	 * driver.get("https://www.demoblaze.com/");
	 * 
	 * }
	 */

	@BeforeTest
	public void report() {
		htmlreporter = new ExtentSparkReporter("Reports/MyResults.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
	}

	@BeforeMethod
	public void method(Method method) {

		parentTest = extent.createTest(method.getName());

	}

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		extent.flush();

	}

}
