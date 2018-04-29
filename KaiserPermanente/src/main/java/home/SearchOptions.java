package home;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchOptions {
    @FindBy(id = "search-btn-text-id")
    public WebElement searchInputButton;
    @FindBy(css="#kp-site-search-input")
    public WebElement searchInputValue;

    public WebElement getSearchInputValue() {
        return searchInputValue;
    }

    public void setSearchInputValue(WebElement searchInputValue) {
        this.searchInputValue = searchInputValue;
    }

    public WebElement getSearchInputButton() {
        return searchInputButton;
    }

    public void setSearchInputButton(WebElement searchInputButton) {
        this.searchInputButton = searchInputButton;
    }

    public void clickOnSearchButton(WebDriver driver)throws InterruptedException {
        getSearchInputButton().click();
        getSearchInputValue().sendKeys("Doctors", Keys.ENTER);
        Thread.sleep(2000);
         driver.navigate().back();
         Thread.sleep(2000);
        getSearchInputButton().click();
        getSearchInputValue().clear();
        getSearchInputValue().sendKeys("Facilities", Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        getSearchInputButton().click();
        getSearchInputValue().clear();
        getSearchInputValue().sendKeys("Classes", Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        getSearchInputButton().click();
        getSearchInputValue().clear();
        getSearchInputValue().sendKeys("Health Topics", Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        getSearchInputButton().click();
        getSearchInputValue().clear();
        getSearchInputValue().sendKeys("Drugs", Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        getSearchInputButton().click();
        getSearchInputValue().clear();
        getSearchInputValue().sendKeys("All", Keys.ENTER);
        Thread.sleep(2000);
        driver.navigate().back();

    }

    /*public void searchItems(WebDriver driver)throws InterruptedException
    {
        List<String> itemList=getSearchItems();
        for(String st:itemList){
            getSearchInputButton().click();
            getSearchInputValue().sendKeys(st, Keys.ENTER);
            driver.navigate().back();
            Thread.sleep(3000);
            getSearchInputValue().clear();
        }
    }

    public List<String> getSearchItems() {
        List<String> itemsList = new ArrayList<String>();
       itemsList.add("Doctors");
       itemsList.add("Facilities");
       itemsList.add("Classes");
       itemsList.add("Health Topics");
       itemsList.add("Drugs");
       itemsList.add("All");
        System.out.println(itemsList);
       return itemsList;
    }*/

}
