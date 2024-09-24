package guice;

import com.epam.tat.module4.Calculator;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;

public class TestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Calculator.class);
    }
}
