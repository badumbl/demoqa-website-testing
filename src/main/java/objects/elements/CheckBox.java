package objects.elements;

import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckBox extends BasePage {

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

    public CheckBox(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public CheckBox goToCheckBox() {
        checkBoxPage.click();
        return this;
    }

    public CheckBox checkReact() {
        js.executeScript("arguments[0].scrollIntoView();", homeExpand);
        homeExpand.click();
        documentsExpand.click();
        workSpaceExpand.click();
        react.click();
        return this;
    }

    public boolean isChoiceCorrect(String text) {
        return successText.getText().equals(text);
    }
}
