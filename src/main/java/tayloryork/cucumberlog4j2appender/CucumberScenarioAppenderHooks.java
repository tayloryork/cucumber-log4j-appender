package tayloryork.cucumberlog4j2appender;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CucumberScenarioAppenderHooks {

    /**
     * Setting the order to a low number means that it should be applied before
     * the user's @Before annotations.
     * @param scenario
     */
    @Before(order = 10)
    public void beforeCucumber(Scenario scenario) {
        CurrentScenarioSingleton.setCurrentScenario(scenario);
    }

    /**
     * Setting the order to a high number means that it should be applied after
     * the user's @After annotations.
     * @param scenario
     */
    @After(order = 990)
    public void afterCucumber(Scenario scenario) {
        CurrentScenarioSingleton.setCurrentScenario(scenario);
    }
}
