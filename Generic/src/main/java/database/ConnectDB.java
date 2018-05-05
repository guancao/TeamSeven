package database;

//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoDatabase;

import base.CommonAPI;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectDB {

//    public static MongoDatabase mongoDatabase = null;

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    //  make changes to pass parameter instead of hard code the filepath
    CommonAPI commonAPI = new CommonAPI();
//    public Properties loadProperties() throws IOException{
    @Parameters({"secretPath"})
    public Properties loadProperties(String secretPath) throws IOException {
        Properties prop = new Properties();
        //       InputStream ism = new FileInputStream("/Users/peoplentech/develop/automation/Web-Automation-Framework/Generic/databaseinfo/secret.properties");
        InputStream ism = new FileInputStream(secretPath); //"/Users/peoplentech/develop/automation/Web-Automation-Framework/Generic/databaseinfo/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }
    @Parameters({"secretPath"})
    public Connection connectToMySql(String secretPath) throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadProperties(secretPath);
        String driverClass = prop.getProperty("MYSQLJDBC.driver");
        String url = prop.getProperty("MYSQLJDBC.url");
        String userName = prop.getProperty("MYSQLJDBC.userName");
        String password = prop.getProperty("MYSQLJDBC.password");
        Class.forName(driverClass);
        connect = DriverManager.getConnection(url, userName, password);
        System.out.println("Database is connected");
        return connect;
    }

//    public MongoDatabase connectToMongoDB() {
//        MongoClient mongoClient = new MongoClient();
//        mongoDatabase = mongoClient.getDatabase("students");
//        System.out.println("Database Connected");
//        return mongoDatabase;
//    }

    @Parameters({"secretPath"})
    public List<String> readDataBase(String secretPath, String tableName, String columnName) throws Exception {
        List<String> data = new ArrayList<String>();
        try {
            connectToMySql(secretPath);
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from " + tableName);
            data = getResultSetData(resultSet, columnName);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

    private List<String> getResultSetData(ResultSet resultSet2, String columnName) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while (resultSet.next()) {
            String itemName = resultSet.getString(columnName);
            dataList.add(itemName);
        }
        return dataList;
    }

    @Parameters({"secretPath"})
    public void insertDataFromArrayToMySql(String secretPath, int[] ArrayData, String tableName, String columnName) {
        try {
            connectToMySql(secretPath);
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (int n = 0; n < ArrayData.length; n++) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setInt(1, ArrayData[n]);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Parameters({"secretPath"})
    public void insertDataFromStringToMySql(String secretPath, String ArrayData, String tableName, String columnName) {
        try {
            connectToMySql(secretPath);
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
            ps.setString(1, ArrayData);
            ps.executeUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Parameters({"secretPath"})
    public List<String> directDatabaseQueryExecute(String secretPath, String passQuery, String dataColumn) throws Exception {
        List<String> data = new ArrayList<String>();

        try {
            connectToMySql(secretPath);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(passQuery);
            data = getResultSetData(resultSet, dataColumn);
        } catch (ClassNotFoundException e) {
            throw e;
        } finally {
            close();
        }
        return data;
    }
    @Parameters({"secretPath"})
    public void insertDataFromArrayListToMySql(String secretPath, List<String> list, String tableName, String columnName) {
        try {
            connectToMySql(secretPath);
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (String st : list) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setObject(1, st);
                ps.executeUpdate();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Parameters({"secretPath"})
    public void insertProfileToMySql(String secretPath, String tableName, String columnName1, String columnName2) {
        try {
            connectToMySql(secretPath);
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName1 + "," + columnName2 + " ) VALUES(?,?)");
            ps.setString(1, "Ankita Sing");
            ps.setInt(2, 3590);
            ps.executeUpdate();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Parameters({"secretPath"})
    public List<String> readFromMySql(String secretPath) throws IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<String>();

        try {
            Connection conn = connectToMySql(secretPath);
            String query = "SELECT * FROM profile";
            // create the java statement
            Statement st = conn.createStatement();
            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);
            // iterate through the java resultset
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("id");
                //System.out.format("%s, %s\n", name, id);

            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {

    	/*
        insertProfileToMySql("profile","name", "id");
        List<User> list = readFromMySql();
        for(User user:list){
            System.out.println(user.getName()+ " " + user.getId());
        }
        String message = insertToMongoDB(new User("Tanima Chowdhury", 3539));
        List<User> user = readFromMongoDB();
        */

    }

}
