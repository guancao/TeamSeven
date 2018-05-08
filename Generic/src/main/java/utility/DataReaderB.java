package utility;

import base.CommonAPIb;
import com.google.common.collect.Table;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.*;
import java.util.*;

public class DataReaderB {
    XSSFWorkbook wb = null;
    XSSFSheet sheet = null;
    //    Table.Cell cell = null;
    Cell cell;  //changed from above line, may cause problem  -- Guan
    FileOutputStream fio = null;
    int numberOfRows, numberOfCol, rowNum;

    //2D array
    public String[][] fileReader1(String path) throws IOException {
        String[][] data = {};
        File file = new File(path);
//        FileInputStream fis = new FileInputStream(file);
        InputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        data = new String[numberOfRows + 1][numberOfCol + 1];

        for (int i = 1; i < data.length; i++) {
            XSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                XSSFCell cell = rows.getCell(j);
                String cellData = cell.getStringCellValue();
                data[i][j] = cellData;
            }
        }
        return data;
    }

    @Parameters({"excelPath"})
    public Properties loadExProperties(@Optional(".\\src\\test\\resources\\excel.properties") String excelPath) throws IOException {
        System.out.println("passing parameter -- excelPath" + excelPath);
        Properties prop = new Properties();
        File f = new File(excelPath);
        FileInputStream ism = new FileInputStream(f); //"/Users/peoplentech/develop/automation/Web-Automation-Framework/Generic/databaseinfo/secret.properties");
        prop.load(ism);
        ism.close();
        return prop;
    }

    //1-D array
    public List<String> xlsxFileReaderB() throws IOException {
        Properties prop = loadExProperties(".\\src\\test\\resources\\excel.properties");
        String file_path = prop.getProperty("xlsxFilePath");
        System.out.println("the excel file path is ===" + file_path);
        File file = new File(file_path);
        InputStream fis = new FileInputStream(file);
        List<String> data = new ArrayList<>();
        wb = new XSSFWorkbook(fis);

        sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
//       data = new String[numberOfRows + 1];
        for (int i = 0; i < numberOfRows + 1; i++) {
            XSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                XSSFCell cell = rows.getCell(j);
                String cellData = cell.getStringCellValue();
                data.add(cellData);
            }
        }
        wb.close();
        fis.close();
        return data;
    }

    public List<String> simpleXlsxFileReader(String fPath) throws IOException {
        File file = new File(fPath);
        InputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        numberOfRows = sheet.getLastRowNum();
        numberOfCol = sheet.getRow(0).getLastCellNum();
        List<String> data = new ArrayList<>();
//       data = new String[numberOfRows + 1];
        for (int i = 0; i < numberOfRows + 1; i++) {
            XSSFRow rows = sheet.getRow(i);
            for (int j = 0; j < numberOfCol; j++) {
                XSSFCell cell = rows.getCell(j);
                String cellData = cell.getStringCellValue();
                data.add(cellData);
            }
        }
        wb.close();
        fis.close();
        return data;
    }


    public String getCellValue(HSSFCell cell) {
        Object value = null;

        int dataType = cell.getCellType();
        switch (dataType) {
            case HSSFCell.CELL_TYPE_NUMERIC:
                value = cell.getNumericCellValue();
                break;
            case HSSFCell.CELL_TYPE_STRING:
                value = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                value = cell.getBooleanCellValue();
                break;
        }
        return value.toString();

    }

    public void xlsxFileWriterB(String value) throws IOException {
        File file = new File(".\\data\\writeback.xlsx");
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
        fis.close();
//        sheet = wb.createSheet();
//        Row row = sheet.createRow(rowNum);
//        row.setHeightInPoints(10);
        sheet = wb.getSheetAt(0);
        int rownum = sheet.getLastRowNum();  //attach to the end of the sheet
        XSSFRow row = sheet.createRow(rownum + 1);  // have to create both row and cell
        XSSFCell cell = row.createCell(0);
        cell.setCellValue(value);

        // open an OutputStream to save written data into XLSX file
        FileOutputStream fos = new FileOutputStream(".\\data\\writeback.xlsx");
        wb.write(fos);
        fos.close();
//        fis.close();
        wb.close();

        System.out.println("Writing on XLSX file Finished ...");
    }

    public static void readXLSXFile() throws IOException {
        InputStream ExcelFileToRead = new FileInputStream(new File(".\\data\\ali.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        Iterator rows = sheet.rowIterator();
        while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                cell = (XSSFCell) cells.next();
                if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                    System.out.print(cell.getStringCellValue() + " ");
                } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                    System.out.print(cell.getNumericCellValue() + " ");
                } else {
                    //U Can Handel Boolean, Formula, Errors
                }
            }
            System.out.println();
        }
    }

    public void writeXlsxFile() throws IOException {
        Map<String, Object[]> data = new HashMap<String, Object[]>();
        data.put("7", new Object[]{7d, "Sonya", "75K", "SALES", "Rupert"});
        data.put("8", new Object[]{8d, "Kris", "85K", "SALES", "Rupert"});
        data.put("9", new Object[]{9d, "Dave", "90K", "SALES", "Rupert"});
        // Set to Iterate and add rows into XLS file
        Set<String> newRows = data.keySet();

        File myFile = new File("C://temp/Employee.xlsx");
        FileInputStream fis = new FileInputStream(myFile);
        // Finds the workbook instance for XLSX file
        XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
        XSSFSheet mySheet = myWorkBook.getSheetAt(0);
        // get the last row number to append new data
        int rownum = mySheet.getLastRowNum();
        for (String key : newRows) {
            // Creating a new Row in existing XLSX sheet
            Row row = mySheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String) obj);
                } else if (obj instanceof Boolean) {
                    cell.setCellValue((Boolean) obj);
                } else if (obj instanceof Date) {
                    cell.setCellValue((Date) obj);
                } else if (obj instanceof Double) {
                    cell.setCellValue((Double) obj);
                }
            }
        }
        // open an OutputStream to save written data into XLSX file
        FileOutputStream os = new FileOutputStream(myFile);
        myWorkBook.write(os);
        System.out.println("Writing on XLSX file Finished ...");

    }


}
