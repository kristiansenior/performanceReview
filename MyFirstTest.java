package com.testing.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.List;


public class MyFirstTest {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public static void setupWebdriver() {
        WebDriverManager.chromedriver().setup();
    }

    private static final By ABOUT_US_BUTTON = By.cssSelector("body > nav > ul.main-navigation > li:nth-child(2) > a");
    private static final By RT_SEARCH_BAR = By.cssSelector("#header > div.header__section.header__section_border-bottom_gray > div > div.header__seach-form > form > div > span > input");
    private static final By SHOP_BY_DEPARTMENT = By.cssSelector("#nav-link-shopall");
    private static final By SHOP_ALL = By.cssSelector("#nav-flyout-shopAll > div.nav-template.nav-flyout-content.nav-tpl-itemList > a");
    private static final By RANDOM_PRODUCT = By.cssSelector("#amshopby-page-container > div.category-products > div.products > ul > li");
    private static final By NATIONAL_NAV_BUTTON = By.cssSelector("#nav-3 > a");



    @Test
    public void startWebdriver() throws InterruptedException {


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://seleniumsimplified.com");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);


        driver.navigate().to("https://www.classicfootballshirts.co.uk/");
        WebElement nationalNavButton = driver.findElement(NATIONAL_NAV_BUTTON);
        action.moveToElement(nationalNavButton).perform();
        Thread.sleep(2000);

        WebElement belgiumDropDown = driver.findElement(By.linkText("Belgium"));
        action.moveToElement(belgiumDropDown);
        action.click();
        action.perform();

        Assert.assertTrue("matches current url",
                driver.getCurrentUrl().matches("https://www.classicfootballshirts.co.uk/international-teams/european/belgium.html"));

        // TRY TO MAKE THIS SELECT A RANDOM PRODUCT FROM THE BELGIUM PAGE USING INT COUNTER AND RANDOM GENERATOR BELOW


        List<WebElement> links = driver.findElements(By.cssSelector("#amshopby-page-container > div.category-products > div.products > ul > li > div > h2 > a"));
        links.get(new Random().nextInt(links.size())).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);

        links = driver.findElements(By.cssSelector("#amshopby-page-container > div.category-products > div.products > ul > li > div > h2 > a"));
        links.get(new Random().nextInt(links.size())).click();
        Thread.sleep(2000);
        driver.navigate().back();

        links = driver.findElements(By.cssSelector("#amshopby-page-container > div.category-products > div.products > ul > li > div > h2 > a"));
        links.get(new Random().nextInt(links.size())).click();
        Thread.sleep(2000);

        driver.navigate().to("https://www.classicfootballshirts.co.uk/2000-02-belgium-away-tee-strupar-10-bnib.html");


        WebElement quantityField = driver.findElement(By.cssSelector("#qty"));
        action.moveToElement(quantityField);
        action.click();
        action.perform();
        quantityField.sendKeys("234");
        Thread.sleep(2000);

        WebElement addToCartButton = driver.findElement(By.cssSelector("#product_info_add > div.add-to-cart > div > button"));
        action.moveToElement(addToCartButton);
        action.click();
        action.perform();
        Thread.sleep(4000);

        WebElement sizeIsRequiredMsg = driver.findElement(By.cssSelector("#product_info_add  button"));

        if (sizeIsRequiredMsg.getText() == "This is a required field.") {
            driver.navigate().to("https://www.classicfootballshirts.co.uk/1982-84-arsenal-home-shirt-excellent-m.html");
            }

            }

    @After
    public void breakdown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }


}
