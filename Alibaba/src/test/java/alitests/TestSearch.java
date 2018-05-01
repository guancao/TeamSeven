package alitests;

import alipages.HomeSearch;
import base.CommonAPI;
import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestSearch extends CommonAPI {

    @Test
    public void testHomeSearch1(){
        HomeSearch hs=PageFactory.initElements(driver, HomeSearch.class);
        hs.searchItem("cheese cake");
    }
    @Test
    public void testHomeSearch2(){
        HomeSearch hs=PageFactory.initElements(driver, HomeSearch.class);
        hs.searchItemList();
    }
}
