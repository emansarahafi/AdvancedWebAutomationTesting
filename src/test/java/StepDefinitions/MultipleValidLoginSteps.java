package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
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

public class MultipleValidLoginSteps {
    WorkingWithEdge connection = new WorkingWithEdge();
    List<Credentials> credentialsList = new ArrayList<>();
    int currentAttempt = 0;

    public MultipleValidLoginSteps() {
        // Add multiple sets of credentials
        credentialsList.add(new Credentials("gbcblppabzutidngdk@ckptr.com", "TestingLab5"));
        credentialsList.add(new Credentials("second@account.yes", "TestingLab5"));
    }

    @Given("^users are on login page$")
    public void user_is_on_login_page() {
        connection.invokeBrowser();
        WebElement connectionLink = connection.driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[2]/header/div[1]/div/ul/li[2]/a"));
        connectionLink.click();
    }

    @When("users enter correct email and password")
    public void user_enters_correct_email_and_password() {
        Credentials credentials = credentialsList.get(currentAttempt);
        WebElement inputEmail = connection.driver.findElement(By.xpath("//*[@id=\"email\"]"));
        WebElement inputPassword = connection.driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        inputEmail.sendKeys(credentials.getEmail());
        inputPassword.sendKeys(credentials.getPassword());
    }

    @And("click on login button")
    public void clicks_on_login_button() {
    	//waiting
    	Wait<WebDriver> wait = new FluentWait<WebDriver>(connection.driver)
    				       .withTimeout(Duration.ofSeconds(10L));
    	   
        //  WebElement submitButton = connection.driver.findElement(By.xpath("//*[@id=\"send2\"]"));
        // Wait until the element is found using a custom function
	    WebElement submitButton = wait.until(new Function<WebDriver, WebElement>() {
	      public WebElement apply(WebDriver driver) {
	        return driver.findElement(By.xpath("//*[@id=\"send2\"]"));
	      }
	    });
        submitButton.click();
    }

    @Then("users are navigated to home page")
    public void user_is_navigated_to_home_page() {
        String actualTitle = connection.driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Vente en ligne Pc portable, Smartphone, TV LED Tunisie";
        assertEquals(expectedTitle, actualTitle);

        // Move to the next set of credentials
        currentAttempt++;
        if (currentAttempt < credentialsList.size()) {
            // Refresh the page to simulate logging out
            connection.driver.navigate().refresh();
        }
    }

    private static class Credentials {
        private final String email;
        private final String password;

        public Credentials(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}
