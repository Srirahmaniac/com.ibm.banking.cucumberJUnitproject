package pages;

import java.util.List;

import org.apache.velocity.runtime.directive.Foreach;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomersPage {
	
	
	 WebDriver driver;

	public CustomersPage(WebDriver driver) {

		this.driver = driver;
		
		PageFactory.initElements(driver, this);

	}
	
	// Identifications
	
	@FindBy(xpath = ".//li[@class='nav-item has-treeview']/a//*[contains(text(),'Customers')]")
	WebElement parentlink_Customers;
	
	@FindBy(xpath = "(.//li[@class='nav-item']/a//*[contains(text(),'Customers')])[position()=1]")
	WebElement childlink_Customers;
	
	@FindBy(xpath = "//h1[contains(text(),'Customers')]")
	WebElement txt_pageHeader;
	
	@FindBy(css = "input#SearchEmail")
	WebElement txt_emailSearchBox;
	
	@FindBy(css = "button#search-customers")
	WebElement btn_search;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table//th")
	WebElement table_columnHeaders;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollBody']/table//tbody/tr/td")
	WebElement table_filteredCustomer;
	
	@FindBy(css = "div#customers-grid_info")
	WebElement scrollPage_toCustomerTable;
	
	@FindBy(css = "input#SearchFirstName")
	WebElement txt_SearchFirstName;
	
	@FindBy(css = "input#SearchLastName")
	WebElement txt_SearchLastName;
	
	// Methods/Action
	
	public void clicksCustomersMenu() {
		
		Actions action = new Actions(driver);
		action.click(parentlink_Customers).click(childlink_Customers).build().perform();
	}
	
	public void verifyPageHeader(String expectedTitle) throws InterruptedException {
		
		Thread.sleep(3000);
		Assert.assertEquals(txt_pageHeader.getText(), expectedTitle);
		
	}
	
	public void searchByEnteringEmail(String email) throws InterruptedException {
		
		txt_emailSearchBox.clear();
		txt_emailSearchBox.sendKeys(email);
		Thread.sleep(3000);
		
		
	}
	
	public void clicksOnSearchButton() {
		
		btn_search.click();
	}
	
	
	public void verifySearchResult(String SearchByElement) throws InterruptedException {
		
		List<WebElement> customerdetails = driver.findElements(By.xpath("//div[@class='dataTables_scrollBody']/table//tbody/tr/td"));
		
		for(WebElement detail : customerdetails) {
			
			if(detail.getText().equalsIgnoreCase(SearchByElement)) {
				
				int indexOfElement = customerdetails.indexOf(detail);
				
				System.out.println("Index Of Element in records is " + indexOfElement);
				
				System.out.println("Element found in records is " + SearchByElement);
			}
			
		}
	}
	
	public void scrollToSearchResult() throws InterruptedException {
		
		Thread.sleep(3000);
		JavascriptExecutor  js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView()", scrollPage_toCustomerTable);
		
		
	}
	
	public void enterCustomerFirstName(String firstName) {
		
		txt_SearchFirstName.clear();
		txt_SearchFirstName.sendKeys(firstName);
		
	}
	
	public void enterCustomerLastName(String lastName) {
		
		txt_SearchLastName.clear();
		txt_SearchLastName.sendKeys(lastName);
		
	}
	
}
