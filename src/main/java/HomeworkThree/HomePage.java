package HomeworkThree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }


    WebElement signInButton = getDriver().findElement(By.xpath("//*[@class=\"login\"]"));


    public void clickOnSignInButton(){
        signInButton.click();
    }

}
