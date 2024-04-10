package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.util.Collections.*;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ThirdTest

{
    private WebDriver driverChrome;



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
    public void findAndClick ()
    {


        driverChrome.get("http://localhost/litecart/admin/login.php");
        driverChrome.findElement(By.name("username")).sendKeys("admin");
        driverChrome.findElement(By.name("password")).sendKeys("admin");
        driverChrome.findElement(By.name("login")).click();

        ArrayList<WebElement> menuList = new ArrayList<>(driverChrome.findElements(By.xpath("//li[@id = 'app-']")));

        for (int i = 0; i < menuList.size(); i++) {
            menuList.get(i).click();
            checkH1();
           menuList = new ArrayList<>(driverChrome.findElements(By.xpath("//li[@id = 'app-']")));
           ArrayList<WebElement> innerList = new ArrayList<>(menuList.get(i).findElements(By.xpath(".//li")));
            for (int j = 0; j < innerList.size() ; j++) {

                innerList.get(j).click();
                checkH1();
               menuList = new ArrayList<>(driverChrome.findElements(By.xpath("//li[@id = 'app-']")));
              innerList = new ArrayList<>(menuList.get(i).findElements(By.xpath(".//li")));
            }


        }



    }


    @After
    public void stop()
    {
        driverChrome.quit();
        driverChrome = null;

    }


}
