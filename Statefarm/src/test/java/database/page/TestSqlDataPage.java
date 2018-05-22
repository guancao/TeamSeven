package database.page;

import findAgent.SearchAgent;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestSqlDataPage extends SqlDataPage{
    //Test Methods
    @Test
    public void testDataBase() throws InterruptedException, Exception {
        SearchAgent searchAgent = PageFactory.initElements(driver, SearchAgent.class);
        SqlDataPage sdp = new SqlDataPage();
        //insert data
        sdp.insertData();
        //read data
        sdp.readData();
        searchAgent.findAutoInsuAgent();
        sdp.getAgentName();

        //Assert

    }
}
