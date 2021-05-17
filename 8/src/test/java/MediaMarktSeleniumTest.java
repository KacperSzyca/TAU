import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MediaMarktSeleniumTest {
    WebDriver chromeDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "../chromedriver.exe");
        chromeDriver = new ChromeDriver();

    }

    public void addToCompare(){
        chromeDriver.findElement(By.xpath("//*[@id=\"query_querystring\"]")).sendKeys("iphone 12 pro");
        chromeDriver.findElement(By.xpath("//*[@id=\"js-triggerSearch\"]/i")).click();



        //Dodanie pierwszego przedomitu do porówania
       chromeDriver.findElement(By.xpath("//*[@id=\"js-mainWrapper\"]/main/div[6]/div[5]/div[2]/div/div[1]/div/div[3]/div[1]/div[2]/div[2]/label")).click();
       chromeDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
       chromeDriver.findElement(By.xpath("//*[@id=\"js-dynamicContent_compare\"]/button")).click();

        //Dodanie drugiego przedomitu do porówania
        chromeDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//*[@id=\"js-mainWrapper\"]/main/div[6]/div[5]/div[4]/div/div[1]/div/div[1]/div[1]/div[1]/a")).click();
        chromeDriver.findElement(By.xpath("//*[@id=\"js-mainWrapper\"]/main/div[6]/section/div[1]/div[2]/div[1]/div[4]/div[2]/label")).click();

        // przejscie do strony z porównaniem
        chromeDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        chromeDriver.findElement(By.xpath("//*[@id=\"js-dynamicContent_msg_compare\"]/div[2]/a[2]")).click();


    }

    //sprawdzenie cen produktów w celu upewnienia, że produkty zostały dodane do porównania
    public void compare(){
        String valueOfFirstItem = "4899,-";
        String valueOfSecoundItem = "4999,-";

        if(!chromeDriver.findElement(By.xpath("//*[@id=\"js-mainWrapper\"]/main/main/div[2]/div/div[2]/table/thead/tr/th[2]/div/div")).getText().equals(valueOfFirstItem)){
            throw new NotFoundException();
        }

        if(!chromeDriver.findElement(By.xpath("//*[@id=\"js-mainWrapper\"]/main/main/div[2]/div/div[2]/table/thead/tr/th[3]/div/div")).getText().equals(valueOfSecoundItem)){
            throw new NotFoundException();
        }


    }


    @Test
    public void Test(){
        chromeDriver.get("https://mediamarkt.pl");
        addToCompare();
        compare();
        chromeDriver.close();
    }
}
