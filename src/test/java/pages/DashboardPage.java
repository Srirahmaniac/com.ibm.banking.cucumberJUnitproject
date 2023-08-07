package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {
	
	
	 WebDriver driver;

		public DashboardPage(WebDriver driver) {

			this.driver = driver;
			
			PageFactory.initElements(driver, this);

		}
		
		@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
		WebElement txt_pageHeader;
		
		
		public void verifyPageHeader(String expectedTitle) throws InterruptedException {
			
			Thread.sleep(3000);
			Assert.assertEquals(txt_pageHeader.getText(), expectedTitle);
			
		}

}
