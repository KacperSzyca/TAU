import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoreleSeleniumTest {
    WebDriver chromeDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        chromeDriver = new ChromeDriver();

    }

    public void addToCart(){
        chromeDriver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div/div/div[2]/div/div[1]/form/div/input")).sendKeys("KatVR Czujniki ruchu VR");
        chromeDriver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div/div/div[2]/div/div[1]/form/button")).click();
        chromeDriver.findElement(By.xpath("//*[@id='product']/div[1]/div[8]/aside/div[1]/div[3]/div[4]/div[1]/a")).click();
    }


    public void removeFirstItemFromCart(){
        chromeDriver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[5]/a")).click();
        chromeDriver.findElement(By.xpath("//*[@id='basket-main']/div[2]/div[2]/div/div[4]")).click();
    }

    @Test
    public void Test(){
        chromeDriver.get("https://morele.net");
        addToCart();
        //Sprawdzenie czy dodanie do koszuka zadziało poprawnie, jak tak to usuwamy produkt
        try {
            if(chromeDriver.findElement(By.xpath("//*[@id='header']/div[1]/div[1]/div/div/div[2]/div/div[2]/div/div[5]/a/span")).getText().equals("899 zł")){
                removeFirstItemFromCart();
            }else{
                throw new NotFoundException();
            }
        }catch (Exception e){
            throw new NotFoundException(e);
        }

        chromeDriver.close();
    }



}
