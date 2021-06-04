package HomeworkThree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AuthenticationPage extends BasePage{


    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }



    WebElement createAccountEmailForm = getDriver().findElement(By.id("email_create"));

    WebElement buttonCreateAccount = getDriver().findElement(By.id("SubmitCreate"));

    public void writeEmailAddressForCreatingTheAccount(String emailAddress){
        createAccountEmailForm.click();
        createAccountEmailForm.sendKeys(emailAddress);
    }

    public void clickCreateAccountButton(){
        buttonCreateAccount.click();
    }











}
