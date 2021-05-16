package test.widgets;

import objects.widgets.DatePicker;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDatePicker extends HelperClass {

    private DatePicker dp;
    private String day;
    private String month;
    private String year;
    private String hoursAndMinutes;
    private LocalDate todaysDate = LocalDate.now();
    private LocalDateTime dateWithTime = LocalDateTime.now();


    @BeforeClass
    public void init() {
        this.dp = new DatePicker(getDriver());
    }

    @Test(priority = 1)
    public void goTo() {
        dp.go();
    }


    @Test(priority = 2)
    public void selectDate() {
        convertDate();
        dp.sDate(day, month, year);
        Assert.assertEquals(getDriver().findElement(By.xpath("//input[@id='datePickerMonthYearInput']"))
                .getAttribute("value"), todaysDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
    }

    @Test(priority = 2)
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
