package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout {

	WorkingWithEdge connection = new WorkingWithEdge();

	@Given("user is loggedin")
	public void user_is_loggedin() {
		connection.invokeBrowser();
		WebElement connectionLink = connection.driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]/a"));
		connectionLink.click();
		WebElement inputEmail = connection.driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement inputPassword = connection.driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		inputEmail.sendKeys("gbcblppabzutidngdk@ckptr.com");
		inputPassword.sendKeys("TestingLab5");
		WebElement submitButton = connection.driver.findElement(By.xpath("//*[@id=\"send2\"]"));
		submitButton.click();

	}

	@When("user redirects to his account page")
	public void user_redirects_to_his_account_page() {
		WebElement submitButton = connection.driver
				.findElement(By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]/a"));
		submitButton.click();

	}

	@And("clicks on logout button")
	public void clicks_on_logout_button() {
		//waiting
		Wait<WebDriver> wait = new FluentWait<WebDriver>(connection.driver)
			       .withTimeout(Duration.ofSeconds(10L));
	    // bypass because the link is not clickable with xpath (not visible unless hover)
	    By css = By.cssSelector("a[href='https://www.mytek.tn/customer/account/logout/']");
	    
	    
	    // Wait until the element is found using a custom function
	    WebElement logoutButton = wait.until(new Function<WebDriver, WebElement>() {
	      public WebElement apply(WebDriver driver) {
	        return driver.findElement(css);
	      }
	    });

	    ((JavascriptExecutor) connection.driver).executeScript("arguments[0].click();", logoutButton);
	  }


	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		// page title is null if logout successful so we check url
		String actualURL = connection.driver.getCurrentUrl();
		String expectedURL = "https://www.mytek.tn/customer/account/logoutSuccess/";
		assertEquals(expectedURL, actualURL);
	}

}
