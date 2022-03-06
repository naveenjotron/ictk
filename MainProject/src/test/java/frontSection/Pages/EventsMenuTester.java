package frontSection.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.TestBase;

public class EventsMenuTester  {
	
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
		public void testEvents() {
			driver.get("http://64.227.132.109/LandingPage");
			driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-home-main[1]/app-header[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[5]/a[1]")).click();
;		}
	

	@Test
	public void testrobotic() throws InterruptedException {
		driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(5) > ul > div.d-none.d-lg-block > ul > li:nth-child(2) > a > h6")).click();
		driver.findElement(By.cssSelector("body > header > div.page-header.min-vh-70 > div.container > div > div > button")).click();
		Thread.sleep(2000);;
		driver.findElement(By.name("name")).sendKeys("Priya");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div:nth-child(2) > input")).sendKeys("priya@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div:nth-child(3) > input")).sendKeys("456782987");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div.text-center")).click();
				
	}

@Test
	public void testsalesforce() throws InterruptedException {
		driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(5) > ul > div.d-none.d-lg-block > ul > li:nth-child(1) > a")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#v-pills-home-tab > i")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#v-pills-home-tab")).click();
		Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#v-pills-profile-tab")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#v-pills-settings-tab")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.cssSelector("#v-pills-download-tab")).click();	
				
	}


}
