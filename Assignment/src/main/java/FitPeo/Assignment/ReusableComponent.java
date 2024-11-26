package FitPeo.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReusableComponent {

	WebDriver driver;
	
	// Method to initialize the WebDriver (e.g., ChromeDriver in this case)
	public WebDriver getDriver() {
		driver = new ChromeDriver();
		return driver;
	}
	
	// Launch the application with a specified URL
	public void launchApp() {
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
	}
	
	// Quit the WebDriver and close the browser
	public void quit() {
		driver.quit();
	} 
}
