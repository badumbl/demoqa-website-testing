package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebTables {

    private WebDriver driver;

    public WebTables(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement goToTables() {
        return driver.findElement(By.xpath("//span[contains(text(),'Web Tables')]"));
    }

    public WebElement addButton() {
        return driver.findElement(By.xpath("//button[@id='addNewRecordButton']"));
    }

    public void register(String firstName, String lastName, String email, String age, String salary, String department) {
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys(age);
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys(salary);
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys(department);

    }

    public void editDept(String editedDepartment) {
        driver.findElement(By.xpath("//input[@id='department']")).clear();
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys(editedDepartment);
    }


    public WebElement search() {
        return driver.findElement(By.xpath("//input[@id='searchBox']"));
    }

    public WebElement delete(String firstName) {
        return driver.findElement(By.xpath("//div[text()='" + firstName + "']/..//span[@title='Delete']"));
    }

    public WebElement submitBtn() {
        return driver.findElement(By.xpath("//button[@id='submit']"));
    }

    public WebElement editBtn(String department) {
        return driver.findElement(By.xpath("//div[text()='" + department + "']/..//span[@class='mr-2']"));
    }

}
