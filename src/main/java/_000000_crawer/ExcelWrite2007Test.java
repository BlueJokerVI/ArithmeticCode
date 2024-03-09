package _000000_crawer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * .xlsx方式
 */
public class  ExcelWrite2007Test {


    @Test
    public void test() throws Exception {

        String url = "E:\\ArithmeticCode\\2001new.xlsx";
        String url1 = "E:\\ArithmeticCode\\2001chain.xlsx";

        try (FileInputStream fis = new FileInputStream(url);
            FileInputStream fis1 = new FileInputStream(url1);
             XSSFWorkbook workbook = new XSSFWorkbook(fis);
             XSSFWorkbook workbook1 = new XSSFWorkbook(fis1);
        ) {

            //创建表
            Sheet sheet = workbook.getSheet("Sheet0");
            Sheet sheet1 = workbook1.getSheet("Sheet0");
            //写入数据
            for (int rowNumber = 1; rowNumber < sheet.getLastRowNum(); rowNumber++) {
                Row row = sheet.getRow(rowNumber);
                Row row1 = sheet1.getRow(rowNumber);
                for (int cellNumber = 1; cellNumber < row.getLastCellNum(); cellNumber++) {
                    if(cellNumber==2){
                        continue;
                    }
                    Cell cell = row.getCell(cellNumber);
                    Cell cell1 = row1.getCell(cellNumber);
                    String s = cell.getStringCellValue() + " (" + cell1.getStringCellValue()+")";
                    System.out.println(s);
                    cell.setCellValue(s);
                }
            }

            // Save the changes back to the Excel file
            try (FileOutputStream fos = new FileOutputStream(url)) {
                workbook.write(fos);
                System.out.println("Data appended successfully.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
