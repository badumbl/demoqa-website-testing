package test.elements;

import objects.elements.CheckBox;
import objects.elements.ElementsMenu;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestCheckBox extends BaseTest {

    private CheckBox checkBoxPage;
    private ElementsMenu em;
    private final static String result = "react";

    @BeforeClass
    public void init() {
        checkBoxPage = new CheckBox(driver);
        em = new ElementsMenu(driver);
        super.passMainPage();
        em.goToElementsMenu();
    }

    @Test
    public void checkReactBox() {
        Assert.assertTrue(
                checkBoxPage
                        .goToCheckBox()
                        .checkReact()
                        .isChoiceCorrect(result)
        );
    }
}
