package dataVerification;
//NaveenJotron
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import projectBase.Scripts.ExcelUtility;
import projectBase.Scripts.TestBase;

public class Testimonial {
	WebDriver driver;
	boolean t;
	String cardData;
	@BeforeTest
	public void browserSetup(){
		TestBase tb;
		tb = new TestBase(driver);
		driver=tb.onSetup();
	}
	
	
	@Test
	public void verifyData() throws IOException, InterruptedException {
	String name=ExcelUtility.getTestimonialCellData(1, 0);
	String organisation=ExcelUtility.getTestimonialCellData(1, 1);
	String testimonial=ExcelUtility.getTestimonialCellData(1, 2);
	String CourseTitle=ExcelUtility.getTestimonialCellData(1, 3);
	
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	  js1.executeScript("window.scrollBy(0,5000)", "");
//	js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");

	Thread.sleep(2000);
	
	do {

		WebElement testimonialCard = driver.findElement(By.cssSelector("div.owl-item:nth-child(46) > div:nth-child(1) > div"));
		t=testimonialCard.isDisplayed();
		System.out.println("Found Card= "+t);
		cardData=testimonialCard.getText();
		System.out.println(cardData);
		if(t==true)
			break;	
		Thread.sleep(300);
		WebElement element = driver.findElement(By.cssSelector(".pt-6 > owl-carousel-o:nth-child(2) > "
				+ "div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > i"));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent"
				+ "('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", element);
		
	}while(t=true);
	
	System.out.println("....................................");
	if(cardData.contains(name)) { System.out.println("***Student name matched***");}
	else {System.out.println("***Student name NOT matched***");}
	if(cardData.contains(organisation)) { System.out.println("***Organization name matched***");}
	else {System.out.println("***Organization name NOT matched***");}
	if(cardData.contains(testimonial)) { System.out.println("***Testimonial data matched***");}
	else {System.out.println("***Testimonial data NOT matched***");}
	if(cardData.contains(CourseTitle)) { System.out.println("***Course Title matched***");}
	else {System.out.println("***Course Title NOT matched***");}
}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}
}
