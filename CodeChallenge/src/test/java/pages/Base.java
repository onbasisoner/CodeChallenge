package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


//This class is for main functions
public class Base {

    public static WebDriver driver;

    private final Actions actions;

    public Base(WebDriver driver){
        Base.driver = driver;
        actions = new Actions(driver);
    }


    //Take SS after completing cases
    public void takeScreenshot(String screenshotName){
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            File destination = new File("target/" + screenshotName + "_" + timestamp + ".png");
            FileUtils.copyFile(source, destination);

            System.out.println("Took Screenshot " + "target/" + screenshotName + timestamp + ".png");

        } catch (IOException IOEx) {
            System.out.println(IOEx);
        }
    }

    //Basic click functions
    public void click(WebElement element, int timeout) {
        try {
            actions.moveToElement(element).perform();
            waitForElementToBeVisible(element, timeout);
            waitForElementToBeClickable(element, timeout);
            element.click();
            wait(500);
        } catch (WebDriverException wdex) {
            System.out.println(wdex);
        }
    }


    //Especially for this project, it's for selecting currency on page
    public void clickAndSelect(WebElement element, int timeout, String text){
        waitForElementToBeVisible(element,timeout);
        waitForElementToBeClickable(element,timeout);
        click(element,5);
        actions.sendKeys(Keys.chord(Keys.BACK_SPACE,text,Keys.ARROW_DOWN,Keys.ENTER)).perform();
        wait(500);
    }

    //This is for writing text
    public void type(WebElement element, int timeout, String inputText) {
        try {
            waitForElementToBeVisible(element, timeout);
            waitForElementToBeClickable(element, timeout);

            click(element,5);
            actions.sendKeys(Keys.BACK_SPACE);
            actions.sendKeys(inputText);

        } catch (WebDriverException wdex) {
            System.out.println(wdex);
        }
    }


    public void waitForElementToBeVisible(WebElement element, int timeout) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOf(element));
        } catch (WebDriverException wdex) {
            System.out.println(wdex);
        }

    }

    public void waitForElementToBeClickable(WebElement element, int timeout) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(element));
        } catch (WebDriverException wdex) {
            System.out.println(wdex);
        }
    }


    public void wait(int waitInMs){
        try {
            Thread.sleep(waitInMs);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
