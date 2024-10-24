package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

    @FindBy(xpath = "//*[@id=\"entry_217847\"]/div/table/tbody/tr/td[2]/a")
    private WebElement productNameElement;

    @FindBy(xpath = "//*[@id=\"entry_217851\"]/a")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductDisplayedInCart(String productName) {
        return productNameElement.getText().equalsIgnoreCase(productName);
    }

    public void clickCheckout(){
        click(checkoutBtn);
    }
}
