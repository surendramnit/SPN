package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	public static FileInputStream fis;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static String path;
	
	
	public ExcelDataProvider() throws Exception 
	{
		try {
	    path=System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\testdata.xlsx";
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public String getExceldata(String sheetname, int row, int cell)
	{
		
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();		
						
	}

	public  int getRowCount(String sheetname) throws Exception
	{
		
		ws=wb.getSheet(sheetname);
		int rowcount=ws.getLastRowNum();
		return rowcount;
	}

	public int getCellCount(String sheetname, int rownum) throws Exception
	{
		
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		return cellcount;
	}
	
	public  String getCellData(String sheetname, int rownum, int cellnum) throws Exception
	{
	
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		cell=row.getCell(cellnum);
		String data;
		try
		{
			DataFormatter formatter=new DataFormatter();
			String cellData=formatter.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data="";
		}
		
		return data;
	}
	
	public void setCellData(String sheetname, int rownum, int cellnum, String data) throws Exception
	{
			
		ws=wb.getSheet(sheetname);
		row=ws.getRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		wb.write(fo);
										
	}
	
	public void setEmptyRowCellData(String sheetname, int rownum, int cellnum, String data) throws Exception
	{
		
		ws=wb.getSheet(sheetname);
		row=ws.createRow(rownum);
		cell=row.createCell(cellnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(path);
		wb.write(fo);
									
	}
	
}