package alitests;

import alipages.HomeSearch;
import alipages.HomeSignIn;
import base.CommonAPIb;
import database.ConnectDBb;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.util.ArrayList;
import java.util.List;

public class TestMySqlSearch extends CommonAPIb {

    @Test
    public void testInsertMysql(){
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPIb.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));
        String [] items = new String[] {"tree", "spoon", "fork", "jighead", "hook", "reel"};

        ConnectDBb myConn = new ConnectDBb();
        myConn.insertDataFromArrayToMySql(items, "tbl_ali_search", "search_item");
    }

    @Test
    public void testItemsFromMysql() throws Exception {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPIb.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));

        List<String> itemsFromMySql = new ArrayList<>();
        HomeSearch hs = PageFactory.initElements(driver, HomeSearch.class);
        ConnectDBb myConn = new ConnectDBb();
        itemsFromMySql=myConn.readDataBase("tbl_ali_search", "search_item");
        for (String st: itemsFromMySql){
            System.out.println("Item from the MySql to be searched : " + "\t"+ st);
            hs.clearInputField();
            hs.searchItem(st);
//            captureScreenshot("./screenshot/",CommonAPIb.convertToString(new Object() {
            captureScreenshot(driver,CommonAPIb.convertToString(new Object() {
            }.getClass().getEnclosingMethod().getName()));
//            Thread.sleep(3000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("SearchText")));
        }

    }

}
