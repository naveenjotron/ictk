package adminSection.Pages;
//NaveenJotron
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNG;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import projectBase.Scripts.ExcelUtility;

import projectBase.Scripts.AdminLoginBase;

public class SprAdminCourses {
	
	WebDriver driver;
	
	@BeforeTest	
		public void loginsetup() {
			AdminLoginBase ul;
			ul= new AdminLoginBase(driver);
			driver= ul.login();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
//			TestNG testNG = new TestNG();
//			testNG.setUseDefaultListeners(false);
			
	}
@Test(priority=1)
		public void courses() throws InterruptedException {
//		driver.getPageSource().contains("Dashboard");
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		
		WebElement coursebtn = driver.findElement(By.cssSelector("#myDiv > li:nth-child(2) > a:nth-child(1)"));
		wait.until(ExpectedConditions.elementToBeClickable(coursebtn));
		coursebtn.click();
//		driver.wait(2000);
//		Thread.sleep(2000);
			
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
	public void addCourse() throws IOException, InterruptedException {
	String CourseTitle = ExcelUtility.getCourseCellData(1, 0);
	String CourseShortName = ExcelUtility.getCourseCellData(1, 1);
	String CourseType = ExcelUtility.getCourseCellData(1, 2);
	String ShortDiscription = ExcelUtility.getCourseCellData(1, 3);
	String RegistrationStatus = ExcelUtility.getCourseCellData(1, 4);
	String CourseCategory = ExcelUtility.getCourseCellData(1, 5);
	String EntranceDate = ExcelUtility.getCourseCellData(1, 6);
	String AboutCourse = ExcelUtility.getCourseCellData(1, 7);
	String ComnceDate = ExcelUtility.getCourseCellData(1, 8);
	String OrienDate = ExcelUtility.getCourseCellData(1, 9);
	String LasDateReg = ExcelUtility.getCourseCellData(1, 10);
	String CourseFee = ExcelUtility.getCourseCellData(1, 11);
	String CourseRegFee = ExcelUtility.getCourseCellData(1, 12);
	String CourseDuration = ExcelUtility.getCourseCellData(1, 13);
	String ObjectivesAgenda = ExcelUtility.getCourseCellData(1, 14);
	String SampleEntQuestion = ExcelUtility.getCourseCellData(1, 15);
	String PlacementList = ExcelUtility.getCourseCellData(1, 16);
	String InternshipCertificate = ExcelUtility.getCourseCellData(1, 17);
	
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
	
//	driver.setFileDetector(new LocalFileDetector());
    File CourseImage = new File(System.getProperty("user.dir") +"/CommonFiles/" + "WWW_YTS_AG.jpg");
    Utils.log("file exists: " + CourseImage.exists());

    String CourseimagePath = CourseImage.getAbsolutePath();
    WebElement input = driver.findElement(By.cssSelector("div.input-box:nth-child(19) > input"));
    input.sendKeys(CourseimagePath);
    WebElement statusSlider=driver.findElement(By.cssSelector("#flexSwitchCheckDefault"));
    statusSlider.sendKeys(Keys.RETURN);
   Thread.sleep(1000);
	//code to click add course btn is not added
    
    WebElement addCourseBtn=driver.findElement(By.cssSelector(".btn.bg-gradient-primary"));
    addCourseBtn.sendKeys(Keys.RETURN);
    Thread.sleep(2000);
    WebElement OKbtn=driver.findElement(By.cssSelector("body > div.swal2-container.swal2-center.swal2-backdrop-show > "
    		+ "div > div.swal2-actions > button.swal2-confirm.swal2-styled"));
    OKbtn.sendKeys(Keys.RETURN);
}

    @Test(priority=4, enabled=true)
    public void deleteCourse() throws InterruptedException {
    	driver.findElement(By.xpath("/html/body/app-root/app-courses/div/main/div/div/div/div/div[2]/div/table/tbody[4]/tr/td[7]/i[3]")).click();
    	Thread.sleep(2000);
    	WebElement OKbtn=driver.findElement(By.xpath("/html/body/div[2]/div/div[6]/button[1]"));
    	OKbtn.sendKeys(Keys.RETURN);
    }
    


	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
//	    driver.quit();
	}

}
