package BaseTest;



import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Page;

import TBGPage.Loginpage;
import TBGPage.PlaywrightFactory;


public class Basetestcase {
	     PlaywrightFactory pf;
		
	     protected Loginpage loginpage;
	     protected Properties property;
		 Page page;
		 ExtentReports extent;
		 
		@BeforeTest
		public void setup()
		{
			pf=new PlaywrightFactory();
		    property=pf.intproperties();
			page = pf.initbrowser(property);
			loginpage=new Loginpage(page);
		}
		@AfterTest
		public void teardown()
		{	
		 page.context().browser().close();
		}
	
	}
