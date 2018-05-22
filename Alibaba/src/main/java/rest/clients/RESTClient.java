package rest.clients;

import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class RESTClient {

    public void getAPI(String url) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault(); //create a client
        HttpGet httpGet = new HttpGet(url);  //create a GET request
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);

        int statusCode = httpResponse.getStatusLine().getStatusCode();  // status code
        System.out.println("The status code is -> "+statusCode);

        String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8"); //the entity of response (JSON -- string)
        System.out.println("The response string is -->> "+responseString);

//        JSONArray jsonArray = new JSONArray(responseString);
//        JSONObject responseJSON = new JSONObject();
//        for(int i =0; i< jsonArray.length(); i++){
//            if(jsonArray.get(i) instanceof JSONObject){
//                responseJSON = (JSONObject)jsonArray.getJSONObject(i); //.get(i);
//            }
//        }
//        JSONObject responseJSON = new JSONObject(responseString.substring(responseString.indexOf('{'),(responseString.length()-1))); // get the JSON from the string
        JSONObject responseJSON = new JSONObject(responseString.substring(responseString.indexOf("{"))); // get the JSON from the string
        System.out.println("The response JSON object  is --->>>"+ responseJSON);

        Header[] headerArray = httpResponse.getAllHeaders(); //all headers
        HashMap<String, String> headerHashMap = new HashMap<>();
        for (Header header: headerArray){
            headerHashMap.put(header.getName(), header.getValue()); //put header into the hashmap
        }
        System.out.println("The header hashmap is ---->>>>"+headerHashMap);
    }
}
