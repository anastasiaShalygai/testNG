
import org.testng.annotations.DataProvider;

/**
 * Created by Anastasiya on 02.04.2017.
 */
public class ComputerProvider {

    @DataProvider(name = "DataComputer")
    public static Object[][] createDataComputer() {
        return new Object[][]{
                {"Ноутбуки, планшеты"},
                {"Жесткие диски"},
                {"Мыши"},
        };
    }
}
