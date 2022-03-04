package frontSection.Pages;
import java.util.ArrayList;
import java.util.Set;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.TestBase;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
		private WebDriver driver;
		TestBase tb;

//		@BeforeClass
//		public void startBrowser() {
//			driver=new ChromeDriver();
//			driver.get("http://64.227.132.109/LandingPage/about");
//			driver.manage().window().maximize();
//		}
		@BeforeTest
		public void browserSetup() {
			tb = new TestBase();
			driver=tb.onSetup();
		}
		
		@AfterTest
		public void closeBrowser() throws InterruptedException {
			Thread.sleep(5000);
			driver.quit();
		}
		

	@Test
		public void _testKnowMoreButton() throws InterruptedException {
		browserSetup();
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,5450)", "");
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.className("fa-play")));
			driver.findElement(By.className("fa-play")).click();
			
			
	}

		@Test
		public void testCareersButton() throws InterruptedException {
			driver.get("http://64.227.132.109/LandingPage/about");
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,7500)", "");
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CAREERS")));
			driver.findElement(By.linkText("CAREERS")).click();
			//Thread.sleep(5000);
			//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			//driver.switchTo().window(tabs.get(1)).close();
			//driver.switchTo().window(tabs.get(0)).close();
			
		}

	}


