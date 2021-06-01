package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class DatePicker {

    private WebDriver driver;


    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement go() {
        return driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]"));
    }

    public void sDate(String day, String month, String year) {
        driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']")).click();
        driver.findElement(By.xpath("//option[@value='" + year + "']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'" + month + "')]")).click();
        try {
            pickDayInsideTheMonth(day).click();
        } catch (NullPointerException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }


    public void sDateTime(String day, String month, String year, String hoursAndMinutes) {
        driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']")).click();
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
