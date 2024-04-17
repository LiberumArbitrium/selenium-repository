package ru.stqa.maven.Ex13PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Application {

    private WebDriver driver;

    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;

    public Application() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void addProductToCart() {
        mainPage.open();

        int i;
        for (i = 0; i < 3; i++) {
            mainPage.selectProduct();

            if (productPage.findSizeElement()) {
                productPage.selectSize();
            }
            productPage.addProduct();

            productPage.checkCount(i);

            productPage.findHome();
        }

    }


    public void deleteProductFromCart()
    {
        productPage.findCart();
        cartPage.checkRows();

    }

}


