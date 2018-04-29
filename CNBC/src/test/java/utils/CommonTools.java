package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;

public class CommonTools {
    public static WebElement findElemByXpath(WebDriver driver, String key) throws FileNotFoundException {
        WebElement element = driver.findElement(By.xpath(readProperties(key)));
        return element;
    }

    public static List<WebElement> findElemsByXpath(WebDriver driver, String key) throws FileNotFoundException {
        List<WebElement> elementList = driver.findElements(By.xpath(readProperties(key)));
        return elementList;
    }


    public static String readProperties(String key) throws FileNotFoundException {
        String filePath = "C:\\Users\\caog\\Documents\\misc\\Web-Automation-TeamSeven\\CNBC\\src\\test\\resources\\locator.properties";
        File f = new File(filePath);
        FileInputStream fis = new FileInputStream(f);
        Properties prop = new Properties();
        String locator = prop.getProperty(key);
        return locator;
    }
}
