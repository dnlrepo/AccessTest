package testSite.pages.Home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static testSite.DriverFactory.*;


public class HomePage {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();
    WebElement element;
    List<WebElement> elements;

    private HomePage(){
        //hide it
    }

    public static HomePage getHomePage(){
        return new HomePage();
    }

    public void goToCountries(){

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        Assert.assertEquals(title, "React App", "Title assertion failed!");


        driver.findElement(By.cssSelector(".sc-gtssRu.sc-dlnjPT.sc-jSFkmK.gmjWml.cuIYFB.izwPze")).click();

    }

    public void assertFinalResults(){
        elements = driver.findElements(By.cssSelector(".sc-bdnylx.sc-cxNIbT.gatfpy.caQbbb"));

        Assert.assertEquals(elements.get(1).getAttribute("innerHTML"), "2", "Visited number assertion failed!"); //Testing the final results after the process (visited)
        Assert.assertEquals(elements.get(2).getAttribute("innerHTML"), "4", "To visit number assertion failed!"); //Testing the final results after the process (To visit)

        //I could also click both reset buttons and then go and recheck the whole test steps that is is cleared, but that would be a bit of an overkill with the 1-2 time spent on the task constraints
    }

}
