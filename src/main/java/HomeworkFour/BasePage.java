package HomeworkFour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

   protected WebDriver driver;
   protected WebDriverWait wait;
   protected Actions actionBuilder;

   protected int timeOut = 10;

   public BasePage(WebDriver driver) {
      this.driver = driver;
      wait = new WebDriverWait(driver, timeOut);
      actionBuilder = new Actions(driver);
   }

   public WebDriver getDriver() {
      return driver;
   }

   public WebDriverWait getWait() {
      return wait;
   }

   protected void waitForElementToAppear(By locator) {
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }


   public Actions getActionBuilder() {
      return actionBuilder;
   }



}
