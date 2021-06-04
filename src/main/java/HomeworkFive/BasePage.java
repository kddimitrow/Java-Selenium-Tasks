package HomeworkFive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actionsBuilder;
    protected int timeOut = 10;



    public BasePage(WebDriver Driver) {
        this.driver = Driver;
        wait = new WebDriverWait(driver, timeOut);
        actionsBuilder = new Actions(driver);
    }


    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public Actions getActionsBuilder() {
        return actionsBuilder;
    }

    public void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void scrollToElementByItsCoordinates(WebElement element) {
        int x = element.getLocation().getX();
        int y = element.getLocation().getY();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + ", " + y + ")");
    }


    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }




}
