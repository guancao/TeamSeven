package linktext;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LinkTextPage extends CommonAPI {


    public void clickLinkByHref(WebDriver driver) throws InterruptedException {
        WebElement anchors = driver.findElement(By.xpath("//*[@id=\"logged_out_topnav\"]/ul"));
        List<WebElement> l1 = anchors.findElements(By.tagName("a"));
        System.out.println("The number of links in area= " + l1.size());
        for (int i = 0; i < l1.size(); i++) {
            l1.get(i).click();
            Thread.sleep(2000);
            String linkTitle = driver.getTitle();
            System.out.println("The Title of the page is:  " + linkTitle);
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            anchors = driver.findElement(By.xpath("//*[@id=\"logged_out_topnav\"]/ul"));
            l1 = anchors.findElements(By.tagName("a"));
        }
    }


}