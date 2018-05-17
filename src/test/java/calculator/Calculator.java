package calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
    Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    public Calculator() {
        LOGGER.trace("Calculator Constructor");
    }

    public int add(int arg0, int arg1) {
        LOGGER.debug("Adding '{}' and '{}'", arg0, arg1);
        int answer = arg0 + arg1;
        LOGGER.trace("Adding answer: {}", answer);
        return answer;
    }

    public int divide(int arg0, int arg1) throws Exception {
        LOGGER.debug("Dividing '{}' by '{}'", arg0, arg1);
        if (arg1 == 0) {
            throw new Exception("Cannot divide '" + arg0 + "' by 0!");
        }
        int answer = arg0 / arg1;
        LOGGER.trace("Dividing answer: {}", answer);
        return answer;
    }
}
