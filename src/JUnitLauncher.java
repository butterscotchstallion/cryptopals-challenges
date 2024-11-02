import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;
import static org.junit.platform.launcher.EngineFilter.includeEngines;

public class JUnitLauncher {

    @Test
    public void launchTests() {
        // Create a SummaryGeneratingListener to collect test execution summary
        SummaryGeneratingListener listener = new SummaryGeneratingListener();

        // Create a request to discover tests
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(
                        selectPackage("test")  // Select package
                )
                .filters(
                        includeEngines("junit-jupiter")  // Include only JUnit Jupiter engine
                )
                .build();

        // Get the Launcher instance and execute the request
        Launcher launcher = LauncherFactory.create();
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        // Print the test summary
        PrintWriter writer = new PrintWriter(System.out, true); // Wrap System.out in PrintWriter
        listener.getSummary().printTo(writer);
    }
}