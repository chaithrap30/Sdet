package com.genericutils;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {

	//this method wait for 20sec for page loading
		//@param driver 
		public void waitUntilPageLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		//this method wait for the element to be visible
		//@param driver
		//@param element 
		public void waitForElementVisibility(WebDriver driver, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		public void waitAndClick(WebElement element) throws Throwable 
		{
			int count=0;
			while(count<40)
			{
			try 
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
			}
		}
		//this method enables user to handle dropdown using visible text 
		
		public void SelectOption(WebElement element, String option)
		{
			Select select=new Select(element);
			select.selectByVisibleText(option);
		}
		
		//this method enables user to handle dropdown using index
		public void SelectOption(WebElement element, int index)
		{
			Select select=new Select(element);
			select.selectByIndex(index);
		}
		//this method to perform mouse over action 
		public void mouseOver(WebDriver driver, WebElement element)
	    {
	        Actions a=new Actions(driver);
	     a.moveToElement(element).perform();
	    }
		//this method to perform right click operation
		public void rightClick(WebDriver driver, WebElement element)
		{
			Actions a=new Actions(driver);
			a.contextClick(element).perform();
		}
		//this method to switch from one window to another 
		public void switchToWindow(WebDriver driver, String partialWinTitle)
		{
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while(it.hasNext())
		{
			String winId=it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle))
			{
				break;
			}
		}
		
		}
		public void acceptAlert(WebDriver driver)
		{
		driver.switchTo().alert().accept();	
		}
	    //cancel alert
		public void cancelAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		// method for scrolling action on the web page
		public void scrillToWebElement(WebDriver driver, WebElement element)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			int y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")",element);
		}
		public void switchFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		public void switchFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		public void switchFrame(WebDriver driver, String idOrName)
		{
			driver.switchTo().frame(idOrName);
		}
		public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable 
		{
			String screenshotPath="./screenshot/"+screenshotName+JavaUtility.getCurrentDate()+".PNG";
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(screenshotPath);
			Files.copy(src,dest);
			return screenshotPath;
		}

	/*	public void pressEnterKey()
		{
			Robot rc=new Robot();
			rc.keyPress(KeyEvent.VK_ENTER);
			rc.keyRelease(KeyEvent.VK_ENTER);
		}*/
			
	}
