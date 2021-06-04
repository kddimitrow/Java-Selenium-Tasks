package HomeworkFive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DemoQaFramesPage extends BasePage{

    public DemoQaFramesPage(WebDriver Driver) {
        super(Driver);
        getWait().until(ExpectedConditions.urlToBe("https://demoqa.com/frames"));
    }


    WebElement iframeOne = driver.findElement(By.id("frame1"));

    WebElement iframeTwo = driver.findElement(By.id("frame2"));

    WebElement footer = driver.findElement(By.xpath(".//footer"));




    public void switchBetweenIframesAndGetTheirText(){

        driver.switchTo().frame(iframeOne);

        System.out.println(getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/h1"))).getText());

        driver.switchTo().defaultContent();

        driver.switchTo().frame(iframeTwo);
        System.out.println(getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/h1"))).getText());

        driver.switchTo().defaultContent();
        System.out.println( footer.getText());

    }






}
