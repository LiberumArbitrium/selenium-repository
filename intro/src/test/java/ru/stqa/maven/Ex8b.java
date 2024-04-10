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
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Ex8b

{
    private WebDriver driverChrome;


    @Before
    public void start(){
        driverChrome = new ChromeDriver();
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void findGeoZones ()
    {

        driverChrome.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driverChrome.findElement(By.name("username")).sendKeys("admin");
        driverChrome.findElement(By.name("password")).sendKeys("admin");
        driverChrome.findElement(By.name("login")).click();


ArrayList<WebElement> listCountries = new ArrayList<>(driverChrome.findElements(By.xpath("//tr[@class = 'row']//a[contains(@href, 'countries') and not(@title='Edit')]")));
ArrayList<WebElement> listElements = new ArrayList<>(driverChrome.findElements(By.xpath("//tr[@class = 'row']//td[6]")));

        for (int i = 0; i < listElements.size(); i++) {

            int countZones = Integer.parseInt(listElements.get(i).getAttribute("textContent"));
            if (countZones>0)
            {
                listCountries.get(i).click();

                ArrayList<WebElement> listInnerZones = new ArrayList<>(driverChrome.findElements(By.xpath("//table[@id='table-zones']//td[3]//*[contains(@name,'zones')]")));
                ArrayList<String> listInnerCountries = new ArrayList<>();

                for (int j = 0; j < listInnerZones.size(); j++) {

                    String str = listInnerZones.get(j).getAttribute("textContent");
                    listInnerCountries.add(j,str);
                }

                ArrayList<String> forSort = new ArrayList<>();
                forSort.addAll(listInnerCountries);

                Collections.sort(forSort);


                Assert.assertEquals(forSort, listInnerCountries) ;

                driverChrome.findElement(By.name("save")).click();
                listCountries = new ArrayList<>(driverChrome.findElements(By.xpath("//tr[@class = 'row']//a[contains(@href, 'countries') and not(@title='Edit')]")));
                listElements = new ArrayList<>(driverChrome.findElements(By.xpath("//tr[@class = 'row']//td[6]")));
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
