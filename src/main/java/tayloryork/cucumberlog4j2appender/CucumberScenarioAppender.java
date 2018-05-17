package tayloryork.cucumberlog4j2appender;

import cucumber.api.Scenario;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.appender.AppenderLoggingException;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;

@Plugin(name = "CucumberScenarioAppender", category = "Core",
        elementType = "appender", printObject = false)
public class CucumberScenarioAppender extends AbstractAppender {

    @PluginFactory
    public static CucumberScenarioAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement("Layout") Layout<? extends Serializable> layout,
            @PluginElement("Filter") final Filter filter,
            @PluginAttribute("otherAttribute") String otherAttribute) {
        if (name == null) {
            LOGGER.error("No name provided for MyCustomAppenderImpl");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.createDefaultLayout();
        }
        return new CucumberScenarioAppender(name, filter, layout);
    }

    protected CucumberScenarioAppender(String name, Filter filter, Layout<? extends Serializable> layout) {
        super(name, filter, layout);
    }

    protected CucumberScenarioAppender(String name, Filter filter, Layout<? extends Serializable> layout,
                                       boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @Override
    public void append(LogEvent event) {
        try {
            Scenario currentScenario = CurrentScenarioSingleton.getCurrentScenario();
            if (currentScenario != null) {
                currentScenario.write(new String(getLayout().toByteArray(event)));
            }
        } catch (Exception e) {
            if (!ignoreExceptions()) {
                throw new AppenderLoggingException(e);
            }
        }

    }
}
