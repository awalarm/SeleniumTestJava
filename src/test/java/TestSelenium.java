
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestSelenium extends BaseTest {


    public static void newClick(WebDriver driver, WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", element);
    }

    @Test
    public void test() throws InterruptedException {
        getDriver().get("https://demoqa.com/automation-practice-form");

        WebElement firstName = getDriver().findElement(By.id("firstName"));
        firstName.sendKeys("Petr");
        getDriver().findElement(By.id("lastName")).sendKeys("Ivanov");

        WebElement radio = getDriver().findElement(By.xpath("//input[@name='gender'][@value='Male']"));
        newClick(getDriver(), radio);

        getDriver().findElement(By.id("userEmail")).sendKeys("test@example.com");
        getDriver().findElement(By.id("userNumber")).sendKeys("+79998887766");

        Thread.sleep(1000);

        WebElement state = getDriver().findElement(By.id("state"));
        newClick(getDriver(), state);
        Thread.sleep(3000);

        Assert.assertEquals(firstName.getAttribute("value") , "Petr");
    }
}
