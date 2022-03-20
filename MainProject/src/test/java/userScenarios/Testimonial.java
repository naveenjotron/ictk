package userScenarios;

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
	
	
//	driver.findElement(By.cssSelector("owl-stage.ng-tns-c96-0 > div")).getText();
	
//	WebElement element = driver.findElement(By.cssSelector("div.owl-item:nth-child(47) > div:nth-child(1) > div"));
//	Actions actions = new Actions(driver);
//	actions.moveToElement(element);
//	actions.perform();
	WebDriverWait wait=new WebDriverWait(driver, 10);
//	WebElement testimonialCard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.owl-item:nth-child(47) > div:nth-child(1) >"
//			+ " div:nth-child(1) > div")));
	Thread.sleep(2000);
	WebElement testimonialCard = driver.findElement(By.cssSelector("div.owl-item:nth-child(47) > div:nth-child(1) > div:nth-child(1) > div"));
	boolean t=testimonialCard.isDisplayed();
	do {
	if(testimonialCard.isDisplayed()) {
		String cardData=testimonialCard.getText();
		System.out.println(cardData);
	}
	else {
//		WebElement element = driver.findElement(By.xpath("/html/body/app-root/app-home-main/app-testimonials/section/div[2]/owl-carousel-o/div/div[2]/div[2]"));
//
//		Actions actions = new Actions(driver);
//
//		actions.moveToElement(element).click().perform();
//		driver.findElement(By.xpath("/html/body/app-root/app-home-main/app-testimonials/section/div[2]/owl-carousel-o/div/div[2]/div[2]")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-home-main/app-testimonials/section/div[2]/owl-carousel-o/div/div[2]/div[2]")));
		driver.findElement(By.xpath("/html/body/app-root/app-home-main/app-testimonials/section/div[2]/owl-carousel-o/div/div[2]/div[2]")).click();
	}
	}while(t=false);
	
}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(10000);
	    driver.quit();
	}
}
