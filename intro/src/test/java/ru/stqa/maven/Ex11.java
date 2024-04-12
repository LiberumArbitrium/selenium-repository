package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex11

{
    private WebDriver driver;


    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkItem ()
    {
     String firstname ="Firstname";
     String lastname = "Lastname" ;
     String addres = "г.Тест, ул. Тестовая, д.1"  ;
     String postcode = "12345" ;
     String city =  "Тест";

     String pass = "123" ;
     String passConf = "123" ;
     String phone = "+79621112211";

    String email = "ggjjuuii_3@mail.ru";

     driver.get("http://localhost/litecart/en/");

     driver.findElement(By.xpath("//a[contains (@href,'create_account')]")).click();

     driver.findElement(By.name("firstname")).sendKeys(firstname);
     driver.findElement(By.name("lastname")).sendKeys(lastname);
     driver.findElement(By.name("address1")).sendKeys(addres);
     driver.findElement(By.name("postcode")).sendKeys(postcode);
     driver.findElement(By.name("city")).sendKeys(city);
     driver.findElement(By.name("password")).sendKeys(pass);
     driver.findElement(By.name("confirmed_password")).sendKeys(passConf);
     driver.findElement(By.name("email")).sendKeys(email);
     driver.findElement(By.name("phone")).sendKeys(phone);


     driver.findElement(By.className("selection")).click();
     driver.findElement(By.xpath("//option[@value='US']")).click();

     driver.findElement(By.xpath("//select[@name = 'zone_code']")).click();
     driver.findElement(By.xpath("//select[@name = 'zone_code']//option[@value='KY']")).click();

      driver.findElement(By.name("password")).click();


     driver.findElement(By.name("create_account")).click();
     driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();

     driver.findElement(By.name("email")).sendKeys(email);
     driver.findElement(By.name("password")).sendKeys(pass);

     driver.findElement(By.name("login")).click();
     driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
    }



    @After
    public void stop()
    {
        driver.quit();
        driver = null;

    }


}
