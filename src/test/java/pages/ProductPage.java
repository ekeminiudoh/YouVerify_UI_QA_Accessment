package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

    @FindBy(xpath = "//*[@id=\"entry_216842\"]/button")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//*[@id=\"entry_217825\"]/a/div[1]/div/svg/use")
    private WebElement cartBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        click(addToCartBtn);
    }

    public void viewCart(){
        click(cartBtn);
    }
}
