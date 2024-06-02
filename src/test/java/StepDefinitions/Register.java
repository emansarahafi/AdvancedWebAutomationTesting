package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.Random;
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

public class Register {
	WorkingWithEdge connection = new WorkingWithEdge();
	
	@Given("^user is on registration page$")
	public void user_is_on_registration_page() {
		connection.invokeBrowser();
		WebElement connectionLink = connection.driver.findElement(By.xpath("//*[@id=\"idUj5ox2IK\"]"));
		connectionLink.click();
	}

	@When("user enters correct credentials format")
	public void user_enters_correct_email_and_password() {
		WebElement inputFirstName = connection.driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		WebElement inputLastName = connection.driver.findElement(By.xpath("//*[@id=\"lastname\"]"));
		WebElement inputPhoneNumber = connection.driver.findElement(By.xpath("//*[@id=\"telephone\"]"));
		WebElement inputAddress = connection.driver.findElement(By.xpath("//*[@id=\"street_1\"]"));
		WebElement inputRegion= connection.driver.findElement(By.xpath("//*[@id=\"region\"]"));
		WebElement inputCity= connection.driver.findElement(By.xpath("//*[@id=\"city\"]"));
		WebElement inputEmail= connection.driver.findElement(By.xpath("//*[@id=\"email_address\"]"));
		WebElement inputPassword= connection.driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement inputConfirmPassword= connection.driver.findElement(By.xpath("//*[@id=\"password-confirmation\"]"));
		
		System.out.println(inputFirstName);
		
		inputFirstName.sendKeys("Ahmed");
		inputLastName.sendKeys("Abbes");
		inputPhoneNumber.sendKeys("94356248");
		inputAddress.sendKeys("Ariana, 3, Rue al nahli");
		inputRegion.sendKeys("Ariana");
		inputCity.sendKeys("ARIANA VILLE");
		
		inputEmail.sendKeys(randomLettersGeneration() + "@ckptr.com");
		inputPassword.sendKeys("TestingLab5");
		inputConfirmPassword.sendKeys("TestingLab5");
	}

	@And("clicks on register button")
	public void clicks_on_register_button() {
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

	@Then("user is navigated to account page")
	public void user_is_navigated_to_account_page() {
		String actualTitle = connection.driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Mon compte" ;
		assertEquals( expectedTitle, actualTitle);
	}
	
	public String randomLettersGeneration() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
    
        for (int i = 0; i < 7; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        
        String randomString = sb.toString();
        return randomString;
	}

}
