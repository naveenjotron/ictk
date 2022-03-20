package frontSection.Pages;
//import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import java.util.ArrayList;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageTest {
	
		private WebDriver driver;
		TestBase tb;
		
		@BeforeTest
		public void browserSetup() 
		{
			tb = new TestBase(driver);
			driver=tb.onSetup();
		}
		
		@AfterTest
		public void closeBrowser() throws InterruptedException 
		{
		//Thread.sleep(5000);
		//driver.close();
		}	
	
		@Test
		//Verify Student  searching and finding details of a course
		
		public void _getStartedButton() throws InterruptedException 
		{
		
			WebDriverWait wait = new WebDriverWait(driver, 5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body > header > div > div > div > div > div > button")));
			driver.findElement(By.cssSelector("body > header > div > div > div > div > div > button")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("listSearch")).sendKeys("MEAN");
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,750)", "");
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.className("card-description"))).pause(2000)
					.click(driver.findElement(By.className("btn-info"))).build().perform();
			Thread.sleep(2000);
		 }
		
		
		@Test (priority=2)
		// Verify Scroll Bar buttons on Home Page
		 public void _testLeftandRightScrollbar() throws InterruptedException 
		  {
			driver.findElement(By.id("dropdownMenuPages")).click();

		  JavascriptExecutor jsx=(JavascriptExecutor)driver; 
		  jsx.executeScript("window.scrollBy(0,1500)", "");
		  Thread.sleep(2000); 
		  driver.findElement(By.cssSelector("#carouselExampleControls > div.min-vh-75.position-absolute.w-100.top-0 > a.carousel-control-next > span.carousel-control-next-icon.position-absolute.bottom-50.me-n7"
		  )).click(); 
		  Thread.sleep(2000); 
		  jsx.executeScript("window.scrollBy(0,850)", ""); 
		  Thread.sleep(2000); 
		  driver.findElement(By.xpath("/html/body/app-root/app-home-main/app-cards/body/div/div/owl-carousel-o/div/div[2]/div[2]/i")).click(); 
		  Thread.sleep(2000);
		  jsx.executeScript("window.scrollBy(0,2450)", ""); 
		 // driver.findElement(By.className("owl-prev")).click();
		//  Thread.sleep(2000); 
		  }
		
	
		@Test (priority=3)
		// Verify Courses dropdown link
	  
	  public void _testCourseDropDownLink() throws InterruptedException 
	  {
			driver.get("http://64.227.132.109/LandingPage");
			WebElement ele=driver.findElement(By.xpath("//*[@id=\"dropdownMenuBlocks\"]")); 
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			driver.findElement(By.cssSelector("#navigation > ul > li:nth-child(3) > ul > div.d-none.d-lg-block > li:nth-child(1) > a > div > div > h6")).click();
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("body > header > div.page-header.min-vh-70 > div.container > div > div > button")).click();
			 driver.findElement(By.name("name")).sendKeys("abc");
			  Thread.sleep(2000); 
		      driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div:nth-child(2) > input")).sendKeys("dfg@gmail.com");
		      Thread.sleep(2000); 
			  driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div:nth-child(3) > input")).sendKeys("22434232");
			  Thread.sleep(2000); 	
			  driver.findElement(By.cssSelector("#exampleModalSignup > div > div > div > div > div.card-body.pb-3 > form > div.text-center > button")).click();
			  driver.switchTo().alert().accept();
	  }

		@Test (priority=4)
		// Verify Courses Left side buttons
	  
		 public void _testCourseMenuBtn() throws InterruptedException 
		  {
			   JavascriptExecutor jsx = (JavascriptExecutor) driver;
			   jsx.executeScript("window.scrollBy(0,300)", "");
			   //About link
			    driver.findElement(By.id("v-pills-home-tab")).click(); 
			    Thread.sleep(2000);
			  //About link
			    driver.findElement(By.id("v-pills-profile-tab")).click();
			    Thread.sleep(2000);
			  //Agenda link
			    driver.findElement(By.id("v-pills-messages-tab")).click();
			    Thread.sleep(2000);
			  //Highlights link
			    driver.findElement(By.id("v-pills-settings-tab")).click();
			    Thread.sleep(2000);
			  //Entrance link
			    driver.findElement(By.id("v-pills-download-tab")).click();
			    Thread.sleep(2000);
			  //Models link
			    driver.findElement(By.cssSelector("#v-pills-partners > section > div > div > div:nth-child(1) > div > p > a")).click();
			    Thread.sleep(2000); 
			   
			    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1)).close();
				driver.switchTo().window(tabs.get(0)).close();
				
	  }

	  }
	   
