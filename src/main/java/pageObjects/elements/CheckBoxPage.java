package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBoxPage extends ElementsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Check Box')]")
    private WebElement checkBoxPage;
    @FindBy(xpath = "//li/span[@class='rct-text']/*[@class='rct-collapse rct-collapse-btn']")
    private WebElement homeExpand;
    @FindBy(xpath = "//*[@id='tree-node-documents']/../../*[@class='rct-collapse rct-collapse-btn']")
    private WebElement documentsExpand;
    @FindBy(xpath = "//*[@id='tree-node-workspace']/../../*[@class='rct-collapse rct-collapse-btn']")
    private WebElement workSpaceExpand;
    @FindBy(xpath = "//span[contains(text(),'React')]/../span")
    private WebElement react;
    @FindBy(xpath = "//span[@class='text-success']")
    private WebElement successText;

    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public CheckBoxPage goToCheckBox() {
        waitClickable(checkBoxPage);
        checkBoxPage.click();
        waitClickable(homeExpand);
        return this;
    }

    public CheckBoxPage checkReact() {
        homeExpand.click();
        waitClickable(documentsExpand);
        documentsExpand.click();
        waitClickable(workSpaceExpand);
        workSpaceExpand.click();
        waitClickable(react);
        react.click();
        return this;
    }

    public boolean isChoiceCorrect(String text) {
        return successText.getText().equals(text);
    }
}
