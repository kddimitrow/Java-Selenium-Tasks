package HomeworkFive;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DemoQaAlertsPage extends BasePage{

    public DemoQaAlertsPage(WebDriver Driver) {
        super(Driver);
    }

    WebElement confirmButton = driver.findElement(By.id("confirmButton"));




    public void clickOkayAfterAlertAppear(){
        confirmButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement confirmTextDisplayed = driver.findElement(By.id("confirmResult"));
       if( confirmTextDisplayed.isDisplayed()){
           String confirmResponseText = confirmTextDisplayed.getText();
           Assert.assertEquals(confirmResponseText, "You selected Ok");
       }


    }

    public void clickCancelAfterAlertAppear(){
        confirmButton.click();

        Alert alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement confirmTextDisplayed = driver.findElement(By.id("confirmResult"));
        if( confirmTextDisplayed.isDisplayed()){
            String confirmResponseText = confirmTextDisplayed.getText();
            Assert.assertEquals(confirmResponseText, "You selected Cancel");
        }


    }


















}
