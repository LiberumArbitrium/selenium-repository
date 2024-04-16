package ru.stqa.maven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class Ex14

{
    private WebDriver driver;


    @Before
    public void start(){
        driver = new ChromeDriver(); //new FirefoxDriver(); new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkItem () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");


        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();


        driver.findElement(By.linkText("Add New Country")).click();


        String mainWindow = driver.getWindowHandle();
        ArrayList<WebElement> links = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'external-link')]")));


        for (int i = 0; i < links.size(); i++) {

            links.get(i).click();
            wait.until((WebDriver driver) -> driver.getWindowHandles().size() > 1);
            ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
            String newWindow = windows.stream()
                    .filter(c -> !c.equals(mainWindow)).findFirst().get();

                driver.switchTo().window(newWindow);
                driver.close();
                driver.switchTo().window(mainWindow);


              links = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'external-link')]")));
        }
    }


    @After
    public void stop()
    {
        driver.quit();
        driver = null;

    }


}
