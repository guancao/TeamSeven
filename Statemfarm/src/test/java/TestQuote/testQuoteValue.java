package TestQuote;

import getQuote.searchQuote;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class testQuoteValue extends searchQuote {

    @Test
    public void testQuotebyZip() {

       searchQuote sq = PageFactory.initElements(driver, searchQuote.class);
        sq.enterAllinfo();

    }
}