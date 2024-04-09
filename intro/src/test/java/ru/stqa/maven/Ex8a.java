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
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.*;
import static java.util.Collections.sort;

public class Ex8a

{
    private WebDriver driverChrome;



    @Before
    public void start(){
        driverChrome = new ChromeDriver();
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void findCountries ()
    {
        WebElement element;


        driverChrome.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driverChrome.findElement(By.name("username")).sendKeys("admin");
        driverChrome.findElement(By.name("password")).sendKeys("admin");
        driverChrome.findElement(By.name("login")).click();

ArrayList<WebElement> list = new ArrayList<>(driverChrome.findElements(By.xpath("//tr[@class = 'row']//a[contains(@href, 'countries') and not(@title='Edit')]")));
ArrayList<String> listCountries = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            String str = list.get(i).getAttribute("textContent");
            listCountries.add(i,str);
        }

        ArrayList<String> forSort = new ArrayList<>();
        forSort.addAll(listCountries);

        Collections.sort(forSort);


        Assert.assertEquals(forSort, listCountries) ;

        }













    @After
    public void stop()
    {
        driverChrome.quit();
        driverChrome = null;

    }


}
