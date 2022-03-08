package frontSection.Pages;
//import java.util.ArrayList;

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
		
		@BeforeTest
		public void browserSetup() {
			tb = new TestBase();
			driver=tb.onSetup();
		}
		
		@AfterTest
		public void closeBrowser() throws InterruptedException {
			//Thread.sleep(5000);
			//driver.close();
		}
		

	@Test
		public void _getStartedButton() throws InterruptedException {
			//browserSetup();
			//Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > header > div > div > div > div > div > button")));
			driver.findElement(By.cssSelector("body > header > div > div > div > div > div > button")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("dropdownMenuPages")).click();
			JavascriptExecutor jsx= (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,1500)", "");
			Thread.sleep(2000); 
			driver.findElement(By.cssSelector("#carouselExampleControls > div.min-vh-75.position-absolute.w-100.top-0 >"
					+ " a.carousel-control-next > span.carousel-control-next-icon.position-absolute.bottom-50.me-n7")).click();
			Thread.sleep(2000); 
			jsx.executeScript("window.scrollBy(0,900)", "");
			
}

	
	/*
	 * @Test public void testCareersButton() throws InterruptedException {
	 * driver.get("http://64.227.132.109/LandingPage/about"); JavascriptExecutor jsx
	 * = (JavascriptExecutor)driver; jsx.executeScript("window.scrollBy(0,7500)",
	 * ""); Thread.sleep(2000); WebDriverWait wait = new WebDriverWait(driver,
	 * 5000);
	 * wait.until(ExpectedConditions.elementToBeClickable(By.linkText("CAREERS")));
	 * driver.findElement(By.linkText("CAREERS")).click(); Thread.sleep(5000);
	 * ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
	 * driver.switchTo().window(tabs.get(1)).close();
	 * //driver.switchTo().window(tabs.get(0)).close();
	 * 
	 * }
	 */

	}


