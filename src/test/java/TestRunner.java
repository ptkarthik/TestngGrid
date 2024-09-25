

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();

        // List of TestNG XMLs to run
        List<String> suites = new ArrayList<>();
        suites.add("src/test/resources/testNGSuite.xml");

        testng.setTestSuites(suites);
        testng.run();
    }
}
