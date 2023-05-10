package TBGPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {
	Browser browser;
	BrowserContext browsercontext;
	Page page;
	Properties property;
	PlaywrightFactory pf;
	private static ThreadLocal<Browser> tlBrowser = new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> tlBrowserContext = new ThreadLocal<>();
	private static ThreadLocal<Page> tlPage = new ThreadLocal<>();
	private static ThreadLocal<Playwright> tlPlaywright = new ThreadLocal<>();

	public static Playwright getPlaywright() {
		return tlPlaywright.get();
	}

	public static Browser getBrowser() {
		return tlBrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return tlBrowserContext.get();
	}

	public static Page getPage() {
		return tlPage.get();
	}

	
	public Page initbrowser(Properties property)
	{
	    String browsername=property.getProperty("browser").trim();
		System.out.println("browser name:"+browsername);
	    Playwright playwright=	Playwright.create();
	    switch(browsername.toLowerCase())
	    {
	    case"chromium":
	    	browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    	break;
	    case"Firefox":
	    	browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    	break;
	    case"safari":
	    	browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
	    	break;
	    case"chrome":
	    	browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("Chrome").setHeadless(false));
	    	break;
	    	default:System.out.println("Enter valid browser name");
	    		break;
	    }
	
	    browsercontext=browser.newContext();
	     browsercontext.setDefaultNavigationTimeout(3000);
	     Page page= browser.newPage();
	     page.navigate(property.getProperty("url").trim());
	     return page;
	}	
	public Properties intproperties()
	{
		try {
			FileInputStream fileinput=new FileInputStream("src/test/resource/configure/configure.properties");
			property=new Properties();
			property.load(fileinput);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return property;
	}
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}
	
	
}
