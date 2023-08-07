package tests;

import org.junit.Test;

import pages.CustomersPage;
import pages.LoginPage;
import utility.Constants;

public class CustomersTest extends BaseTest {
	
		
		
	@Test
    public void verifyCustomersFeature() throws Exception {
		
		LoginPage lp = new LoginPage(driver);
		CustomersPage cp = new CustomersPage(driver);
        lp.enterEmail(Constants.username);
        lp.enterPassword(Constants.password);
        lp.clickReminderCheckbox();
        lp.clickLoginButton();
        lp.verifyApplicationTitle("Dashboard / nopCommerce administration");
        cp.clicksCustomersMenu();
        cp.verifyPageHeader("Customers");
        cp.searchByEmail(Constants.customer_mailId);
        cp.verifySearchResult(Constants.customer_name);
        
        
    }
	

}
