package HomeworkFive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DemoQaTutorialsPage extends BasePage{

    public DemoQaTutorialsPage(WebDriver Driver) {
        super(Driver);

        getWait().until(ExpectedConditions.urlToBe("https://www.toolsqa.com/"));
    }

    public void clickToFacebookLinkInFooterAndGetTextOfTheNewlyOpenedTab() throws InterruptedException {


        Thread.sleep(5000);

        WebElement facebookIconInFooter = driver.findElement(By.xpath("//*[@title='Facebook']"));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", facebookIconInFooter);


        facebookIconInFooter.click();

        List<String> openedTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openedTabs.get(1));


        WebElement facebookPageHeadingText = driver.findElement(By.id("content"));
        System.out.println( facebookPageHeadingText.getText());

    }




    public void printCopyrightTextFromFooter(){
        WebElement copyrightText = driver.findElement(By.xpath("//*[@class='bottom-text-block']"));

        scrollToElementByItsCoordinates(copyrightText);

        System.out.println(copyrightText.getText());



    }







}
