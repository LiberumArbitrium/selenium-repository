package ru.stqa.maven.Ex13PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class CartPage extends Page {

        public CartPage(WebDriver driver) {
            super(driver);
        }


public CartPage checkRows()
{ArrayList<WebElement> countRow = new ArrayList<>(driver.findElements(By.xpath("//td[@class = 'item']")));
    while (countRow.size()>0)
    {
        wait.until(ExpectedConditions.elementToBeClickable(By.name("remove_cart_item"))).click();
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//td[@class = 'item']"),countRow.size()));
        countRow = new ArrayList<>(driver.findElements(By.xpath("//td[@class = 'item']")));
    }
    return this;
}




    }
