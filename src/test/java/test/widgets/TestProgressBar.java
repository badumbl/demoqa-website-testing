package test.widgets;

import objects.widgets.ProgressBar;
import objects.widgets.Widgets;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestProgressBar extends BaseTest {

    private ProgressBar progressBarPage;
    private Widgets wd;
    private final static String desiredProgress = "89%";

    @BeforeClass
    public void init() {
        progressBarPage = new ProgressBar(driver);
        wd = new Widgets(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        wd.go();
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
