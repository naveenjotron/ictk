package com.ictacademyofficial.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.ictacademyofficial.scripts.UserLogin;

public class usrAdminCourses {
	
	WebDriver driver;
@BeforeTest	
	public void login() throws InterruptedException {
		
		UserLogin ul;
		ul= new UserLogin(driver);
		driver= ul.login();
		
}
@Test	
	public void courses() throws InterruptedException {
	Thread.sleep(10000);
	driver.getPageSource().contains("Dashboard");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("/html/body/app-root/app-dashboard/body/aside/app-sidenavbar"
			+ "/aside/div[2]/ul/div/ul/li[2]/a")).click();
		
	
	}

}
