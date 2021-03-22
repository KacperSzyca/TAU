import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {
    WebDriver chromeDriver;
    WebDriver mozillaDriver;
    WebDriver operaDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        chromeDriver = new ChromeDriver();
        // System.setProperty("webdriver.firefox.driver", "../geckodriver.exe");
        // mozillaDriver = new FirefoxDriver();
        // System.setProperty("webdriver.opera.driver", "../operadriver.exe");
        //operaDriver = new OperaDriver();

    }
    @Test
    public void inputMessage(){
        chromeDriver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        chromeDriver.findElement(By.id("user-message")).sendKeys("test");
        chromeDriver.findElement(By.id("get-input")).findElement(By.tagName("button")).click();
        String test = chromeDriver.findElement(By.id("display")).getText();
        assertEquals("test", test);
    }

    @Test
    public void inputTwoValue(){
        chromeDriver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        chromeDriver.findElement(By.id("sum1")).sendKeys("2");
        chromeDriver.findElement(By.id("sum2")).sendKeys("2");
        chromeDriver.findElement(By.id("gettotal")).findElement(By.tagName("button")).click();
        String test = chromeDriver.findElement(By.id("displayvalue")).getText();
        assertEquals("4", test);
    }
    @Test
    public void formTest(){
        chromeDriver.get("https://www.seleniumeasy.com/test/input-form-demo.html");
        chromeDriver.findElement(By.name("first_name")).sendKeys("test");
        chromeDriver.findElement(By.name("last_name")).sendKeys("test");
        chromeDriver.findElement(By.name("email")).sendKeys("test@test.com");
        chromeDriver.findElement(By.name("phone")).sendKeys("0000000000");
        chromeDriver.findElement(By.name("address")).sendKeys("addressTest");
        chromeDriver.findElement(By.name("city")).sendKeys("address");
        Select select = new Select(chromeDriver.findElement(By.name("state")));
        select.selectByIndex(5);
        chromeDriver.findElement(By.name("zip")).sendKeys("77123");
        chromeDriver.findElements(By.name("hosting")).get(0).click();
        chromeDriver.findElement(By.name("comment")).sendKeys("Test test test test test test");
        chromeDriver.findElement(By.className("btn")).click();

    }
}
