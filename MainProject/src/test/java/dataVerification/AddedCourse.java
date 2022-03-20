package dataVerification;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import projectBase.Scripts.ExcelUtility;
import projectBase.Scripts.TestBase;

public class AddedCourse {
	
	WebDriver driver;
	String ExRegStat;
	
	@BeforeTest
	public void browserSetup(){
		TestBase tb;
		tb = new TestBase(driver);
		driver=tb.onSetup();
	}
	@Test
	public void VerifyCourse() throws IOException, ParseException {
		driver.findElement(By.cssSelector("li.dropdown-subitem:nth-child(3) > a")).sendKeys(Keys.RETURN);
		
		
		String CourseTitle = ExcelUtility.getCourseCellData(1, 0);
		String CourseShortName = ExcelUtility.getCourseCellData(1, 1);
		String CourseType = ExcelUtility.getCourseCellData(1, 2);
		String ShortDiscription = ExcelUtility.getCourseCellData(1, 3);
		String RegistrationStatus = ExcelUtility.getCourseCellData(1, 4);
		String CourseCategory = ExcelUtility.getCourseCellData(1, 5);
		String EntranceDate = ExcelUtility.getCourseCellData(1, 6);
		String AboutCourse = ExcelUtility.getCourseCellData(1, 7);
		String ComnceDate = ExcelUtility.getCourseCellData(1, 8);
		String OrienDate = ExcelUtility.getCourseCellData(1, 9);
		String LasDateReg = ExcelUtility.getCourseCellData(1, 10);
		String CourseFee = ExcelUtility.getCourseCellData(1, 11);
		String CourseRegFee = ExcelUtility.getCourseCellData(1, 12);
		String CourseDuration = ExcelUtility.getCourseCellData(1, 13);
		String ObjectivesAgenda = ExcelUtility.getCourseCellData(1, 14);
		String SampleEntQuestion = ExcelUtility.getCourseCellData(1, 15);
		String PlacementList = ExcelUtility.getCourseCellData(1, 16);
		String InternshipCertificate = ExcelUtility.getCourseCellData(1, 17);
		
		
		
		String ExCourseTitle= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExCourseShortName= driver.findElement(By.cssSelector("h1.text-white:nth-child(1)")).getText();
		
		WebElement CourseDrpdwn = driver.findElement(By.id("dropdownMenuBlocks"));
		//Creating object of an Actions class
		Actions action = new Actions(driver);
		//Performing the mouse hover action on the target element.
		action.moveToElement(CourseDrpdwn).perform();
		String ExCourseType= driver.findElement(By.cssSelector("li.dropdown-subitem:nth-child(3) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span")).getText();
		
//		String ExShortDiscription= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
				System.out.println("**Short Description NOT found on page");
		String ExRegistrationStatus= driver.findElement(By.cssSelector(".w-auto")).getText();
		System.out.println("*"+ExRegistrationStatus+"*");
		String status="APPLY NOW";
		
		if(ExRegistrationStatus==status) { ExRegStat="Registration Open"; System.out.println(ExRegStat);}
//		String ExCourseCategory= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		
		WebElement ExEntranceDate= driver.findElement(By.cssSelector(".col-sm-12 > div:nth-child(1) > h6:nth-child(3) > span"));
	    String dateString1 = ExEntranceDate.getText();
	    SimpleDateFormat old1 = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date date1 = old1.parse(dateString1);
	    SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
	    String ExEntrncDat= dt1.format(date1);
	    System.out.println(ExEntrncDat);
	    
		String ExAboutCourse= driver.findElement(By.cssSelector(".mb-sm-6 > p")).getText();
		
		WebElement ExComnceDate= driver.findElement(By.cssSelector(".col-sm-12 > div:nth-child(1) > h6:nth-child(4) > span"));
		String dateString2 = ExComnceDate.getText();
	    SimpleDateFormat old2 = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date date2 = old2.parse(dateString2); 
	    SimpleDateFormat dt2 = new SimpleDateFormat("dd-MM-yyyy");
	    String ExComncDat= dt2.format(date2);
	    System.out.println(ExComncDat);
	    
		WebElement ExOrienDate= driver.findElement(By.cssSelector(".col-sm-12 > div:nth-child(1) > h6:nth-child(5) > span"));
		String dateString3 = ExOrienDate.getText();
	    SimpleDateFormat old3 = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date date3 = old3.parse(dateString3);
	    SimpleDateFormat dt3 = new SimpleDateFormat("dd-MM-yyyy");
	    String ExOrienDat= dt3.format(date3);
	    System.out.println(ExOrienDat);
		
		WebElement ExLasDateReg= driver.findElement(By.cssSelector("h6.mt-5 > span:nth-child(1)"));
		String dateString4 = ExLasDateReg.getText();
	    SimpleDateFormat old4 = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date date4 = old4.parse(dateString4);
	    SimpleDateFormat dt4 = new SimpleDateFormat("dd-MM-yyyy");
	    String ExLasDatReg= dt4.format(date4);
	    System.out.println(ExLasDatReg);
	    
		String ExCourseFee= driver.findElement(By.cssSelector("h1.mt-0")).getText();
		boolean exCorFee=ExCourseFee.contains(CourseFee);
//		String ExCourseRegFee= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
//		String ExCourseDuration= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
				System.out.println("**Course Duration NOT Found");
		driver.findElement(By.cssSelector("#v-pills-profile-tab")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String ExObjectivesAgenda= driver.findElement(By.cssSelector("#v-pills-profile > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > p:nth-child(1)")).getText();
//		String ExSampleEntQuestion= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
				System.out.println("**Cannot test Sample Entrance Questions");
//		String ExPlacementList= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
				System.out.println("**Cannot test Placement List");
//		String ExInternshipCertificate= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
				System.out.println("**Cannot test Intership Certificate");
				
				
				
				
				
		Assert.assertEquals(ExCourseTitle,CourseTitle);
		System.out.println("**Course Title -FOUND");
		Assert.assertEquals(ExCourseShortName,CourseShortName);
		System.out.println("**Course Short Name -FOUND");
		Assert.assertEquals(ExCourseType,CourseType);
		System.out.println("**Course Type -FOUND");
		Assert.assertEquals(ExEntrncDat,EntranceDate);
		System.out.println("**Entrance Date -FOUND");
		Assert.assertEquals(ExAboutCourse,AboutCourse);
		System.out.println("**About Course -FOUND");
		Assert.assertEquals(ExComncDat,ComnceDate);
		System.out.println("**Commence date -FOUND");
		Assert.assertEquals(ExOrienDat,OrienDate);
		System.out.println("**Orientation date -FOUND");
		Assert.assertEquals(ExLasDatReg,LasDateReg);
		System.out.println("**Last date of Registration -FOUND");
		Assert.assertEquals(exCorFee,true);
		System.out.println("**Course Free -FOUND");
		Assert.assertEquals(ExObjectivesAgenda,ObjectivesAgenda);
		System.out.println("**Objectives Agenda -FOUND");
		
		
//		Assert.assertEquals(ExRegStat,RegistrationStatus);
	}
	@AfterTest
	public void quitBrowser() throws IOException, InterruptedException {
		Thread.sleep(5000);
	    driver.quit();
	}
}
