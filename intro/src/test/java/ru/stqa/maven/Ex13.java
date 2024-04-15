package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Ex13

{
    private WebDriver driver;


    @Before
    public void start(){
        driver = new ChromeDriver(); //new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkItem ()
    {

     driver.get("http://localhost/litecart/en/");





    }



    @After
    public void stop()
    {
        driver.quit();
        driver = null;

    }


}
