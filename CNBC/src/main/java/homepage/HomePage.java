package homepage;

import base.CommonAPI;
import com.gargoylesoftware.htmlunit.javascript.host.URL;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends CommonAPI {

    @FindBy(how=How.ID, using="nav")
    List<WebElement> menuItemList;

    //retrieve the menu item information, return a list -- method #1
    public List<String> retrieveMenuTitle(WebDriver driver) throws IOException {
        List<String> menu = new ArrayList<String>();
        menu=getTextLists(driver,"#nav");
        return menu;
    }
    //retrieve the menu item information, return a list  -- method #2
    @Parameters({"filepath"})
    public List<String> retrieveMenuTitle2(WebDriver driver, String filepath) throws IOException {
        List<String> menu = new ArrayList<String>();
        menu = findElemsStringListByXpath(driver, readProperties("menuxpath",filepath), filepath);
         return menu;
    }

    //search using the search box
    @FindBy(xpath = "//input[@placeholder = 'Search Quotes, News & Video']")
    public WebElement searchInputField;

    public WebElement getSearchInputField() {
        return searchInputField;
    }

    public void setSearchInputField(WebElement searchInputField) {
        this.searchInputField = searchInputField;
    }

    public void searchItems(){
        List<String> itemList = getItemValue();
        for(String st: itemList) {
            getSearchInputField().sendKeys(st, Keys.ENTER);
            getSearchInputField().clear();
        }
    }

    public List<String> getItemValue(){
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("Facebook");
        itemsList.add("bitcoin");
        itemsList.add("trade war");
        itemsList.add("north korea");

        return itemsList;
    }
}
