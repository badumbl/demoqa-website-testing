package objects.alertsFrameWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Frames {

    private WebDriver driver;

    public Frames(WebDriver driver) {
        this.driver = driver;
    }

    public void go() {
        driver.findElement(By.xpath("//span[text() = 'Frames']")).click();
    }

    public void big() {
        driver.switchTo().frame("frame1");
    }

    public void small() {
        driver.switchTo().frame("frame2");
    }
    public void mainFrame(){
        driver.switchTo().parentFrame();
    }
}
