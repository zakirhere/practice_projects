package GoldmanSach;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class dropdownValues {

	public static By category = By.id("chlang");
	
	public void printAllValues(WebDriver myDriver) {
		WebElement elem = (WebElement) myDriver.findElement(category);
		java.util.List <WebElement> lists = elem.findElements(By.tagName("option"));
		for(WebElement element: lists)  
	    {
	        String var2 = element.getText();
	        System.out.println(var2);
	    }
	}
	
	public void printAllValues_2(WebDriver myDriver) {
		WebElement elem = (WebElement) myDriver.findElement(category);
		Select cat_dd = new Select(elem);
		cat_dd.getAllSelectedOptions();
	}
	
	public void selectdropdownItem(WebDriver myDriver, int selectIndex) {
		
		WebElement elem = myDriver.findElement(category);
		Select cat_dd = new Select(elem);
		cat_dd.selectByIndex(selectIndex);
		
	}
	
	public void selectdropdownItem(WebDriver myDriver, String selectName) {
		
		WebElement elem = myDriver.findElement(category);
		Select cat_dd = new Select(elem);
		cat_dd.selectByVisibleText(selectName);;
		
	}
	
	public void selectedValues(WebDriver myDriver) {
		WebElement elem = myDriver.findElement(category);
		Select cat_dd = new Select(elem);
		System.out.println(cat_dd.getFirstSelectedOption().getText());
	}
	
}
