package Com.Test.BlueBadge.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Com.Test.BlueBadge.Base.BasePage;
import Com.Test.BlueBadge.Util.ElementUtil;

public class BeforeYouBeginPage extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	//by locators
	
	By pageHeader=By.xpath("//a[contains(text(),'Before You Begin')]");
	By loggedinAccountName=By.xpath("//span[@class='user displayname']");
	
	public BeforeYouBeginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	

	//page actions
	public String verifyPageHeader() {
		return elementUtil.doGetText(pageHeader);
	}
	public String verifyLoggedInAccountName() {
		return elementUtil.doGetText(loggedinAccountName);
	}

}
