package ru.stqa.maven.Ex20Cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {


    public MainPage(WebDriver driver) {
        super(driver);
    }


    public MainPage open() {
        driver.get("http://localhost/litecart/en/");
        return this;
    }


    public void selectProduct() {
        driver.findElement(By.xpath("//li[contains (@class,'product')]")).click();
    }

}
