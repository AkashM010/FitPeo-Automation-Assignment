package FitPeo.Assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CPTCodePageObect extends ReusableComponent {

	// Constructor to initialize WebDriver
	public CPTCodePageObect(WebDriver driver) {
		this.driver = driver;
	}
	
	// Array of target CPT codes to be selected
	String[] targetCptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
	
	// Locators for CPT code blocks, individual CPT codes, and checkboxes
	By cptBlocks = By.xpath("//div[contains(@class, 'MuiBox-root css-1eynrej')]"); // Locator for CPT blocks
	By cptcodelocator = By.xpath(".//p[contains(text(),'CPT-')]"); // Locator for CPT code text
	By checkboxlocator = By.xpath(".//input[@type='checkbox']"); // Locator for CPT checkboxes
	
	// Locator for the total recurring reimbursement value
	By recurringReimbursementLocator = By.xpath("//p[contains(text(), 'Total Recurring Reimbursement for all Patients Per Month:')]/p"); 
	
	
	// Method to select specific CPT codes by interacting with their checkboxes
	public void clickOnCPTCodeCheckbox() {
		// Retrieve all CPT code blocks
		List<WebElement> cptBlocksList = driver.findElements(cptBlocks);
		
		// Loop through the target CPT codes and select their checkboxes	
		for(String cptCode : targetCptCodes) {
			for(WebElement block : cptBlocksList) {
				WebElement cptCodeElement = block.findElement(cptcodelocator);
				String code = cptCodeElement.getText().trim();	// Retrieving the CPT codes from the Page
				
				// If the current block matches a target CPT code, click its checkbox
				if(code.equals(cptCode)) {
					WebElement checkbox = block.findElement(checkboxlocator);
					checkbox.click();
				}
			}
		}
	}
	
	// Retrieve the recurring reimbursement value displayed on the page
	public String recurringReimbursementValue() {
		WebElement RecurringReimbursementElement = driver.findElement(recurringReimbursementLocator);
		return RecurringReimbursementElement.getText().trim();
	}
}
