package api;


import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.*;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class GoogleSheetReaderB {
    private static final String APPLICATION_NAME = "WebAutomation";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String CREDENTIALS_FOLDER = "credentials"; // Directory to store user credentials.
    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved credentials/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CLIENT_SECRET_DIR = "/client_secret.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If there is no client_secret.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        InputStream in = GoogleSheetReader.class.getResourceAsStream(CLIENT_SECRET_DIR);
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(CREDENTIALS_FOLDER)))
                .setAccessType("offline")
                .build();
        return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
    }

    /**
      * =================you have to enable API in your google account======================
     */

    public static void main(String... args) throws IOException, GeneralSecurityException {
            // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/Alibaba/src/test/resources/locator.properties"));
        Properties prop = new Properties();
        prop.load(fis);
        final String spreadsheetId = prop.getProperty("sheetId"); // "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
        final String range = prop.getProperty("dataRange"); //"Class Data!A2:E";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Major");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s\n", row.get(0));
            }
        }
    }

    public static List<String> getStringListFromGoogleSheet(String locatorFilePath) throws IOException, GeneralSecurityException {
        List<List<Object>> listObjectList = getGoogleSheetValues(locatorFilePath);
        List<String> stringList = new ArrayList<String>();
        for (int i = 0; i < listObjectList.size(); i++) {
            List row = listObjectList.get(i);
            stringList.add(row.get(0).toString());
            System.out.println("The expected ====" + stringList.get(i));
        }
        return stringList;
    }

    //customized methods
    public static List<List<Object>> getGoogleSheetValues(String locatorFilePath) throws GeneralSecurityException, IOException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+locatorFilePath));
        Properties prop = new Properties();
        prop.load(fis);
        final String spreadsheetId = prop.getProperty("sheetId"); // "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
        final String range = prop.getProperty("dataRange"); //"Class Data!A2:E";

        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        return values;
    }
    // custom methods
    public static List<List<Object>> getGoogleSheetValues2() throws IOException, GeneralSecurityException{
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1RipEIeqO8WYDkB2fIBYmGs8b4iqTUHOUKoG6XZr68cM";
        final String range = "Sheet1!A2:A6";
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
            return null;
        } else {
            return values;
        }
    }
}
