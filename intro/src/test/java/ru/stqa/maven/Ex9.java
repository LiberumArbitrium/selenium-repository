package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class Ex9

{
    private WebDriver driverChrome;


    @Before
    public void start(){
        driverChrome = new ChromeDriver();
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkGeoZones ()
    {

        driverChrome.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driverChrome.findElement(By.name("username")).sendKeys("admin");
        driverChrome.findElement(By.name("password")).sendKeys("admin");
        driverChrome.findElement(By.name("login")).click();



ArrayList<WebElement> listZones = new ArrayList<>(driverChrome.findElements(By.xpath("//tr[@class = 'row']//td[3]//a")));

        for (int i = 0; i < listZones.size(); i++) {

            listZones.get(i).click();
            ArrayList<WebElement> listInnerZones = new ArrayList<>(driverChrome.findElements(By.xpath("//select[contains(@name,'[zone_code]')]//option[@selected = 'selected']")));
            ArrayList<String> listInnerZonesString = new ArrayList<>();

            for (int j = 0; j < listInnerZones.size(); j++) {

                String str = listInnerZones.get(j).getAttribute("textContent");
                listInnerZonesString.add(j,str);
            }

                ArrayList<String> forSort = new ArrayList<>();
                forSort.addAll(listInnerZonesString);

                Collections.sort(forSort);

                Assert.assertEquals(forSort, listInnerZonesString) ;

                driverChrome.findElement(By.name("cancel")).click();

            listZones = new ArrayList<>(driverChrome.findElements(By.xpath("//tr[@class = 'row']//td[3]//a")));
        }
        }



    @After
    public void stop()
    {
        driverChrome.quit();
        driverChrome = null;

    }


}
