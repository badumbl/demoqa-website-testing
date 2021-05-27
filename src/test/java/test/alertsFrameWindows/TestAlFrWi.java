package test.alertsFrameWindows;

import objects.alertsFrameWindows.AlFrWi;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestAlFrWi extends HelperClass {

    private AlFrWi afw;

    @BeforeClass
    public void init() {
        afw = new AlFrWi(getDriver());
        super.passMainPage();
    }

    @Test
    public void goToPage() {
        afw.go().click();
    }

}
