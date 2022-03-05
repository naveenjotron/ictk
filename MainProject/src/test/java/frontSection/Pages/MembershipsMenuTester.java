package frontSection.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import projectBase.Scripts.TestBase;

public class MembershipsMenuTester  {
	WebDriver driver;
	
	private void selectDropdownOption(String menuOptionSelector) throws InterruptedException {

		driver.findElement(By.id("dropdownMenuDocs")).click();
		Thread.sleep(3000);

		driver.findElement(By.cssSelector(menuOptionSelector)).click();

	}
	
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

	private void testCorporateMembership() {
		// verifying corporate membership form
		driver.findElement(By.cssSelector(
				"body > app-root > app-corporate > app-bannercorporate > header > div > div.container > div > div > button"))
				.click();
		driver.findElement(By.cssSelector("body > app-root > app-corporateform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > form > div > div:nth-child(1) > div > div > input")).sendKeys("Anjali");
		driver.findElement(By.name("address")).sendKeys("Gayathri nagar banglore");
		driver.findElement(By.name("head")).sendKeys("Chief product officer");
		driver.findElement(By.name("nature")).sendKeys("Products");
		driver.findElement(By.name("website")).sendKeys("www.nytimes.com");
		
		driver.findElement(By.cssSelector(
				"body > app-root > app-corporateform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > form > div > div:nth-child(5) > div:nth-child(2) > div > input"))
				.sendKeys("G6384HJK");
		driver.findElement(By.name("GST")).sendKeys("22");

		// verifying point of contact form
		driver.findElement(By.name("nameofContact")).sendKeys("Deepthi");
		driver.findElement(By.cssSelector(
				"body > app-root > app-corporateform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > form > div > div:nth-child(8) > div:nth-child(2) > div > input"))
				.sendKeys("7483798093");
		driver.findElement(By.name("TechnicalSkill")).sendKeys("Java,SQL");
		driver.findElement(By.cssSelector("body > app-root > app-corporateform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > form > div > div:nth-child(10) > div:nth-child(1) > div > input")).sendKeys("deeothi123@gmail.com");;
		driver.findElement(By.name("employeeCount")).sendKeys("150");
		driver.findElement(By.name("details")).sendKeys("Bravo");
		driver.findElement(By.xpath("//input[@value='REGISTER']")).click();

	}

	private void testAcademicMembership() throws InterruptedException {

		// to perform Scroll down on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(3000);

		// verify that the “Registration button” is displayed
		boolean registerbutton = driver.findElement(By.xpath("//a[@class='btn btn-warning']")).isDisplayed();

		if (registerbutton) {
			System.out.println("Register Button is displayed");
		} else {
			System.out.println("Register Button is not displayed");
		}

		// checking the horizontal scroll inside a web element
		WebElement scrollArea = driver.findElement(By.className("table-responsive"));

		// Scroll to div's most right:
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft = arguments[0].offsetWidth", scrollArea);

		// Or scroll the div by pixel number:
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollLeft += 250", scrollArea);

		// to scroll down the webpage

		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
	}

	// verifying partnership form
	public void testpartnership() {
		driver.findElement(By.cssSelector(
				"body > app-root > app-partnership > app-bannerpartnership > header > div > div.container > div > div > button"))
				.click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Teena Mathew");
		driver.findElement(By.cssSelector(
				"body > app-root > app-partenshipform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > div > div.card.card-plain > form > div > div:nth-child(1) > div.col-md-6.ps-md-2 > div > input"))
				.sendKeys("teena@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("7909076655");
		driver.findElement(By.name("firm")).sendKeys("3-06-2021");
		driver.findElement(By.xpath("//input[@placeholder='Address']")).sendKeys("Pazhassi quarters");
		driver.findElement(By.name("district")).sendKeys("Ernakulam");
		driver.findElement(By.name("officeSpace")).sendKeys("400");
		driver.findElement(By.xpath("//input[@placeholder='Number of Employees']")).sendKeys("600");
		driver.findElement(By.name("report")).sendKeys("Training industry conducts research");
		driver.findElement(By.name("expect")).sendKeys("Utilizing the strength");
		driver.findElement(By.name("profile")).sendKeys("Flexible & Diplomatic");
		driver.findElement(By.cssSelector("body > app-root > app-partenshipform > header > div.card.shadow-lg.mt-n5.mx-4.mb-4 > section > div > div > div > div > div.card.card-plain > form > div > div:nth-child(8) > div > button")).click();

		// verifying alert
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept(); // click on ok button
		driver.navigate().back();

		// verifying download button
		driver.findElement(By.linkText("Download Proposal")).click();

	}

public static void main(String[] args) throws InterruptedException {
	MembershipsMenuTester website = new MembershipsMenuTester();
	website.testICTWebsite();
	}
//	  public void aftertest() {
//		  driver.close();
//		  System.out.println("Test Ended");
//	  }
	  

}
