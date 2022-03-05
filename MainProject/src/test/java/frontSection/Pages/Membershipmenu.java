package frontSection.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import projectBase.Scripts.TestBase;

public class Membershipmenu {
	WebDriver driver;
	TestBase tb;
	@BeforeTest
	public void browserSetup(){
		TestBase tb;
		tb = new TestBase();
		driver=tb.onSetup();
		}
	@Test(priority=1, enabled=true)
	   public void selectDropdownOption() throws InterruptedException {

		driver.findElement(By.id("dropdownMenuDocs")).click();
		Thread.sleep(3000);
		Select AcademicMem= new Select(driver.findElement(By.cssSelector("li.mx-2:nth-child(4) > ul:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1) > h6")));
		AcademicMem.selectByVisibleText("Academic Membership");


		//driver.findElement(By.cssSelector(menuOptionSelector)).click();

	}
	@Test(priority=2, enabled=false)
	public void testICTWebsite() throws InterruptedException {

		// verifying academic membership

		String academicMembershipSelector = "#navigation > ul > li:nth-child(4) > ul > div.d-none.d-lg-block > ul > li:nth-child(1) > a";
		selectDropdownOption(academicMembershipSelector);

		testAcademicMembership();

		// verifying ICTAK logo
		driver.findElement(By.xpath("//img[@alt='main_logo']")).click();
		driver.findElement(By.xpath("//body[@class='loaded']")).click();

		// verifying corporate membership

		String corporateMembershipSelector = "#navigation > ul > li:nth-child(4) > ul > div.d-none.d-lg-block > ul > li:nth-child(2) > a > h6";
		selectDropdownOption(corporateMembershipSelector);

		testCorporateMembership();

		String partnershipSelector = "#navigation > ul > li:nth-child(4) > ul > div.d-none.d-lg-block > ul > li:nth-child(3) > a > h6";
		selectDropdownOption(partnershipSelector);

		testpartnership();

	}

@AfterTest
public void quitbrowser() throws InterruptedException {
	Thread.sleep(10000);
	driver.quit();
	
}
}
