package StepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenContactPage {
    WorkingWithEdge connection = new WorkingWithEdge();
    
    @Given("^user is on website$")
    public void user_is_on_the_website() {
        connection.invokeBrowser();
    }

    @When("user navigates to the contact page")
    public void user_navigates_to_service_client_page() {
        WebElement contactLink = connection.driver.findElement(By.xpath("//*[@id=\"html-body\"]/div[2]/footer/div/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/div/div[2]/ul/li[7]/a"));
        contactLink.click();
    }

    @Then("user should see the contact page loaded successfully")
    public void user_should_see_service_client_page_loaded_successfully() {
        String actualTitle = connection.driver.getTitle();
        String expectedTitle = "NOUS CONTACTER";
        assertEquals(expectedTitle, actualTitle);
    }
}
