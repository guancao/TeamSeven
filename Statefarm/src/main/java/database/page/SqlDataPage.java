package database.page;

import base.CommonAPI;
import database.ConnectDB;
import database.ConnectDbU;

import java.util.List;

public class SqlDataPage extends CommonAPI {

    // helpers methods to navigate to different page

    //insert expected result into database
    public void insertData() {
        ConnectDbU connectDbU = new ConnectDbU();
        connectDbU.insertDataFromStringToMySql("Jeffery T Hughes", "Expected_Data", "Expected_Result");

    }

    // read the expected the result
    public List<String> readData() throws Exception {
       ConnectDbU connectDbU = new ConnectDbU();

        List<String> expectedResult = connectDbU.readDataBase("Expected_Data", "Expected_Result");
        return  expectedResult;
    }

    // get the agen name from page
    public String getAgentName(){
        String result = getTextByXpath("//b[text() = 'Jeffrey T Hughes']");
        return  result;
    }
}
