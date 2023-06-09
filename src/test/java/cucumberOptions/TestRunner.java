package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src//test//java//Features",
		glue="stepDefinations",
		dryRun = false,
		monochrome = true,
		plugin={"pretty","html:target/cucumber-reports.html"}
		)
public class TestRunner {

}
