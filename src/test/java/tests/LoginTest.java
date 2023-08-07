package tests;
import org.junit.Test;
import pages.LoginPage;
import utility.Constants;

public class LoginTest extends BaseTest {

	 
    
    @Test
    public void verifyLoginFeature() throws Exception {
        
    	LoginPage lp = new LoginPage(driver);
      
        lp.enterEmail(Constants.username);
        lp.enterPassword(Constants.password);
        lp.clickReminderCheckbox();
        lp.clickLoginButton();
        
        
        //verify post login title
        lp.verifyApplicationTitle("Dashboard / nopCommerce administration");
        
        lp.clickLogoutButton();
        
        //verify login page title
        lp.verifyApplicationTitle("Your store. Login");
        
    }
    
    
    
}
