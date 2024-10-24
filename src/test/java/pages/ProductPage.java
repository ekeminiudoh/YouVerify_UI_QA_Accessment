package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

    @FindBy(xpath = "/html/body/div[1]/div[9]/div[1]/div[2]/div/div[2]/div[2]/div[10]/div/div[4]/div/div[2]/button")
    protected WebElement addToCartBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div[1]/a")
    protected WebElement cartBtn;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(){
        click(addToCartBtn);
    }

    public void viewCart(){
        waitForVisibility(cartBtn);
        click(cartBtn);
    }
}
