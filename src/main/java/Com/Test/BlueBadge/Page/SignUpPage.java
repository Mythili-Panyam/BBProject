package Com.Test.BlueBadge.Page;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import Com.Test.BlueBadge.Base.BasePage;
import Com.Test.BlueBadge.Util.ElementUtil;
import io.qameta.allure.Step;

public class SignUpPage extends BasePage {
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	//Locators-By
	By logo=By.xpath("//a[@class='logo-text seax']");
	By loginButton=By.xpath("//a[@class='btn btn-primary']");
	By header=By.xpath("//h1[contains(text(),'Sign up for an account')]");
	By menuOption1=By.xpath("//a[contains(@class,'btn btn-lg btn-primary top')][contains(text(),'Home')]");
	By menuOption2= By.xpath("//a[contains(@class,'btn btn-lg btn-primary top')][contains(text(),'Online')]");
	By pageBottomOption1=By.xpath("//a[contains(text(),'About essex.gov.uk')]");
	By pageBottomOption2=By.xpath("//a[contains(text(),'Accessibility')]");
	By pageBottomOption3=By.xpath("//a[contains(text(),'Cookies')]");
	By pageBottomOption4=By.xpath("//a[contains(text(),'Terms and conditions')]");
	By pageBottomOption5=By.xpath("//a[contains(text(),'Privacy and data protection')]");
	By pageBottomOption6=By.xpath("//a[contains(text(),'Contact us')]");
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//Page Actions
	@Step("Getting signup page title")
	public String getPageTitle() {
	return elementUtil.doGetPageTitle();
	}
	@Step("Getting signup page logo")
	public boolean verifyPageLogo() {	
	return elementUtil.doIsDisplayed(logo);
    }
	@Step("Getting signup page header text")
    public String verifyHeaderText() {
    	return elementUtil.doGetText(header);
    }
	@Step("Verifying menu options 1")
    public boolean verifyMenuOption1() {
    	return elementUtil.doIsDisplayed(menuOption1);	
    }
    public boolean verifyMenuOption2() {
    	return elementUtil.doIsDisplayed(menuOption2);	
    }
    public boolean verifypageBottomOption1() {
    	return elementUtil.doIsDisplayed(pageBottomOption1);	
    }
    public boolean verifypageBottomOption2() {
    	return elementUtil.doIsDisplayed(pageBottomOption2);	
    }
    public boolean verifypageBottomOption3() {
    	return elementUtil.doIsDisplayed(pageBottomOption3);	
    }
    public boolean verifypageBottomOption4() {
    	return elementUtil.doIsDisplayed(pageBottomOption4);	
    }
    public boolean verifypageBottomOption5() {
    	return elementUtil.doIsDisplayed(pageBottomOption5);	
    }
    public boolean verifypageBottomOption6() {
    	return elementUtil.doIsDisplayed(pageBottomOption6);	
    }
    public LoginPage clickOnLoginButton() {
    	elementUtil.doClick(loginButton);
    	return new LoginPage(driver);
    }
	
}
