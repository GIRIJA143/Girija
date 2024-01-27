package actitime.testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import actitime.genericLib.BaseClass;

public class DropDownHandling extends BaseClass {
		@Test
		public void handleDropdown() {
			
			driver.findElement(By.className("popup_menu_button_settings")).click();
			driver.findElement(By.xpath("//div[contains(text(),'Manage system settings')]/..")).click();
	        WebElement war= driver.findElement(By.id("firstHierarchyLevelCodeSelect"));
	        cu.dropDownSelectByVisibleText(war, "Product Line");
	        String msg=  driver.findElement(By.id("FormModifiedTextCell")).getText();
	        System.out.println(msg);
		}

	}