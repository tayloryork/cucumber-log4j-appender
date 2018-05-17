package calculator;

import com.ca.awesometestreport.log4jappender.CurrentScenarioSingleton;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyStepDefs {
    Logger LOGGER = LoggerFactory.getLogger(MyStepDefs.class);

    private Calculator calculator;
    private Integer lastAnswer = null;
    private Exception exceptionCaught;

    public MyStepDefs() {
        LOGGER.trace("MyStepDefs Constructor");

        Runtime.getRuntime().addShutdownHook(new Thread(() -> LOGGER.info("Runtime Shutdown Hook is running! (Created by MyStepDefs constructor)")));
    }

    @Before
    public void beforeCucumber(Scenario scenario) {
        LOGGER.info("In @Before");
    }

    @After
    public void afterCucumber(Scenario scenario) {
        LOGGER.info("In @After");
    }

    @Given("^I have a new calculator$")
    public void iHaveANewCalculator() throws Throwable {
        LOGGER.info("Creating a new Calculator");
        calculator = new Calculator();
        LOGGER.debug("New Calculator created: " + calculator.toString() + "");
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void iAddAnd(Integer arg0, Integer arg1) throws Throwable {
        LOGGER.info("Adding {} and {}", arg0, arg1);
        lastAnswer = calculator.add(arg0, arg1);
    }

    @Then("^I should have (\\d+)$")
    public void iShouldHave(Integer arg0) throws Throwable {
        LOGGER.info("Asserting {} should be {}", lastAnswer, arg0);
        Assert.assertEquals(arg0, lastAnswer);
    }

    @When("^I divide (\\d+) by (\\d+)$")
    public void iDivideBy(int arg0, int arg1) throws Throwable {
        LOGGER.info("Dividing {} by {}", arg0, arg1);
        exceptionCaught = null;
        try {
            calculator.divide(arg0, arg1);
        } catch (Exception e) {
            LOGGER.info("Caught exception when dividing!", e);
            exceptionCaught = e;
        }
    }

    @Then("^I should get an exception$")
    public void iShouldGetAnException() throws Throwable {
        Assert.assertNotNull("There should have been an exception!", exceptionCaught);
    }
}
