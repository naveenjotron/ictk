package adminSection.Pages;

import org.testng.annotations.Test;

import projectBase.Scripts.UserLoginBase;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class userAdminStaffs {
	WebDriver driver;

	  @BeforeTest
	  public void login() throws InterruptedException {
			
			UserLoginBase ul;
			ul= new UserLoginBase(driver);
			driver= ul.login();
	  }
	  
	  
	  @Test	
		public void courses() throws InterruptedException {
		Thread.sleep(4000);
		driver.getPageSource().contains("Dashboard");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath("/html/body/app-root/app-dashboard/body/aside/app-sidenavbar"
//				+ "/aside/div[2]/ul/div/ul/li[2]/a")).click();
		driver.findElement(By.cssSelector("#myDiv > li:nth-child(12) > a")).click();
			
		
		}

	  @AfterTest
	  public void quitBrowser() throws IOException, InterruptedException {
			Thread.sleep(10000);
		    driver.quit();
		}
}
