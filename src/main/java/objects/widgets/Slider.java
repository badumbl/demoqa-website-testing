package objects.widgets;

import lombok.Data;
import objects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class Slider extends BasePage {

    @FindBy(xpath = "//span[contains(text(),'Slider')]")
    WebElement sliderPage;
    @FindBy(xpath = "//input[@class='range-slider range-slider--primary']")
    WebElement slider;
    @FindBy(xpath = " //input[@id='sliderValue']")
    WebElement sliderValue;

    public Slider(WebDriver driver) {
        super(driver);
        driver.get(BASE_URL);
    }

    public Slider go() {
        sliderPage.click();
        return this;
    }

    public Slider moveSlider() {
        action.dragAndDropBy(slider, 50, 0).perform();
        return this;
    }
}
