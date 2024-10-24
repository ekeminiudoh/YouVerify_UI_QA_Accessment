package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase {

    @FindBy(xpath = "//*[@id=\"entry_217847\"]/div/table/tbody/tr/td[2]/a")
    public WebElement productNameElement;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div[1]/div/div/div[2]/a[2]")
    public WebElement checkoutBtn;

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
