package alipages;

import base.CommonAPIb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utility.DataReaderB;

import java.io.IOException;
import java.util.List;

public class SearchFromExcel extends CommonAPIb {
//    @FindBy(xpath = "//input[@placeholder = 'Search Quotes, News & Video']")
    @FindBy(name = "SearchText")
    public WebElement searchInputField;

    public WebElement getSearchInputField() {
        return searchInputField;
    }

    public void setSearchInputField(WebElement searchInputField) {
        this.searchInputField = searchInputField;
    }

    public void searchItemsFromExcel() throws IOException, InterruptedException {
        DataReaderB dr = new DataReaderB();
        String excelfilepath = ".\\data\\ali.xlsx"; //"E:\\WebAutomationTeamSeven\\Alibaba\\data\\ali.xlsx";
        List<String> searchItems = dr.xlsxFileReaderB(excelfilepath);
//        List<String> itemList = new ArrayList<>();
        for (String st : searchItems) {
            System.out.println(st);
            getSearchInputField().sendKeys(st, Keys.ENTER);
            Thread.sleep(3000);
            getSearchInputField().clear();
        }
        dr.xlsxFileWriterB("grape juice");
        dr.xlsxFileWriterB("orange juice");
        dr.xlsxFileWriterB("grape seeds");


    }
}
