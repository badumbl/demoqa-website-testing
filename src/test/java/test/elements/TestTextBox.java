package test.elements;

import objects.elements.ElementsMenu;
import objects.elements.TextBox;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestTextBox extends BaseTest {

    private TextBox textBoxPage;
    private ElementsMenu em;
    private static final String FULL_NAME = "full name";
    private static final String EMAIL = "email@dot.com";
    private static final String ADDRESS = "address";
    private static final String PERM_ADDRESS = "permanent address";
    private static final String FULL_NAME_TEXT = "Name:" + FULL_NAME;
    private static final String EMAIL_TEXT = "Email:" + EMAIL;
    private static final String ADDRESS_TEXT = "Current Address :" + ADDRESS;
    private static final String PERM_ADDRESS_TEXT = "Permananet Address :" + PERM_ADDRESS;


    @BeforeClass
    public void init() {
        textBoxPage = new TextBox(driver);
        em = new ElementsMenu(driver);
        super.passMainPage();
    }

    @Test
    public void fillFormAndSubmit() {
        em.goToElementsMenu();
        textBoxPage
                .goToTextBox()
                .submitForm(FULL_NAME, EMAIL, ADDRESS, PERM_ADDRESS);
        Assert.assertEquals(FULL_NAME_TEXT, textBoxPage.getNameTextOutput().getText());
        Assert.assertEquals(EMAIL_TEXT, textBoxPage.getEmailTextOutput().getText());
        Assert.assertEquals(ADDRESS_TEXT, textBoxPage.getAddressTextOutput().getText());
        Assert.assertEquals(PERM_ADDRESS_TEXT, textBoxPage.getPermAddressTextOutput().getText());
    }


}
