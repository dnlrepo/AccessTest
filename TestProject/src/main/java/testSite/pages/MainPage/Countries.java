package testSite.pages.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static testSite.DriverFactory.*;

public class Countries {

    private Countries(){
        //hide it
    }

    public static Countries getMainPage(){
        return new Countries();
    }

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();
    WebElement element;
    List<WebElement> elements;


    public void searchBarCheck(){
   driver.findElement(By.cssSelector("[type=text]")).sendKeys("Aus");
   elements = driver.findElements(By.cssSelector(".sc-jrsJCI.emsrNO > tr"));
   Assert.assertEquals(elements.size(), 2, "Unexpected number of results!");



    }

    public void checkBoxCheck(){

        elements = driver.findElements(By.cssSelector(".sc-jrsJCI.emsrNO > tr > td > input"));
        elements.get(0).click();
        elements.get(1).click();
        elements = driver.findElements(By.cssSelector("option"));
        elements.get(1).click();
        elements.get(3).click();

        /*At this point I was planning to have also an actual click test (of the right checkbox) to assert the color change,
        but I was not able to have a quick solution to how to do that as the element is used as a checkbox and the color change is not reflected directly within the HTML*/

    }

    public void singleCountryCheck() {
        //driver.findElement(By.cssSelector("[type=text]")).clear(); //For some reason, there is a "bug" when I use clear here, the textbox will not update the list. So I used backspace instead as a workaround.

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.cssSelector("[type=text]")).sendKeys(Keys.BACK_SPACE);
        }

        element =  driver.findElement(By.cssSelector("#root > div > div.sc-bdnylx.sc-fujyUd.ihAysR.dAHnJY > table > tbody > tr:nth-child(100) > td:nth-child(10)"));
        element.click(); //Mark the country in the 100th position as "Want to go"
        element =  driver.findElement(By.cssSelector("#root > div > div.sc-bdnylx.sc-fujyUd.ihAysR.dAHnJY > table > tbody > tr:nth-child(102)"));
        element.click(); //Sends the user to the page of the 102th country

    }

}


