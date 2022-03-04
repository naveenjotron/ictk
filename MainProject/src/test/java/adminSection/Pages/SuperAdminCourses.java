package adminSection.Pages;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.ExcelUtility;

import projectBase.Scripts.AdminLoginBase;

public class SuperAdminCourses {
	
	WebDriver driver;
	
	@BeforeTest	
		public void loginsetup() {
			AdminLoginBase ul;
			ul= new AdminLoginBase(driver);
			driver= ul.login();
			
//			TestNG testNG = new TestNG();
//			testNG.setUseDefaultListeners(false);
			
	}
@Test(priority=1)
		public void courses() throws InterruptedException {
		driver.getPageSource().contains("Dashboard");

		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement coursebtn = driver.findElement(By.cssSelector("#myDiv > li:nth-child(2) > a:nth-child(1)"));
		wait.until(ExpectedConditions.elementToBeClickable(coursebtn));
		coursebtn.click();
		Thread.sleep(2000);
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		}
@Test(priority=2)
	public void search() {
		String keyword="SOFTWARE TESTING";
		driver.findElement(By.id("listSearch")).sendKeys(keyword);
		String searchResult=driver.findElement(By.cssSelector("div.p-3")).getText();
		
		if(searchResult.contains(keyword))
          	System.out.println("The search result contains the keyword --- "+searchResult);
    	else
          	System.out.println("The search result doesn't contains the keyword --- "+searchResult);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
@Test(priority=3)
	public void addCourse() throws IOException {
	String CourseTitle = ExcelUtility.getCellData(1, 0);
	String CourseShortName = ExcelUtility.getCellData(1, 1);
	String CourseType = ExcelUtility.getCellData(1, 2);
	String ShortDiscription = ExcelUtility.getCellData(1, 3);
	String RegistrationStatus = ExcelUtility.getCellData(1, 4);
	String CourseCategory = ExcelUtility.getCellData(1, 5);
	String EntranceDate = ExcelUtility.getCellData(1, 6);
	String AboutCourse = ExcelUtility.getCellData(1, 7);
	String ComnceDate = ExcelUtility.getCellData(1, 8);
	String OrienDate = ExcelUtility.getCellData(1, 9);
	String LasDateReg = ExcelUtility.getCellData(1, 10);
	String CourseFee = ExcelUtility.getCellData(1, 11);
	String CourseRegFee = ExcelUtility.getCellData(1, 12);
	String CourseDuration = ExcelUtility.getCellData(1, 13);
	String ObjectivesAgenda = ExcelUtility.getCellData(1, 14);
	String SampleEntQuestion = ExcelUtility.getCellData(1, 15);
	String PlacementList = ExcelUtility.getCellData(1, 16);
	String InternshipCertificate = ExcelUtility.getCellData(1, 17);
	
	driver.findElement(By.cssSelector("a.btn:nth-child(1)")).click();
	driver.findElement(By.cssSelector("div.input-box:nth-child(1) > input")).sendKeys(CourseTitle);
	driver.findElement(By.cssSelector("div.input-box:nth-child(2) > input")).sendKeys(CourseShortName);
	driver.findElement(By.cssSelector("div.input-box:nth-child(3) > input")).sendKeys(CourseType);
	driver.findElement(By.id("richtexteditor_2023600528_0_rte-edit-view")).sendKeys(ShortDiscription);
	
	Select RegStatDrop= new Select(driver.findElement(By.cssSelector("select.ng-valid")));
	RegStatDrop.selectByVisibleText(RegistrationStatus);
	Select CorsCat= new Select(driver.findElement(By.cssSelector("select.ng-invalid")));
	CorsCat.selectByValue(CourseCategory);
	
	WebElement EntrncDate = driver.findElement(By.cssSelector("div.input-box:nth-child(8) > input"));
	EntrncDate.sendKeys(EntranceDate);
	driver.findElement(By.id("richtexteditor_2023600528_1_rte-edit-view")).sendKeys(AboutCourse);
	WebElement ComnceDat = driver.findElement(By.cssSelector("div.input-box:nth-child(9) > input"));
	ComnceDat.sendKeys(ComnceDate);
	WebElement OrienDat=driver.findElement(By.cssSelector("div.input-box:nth-child(10) > input"));
	OrienDat.sendKeys(OrienDate);
	WebElement LasDatReg=driver.findElement(By.cssSelector("div.input-box:nth-child(11) > input"));
	LasDatReg.sendKeys(LasDateReg);
	driver.findElement(By.cssSelector("div.input-box:nth-child(12) > input")).sendKeys(CourseFee);
	driver.findElement(By.cssSelector("div.input-box:nth-child(13) > input")).sendKeys(CourseRegFee);
	driver.findElement(By.cssSelector("div.input-box:nth-child(14) > input")).sendKeys(CourseDuration);
	driver.findElement(By.id("richtexteditor_2023600528_2_rte-edit-view")).sendKeys(ObjectivesAgenda);
	driver.findElement(By.cssSelector("div.input-box:nth-child(16) > input")).sendKeys(SampleEntQuestion);
	driver.findElement(By.cssSelector("div.input-box:nth-child(17) > input")).sendKeys(PlacementList);
	driver.findElement(By.cssSelector("div.input-box:nth-child(18) > input")).sendKeys(InternshipCertificate);
	
	WebElement CourseImage=driver.findElement(By.cssSelector("div.input-box:nth-child(19) > input"));
	FileInputStream CoursePhoto = new FileInputStream(System.getProperty("user.dir")
			+"/CommonFiles/WWW_YTS_AG.jpg");
	CourseImage.sendKeys("/CommonFiles/WWW_YTS_AG.jpg");
	
}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(15000);
	    driver.quit();
	}

}
