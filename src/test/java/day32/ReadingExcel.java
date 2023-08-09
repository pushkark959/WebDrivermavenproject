package day32;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		// FileInputStream File = new
		// FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		FileInputStream File = new FileInputStream("/Users/pushkar/eclipse-workspace/WebDrivermavenproject/testdata/data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(File);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int total_rows = sheet.getLastRowNum();
		int total_cells = sheet.getRow(1).getLastCellNum();
		System.out.println("No of rows : " + total_rows); // 5
		System.out.println("No of rows : " + total_cells); // 4

		for (int r = 0; r <= total_rows; r++) {
			XSSFRow currentRow = sheet.getRow(r);
			for (int c = 0; c < total_cells; c++) {
				String value = currentRow.getCell(c).toString();
				System.out.print(value + "   ");
			}
			System.out.println();
		}
		workbook.close();
		File.close();
	}

}
