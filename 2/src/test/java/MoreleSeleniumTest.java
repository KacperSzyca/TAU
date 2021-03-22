import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class MoreleSeleniumTest {
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

    public void findProduct(){
        chromeDriver.get("https://morele.net");
        chromeDriver.findElement(By.className("quick-search-autocomplete")).sendKeys("KatVR Czujniki ruchu VR");
        chromeDriver.findElement(By.className("h-quick-search-submit")).click();
    }

    @Test
    public void addToCartTest(){
        findProduct();
        chromeDriver.findElement(By.className("add-to-cart__btn")).click();
        chromeDriver.findElement(By.className("item-remove")).click();
    }

    @Test
    public void compareTest(){
        findProduct();
        chromeDriver.findElement(By.className("btn-compare")).click();
        chromeDriver.findElement(By.className("btn-compare")).click();
        chromeDriver.close();
    }


    @Test
    public void failedLoginTest(){
        chromeDriver.get("https://morele.net");
        chromeDriver.findElement(By.className("h-user-control")).click();
        chromeDriver.findElement(By.id("username")).sendKeys("test@test.pl");
        chromeDriver.findElement(By.id("password-log")).sendKeys("asd");
        chromeDriver.findElement(By.className("btn-primary-2")).click();
        chromeDriver.close();
    }

    @Test
    public void failedPasswordReminder(){
        chromeDriver.get("https://morele.net");
        chromeDriver.findElement(By.className("h-user-control")).click();
        chromeDriver.findElement(By.linkText("Nie pamiętam hasła")).click();
        chromeDriver.findElement(By.className("form-control-material")).sendKeys("asdasdad@asdasdawd.dddwa");
        chromeDriver.findElement(By.className("btn-primary-2")).click();
        chromeDriver.findElement(By.className("btn-secondary-outline"));
        chromeDriver.close();
    }

}
