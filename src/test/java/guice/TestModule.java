package guice;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import services.Calculator;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Calculator.class);
    }
}
