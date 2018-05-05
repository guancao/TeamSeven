package alitests;

import alipages.SearchFromExcel;
import base.CommonAPIb;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import reporting.TestLogger;

import java.io.IOException;

public class TestSearchExcelInput extends CommonAPIb{

    @Test
    public void testHomeSearchExcel() throws IOException, InterruptedException {
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPIb.convertToString(new Object() {
        }.getClass().getEnclosingMethod().getName()));

        SearchFromExcel sfe = PageFactory.initElements(driver, SearchFromExcel.class);
        sfe.searchItemsFromExcel();


    }
}
