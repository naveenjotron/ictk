package frontSection.Pages;

import org.openqa.selenium.By;

public class ContactUsTester extends ICTWebsiteMenuTester {
	
	public void testContactUs() {
		driver.findElement(By.xpath("//body[@data-aos-easing='ease']")).click();
		
		driver.findElement(By.cssSelector("#contact-form > div.card-body.pt-1 > div:nth-child(1) > div:nth-child(2) > input")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("rahul123@gmail.com");
		driver.findElement(By.name("coursename")).sendKeys("Testing");
		driver.findElement(By.id("message")).sendKeys("Excellent");
		driver.findElement(By.cssSelector("#contact-form > div.card-body.pt-1 > div:nth-child(2) > div")).click();
	
	}
	public static void main(String[] args) {
		ContactUsTester tester = new ContactUsTester();
		tester.testContactUs();

	}

}
