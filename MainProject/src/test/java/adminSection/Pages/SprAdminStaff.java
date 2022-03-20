package adminSection.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import projectBase.Scripts.AdminLoginBase;
import projectBase.Scripts.ExcelUtility;

public class SprAdminStaff {
	WebDriver driver;
	

	@BeforeTest	
		public void loginsetup() {
			AdminLoginBase ul;
			ul= new AdminLoginBase(driver);
			driver= ul.login();
	 }


	@Test(priority=1)
			public void courses() throws InterruptedException {


		
		WebElement staffbtn = driver.findElement(By.cssSelector("li.nav-item:nth-child(12) > a:nth-child(1)"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", staffbtn);
			
	  
	  
  }
	  
  
		
		
		
				
	

	@Test(priority=2)
	public void search() {
		String keyword="Riji";
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
	public void Adminstaff() throws IOException {
		
		
//		WebElement Addnewstaff = driver.findElement(By.xpath("a.btn:nth-child(1)"));
//		wait.until(ExpectedConditions.elementToBeClickable(Addnewstaff));
//		Addnewstaff.click();
		
		
		
		WebElement Addnewstaff = driver.findElement(By.cssSelector("a.btn:nth-child(1)"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", Addnewstaff);
			
	  
		
		String StaffName = ExcelUtility.getStaffCellData(1, 0);
		String Designation = ExcelUtility.getStaffCellData(1, 1);
		String About = ExcelUtility.getStaffCellData(1, 2);
		
		
		
		driver.findElement(By.cssSelector("div.input-group:nth-child(2) > input:nth-child(1)")).sendKeys(StaffName);
		driver.findElement(By.cssSelector(".form-select")).sendKeys(Designation);
		driver.findElement(By.cssSelector("textarea.form-control")).sendKeys(About);
		
		Select CorsCat= new Select(driver.findElement(By.cssSelector(".form-select")));
		CorsCat.selectByValue(Designation);

//image
		
		
//		driver.setFileDetector(new LocalFileDetector());
//	    File AdminImage = new File(System.getProperty("user.dir") +"/CommonFiles/" + "Admin.jpg");
//	    Utils.log("file exists: " + AdminImage.exists());
//
//	    String CourseimagePath = AdminImage.getAbsolutePath();
//	    WebElement input = driver.findElement(By.cssSelector("input.ng-touched"));
//	    input.sendKeys(CourseimagePath);
//		
//		
//	 driver.findElement(By.cssSelector("button.ms-auto")).click();
//	}
		
		
		
		
		File AdminImage = new File(System.getProperty("user.dir") +"/CommonFiles/" + "Admin.jpg");
	    Utils.log("file exists: " + AdminImage.exists());

	    String AddimagePath = AdminImage.getAbsolutePath();
	    WebElement input = driver.findElement(By.cssSelector("div.input-group:nth-child(7) > input:nth-child(1)"));
	    input.sendKeys(AddimagePath);
	    
	    driver.findElement(By.cssSelector("button.ms-auto")).click();
	    
	    driver.findElement(By.cssSelector("body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
	    	
	
	}
		
		
		
		
		
	@Test(priority=4)
	  public void deletestaff() throws InterruptedException {
		  
//		  driver.findElement(By.cssSelector(".table > tbody:nth-child(20) > tr:nth-child(1) > td:nth-child(7) > i:nth-child(3)")).click();
		
			
			driver.findElement(By.cssSelector(".table > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(7) > i:nth-child(3)")).click();
			driver.findElement(By.cssSelector(".swal2-confirm")).click();
			
			Thread.sleep(5000);
			driver.findElement(By.cssSelector(".swal2-confirm")).click();
			Thread.sleep(5000);
			
		  
		  
	  }
//	 View
	@Test(priority=5)
	  public void viewstaff() throws InterruptedException {
		  
		
			
			driver.findElement(By.cssSelector(".table > tbody:nth-child(4) > tr:nth-child(1) > td:nth-child(7) > i:nth-child(1)")).click();
		
			
			Thread.sleep(5000);
			
		  
		  
	  }
	
	
//	@Test(priority=6)
//	public void UpdateStaff() throws IOException {
//		
//		
////		WebElement UpdateStaff = driver.findElement(By.xpath("a.btn:nth-child(1)"));
////		wait.until(ExpectedConditions.elementToBeClickable(UpdateStaff));
////		Addnewstaff.click();
//		
//		
//		
//		WebElement UpdateStaff = driver.findElement(By.cssSelector(".table > tbody:nth-child(20) > tr:nth-child(1) > td:nth-child(7) > i:nth-child(2)"));
//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
//	js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
//				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", UpdateStaff);
//			
//	  
//		
//		String StaffName = ExcelUtility.getStaffCellData(2, 0);
//		String Designation = ExcelUtility.getStaffCellData(2, 1);
//		String About = ExcelUtility.getStaffCellData(2, 2);
//		
//		
//		
//		driver.findElement(By.cssSelector("div.input-group:nth-child(2) > input:nth-child(1)")).sendKeys(StaffName);
//		driver.findElement(By.cssSelector(".form-select")).sendKeys(Designation);
//		driver.findElement(By.cssSelector("textarea.form-control")).sendKeys(About);
//		
//		Select CorsCat= new Select(driver.findElement(By.cssSelector(".form-select")));
//		CorsCat.selectByValue(Designation);
//		
//		
//	    
//		File UpdateImage = new File(System.getProperty("user.dir") +"/CommonFiles/" + "UpdateStaff.png");
//	    Utils.log("file exists: " + UpdateImage.exists());
//
//	    String UpadateimagePath = UpdateImage.getAbsolutePath();
//	    WebElement input = driver.findElement(By.cssSelector("input.multisteps-form__input:nth-child(2)"));
//	    input.sendKeys(UpadateimagePath);
//	    
//	    driver.findElement(By.cssSelector("#imm > div.button-row.d-flex.mt-4 > button")).click();
//	    
//	    driver.findElement(By.cssSelector("body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
//	    
//	    
//	    
//	    
//	    
//	    
//	    driver.findElement(By.cssSelector("button.ms-auto")).click();
//	    
//	    driver.findElement(By.cssSelector("body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
//	    	
//	    driver.findElement(By.cssSelector("li.nav-item:nth-child(12) > a:nth-child(1)")).click();
//
//				
//	
//
//	}
	



//
	@AfterTest
	public void closeBrowser() {
			driver.close();
		}
	}
