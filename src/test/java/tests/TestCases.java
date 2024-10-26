package tests;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.lang.reflect.Method;
import java.util.List;

import static utils.extentReports.ExtentTestManager.startTest;

public class TestCases extends TestBase {
    LandingPage landingPage;
    CartPage cartPage;
    ProductPage productPage;
    SearchResultsPage searchResultsPage;
    SoftAssert softAssert;

    private void initializer() {
        landingPage = new LandingPage(driver);
        cartPage = new CartPage(driver);
        productPage = new ProductPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        softAssert = new SoftAssert();
    }

    @Test( priority = 1, description = " TC_01 - Validate that user can navigate to the e-commerce site ")
    public void TC_01 (Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "go to url");
        initializer();
        landingPage.assertCurrentUrl(softAssert, "https://ecommerce-playground.lambdatest.io/");
    }

    @Test( priority = 2, description = " TC_02 - Validate that user can search for a specific product ")
    public void TC_02 (Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "search for a product");
        landingPage.searchProduct("htc touch hd");
        softAssert.assertTrue(searchResultsPage.searchResults("HTC Touch HD"), "The search results do not contain the search term: " + "HTC Touch HD");
    }

    @Test( priority = 3, description = "  TC_03 - Validate that user can add product to cart")
    public void TC_03 (Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "add and confirm product in cart");
        searchResultsPage.clickResultByIndex(0);
        productPage.addToCart();
        productPage.viewCart();
        softAssert.assertTrue(cartPage.isProductDisplayedInCart("HTC Touch HD"), "Product is not displayed in the cart.");
    }

    @Test( priority = 4, description = "  TC_04 - Validate user can checkout from cart page")
    public void TC_04 (Method method) throws InterruptedException {
        startTest(method.getName(), method.getAnnotation(Test.class).description(), "confirm checkout");
        cartPage.clickCheckout();
        softAssert.assertEquals(driver.getTitle(), "Checkout", "User is not on the Cart page.");

    }
}
