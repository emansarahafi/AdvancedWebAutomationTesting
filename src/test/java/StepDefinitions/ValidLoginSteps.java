package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidLoginSteps {
	WorkingWithEdge connection = new WorkingWithEdge();
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() {
		connection.invokeBrowser();
		WebElement connectionLink = connection.driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]/a"));
		connectionLink.click();
		
	}

	@When("user enters correct email and password")
	public void user_enters_correct_email_and_password() {
		WebElement inputEmail = connection.driver.findElement(By.xpath("//*[@id=\"email\"]"));
		WebElement inputPassword = connection.driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		inputEmail.sendKeys("gbcblppabzutidngdk@ckptr.com");
		inputPassword.sendKeys("TestingLab5");

	}

	@And("clicks on login button")
	public void clicks_on_login_button() {
		//waiting
		Wait<WebDriver> wait = new FluentWait<WebDriver>(connection.driver)
					       .withTimeout(Duration.ofSeconds(10L));
		
		//WebElement submitButton = connection.driver.findElement(By.xpath("//*[@id=\"send2\"]"));
	    // Wait until the element is found using a custom function
	    WebElement submitButton = wait.until(new Function<WebDriver, WebElement>() {
	      public WebElement apply(WebDriver driver) {
	        return driver.findElement(By.xpath("//*[@id=\"send2\"]"));
	      }
	    });
		submitButton.click();	
	}

	@Then("user is navigated to home page")
	public void user_is_navigated_to_home_page() {
		String actualTitle = connection.driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Vente en ligne Pc portable, Smartphone, TV LED Tunisie" ;
		assertEquals( expectedTitle, actualTitle);
	}

}
