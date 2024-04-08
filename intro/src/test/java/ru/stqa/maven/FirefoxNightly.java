package ru.stqa.maven;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

@SuppressWarnings("ALL")
public class FirefoxNightly {


    private WebDriver driverFirefox;
    private WebDriverWait wait;

    @Before
    public void start(){

        FirefoxOptions options = new FirefoxOptions().setBinary("C:\\Program Files\\Firefox Nightly\\firefox.exe");

        driverFirefox = new FirefoxDriver(options);

    }

    @Test
    public void loginAdminPane ()
    {


        driverFirefox.get("http://localhost/litecart/admin/login.php");
        driverFirefox.findElement(By.name("username")).sendKeys("admin");
        driverFirefox.findElement(By.name("password")).sendKeys("admin");
        driverFirefox.findElement(By.name("login")).click();



    }


    @After
    public void stop()
    {


        driverFirefox.quit();
        driverFirefox = null;


    }


}
