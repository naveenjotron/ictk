package adminSection.Pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import projectBase.Scripts.AdminLoginBase;

public class SuperadminAcad {


WebDriver driver;
@BeforeTest	
	public void login() throws InterruptedException {
		
		AdminLoginBase ul;
		ul= new AdminLoginBase(driver);
		driver= ul.login();
		
		
}
		
		
}