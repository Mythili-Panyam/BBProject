package Com.Test.BlueBadge.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Com.Test.BlueBadge.Base.BasePage;

public class ElementUtil extends BasePage{
	
WebDriver driver;
WebDriverWait wait;
JavaScriptUtil jsUtil;

public ElementUtil(WebDriver driver) {
	this.driver=driver;	
	wait=new WebDriverWait(driver,AppConstants.DEFAULT_TIME_OUT);
	jsUtil=new JavaScriptUtil(driver);
}
/**
 * This method is used to wait until the title is found
 * @param title
 * @return boolean
 */
public boolean doWaitForTitlePresent(String title) {
	wait.until(ExpectedConditions.titleIs(title));
	return true;
}
/**
 * This method is used to wait until the element is found on the basis of by locator
 * @param 
 * @return boolean
 */
public boolean doWaitForElementPresent(By locator) {
	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	return true;
}
/**
 * This method is used to get the title of the webpage
 * @param 
 * @return 
 */
public String doGetPageTitle() {
	try {
	return driver.getTitle();
	}catch(Exception e) {
		System.out.println("some exception got occured while getting the page title....");
	}
	return null;
}

/**
 * This method is used to find the webelement on the basis of by locator
 * @param locator
 * @return webelement
 */
public WebElement findWebElement(By locator) {
	WebElement element=null;
			try {
	if( doWaitForElementPresent(locator));
	element=driver.findElement(locator);
	if(highlightElement) {
		jsUtil.flash(element);
	}
			}catch(Exception e) {
				System.out.println("Some exception got occured while locating the webelement...");
			}
			return element;
	}
/**
 * This method is used to enter value into the field on the basis of by locators
 * @param locator,value
 * @return 
 */

public void doSendKeys(By locator, String value) {
	try {
	WebElement ele=findWebElement(locator);
	ele.clear();
	ele.sendKeys(value);
	}catch(Exception e) {
		System.out.println("Some exception got occured while entering the value into the field ....");
	}
}
/**
 * This method is used to click on the webelement on the basis of by locator
 * @param locator
 * @return 
 */
public void doClick(By locator) {
	try {
	findWebElement(locator).click();
	}catch(Exception e) {
		System.out.println("Some exception got occured while clicking on the webelement ....");
	}
}
/**
 * This method is used to click on the webelement on the basis of by locator
 * @param locator
 * @return 
 */
public boolean doIsDisplayed(By locator) {
	try {
	return findWebElement(locator).isDisplayed();
	}catch(Exception e) {
		System.out.println("some excepption got occured while verifying if the webelement is displayed or not....");
	}
	return false;
}
/**
 * This method is used to get the text of the webelement on the basis of by locator
 * @param locator
 * @return 
 * @return 
 */
public String doGetText(By locator) {
	try {
	return findWebElement(locator).getText();
	}catch(Exception e) {
		System.out.println("some exception got occured while getting the text.....");
	}
	return null;
}

}
