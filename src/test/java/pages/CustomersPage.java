package pages;

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
	WebElement rootlink_Customers;
	
	@FindBy(xpath = "(.//li[@class='nav-item']/a//*[contains(text(),'Customers')])[position()=1]")
	WebElement sublink_Customers;
	
	@FindBy(xpath = "//h1[contains(text(),'Customers')]")
	WebElement txt_pageHeader;
	
	@FindBy(css = "input#SearchEmail")
	WebElement txt_emailSearchBox;
	
	@FindBy(css = "button#search-customers")
	WebElement btn_search;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollHeadInner']/table//th")
	WebElement table_columnHeaders;
	
	@FindBy(xpath = "//div[@class='dataTables_scrollBody']/table//tbody/tr/td")
	WebElement table_filteredRecords;
	
	@FindBy(css = "div#customers-grid_info")
	WebElement scroll_page;
	
	// Methods/Action
	
	public void clicksCustomersMenu() {
		
		Actions action = new Actions(driver);
		action.click(rootlink_Customers).click(sublink_Customers).build().perform();
	}
	
	public void verifyPageHeader(String expectedTitle) throws InterruptedException {
		
		Thread.sleep(3000);
		Assert.assertEquals(txt_pageHeader.getText(), expectedTitle);
		
	}
	
	public void searchByEmail(String email) throws InterruptedException {
		
		txt_emailSearchBox.clear();
		txt_emailSearchBox.sendKeys(email);
		Thread.sleep(3000);
		btn_search.click();
		
	}
	
	
	public void verifySearchResult(String SearchNames) {
		
		JavascriptExecutor  js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView()", scroll_page);
		
	}
	
	
	
}
