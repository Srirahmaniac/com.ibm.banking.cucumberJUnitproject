package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( 
        
        
                    features = ".\\IBM_Features\\Login.feature" ,  
                    glue = "stepDefinition",
                    monochrome = true, 
                    plugin = {"html: ibm_reports/TestResult.html"},
                   // tags = "@ibm_sanity"
                    tags = "@ibm_regression"
                  //tags= {"@sanity"},
                   // tags= {"@regression"}
                    //tags= {"@positive"},
                    //plugin= {"pretty","html: test-output"}
        
        
                )

public class TestRunner {
    
}