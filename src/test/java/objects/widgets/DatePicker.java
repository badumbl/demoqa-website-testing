package objects.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePicker {

    private WebDriver driver;


    public DatePicker(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.findElement(By.xpath("//span[contains(text(),'Date Picker')]")).click();
    }

    public void sDate(String day, String month, String year) {

        driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']")).click();
        driver.findElement(By.xpath("//option[@value='" + year + "']")).click();
        driver.findElement(By.xpath("//option[contains(text(),'" + month + "')]")).click();
        driver.findElement(By.xpath("//div[text()='" + day + "']")).click();
    }

    public void sDateTime(String day, String month, String year, String hoursAndMinutes) {
        driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'2021')]")).click();
        driver.findElement(By.xpath("//div[text()='" + year + "']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'May')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + month + "')]")).click();
        driver.findElement(By.xpath("//div[text()='" + day + "']")).click();
        driver.findElement(By.xpath("//li[text()='" + hoursAndMinutes + "']")).click();
    }
}
