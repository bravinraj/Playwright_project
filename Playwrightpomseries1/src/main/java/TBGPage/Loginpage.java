package TBGPage;

import com.microsoft.playwright.Page;

public class Loginpage {
	
	
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
	
	

