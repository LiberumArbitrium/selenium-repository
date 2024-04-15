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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class Ex13

{
    private WebDriver driver;


    @Before
    public void start(){
        driver = new ChromeDriver(); //new FirefoxDriver(); new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkItem ()
    {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     driver.get("http://localhost/litecart/en/");

        for (int i = 0; i < 3; i++) {

            driver.findElement(By.xpath("//li[contains (@class,'product')]")).click();

            if (!driver.findElements(By.name("options[Size]")).isEmpty())
            {
                driver.findElement(By.name("options[Size]")).click();
                driver.findElement(By.xpath("//option[@value = 'Small']")).click();
            }
            driver.findElement(By.name("add_cart_product")).click();

            WebElement cart = driver.findElement(By.className("quantity"));
            String num = String.valueOf(i+1);
            String test= cart.getText();
            wait.until(ExpectedConditions.textToBePresentInElement(cart,num));

            driver.findElement(By.linkText("Home")).click();

        }

        driver.findElement(By.xpath("//div[@id='cart']")).click();

        ArrayList <WebElement> countRow = new ArrayList<>(driver.findElements(By.xpath("//td[@class = 'item']")));
        while (countRow.size()>0)
        {
            wait.until(ExpectedConditions.elementToBeClickable(By.name("remove_cart_item"))).click();
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//td[@class = 'item']"),countRow.size()));
            countRow = new ArrayList<>(driver.findElements(By.xpath("//td[@class = 'item']")));
        }

       // wait.until(ExpectedConditions.stalenessOf(driver.findElements(By.xpath("//td[@class = 'item']"));

    }



    @After
    public void stop()
    {
        driver.quit();
        driver = null;

    }


}
