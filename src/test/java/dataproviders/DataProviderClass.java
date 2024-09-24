package dataproviders;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider
    public int[][] getData() {
        return new int[][]{
                {1, 2}
        };
    }

}
