package pageObjects.widgets;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class SliderPage extends WidgetsMainPage {

    @FindBy(xpath = "//span[contains(text(),'Slider')]")
    WebElement sliderPage;
    @FindBy(xpath = "//input[@class='range-slider range-slider--primary']")
    WebElement slider;
    @FindBy(xpath = " //input[@id='sliderValue']")
    WebElement sliderValue;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    public SliderPage go() {
        waitVisibility(sliderPage);
        sliderPage.click();
        waitingElementOnPage(slider);
        return this;
    }

    public SliderPage moveSlider() {
        action
                .moveToElement(slider)
                .dragAndDropBy(slider, 50, 0)
                .release()
                .build()
                .perform();
        return this;
    }
}
