import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import guice.TestModule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected static Injector injector;
    @Inject
    WebDriver driver;
    @Inject
    HomePageServices homePageServices;

    public BaseTest() {
        // Initialize the injector here
        injector = Guice.createInjector(new TestModule());
        injector.injectMembers(this);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        driver.manage().window().maximize();
        driver.get("https://amazon.in");
    }

    @AfterMethod
    public void tearDown() throws Exception {
//        driver.quit();
    }
}
