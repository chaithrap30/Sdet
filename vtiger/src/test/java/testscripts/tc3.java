package testscripts;

import testscript.ChromeDriver;
import testscript.FileUtility;
import testscript.WebDriver;
import testscript.WebDriverUtility;
import testscript.WebElement;

public class tc3 {
	FileUtility fu=new FileUtility();
	WebDriverUtility wu=new WebDriverUtility();
	WebDriver driver=new ChromeDriver();
    wu.maximizeWindow(driver);
	wu.waitUntilPageLoad(driver);
	String URL = fu.getPropertyKeyValue("url");
	driver.get(URL);
	String USERNAME = fu.getPropertyKeyValue("username");
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	String PASSWORD = fu.getPropertyKeyValue("password");
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	String organizationName = fu.getPropertyKeyValue("organizationName");
	driver.findElement(By.name("accountname")).sendKeys(organizationName);
	String WEBSITE = fu.getPropertyKeyValue("website");
	driver.findElement(By.name("website")).sendKeys(WEBSITE);
	String PHONE = fu.getPropertyKeyValue("phone");
	driver.findElement(By.id("phone")).sendKeys(PHONE);
	driver.findElement(By.name("industry")).click();
	WebElement drpdwn = driver.findElement(By.name("industry"));
	wu.SelectOption(drpdwn,"Government");
	driver.findElement(By.name("rating")).click();
	WebElement drpdwn1 = driver.findElement(By.name("rating"));
	wu.SelectOption(drpdwn1,"Active");
	driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
	driver.findElement(By.xpath("//select[@name='assigned_group_id']")).click();
	WebElement drpdwn2 = driver.findElement(By.xpath("//select[@name='assigned_group_id']"));
	wu.SelectOption(drpdwn2,"Support Group");
	driver.findElement(By.name("button")).click();
	String title = driver.getTitle();
	System.out.println(title);
	String TITLE1 = fu.getPropertyKeyValue("title1");
	
	Assert.assertEquals(title,TITLE1);
	driver.close();		
	
}

}
