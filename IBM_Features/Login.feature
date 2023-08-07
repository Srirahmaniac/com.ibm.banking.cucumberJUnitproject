Feature: Login functionality

@ibm_sanity
Scenario: Successful Login with Valid Credentials 
    
    Given  		  User Launch Chrome browser 
    When        User opens URL "http://admin-demo.nopcommerce.com/login" 
    And         User enters Email as "admin@yourstore.com" and Password as "admin" 
    And         Click on Login 
    Then        Page Title should be "Dashboard / nopCommerce administration" 
    When        User click on Log out link 
    Then        Page Title should be "Your store. Login" 
    And         close browser
    
    
@ibm_regression
Scenario Outline: Successful Login with Multiple User Credentials 
    
    Given   User Launch Chrome browser 
    When        User opens URL "http://admin-demo.nopcommerce.com/login" 
    And         User enters Email as "<email>" and Password as "<pass>" 
    And         Click on Login 
    Then        Page Title should be "Dashboard / nopCommerce administration" 
    When        User click on Log out link 
    Then        Page Title should be "Your store. Login" 
    And         close browser 
    
    
Examples:

|email                      | pass                          |
|admin@yourstore.com        | admin                         |
|admin123@yourstore.com     | admin123                      |

    