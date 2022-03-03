package adminSection.Pages;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

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

import projectBase.Scripts.AdminLoginBase;

public class SuperAdminCourses {
	
	WebDriver driver;
	
	@BeforeTest	
		public void loginsetup() {
			AdminLoginBase ul;
			ul= new AdminLoginBase(driver);
			driver= ul.login();
			
			TestNG testNG = new TestNG();
			testNG.setUseDefaultListeners(false);
			
	}
@Test(priority=1)
		public void courses() throws InterruptedException {
//		Thread.sleep(8000);
		driver.getPageSource().contains("Dashboard");

		WebDriverWait wait=new WebDriverWait(driver, 10);
		
		WebElement coursebtn = driver.findElement(By.cssSelector("#myDiv > li:nth-child(2) > a:nth-child(1)"));
		wait.until(ExpectedConditions.elementToBeClickable(coursebtn));
		coursebtn.click();
		
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
	
		
	}
@Test(priority=3)
	public void addCourse() {
	driver.findElement(By.cssSelector("a.btn:nth-child(1)")).click();
	driver.findElement(By.cssSelector("div.input-box:nth-child(1) > input")).sendKeys("CourseTitle Test");
	driver.findElement(By.cssSelector("div.input-box:nth-child(2) > input")).sendKeys("CourseShortName");
	driver.findElement(By.cssSelector("div.input-box:nth-child(3) > input")).sendKeys("CourseType Test");
	driver.findElement(By.id("richtexteditor_2023600528_0_rte-edit-view")).sendKeys("ShortDiscription Test");
	
	Select RegStatDrop= new Select(driver.findElement(By.cssSelector("select.ng-valid")));
	RegStatDrop.selectByVisibleText("Registration Open");
	Select CorsCat= new Select(driver.findElement(By.cssSelector("select.ng-invalid")));
	CorsCat.selectByValue("Retail");
	
	WebElement EntranceDate = driver.findElement(By.cssSelector("div.input-box:nth-child(8) > input"));
	EntranceDate.sendKeys("02"+"03"+"2021");
	driver.findElement(By.id("richtexteditor_2023600528_1_rte-edit-view")).sendKeys("AboutCourse Test");
	WebElement ComnceDate = driver.findElement(By.cssSelector("div.input-box:nth-child(9) > input"));
	ComnceDate.sendKeys("03032021");
	WebElement OrienDate=driver.findElement(By.cssSelector("div.input-box:nth-child(10) > input"));
	OrienDate.sendKeys("04032021");
	WebElement LasDatReg=driver.findElement(By.cssSelector("div.input-box:nth-child(11) > input"));
	LasDatReg.sendKeys("05032021");
	driver.findElement(By.cssSelector("div.input-box:nth-child(12) > input")).sendKeys("5001");
	driver.findElement(By.cssSelector("div.input-box:nth-child(13) > input")).sendKeys("200");
	driver.findElement(By.cssSelector("div.input-box:nth-child(14) > input")).sendKeys("6 months");
	driver.findElement(By.id("richtexteditor_2023600528_2_rte-edit-view")).sendKeys("Objectivesor"
			+ "Agenda Test");
	driver.findElement(By.cssSelector("div.input-box:nth-child(17) > input")).sendKeys("Here,  There");
	
}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(15000);
	    driver.quit();
	}

}
