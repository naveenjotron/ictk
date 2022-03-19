package frontSection.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.TestBase;

public class ContactUsTester  {
	
	 private WebDriver driver;
	 TestBase tb;
	 
	 @BeforeTest
		public void browserSetup() {
			tb = new TestBase();
			driver=tb.onSetup();
		}
	 
	 @AfterTest
		public void closeBrowser() {
			driver.close();
		}
		
	@Test
	public void testContactUs() throws InterruptedException {
		driver.get("http://64.227.132.109/LandingPage");
		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home-main[1]/app-header[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[6]/a[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#contact-form > div.card-body.pt-1 > div:nth-child(1) > div:nth-child(2) > input")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rahul123@gmail.com");
		driver.findElement(By.name("coursename")).sendKeys("Testing");
		driver.findElement(By.id("message")).sendKeys("Excellent");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#contact-form > div.card-body.pt-1 > div:nth-child(2) > div")).click();
	
	}

}
