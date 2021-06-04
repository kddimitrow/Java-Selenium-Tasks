package HomeworkFourTests;

import HomeworkFour.AuthenticationPage;
import HomeworkFour.CreateAccountPage;
import HomeworkFour.HomePage;
import HomeworkFour.UserInformation;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomeworkFourTests {

    WebDriver driverChrome;
    HomePage homePage;
    AuthenticationPage authenticationPage;
    UserInformation userInformation;
    CreateAccountPage createAccountPage;

    @BeforeClass
    public void setupWebDriverManager(){
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void setupBeforeMethods(){
        driverChrome = new ChromeDriver();
        driverChrome.manage().window().maximize();
        driverChrome.get("http://automationpractice.com/index.php");

        userInformation = new UserInformation();

        homePage = new HomePage(driverChrome);

    }

    @Test
    public void checkRadioButtonTest() throws InterruptedException {

        homePage.clickOnSignInButton();

        authenticationPage = new AuthenticationPage(driverChrome);
        authenticationPage.writeEmailAddressForCreatingTheAccount(userInformation.getEmailCreate());
        authenticationPage.clickCreateAccountButton();

        driverChrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        createAccountPage = new CreateAccountPage(driverChrome);
        createAccountPage.selectGenderRadioButton();

        Assert.assertTrue(createAccountPage.getGenderFemale().isEnabled());
   }

   @Test
   public void checkCheckboxForNewsletter(){
       homePage.clickOnSignInButton();

       authenticationPage = new AuthenticationPage(driverChrome);
       authenticationPage.writeEmailAddressForCreatingTheAccount(userInformation.getEmailCreate());
       authenticationPage.clickCreateAccountButton();

       driverChrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       createAccountPage = new CreateAccountPage(driverChrome);
       createAccountPage.newsletterCheckboxIsChecked();

       Assert.assertTrue(createAccountPage.getNewsletterCheckbox().isEnabled());
   }

    @Test
    public void printDateOfBirthdays(){
        homePage.clickOnSignInButton();

        authenticationPage = new AuthenticationPage(driverChrome);
        authenticationPage.writeEmailAddressForCreatingTheAccount(userInformation.getEmailCreate());
        authenticationPage.clickCreateAccountButton();

        driverChrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        createAccountPage = new CreateAccountPage(driverChrome);
        createAccountPage.DaysOfBirthDropdownPrintAllDays();


    }

    @Test
    public void selectRandomDateOfBirthTest(){
        homePage.clickOnSignInButton();

        authenticationPage = new AuthenticationPage(driverChrome);
        authenticationPage.writeEmailAddressForCreatingTheAccount(userInformation.getEmailCreate());
        authenticationPage.clickCreateAccountButton();

        driverChrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        createAccountPage = new CreateAccountPage(driverChrome);
        createAccountPage.getRandomDateOfBirth();
    }


    @Test
    public void getRegisterUserErrorTextTest(){
        homePage.clickOnSignInButton();

        authenticationPage = new AuthenticationPage(driverChrome);
        authenticationPage.writeEmailAddressForCreatingTheAccount(userInformation.getEmailCreate());
        authenticationPage.clickCreateAccountButton();

        driverChrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        createAccountPage = new CreateAccountPage(driverChrome);
        createAccountPage.getCreatingProfileErrorMessageText();
    }

    @Test
    public void createAccountWithEmailAndGetNextPageTitle(){
        homePage.clickOnSignInButton();

        authenticationPage = new AuthenticationPage(driverChrome);
        authenticationPage.clickCreateAccountAndPrintNextPageTitle(userInformation.getEmailCreate());



    }

    @Test
    public void createAccountWithInvalidEmailAndGetErrorMessageText(){
        homePage.clickOnSignInButton();

        authenticationPage = new AuthenticationPage(driverChrome);
        authenticationPage.invalidEmailInputForCreatingAccount();



    }
    @Test
    public void validateNavigatedPages(){
        homePage.checkIsHomePage();
        homePage.clickOnSignInButton();


        authenticationPage = new AuthenticationPage(driverChrome);
        authenticationPage.writeEmailAddressForCreatingTheAccount(userInformation.getEmailCreate());
        authenticationPage.clickCreateAccountButton();

        driverChrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        createAccountPage = new CreateAccountPage(driverChrome);
        createAccountPage.checkIsCreateAccountPage();



    }

    @AfterMethod
    public void afterTestMethod(){
        driverChrome.close();

        if (driverChrome != null) {
            driverChrome.quit();
        }
    }





}
