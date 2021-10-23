import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeClass
    protected void before(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void beforeTest(){
        driver = new ChromeDriver();
    }

    @AfterMethod
    protected void afterTest(){
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
