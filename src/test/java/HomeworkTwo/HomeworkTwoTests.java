package HomeworkTwo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeworkTwoTests {

        WebDriver driverChrome;

    @BeforeClass
    public void setUpMethod(){
            WebDriverManager.chromedriver().setup();
    }




    @BeforeMethod
    public  void setUpTest(){
        driverChrome = new ChromeDriver();

        driverChrome.manage().window().maximize();
        driverChrome.get("http://automationpractice.com/index.php");
    }


    @Test(priority = 1)
    public void testMethodOne(){

       WebElement titleWoman = driverChrome.findElement(By.xpath("//*[@id='block_top_menu']//*[contains(text(), \"Women\")]"));

       String titleForWoman =  titleWoman.getText();

       WebElement titleDresses = driverChrome.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));

       String titleForDresses = titleDresses.getText();


      WebElement titleTshirts = driverChrome.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));

      String titleForTshirts = titleTshirts.getText();

      List<String> titlesList = Arrays.asList(titleForWoman, titleForDresses, titleForTshirts);

        for (String str : titlesList) {
            System.out.println(str);
        }

    }


    @Test(priority = 2)
    public void testMethodTwo(){

    WebElement titleContactUs = driverChrome.findElement(By.xpath("//*[@id='contact-link']/a"));

    String contactUs = titleContactUs.getText();

    WebElement titleSignIn = driverChrome.findElement(By.xpath("//*[@class='header_user_info']/a"));

    String signIn = titleSignIn.getText();

        System.out.println(contactUs);
        System.out.println(signIn);
    }


    @Test(priority = 3)
    public void testMethodThree(){
       List<WebElement> allDressesPrices = new ArrayList<>();

       WebElement priceFadeShortSleeve = driverChrome.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[2]/div[1]/span"));
       allDressesPrices.add(priceFadeShortSleeve);

       WebElement priceBlouse = driverChrome.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[2]/div/div[2]/div[1]/span"));
       allDressesPrices.add(priceBlouse);

       WebElement pricePrintedDressOne = driverChrome.findElement(By.xpath("//ul[@id='homefeatured']/li[3]/div/div[2]/div[1]/span"));
       allDressesPrices.add(pricePrintedDressOne);

       WebElement pricePrintedDressTwo = driverChrome.findElement(By.xpath("//ul[@id='homefeatured']/li[4]/div/div[2]/div[1]/span"));
       allDressesPrices.add(pricePrintedDressTwo);

       WebElement pricePrintedSummerDressSalePrice = driverChrome.findElement(By.xpath("//ul[@id='homefeatured']/li[5]/div/div[2]/div[1]/span"));
       allDressesPrices.add(pricePrintedSummerDressSalePrice);

        WebElement pricePrintedSummerDress = driverChrome.findElement(By.xpath("//ul[@id='homefeatured']/li[6]/div/div[2]/div[1]/span"));
        allDressesPrices.add(pricePrintedSummerDress);

        WebElement pricePrintedChiffonDressSalePrice = driverChrome.findElement(By.xpath("//ul[@id='homefeatured']/li[7]/div/div[2]/div[1]/span"));
        allDressesPrices.add(pricePrintedChiffonDressSalePrice);

       System.out.println( allDressesPrices.size());

        for (WebElement elements:allDressesPrices ) {
            System.out.println( elements.getText());
        }


    }



    @AfterMethod
    public void afterTestsMethod(){
        driverChrome.close();

        if (driverChrome != null){
            driverChrome.quit();
        }
    }
















}
