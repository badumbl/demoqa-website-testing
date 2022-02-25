package pageObjects.interactions;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
@Setter
public class DroppablePage extends InteractionsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Droppable')]")
    private WebElement droppablePage;
    @FindBy(xpath = "//a[@id='droppableExample-tab-accept']")
    private WebElement acceptTab;
    @FindBy(xpath = "//div[@id='draggable']")
    private WebElement simpleObj;
    @FindBy(xpath = "//div[@id='simpleDropContainer']//div[@id='droppable']")
    private WebElement simpleTarget;
    @FindBy(xpath = "//div[@id='acceptable']")
    private WebElement acceptObj;
    @FindBy(xpath = "//div[@id='acceptDropContainer']//div[@id='droppable']")
    private WebElement acceptTarget;
    @FindBy(xpath = "//div[@id='notAcceptable']")
    private WebElement notAcceptObj;
    @FindBy(xpath = "//a[@id='droppableExample-tab-preventPropogation']")
    private WebElement goPrevProp;
    @FindBy(xpath = "//div[@id='dragBox']")
    private WebElement dragBox;
    @FindBy(xpath = "//div[@id='notGreedyDropBox']")
    private WebElement outNotGreedy;
    @FindBy(xpath = "//div[@id='notGreedyInnerDropBox']")
    private WebElement innerNotGreedy;
    @FindBy(xpath = "//div[@id='greedyDropBox']")
    private WebElement outGreedy;
    @FindBy(xpath = "//div[@id='greedyDropBox']//child::*")
    private WebElement outGreedyChild;
    @FindBy(xpath = "//div[@id='greedyDropBoxInner']")
    private WebElement innerGreedy;
    @FindBy(xpath = "//a[@id='droppableExample-tab-revertable']")
    private WebElement goRevert;
    @FindBy(xpath = "//div[@id='revertable']")
    private WebElement revertable;
    @FindBy(xpath = "//div[@id='notRevertable']")
    private WebElement notRevertable;
    @FindBy(xpath = "//div[@id='revertableDropContainer']//div[@id='droppable']")
    private WebElement dropBox;
    @FindBy(xpath = "//a[@id='droppableExample-tab-accept']")
    private WebElement goAccept;
    @FindBy(xpath = "//div[@id='notGreedyDropBox']//*[text() ='Outer droppable']")
    private WebElement otherDroppable;
    @FindBy(xpath = "//a[@id='droppableExample-tab-simple']")
    private WebElement simpleTab;


    public DroppablePage(WebDriver driver) {
        super(driver);
    }

    public DroppablePage go() {
        droppablePage.click();
        waitVisibility(simpleObj);
        waitingElementOnPage(simpleTab);
        simpleTab.click();
        return this;
    }

    public DroppablePage goAccept() {
        goAccept.click();
        return this;
    }

    public DroppablePage goPrevProp() {
        goPrevProp.click();
        return this;
    }

    public DroppablePage goRevert() {
        goRevert.click();
        return this;
    }

    public DroppablePage dragAndDrop(WebElement source, WebElement target) {
        action.moveToElement(source);
        action.dragAndDrop(source, target).perform();
        return this;
    }

    public DroppablePage clickAndHoldOffset(WebElement source) {
        action.clickAndHold(source).moveByOffset(100, 200).perform();
        return this;
    }

    public DroppablePage clickAndHoldToElement(WebElement source, WebElement target) {
        action.clickAndHold(source).moveToElement(target).perform();
        return this;
    }

    public boolean isEquals(WebElement elem, String toCompare) {
        return elem.getCssValue("background-color").equals(toCompare);
    }

}
