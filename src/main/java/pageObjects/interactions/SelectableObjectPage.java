package pageObjects.interactions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectableObjectPage extends InteractionsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Selectable')]")
    private WebElement selectableObjPage;
    @FindBy(xpath = "//a[@id='demo-tab-list']")
    private WebElement goTolist;
    @FindBy(xpath = "//a[@id='demo-tab-grid']")
    private WebElement goToGrid;
    @FindBy(xpath = "//ul[@id='verticalListContainer']//child::*")
    private List<WebElement> listOfElements;
    @FindBy(xpath = "//div[@id='gridContainer']//child::*")
    private List<WebElement> listOfGridElements;

    public SelectableObjectPage(WebDriver driver) {
        super(driver);
    }

    public SelectableObjectPage go() {
        waitVisibility(selectableObjPage);
        selectableObjPage.click();
        waitingElementOnPage(goTolist);
        return this;
    }

    public SelectableObjectPage goToList() {
        goTolist.click();
        return this;
    }

    public SelectableObjectPage goToGrid() {
        goToGrid.click();
        return this;
    }

    public List<WebElement> getList() {
        return listOfElements;
    }

    public List<WebElement> getGrid() {
        return listOfGridElements;
    }

    public SelectableObjectPage chooseElementList(String select) {
        goThroughList(select, getList()).click();
        return this;
    }
    public SelectableObjectPage chooseElementGrid(String select) {
        goThroughList(select, getGrid()).click();
        return this;
    }

    public WebElement goThroughList(String name, List<WebElement> theList) {
        for (WebElement elem : theList) {
            if (elem.getText().equals(name)) {
                return elem;
            }
        }
        return null;
    }

}
