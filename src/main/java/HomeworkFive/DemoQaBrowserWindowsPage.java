package HomeworkFive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DemoQaBrowserWindowsPage extends BasePage{

    public DemoQaBrowserWindowsPage(WebDriver Driver) {
        super(Driver);
    }


    WebElement newWindowButton = driver.findElement(By.id("windowButton"));

    WebElement newWindowMessageButton = driver.findElement(By.id("messageWindowButton"));

    public void openNewWindowAndGetTextInIt() {

        newWindowButton.click();

        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        WebElement newWindowText = driver.findElement(By.id("sampleHeading"));

        System.out.println(newWindowText.getText());


    }


    public void openNewWindowMessageAndGetTextInIt() {

       newWindowMessageButton.click();


        List<String> windows = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(windows.get(1));

        WebElement newWindowMessageText = driver.findElement(By.xpath("//body"));

        System.out.println(newWindowMessageText.getText());


    }







}
