package alipages;

import base.CommonAPIb;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DataReaderB;

import java.io.IOException;
import java.util.ArrayList;
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
        String excelFilePath = "./data/ali.xlsx"; //"E:\\WebAutomationTeamSeven\\Alibaba\\data\\ali.xlsx";
        DataReaderB dr = PageFactory.initElements(driver, DataReaderB.class);
        List<String> searchItems = dr.xlsxFileReaderB();
        for (String st : searchItems) {
            System.out.println(st);
            getSearchInputField().sendKeys(st, Keys.ENTER);
            Thread.sleep(3000);
            getSearchInputField().clear();
        }
    }

    public void searchItemsFromExcel2() throws IOException, InterruptedException {
        String excelFilePath=".\\data\\ali.xlsx";//"E:\\WebAutomationTeamSeven\\Alibaba\\data\\ali.xlsx";
        DataReaderB dr = new DataReaderB();
        List<String> searchItems = dr.simpleXlsxFileReader(excelFilePath);
        for (String st : searchItems) {
            System.out.println(st);
            getSearchInputField().sendKeys(st, Keys.ENTER);
            Thread.sleep(3000);
            getSearchInputField().clear();
        }
    }

    public void writeToExcel() throws IOException {
        DataReaderB dr = new DataReaderB();
        dr.xlsxFileWriterB("grape juice");
        dr.xlsxFileWriterB("orange juice");
        dr.xlsxFileWriterB("grape seeds");
    }
}
