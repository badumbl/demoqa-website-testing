package pageObjects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebTablesPage extends ElementsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Web Tables')]")
    private WebElement webTablesPage;
    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    private WebElement addButton;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='age']")
    private WebElement ageField;
    @FindBy(xpath = "//input[@id='salary']")
    private WebElement salaryField;
    @FindBy(xpath = "//input[@id='department']")
    private WebElement departmentField;
    @FindBy(xpath = "//input[@id='searchBox']")
    private WebElement searchBox;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton;


    public WebTablesPage(WebDriver driver) {
        super(driver);
    }

    public WebTablesPage goToTables() {
        waitClickable(webTablesPage);
        webTablesPage.click();
        waitClickable(addButton);
        return this;
    }

    public WebTablesPage register(String firstName, String lastName, String email, String age, String salary, String department) {
        waitClickable(addButton);
        addButton.click();
        waitClickable(firstNameField);
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        ageField.sendKeys(age);
        salaryField.sendKeys(salary);
        departmentField.sendKeys(department);
        submitButton.click();
        return this;
    }

    public WebTablesPage editDept(String currentDepartment, String editedDepartment) {
        editBtn(currentDepartment).click();
        departmentField.clear();
        departmentField.sendKeys(editedDepartment);
        submitButton.click();
        return this;
    }


    public WebTablesPage search(String text) {
        searchBox.sendKeys(text);
        return this;
    }

    public WebTablesPage delete(String text) {
        deleteBtn(text).click();
        return this;
    }

    public WebElement deleteBtn(String firstName) {
        return driver.findElement(By.xpath("//div[text()='" + firstName + "']/..//span[@title='Delete']"));
    }

    public WebElement editBtn(String department) {
        return driver.findElement(By.xpath("//div[text()='" + department + "']/..//span[@title='Edit']"));
    }

    public WebElement findByValue(String value) {
        try {
            return driver.findElement(By.xpath("//div[text()='" + value + "']"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return null;
        }
    }

}
