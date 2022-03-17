package adminSection.Pages;

import java.io.IOException;
import java.rmi.AccessException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.UserLoginBase;

public class useradminPartnership {

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
		
	driver.findElement(By.cssSelector("li.nav-item:nth-child(7) > a")).click();

	}
	@Test(priority=2)
	public void search() {
		String keyword="Nayana";
		driver.findElement(By.xpath("/html/body/app-root/app-partnership/body/main/nav/div/div[2]/div/div/input")).sendKeys(keyword);
		String searchResult=driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2) > p")).getText();

		if(searchResult.contains(keyword))
	      	System.out.println("The search result contains the keyword --- "+searchResult);
		else
	      	System.out.println("The search result doesn't contains the keyword --- "+searchResult);
	}
	@Test(priority=3)
	public void fileDownload() throws AccessException, InterruptedException {
		
		driver.get("http://64.227.132.109/adminpage/partnership");
		Thread.sleep(2000);
		WebElement btnDownload = driver.findElement(By.xpath("/html/body/app-root/app-partnership/body/main/div/div/div/div/div[1]/div/div[2]/div/button"));
		btnDownload.click();
		
		Thread.sleep(7000);
		
	}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}

	}
