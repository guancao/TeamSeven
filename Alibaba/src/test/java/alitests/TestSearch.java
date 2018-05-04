package alitests;

import alipages.HomeSearch;
import base.CommonAPIb;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.TestLogger;

public class TestSearch extends CommonAPIb {

    @Test
    public void testHomeSearch1() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPIb.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));

        HomeSearch hs = PageFactory.initElements(driver, HomeSearch.class);
        hs.searchItem("cheese cake");
    }

    @Test
    public void testHomeSearch2() {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPIb.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));

        HomeSearch hs = PageFactory.initElements(driver, HomeSearch.class);
        hs.searchItemList();
    }
}
