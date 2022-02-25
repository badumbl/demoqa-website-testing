package test.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.elements.CheckBoxPage;
import test.BaseTest;

public class TestCheckBoxPage extends BaseTest {

    private CheckBoxPage checkBoxPage;
    private final static String result = "react";

    @BeforeClass
    public void init() {
        checkBoxPage = new CheckBoxPage(driver);
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
