package actitime.genericLib;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	public int getRandomNum()
	{
		Random r=new Random();
		int num=r.nextInt(10000);
		return num;
	}
    public String getAlertText(WebDriver driver) {
		
		Alert alt=driver.switchTo().alert();
		String msg=alt.getText();
		System.out.println(msg);
		return msg;
	}

	public void getAlertCancel(WebDriver driver) {
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
		
	}
	public void dropDownSelectByValue(WebElement dropdown,String num) 
    {
  	    Select s=new Select(dropdown);
        s.selectByValue(num);
    }          
  public void dropDownSelectByIndex(WebElement dropdown,int num) 
    {
        Select s=new Select(dropdown);
        s.selectByIndex(num);
    }                
  public void dropDownSelectByVisibleText(WebElement dropdown,String text) 
    {
  	    Select s=new Select(dropdown);
  	    s.selectByVisibleText(text);
	}
  public void textToBePresentWait(WebDriver driver,By locator,String text)
  {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	  wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
  }
  public void doubleClick(WebDriver driver,WebElement wb) 
  {
  	Actions act=new Actions(driver);
  	act.doubleClick(wb).perform();	
  }
public List<WebElement> getOptions(WebDriver driver,By locator) 
  {
  	WebElement mo =driver.findElement(locator);
		Select s=new Select(mo);
		List<WebElement> alloptions=s.getOptions();
		return alloptions;
  }
//public void moveToElement(WebDriver driver,WebElement wb) 
  {
  //	Actions act=new Actions(driver);
	//act.moveToElement(wb).perform();

}

}