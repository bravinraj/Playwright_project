package TBGtestcase;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import BaseTest.Basetestcase;
import TBGPage.PlaywrightFactory;

public class LoginTest extends Basetestcase  {
	            
	           PlaywrightFactory pf;
	           ExtentTest test;
	           ExtentReports extent;
			   
		      // public Loginpage loginpage;
			  // public Homepage homepage;
		      
			    //verify the tittle before login 
				    @Test
				    public void verifytittle()
					    {
				    	
					    String tittle=loginpage.verifyTittle();
					    Assert.assertEquals(tittle,"WebaccessApp");
					    if(tittle.equals("WebaccessApp"))
					    {
					    	System.out.println("passed");
					    }
					    else
					    {
					    	System.out.println("Failed");
					    }
					    }
				    //login
				    @Test
				    public void login()
				    {
				      loginpage.LoginintoApplication(property.getProperty("username").trim(),property.getProperty("password").trim());		    	
				    }
				
				 
				    //logout
				    @Test
				    public void logout()
				    {
				    	loginpage.logout();
				    }
				   
		}
		
