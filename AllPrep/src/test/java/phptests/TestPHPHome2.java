package phptests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class TestPHPHome2 {
    public WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "../generic/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.78 Safari/537.36");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://www.php.net");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
 //       driver.quit();
    }
    public void searchText(String str){
//        searchBox.sendKeys(str, Keys.ENTER);
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys(str, Keys.ENTER);
    }

    @Test
    public void testText(){

        searchText("eval");
        String newUrl = driver.getCurrentUrl();
        if(newUrl.equalsIgnoreCase("http://php.net/manual/en/function.eval.php")) {
            System.out.println("they are the same.");
        }

       SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(newUrl.contains("php.net/manual/en/function.eval.php"),"the URL is not correct.");

        String bodyText = driver.findElement(By.tagName("body")).getText();
        softAssert.assertTrue(bodyText.contains("Caution"), "it does not have 'Caution'.");

//        softAssert.assertEquals(newUrl, "http://php.net/manual/en/function.eval.php", "the URL is not correct.");

        softAssert.assertAll();
    }
}
