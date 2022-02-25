package test.forms;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.forms.PracticeFormPage;
import test.BaseTest;

import java.util.ArrayList;

public class TestPracticeFormPage extends BaseTest {

    private PracticeFormPage practiceFormPage;
    private static String subjectsFormatted = "";

    private final static String fName = "First Name";
    private final static String lName = "Last Name";
    private final static String email = "email@test.com";
    private final static String gender = "Male";
    private final static String mobile = "1234567890";
    private final static String dayBirth = "001";
    private final static String monthBirth = "January";
    private final static int yearBirth = 1988;
    private final static String fullDateOfBirth = "01 January,1988";
    private final static ArrayList<String> subjects = new ArrayList<>();
    private final static String hobbies = "Sports";
    private final static String address = "test address 123";
    private final static String state = "Rajasthan";
    private final static String city = "Jaipur";


    @BeforeClass
    public void init() {
        practiceFormPage = new PracticeFormPage(driver);
        subjects.add("Computer Science");
        subjects.add("English");
        subjects.add("Arts");
        
    }

    @Test(priority = 1)
    public void goToForms() {
        practiceFormPage.goToForms();
        practiceFormPage.goToPractice();
        practiceFormPage.setI(29);
    }

    @Test(priority = 2)
    public void fillTheForm() {
        practiceFormPage.fillForm(fName, lName, email, gender, mobile, dayBirth, monthBirth, yearBirth, subjects,
                hobbies, address, state, city);
        Assert.assertEquals(practiceFormPage.getNameResult().getText(), fName + " " + lName);
        Assert.assertEquals(practiceFormPage.getEmailResult().getText(), email);
        Assert.assertEquals(practiceFormPage.getGenderResult().getText(), gender);
        Assert.assertEquals(practiceFormPage.getMobileResult().getText(), mobile);
        Assert.assertEquals(practiceFormPage.getDateOfBirthResult().getText(), fullDateOfBirth);
        Assert.assertEquals(practiceFormPage.getSubjectsResult().getText(), subjectsFormat());
        Assert.assertEquals(practiceFormPage.getHobbiesResult().getText(), hobbies);
        Assert.assertEquals(practiceFormPage.getAddressResult().getText(), address);
        Assert.assertEquals(practiceFormPage.getStatCityResult().getText(), state + " " + city);
        practiceFormPage.closeResults();
    }

    @Test(priority = 3)
    public void fillTheFormIncorrectly() {
        driver.navigate().refresh();
        Assert.assertTrue(
                practiceFormPage
                        .submitData()
                        .isHighlighted("rgb(220, 53, 69)")
        );
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
