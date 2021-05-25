package test.elements;

import objects.elements.BrokenLinksImages;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.HelperClass;

import java.util.List;

public class TestBrokenLinksImages extends HelperClass {

    private BrokenLinksImages bli;
    private WebDriver driver;


    @BeforeClass
    public void init() {
        driver = getDriver();
        bli = new BrokenLinksImages(driver);
    }

    @Test(priority = 1)
    public void goToBrokenLinksAndImages() {
        //Scroll is needed, because footer blocks button on smaller monitors
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)");
        bli.goToBrokenLinks().click();
    }

    @Test(priority = 2)
    public void findBrokenImages() {

    }

    @Test(priority = 2)
    public void testLinks() {
        /*RestAssured.baseURI = getDriver().getCurrentUrl();
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(getDriver().findElement(By
                .xpath("//a[contains(text(),'Click Here for Broken Link')]"))
                .getAttribute("href"));
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 500);*/

        int iBrokenLinkCount = 0;
        try {
            List<WebElement> link_list = driver.findElements(By.xpath("//a"));
            // Print the total number of links on the page
            System.out.println("The page under test has " + link_list.size() + " links");
            for (WebElement link : link_list) {
                if (link != null) {
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpGet request = new HttpGet(link.getAttribute("href"));
                    HttpResponse response = client.execute(request);
                    // For valid links, the HttpStatus will be 200
                    if (response.getStatusLine().getStatusCode() != 200) {
                        System.out.println("'" + link.getText() + "'" + " - is broken "
                                + "(" + link.getAttribute("href") + ")");
                        Assert.assertEquals(response.getStatusLine().getStatusCode(), 500);
                        iBrokenLinkCount++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("The page has " + iBrokenLinkCount + " broken links");
    }
}
