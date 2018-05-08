package database;

//import com.mongodb.MongoClient;
//import com.mongodb.client.MongoDatabase;

import base.CommonAPIb;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectDBb {

//    public static MongoDatabase mongoDatabase = null;

    public static Connection connect = null;
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;

    //  make changes to pass parameter instead of hard code the filepath
    CommonAPIb commonAPI = new CommonAPIb();

    //    public Properties loadProperties() throws IOException{
//    @Parameters({"secretMySqlPath"})
    @Parameters({"mysqlPath"})
    public Properties loadMyProperties(@Optional(".\\src\\test\\resources\\mysql.properties") String mysqlPath) throws IOException {
        Properties prop = new Properties();
        File f=new File(mysqlPath);
        FileInputStream ism = new FileInputStream(f); //"/Users/peoplentech/develop/automation/Web-Automation-Framework/Generic/databaseinfo/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    public Connection connectToMySql() throws IOException, SQLException, ClassNotFoundException {
        //@Optional("E:\\WebAutomationTeamSeven\\Alibaba\\databaseinfo\\secret.properties") String secretPath) throws IOException, SQLException, ClassNotFoundException {
        Properties prop = loadMyProperties(".\\databaseinfo\\secret.properties");
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

    public List<String> readDataBase(String tableName, String columnName) throws Exception {
        List<String> data = new ArrayList<String>();
        try {
            connectToMySql();
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

    public void insertDataFromArrayToMySql(int[] ArrayData, String tableName, String columnName) {
        try {
            connectToMySql();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName +
                    "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
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

    public void insertDataFromArrayToMySql(String[] ArrayData, String tableName, String columnName) {
        try {
            connectToMySql();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName +
                    "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`" + columnName + "` varchar(250) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
            for (int n = 0; n < ArrayData.length; n++) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setString(1, ArrayData[n]);
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

    public void insertDataFromStringToMySql(String ArrayData, String tableName, String columnName) {
        try {
            connectToMySql();
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

    public List<String> directDatabaseQueryExecute(String passQuery, String dataColumn) throws Exception {
        List<String> data = new ArrayList<String>();
        try {
            connectToMySql();
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

    //    @Parameters({"secretPath"})
    public void insertDataFromArrayListToMySql(List<String> list, String tableName, String columnName) {
        try {
            connectToMySql();
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE `" + tableName
                    + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`SortingNumbers` bigint(20) DEFAULT NULL,  PRIMARY KEY (`ID`) );");
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

    //    @Parameters({"secretPath"})
    public void insertProfileToMySql(String tableName, String columnName1, String columnName2) {
        try {
            connectToMySql();
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

    //    @Parameters({"secretPath"})
    public List<String> readFromMySql() throws IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<String>();
        try {
            Connection conn = connectToMySql();
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

//    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
    	/*
        insertProfileToMySql("profile","name", "id");
        List<User> list = readFromMySql();
        for(User user:list){
            System.out.println(user.getName()+ " " + user.getId());
        }
        String message = insertToMongoDB(new User("Tanima Chowdhury", 3539));
        List<User> user = readFromMongoDB();
        */

//    }

}
