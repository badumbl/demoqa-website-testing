package test.alertsFrameWindows;

import objects.alertsFrameWindows.AlFrWi;
import objects.alertsFrameWindows.Alerts;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;


public class TestAlerts extends BaseTest {

    private Alerts alertsPage;
    private AlFrWi afw;
    private static final String TEXT_FOR_ALERT_INPUT = "Test for alert text";
    private static final String ALERT_BUTTON_TEXT = "You clicked a button";
    private static final String ALERT_FIVE_SEC_BUTTON_TEXT = "This alert appeared after 5 seconds";
    private static final String ALERT_CONFIRM_BUTTON_TEXT = "Do you confirm action?";
    private static final String ALERT_CONFIRMED_TEXT = "You selected Ok";
    private static final String ALERT_DECLINED_TEXT = "You selected Cancel";
    private static final String ALERT_PROMPT_BUTTON_TEXT = "Please enter your name";
    private static final String ALERT_PROMPT_Result_TEXT = "You entered " + TEXT_FOR_ALERT_INPUT;

    @BeforeClass
    public void init() {
        alertsPage = new Alerts(driver);
        super.passMainPage();
        afw = new AlFrWi(driver);
    }

    @Test(priority = 1)
    public void goToAlerts() {
        afw.go();
        alertsPage.goAlerts();
    }

    @Test(priority = 2)
    public void alertButton() {
        Assert.assertTrue(
                alertsPage
                        .alertButton()
                        .isAlertTextRight(ALERT_BUTTON_TEXT)
        );
        alertsPage.acceptAlert();
    }

    @Test(priority = 2)
    public void alertFiveButton() {
        Assert.assertTrue(
                alertsPage
                        .alertFiveSec()
                        .waitTillAlert()
                        .isAlertTextRight(ALERT_FIVE_SEC_BUTTON_TEXT));
        alertsPage.acceptAlert();
    }

    @Test(priority = 2)
    public void alertConfirmButton() {
        Assert.assertTrue(
                alertsPage
                        .alertConfirm()
                        .isAlertTextRight(ALERT_CONFIRM_BUTTON_TEXT)
        );
        Assert.assertTrue(
                alertsPage
                        .acceptAlert()
                        .isAlertConfirmResultRight(ALERT_CONFIRMED_TEXT)
        );
        Assert.assertTrue(
                alertsPage
                        .alertConfirm()
                        .declineAlert()
                        .isAlertConfirmResultRight(ALERT_DECLINED_TEXT)
        );
    }

    @Test(priority = 2)
    public void alertPromptButton() {
        Assert.assertTrue(
                alertsPage
                        .alertPrompt()
                        .isAlertTextRight(ALERT_PROMPT_BUTTON_TEXT)
        );
        Assert.assertTrue(
                alertsPage
                        .sendKeysToAlert(TEXT_FOR_ALERT_INPUT)
                        .acceptAlert()
                        .isAlertPromptResultRight(ALERT_PROMPT_Result_TEXT)
        );
    }
}
