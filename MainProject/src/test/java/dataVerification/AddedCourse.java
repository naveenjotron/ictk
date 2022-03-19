package dataVerification;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import projectBase.Scripts.ExcelUtility;
import projectBase.Scripts.TestBase;

public class AddedCourse {
	
	WebDriver driver;
	
	@BeforeTest
	public void browserSetup(){
		TestBase tb;
		tb = new TestBase(driver);
		driver=tb.onSetup();
	}
	@Test
	public void VerifyCourse() throws IOException {
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
		String ExCourseType= driver.findElement(By.cssSelector("li.dropdown-subitem:nth-child(3) > a:nth-child(1) > "
				+ "div:nth-child(1) > div:nth-child(1) > span")).getText();
//		String ExShortDiscription= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
//		String ExRegistrationStatus= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
//		String ExCourseCategory= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExEntranceDate= driver.findElement(By.cssSelector(".col-sm-12 > div:nth-child(1) > h6:nth-child(3) > span")).getText();
//		String ReExEntranceDate;
		StringBuilder sb=new StringBuilder(ExEntranceDate);
		sb.reverse().toString();
		System.out.println(sb);
		String ExAboutCourse= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String EXComnceDate= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExOrienDate= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExLasDateReg= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExCourseFee= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExCourseRegFee= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExCourseDuration= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExObjectivesAgenda= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExSampleEntQuestion= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExPlacementList= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
		String ExInternshipCertificate= driver.findElement(By.cssSelector("div.text-white > h2")).getText();
	}
}
