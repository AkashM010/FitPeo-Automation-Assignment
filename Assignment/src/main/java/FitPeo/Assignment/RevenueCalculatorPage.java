package FitPeo.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RevenueCalculatorPage {
	WebDriver driver;

    // Constructor to initialize WebDriver
    public RevenueCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for Revenue Calculator link
    By revenueCalculatorLink = By.xpath("//div[contains(text(),'Revenue Calculator')]");

    // Method to navigate to Revenue Calculator page
    public void navigateToRevenueCalculator() {
        WebElement link = driver.findElement(revenueCalculatorLink);
        link.click();
    }
}
