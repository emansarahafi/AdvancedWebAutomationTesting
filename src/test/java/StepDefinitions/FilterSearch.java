package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
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

public class FilterSearch {
	WorkingWithEdge connection = new WorkingWithEdge();
	@Given("user is searching for laptops")
	public void user_is_searching_for_laptops() {
		connection.invokeBrowser();
		WebElement categoriesButton = connection.driver.findElement(By.xpath("//*[@id=\"rw-menutop\"]/li[1]/a"));
		categoriesButton.click();
		WebElement informatiqueButton = connection.driver.findElement(By.xpath("//*[@id=\"rw-menutop\"]/li[1]/div/ul/li[1]/a"));
		informatiqueButton.click();
		WebElement laptopsButton = connection.driver.findElement(By.xpath("//*[@id=\"rw-menutop\"]/li[1]/div/ul/li[1]/div/div/div[1]/ul/li[1]/a"));
		laptopsButton.click();
	}

	@When("user selects the Asus brand")
	public void user_selects_asus_brand() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Wait<WebDriver> wait = new FluentWait<WebDriver>(connection.driver)
			       .withTimeout(Duration.ofSeconds(10L));
	    WebElement brandsButton = wait.until(new Function<WebDriver, WebElement>() {
		      public WebElement apply(WebDriver driver) {
		    	  return connection.driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div/div[2]/div/div[1]"));
		      }
		    });
		brandsButton.click();
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(connection.driver)
			       .withTimeout(Duration.ofSeconds(10L));
	    WebElement asusCheckbox = wait2.until(new Function<WebDriver, WebElement>() {
		      public WebElement apply(WebDriver driver) {
		    	  return connection.driver.findElement(By.xpath("//*[@id=\"manufacturerFilter_option_1\"]"));
		      }
		    });
		asusCheckbox.click();
	}

	@And("user selects the Windows 11 Pro operating system")
	public void select_windows_11_os() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Wait<WebDriver> wait = new FluentWait<WebDriver>(connection.driver)
			       .withTimeout(Duration.ofSeconds(10L));
	    WebElement osButton = wait.until(new Function<WebDriver, WebElement>() {
		      public WebElement apply(WebDriver driver) {
		    	  return connection.driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[9]"));
		      }
		    });
	    osButton.click();
		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(connection.driver)
			       .withTimeout(Duration.ofSeconds(10L));
	    WebElement win11Checkbox = wait2.until(new Function<WebDriver, WebElement>() {
		      public WebElement apply(WebDriver driver) {
		    	  return connection.driver.findElement(By.xpath("//*[@id=\"systeme_d_exploitationFilter_option_39\"]"));
		      }
		    });
	    win11Checkbox.click();
	}

	@Then("user sees the Asus Expertbook B5")
	public void user_sees_asus_expertbook() {
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement firstProduct = connection.driver.findElement(By.className("product-item-link"));
		String firstProductTitle = firstProduct.getText();
		System.out.println(firstProductTitle);
		String expectedProductTitle = "PC Portable ASUS ExpertBook B5 i7 13è Gén 16Go 1To SSD - Noir";
		assertEquals( firstProductTitle, expectedProductTitle);
	}
}
