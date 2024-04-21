package ru.stqa.maven.Ex20Cucumber;


import io.cucumber.java8.Ru;
import ru.stqa.maven.Ex13PageObject.Application;

public class StepsDefs implements Ru {

    public StepsDefs() {

        Application app = new Application();
        Когда("^Добавляем 3 первых товара из списка в корзину$", () ->

        {
            // Write code here that turns the phrase above into concrete actions
            app.addProductToCart();
        });

        Тогда("^Удаляем все товары из корзины один за другим$", () ->

        {
            // Write code here that turns the phrase above into concrete actions
            app.deleteProductFromCart();
            app.quit();
        });

    }
}

