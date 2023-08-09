package day32;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream File = new FileOutputStream("/Users/pushkar/eclipse-workspace/WebDrivermavenproject/testdata/myfile.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();
        
        /*
      //Creating rows, cells and update data without loop
        XSSFRow row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Welcome");
        row1.createCell(1).setCellValue("12345");
        row1.createCell(2).setCellValue("xyz");
        
        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("abc");
        row2.createCell(1).setCellValue("4567");
        row2.createCell(2).setCellValue("testing");
        row2.createCell(3).setCellValue("pushkar");
        */
        
        Scanner sc = new Scanner(System.in);
        for(int r=0;r<=3;r++)
        {
        	XSSFRow current_row = sheet.createRow(r);
        	for(int c=0;c<=3;c++)
        	{
        		//current_row.createCell(c).setCellValue("Welcome");
        		
        		System.out.println("Enter a value");
        		String Value = sc.next();
        		current_row.createCell(c).setCellValue(Value);
        	}
        }
        
        workbook.write(File);
        workbook.close();
        File.close();
        
	}

}
