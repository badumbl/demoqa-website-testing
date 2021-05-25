package test.widgets;

import objects.widgets.DatePicker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class TestDatePicker extends HelperClass {

    private DatePicker dp;
    private String day;
    private String month;
    private String year;
    private String hoursAndMinutes;
    private LocalDate todaysDate = LocalDate.now();
    private LocalDateTime dateWithTime = LocalDateTime.now();
    private Wait<WebDriver> wait;


    @BeforeClass
    public void init() {
        this.dp = new DatePicker(getDriver());
        wait = new FluentWait<WebDriver>(getDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.MILLISECONDS)
                .ignoring(NoSuchElementException.class);
    }

    @Test(priority = 1)
    public void goTo() {
        wait.until((WebDriver wb) -> getDriver().findElement(By.xpath("//span[contains(text(),'Date Picker')]")).isDisplayed());
        dp.go();
        wait.until((WebDriver wb) -> getDriver().findElement(By.xpath("//input[@id='datePickerMonthYearInput']")).isDisplayed());
    }


    @Test(priority = 2)
    public void selectDate() {
        convertDate();
        dp.sDate(day, month, year);
        Assert.assertEquals(getDriver().findElement(By.xpath("//input[@id='datePickerMonthYearInput']"))
                .getAttribute("value"), todaysDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
    }

    @Test(priority = 3)
    public void selectDateAndTime() {
        convertDateTime();
        dp.sDateTime(day, month, year, hoursAndMinutes);
        Assert.assertEquals(getDriver().findElement(By.xpath("//input[@id='dateAndTimePickerInput']"))
                .getAttribute("value"), dateWithTime.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy h:mm a")));
    }

    public void convertDate() {
        String[] dateArray = todaysDate.format(DateTimeFormatter.ofPattern("d/MMMM/yyyy")).split("/");
        day = dateArray[0];
        month = dateArray[1];
        year = dateArray[2];

    }

    public void convertDateTime() {
        int minute = dateWithTime.getMinute();
        if (minute > 45) {
            dateWithTime = dateWithTime.plusHours(1L).withMinute(0);
        } else {
            dateWithTime = dateWithTime.withMinute(minute < 30 ? minute < 15 ? 15 : 30 : 45);
        }
        String[] dateArray = dateWithTime.format(DateTimeFormatter.ofPattern("d/MMMM/yyyy HH:mm")).split("/|\\s");
        day = dateArray[0];
        month = dateArray[1];
        year = dateArray[2];
        hoursAndMinutes = dateArray[3];
    }
}
