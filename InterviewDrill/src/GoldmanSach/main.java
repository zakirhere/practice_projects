package GoldmanSach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class main {

	public static WebDriver myDriver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main myObject = new main();
		myObject.openApplication();
		
		dropdownValues ddObj = new dropdownValues();
		//ddObj.printAllValues(myDriver);
		
		ddObj.selectdropdownItem(myDriver, 2);
		ddObj.selectedValues(myDriver);
		
		ddObj.selectdropdownItem(myDriver, "english");
		ddObj.selectedValues(myDriver);
		
		myObject.closeApplication();
	}

	public void openApplication() {
		myDriver = new FirefoxDriver();
		myDriver.get("http://newyork.craigslist.org/");
	}
	
	public void closeApplication() {
		myDriver.close();
	}
}
