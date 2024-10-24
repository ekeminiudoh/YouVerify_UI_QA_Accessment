package pages;

import base.PageBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class LandingPage extends PageBase {
    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div[2]/input")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"search\"]/div[2]/button")
    private WebElement searchButton;

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String productName) {
        enterText(searchBox, productName);
        click(searchButton);
    }

    public void assertCurrentUrl(SoftAssert softAssert, String expectedUrl) {
        // Get the current URL
        String actualUrl = driver.getCurrentUrl();
        // Soft assertion to check if the current URL matches the expected URL
        softAssert.assertEquals(actualUrl, expectedUrl, "The current URL did not match the expected URL.");
    }
}
