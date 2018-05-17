package calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(plugin = {"pretty",
        "html:build/cucumber.html", "json:build/cucumber.json"},
        glue = "com.ca.awesometestreport.log4jappender")
@RunWith(Cucumber.class)
public class Log4jAppenderCucumberRunnerTest {
}
