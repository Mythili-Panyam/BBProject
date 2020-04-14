package Com.Test.BlueBadge.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Test.BlueBadge.Base.BasePage;
import Com.Test.BlueBadge.Page.BeforeYouBeginPage;
import Com.Test.BlueBadge.Page.LoginPage;
import Com.Test.BlueBadge.Page.ResetPasswordPage;
import Com.Test.BlueBadge.Page.SignUpPage;
import Com.Test.BlueBadge.Util.AppConstants;
import Com.Test.BlueBadge.Util.Credentials;

public class LoginPageTest {
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	SignUpPage signuppage;
	LoginPage loginpage;
	ResetPasswordPage resetpwrdpage;
	BeforeYouBeginPage beforeyoubeginpage;
	Credentials userCred;
	
	@BeforeTest
	public void setup() {
		basepage=new BasePage();
		prop=basepage.init_properties();
		String browserName=prop.getProperty("browser");
	driver=basepage.init_driver(browserName);
	driver.get(prop.getProperty("url"));	
	signuppage=new SignUpPage(driver);
	resetpwrdpage=new ResetPasswordPage(driver);
	beforeyoubeginpage=new BeforeYouBeginPage(driver);
	loginpage=signuppage.clickOnLoginButton();
	 userCred=new Credentials((prop.getProperty("Email")),(prop.getProperty("Email")));
	}
	@Test(priority=1, alwaysRun = true)
	public void verifyPageHeaderTest() {
		Assert.assertEquals(loginpage.verifyPageHeader(),AppConstants.Login_Page_Header);
	}
	@Test(priority=2, alwaysRun = true)
	public void  verifyCancelButtonPresenceTest() {
		Assert.assertTrue(loginpage.verifyCancelButtonPresence());
	}
	@Test(priority=3, alwaysRun = true)
	public void  verifyregisterButtonPresenceTest() {
		Assert.assertTrue(loginpage.verifyregisterButtonPresence());
	}
	@Test(priority =4, alwaysRun = true)
	public void verifyForgotPasswordLink() {
	 resetpwrdpage=loginpage.verifyForgotPasswordLink();
	String pageheader= resetpwrdpage.verifyPageHeader();
	System.out.println("Page title is "+pageheader);
	Assert.assertEquals(pageheader,AppConstants.ResetPassword_Page_Header);
	}
	@Test(priority=5,enabled=false)
	public void doLoginTest() {
	 beforeyoubeginpage=loginpage.doLogin(userCred);
		//Assert.assertEquals(beforeyoubeginpage.verifyPageHeader(),"Before You Begin");
	Assert.assertEquals( beforeyoubeginpage.verifyLoggedInAccountName(), prop.getProperty("accountname"));
	}
	@DataProvider
	public Object[][] getLoginInvalidData() {
		Object data [][]= {
				{"mpanyam5@gmail.com","test123"},
				{"mpanyam@gmail.com","test123"},
				{"mpanyam5@gmail.com","Hansi@123"},
				{"mpanyam5@gmail.com"," "},
				{" ","Hansi@123 "},
				{" "," "},
		           };
		return data;
	}
	@Test(priority=6, dataProvider="getLoginInvalidData",enabled=false)
	public void doLogin_InvalidDetails(String username, String pwrd) {
		userCred.setAppUsername(username);
		userCred.setAppPassword(pwrd);
		loginpage.doLogin(userCred);
	Assert.assertTrue(loginpage.verifyLoginErrorMsg());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
