package HomeworkFour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage extends BasePage {


    public HomePage(WebDriver driver) {
        super(driver);

    }

    WebElement signInButton = getDriver().findElement(By.xpath("//*[@class=\"login\"]"));


    public void clickOnSignInButton(){
       getWait().until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
    }

    public void checkIsHomePage(){
        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php"));

        Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php" );

    }

}
