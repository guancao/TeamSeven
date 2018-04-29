package homepage;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends CommonAPI {
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

    //prepare the list for the searchItems()
    public List<String> getItemValue(){
        List<String> itemsList = new ArrayList<String>();
        itemsList.add("Facebook");
        itemsList.add("bitcoin");
        itemsList.add("trade war");
        itemsList.add("north korea");

        return itemsList;
    }


}
