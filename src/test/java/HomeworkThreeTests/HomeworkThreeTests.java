package HomeworkThreeTests;

import HomeworkThree.AuthenticationPage;
import HomeworkThree.CreateAccountPage;
import HomeworkThree.HomePage;
import HomeworkThree.UserInformation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class HomeworkThreeTests {


    WebDriver driverChrome;
    HomePage homePage;
    AuthenticationPage authenticationPage;
    UserInformation userInformation;
    String emailCreating;
    CreateAccountPage createAccountPage;



    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpMethod(){
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driverChrome.get("http://automationpractice.com/index.php");

        emailCreating = "emailSelenium"+getRandomIntegerBetweenRange(1, 3333) +"@mail.com";

        userInformation = new UserInformation();

        userInformation.setFirstname("Junior");
        userInformation.setLastName("Automation");
        userInformation.setPassword("123456789");
        userInformation.setCompanyName("MM");
        userInformation.setCity("Minneapolis");
        userInformation.setMobileNumber(333333333);
        userInformation.setPostalCode(33333);
        userInformation.setAddressInformation("My address");


    }


    @Test
    public void navigateAndRegisterNewUser(){

        homePage = new HomePage(driverChrome);
        homePage.clickOnSignInButton();

        userInformation.setEmailAddress(emailCreating);

        authenticationPage = new AuthenticationPage(driverChrome);
        authenticationPage.writeEmailAddressForCreatingTheAccount(userInformation.getEmailAddress());
        authenticationPage.clickCreateAccountButton();

        createAccountPage = new CreateAccountPage(driverChrome);
        createAccountPage.fillTheCreateProfileInformation(userInformation.getFirstname(),userInformation.getLastName(),userInformation.getPassword(),userInformation.getAddressInformation(),userInformation.getCity(),userInformation.getPostalCode(),userInformation.getMobileNumber());

        Assert.assertEquals(driverChrome.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }


    @AfterMethod
    public void afterTestMethod(){
        driverChrome.close();

        if (driverChrome != null) {
            driverChrome.quit();
        }
    }




    public static Integer getRandomIntegerBetweenRange(int min, int max){
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }








}
