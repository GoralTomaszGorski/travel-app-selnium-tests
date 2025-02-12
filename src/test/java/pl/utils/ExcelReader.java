package pl.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    public static void readExcel(String fileName) throws IOException {
        File file = new File("src/test/resources/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;
        String fileExt = fileName.substring(fileName.indexOf("."));
        if (fileExt.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExt.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }

    }
}
