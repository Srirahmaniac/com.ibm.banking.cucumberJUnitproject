package tests;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Constants;

public class BaseTest {
    
    public WebDriver driver;
    
    
    @Before
    public void launchApp() {
        
        //WebDriverManager.chromedriver().setup();
    	System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Constants.nop_app); //https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        
    }

    
    
    @After
    public void closeApp() throws Exception {
        
        Thread.sleep(6000);
        
        driver.close();
        driver.quit();
        
    }
}


