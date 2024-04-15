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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FourthTest

{
    private WebDriver driverChrome;


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

       ArrayList<WebElement> itemsList = new ArrayList<>(driverChrome.findElements(By.xpath("//li[contains (@class,'product')]")));

        for (int i = 0; i < itemsList.size(); i++) {

            ArrayList<WebElement> stikers = new ArrayList<>(itemsList.get(i).findElements(By.xpath(".//div[contains(@class, 'sticker')]")));
            Assert.assertEquals(1,stikers.size());

        }
    }



    @After
    public void stop()
    {
        driverChrome.quit();
        driverChrome = null;

    }


}
