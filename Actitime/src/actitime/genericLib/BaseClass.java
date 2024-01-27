package actitime.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public WebDriver driver;
	public static WebDriver listenerdriver;
	public DataUtility du=new DataUtility();
	public CommonUtility cu=new CommonUtility();
	
	@BeforeClass
	public void launchBrowser()
	{
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(opt);
		listenerdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	//@Parameters({"url","Username","Password"})
    @BeforeMethod
    public void login() throws IOException
    {
		driver.get(du.getDataFromProperties("url"));
		driver.findElement(By.id("username")).sendKeys(du.getDataFromProperties("username"));
		driver.findElement(By.name("pwd")).sendKeys(du.getDataFromProperties("password"));
		driver.findElement(By.id("loginButton")).click();
    }
    @AfterMethod
    public void logout()
    {
    	driver.findElement(By.id("logoutLink")).click();
    }
    @AfterClass
    public void closeBrowser() 
    {
    	driver.close();
    
     }

}