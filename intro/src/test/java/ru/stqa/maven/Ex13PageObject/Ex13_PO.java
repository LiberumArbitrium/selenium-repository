package ru.stqa.maven.Ex13PageObject;


import org.junit.Test;

public class Ex13_PO

{


    @Test
    public void checkItem () {


        Application app = new Application();
        app.addProductToCart();
        app.deleteProductFromCart();
        app.quit();
    }

}
