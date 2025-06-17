package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsx {
	
	
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String fname,String Sheet) throws IOException {
		
		fis=new FileInputStream(fname);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(Sheet);
		int ttlrowCount=sh.getLastRowNum()+1;
//		wb.close();
//		fis.close();
		return ttlrowCount;
	}
public static int getCellCount(String fname,String Sheet) throws IOException {
		
		fis=new FileInputStream(fname);
		wb=new XSSFWorkbook(fis);
		sh=wb.getSheet(Sheet);
		row=sh.getRow(0);
		int ttlCellCount=row.getLastCellNum();
		wb.close();
		fis.close();
		return ttlCellCount;
				
	}

public static String getCellValue(String fname,String Sheet,int Row,int Cell) throws IOException {
	
	fis=new FileInputStream(fname);
	wb=new XSSFWorkbook(fis);
	sh=wb.getSheet(Sheet);
	row=sh.getRow(Row);
	//String cell=sh.getRow(0).getCell(Cell).getStringCellValue();
	cell=row.getCell(Cell);
	
	DataFormatter format=new DataFormatter();
	String value=format.formatCellValue(cell);
	
//	wb.close();
//	fis.close();
	return value;	
}


}
