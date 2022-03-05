package frontSection.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import projectBase.Scripts.TestBase;

public class test1 {
	WebDriver driver;
	TestBase tb;

@BeforeTest
	public void browserSetup(){
		tb = new TestBase();
		driver=tb.onSetup();
	}
@Test
public void membershipDropDwn() throws InterruptedException {
	driver.findElement(By.id("dropdownMenuDocs")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("li.mx-2:nth-child(4) > ul:nth-child(2) > "
			+ "div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a")).click();
}
@AfterTest
public void quitBrowser() throws IOException, InterruptedException {
	Thread.sleep(15000);
    driver.quit();
}
}
