package home;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestSearchOptions extends CommonAPI {

    @Test
    public void search()throws InterruptedException
    {
        SearchOptions searchOptions= PageFactory.initElements(driver, SearchOptions.class);
        searchOptions.clickOnSearchButton(driver);
       //searchOptions.searchItems(driver);
    }
   /*@Test
    public void searchOptions()
   {
       clickOnElement("search-btn-text-id");
       typeByCssNEnter("#kp-site-search-input","Doctors");
       navigateBack();
   }*/




}
