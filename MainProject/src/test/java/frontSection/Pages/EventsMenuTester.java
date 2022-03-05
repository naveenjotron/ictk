package frontSection.Pages;

import org.openqa.selenium.By;

public class EventsMenuTester extends ICTWebsiteMenuTester {
	
	private void selectDropdownOption(String menuOptionSelector) throws InterruptedException {

		driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-contactus[1]/app-header[1]/div[1]/div[1]/div[1]/nav[1]/div[1]/div[1]/ul[1]/li[5]/a[1]")).click();;
		Thread.sleep(3000);

		driver.findElement(By.cssSelector(menuOptionSelector)).click();

	}

	
	public void testICTWebsite() throws InterruptedException {
		
		String salesforceselector = "#navigation > ul > li:nth-child(5) > ul > div.d-none.d-lg-block > ul > li:nth-child(1) > a > h6";
		selectDropdownOption(salesforceselector);
		
		testsalesforce();
		
		String roboticselector = "#navigation > ul > li:nth-child(5) > ul > div.d-none.d-lg-block > ul > li:nth-child(2) > a";
		selectDropdownOption(roboticselector);
		
		testrobotic();
	}
	
	private void testrobotic() {
		driver.findElement(By.id("v-pills-home-tab")).click();
		driver.findElement(By.id("v-pills-profile-tab")).click();
		driver.findElement(By.id("v-pills-messages-tab")).click();
		driver.findElement(By.id("v-pills-settings-tab")).click();
		driver.findElement(By.id("v-pills-download-tab")).click();
				
	}


//	private void testsalesforce() {
//		driver.findElement(By.id("v-pills-home-tab")).click();
//		driver.findElement(By.id("v-pills-profile-tab")).click();
//		driver.findElement(By.id("v-pills-messages-tab")).click();
//		driver.findElement(By.id("v-pills-settings-tab")).click();
//		driver.findElement(By.id("v-pills-download-tab")).click();	
//					
//	}


	public static void main(String[] args) {
		EventsMenuTester tester = new EventsMenuTester();
		tester.testEventMenu();

	}


	private void testEventMenu() {
		// TODO Auto-generated method stub
		
	}

}
