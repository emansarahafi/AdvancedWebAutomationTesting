package StepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/emansarahafi/Downloads/AdvancedWebAutomationTesting/src/test/resources/Features",
glue = "StepDefinitions",
monochrome = true,
plugin = {"pretty", "html:target/HtmlReports/report.html"},
tags = "@smoketest")
public class TestRunner {
	


}
