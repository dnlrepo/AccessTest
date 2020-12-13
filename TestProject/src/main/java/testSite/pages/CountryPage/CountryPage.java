package testSite.pages.CountryPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static testSite.DriverFactory.*;

public class CountryPage {

    private CountryPage(){
        //hide it
    }

    public static CountryPage getCountryPage(){
        return new CountryPage();
    }

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();
    WebElement element;
    List<WebElement> elements;


    public void setStatus(){

        wait.until(ExpectedConditions.attributeContains(By.cssSelector("h1"), "innerHTML", "\uD83C\uDDEE\uD83C\uDDEA Ireland"));
        element =  driver.findElement(By.cssSelector("h1"));
        Assert.assertEquals(element.getAttribute("innerHTML"), "\uD83C\uDDEE\uD83C\uDDEA Ireland", "Country assertion failed!");
        elements = driver.findElements(By.cssSelector("button"));
        elements.get(1).click();

        element = driver.findElement(By.cssSelector("#root > div > div.sc-bdnylx.sc-fujyUd.ihAysR.dAHnJY > div.sc-bdnylx.dBAEzr > div > a"));
        element.click();//Sends the user back to the main page
        driver.findElement(By.cssSelector(".sc-gtssRu.sc-dlnjPT.sc-jSFkmK.gmjWml.cuIYFB.izwPze")).click();//Sends the user back to the home page



    }

}


