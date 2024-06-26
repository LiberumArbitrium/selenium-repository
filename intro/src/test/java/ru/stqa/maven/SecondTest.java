package ru.stqa.maven;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondTest {

    private WebDriver driverChrome;
    private WebDriver driverFirefox;
    private WebDriver driverEdge;
    private WebDriverWait wait;

    @Before
    public void start(){
        driverChrome = new ChromeDriver();
        driverFirefox = new FirefoxDriver();
        driverEdge = new EdgeDriver();
    }

    @Test
    public void loginAdminPane ()
    {
       driverChrome.get("http://localhost/litecart/admin/login.php");
       driverChrome.findElement(By.name("username")).sendKeys("admin");
       driverChrome.findElement(By.name("password")).sendKeys("admin");
       driverChrome.findElement(By.name("login")).click();

        driverFirefox.get("http://localhost/litecart/admin/login.php");
        driverFirefox.findElement(By.name("username")).sendKeys("admin");
        driverFirefox.findElement(By.name("password")).sendKeys("admin");
        driverFirefox.findElement(By.name("login")).click();


        driverEdge.get("http://localhost/litecart/admin/login.php");
        driverEdge.findElement(By.name("username")).sendKeys("admin");
        driverEdge.findElement(By.name("password")).sendKeys("admin");
        driverEdge.findElement(By.name("login")).click();
    }


    @After
    public void stop()
    {
        driverChrome.quit();
        driverChrome = null;

        driverFirefox.quit();
        driverFirefox = null;

        driverEdge.quit();
        driverEdge = null;
    }


}
