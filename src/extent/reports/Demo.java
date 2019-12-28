package extent.reports;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Demo 
{
	/*
	
	@Test
	public void extendReportInstance()
	{
		Date date= new Date();
		String currentDate = date.toString();
		//String rep1=currentDate.replace(" ", "_");
		//System.out.println(rep1);
		String finalDateTime=currentDate.replace(" ", "_").replace(":","_");
		System.out.println(finalDateTime);
	}
	*/
	WebDriver driver;
	ExtentTest eTest;
	ExtentReports eReport;
	
	
	@Test
    public void getLoginpageTitle()
	{
		String expTitle="Facebook – log in or sign up";
		eReport =ExtentReportManage.extentReportInstance();
		
		
		eTest = eReport.startTest("Get login Page Title");
		eTest.log(LogStatus.INFO, "creation of webdriver Chrome object");
		driver= new FirefoxDriver();
		eTest.log(LogStatus.INFO, "Navigat to  Facebook/Test Application");
		driver.get("http:\\facebook.com");
		eTest.log(LogStatus.INFO, "Get title of Facebook/Test Application");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
		if(expTitle.equals(actTitle))
		{
			eTest.log(LogStatus.PASS, "Expected Title is matching with actual");
		}
		else
		{
			eTest.log(LogStatus.FAIL, "Expected title is not matching with actual");
		}
	}
		
	@AfterMethod
	public void postTestExe()
		{
		eTest.log(LogStatus.INFO, "close the browswer for Facebook/test application");
		driver.quit();
		
		eReport.endTest(eTest);
		eReport.flush();
			
		}
	}

