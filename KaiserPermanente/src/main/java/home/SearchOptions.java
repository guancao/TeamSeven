package home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchOptions {

    public List<String> getSearchItems() {
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("Doctors");
        itemsList.add("Facilities");
        itemsList.add("Classes");
        itemsList.add("Health Topics");
        itemsList.add("Drugs");
        itemsList.add("All");
        System.out.println("Number of items in list:- "+itemsList.size());
        System.out.println(itemsList);
        return itemsList;
    }
    public void searchLinkText(WebDriver driver) throws InterruptedException {
        WebElement anchors = driver.findElement(By.id("search-btn-text-id"));
        WebElement  l1 = driver.findElement(By.cssSelector("#kp-site-search-input"));
        List<String> st=getSearchItems();
        for (int i = 0; i < st.size(); i++) {
            anchors.click();
            Thread.sleep(2000);
            l1.clear();
            l1.sendKeys(st.get(i),Keys.ENTER);
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            anchors = driver.findElement(By.id("search-btn-text-id"));
            l1 = driver.findElement(By.cssSelector("#kp-site-search-input"));
        }
    }
}
