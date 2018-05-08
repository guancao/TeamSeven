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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class GoogleSheetReaderB {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
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
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     *
     * =================you have to enable API in your google account======================
     */
    @Parameters({"secretPath"})
    public static Properties loadProperties(@Optional("E:\\WebAutomationTeamSeven\\Alibaba\\databaseinfo\\secret.properties")
                                             String secretPath) throws IOException {
        Properties prop = new Properties();
        //       InputStream ism = new FileInputStream("/Users/peoplentech/develop/automation/Web-Automation-Framework/Generic/databaseinfo/secret.properties");
        InputStream ism = new FileInputStream(secretPath); //"/Users/peoplentech/develop/automation/Web-Automation-Framework/Generic/databaseinfo/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

//    @Parameters({"sheetId", "dataRange"})
//    public static void main(@Optional("1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms") String sheetId,
//            @Optional("Class Data!A2:E") String dataRange ) throws IOException, GeneralSecurityException { //String... args) throws IOException, GeneralSecurityException {
    public static void main(String... args) throws IOException, GeneralSecurityException {
            // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Properties prop = loadProperties("secretPath");
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
                System.out.printf("%s, %s, %s\n", row.get(0), row.get(1), row.get(4));
            }
        }
    }

    //customized methods
//    @Parameters({"sheetId", "dataRange"})
//    public static List<List<Object>> getGoogleSheetValues(@Optional("1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms") String sheetId,
//                                                          @Optional("Class Data!A2:E") String dataRange) throws GeneralSecurityException, IOException {
    public static List<List<Object>> getGoogleSheetValues() throws GeneralSecurityException, IOException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        final String spreadsheetId = sheetId;  //"1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
//        final String range = dataRange;  //"Class Data!A2:E";
        Properties prop = loadProperties("secretPath");
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
//        if (values == null || values.isEmpty()) {
//            System.out.println("No data found.");
//        } else {
//            System.out.println("Name, Major");
//            for (List row : values) {
//                // Print columns A and E, which correspond to indices 0 and 4.
//                System.out.printf("%s, %s, %s\n", row.get(0), row.get(1), row.get(4));
//            }
//        }
    }
    // custom methods
    public static List<List<Object>> getGoogleSheetValues2() throws IOException, GeneralSecurityException{
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final String spreadsheetId = "1RipEIeqO8WYDkB2fIBYmGs8b4iqTUHOUKoG6XZr68cM";
        final String range = "Sheet1!A2:A";
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
