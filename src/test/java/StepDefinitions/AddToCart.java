package StepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCart {
	WorkingWithEdge connection = new WorkingWithEdge();

	@Given("user is on home page")
	public void user_is_on_home_page() {
		connection.invokeBrowser();
	}

	@When("user searches for a product")
	public void user_searches_for_a_product() {
		WebElement searchbox = connection.driver.findElement(By.tagName("input"));
		searchbox.sendKeys("laptop");
		searchbox.sendKeys(Keys.ENTER);
	}

	@And("clicks on add to cart")
	public void clicks_on_add_to_cart() {
		WebElement addBtn = connection.driver
				.findElement(By.xpath("//*[@id=\"product-item-info_38847\"]/div[3]/div[2]/div/div[1]/form/button"));
		addBtn.click();
	}

	@Then("the cart content is updated")
	public void the_cart_content_is_updated() {
		// Check that the cart contains exactly one element
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement counter = connection.driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[2]/div[1]/a/span[2]/span[1]"));
		String actual = counter.getText();
		String expected = "1";
		assertEquals(expected, actual);

	}
}
