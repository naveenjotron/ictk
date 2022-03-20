package adminSection.Pages;

import java.io.IOException;
import java.rmi.AccessException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import projectBase.Scripts.AdminLoginBase;

public class SuperadminAcad {


WebDriver driver;
@BeforeTest	
	public void login() throws InterruptedException {
		
		AdminLoginBase ul;
		ul= new AdminLoginBase(driver);
		driver= ul.login();
				
}
@Test(priority=1)
public void courses() throws InterruptedException {
Thread.sleep(10000);
driver.getPageSource().contains("Dashboard");
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.findElement(By.cssSelector("li.nav-item:nth-child(5) > a")).click();

}
@Test(priority=2)
public void search() {
	String keyword="Adi";
	driver.findElement(By.xpath("/html/body/app-root/app-academic-membership/body/main/nav/div/div[2]/div/div/input")).sendKeys(keyword);
	String searchResult=driver.findElement(By.cssSelector("div.card-body:nth-child(2)")).getText();

	if(searchResult.contains(keyword))
      	System.out.println("The search result contains the keyword --- "+searchResult);
	else
      	System.out.println("The search result doesn't contains the keyword --- "+searchResult);
}

@Test(priority=3)
public void fileDownload() throws AccessException, InterruptedException {
	
	driver.get("http://64.227.132.109/adminpage/academic");
	Thread.sleep(2000);
	WebElement btnDownload = driver.findElement(By.xpath("/html/body/app-root/app-academic-membership/body/main/div/div/div/div/div[1]/div/div[2]/div/button"));
	btnDownload.click();
	
	Thread.sleep(7000);
	
}






@AfterTest
public void quitBrowser() throws IOException, InterruptedException {
	Thread.sleep(20000);
    driver.quit();
}
}