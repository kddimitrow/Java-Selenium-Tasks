package HomeworkFiveTests;

import HomeworkFive.DemoQaAlertsPage;
import HomeworkFive.DemoQaBrowserWindowsPage;
import HomeworkFive.DemoQaFramesPage;
import HomeworkFive.DemoQaTutorialsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class HomeworkFiveTests {

    WebDriver driverChrome;
    DemoQaFramesPage demoQaFramesPage;
    DemoQaTutorialsPage demoQaTutorialsPage;
    DemoQaAlertsPage demoQaAlertsPage;
    DemoQaBrowserWindowsPage demoQaBrowserWindowsPage;

    @BeforeClass
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupBeforeMethods(){
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();

    }


   // @Test
    public void iframeTest(){
        driverChrome.get("https://demoqa.com/frames");
        demoQaFramesPage = new DemoQaFramesPage(driverChrome);

        demoQaFramesPage.switchBetweenIframesAndGetTheirText();

    }

   // @Test
    public void clickToFacebookLinkInFooterAndGetMainTextOfTheNewlyOpenedTab() throws InterruptedException {
        driverChrome.get("https://www.toolsqa.com/");

        demoQaTutorialsPage = new DemoQaTutorialsPage(driverChrome);
        demoQaTutorialsPage.clickToFacebookLinkInFooterAndGetTextOfTheNewlyOpenedTab();
    }

    //@Test
    public void printCopyrightText() {
        driverChrome.get("https://www.toolsqa.com/");

        demoQaTutorialsPage = new DemoQaTutorialsPage(driverChrome);
        demoQaTutorialsPage.printCopyrightTextFromFooter();
    }

    //@Test
    public void clickOkayAfterAlertAppear() {
        driverChrome.get("https://demoqa.com/alerts");

        demoQaAlertsPage = new DemoQaAlertsPage(driverChrome);
        demoQaAlertsPage.clickOkayAfterAlertAppear();
    }

    //@Test
    public void clickCancelAfterAlertAppear() {
        driverChrome.get("https://demoqa.com/alerts");

        demoQaAlertsPage = new DemoQaAlertsPage(driverChrome);
        demoQaAlertsPage.clickCancelAfterAlertAppear();
    }


   // @Test
    public void openNewWindowAndGetText() {
        driverChrome.get("https://demoqa.com/browser-windows");

        demoQaBrowserWindowsPage = new DemoQaBrowserWindowsPage(driverChrome);
        demoQaBrowserWindowsPage.openNewWindowAndGetTextInIt();

    }


    @Test
    public void openNewWindowMessageAndGetTextInIt(){
        driverChrome.get("https://demoqa.com/browser-windows");

        demoQaBrowserWindowsPage = new DemoQaBrowserWindowsPage(driverChrome);
        demoQaBrowserWindowsPage.openNewWindowMessageAndGetTextInIt();
    }

    @AfterMethod
    public void afterTestMethod(){
        driverChrome.close();

        if (driverChrome != null) {
            driverChrome.quit();
        }
    }








}
