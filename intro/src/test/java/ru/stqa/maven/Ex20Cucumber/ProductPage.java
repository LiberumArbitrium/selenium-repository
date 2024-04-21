package ru.stqa.maven.Ex20Cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.stqa.maven.Ex13PageObject.Page;

public class ProductPage extends Page {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean findSizeElement() {
        boolean b = !(driver.findElements(By.name("options[Size]")).isEmpty());
        return b;
    }


    public ProductPage selectSize() {
        driver.findElement(By.name("options[Size]")).click();
        driver.findElement(By.xpath("//option[@value = 'Small']")).click();
        return this;
    }

    public ProductPage addProduct() {
        driver.findElement(By.name("add_cart_product")).click();
        return this;
    }

    public ProductPage checkCount(int k) {

        WebElement cart = driver.findElement(By.className("quantity"));
        String num = String.valueOf(k+1);
        String test= cart.getText();
        wait.until(ExpectedConditions.textToBePresentInElement(cart,num));
        return this;
    }

    public ProductPage findCart() {
        driver.findElement(By.xpath("//div[@id='cart']")).click();
        return this;
    }

    public ProductPage findHome() {
        driver.findElement(By.linkText("Home")).click();
        return this;
    }




}
