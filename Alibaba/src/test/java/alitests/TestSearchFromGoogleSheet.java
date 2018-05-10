package alitests;

import alipages.SearchFromGoogleSheets;
import base.CommonAPIb;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class TestSearchFromGoogleSheet extends CommonAPIb {
    @Test
    public void testGoogleSheetSearch() throws GeneralSecurityException, IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPIb.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));

        SearchFromGoogleSheets sgs= PageFactory.initElements(driver, SearchFromGoogleSheets.class);
        sgs.searchGoogleSheetItemList();
        Thread.sleep(3000);
    }
}
