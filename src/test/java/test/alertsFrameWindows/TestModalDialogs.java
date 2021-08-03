package test.alertsFrameWindows;

import objects.alertsFrameWindows.AlFrWi;
import objects.alertsFrameWindows.ModalDialogs;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.BaseTest;

public class TestModalDialogs extends BaseTest {

    private ModalDialogs modalDialogsPage;
    private AlFrWi afw;
    private static final String smallModalText = "This is a small modal. It has very less content";
    private static final String largeModalText = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

    @BeforeClass
    public void init() {
        modalDialogsPage = new ModalDialogs(driver);
        afw = new AlFrWi(driver);
        super.passMainPage();
    }

    @Test(priority = 1)
    public void goTo() {
        afw.go();
        modalDialogsPage.go();
    }

    @Test(priority = 2)
    public void smallModal() {
        Assert.assertTrue(
                modalDialogsPage
                        .small()
                        .isModalTextCorrect(ModalDialogs.ModalSize.SMALL,smallModalText)
        );
    }

    @Test(priority = 3)
    public void largeModal() {
        Assert.assertTrue(
                modalDialogsPage
                        .large()
                        .isModalTextCorrect(ModalDialogs.ModalSize.LARGE, largeModalText)
        );
    }
}
