package test.widgets;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.widgets.ProgressBarPage;
import test.BaseTest;

public class TestProgressBarPage extends BaseTest {

    private ProgressBarPage progressBarPage;
    private final static String desiredProgress = "89%";

    @BeforeClass
    public void init() {
        progressBarPage = new ProgressBarPage(driver);
    }

    @Test(priority = 1)
    public void goTo() {
        progressBarPage.go();
    }

    @Test(priority = 2)
    public void buttonName() {
        Assert.assertEquals(
                progressBarPage
                        .getStartStopButton().getText(),
                "Start"
        );
        Assert.assertEquals(
                progressBarPage
                        .startStopButtonClick()
                        .getStartStopButton().getText(),
                "Stop"
        );
        Assert.assertEquals(
                progressBarPage
                        .waitngResetButton(progressBarPage.getResetButton())
                        .getResetButton().getText(),
                "Reset"
        );
        Assert.assertEquals(
                progressBarPage.getSuccess().getText(),
                "100%"
        );
        Assert.assertEquals(
                progressBarPage
                        .resetButtonClick()
                        .getInProgress().getText(),
                "0%"
        );

    }

    @Test(priority = 3)
    public void progress() {
        Assert.assertEquals(
                progressBarPage
                        .startStopButtonClick()
                        .waitingExactNumber(desiredProgress)
                        .getInProgress().getText(),
                desiredProgress
        );
    }
}
