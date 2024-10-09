package guice;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import services.Calculator;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {

        bind(WebDriver.class).to(ChromeDriver.class).asEagerSingleton();
    }
}
