package stepDefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CustomersPage;
import pages.DashboardPage;
import utility.Constants;

public class CustomersSteps{
	
	
	
	CustomersPage cp = new CustomersPage(LoginSteps.driver);
	DashboardPage dp = new DashboardPage(LoginSteps.driver);
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboad() throws InterruptedException {
	    
		dp.verifyPageHeader("Dashboard");
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_Menu() {
	   
		cp.clicksCustomersMenu();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() {
	    
	
	}

	@Then("User can view Add new customer page")
	public void user_can_view_Add_new_customer_page() {
		
		
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		
		
	}

	@When("click on Save button")
	public void click_on_Save_button() {
		
		
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String string) {
		
		
	}

	@When("Enter customer eMail")
	public void enter_customer_EMail() throws InterruptedException {
	   
		cp.searchByEnteringEmail(Constants.customer_mailId);
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    
		cp.clicksOnSearchButton();
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_Email_in_the_Search_table() throws InterruptedException {
	    
		cp.scrollToSearchResult();
		cp.verifySearchResult(Constants.customer_mailId);
	}

	@And("Enter customer FirstName")
	public void enter_customer_FirstName() {
	    
		cp.enterCustomerFirstName("Victoria");
	}

	@And("Enter customer LastName")
	public void enter_customer_LastName() {
	   
		cp.enterCustomerLastName("Terces");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_Name_in_the_Search_table() throws InterruptedException {
	   
		cp.scrollToSearchResult();
		cp.verifySearchResult(Constants.customer_name);
	}

}
