package Com.Test.BlueBadge.Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Com.Test.BlueBadge.Base.BasePage;
import Com.Test.BlueBadge.Page.SignUpPage;
import Com.Test.BlueBadge.Util.AppConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class SignUpPageTest {
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	SignUpPage signuppage;
	
	@BeforeTest
	public void setup() {
		basepage=new BasePage();
		prop=basepage.init_properties();
		String browserName=prop.getProperty("browser");
	driver=basepage.init_driver(browserName);
	driver.get(prop.getProperty("url"));	
	signuppage=new SignUpPage(driver);
	}
	
	@Test(priority=1, description="verifying Page Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description:Verify page title test")
	public void getPageTitleTest() {
		String title=signuppage.getPageTitle();
		System.out.println("Title is "+title);
		Assert.assertEquals(title, AppConstants.SignUp_Page_Title);	
	}
	@Test(priority=2)
	@Severity(SeverityLevel.CRITICAL)
	public void verifyPageLogoTest() {
		Assert.assertTrue(signuppage.verifyPageLogo());	
	}
	@Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	public void verifyHeaderTextTest() {
		String headerText=signuppage.verifyHeaderText();
		Assert.assertEquals(headerText,AppConstants.Signup_Page_Header);
	}
	@Test(priority=4)
	@Severity(SeverityLevel.NORMAL)
	public void verifyMenuOption1() {
		Assert.assertTrue(signuppage.verifyMenuOption1());	
	}
	@Test(priority=5)
	@Severity(SeverityLevel.NORMAL)
	public void verifyMenuOption2() {
		Assert.assertTrue(signuppage.verifyMenuOption2());	
	}
	@Test(priority=6)
	@Severity(SeverityLevel.NORMAL)
	public void verifypageBottomOption1() {
		Assert.assertTrue(signuppage.verifypageBottomOption1());	
	}
	@Test(priority=7)
	@Severity(SeverityLevel.NORMAL)
	public void verifypageBottomOption2() {
		Assert.assertTrue(signuppage.verifypageBottomOption2());	
	}
	@Test(priority=8)
	@Severity(SeverityLevel.NORMAL)
	public void verifypageBottomOption3() {
		Assert.assertTrue(signuppage.verifypageBottomOption3());	
	}
	@Test(priority=9)
	@Severity(SeverityLevel.NORMAL)
	public void verifypageBottomOption4() {
		Assert.assertTrue(signuppage.verifypageBottomOption4());	
	}
	@Test(priority=10)
	@Severity(SeverityLevel.NORMAL)
	public void verifypageBottomOption5() {
		Assert.assertTrue(signuppage.verifypageBottomOption5());	
	}
	@Test(priority=11)
	@Severity(SeverityLevel.NORMAL)
	public void verifypageBottomOption6() {
		Assert.assertTrue(signuppage.verifypageBottomOption6());	
	}
	@Test(priority=12)
	@Severity(SeverityLevel.BLOCKER)
	public void clickOnLoginButtonTest() {
		signuppage.clickOnLoginButton();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	


}
