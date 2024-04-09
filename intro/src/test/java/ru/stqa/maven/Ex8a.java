package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Ex8a

{
    private WebDriver driverChrome;

    private WebDriverWait wait;

    public void checkH1 ()
    {
        Assert.assertTrue(driverChrome.findElement(By.tagName("h1")).isEnabled());
    }

    @Before
    public void start(){
        driverChrome = new ChromeDriver();
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void findLabel ()
    {
        WebElement element;

        driverChrome.get("http://localhost/litecart/en/");

        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-most-popular']//a[@title='Red Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-most-popular']//a[@title='Blue Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-most-popular']//a[@title='Green Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-most-popular']//a[@title='Purple Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-most-popular']//a[@title='Yellow Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());


        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-campaigns']//a[@title='Yellow Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());

        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-latest-products']//a[@title='Red Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-latest-products']//a[@title='Blue Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-latest-products']//a[@title='Green Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-latest-products']//a[@title='Purple Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
        Assert.assertEquals(1, driverChrome.findElements(By.xpath("//div[@id='box-latest-products']//a[@title='Yellow Duck']//div[@class = 'sticker new' or @class = 'sticker sale']")).size());
    }


    @After
    public void stop()
    {
        driverChrome.quit();
        driverChrome = null;

    }


}
