package homepagetest;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import homepage.SearchPage;

public class TestSearch extends SearchPage {

    @Test
    public void testSeartch() {
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        searchPage.searchItems();
    }

    @Test
    public void search(){
        typeOnInputField("//input[@placeholder = 'Search Quotes, News & Video']","trade war");
        clickOnElement("//*[@id=\"cnbc-new-header\"]/div[1]/div/div[1]/div[1]/span[1]/a/i");
    }
}
