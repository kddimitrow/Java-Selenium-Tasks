package HomeworkFour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.List;
import java.util.concurrent.TimeUnit;

public class CreateAccountPage extends BasePage{


    public CreateAccountPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"));
    }


    WebElement genderMale = getDriver().findElement(By.id("id_gender1"));

    WebElement genderFemale = getDriver().findElement(By.id("id_gender2"));


    WebElement newsletterCheckbox = getDriver().findElement(By.xpath("//*[@id=\"uniform-newsletter\"]"));

    WebElement dayOfBirth = getDriver().findElement(By.xpath("//*[@id='days']"));

    WebElement registerButton = getDriver().findElement(By.id("submitAccount"));


    public void selectGenderRadioButton(){
       // driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       // getWait().until(ExpectedConditions.elementToBeClickable(genderMale));

        genderMale.click();

        WebElement checkGenderMaleIsChecked = getDriver().findElement(By.xpath("//*[@class=\"radio-inline\"]//*[@class=\"checked\"]"));

        if (checkGenderMaleIsChecked.isEnabled()){
            genderFemale.click();
        }else {
            System.out.println("Mr radio button is not clicked");
        }


    }


    public void newsletterCheckboxIsChecked(){


        if (newsletterCheckbox.isEnabled()){
            newsletterCheckbox.click();
        }else {
            System.out.println("Newsletter checkbox is clicked");
        }
    }


    public void DaysOfBirthDropdownPrintAllDays(){

        List<WebElement> dayOfBirth = getDriver().findElements(By.xpath("//*[@id='days']"));
        for (WebElement element: dayOfBirth ) {
            System.out.println(  element.getText());
        }
    }


    public void getRandomDateOfBirth(){
        Select dropDown = new Select(driver.findElement(By.xpath("//*[@id='days']")));
        dropDown.selectByIndex(getRandomIntegerBetweenRange(1, 32));
       if (dayOfBirth.isEnabled()){
          String day = dropDown.getFirstSelectedOption().getText();
           int dayDate = Integer.valueOf(day.trim());
          int secondRandomDayDate = getRandomIntegerBetweenRange(1, 32);
          if (dayDate != secondRandomDayDate ){
          dropDown.selectByIndex(secondRandomDayDate);
          }else {
              System.out.println("First day date is equal to second day date, because of the number random generator, please rerun the test");
          }
       }else {
           System.out.println("Day date is not selected");
       }

    }


    public void getCreatingProfileErrorMessageText(){

        registerButton.click();
        WebElement registerUserErrorMessage = getDriver().findElement(By.xpath("//*[@class=\"alert alert-danger\"]/ol"));
        getWait().until(ExpectedConditions.visibilityOf(registerUserErrorMessage));
        List<WebElement> registerUserErrorMessageElements = getDriver().findElements(By.xpath("//*[@class=\"alert alert-danger\"]/ol"));

        for (WebElement element : registerUserErrorMessageElements) {
            System.out.println( element.getText());
        }

    }

    public void checkIsCreateAccountPage(){
        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation"));

        Assert.assertEquals(driver.getCurrentUrl(),"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation" );

    }

    public static Integer getRandomIntegerBetweenRange(int min, int max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }



    public WebElement getGenderFemale() {
        return genderFemale;
    }


    public WebElement getNewsletterCheckbox() {
        return newsletterCheckbox;
    }

}
