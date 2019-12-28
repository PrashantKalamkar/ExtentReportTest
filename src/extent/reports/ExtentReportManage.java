package extent.reports;

import java.io.File;
import java.util.Date;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportManage 
{
	@Test
	public static ExtentReports extentReportInstance()
	{
		Date date= new Date();
		String currentDate = date.toString();
		//String rep1=currentDate.replace(" ", "_");
		//System.out.println(rep1);
		String finalDateTime=currentDate.replace(" ", "_").replace(":","_");
		System.out.println(finalDateTime);
		String fileName="Report_"+finalDateTime+".html";
		System.out.println(fileName);
		ExtentReports eReport = new ExtentReports(fileName,true,DisplayOrder.NEWEST_FIRST);
		String currentDirPath =System.getProperty("user.dir");
		String pathName =currentDirPath+"\\Reports-Config.xml";
		File configfile = new File(pathName);
		eReport.loadConfig(configfile);
		eReport.addSystemInfo("Environment","QA").addSystemInfo("Selenium version", "3.141").addSystemInfo("TestNG", "7.0");
		return eReport;
		
		
		
		
	}

}
