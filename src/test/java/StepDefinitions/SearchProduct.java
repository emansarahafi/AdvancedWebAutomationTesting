package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchProduct {
	WorkingWithEdge connection = new WorkingWithEdge();

	@Given("user is on homee page")
	public void user_is_on_homee_page() {
		connection.invokeBrowser();
	}

	@When("user enters laptop name")
	public void user_enters_laptop_name() {
		WebElement searchbox = connection.driver.findElement(By.tagName("input"));
		searchbox.sendKeys("mac");

	}

	@And("user clicks enter")
	public void user_clicks_enter() {
		WebElement srchBtn = connection.driver.findElement(By.tagName("button"));
		srchBtn.click();
	
	}

	@Then("user is navigated to search results page")
	public void user_is_navigated_to_search_results_page() {
		String actualTitle = connection.driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Résultats de recherche pour : 'mac'" ;
		assertEquals( expectedTitle, actualTitle);
	}
}
