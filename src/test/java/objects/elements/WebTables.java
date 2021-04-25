package objects.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTables {

    private WebDriver driver;

    public WebTables(WebDriver driver) {
        this.driver = driver;
    }

    public void goToTables() {
        driver.findElement(By.xpath("//span[contains(text(),'Web Tables')]")).click();
    }

    public void addButton() {
        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
    }

    public void register(String firstName, String lastName, String email, String age, String salary, String department) {
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys(age);
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys(salary);
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys(department);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }

    public void editDept(String department, String editedDepartment) {
        driver.findElement(By.xpath("//div[text()='" + department + "']/..//span[@class='mr-2']")).click();
        driver.findElement(By.xpath("//input[@id='department']")).clear();
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys(editedDepartment);
        driver.findElement(By.xpath("//button[@id='submit']")).click();
    }


    public void search(String lastName) {
        driver.findElement(By.xpath("//input[@id='searchBox']")).sendKeys(lastName);
    }

    public void delete(String firstName) {
        driver.findElement(By.xpath("//div[text()='" + firstName + "']/..//span[@title='Delete']")).click();
    }


}
