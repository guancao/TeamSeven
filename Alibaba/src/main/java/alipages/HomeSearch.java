package alipages;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomeSearch extends CommonAPI {

    private WebDriver driver;
    public HomeSearch(){
        super();
    }

    @FindBy(name = "SearchText")
    public WebElement searchInputField;

    //****search by input an item name
    public void searchItem(String itemName){   //search in the search box
        searchInputField.sendKeys(itemName, Keys.ENTER);
    }

    //*******search with a prepared item list
    public void searchItemList(){
        List<String> itemList = setItemlist();
        for(String st: itemList) {
            getSearchInputField().sendKeys(st, Keys.ENTER);
            getSearchInputField().clear();
        }
    }

    public List<String> setItemlist(){
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("fishing lure");
        itemsList.add("fishing jig");
        itemsList.add("spoon lure");
        itemsList.add("selenium");

        return itemsList;
    }

    public WebElement getSearchInputField() {
        return searchInputField;
    }

    public void setSearchInputField(WebElement searchInputField) {
        this.searchInputField = searchInputField;
    }




}
