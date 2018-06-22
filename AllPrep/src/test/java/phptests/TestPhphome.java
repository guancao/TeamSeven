package phptests;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import phppage.Phphome;
import utils.Lib;

public class TestPhphome extends Lib {

    @Test
    public void testText(){
        Phphome phome = PageFactory.initElements(driver, Phphome.class);
        phome.searchText("eval");

 //       driver.findElement(By.xpath("//input[@type='search']")).sendKeys("eval", Keys.ENTER);
        String newUrl = driver.getCurrentUrl();
        Assert.assertEquals(newUrl, "http://php.net/manual/en/function.eval.php","the URL is not correct.");

        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("Caution"), "it does not have 'Caution'.");
    }


}
