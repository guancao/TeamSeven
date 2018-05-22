package testBrowser;

import base.CommonAPIb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VerifyTitle { //} extends CommonAPIb {
    WebDriver driver;

    @Test(priority=1)
    @Parameters({"browserName"})
    public void sam(String browserName) {
        System.out.println("You are using " + browserName);
    }

    @Test(priority = 2)
    @Parameters({"browserName"})
    public void browsers(String browserName) {

        System.out.println(browserName);

        if(browserName.equalsIgnoreCase("chrome")) {
            System.out.println("You have selected " + browserName);

            System.setProperty("webdriver.chrome.driver","..\\browser-driver\\chromedriver.exe");
 //                   System.getProperty("user.dir") + "..\\browser-driver\\chromedriver.exe");

            driver = new ChromeDriver();

        }
        else {
            System.out.println("You have not selected chrome");
        }

        driver.manage().window().maximize();
        driver.get("https://www.alibaba.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


}
