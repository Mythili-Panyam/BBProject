package Com.Test.BlueBadge.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.Test.BlueBadge.Base.BasePage;
import Com.Test.BlueBadge.Util.ElementUtil;

public class ResetPasswordPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	//By Locators
	//By pageHeader=By.xpath("//span[@class='_formName']");
	By email=By.id("Email_Address");
	By submitButton=By.xpath("//span[@class='submitText']");
	By cancelButton=By.xpath("//span[@class='cancelText']");
	By pageHeader=By.className(" _formName");
	
	public ResetPasswordPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	//page actions
	public String verifyPageHeader() {
		return elementUtil.doGetText(pageHeader);
	}
				

}
