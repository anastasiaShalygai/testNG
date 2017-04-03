import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

/**
 * Created by Anastasiya on 30.03.2017.
 */
public class Demo {
    private WebDriver driver;
    private By xpathPcBlock = By.xpath("//*[@class = \"pc-block\"]/*[contains(@class, \"head\")]");
    private By xpathFieldComputer = By.xpath("//*[contains(@class, \"computer\")]/following-sibling::node()//a");
    private String SitePN = "https://pn.com.ua/";

    @BeforeClass
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        driver.get(SitePN);
    }

    @Parameters("title")
    @Test
    public void verifyTitle(String title) throws Exception {
        Assert.assertEquals(title, driver.getTitle());
    }

    @DataProvider(name = "pcBlockHead")
    public Object[][] Name() {
        return new Object[][]{
                {"Компьютеры"},
                {"Электроника"},
                {"Бытовая техника"},
                {"Все для дома"},
                {"Мебель"},
        };
    }

    @Test(dataProvider = "pcBlockHead")
    public void verifyContainPcBlock(String nameBlock) throws Exception {
        Boolean presenceBlock = false;
        List<WebElement> listPcBlock = driver.findElements(xpathPcBlock);
        for (WebElement element : listPcBlock) {
            if (element.getText().equals(nameBlock)) {
                presenceBlock = true;
                break;
            }
        }
        Assert.assertTrue(presenceBlock);
    }

    @Test(dataProvider = "DataComputer", dataProviderClass = ComputerProvider.class)
    public void verifyContainComputer(String nameFieldComputer) throws Exception {
        Boolean presenceComputer = false;
        List<WebElement> listComputer = driver.findElements(xpathFieldComputer);
        for (WebElement element : listComputer) {
            if (element.getText().equals(nameFieldComputer)) {
                presenceComputer = true;
                break;
            }
        }
        Assert.assertTrue(presenceComputer);
    }
}
