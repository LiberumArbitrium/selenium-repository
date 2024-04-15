package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Ex12

{
    private WebDriver driver;


    @Before
    public void start(){
        driver = new ChromeDriver(); //new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkItem ()
    {
        String itemName = "Bike_1";

        //переход на страницу редактирования каталога, логин, нажатие кнопки добавления товара
     driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog");

     driver.findElement(By.name("username")).sendKeys("admin");
     driver.findElement(By.name("password")).sendKeys("admin");
     driver.findElement(By.name("login")).click();
     driver.findElement(By.linkText("Add New Product")).click();

        // заполнение страницы General

        driver.findElement(By.xpath("//input[@name = 'status' and @value = '1']")).click();
        driver.findElement(By.name("name[en]")).sendKeys(itemName);
        driver.findElement(By.name("code")).sendKeys("3450");
        driver.findElement(By.xpath("//input[@name = 'product_groups[]' and @value = '1-3']")).click();
        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("5");
        driver.findElement(By.name("sold_out_status_id")).click();
        driver.findElement(By.xpath("//select[@name = 'sold_out_status_id']/option[1]")).click();
        driver.findElement(By.name("date_valid_from")).sendKeys("01012001");
        driver.findElement(By.name("date_valid_to")).sendKeys("10102025");

        Path path = Paths.get("src\\img\\bike.jpg");
        String absPath = path.toAbsolutePath().toString();

        driver.findElement(By.name("new_images[]")).sendKeys(absPath);

        driver.findElement(By.linkText("Information")).click();

        // заполнение страницы Information

        driver.findElement(By.name("manufacturer_id")).click();
        driver.findElement(By.xpath("//select[@name = 'manufacturer_id']/option[@value='1']")).click();

        driver.findElement(By.name("keywords")).sendKeys("keywords keywords keywords");

        driver.findElement(By.name("short_description[en]")).sendKeys("Short Description test");

        driver.findElement(By.className("trumbowyg-editor")).sendKeys("Description looooooooooooooooooooooooooong");

        driver.findElement(By.name("head_title[en]")).sendKeys("Head Title test");

        driver.findElement(By.name("meta_description[en]")).sendKeys("Meta Description test");

        driver.findElement(By.linkText("Prices")).click();

        // заполнение страницы Prices

        driver.findElement(By.name("purchase_price")).clear();
        driver.findElement(By.name("purchase_price")).sendKeys("1000");


        driver.findElement(By.name("purchase_price_currency_code")).click();
        driver.findElement(By.xpath("//option[@value='USD']")).click();

        driver.findElement(By.name("prices[USD]")).sendKeys("1000");
        driver.findElement(By.name("prices[EUR]")).sendKeys("940");


        driver.findElement(By.name("save")).click();

        //Проверка наличия товара в каталоге админке

        ArrayList <WebElement> countBike = new ArrayList<>(driver.findElements(By.linkText(itemName)));

        Assert.assertEquals(1, countBike.size());

    }



    @After
    public void stop()
    {
        driver.quit();
        driver = null;

    }


}
