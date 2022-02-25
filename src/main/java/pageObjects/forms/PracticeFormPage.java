package pageObjects.forms;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObjects.BasePage;

import java.util.ArrayList;

@Data
public class PracticeFormPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Forms')]")
    private WebElement formsMenu;
    @FindBy(xpath = "//span[contains(text(),'Practice Form')]")
    private WebElement practiceFormPage;
    @FindBy(xpath = "//form[@id='userForm']")
    private WebElement userForm;
    @FindBy(xpath = "//div[@class='subjects-auto-complete__option subjects-auto-complete__option--is-focused css-1n7v3ny-option']")
    private WebElement visible;
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement useremail;
    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement userNumber;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirth;
    @FindBy(xpath = "//div[@class='subjects-auto-complete__input']")
    private WebElement subjectsField;
    @FindBy(xpath = "//textarea[@id='currentAddress']")
    private WebElement currentaddress;
    @FindBy(xpath = "//div[contains(text(),'Select State')]")
    private WebElement stateField;
    @FindBy(xpath = "//div[contains(text(),'Select City')]")
    private WebElement cityField;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit;
    @FindBy(xpath = "//tr//td[contains(text(), 'Student Name')]//following::td")
    private WebElement nameResult;
    @FindBy(xpath = "//tr//td[contains(text(), 'Student Email')]//following::td")
    private WebElement emailResult;
    @FindBy(xpath = "//tr//td[contains(text(), 'Gender')]//following::td")
    private WebElement genderResult;
    @FindBy(xpath = "//tr//td[contains(text(), 'Mobile')]//following::td")
    private WebElement mobileResult;
    @FindBy(xpath = "//tr//td[contains(text(), 'Date of Birth')]//following::td")
    private WebElement dateOfBirthResult;
    @FindBy(xpath = "//tr//td[contains(text(), 'Subjects')]//following::td")
    private WebElement subjectsResult;
    @FindBy(xpath = "//tr//td[contains(text(), 'Hobbies')]//following::td")
    private WebElement hobbiesResult;
    @FindBy(xpath = "//tr//td[contains(text(), 'Address')]//following::td")
    private WebElement addressResult;
    @FindBy(xpath = "//tr//td[contains(text(), 'State and City')]//following::td")
    private WebElement statCityResult;
    @FindBy(xpath = "//*[@id='closeLargeModal']")
    private WebElement closeResult;
    @FindBy(xpath = "//img[@title='Ad.Plus Advertising']")
    private WebElement advertisementClose;
    private int i = 0;

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }

    public PracticeFormPage goToForms() {
        formsMenu.click();
        waitClickable(practiceFormPage);
        return this;
    }

    public PracticeFormPage goToPractice() {
        practiceFormPage.click();
        return this;
    }

    public void fillForm(String fName, String lName, String email, String gender, String mobile,
                         String dayBirth, String monthBirth, int yearBirth, ArrayList<String> subjects,
                         String hobbies, String address, String state, String city) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        useremail.sendKeys(email);
        driver.findElement(By.xpath("//label[contains(text(),'" + gender + "')]")).click();
        userNumber.sendKeys(mobile);
        dateOfBirth.click();
        driver.findElement(By.xpath("//option[contains(text(),'" + monthBirth + "')]")).click();
        driver.findElement(By.xpath("//option[contains(text(),'" + yearBirth + "')]")).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--" + dayBirth + "']"))
                .click();
        subjectsField.click();
        for (String subject : subjects) {
            super.action.sendKeys(subject).build().perform();
            super.waitAndClick(visible);
        }
        super.js.executeScript("window.scrollBy(0,250)");
        driver.findElement(By.xpath("//label[contains(text(),'" + hobbies + "')]")).click();
        currentaddress.sendKeys(address);
        advertisementClose.click();
        stateField.click();
        driver.findElement(By.xpath("//div[text()='" + state + "']")).click();
        cityField.click();
        driver.findElement(By.xpath("//div[text()='" + city + "']")).click();
        submit.click();
    }
    public PracticeFormPage closeResults() {
        closeResult.click();
        return this;
    } public PracticeFormPage submitData() {
        submit.click();
        return this;
    }
    public boolean isHighlighted(String value){
        return wait.until((WebDriver) -> userNumber
                .getCssValue("border-color").equals(value));
    }
}
