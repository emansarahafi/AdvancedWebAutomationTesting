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

public class EditProfileSteps {

	WorkingWithEdge connection = new WorkingWithEdge();
	String old_name;
	@Given("user is logged in")
	public void user_is_logged_in() {
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

	@When("user goes to his edit account page")
	public void user_goes_to_his_edit_account_page() {
		//WebElement editBtn = connection.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/a[1]"));
		//editBtn.click();
		connection.driver.get("https://www.mytek.tn/customer/account/edit/");
	}

	@And("saves a new name")
	public void saves_a_new_name() {
		//waiting
		Wait<WebDriver> wait = new FluentWait<WebDriver>(connection.driver)
					       .withTimeout(Duration.ofSeconds(10L));
		
		
		//WebElement nameInput = connection.driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		
		// Wait until the element is found using a custom function
	    WebElement nameInput = wait.until(new Function<WebDriver, WebElement>() {
	      public WebElement apply(WebDriver driver) {
	        return driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
	      }
	    });
		old_name = nameInput.getAttribute("value");
		
		nameInput.clear();
		nameInput.sendKeys(old_name+"2");
		
		//WebElement saveBtn = connection.driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
		
		//not sure if we need to wait for these two as well or if waiting for the just the nameinput is enough
		// Wait until the element is found using a custom function
	    WebElement saveBtn = wait.until(new Function<WebDriver, WebElement>() {
	      public WebElement apply(WebDriver driver) {
	        return driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
	      }
	    });
		saveBtn.click();
		
		//WebElement editBtn = connection.driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/a[1]"));
		WebElement editBtn = wait.until(new Function<WebDriver, WebElement>() {
		      public WebElement apply(WebDriver driver) {
		        return driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/a[1]"));
		      }
		    });
		editBtn.click();
		
	}

	@Then("user sees the field updated")
	public void user_sees_the_field_updated() {
		//waiting
		Wait<WebDriver> wait = new FluentWait<WebDriver>(connection.driver)
					       .withTimeout(Duration.ofSeconds(10L));
		//WebElement nameInput = connection.driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
		
		 // Wait until the element is found using a custom function
	    WebElement nameInput = wait.until(new Function<WebDriver, WebElement>() {
	      public WebElement apply(WebDriver driver) {
	        return driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
	      }
	    });
		assertEquals( nameInput.getAttribute("value"), old_name+"2");
		//Clearing back the name to the old value so that we can actually compare with it next time we run the test
		nameInput.clear();
		nameInput.sendKeys(old_name);
		
		//@sahar might need to add another wait until here
		WebElement saveBtn = connection.driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button"));
		saveBtn.click();
	}

}
