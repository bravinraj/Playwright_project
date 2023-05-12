package TBGPage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Page;

public class Loginpage {
	
	ExtentTest test;
	ExtentReports extent;
	private Page page;
	//static Properties pro;
	String Employer="//button[text()='Employers']";
	String Userid="//input[@data-placeholder='User ID']";
	String Password="//input[@data-placeholder='Password']";
	String login="//button[text()='Log In']";
	String FS="//div[text()=' FS ']";
	String logout="//button[text()='Sign Out']";
	
	    //initialize page object
	   public Loginpage(Page page)
	   {
		   this.page=page;
	   }
	

	
	//verify Tittle
	public String verifyTittle() 
		{
			String tittle=page.title();
			//test=extent.createTest("Test Case 1\", \"The test case 1 has passed");
			return tittle;
		}
	
	//Login into Application
	public void LoginintoApplication(String userid,String pass)
		{
		   
			Clickemployer();
			Enterusername(userid);
			Enterpassword(pass);
			Enterlogin();
		
		}
	public void logout()
		{
			ClickFS();
			Clicklogout();
		}
	public void Clickemployer()
		{
		   page.click(Employer);
		} 
	public void Enterusername(String userid)
		{
			page.fill(Userid,userid);
		}
	public void Enterpassword(String pass)
		{
			page.fill(Password, pass);
		}
	public void Enterlogin()
		{
			page.click(login);
		}
	public void ClickFS()
		{
			page.click(FS);
		}
	public void Clicklogout()
		{
			page.click(logout);
		}
}
	
	

