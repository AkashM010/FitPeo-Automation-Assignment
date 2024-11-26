package FitPeo.Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SliderPageObject extends ReusableComponent{

	WebDriverWait wait;
	
	// Constructor to initialize the WebDriver and WebDriverWait
	public SliderPageObject(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	// Locators for slider elements
	By sliderLocator = By.xpath("//*[contains(@class,'MuiSlider-rail')]");	// Locator for the slider rail
	By rangeLocator = By.xpath("//input[@type='range']");  					// Locator for the slider range input
	By sliderTextFieldValueLocator = By.xpath("//input[@type='number']");	// Locator for the text field linked to the slider
	
	
	// Method to move the slider to a specific target value
	public void moveSlider(int targetValue) {
		WebElement sliderRail = wait.until(ExpectedConditions.visibilityOfElementLocated(sliderLocator));
		WebElement sliderRange = driver.findElement(rangeLocator);
		
		//Get slider properties
		int sliderWidth = sliderRail.getSize().getWidth();	// Width of the slider
	    int maxValue = Integer.parseInt(sliderRange.getAttribute("aria-valuemax")); // Maximum value of the slider

	    // Calculate the pixel offset based on the target value
	    double percent = (double) targetValue / maxValue; // Target position as a percentage
        int offset = (int) (percent * sliderWidth - (sliderWidth / 2)); // Calculate offset relative to center
	    
        // Move the slider using Actions
		Actions actions = new Actions(driver);
		actions.moveToElement(sliderRail, offset, 0).click().build().perform();
		
		// Adjust the slider to the precise value using arrow keys	
		String current_value = sliderRange.getAttribute("aria-valuenow");
		int current = Integer.parseInt(current_value);
		adjustSliderUSingKeys(current, targetValue, sliderRange);
	}
	
	// Helper method to fine-tune the slider value using keyboard keys
	private void adjustSliderUSingKeys(int current, int targetValue, WebElement sliderRange) {
		if(current<targetValue) {
			while(current<targetValue) {
				sliderRange.sendKeys(Keys.ARROW_UP);
				current++;
			}
		} else if (current>targetValue) {
			while(current>targetValue) {
				sliderRange.sendKeys(Keys.ARROW_DOWN);
				current++;
			}
		}
	}
	
	// Get the slider text field WebElement
	public WebElement sliderTextFieldElement() {
		WebElement textFieldElement = driver.findElement(sliderTextFieldValueLocator);
		return textFieldElement;
	}
	
	// Retrieve the current value from the slider text field
	public int getSliderTextFieldValue() {
		WebElement textfieldElement = driver.findElement(sliderTextFieldValueLocator);
		int textFieldValue = Integer.parseInt(textfieldElement.getAttribute("value"));
		
		return textFieldValue;
	}
	
	// Retrieve the current slider value
	public int getSliderValue() {
		WebElement sliderRange = driver.findElement(rangeLocator);
		
		int current_value = Integer.parseInt(sliderRange.getAttribute("aria-valuenow"));
		return current_value;
	}
	
}
