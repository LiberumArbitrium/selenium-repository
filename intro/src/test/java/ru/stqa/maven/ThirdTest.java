package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


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
        WebElement element;

        driverChrome.get("http://localhost/litecart/admin/login.php");
        driverChrome.findElement(By.name("username")).sendKeys("admin");
        driverChrome.findElement(By.name("password")).sendKeys("admin");
        driverChrome.findElement(By.name("login")).click();


        driverChrome.findElement(By.linkText("Appearence")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Template")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Logotype")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Catalog")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Product Groups")).click();
        checkH1();


        driverChrome.findElement(By.linkText("Option Groups")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Manufacturers")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Suppliers")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Delivery Statuses")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Sold Out Statuses")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Quantity Units")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@class='docs']/li[@id='doc-csv']/a[contains(@href, 'catalog')]")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Countries")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Currencies")).click();
        checkH1();


        driverChrome.findElement(By.xpath("//ul[@id='box-apps-menu']/li[@id='app-']/a[contains(., 'Customers')]")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@class='docs']/li[@id='doc-customers']")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@class='docs']/li[@id='doc-csv']/a[contains(@href, 'customers')]")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@class='docs']/li[@id='doc-newsletter']")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Geo Zones")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@id='box-apps-menu']/li[@id='app-']/a[contains(., 'Languages')]")).click();
        checkH1();


        driverChrome.findElement(By.xpath("//ul[@class='docs']/li[@id='doc-languages']")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@class='docs']/li[@id='doc-storage_encoding']")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Modules")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Background Jobs")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Customer")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Shipping")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Payment")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Order Total")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Order Success")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Order Action")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@id='box-apps-menu']/li[@id='app-']/a[contains(., 'Orders')]")).click();
        checkH1();


        driverChrome.findElement(By.linkText("Order Statuses")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Pages")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Reports")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Monthly Sales")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Most Sold Products")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Most Shopping Customers")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Settings")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Store Info")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Defaults")).click();
        checkH1();

        driverChrome.findElement(By.linkText("General")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Listings")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Images")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Checkout")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Advanced")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Security")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Slides")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Tax")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Tax Classes")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Tax Rates")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Translations")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Search Translations")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Scan Files")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@class='docs']/li[@id='doc-csv']/a[contains(@href, 'translations')]")).click();
        checkH1();

        driverChrome.findElement(By.linkText("Users")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@id='box-apps-menu']/li[@id='app-']/a[contains(., 'vQmods')]")).click();
        checkH1();

        driverChrome.findElement(By.xpath("//ul[@class='docs']/li[@id='doc-vqmods']")).click();
        checkH1();





    }


    @After
    public void stop()
    {
        driverChrome.quit();
        driverChrome = null;

    }


}
