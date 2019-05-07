package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}, plugin = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, glue = "Steps")

public class TestRunner extends AbstractTestNGCucumberTests {
}