package adminSection.Pages;

import org.testng.annotations.Test;
import org.testng.internal.Utils;

import projectBase.Scripts.AdminLoginBase;
import projectBase.Scripts.ExcelUtility;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SprAdminEvents {
 WebDriver driver;
  @BeforeTest
  public void loginsetup() {
			AdminLoginBase ul;
			ul= new AdminLoginBase(driver);
			driver= ul.login();
  }

	  
	  
	  @Test(priority=1)
	  public void f() throws InterruptedException {
//		  driver.getPageSource().contains("Dashboard");
			
			
			
			WebElement eventsbtn = driver.findElement(By.cssSelector("#myDiv > li:nth-child(11) > a"));
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
					+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", eventsbtn);
				
		  
		  
	  }
	  
	  @Test(priority=2)
	  public void search() {
			String keyword="Salesforce Developerr";
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
		String EventName = ExcelUtility.getEventsCellData(1, 0);
		String CourseName = ExcelUtility.getEventsCellData(1, 1);
		String CourseType = ExcelUtility.getEventsCellData(1, 2);
		String About = ExcelUtility.getEventsCellData(1, 3);
		String EventOverview = ExcelUtility.getEventsCellData(1, 4);
		String EventAgenda = ExcelUtility.getEventsCellData(1, 5);
		String EventTraining = ExcelUtility.getEventsCellData(1, 6);
		String EventFee= ExcelUtility.getEventsCellData(1, 7);
		String LastDate= ExcelUtility.getEventsCellData(1, 8);
		String EventObjective= ExcelUtility.getEventsCellData(1, 9);
		String StartDate= ExcelUtility.getEventsCellData(1, 10);
		String EndDate= ExcelUtility.getEventsCellData(1, 11);
		String RegStatus= ExcelUtility.getEventsCellData(1, 12);
		
		
		driver.findElement(By.cssSelector("body > app-root > app-events > div > main > div > div > div > div > div.card-header.pb-0 > div > div.ms-auto.my-auto.mt-lg-0.mt-4 > div > a")).click();
		driver.findElement(By.cssSelector("body > main > div > div > div.content > form > div > div:nth-child(1) > input")).sendKeys(EventName);
		driver.findElement(By.cssSelector("body > main > div > div > div.content > form > div > div:nth-child(2) > input")).sendKeys(CourseName);
		driver.findElement(By.cssSelector("body > main > div > div > div.content > form > div > div:nth-child(3) > input")).sendKeys(CourseType);
		driver.findElement(By.id("richtexteditor_1057282398_0_rte-edit-view")).sendKeys(About);
		driver.findElement(By.id("richtexteditor_1057282398_1_rte-edit-view")).sendKeys(EventOverview);
		driver.findElement(By.id("richtexteditor_1057282398_2_rte-edit-view")).sendKeys(EventAgenda);
		driver.findElement(By.id("richtexteditor_1057282398_3_rte-edit-view")).sendKeys(EventTraining);
		driver.findElement(By.cssSelector("body > main > div > div > div.content > form > div > div:nth-child(8) > input")).sendKeys(EventFee);
		
//		Select RegStatDrop= new Select(driver.findElement(By.cssSelector("select.ng-valid")));
//		RegStatDrop.selectByVisibleText(RegistrationStatus);
	
		
		WebElement EntrncDate = driver.findElement(By.cssSelector("body > main > div > div > div.content > form > div > div:nth-child(9) > input"));
		EntrncDate.sendKeys(LastDate);
		
		driver.findElement(By.id("richtexteditor_1057282398_4_rte-edit-view")).sendKeys(EventObjective);
		

		WebElement ComnceDat = driver.findElement(By.cssSelector("body > main > div > div > div.content > form > div > div:nth-child(11) > input"));
		ComnceDat.sendKeys(StartDate);
		WebElement OrienDat=driver.findElement(By.cssSelector("body > main > div > div > div.content > form > div > div:nth-child(12) > input"));
		OrienDat.sendKeys(EndDate);
		
		
		Select CorsCat= new Select(driver.findElement(By.cssSelector("select.ng-invalid")));
		CorsCat.selectByValue(RegStatus);
		
		

	  
	    
		
	    driver.findElement(By.cssSelector("body > main > div > div > div.content > form > div > div.button > button")).click();
	    
	}
	  
	  
	  
	  
  @AfterTest
  public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}

}
