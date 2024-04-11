package ru.stqa.maven;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Ex10

{
    private WebDriver driver;


    @Before
    public void start(){
        driver = new EdgeDriver(); //new ChromeDriver(); new FirefoxDriver(); new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void checkItem ()
    {
     driver.get("http://localhost/litecart/en/");

     //--поиск элементов и значений на главной странице

     WebElement item = driver.findElement(By.xpath("//div[@id = 'box-campaigns']//li[1]"));
    WebElement name = item.findElement(By.xpath(".//div[@class='name']"));
    WebElement priceRegular = item.findElement(By.xpath(".//s[@class='regular-price']"))  ;
    WebElement priceSale = item.findElement(By.xpath(".//strong[@class='campaign-price']"));

    String nameMain = name.getAttribute("textContent");
    String priceRegularMain = priceRegular.getAttribute("textContent");
    String priceSaleMain = priceSale.getAttribute("textContent");

    String stylePriceRegularMain = priceRegular.getCssValue("text-decoration");
    String colorPriceRegularMain = priceRegular.getCssValue("color");

    int stylePriceSaleMain = Integer.parseInt(priceSale.getCssValue("font-weight"));
    String colorPriceSaleMain = priceSale.getCssValue("color");

    String sizePriceRegularMain = priceRegular.getCssValue("font-size");
    String  sizePriceSaleMain = priceSale.getCssValue("font-size");


     item.click();

//--поиск элементов и значений на транице карточки товара

        WebElement nameCard = driver.findElement(By.xpath("//h1"));
        WebElement priceRegularPage = driver.findElement(By.xpath("//s[@class = 'regular-price']"))  ;
        WebElement priceSalePage = driver.findElement(By.xpath("//strong[@class='campaign-price']"));

        String nameItemCard = nameCard.getAttribute("textContent");
        String priceRegularCard = priceRegularPage.getAttribute("textContent");
        String priceSaleCard = priceSalePage.getAttribute("textContent");

        String stylePriceRegularCard = priceRegularPage.getCssValue("text-decoration");
        String colorPriceRegularCard = priceRegularPage.getCssValue("color");

        int stylePriceSaleCard = Integer.parseInt(priceSalePage.getCssValue("font-weight"));
        String colorPriceSaleCard = priceSalePage.getCssValue("color");

        String sizePriceRegularCard = priceRegularPage.getCssValue("font-size");
        String sizePriceSaleCard = priceSalePage.getCssValue("font-size");


        //Проверки

        //а) на главной странице и на странице товара совпадает текст названия товара
        Assert.assertEquals(nameMain,nameItemCard);

        //б) на главной странице и на странице товара совпадают цены (обычная и акционная)
        Assert.assertEquals(priceRegularMain,priceRegularCard);
        Assert.assertEquals(priceSaleMain,priceSaleCard);

        //в) ПРОВЕРКА НА ГЛАВНОЙ СТРАНИЦЕ обычная цена зачёркнутая и серая
        // (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)
        Assert.assertEquals(true,stylePriceRegularMain.contains("line-through"));

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(colorPriceRegularMain);
        matcher.find();
        int R = Integer.parseInt(matcher.group());
        matcher.find();
        int G =Integer.parseInt(matcher.group());
        matcher.find();
        int B =Integer.parseInt(matcher.group());

        Assert.assertEquals(true,(R==G)&&(R==B));

        //г) ПРОВЕРКА НА ГЛАВНОЙ СТРАНИЦЕ акционная жирная и красная
        //(можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)

        Assert.assertEquals(true,stylePriceSaleMain>=700);

        matcher = pattern.matcher(colorPriceSaleMain);
        matcher.find();
        R = Integer.parseInt(matcher.group());
        matcher.find();
        G =Integer.parseInt(matcher.group());
        matcher.find();
        B =Integer.parseInt(matcher.group());

        Assert.assertEquals(true,(G==0)&&(B==0));

       //д) ПРОВЕРКА НА ГЛАВНОЙ СТРАНИЦЕ акционная цена крупнее, чем обычная

        matcher = pattern.matcher(sizePriceRegularMain);
        matcher.find();
        float sizeReg = Float.parseFloat(matcher.group());

        matcher = pattern.matcher(sizePriceSaleMain);
        matcher.find();
        float sizeSale = Float.parseFloat(matcher.group());

        Assert.assertEquals(true,sizeSale>sizeReg);



        //в) ПРОВЕРКА НА КАРТОЧКЕ ТОВАРА обычная цена зачёркнутая и серая
        // (можно считать, что "серый" цвет это такой, у которого в RGBa представлении одинаковые значения для каналов R, G и B)

        Assert.assertEquals(true,stylePriceRegularCard.contains("line-through"));

        matcher = pattern.matcher(colorPriceRegularCard);
        matcher.find();
        R = Integer.parseInt(matcher.group());
        matcher.find();
        G =Integer.parseInt(matcher.group());
        matcher.find();
        B =Integer.parseInt(matcher.group());

        Assert.assertEquals(true,(R==G)&&(R==B));

        //г) ПРОВЕРКА НА КАРТОЧКЕ ТОВАРА акционная жирная и красная
        //(можно считать, что "красный" цвет это такой, у которого в RGBa представлении каналы G и B имеют нулевые значения)

        Assert.assertEquals(true,stylePriceSaleCard>=700);

        matcher = pattern.matcher(colorPriceSaleCard);
        matcher.find();
        R = Integer.parseInt(matcher.group());
        matcher.find();
        G =Integer.parseInt(matcher.group());
        matcher.find();
        B =Integer.parseInt(matcher.group());

        Assert.assertEquals(true,(G==0)&&(B==0));

        //д) ПРОВЕРКА НА КАРТОЧКЕ ТОВАРА акционная цена крупнее, чем обычная

        matcher = pattern.matcher(sizePriceRegularCard);
        matcher.find();
       sizeReg = Float.parseFloat(matcher.group());

        matcher = pattern.matcher(sizePriceSaleCard);
        matcher.find();
        sizeSale = Float.parseFloat(matcher.group());

        Assert.assertEquals(true,sizeSale>sizeReg);


    }



    @After
    public void stop()
    {
        driver.quit();
        driver = null;

    }


}
