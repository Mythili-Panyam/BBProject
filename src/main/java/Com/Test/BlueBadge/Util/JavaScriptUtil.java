package Com.Test.BlueBadge.Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	WebDriver driver;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver=driver;
	}
	
	public void refreshBrowserByJS() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
		}
	public String getBrowserInfoByJS() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
	String uAgent=js.executeScript("return navigator.userAgent").toString();
	return uAgent;
	}
	public String getPageInnerTextByJS() {
		JavascriptExecutor js=((JavascriptExecutor)driver);	
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;	
	}
	public void flash(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolour=element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element);//1
			changeColor("bgcolor",element);//2
			}
	}
	public void changeColor(String color,WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		try {
			Thread.sleep(20);
		}catch(InterruptedException e) {
			
		}
		}
	public void drawBorder(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'",element);
	}
	public void scrollPageDown() {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		}
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
		}
	
	
}
