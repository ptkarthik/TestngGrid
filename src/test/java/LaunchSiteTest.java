import com.google.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LaunchSiteTest extends BaseTest {

    Logger logger= LogManager.getLogger(LaunchSiteTest.class);
    @Inject
    WebDriver driver;

    @Test
    public void RunSite() {
logger.info(driver.getTitle());
    }

}
