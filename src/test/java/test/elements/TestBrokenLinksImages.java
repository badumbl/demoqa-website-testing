package test.elements;

import objects.elements.BrokenLinksImages;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
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
        bli.goToBrokenLinks();
    }

    @Test(priority = 2)
    public void findBrokenImages() {

    }

    @Test(priority = 2)
    public void testLinks() {
        int iBrokenLinkCount = 0;

        try {
            List<WebElement> link_list = driver.findElements(By.xpath("//a"));
            /* Print the total number of links on the page */
            System.out.println("The page under test has " + link_list.size() + " links");
            for (WebElement link : link_list) {
                if (link != null) {
                    HttpClient client = HttpClientBuilder.create().build();
                    HttpGet request = new HttpGet(link.getAttribute("href"));
                    HttpResponse response = client.execute(request);
                    /* For valid links, the HttpStatus will be 200 */
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
