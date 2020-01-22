package stepDefinitions;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepDefinitions {
	@Given("^I navigate to google page$")
	public void i_navigate_to_google_page() throws Throwable {
	    System.out.println("Given block");
	}
	
	@When("^I enter the search string as \"([^\"]*)\"$")
	public void i_enter_the_search_string_as(String searchText) throws Throwable {
	    System.out.println(searchText);
	}

	@When("^I click search button$")
	public void i_click_search_button() throws Throwable {
		System.out.println("Given block");
	}

	@Then("^I should see search list$")
	public void i_should_see_search_list() throws Throwable {
		System.out.println("Given block");
	}
	
	@When("^I enter the following search strings$")
	public void i_enter_the_following_search_strings(DataTable table) throws Throwable {
	    List<List<String>> data = table.raw();
	    System.out.println(data.get(0));
	    System.out.println(data.get(0));
	}
}
