package actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;
    
    //@Listeners(actitime.genericLib.ListenerImplementation.class)
	public class CustomerCreation extends BaseClass {

		@Test
		
		    public void createCustomer() throws EncryptedDocumentException, IOException  {
			
			String customername=du.getDataFromExcelSheet("Sheet1",0,1);
			String description=du.getDataFromExcelSheet("Sheet1", 1, 1);
			int num=cu.getRandomNum();
			customername=customername+num;
			driver.findElement(By.id("container_tasks")).click();
			driver.findElement(By.className("ellipsis")).click();
			driver.findElement(By.className("createNewCustomer")).click();
			driver.findElement(By.className("inputNameField")).sendKeys(customername);
			driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys(description);
			driver.findElement(By.xpath("//div[text()='Create Product']")).click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".titleEditButtonContainer>.title"),customername));
			String expCustomername=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
			System.out.println(expCustomername);
		}
	}