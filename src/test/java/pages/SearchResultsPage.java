package pages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.IntStream;

public class SearchResultsPage extends PageBase {

    @FindBy(className = "text-ellipsis-2")
    protected List<WebElement> results;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public boolean searchResults(String expectedName){
        return results.stream().map(WebElement::getText).anyMatch(text -> text.contains(expectedName));
    }

    public void clickResultByIndex(int index) {
        IntStream.range(0, results.size()).forEach(i -> System.out.println("Index: " + i + " - Element: " + results.get(i).getText()));

        try {
            if (index >= 0 && index < results.size()) {
                results.get(index).click();
                Thread.sleep(6);
                System.out.println("got to here");// Click on the specific result
            } else {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + results.size());
            }
        } catch (WebDriverException e) {
            // Handle WebDriver related exceptions
            System.out.println("Error clicking the result: " + e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
