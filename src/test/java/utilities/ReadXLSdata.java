package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLSdata {

	@DataProvider(name = "LoginTest")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException {
		// Read the file
		String excelSheetName = m.getName();
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("LoginTest");
		// Read the data
		int totalRows = sheetName.getLastRowNum();
		System.out.println("totalRows" + totalRows);
		Row rowcells = sheetName.getRow(0);
		int totalcols = rowcells.getLastCellNum();
		System.out.println("totalcols" + totalcols);
		// Formatting the data
		DataFormatter format = new DataFormatter();
		// Reading the data
		String testData[][] = new String[totalRows][totalcols];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalcols; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}
		}
		return testData;
	}

	@DataProvider(name = "POTest")
	public String[][] getdata1(Method m) throws EncryptedDocumentException, IOException {
		// Read the file
		String excelSheetName = m.getName();
		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet("POTest");
		// Read the data
		int totalRows = sheetName.getLastRowNum();
		// System.out.println("totalRows" + totalRows);
		Row rowcells = sheetName.getRow(0);
		int totalcols = rowcells.getLastCellNum();
		// System.out.println("totalcols" + totalcols);
		// Formatting the data
		DataFormatter format = new DataFormatter();
		// Reading the data
		String testData[][] = new String[totalRows][totalcols];
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalcols; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				// System.out.println(testData[i - 1][j]);
			}
		}
		return testData;
	}
}
