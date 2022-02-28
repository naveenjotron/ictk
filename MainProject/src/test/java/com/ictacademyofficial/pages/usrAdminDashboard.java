package com.ictacademyofficial.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.ITestResult;


import com.ictacademyofficial.scripts.*;



public class usrAdminDashboard {

	WebDriver driver;
	UserLogin ul;
	ScreenshotBase ssb;
@BeforeTest	
public void loginsetup() {
//	System.setProperty("webdriver.chrome.driver", "D:\\SoftwareTestingICTAK\\Selenium\\CommonFiles\\chromedriver.exe");
//	FirefoxOptions options = new FirefoxOptions();  
//	options.setHeadless(false);
	
//	ChromeOptions options = new ChromeOptions();
//	options.addArguments("--start-maximized");
//	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//	capabilities.setCapability("pageLoadStrategy", "none");
//	WebDriver driver = new ChromeDriver(capabilities);
//	driver.get("http://64.227.132.109/");
//	driver.manage().window().maximize();
		
		
		ul= new UserLogin(driver);
		driver=ul.login();
		
		
}
@Test(priority=1)
public void Dashboard() throws InterruptedException{
//	driver.getPageSource().contains("Dashboard");
	WebDriverWait wait=new WebDriverWait(driver, 20);
	WebElement dashB;
	dashB= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".font-weight-bolder")));
	
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(3000);
}
@Test(priority=2)
public void addTask() {
	WebElement addTaskText = driver.findElement(By.cssSelector("input.form-control:nth-child(1)"));
	addTaskText.click();
//	addTaskText.sendKeys(Keys.SEMICOLON);
}
	
	
	
@Test(priority=3)
public void pieChart() {	
	String expectedBanner ="ICT LIVE STATUS";
    WebElement errorBanner =driver.findElement(By.cssSelector("body > main > div.container.pt-3.ms-6 >"
    		+ " div > div:nth-child(1) > h2"));
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    String actualErrorBanner = errorBanner.getText();
    Assert.assertEquals(expectedBanner,actualErrorBanner);
}


@AfterMethod
public void screenshot(ITestResult iTestResult) throws IOException {
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
ssb=new ScreenshotBase(driver);
ssb.tearDown(iTestResult);

}
@AfterTest
public void quitBrowser() throws IOException, InterruptedException {
	Thread.sleep(8000);
    driver.quit();
}

}
