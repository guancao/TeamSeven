package home;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestSearchOptions extends CommonAPI {

    @Test
    public void search()throws InterruptedException
    {
        SearchOptions searchOptions= PageFactory.initElements(driver,SearchOptions.class);
        searchOptions.searchLinkText(driver);
    }
}

