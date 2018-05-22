package google.sheet.page;

import base.CommonAPI;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static api.GoogleSheetReaderU.getSheetsService;

public class GoogleSheetPage extends CommonAPI{

    public void findStateFarmAgents(){
        clickWebElement("tab4");
        typeByXpath("//div[@id='qam-agent-zip-field']/label", "19047");
        clickWebElement("qam-agent-find-agent-button");
        selectOptionByVisibleText(driver.findElement(By.xpath("//select[@id='distance']")), "Within 70 miles");
        clickWebElement("search");

    }
    public List<List<Object>> getSpreadSheetRecords(String spreadsheetId, String range) throws IOException {
        // Build a new authorized API client service.
        Sheets service = getSheetsService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            return null;
        } else {
            return values;
        }
    }

    // AMZ_TS5: Use google sheets test data to search multiple items
    // AMZ_TS5_TC1: Search multiple items by name from a google sheets file
    public List<String> searchAgenByName(String spreadsheetId, String range) throws IOException, InterruptedException {
        List<List<Object>> values = getSpreadSheetRecords(spreadsheetId, range);
        List<String> actual = new ArrayList<>();
        for (List row : values) {
//            waitUntilClickAble(By.id("twotabsearchtextbox"));
//            getTextByXpath("//b[text() = 'Jeffrey T Hughes']", row.get(1).toString());
//            typeByIdNEnter("twotabsearchtextbox", row.get(1).toString());

        }
        return actual;
    }

    // AMZ_TS5_TC2: Search multiple items by bar-code from a google sheets file
//    public List<String> searchItemByBarCode(String spreadsheetId, String range) throws IOException, InterruptedException {
//        List<List<Object>> values = getSpreadSheetRecords(spreadsheetId, range);
//        List<String> actual = new ArrayList<>();
//        for (List row : values) {
//            waitUntilClickAble(By.id("twotabsearchtextbox"));
//            typeByIdNEnter("twotabsearchtextbox", row.get(1).toString());
//            actual.add(getTextByXpath("//*[text()='" + row.get(2) + "']"));
//            System.out.println(row.get(2));
//            clearInputFieldById("twotabsearchtextbox");
//        }
//        return actual;
//    }
}
