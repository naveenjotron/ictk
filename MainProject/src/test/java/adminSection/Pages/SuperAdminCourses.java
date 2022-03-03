package adminSection.Pages;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.AdminLoginBase;

public class SuperAdminCourses {
	
	WebDriver driver;
	@BeforeTest	
		public void login() throws InterruptedException {
			
			AdminLoginBase ul;
			ul= new AdminLoginBase(driver);
			driver= ul.login();
			
	}
@Test(priority=1)
		public void courses() throws InterruptedException {
		Thread.sleep(8000);
		driver.getPageSource().contains("Dashboard");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#myDiv > li:nth-child(2) > a:nth-child(1)")).click();
				
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
	driver.findElement(By.cssSelector("div.input-box:nth-child(1) > input")).sendKeys("1");
	driver.findElement(By.cssSelector("div.input-box:nth-child(2) > input")).sendKeys("2");
	driver.findElement(By.cssSelector("div.input-box:nth-child(3) > input")).sendKeys("3");
	driver.findElement(By.id("richtexteditor_2023600528_0_rte-edit-view")).sendKeys("abcd123");
	
	Select RegStatDrop= new Select(driver.findElement(By.cssSelector("select.ng-valid")));
	RegStatDrop.selectByVisibleText("Registration Open");
	Select CorsCat= new Select(driver.findElement(By.cssSelector("select.ng-invalid")));
	CorsCat.selectByValue("Retail");
	
	driver.findElement(By.id("richtexteditor_2023600528_0_rte-edit-view")).sendKeys("abcd123");
	WebElement EntranceDate = driver.findElement(By.cssSelector("div.input-box:nth-child(8) > input"));
	EntranceDate.sendKeys("02032021");
}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(15000);
	    driver.quit();
	}

}
