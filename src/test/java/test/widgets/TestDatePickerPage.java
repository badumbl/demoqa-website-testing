package test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.widgets.DatePickerPage;
import test.BaseTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDatePickerPage extends BaseTest {

    private DatePickerPage datePickerPage;
    private String day;
    private String month;
    private String year;
    private String hoursAndMinutes;
    private final LocalDate todaysDate = LocalDate.now();
    private LocalDateTime dateWithTime = LocalDateTime.now();


    @BeforeClass
    public void init() {
        this.datePickerPage = new DatePickerPage(driver);
        convertDate();
        convertDateTime();
    }

    @Test(priority = 1)
    public void goTo() {
        datePickerPage.go();
    }


    @Test(priority = 2)
    public void selectDate() {
        Assert.assertEquals(
                datePickerPage
                        .sDate(day, month, year)
                        .getDayMonthYear().getAttribute("value"),
                todaysDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
        );
    }

    @Test(priority = 3)
    public void selectDateAndTime() {
        Assert.assertEquals(
                datePickerPage
                        .sDateTime(day, month, year, hoursAndMinutes)
                        .getDateAndTime().getAttribute("value"),
                dateWithTime.format(DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a"))
        );
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
