package test.widgets;

import objects.widgets.Widgets;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

public class TestWidgets extends HelperClass {

    private Widgets wi;

    @BeforeClass
    public void init() {
        wi = new Widgets(getDriver());
        super.passMainPage();
    }

    @Test
    public void goToWidgets() {
        wi.go().click();
    }
}
