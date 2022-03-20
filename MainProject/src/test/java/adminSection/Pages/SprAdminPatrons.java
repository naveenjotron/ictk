package adminSection.Pages;

import org.testng.annotations.Test;
import org.testng.internal.Utils;

import projectBase.Scripts.AdminLoginBase;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;


import java.io.File;
import java.io.IOException;
public class SprAdminPatrons {
	WebDriver driver;

 
  @BeforeTest
  public void loginsetup() {
		AdminLoginBase ul;
		ul= new AdminLoginBase(driver);
		driver= ul.login();
}

  @Test(priority=1)
  public void courses() throws InterruptedException {
	  driver.getPageSource().contains("Dashboard");

	  WebDriverWait wait=new WebDriverWait(driver, 10);

	  WebElement patronbtn = driver.findElement(By.cssSelector("#myDiv > li:nth-child(10) > a"));
	  wait.until(ExpectedConditions.elementToBeClickable(patronbtn));
	  patronbtn.click();
	  Thread.sleep(2000);

	  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	  }


	  @Test(priority=2)
	  public void search() {
	  	String keyword="12";
	  	driver.findElement(By.id("listSearch")).sendKeys(keyword);
	  	String searchResult=driver.findElement(By.cssSelector("div.p-3")).getText();
	  	
	  	if(searchResult.contains(keyword))
	        	System.out.println("The search result contains the keyword --- "+searchResult);
	  	else
	        	System.out.println("The search result doesn't contains the keyword --- "+searchResult);
	  	try {
	  		Thread.sleep(2000);
	  	} catch (InterruptedException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	}

	  	
	  }

	  @Test(priority=3)
	  public void addpatrons() {
	  	driver.findElement(By.cssSelector("body > app-root > app-patron > div > main > div > div > div > div > div.card-header.pb-0 > div > div.ms-auto.my-auto.mt-lg-0.mt-4 > div > a")).click();
	  	
	  	File CourseImage = new File(System.getProperty("user.dir") +"/CommonFiles/" + "WWW_YTS_AG.jpg");
	      Utils.log("file exists: " + CourseImage.exists());

	      String CourseimagePath = CourseImage.getAbsolutePath();
	      WebElement input = driver.findElement(By.cssSelector("#imm > div.input-group.input-group-dynamic.ms-5 > input"));
	      input.sendKeys(CourseimagePath);
	      
	      driver.findElement(By.cssSelector("#imm > div.button-row.d-flex.mt-4 > button")).click();
	      
	      driver.findElement(By.cssSelector("body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled")).click();
	      
	      
	  	
	  	
	  }
	  

	  @Test(priority=4)
	  public void deletepatrons() throws InterruptedException {
	  	Thread.sleep(2000);
	  	driver.findElement(By.cssSelector("body > app-root > app-patron > div > main > div > div > div > div > div.card.p-3 > div > table > tbody:nth-child(13) > tr > td.align-center.text-center.act-align > i")).click();
	  	driver.findElement(By.cssSelector("body > div > div > div.swal2-actions > button.swal2-confirm.swal2-styled.swal2-default-outline")).click();
	  }

  
  
  
  
  
  
  
  @AfterTest
  public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(15000);
	    driver.quit();
	}


}
