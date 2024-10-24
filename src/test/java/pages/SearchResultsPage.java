package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends PageBase {

    @FindBy(className = "entry-content content-products order-4 order-md-3")
    private List<WebElement> results;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public boolean searchResults(String expectedName){
        boolean nameFound = results.stream().map(WebElement::getText).anyMatch(text -> text.contains(expectedName));
        return nameFound;
    }

    public void clickResultByIndex(int index) {
        try {
            if (index >= 0 && index < results.size()) {
                results.get(index).click(); // Click on the specific result
            } else {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + results.size());
            }
        } catch (WebDriverException e) {
            // Handle WebDriver related exceptions
            System.out.println("Error clicking the result: " + e.getMessage());
        }
    }
}
