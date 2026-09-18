package SauceDemo;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

    public static String getCellData(
            String sheetName,
            int rowNumber,
            int columnNumber) {

        String value = "";

        try {

            FileInputStream file =
                    new FileInputStream(
                            "./src/main/resources/DDT/saucedemo.xlsx");

            Workbook workbook =
                    WorkbookFactory.create(file);

            Sheet sheet =
                    workbook.getSheet(sheetName);

            Row row =
                    sheet.getRow(rowNumber);

            DataFormatter formatter =
                    new DataFormatter();

            value = formatter.formatCellValue(
                    row.getCell(columnNumber));

            workbook.close();

            file.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return value;
    }
}
