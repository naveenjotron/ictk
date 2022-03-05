package frontSection.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import projectBase.Scripts.TestBase;

public class ICTWebsiteMenuTester {
	

	WebDriver driver;
	TestBase tb;
//	public ICTWebsiteMenuTester() {
//
//		System.setProperty("webdriver.chrome.driver", "C:\\Workspace_ICTAK\\MainProject\\drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		
//		launchPage();
//	}
	@BeforeTest
	public void browserSetup(){
		TestBase tb;
		tb = new TestBase();
		driver=tb.onSetup();
	}
	
	
//	public void launchPage() {
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//
//		// Launching website
//		driver.get("http://64.227.132.109/LandingPage");
//
//		// Maximize the browser window
//		driver.manage().window().maximize();
//	}

}
