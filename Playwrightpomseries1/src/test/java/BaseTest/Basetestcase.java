package BaseTest;



import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.microsoft.playwright.Page;

import TBGPage.Loginpage;
import TBGPage.PlaywrightFactory;


public class Basetestcase {
	     PlaywrightFactory pf;
		
	     protected Loginpage loginpage;
	     protected Properties property;
		 Page page;
		 ExtentReports extent;
		 ExtentSparkReporter extentspark;
		 ExtentTest test;
		 
		@BeforeTest
		public void setup()
		{
			pf=new PlaywrightFactory();
		    property=pf.intproperties();
			page = pf.initbrowser(property);
			loginpage=new Loginpage(page);
		    extentspark=new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/testReport.html");
		    extent=new ExtentReports();
		    test=extent.createTest("Basetestcase");
		    extent.attachReporter(extentspark);
		   
		  
		    //config
		    extentspark.config().setTimelineEnabled(true);
		    extentspark.config().setDocumentTitle("Simple Automation Report");
		    extentspark.config().setReportName("TBG Report");
		    extentspark.config().setTheme(Theme.STANDARD);
		    extentspark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		    
		    
		}
		@AfterTest
		public void teardown()
		{	
		 page.context().browser().close();
		 extent.flush();
		}
	
	}
