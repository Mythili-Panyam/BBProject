package Com.Test.BlueBadge.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public static boolean highlightElement;
	public OptionsManager optionsManager;
	
	
	public WebDriver init_driver(String browserName) {
		
		optionsManager=new OptionsManager(prop);
		highlightElement=prop.getProperty("highlight").equals("yes")? true:false;
		
		System.out.println("Browser name is "+browserName);
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(optionsManager.getChromeOptions());	
			
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();	
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else if(browserName.equals("internet explorer")) {
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();	
			
		}else {
			System.out.println(browserName+" is not found, please pass the correct browser");
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//driver.get(url);
		
		return driver;
		
	}
	public Properties init_properties() {
		prop=new Properties();
		//String path=null;
		//String env=null;
		
	//	try {
		//	env=System.getProperty("env");
			//if(env.equals("QA")) {
				//path=".\\src\\main\\java\\Com\\Test\\BlueBadge\\Config\\QA.Config.Properties";
			//}else if(env.equals("Stage")) {
				//path=".\\src\\main\\java\\Com\\Test\\BlueBadge\\Config\\Stage.Config.Properties";
			//}
		//}catch(Exception e) {
		 String path=".\\src\\main\\java\\Com\\Test\\BlueBadge\\Config\\Config.Properties";
		//}
		try {
			FileInputStream ip=new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("some issue with config properties...please correct your config...");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		return prop;
		
		
		
		
	
	}
	
	}
