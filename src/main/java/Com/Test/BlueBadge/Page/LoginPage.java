package Com.Test.BlueBadge.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.Test.BlueBadge.Base.BasePage;
import Com.Test.BlueBadge.Util.Credentials;
import Com.Test.BlueBadge.Util.ElementUtil;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	
	//Locators-By
	By email=By.name("username");
	By password=By.name("password");
	By signInButton=By.xpath("//button[@class='btn btn-default primary']");
	By registerButton=By.xpath("//a[@class='btn btn-default primary']");
	By cancelButton=By.xpath("//a[@class='btn btn-default pull-right']");
	By forgotPassword=By.xpath("//a[@class='resetLink']");
	By pageHeader=By.xpath("//h1[contains(text(),'Log In')]");
	By loginErrorText=By.xpath("//div[@class='error-text']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	//page actions
	
	public String verifyPageHeader() {
		return elementUtil.doGetText(pageHeader);	
	}
	public boolean verifyCancelButtonPresence() {
		return elementUtil.doIsDisplayed(cancelButton);
	}
	public boolean verifyregisterButtonPresence() {
		return elementUtil.doIsDisplayed(registerButton);
	}
	public BeforeYouBeginPage doLogin(Credentials userCred) {
		elementUtil.doSendKeys(email, userCred.getAppUsername());
		elementUtil.doSendKeys(password, userCred.getAppPassword());
		elementUtil.doClick(signInButton);
		return new BeforeYouBeginPage(driver);
	}
	public ResetPasswordPage verifyForgotPasswordLink() {
		elementUtil.doClick(forgotPassword);
		return new ResetPasswordPage(driver);
	}
	public boolean verifyLoginErrorMsg() {
		return elementUtil.doIsDisplayed(loginErrorText);
	}
	

}
