import com.epam.tat.module4.Calculator;
import com.google.inject.Inject;
import dataproviders.DataProviderClass;
import org.testng.Assert;
import org.testng.annotations.Test;


public class UnitTestsValidation extends BaseTest {

    @Inject
    Calculator calculator;

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "getData", groups = "positive")
    public void testAdd(int[][] objects) {
        long result = calculator.sum(objects[0][0], objects[0][1]);
        Assert.assertEquals(result, 3, "Addition failed");
    }

    @Test(groups = "positive")
    public void testSubtract() {
        double result = calculator.sub(5, 3);
        Assert.assertEquals(result, 2.0, "Subtraction failed");
    }

    @Test(groups = "positive")
    public void testMultiply() {
        long result = calculator.mult(4, 2);
        Assert.assertEquals(result, 8, "Multiplication failed");
    }

    @Test(groups = "positive")
    public void testDivide() {
        double result = calculator.div(10, 2);
        Assert.assertEquals(result, 5.0, "Division failed");
    }


    @Test(groups = "positive")
    public void testDivideWithPositive() {
        long result = calculator.div(10, 5);
        Assert.assertEquals(result, 2, "Division failed");
    }

    // Negative Test Cases
    @Test(expectedExceptions = NumberFormatException.class, groups = "negative")
    public void testDivideByZero() {
        calculator.div(10, 0);
    }

    @Test(groups = "negative")
    public void testAddNegative() {
        long result = calculator.sum(-2, -3);
        Assert.assertEquals(result, -5, "Negative addition failed");
    }

    @Test(dataProviderClass = DataProviderClass.class, dataProvider = "getData", groups = "negative")
    public void testSubtractNegative(int[][] objects) {
        long result = calculator.sub(objects[0][0], objects[0][1]);
        Assert.assertEquals(result, -1, "Negative subtraction failed");
    }

    @Test(groups = "negative")
    public void testMultiplyNegative() {
        double result = calculator.mult(-2, 3);
        Assert.assertEquals(result, -6.0, "Negative multiplication failed");
    }

    @Test(groups = "negative")
    public void testDivideNegative() {
        double result = calculator.div(-10, 2);
        Assert.assertEquals(result, -5.0, "Negative division failed");
    }
}
