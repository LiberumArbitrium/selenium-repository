package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Ex17

{
    private WebDriver driver;


    @Before
    public void start(){
        driver = new ChromeDriver();//new FirefoxDriver(); new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkItem () {
        // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");


        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


ArrayList<WebElement> products = new ArrayList<>(driver.findElements(By.xpath("//tr[@class='row']//td[3]/a[contains(@href,'product_id')]"))) ;

        for (int i = 0; i < products.size() ; i++) {
            ArrayList<LogEntry> errors = new ArrayList<>();
            products.get(i).click();
            Assert.assertEquals(0, driver.manage().logs().get("browser").getAll().size());
            driver.findElement(By.name("cancel")).click();
            products = new ArrayList<>(driver.findElements(By.xpath("//tr[@class='row']//td[3]/a[contains(@href,'product_id')]"))) ;
        }


    }


    @After
    public void stop()
    {
        driver.quit();
        driver = null;

    }


}
