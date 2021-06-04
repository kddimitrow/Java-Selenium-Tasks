package HomeworkFour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AuthenticationPage extends BasePage {



    public AuthenticationPage(WebDriver driver) {
        super(driver);

        getWait().until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account"));
    }



    WebElement createAccountEmailForm = getDriver().findElement(By.id("email_create"));

    WebElement buttonCreateAccount = getDriver().findElement(By.id("SubmitCreate"));


    public void writeEmailAddressForCreatingTheAccount(String emailAddress){

        createAccountEmailForm.click();
        createAccountEmailForm.sendKeys(emailAddress);
    }

    public void clickCreateAccountButton(){
        getActionBuilder().click(buttonCreateAccount).perform();
    }


    public void clickCreateAccountAndPrintNextPageTitle(String emailAddress){
        getActionBuilder().click(createAccountEmailForm)
                          .sendKeys(emailAddress)
                          .perform();

    getWait().until(ExpectedConditions.elementToBeClickable(buttonCreateAccount));

    buttonCreateAccount.click();

    getWait().until(ExpectedConditions.invisibilityOfElementLocated(By.id("SubmitCreate")));

        System.out.println(driver.getTitle());


    }

    public void invalidEmailInputForCreatingAccount(){
        getActionBuilder().click(createAccountEmailForm)
                .sendKeys("emailAddress")
                .perform();

        buttonCreateAccount.click();

        WebElement invalidEmailInputMessage = driver.findElement(By.id("create_account_error"));

        getWait().until(ExpectedConditions.visibilityOf(invalidEmailInputMessage));
       if( invalidEmailInputMessage.isDisplayed()){
           System.out.println( invalidEmailInputMessage.getText() );
       }

    }



    public void checkIsAuthenticationPage(){
        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account"));

        Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

}
