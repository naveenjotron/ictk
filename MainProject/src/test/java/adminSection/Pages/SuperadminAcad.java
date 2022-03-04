package adminSection.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
Thread.sleep(5000);
driver.getPageSource().contains("Dashboard");
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.findElement(By.cssSelector("<div _ngcontent-wxd-c30=\"\" class=\"text-white text-center me-2 d-flex align-items-center justify-content-center\"><i _ngcontent-wxd-c30=\"\" class=\"material-icons opacity-10\">assignment_ind</i></div><span _ngcontent-wxd-c30=\"\" class=\"nav-link-text ms-1\">Academic Membership</span></a>)")).click();

}
@Test(priority=2)






@AfterTest
public void quitBrowser() throws IOException, InterruptedException {
	Thread.sleep(10000);
    driver.quit();
}
}