package restApiTest;

import restapibase.RestAPIBase;
import clients.RESTClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class TestRestAPI extends RestAPIBase {

    RestAPIBase restAPIBase;
    public String url;

    @BeforeMethod
    public void setUp() throws IOException {
        restAPIBase = new RestAPIBase();
        String serviceUrl;
        String apiUrl;
        serviceUrl = prop.getProperty("serviceURL");
        apiUrl = prop.getProperty("apiURL");
        url = serviceUrl + apiUrl;
    }

    @Test
    public void testGet() throws IOException {
        RESTClient client = new RESTClient();
        client.getAPI(url);
    }
}
