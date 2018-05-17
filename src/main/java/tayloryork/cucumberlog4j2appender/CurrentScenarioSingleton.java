package tayloryork.cucumberlog4j2appender;

import cucumber.api.Scenario;

/**
 * I hate statics more than anyone, but I don't know a better way to bridge Log4j & the user step definitions...
 * Maybe have a Spring, Pico, etc versions for people who want to use DI?
 */
public class CurrentScenarioSingleton {

    private static Scenario currentScenario = null;

    // never called
    private CurrentScenarioSingleton() {
    }

    public static Scenario getCurrentScenario() {
        return CurrentScenarioSingleton.currentScenario;
    }

    public static void setCurrentScenario(Scenario currentScenario) {
        CurrentScenarioSingleton.currentScenario = currentScenario;
    }
}
