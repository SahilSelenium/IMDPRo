package Comgeneric.Imed.Imed;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Browser {
	
	public static WebDriver driver;
	@Test
	public static WebDriver getBrowser(){
		if(Constant.browser.equals("chrome")){
			        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(Constant.browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver","D:\\gecko\\geckodriver.exe");
			
			//System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(Constant.browser.equals("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\sjar\\IEDriverSerevr.exe");
			driver = new InternetExplorerDriver();
		}else if(Constant.browser.equals("Safari")){
			System.setProperty("webdriver.ie.driver", "C:\\sjar\\IEDriverSerevr.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

}
