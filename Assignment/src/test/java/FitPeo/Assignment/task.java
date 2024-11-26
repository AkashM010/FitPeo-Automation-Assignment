package FitPeo.Assignment;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class task {

	WebDriver driver;                        // WebDriver instance for browser interactions
    ReusableComponent component;            // Reusable component for common setup tasks
    CPTCodePageObect cptCodePage;           // Page object for CPT Code interactions
    SliderPageObject sliderPage;            // Page object for slider interactions
    RevenueCalculatorPage revenuePage;      // Page object for Revenue Calculator navigation
    JavascriptExecutor js;                  // JavaScript Executor for advanced DOM manipulations
    SoftAssert assertion = new SoftAssert(); // SoftAssert for flexible assertion handling
    Actions action;                         // Actions instance for complex user interactions
	
	@BeforeTest
	public void setup() {
		//Initialize the reusable component and driver
		component = new ReusableComponent();
		driver = component.getDriver();
		
		//Initialize the Page Object classes
		js = (JavascriptExecutor) driver;
		revenuePage = new RevenueCalculatorPage(driver);
		cptCodePage = new CPTCodePageObect(driver);
		sliderPage = new SliderPageObject(driver);
		component.launchApp();
		
		//Initialize Actions
		action = new Actions(driver);
	}
	
	@AfterTest
	public void teardown() {
		//Quit the browser session
		component.quit();
	}
	
	@Test (priority = 0)
	public void navigateToRevenueCalculator() {
		//Navigate to the Revenue Calculator page using the page object
		revenuePage.navigateToRevenueCalculator();
		System.out.println("Successfully navigated to Revenue Calculator page.");
	}
	
	@Test (priority = 1)
	public void validateSliderUpdatesWithMovement() {
		//move the slider to the target value
		sliderPage.moveSlider(820);
		
		//validate if the slider value matches with the text field value
		int sliderValue = sliderPage.getSliderValue(); // Retrieve the Slider value
        int textFieldValue = sliderPage.getSliderTextFieldValue(); //Retrieve the Text Field value
		assertion.assertEquals(sliderValue, textFieldValue, "Slider value does not match text field value.");
		System.out.println("Slider correctly updated to: " +sliderValue);
				
	}
	
	@Test(priority = 2)
	public void updateSliderThroughTextField() throws Exception {
		// Click the text field and clear existing value
		sliderPage.sliderTextFieldElement().click();	// Click on the text field
		js.executeScript("arguments[0].value = '';", sliderPage.sliderTextFieldElement());	// Clear the text field value
		
		// Update the text field value to 560
		sliderPage.sliderTextFieldElement().sendKeys("560");
		
		// Validate if the slider value is updated to match the text field value
		int sliderValue = sliderPage.getSliderValue(); // Retrieve the Slider value
        int textFieldValue = sliderPage.getSliderTextFieldValue(); //Retrieve the Text Field value
        assertion.assertEquals(sliderValue, textFieldValue, "Slider value did not update correctly from text field input.");	// Validating the slider value with the text field value
        System.out.println("Slider value: " + sliderValue + ", Text field value: " + textFieldValue);

        assertion.assertAll();
	}
	
	
	@Test (priority = 3)
	public void validatingTotalRecurringReimbursement() {
		//Set slider value to 820 and select CPT Codes
		js.executeScript("arguments[0].value = '';", sliderPage.sliderTextFieldElement());	// Clear the text field value
		sliderPage.sliderTextFieldElement().sendKeys("820");	// Update the text field to 820
		cptCodePage.clickOnCPTCodeCheckbox();   //Select the relevant CPT codes
			
		//Validate the Total Recurring Reimbursement value
		String expectedValue = "$110700"; //Expected reimbursement value
		String actualValue = cptCodePage.recurringReimbursementValue(); //Retrieve the actual value displayed on the page
		assertion.assertEquals(actualValue, expectedValue, "Total Recurring Reimbursement value does not match.");	// Validating the Total Recurring Reimbursement value 
		if (actualValue.equals(expectedValue)) {
	        System.out.println("Test Passed: The actual Total Recurring Reimbursement value matches the expected value: " + actualValue);
	    } else {
	        System.out.println("Test Failed: Expected value is " + expectedValue + ", but actual value is " + actualValue);
	    }
		
		assertion.assertAll();
	}
	

}
