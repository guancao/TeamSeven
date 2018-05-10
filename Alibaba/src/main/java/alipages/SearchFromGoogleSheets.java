package alipages;

import api.GoogleSheetReaderG;
import base.CommonAPIb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class SearchFromGoogleSheets extends CommonAPIb {
    @FindBy(name = "SearchText")
    public WebElement searchInputField;

    public WebElement getSearchInputField() {
        return searchInputField;
    }

    public void setSearchInputField(WebElement searchInputField) {
        this.searchInputField = searchInputField;
    }

    //clear searchInputField
    public void clearInputField() {
        searchInputField.clear();
    }

    //****search by input an item name
    public void searchItem(String itemName) {   //search in the search box
        clearInputField();
        searchInputField.sendKeys(itemName, Keys.ENTER);
    }

    //*******search with a prepared item list
    public void searchGoogleSheetItemList() throws GeneralSecurityException, IOException {
        List<String> itemList = getListFromGoogleSheets();
        for (String st : itemList) {
            clearInputField();
            getSearchInputField().sendKeys(st, Keys.ENTER);
        }
    }

    //    @Parameters({"sheetId","dataRange"})
    public static List<String> getListFromGoogleSheets() throws GeneralSecurityException, IOException { //@Optional("") String sheetId, @Optional("") String dataRange){
        List<String> itemList;
        GoogleSheetReaderG gsr = PageFactory.initElements(driver, GoogleSheetReaderG.class);
        itemList = GoogleSheetReaderG.getStringListFromGoogleSheet("dummies", "dummies");
        return itemList;
    }
}
