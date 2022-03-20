package adminSection.Pages;

import org.testng.annotations.Test;
import org.testng.internal.Utils;

import projectBase.Scripts.AdminLoginBase;
import projectBase.Scripts.ExcelUtility;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SprAdminAdminusers {
	WebDriver driver;
 
  @BeforeTest
	public void loginsetup() {
		AdminLoginBase ul;
		ul= new AdminLoginBase(driver);
		driver= ul.login();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		TestNG testNG = new TestNG();
//		testNG.setUseDefaultListeners(false);
		
}

  
  
  @Test(priority=1)
	public void courses() throws InterruptedException {
//	driver.getPageSource().contains("Dashboard");
	
	WebDriverWait wait=new WebDriverWait(driver, 10);
	
	
	WebElement adminbtn = driver.findElement(By.cssSelector("#myDiv > li:nth-child(13) > a"));
	wait.until(ExpectedConditions.elementToBeClickable(adminbtn));
	adminbtn.click();
//	driver.wait(2000);
//	Thread.sleep(2000);
		
	}
  
  
  @Test(priority=2)
	public void search() {
		String keyword="12";
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
	public void addAdmin() throws IOException, InterruptedException {
	String UserName = ExcelUtility.getAdminCellData(1, 0);
	String FirstName = ExcelUtility.getAdminCellData(1, 1);
	String LastName = ExcelUtility.getAdminCellData(1, 2);
	String Email = ExcelUtility.getAdminCellData(1, 3);
	String Designation = ExcelUtility.getAdminCellData(1, 4);
	String Password = ExcelUtility.getAdminCellData(1, 5);
	
	
	driver.findElement(By.cssSelector("a.btn:nth-child(1)")).click();
	driver.findElement(By.cssSelector("body > main > div > div > div > div > div > div > div > div.card-body > form > div.multisteps-form__panel.js-active > div > div > div.col-12.col-sm-8.mt-4.mt-sm-0.text-start > div:nth-child(1) > input")).sendKeys(UserName);
	driver.findElement(By.cssSelector("body > main > div > div > div > div > div > div > div > div.card-body > form > div.multisteps-form__panel.js-active > div > div > div.col-12.col-sm-8.mt-4.mt-sm-0.text-start > div:nth-child(2) > input")).sendKeys(FirstName);
	driver.findElement(By.cssSelector("body > main > div > div > div > div > div > div > div > div.card-body > form > div.multisteps-form__panel.js-active > div > div > div.col-12.col-sm-8.mt-4.mt-sm-0.text-start > div:nth-child(3) > input")).sendKeys(LastName);
	driver.findElement(By.cssSelector("body > main > div > div > div > div > div > div > div > div.card-body > form > div.multisteps-form__panel.js-active > div > div > div.col-12.col-sm-8.mt-4.mt-sm-0.text-start > div:nth-child(4) > input")).sendKeys(Email);
	driver.findElement(By.cssSelector("body > main > div > div > div > div > div > div > div > div.card-body > form > div.multisteps-form__panel.js-active > div > div > div.col-12.col-sm-8.mt-4.mt-sm-0.text-start > div:nth-child(5) > input")).sendKeys(Designation);
	driver.findElement(By.cssSelector("body > main > div > div > div > div > div > div > div > div.card-body > form > div.multisteps-form__panel.js-active > div > div > div.col-12.col-sm-8.mt-4.mt-sm-0.text-start > div:nth-child(6) > input")).sendKeys(Password);
	
	
//	driver.findElement(By.id("richtexteditor_2023600528_0_rte-edit-view")).sendKeys(Email);
	
	
  
	//code to click add course btn is not added
  driver.findElement(By.cssSelector("body > main > div > div > div > div > div > div > div > div.card-body > form > div:nth-child(2) > div.multisteps-form__panel > div.multisteps-form__content > div.button-row.d-flex.mt-4 > button")).click();
  Thread.sleep(2000);
  driver.findElement(By.cssSelector("body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
}
  
  
  @Test(priority=4)
  public void deleteadmin() {
  	
  	driver.findElement(By.cssSelector("body > app-root > app-admin-user > div > main > div > div > div > div > div.card.p-3 > div > table > tbody:nth-child(4) > tr > td.align-center.text-center.act-align > i.fas.fa-trash.ms-3.text-danger")).click();
  	driver.findElement(By.cssSelector("body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled.swal2-default-outline")).click();
  	driver.findElement(By.cssSelector("body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
  }

  
  
  
  @Test(priority=5)
  public void viewAdmin() {
  	
  	driver.findElement(By.cssSelector("body > app-root > app-admin-user > div > main > div > div > div > div > div.card.p-3 > div > table > tbody:nth-child(2) > tr > td.align-center.text-center.act-align > i.fas.fa-eye.text-info")).click();
  	
  } 
  

  @AfterTest
  public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}

}
