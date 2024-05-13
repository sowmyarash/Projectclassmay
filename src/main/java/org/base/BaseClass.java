package org.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	//public static WebDriver chromeBrowser() {
		//WebDriverManager.chromedriver().setup();
		//return driver=new ChromeDriver();
		//}
	public static WebDriver browesrLaunch(String browserName) { 
	if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
	else if(browserName.equalsIgnoreCase("edge")) {
		 WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	}
return driver;
}
public static void urllaunch(String url) {
	driver.get(url);
	driver.manage().window().maximize();
	}
public static void implicityWait(int a) {
	driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
public static void sendKeys(WebElement e,String a) {
	e.sendKeys(a);
}
public static void click(WebElement e) {
	e.click();
}
public static String getCurrentUrl() {
	String currentUrl=driver.getCurrentUrl();
	return currentUrl;
	}
public static String getTitle() {
	String title=driver.getTitle();
	return title;
	}
public static void quit() {
	driver.quit();
}
public static String getAttribute(WebElement e) {
	String attribute=e.getAttribute("value");
	return attribute;
	}
public static void moveToElement(WebElement e) {
	Actions a=new Actions(driver);
	a.moveToElement(e).perform();
}
public static void dragAndDrop(WebElement src,WebElement tar) {
	Actions a=new Actions(driver);
	a.dragAndDrop(src, tar).perform();
	}
public static void selectByIndex(WebElement e,int index) {
	Select s=new Select(e);
	s.selectByIndex(index);
	}
public static void deSelectByValue(WebElement e,String value) {
	Select s=new Select(e);
	s.deselectByValue(value);
	}
public static void refresh() {
	driver.navigate().refresh();
}

}
