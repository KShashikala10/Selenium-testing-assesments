package SauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver d;

    By productsTitle =
            By.className("title");

    By backpack =
            By.id("add-to-cart-sauce-labs-backpack");

    By cartIcon =
            By.className("shopping_cart_link");

    By cartCount =
            By.className("shopping_cart_badge");

    public ProductsPage(WebDriver d) {
        this.d = d;
    }

    public String getProductsTitle() {

        return d.findElement(productsTitle).getText();
    }

    public void addBackpackToCart() {

        d.findElement(backpack).click();
    }

    public String getCartCount() {

        return d.findElement(cartCount).getText();
    }

    public void clickCart() {

        d.findElement(cartIcon).click();
    }
}
