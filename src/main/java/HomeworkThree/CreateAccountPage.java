package HomeworkThree;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage extends BasePage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    WebElement gender = getDriver().findElement(By.id("id_gender1"));
    WebElement firstName = getDriver().findElement(By.id("customer_firstname"));
    WebElement lastName = getDriver().findElement(By.id("customer_lastname"));
    WebElement email = getDriver().findElement(By.id("email"));
    WebElement password = getDriver().findElement(By.id("passwd"));
    WebElement dayOfBirth = getDriver().findElement(By.xpath("//*[@id='days']/*[contains(text(),'15')]"));
    WebElement monthOfBirth = getDriver().findElement(By.xpath("//*[@id='months']/*[@value='6']"));
    WebElement yearOfBirth = getDriver().findElement(By.xpath("//*[@id='years']/*[@value='1995']"));
    WebElement address = getDriver().findElement(By.id("address1"));
    WebElement city = getDriver().findElement(By.id("city"));
    WebElement state = getDriver().findElement(By.xpath("//*[@id='id_state']/*[@value='23']"));
    WebElement postcode = getDriver().findElement(By.id("postcode"));
    WebElement mobilePhone = getDriver().findElement(By.id("phone_mobile"));
    WebElement alias = getDriver().findElement(By.id("alias"));
    WebElement submitButton = getDriver().findElement(By.id("submitAccount"));


    public void genderSelect(){
        gender.click();
    }


    public void setFirstName(String setFirstName){
        firstName.click();
        firstName.sendKeys(setFirstName);
    }

    public void setLastName(String setLastName){
        lastName.click();
        lastName.sendKeys(setLastName);
    }

    public void setEmail(){
        email.click();
    }

    public void setPassword(String passwordInput){
        password.click();
        password.sendKeys(passwordInput);
    }

    public void setBirthDate(){
        dayOfBirth.click();
        monthOfBirth.click();
        yearOfBirth.click();
    }

    public void setAddress(String setAddress){
        address.click();
        address.sendKeys(setAddress);
    }
    public void setCity(String setCity){
        city.click();
        city.sendKeys(setCity);
    }

    public void setState(){
        state.click();
    }

    public void setPostcode(int setPostCode){
        postcode.click();
        postcode.sendKeys(String.valueOf(setPostCode));

    }

    public void setMobileNumber(int number){
        mobilePhone.click();
        mobilePhone.sendKeys(String.valueOf(number));
    }

    public void setAlias(){
        alias.click();
    }

    public void clickSubmitButton(){
      submitButton.click();

    }

    public void fillTheCreateProfileInformation(String setFirstName,String setLastName,String passwordInput, String setAddress, String setCity, int setPostCode, int number){
        genderSelect();
        setFirstName(setFirstName);
        setLastName(setLastName);
        setEmail();
        setPassword(passwordInput);
        setBirthDate();
        setAddress(setAddress);
        setCity(setCity);
        setState();
        setPostcode(setPostCode);
        setMobileNumber(number);
        setAlias();
        clickSubmitButton();
    }


}
