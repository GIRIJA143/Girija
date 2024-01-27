package actitime.testscript;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;

public class AlertHandling extends BaseClass {
	@Test
	public void handelAlert() throws EncryptedDocumentException, IOException {
		driver.findElement(By.cssSelector(".popup_menu_button.popup_menu_button_settings ")).click();
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
	//	Thread.sleep(2000);
		driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelSheet("Sheet1",0,1));
		driver.findElement(By.xpath("//input[@value='      Cancel      ']")).click();
		cu.getAlertText(driver);
		cu.getAlertCancel(driver);
	}

}