package rest.restapibase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RestAPIBase {

    public Properties prop;

    public RestAPIBase() {
        try {
            FileInputStream fis = null;
            File file = new File(System.getProperty("user.dir")+"/src/main/java/rest/configures/configure.properties");
            fis = new FileInputStream(file);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
