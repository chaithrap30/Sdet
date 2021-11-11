package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.genericutils.FileUtility;

public class tc1 {
	public static void main(String[] args) throws Throwable
	{
		FileUtility fu=new FileUtility();
		//WebDriverUtility wu=new WebDriverUtility();
		WebDriver driver=new ChromeDriver();
	   // wu.maximizeWindow(driver);
		//wu.waitUntilPageLoad(driver);
		String URL = fu.getPropertykeyValue("url");
		//WebDriver driver=null;
		//if(Browser.equalsIgnoreCase("chome"))
		{
			driver=new ChromeDriver();
		}
		//else if(Browser.equalsIgnoreCase("IE"))
		{
		//	driver=new InternetExploreDriver();
		}
		driver.get(URL);
		String USERNAME = fu.getPropertykeyValue("username");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		String PASSWORD = fu.getPropertykeyValue("password");
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String organizationName = fu.getPropertykeyValue("OrganizationName");
		driver.findElement(By.name("accountname")).sendKeys(organizationName);
		String WEBSITE = fu.getPropertykeyValue("Website");
		driver.findElement(By.name("website")).sendKeys(WEBSITE);
		String PHONE = fu.getPropertykeyValue("Phone");
		driver.findElement(By.id("phone")).sendKeys(PHONE);
		driver.findElement(By.name("button")).click();
		String TITLE1 = fu.getPropertykeyValue("title1");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,TITLE1);
		driver.close();
	}
}


}
