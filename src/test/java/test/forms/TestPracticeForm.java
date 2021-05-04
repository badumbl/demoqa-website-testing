package test.forms;

import objects.forms.PracticeForm;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.ArrayList;

public class TestPracticeForm extends HelperClass {

    private PracticeForm pf;
    private String fName = "First Name";
    private String lName = "Last Name";
    private String email = "email@test.com";
    private String gender = "Male";
    private String mobile = "1234567890";
    //TBU
    private String dayBirth = "001";
    private String monthBirth = "January";
    private int yearBirth = 1988;
    private ArrayList<String> subjects = new ArrayList<>();
    private String subjectsFormatted = "";
    private String hobbies = "Sports";
    private String address = "test address 123";
    private String state = "Rajasthan";
    private String city = "Jaipur";


    @BeforeClass
    public void init() {
        pf = new PracticeForm(getDriver());
        subjects.add("Computer Science");
        subjects.add("English");
        subjects.add("Arts");
    }

    @Test(priority = 1)
    public void goToForms() {
        pf.goToForm();
    }

    @Test(priority = 2)
    public void fillTheForm() {
        pf.fillForm(fName, lName, email, gender, mobile, dayBirth, monthBirth, yearBirth, subjects,
                hobbies, address, state, city);
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'Student Name')]//following::td")).getText(),
                fName + " " + lName);
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'Student Email')]//following::td")).getText(),
                email);
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'Gender')]//following::td")).getText(),
                gender);
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'Mobile')]//following::td")).getText(),
                mobile);
        //TBU
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'Date of Birth')]//following::td")).getText(),
                "01 January,1988");
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'Subjects')]//following::td")).getText(),
                subjectsFormat());
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'Hobbies')]//following::td")).getText(),
                hobbies);
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'Address')]//following::td")).getText(),
                address);
        Assert.assertEquals(getDriver()
                        .findElement(By.xpath("//tr//td[contains(text(), 'State and City')]//following::td")).getText(),
                state + " " + city);
    }

    //TBU
    @Test(priority = 3)
    public void fillTheFormIncorrectly() {

    }

    public String subjectsFormat() {
        for (int i = 0; i < subjects.size(); i++) {
            if (i == subjects.size() - 1) {
                subjectsFormatted += subjects.get(i) + "";
            } else {
                subjectsFormatted += subjects.get(i) + ", ";
            }
        }
        return subjectsFormatted;
    }
}
