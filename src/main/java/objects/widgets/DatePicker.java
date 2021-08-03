package objects.widgets;

import lombok.Data;
import objects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

@Data
public class DatePicker extends BasePage {


    @FindBy(xpath = "//span[contains(text(),'Date Picker')]")
    private WebElement datePicker;
    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']")
    private WebElement dayMonthYear;
    @FindBy(xpath = "//input[@id='dateAndTimePickerInput']")
    private WebElement dateAndTime;

    public DatePicker(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public DatePicker go() {
        datePicker.click();
        waitVisibility(dayMonthYear);
        return this;
    }

    public DatePicker sDate(String day, String month, String year) {
        dayMonthYear.click();
        driver.findElement(By.xpath("//option[@value='" + year + "']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'" + month + "')]")).click();
        try {
            pickDayInsideTheMonth(day).click();
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        return this;
    }

    public DatePicker sDateTime(String day, String month, String year, String hoursAndMinutes) {
        dateAndTime.click();
        driver.findElement(By.xpath("//span[@class='react-datepicker__year-read-view--selected-year']")).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__year-dropdown']//*[contains(text(),'" + year + "')]")).click();
        driver.findElement(By.xpath("//span[@class='react-datepicker__month-read-view--selected-month']")).click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__month-dropdown']//*[contains(text(),'" + month + "')]")).click();
        try {
            pickDayInsideTheMonth(day).click();
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        driver.findElement(By.xpath("//li[text()='" + hoursAndMinutes + "']")).click();
        return this;
    }

    private WebElement pickDayInsideTheMonth(String day) {
        List<WebElement> list = driver.findElements(By.xpath("//div[text()='" + day + "']"));
        for (WebElement elem : list) {
            if (!elem.getAttribute("class").contains("outside-month")) {
                return elem;
            }
        }
        return null;
    }
}
