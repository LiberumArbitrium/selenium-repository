package ru.stqa.maven;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
    }

    @Test
    public void loadSite()
    {
       driver.get("https://software-testing.ru/");
    }


    @After
    public void stop()
    {
        driver.quit();
        driver = null;
    }


}
