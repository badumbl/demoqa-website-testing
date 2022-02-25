package pageObjects.interactions;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

@Data
public class SortableObjectPage extends InteractionsMainPage {


    @FindBy(xpath = "//span[contains(text(),'Sortable')]")
    private WebElement sortablePage;
    @FindBy(xpath = "//a[@id='demo-tab-list']")
    private WebElement listPage;
    @FindBy(xpath = "//a[@id='demo-tab-grid']")
    private WebElement gridPage;
    @FindBy(xpath = "//div[@id='demo-tabpane-list']//div[@class='vertical-list-container mt-4']//child::*")
    private List<WebElement> listElements;
    @FindBy(xpath = "//div[@id='demo-tabpane-grid']//div[@class='create-grid']//child::*")
    private List<WebElement> gridElements;

    public SortableObjectPage(WebDriver driver) {
        super(driver);
    }

    public SortableObjectPage go() {
        waitVisibility(sortablePage);
        sortablePage.click();
        waitingElementOnPage(listPage);
        return this;
    }

    public SortableObjectPage goToList() {
        listPage.click();
        waitVisibility(listElements.get(0));
        return this;
    }

    public WebElement getFromList(String name) {
        for (WebElement elem : listElements) {
            if (elem.getText().contains(name)) {
                return elem;
            }
        }
        return null;
    }

    public SortableObjectPage goToGrid() {
        gridPage.click();
        waitVisibility(gridElements.get(0));
        return this;
    }

    public WebElement getFromGrid(String name) {
        for (WebElement elem : gridElements) {
            if (elem.getText().contains(name)) {
                return elem;
            }
        }
        return null;
    }

    public void dragAndDrop(WebElement source, WebElement target) {
        try {
            action.moveToElement(source);
            action.dragAndDrop(source, target).perform();
        } catch (NullPointerException nul) {
            System.out.println(Arrays.toString(nul.getStackTrace()));
        }
    }

}


