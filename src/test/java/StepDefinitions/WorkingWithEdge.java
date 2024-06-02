package StepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithEdge {

    public ChromeDriver driver;

    String driverPath = "/Users/emansarahafi/Downloads/chromedriver-mac-x64/chromedriver";
    String url = "https://www.mytek.tn/";

    public void invokeBrowser() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
}
