import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.TestModule;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static Injector injector;
    public BaseTest() {
        // Initialize the injector here
        injector = Guice.createInjector(new TestModule());
        injector.injectMembers(this);
    }
    @BeforeMethod
    public void setUp() throws Exception {

    }

    @AfterMethod
    public void tearDown() throws Exception {
    }
}
